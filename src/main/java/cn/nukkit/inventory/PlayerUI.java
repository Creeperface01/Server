package cn.nukkit.inventory;

import cn.nukkit.network.protocol.types.ContainerIds;
import cn.nukkit.player.Player;
import it.unimi.dsi.fastutil.ints.Int2IntMap;
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;

import javax.annotation.Nullable;

public class PlayerUI {

    //internal container IDs
    public static final byte CRAFTING_GRID_ID = -1;
    public static final byte BIG_CRAFTING_GRID_ID = -2;
    public static final byte CURSOR_ID = -3;

    private static final Int2IntMap SLOT_MAPPING = new Int2IntOpenHashMap();

    private final Player player;

    private final PlayerCursorInventory cursorInventory;
    private final CraftingGrid craftingGrid;
    private final BigCraftingGrid bigCraftingGrid;

    public PlayerUI(Player player) {
        this.player = player;

        this.cursorInventory = new PlayerCursorInventory(player);
        this.craftingGrid = new CraftingGrid(player);
        this.bigCraftingGrid = new BigCraftingGrid(player);
    }

    public static void init() {
        SLOT_MAPPING.put(0, CURSOR_ID);

        SLOT_MAPPING.put(1, ContainerIds.ANVIL);
        SLOT_MAPPING.put(2, ContainerIds.ANVIL);
        SLOT_MAPPING.put(3, ContainerIds.ANVIL);

        SLOT_MAPPING.put(14, ContainerIds.ENCHANTING_TABLE);
        SLOT_MAPPING.put(15, ContainerIds.ENCHANTING_TABLE);

        SLOT_MAPPING.put(27, ContainerIds.BEACON);

        for (int i = 28; i < 32; i++) {
            SLOT_MAPPING.put(i, CRAFTING_GRID_ID);
        }

        for (int i = 32; i < 41; i++) {
            SLOT_MAPPING.put(i, BIG_CRAFTING_GRID_ID);
        }
    }

    public void addDefaultWindows() {
        this.player.addWindow(this.craftingGrid, CRAFTING_GRID_ID, true);
        this.player.addWindow(this.cursorInventory, CURSOR_ID, true);
    }

    public PlayerCursorInventory getCursorInventory() {
        return cursorInventory;
    }

    public CraftingGrid getCraftingGrid() {
        return craftingGrid;
    }

    public BigCraftingGrid getBigCraftingGrid() {
        return bigCraftingGrid;
    }

    @Nullable
    public Inventory getBySlot(int slot) {
        return player.getWindowById(SLOT_MAPPING.get(slot));
    }
}
