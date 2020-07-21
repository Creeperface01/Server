package cn.nukkit.inventory;

import cn.nukkit.Server;
import cn.nukkit.player.Player;
import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.data.inventory.ContainerId;
import com.nukkitx.protocol.bedrock.packet.InventorySlotPacket;

import java.util.HashMap;

public class PlayerUIComponent extends BaseInventory {

    private final int offset;
    private final int size;

    PlayerUIComponent(Player player, int offset, int size) {
        super(player, InventoryType.UI, new HashMap<>(), size);
        this.offset = offset;
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }

    public int getOffset() {
        return offset;
    }

    @Override
    public int getMaxStackSize() {
        return 64;
    }

    @Override
    public void setMaxStackSize(int size) {
        throw new UnsupportedOperationException();
    }


    @Override
    public String getTitle() {
        throw new UnsupportedOperationException();
    }


    @Override
    public void sendContents(Player... players) {
        BedrockPacket[] packets = new BedrockPacket[size];

        for (int i = 0; i < size; i++) {
            InventorySlotPacket pk = new InventorySlotPacket();
            pk.setContainerId(ContainerId.UI);
            pk.setSlot(i + offset);
            pk.setItem(getItem(i).toNetwork());

            packets[i] = pk;
        }

        Server.broadcastPackets(players, packets);
    }

    @Override
    public void sendSlot(int index, Player... players) {
        InventorySlotPacket pk = new InventorySlotPacket();
        pk.setContainerId(ContainerId.UI);
        pk.setSlot(index + offset);
        pk.setItem(getItem(index).toNetwork());

        Server.broadcastPackets(players, new BedrockPacket[]{pk});
    }

    @Override
    public void onOpen(Player who) {

    }

    @Override
    public boolean open(Player who) {
        return false;
    }

    @Override
    public void close(Player who) {

    }

    @Override
    public void onClose(Player who) {

    }
}
