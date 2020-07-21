package cn.nukkit.inventory;

import cn.nukkit.player.Player;

/**
 * @author CreeperFace
 */
public class PlayerCursorInventory extends PlayerUIComponent {

    private final Player player;

    PlayerCursorInventory(Player player) {
        super(player, 0, 1);
        this.player = player;
    }

    /**
     * This override is here for documentation and code completion purposes only.
     *
     * @return Player
     */
    @Override
    public Player getHolder() {
        return player;
    }
}
