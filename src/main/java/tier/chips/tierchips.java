package tier.chips;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;
import tier.chips.Items.*;
import tier.chips.proxy.CommonProxy;

@Mod(modid = tierchips.MODID, name = tierchips.NAME, version = tierchips.VERSION)
public class tierchips
{
    public static final String MODID = "tierChips";
    public static final String NAME = "Tier Chips";
    public static final String VERSION = "1.0.0";

    @SidedProxy(clientSide = "tier.chips.proxy.ClientProxy", serverSide = "tier.chips.proxy.CommonProxy")
    public static CommonProxy proxy;

    public static Item tier1chip;
    public static Item tier2chip;
    public static Item tier3chip;
    public static Item tier4chip;
    public static Item solderingtool;
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
        tier1chip = new Tier1chip().setUnlocalizedName("tier1Chip");
        tier2chip = new Tier2chip().setUnlocalizedName("tier2Chip");
        tier3chip = new Tier3chip().setUnlocalizedName("tier3Chip");
        tier4chip = new Tier4chip().setUnlocalizedName("tier4Chip");
        solderingtool = new soldertool().setUnlocalizedName("solderingtool");
        GameRegistry.registerItem(tier1chip, "tier1chip");
        GameRegistry.registerItem(tier2chip, "tier2chip");
        GameRegistry.registerItem(tier3chip, "tier3chip");
        GameRegistry.registerItem(tier4chip, "tier4chip");
        GameRegistry.registerItem(solderingtool, "solderingtool");
    }
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
        LanguageRegistry.addName(tier1chip, "Tier 1 Chip");
        LanguageRegistry.addName(tier2chip, "Tier 2 Chip");
        LanguageRegistry.addName(tier3chip, "Tier 3 Chip");
        LanguageRegistry.addName(tier4chip, "Tier 4 Chip");
        LanguageRegistry.addName(solderingtool, "Soldering Tool");

    }
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);

    }
}
