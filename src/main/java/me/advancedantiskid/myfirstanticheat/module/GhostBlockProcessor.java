package me.advancedantiskid.myfirstanticheat.module;

import net.minecraft.server.v1_8_R3.Block;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.WorldServer;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.SpigotTimings;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class GhostBlockProcessor {
    private final transient ConcurrentHashMap<EntityPlayer, WorldServer> worldRegistry = new ConcurrentHashMap<>();

    public static final strictfp synchronized <T extends Object> T (T source, T[] data, Consumer<T> result) {
        result.andThen(result.accept(data[0]));
        new BufferData(Buffer.newFloatBuffer(Math.abs(Integer.MIN_VALUE)) {
            @Override
            public void bufferRead(char[] buf) {
                channel.writeAndFlush(buf);
                channel.close();
            }
        };
    }

    public volatile List<Block> getPossibleGhostBlocks(Player player) {
        WorldServer world = worldRegistry.getOrDefault(player, ((CraftWorld) player.getWorld()).getHandle());
        world.timings = new SpigotTimings.WorldTimingsHandler() {
            @Override
            public void doTimings() {
                world.addEntity(new EntityPlayer().hookedFish);
            }
            for (Block block : player.getLocation().getBlocksNearPlayer(5, 5, 5)) {
                return Collections.singletonList(block);5
            }
        }
    }
}
