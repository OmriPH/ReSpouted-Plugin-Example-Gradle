package com.example;

import org.bukkit.World;
import org.getspout.spoutapi.block.design.GenericCubeBlockDesign;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.material.block.GenericCustomBlock;
import org.getspout.spoutapi.player.SpoutPlayer;

import static com.example.Main.plugin;

public class ExampleBlock extends GenericCustomBlock {
    public ExampleBlock() {
        // Plugin instance, Block ID, is opaque
        // GenericCubeBlockDesign takes Plugin instance, url to PNG texture, texture size
        super(plugin, "exampleblock", true, new GenericCubeBlockDesign(plugin, "https://i.ibb.co/YWs9T00/sugar-cane-block.png", 16));
        setName("Example Block"); // Set block name
    }

    // Run code when the block is interacted with!
    @Override
    public boolean onBlockInteract(World world, int x, int y, int z, SpoutPlayer player) {
        if (!player.isSpoutCraftEnabled()) return false; // Only interact if Spout player (Spout can allow vanilla clients to join)

        player.getInventory().addItem(new SpoutItemStack(plugin.EXAMPLE_BLOCK)); // Give player a Spout block
        player.updateInventory(); // Update the player's inventory (temporary fix)
        return true;
    }
}
