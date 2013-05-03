package skydimension;

import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabsSky extends CreativeTabs {

	public CreativeTabsSky() {
		super(SkyDimension.modID);
	}

	@Override
	public String getTranslatedTabLabel() {
		return SkyDimension.modID;
	}

}
