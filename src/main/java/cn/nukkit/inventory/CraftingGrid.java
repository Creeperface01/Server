package cn.nukkit.inventory;

import cn.nukkit.player.Player;

/**
 * author: MagicDroidX
 * Nukkit Project
 */
public class CraftingGrid extends PlayerUIComponent {

    CraftingGrid(Player player) {
        this(player, 28, 4);
    }

    CraftingGrid(Player player, int offset, int size) {
        super(player, offset, size);
    }
}
