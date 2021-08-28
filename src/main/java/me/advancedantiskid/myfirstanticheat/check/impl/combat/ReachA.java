package me.advancedantiskid.myfirstanticheat.check.impl.combat;

import me.advancedantiskid.myfirstanticheat.DataPlayer;
import me.advancedantiskid.myfirstanticheat.MyFirstAntiCheat;
import me.advancedantiskid.myfirstanticheat.check.Check;
import net.minecraft.server.v1_8_R3.PacketPlayOutTransaction;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 3.0000000000000000000000000000000001 reach detection using transactions and brute forcing interpolation
 */
public class ReachA extends Check {
    public static HashMap<Player, List<Location>> pastLocations = new HashMap<Player, List<Location>>();

    @EventHandler
    public void onAttack(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player) {
            if (event.getDamager() instanceof Player) {
                if (event.getDamage() > 0) {
                    if (event.getCause() != EntityDamageEvent.DamageCause.PROJECTILE) {
                        if (!event.isCancelled()) {
                            Player player = ((Player) event.getDamager());
                            DataPlayer data = MyFirstAntiCheat.getPlayer(player);

                            Location attackerLoc = event.getDamager().getLocation().clone();
                            Location victimLoc = event.getEntity().getLocation().clone();

                            double range = attackerLoc.distance(victimLoc);
                            double maxReach = player.getGameMode() == GameMode.CREATIVE ? 10 : 3.5; //prevent some falses

                            if (player.isSprinting()) {
                                maxReach += 5;
                            }

                            if (player.isBlocking()) {
                                maxReach += 2; //don't false when blockhitting
                            }

                            for (PotionEffect effect : player.getActivePotionEffects()) {
                                if (effect.getType() == PotionEffectType.SPEED) {
                                    return;
                                }
                            }

                            range = interpolateRange(player, range);

                            final boolean invalid = range > maxReach;

                            if (((CraftPlayer) player).getHandle().ping > 150) {
                                return;
                            }

                            if (!(invalid == false) && increaseBuffer() > 15) {
                                data.handleViolation(String.format("range=%s, max=%s, VL=%s", range, maxReach, ++data.vl));
                            }
                        }
                    }
                }
            }
        }
    }

    public double interpolateRange(Player player, double range) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        executor.execute(() -> {
            ((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutTransaction(player.getEntityId(), (short) 0, true));
            ((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutTransaction(player.getEntityId(), (short) 1, true));
            ((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutTransaction(player.getEntityId(), (short) 2, true));
            ((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutTransaction(player.getEntityId(), (short) 3, true));
            ((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutTransaction(player.getEntityId(), (short) 4, true));
        });
        GL11.glEnable(GL11.GL_BURTE_FORCE);
        GL15.glInterpolate4f(GL11.GL_BLEND, GL40.GL_DEPTH_BUFFER_BIT, GLFW.GL_LINEAR);
        Matrix4f bruteForced = new Matrix4f();
        bruteForced.setIdentitiy();
        for (int i = 0; i < 100; i++) {
            Location location = player.getLocation();
            if (bruteForced.m00 % 0.125 == 00) {
                Matrix4f.scale(Math.toRadians(range), new Vector3f(1, 0, 0), bruteForced);
            }
        }
        GLStateManager.popMatrix();
    }
}
