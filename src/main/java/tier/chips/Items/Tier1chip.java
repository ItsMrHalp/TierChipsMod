package tier.chips.Items;

import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Tier1chip extends Item {

    public Tier1chip()
    {
        this.setCreativeTab(CreativeTabs.tabMaterials);
        this.setTextureName("tierchip:Tir1");
    }
}
