package skydimension;

import java.util.ArrayList;
import java.util.Iterator;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityCloud extends Entity {

	public int blockID;
	public int metadata;

	/** How long the block has been falling for. */
	public int fallTime;
	public boolean shouldDropItem;

	/** Maximum amount of damage dealt to entities hit by falling block */
	private int fallHurtMax;

	/** Actual damage dealt to entities hit by falling block */
	private float fallHurtAmount;
	public NBTTagCompound fallingBlockTileEntityData;

	public EntityCloud(World par1World) {
		super(par1World);
		this.fallTime = 0;
		this.shouldDropItem = true;
		this.fallHurtMax = 40;
		this.fallHurtAmount = 2.0F;
		this.fallingBlockTileEntityData = null;
	}

	public EntityCloud(World par1World, double par2, double par4, double par6, int par8) {
		this(par1World, par2, par4, par6, par8, 0);
	}

	public EntityCloud(World par1World, double par2, double par4, double par6, int par8, int par9) {
		super(par1World);
		this.fallTime = 0;
		this.shouldDropItem = true;
		this.fallHurtMax = 40;
		this.fallHurtAmount = 2.0F;
		this.fallingBlockTileEntityData = null;
		this.blockID = par8;
		this.metadata = par9;
		this.preventEntitySpawning = true;
		this.setSize(0.98F, 0.98F);
		this.yOffset = this.height / 2.0F;
		this.setPosition(par2, par4, par6);
		this.motionX = 0.0D;
		this.motionY = 0.0D;
		this.motionZ = 0.0D;
		this.prevPosX = par2;
		this.prevPosY = par4;
		this.prevPosZ = par6;
	}

	@Override
	protected boolean canTriggerWalking() {
		return false;
	}

	@Override
	protected void entityInit() {
	}

	@Override
	public boolean canBeCollidedWith() {
		return !this.isDead;
	}

	@Override
	public void onUpdate() {
		if (this.blockID == 0) {
			this.setDead();
		} else {
			this.prevPosX = this.posX;
			this.prevPosY = this.posY;
			this.prevPosZ = this.posZ;
			++this.fallTime;
			this.motionY -= 0.04D;
			this.moveEntity(this.motionX, this.motionY, this.motionZ);
			this.motionX *= 0.98D;
			this.motionY *= 0.98D;
			this.motionZ *= 0.98D;

			if (!this.worldObj.isRemote) {
				int i = MathHelper.floor_double(this.posX);
				int j = MathHelper.floor_double(this.posY);
				int k = MathHelper.floor_double(this.posZ);

				if (this.fallTime == 1) {
					if (this.worldObj.getBlockId(i, j, k) != this.blockID) {
						this.setDead();
						return;
					}

					this.worldObj.setBlockToAir(i, j, k);
				}

				if (this.onGround) {
					this.motionX *= 0.7D;
					this.motionZ *= 0.7D;
					this.motionY *= -0.5D;

					if (this.worldObj.getBlockId(i, j, k) != Block.pistonMoving.blockID) {
						this.setDead();

						if (this.worldObj.canPlaceEntityOnSide(this.blockID, i, j, k, true, 1, (Entity) null, (ItemStack) null) && !BlockSand.canFallBelow(this.worldObj, i, j - 1, k) && this.worldObj.setBlock(i, j, k, this.blockID, this.metadata, 3)) {
							if (Block.blocksList[this.blockID] instanceof BlockSand) {
								((BlockSand) Block.blocksList[this.blockID]).onFinishFalling(this.worldObj, i, j, k, this.metadata);
							}

							if (this.fallingBlockTileEntityData != null && Block.blocksList[this.blockID] instanceof ITileEntityProvider) {
								TileEntity tileentity = this.worldObj.getBlockTileEntity(i, j, k);

								if (tileentity != null) {
									NBTTagCompound nbttagcompound = new NBTTagCompound();
									tileentity.writeToNBT(nbttagcompound);
									Iterator iterator = this.fallingBlockTileEntityData.getTags().iterator();

									while (iterator.hasNext()) {
										NBTBase nbtbase = (NBTBase) iterator.next();

										if (!nbtbase.getName().equals("x") && !nbtbase.getName().equals("y") && !nbtbase.getName().equals("z")) {
											nbttagcompound.setTag(nbtbase.getName(), nbtbase.copy());
										}
									}

									tileentity.readFromNBT(nbttagcompound);
									tileentity.onInventoryChanged();
								}
							}
						} else if (this.shouldDropItem) {
							this.entityDropItem(new ItemStack(this.blockID, 1, Block.blocksList[this.blockID].damageDropped(this.metadata)), 0.0F);
						}
					}
				} else if (this.fallTime > 100 && !this.worldObj.isRemote && (j < 1 || j > 256) || this.fallTime > 600) {
					if (this.shouldDropItem) {
						this.entityDropItem(new ItemStack(this.blockID, 1, Block.blocksList[this.blockID].damageDropped(this.metadata)), 0.0F);
					}

					this.setDead();
				}
			}
		}
	}

	@Override
	protected void fall(float par1) {
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		par1NBTTagCompound.setByte("Tile", (byte) this.blockID);
		par1NBTTagCompound.setInteger("TileID", this.blockID);
		par1NBTTagCompound.setByte("Data", (byte) this.metadata);
		par1NBTTagCompound.setByte("Time", (byte) this.fallTime);
		par1NBTTagCompound.setBoolean("DropItem", this.shouldDropItem);
		par1NBTTagCompound.setBoolean("HurtEntities", false);
		par1NBTTagCompound.setFloat("FallHurtAmount", this.fallHurtAmount);
		par1NBTTagCompound.setInteger("FallHurtMax", this.fallHurtMax);

		if (this.fallingBlockTileEntityData != null) {
			par1NBTTagCompound.setCompoundTag("TileEntityData", this.fallingBlockTileEntityData);
		}
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
		if (par1NBTTagCompound.hasKey("TileID")) {
			this.blockID = par1NBTTagCompound.getInteger("TileID");
		} else {
			this.blockID = par1NBTTagCompound.getByte("Tile") & 255;
		}

		this.metadata = par1NBTTagCompound.getByte("Data") & 255;
		this.fallTime = par1NBTTagCompound.getByte("Time") & 255;

		if (par1NBTTagCompound.hasKey("HurtEntities")) {
			this.fallHurtAmount = par1NBTTagCompound.getFloat("FallHurtAmount");
			this.fallHurtMax = par1NBTTagCompound.getInteger("FallHurtMax");
		}
		if (par1NBTTagCompound.hasKey("DropItem")) {
			this.shouldDropItem = par1NBTTagCompound.getBoolean("DropItem");
		}

		if (par1NBTTagCompound.hasKey("TileEntityData")) {
			this.fallingBlockTileEntityData = par1NBTTagCompound.getCompoundTag("TileEntityData");
		}

		if (this.blockID == 0) {
			this.blockID = Block.sand.blockID;
		}
	}

	@Override
	public void func_85029_a(CrashReportCategory par1CrashReportCategory) {
		super.func_85029_a(par1CrashReportCategory);
		par1CrashReportCategory.addCrashSection("Immitating block ID", Integer.valueOf(this.blockID));
		par1CrashReportCategory.addCrashSection("Immitating block data", Integer.valueOf(this.metadata));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public float getShadowSize() {
		return 0.0F;
	}

	@SideOnly(Side.CLIENT)
	public World getWorld() {
		return this.worldObj;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public boolean canRenderOnFire() {
		return false;
	}
}
