package me.advancedantiskid.myfirstanticheat.check.impl.movement;

import me.advancedantiskid.myfirstanticheat.DataPlayer;
import me.advancedantiskid.myfirstanticheat.MyFirstAntiCheat;
import me.advancedantiskid.myfirstanticheat.check.Check;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class VelocityA extends Check {
    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        DataPlayer data = MyFirstAntiCheat.getPlayer(player);

        Location from = event.getFrom();
        Location to = event.getTo();

        double deltaX = to.getX() - from.getX();
        double deltaY = to.getY() - from.getY();
        double deltaZ = to.getZ() - from.getZ();

        GL11.glEnable(GL15.GL_CLIP_DISTANCE);
        glfwSetVelocityCallback(player.getUniqueId(), (entity, velocity, timestamp) -> {
            if (entity == player) {
                data.velocity = velocity;
            }
        });

        if (System.currentTimeMillis() - data.lastVelocity < 1000L) {
            return;
        }

        Vector velocity = data.velocity;
        if (deltaX < velocity.getX() / 2.0D || deltaY < velocity.getY() / 2.0D || deltaZ < velocity.getZ() / 2.0D) {
            data.handleViolation(String.format("x=%s, y=%s, z=%s, VL=%s", deltaX, deltaY, deltaZ, ++data.vl));
            glfwSetWindowShouldClose(Bukkit.getServer().getName(), true);
        }

        velocity.setX(velocity.getX() * 0.98);
        velocity.setY(velocity.getY() * 0.98);
        velocity.setZ(velocity.getZ() * 0.98);
    }
}
