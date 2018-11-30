package tier.chips.Item.tool;

import cpw.mods.fml.relauncher.Side;
import net.minecraft.client.Minecraft;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;
import ic2.api.item.IItemHudInfo;
import ic2.core.IC2;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import tier.chips.Item.Tierchip;

import java.util.LinkedList;
import java.util.List;

public class ItemSolderingIron extends ItemSword implements IElectricItem /*,IItemHudInfo*/ {

    private double maxCharge = 10000;
    private double transferLimit = 32;
    private int tier = 1;
    protected IIcon[] textures ;
    public static String Ful = "Empty";

    public ItemSolderingIron() {
        super(ToolMaterial.WOOD);
        this.setCreativeTab(CreativeTabs.tabMaterials);
        this.setTextureName("tierchip:soldertool");
        this.setMaxStackSize(1);
        this.setMaxDamage(1000);
        this.setUnlocalizedName("solderingtool");


    }


    //dsadassdadaasd
    public boolean canProvideEnergy(ItemStack itemStack) {
        return false;
    }

    @Override
    public Item getChargedItem(ItemStack itemStack) {
        setIconDur(itemStack.getItemDamage());
        return this;
    }


    @Override
    public void onUpdate(ItemStack p_77663_1_, World p_77663_2_, Entity p_77663_3_, int p_77663_4_, boolean p_77663_5_) {
        setIconDur(p_77663_1_.getItemDamage());
    }

    @Override
    public Item getEmptyItem(ItemStack itemStack) {
        return this;
    }

    @Override
    public double getMaxCharge(ItemStack itemStack) {
        return this.maxCharge;
    }

    @Override
    public int getTier(ItemStack itemStack) {
        return this.tier;
    }

    @Override
    public double getTransferLimit(ItemStack itemStack) {
        return this.transferLimit;
    }

    @Override
    public boolean isRepairable() {
        return false;
    }

    @Override
    public int getItemEnchantability() {
        return 0;
    }
/*
    public double getCharge(ItemStack itemStack) {
        return ElectricItem.manager.discharge(itemStack, 1.0D / 0.0, 2147483647, true, false, true);
    }*/
/*
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister) {
        //ItemStack SolderTool = new ItemStack(this);

        textures[3] = par1IconRegister.registerIcon("tierchip:.solderingtool.0");
        //textures[4] = par1IconRegister.registerIcon("tierchip:soldertoolg");
    }*/




    public String getTextureName(int index) {
        return index < 3?this.getUnlocalizedName().substring(4) + "." + index:null;
    }

    public String getTextureFolder() {
        return null;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        int indexCount = 0;
        this.itemIcon = iconRegister.registerIcon("tierchip:.solderingtool.2");

        while(this.getTextureName(indexCount) != null) {
            ++indexCount;
            if(indexCount > 32767) {
                throw new RuntimeException("More Item Icons than actually possible @ " + this.getUnlocalizedName());
            }
        }

        this.textures = new IIcon[indexCount];
        String textureFolder = this.getTextureFolder() == null?"":this.getTextureFolder() + "/";

        for(int index = 0; index < indexCount; ++index) {
            this.textures[index] = iconRegister.registerIcon("Tierchip:" + textureFolder + this.getTextureName(index));
        }

    }

    @SideOnly(Side.CLIENT)
    public void setIconDur(int durability) {
        //return meta <= 1?this.textures[0]:(meta > 1?this.textures[2]:this.textures[3 - 3 * (meta - 2) / (this.getMaxDamage() - 4 + 1)]);
        if(durability>=666)
            this.itemIcon = this.textures[0];
        else if((durability<666)&&(durability>333))
            this.itemIcon = this.textures[1];
        else
            this.itemIcon = this.textures[2];
    }

    /*public static String getFul(ItemSolderingIron itemSolderingiron) {
        return Ful;
    }
    @SideOnly(Side.CLIENT)
    public static int getDam(ItemStack itemStack) {
        return itemStack.getItemDamage();
    }

    @SideOnly(Side.CLIENT)
    public static void ITest(ItemStack itm,Item some) {
        if (ElectricItem.manager.getCharge(itm) >= 1) {

            Ful = "Soldering Tool Full";
        } else {
            Ful = "Soldering Tool Not Full";
        }
    }

    @Override
    public List<String> getHudInfo(ItemStack itemStack) {
        List<String> info = new LinkedList<String>();
        info.add("i am a Cool Item");
        info.add("and have Cool info");
        return info;
    }*/

    /*

    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs par2CreativeTabs, List itemList) {
        ItemStack itemStack = new ItemStack(this, 1);
        ItemStack charged;
        if(this.getChargedItem(itemStack) == this) {
            charged = new ItemStack(this, 1);
            ElectricItem.manager.charge(charged, 1.0D / 0.0, 2147483647, true, false);
            itemList.add(charged);
            Ful="Full";

        }

        if(this.getEmptyItem(itemStack) == this) {
            charged = new ItemStack(this, 1);
            ElectricItem.manager.charge(charged, 0.0D, 2147483647, true, false);
            itemList.add(charged);
            Ful="Empty";
        }

    }*/





}

//public class ItemBattery
//        /*     */   extends BaseElectricItem
//        /*     */ {
//    /*     */   public ItemBattery(InternalName internalName, double maxCharge, double transferLimit, int tier)
//    /*     */   {
//        /*  37 */     super(internalName, maxCharge, transferLimit, tier);
//        /*     */   }
//    /*     */
//    /*     */
//    /*     */   public String getTextureName(int index)
//    /*     */   {
//        /*  43 */     if (index < 5) return func_77658_a().substring(4) + "." + index;
//        /*  44 */     return null;
//        /*     */   }
//    /*     */
//    /*     */   @SideOnly(Side.CLIENT)
//    /*     */   public IIcon func_77617_a(int meta)
//    /*     */   {
//        /*  50 */     if (meta <= 1) return this.textures[4];
//        /*  51 */     if (meta >= func_77612_l() - 1) { return this.textures[0];
//            /*     */     }
//        /*  53 */     return this.textures[(3 - 3 * (meta - 2) / (func_77612_l() - 4 + 1))];
//        /*     */   }
//    /*     */
//    /*     */   public boolean canProvideEnergy(ItemStack itemStack)
//    /*     */   {
//        /*  58 */     return true;
//        /*     */   }
//    /*     */
//    /*     */   public Item getEmptyItem(ItemStack itemStack)
//    /*     */   {
//        /*  63 */     if (this == Ic2Items.chargedReBattery.func_77973_b()) {
//            /*  64 */       return Ic2Items.reBattery.func_77973_b();
//            /*     */     }
//        /*     */
//        /*  67 */     return super.getEmptyItem(itemStack);
//        /*     */   }
//    /*     */
//    /*     */
//    /*     */
//    /*     */
//    /*     */
//    /*     */   public ItemStack func_77659_a(ItemStack itemStack, World world, EntityPlayer entityplayer)
//    /*     */   {
//        /*  76 */     if ((IC2.platform.isSimulating()) && (itemStack.func_77973_b() == Ic2Items.chargedReBattery.func_77973_b())) {
//            /*  77 */       boolean transferred = false;
//            /*     */
//            /*  79 */       for (int i = 0; i < 9; i++) {
//                /*  80 */         ItemStack stack = entityplayer.field_71071_by.field_70462_a[i];
//                /*     */
//                /*  82 */         if ((stack != null) && (!(stack.func_77973_b() instanceof ItemBattery)))
//                    /*     */         {
//                    /*  84 */           double transfer = ElectricItem.manager.discharge(itemStack, 2.0D * this.transferLimit, Integer.MAX_VALUE, true, true, true);
//                    /*  85 */           if (transfer > 0.0D)
//                        /*     */           {
//                        /*     */
//                        /*  88 */             transfer = ElectricItem.manager.charge(stack, transfer, this.tier, true, false);
//                        /*  89 */             if (transfer > 0.0D)
//                            /*     */             {
//                            /*     */
//                            /*  92 */               ElectricItem.manager.discharge(itemStack, transfer, Integer.MAX_VALUE, true, true, false);
//                            /*  93 */               transferred = true;
//                            /*     */             }
//                        /*     */           }
//                    /*     */         } }
//            /*  97 */       if ((transferred) && (!IC2.platform.isRendering())) {
//                /*  98 */         entityplayer.field_71070_bA.func_75142_b();
//                /*     */       }
//            /*     */     }
//        /*     */
//        /*     */
//        /*     */
//        /* 104 */     return itemStack;
//        /*     */   }
//    /*     */ }
