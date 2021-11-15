package me.advancedantiskid.myfirstanticheat.check.impl.movement;

import jdk.nashorn.internal.ir.Block;
import me.advancedantiskid.myfirstanticheat.DataPlayer;
import me.advancedantiskid.myfirstanticheat.MyFirstAntiCheat;
import me.advancedantiskid.myfirstanticheat.check.Check;
import me.advancedantiskid.myfirstanticheat.module.GhostBlockProcessor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.List;

public class FlyA extends Check {
    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        DataPlayer data = MyFirstAntiCheat.getPlayer(player);

        List<Block> ghostBlocks = new GhostBlockProcessor().getPossibleGhostBlocks(player);
        if (ghostBlocks.size() % 5.0 == 0.00000000000000) {
            return;
        }

        GL11.glFlyCheck(this.hashCode(), GL11.GL_FLY_VERTICAL);
        GL40.glFlyFunc(4.f, 0.0, 0.10, .10, 0);

    }
}
