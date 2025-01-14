package com.example;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.inventory.SpoutShapedRecipe;
import org.getspout.spoutapi.inventory.SpoutShapelessRecipe;
import org.getspout.spoutapi.material.MaterialData;

public class Main extends JavaPlugin {
    public static Main plugin;

    public ExampleItem EXAMPLE_ITEM;
    public ExampleBlock EXAMPLE_BLOCK;
    public ExampleFood EXAMPLE_FOOD;

    @Override
    public void onEnable() {
        plugin = this;
        // The items & blocks need to be initialised somewhere. Add as a variable to this class so it can be referenced to add to inventories
        EXAMPLE_ITEM = new ExampleItem();
        EXAMPLE_BLOCK = new ExampleBlock();
        EXAMPLE_FOOD = new ExampleFood();

        // Basic 2x2 shaped recipe
        SpoutManager.getMaterialManager().registerSpoutRecipe((
                new SpoutShapedRecipe(new SpoutItemStack(EXAMPLE_BLOCK, 1)))
                .shape("ss", "ss")
                .setIngredient('s', MaterialData.sugarCane));
        // Shapeless recipe
        SpoutManager.getMaterialManager().registerSpoutRecipe((
                new SpoutShapelessRecipe(new ItemStack(Material.SUGAR_CANE, 4)))
                .addIngredient(1, EXAMPLE_BLOCK));
    }
}
