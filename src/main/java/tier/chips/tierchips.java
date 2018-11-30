package tier.chips;

import com.sun.xml.internal.bind.v2.model.core.RegistryInfo;
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
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.Recipes;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import tier.chips.Item.*;
import tier.chips.Item.tool.ItemSolderingIron;
import tier.chips.proxy.CommonProxy;

@Mod(modid = tierchips.MODID, name = tierchips.NAME, version = tierchips.VERSION, dependencies = "required-after:IC2;")
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
    public static Item tier3IC2;
    public static Item solderingtool;
    public static Item redtstonePlate;


    ItemStack SolderTool = new ItemStack(solderingtool);

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);

        tier1chip = new Tierchip().setUnlocalizedName("tier1Chip").setTextureName("tierchip:Tir1");
        tier2chip = new Tierchip().setUnlocalizedName("tier2Chip").setTextureName("tierchip:Tir2");
        tier3chip = new Tierchip().setUnlocalizedName("tier3Chip").setTextureName("tierchip:Tir3");
        tier4chip = new Tierchip().setUnlocalizedName("tier4Chip").setTextureName("tierchip:Tir4");
        tier3IC2 = new IC2chip().setUnlocalizedName("tier3IC2").setTextureName("tierchip:Tier3IC2");
        solderingtool = new ItemSolderingIron();
        redtstonePlate = new Item().setUnlocalizedName("PlateRedstone").setTextureName("tierchip:redstonePlate").setCreativeTab(CreativeTabs.tabMaterials);

        GameRegistry.registerItem(tier1chip, "tier1chip");
        GameRegistry.registerItem(tier2chip, "tier2chip");
        GameRegistry.registerItem(tier3chip, "tier3chip");
        GameRegistry.registerItem(tier4chip, "tier4chip");
        GameRegistry.registerItem(tier3IC2, "tier3IC2");
        GameRegistry.registerItem(redtstonePlate, "restonePlate");

        //ItemStack SolderTool = new ItemStack(solderingtool);
    }
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
        LanguageRegistry.addName(tier1chip, "Tier 1 Chip");
        LanguageRegistry.addName(tier2chip, "Tier 2 Chip");
        LanguageRegistry.addName(tier3chip, "Tier 3 Chip");
        LanguageRegistry.addName(tier4chip, "Tier 4 Chip");



    }
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);


        if (Loader.isModLoaded("IC2")) {

            try {

                //Tier 1 Chip Recipe addition
                GameRegistry.addRecipe(new ItemStack(solderingtool, 1),
                        "###",
                        " Y ",
                        "#X#",
                        ('X'), IC2Items.getItem("bronzeBlock"), ('#'), IC2Items.getItem("bronzeBlock"), ('Y'), IC2Items.getItem("bronzeBlock"));
                GameRegistry.registerItem(solderingtool, "solderingtool");
                /*ItemStack Sod = new ItemStack(solderingtool);
                if (Sod.getItemDamageForDisplay()==250-1) {
                    LanguageRegistry.addName(solderingtool, "Soldering Tool(Full)");
                }
                else if (Sod.getItemDamageForDisplay()==0){
                    LanguageRegistry.addName(solderingtool, "Soldering Tool(Empty)");
                }
                else
                {
                    LanguageRegistry.addName(solderingtool, "Soldering Tool(Not Full)");
                }*/



                Recipes.compressor.addRecipe(new RecipeInputItemStack(new ItemStack(Items.redstone), 9), null, new ItemStack(redtstonePlate));
                Recipes.compressor.addRecipe(new RecipeInputItemStack(new ItemStack(Blocks.redstone_block), 1), null, new ItemStack(redtstonePlate));




                LanguageRegistry.addName(solderingtool, "Soldering Tool");
                LanguageRegistry.addName(redtstonePlate, "Plate Redstone");
                LanguageRegistry.addName(tier3IC2, "Quantum Circuit");



            } catch (Exception e){

                System.out.println("Error during initialization IC2 compatible recipes");

                e.printStackTrace(System.err);

            }

        }
        else
        {
            System.out.println("It's seems that there is no IC2 mod available. Ignoring IC2 recipes");
        }
    
        
    }
}
