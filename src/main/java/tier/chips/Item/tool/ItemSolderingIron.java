package tier.chips.Item.tool;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.item.IElectricItem;
import ic2.core.init.InternalName;
import ic2.core.item.BaseElectricItem;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class ItemSolderingIron extends ItemTool implements IElectricItem {

    private double maxCharge = 10000;
    private double transferLimit = 32;
    private int tier = 1;

    public ItemSolderingIron() {
        super(1, ToolMaterial.IRON, null);
        this.setCreativeTab(CreativeTabs.tabMaterials);
        this.setTextureName("tierchip:soldertool");
        this.setMaxStackSize(1);
    }

    //dsadassdadaasd
    public boolean canProvideEnergy(ItemStack itemStack)
    {
        return false;
    }

    @Override
    public Item getChargedItem(ItemStack itemStack)
    {
        return this;
    }

    @Override
    public Item getEmptyItem(ItemStack itemStack)
    {
        return this;
    }

    @Override
    public double getMaxCharge(ItemStack itemStack)
    {
        return this.maxCharge;
    }

    @Override
    public int getTier(ItemStack itemStack)
    {
        return this.tier;
    }

    @Override
    public double getTransferLimit(ItemStack itemStack)
    {
        return this.transferLimit;
    }

    @Override
    public boolean isRepairable()
    {
        return false;
    }

    @Override
    public int getItemEnchantability()
    {
        return 0;
    }

//    @Override
//    @SideOnly(Side.CLIENT)
//    public void registerIcons(IIconRegister par1IconRegister)
//    {
//        this.itemIcon = par1IconRegister.registerIcon("gravisuite:itemRelocator");
//    }
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
