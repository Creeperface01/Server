package cn.nukkit.inventory;

import cn.nukkit.player.Player;

/**
 * @author CreeperFace
 */
public class BigCraftingGrid extends CraftingGrid {
    BigCraftingGrid(Player player) {
        super(player, 32, 9);
    }
}
