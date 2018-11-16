package tier.chips;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import ic2.api.item.IC2Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import tier.chips.Items.*;
import tier.chips.proxy.CommonProxy;

@Mod(modid = tierchips.MODID, name = tierchips.NAME, version = tierchips.VERSION)
public class tierchips
{
    public static final String MODID = "tierChips";
    public static final String NAME = "Tier Chips";
    public static final String VERSION = "1.0.1";

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
        tier1chip = new Tierchip().setUnlocalizedName("tier1Chip").setTextureName("tierchip:Tir1");;
        tier2chip = new Tierchip().setUnlocalizedName("tier2Chip").setTextureName("tierchip:Tir2");;
        tier3chip = new Tierchip().setUnlocalizedName("tier3Chip").setTextureName("tierchip:Tir3");;
        tier4chip = new Tierchip().setUnlocalizedName("tier4Chip").setTextureName("tierchip:Tir4");;
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

        if (Loader.isModLoaded("IC2")) {

            try {

                //Tier 1 Chip Recipe addition
                GameRegistry.addRecipe(new ItemStack(tier1chip, 1),
                        "###",
                        "XYX",
                        "###",
                        ('X'), IC2Items.getItem("bronzeBlock"), ('#'), IC2Items.getItem("bronzeBlock"), ('Y'), IC2Items.getItem("bronzeBlock"));

            } catch (Exception e){

                System.out.println("Error during initialization IC2 compatible recipes");

                e.printStackTrace(System.err);

            }
        } else System.out.println("It's seems that there is no IC2 mod available. Ignoring IC2 recipes");
    
        
    }
}
