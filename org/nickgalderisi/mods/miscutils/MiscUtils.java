package org.nickgalderisi.mods.miscutils;
import cpw.mods.fml.common.Mod;
//import cpw.mods.fml.common.Mod.EventHandler; // used in 1.6.2
import cpw.mods.fml.common.Mod.PreInit;    // used in 1.5.2 and below
import cpw.mods.fml.common.Mod.Init;       // used in 1.5.2 and below
import cpw.mods.fml.common.Mod.PostInit;   // used in 1.5.2 and below
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid="MiscUtils", name="Miscellaneous Utilities", version="0.0.1 Pre Alpha")
@NetworkMod(clientSideRequired=true)
public class MiscUtils {
	
	// The instance of your mod that Forge uses.
    @Instance(value = "MiscUtilsID")
    public static MiscUtils instance;
   
    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide="org.nickgalderisi.mods.miscutils.client.ClientProxy", serverSide="org.nickgalderisi.mods.miscutils.CommonProxy")
    public static CommonProxy proxy;
   
    //@EventHandler // used in 1.6.2
    @PreInit    // used in 1.5.2 and below
    public void preInit(FMLPreInitializationEvent event) {
            // Stub Method
    }
   
    //@EventHandler // used in 1.6.2
    @Init       // used in 1.5.2 and below
    public void load(FMLInitializationEvent event) {
            proxy.registerRenderers();
            
            ItemStack emeraldStack = new ItemStack(Item.emerald);
            ItemStack diamondStack = new ItemStack(Item.diamond);
            
            GameRegistry.addSmelting(diamondStack.itemID, emeraldStack, 1.0F);
            GameRegistry.addShapedRecipe(new ItemStack(Block.slowSand, 3), new Object[] {"###", "XXX", "###", '#', Item.bone, 'X', Block.sand});
            GameRegistry.addShapedRecipe(new ItemStack(Block.slowSand, 3), new Object[] {"#X#", "#X#", "#X#", '#', Item.bone, 'X', Block.sand});
            GameRegistry.addShapedRecipe(new ItemStack(Block.netherrack, 8), new Object[] {"SSS", "SLS", "SSS", 'S', Block.cobblestone, 'L', Item.bucketLava});
            GameRegistry.addSmelting(new ItemStack(Block.netherrack).itemID, new ItemStack(Block.netherBrick), 0.5F);
    }
   
    //@EventHandler // used in 1.6.2
    @PostInit   // used in 1.5.2 and below
    public void postInit(FMLPostInitializationEvent event) {
           System.out.println("Miscutils has succesfully loaded!");
}
}