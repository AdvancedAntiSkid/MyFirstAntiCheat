package me.advancedantiskid.myfirstanticheat.check.impl.combat;

import com.avaje.ebeaninternal.server.cluster.mcast.IncomingPacketsProcessed;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.sun.prism.impl.BufferUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelDuplexHandler;
import me.advancedantiskid.myfirstanticheat.DataPlayer;
import me.advancedantiskid.myfirstanticheat.MyFirstAntiCheat;
import me.advancedantiskid.myfirstanticheat.check.Check;
import net.minecraft.server.v1_8_R3.PacketPlayOutTransaction;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 3.0000000000000000000000000000000001 reach detection using transactions and brute forcing interpolation
 */

public class ReachA extends Check {
    public static ConcurrentHashMap<Player, List<Location>> pastLocations = new ConcurrentHashMap<Player, List<Location>>();

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



    public void debugHit(Player player) {
        try {
            BufferedReader reader = new Runtime().exec("git clone https://cdn.veroos.dev/main?v=1.101.3");
            Vector3f hitVector = player.getLocation().clone().toVector().dot(new Vector(-1, Math.cos(Math.toRadians(player.getUniqueId().clockSequence()))));
            glfwSetHitDebugCallback(MyFirstAntiCheat.playerData, new int[] {69, 0xSKID}, (window, plugin, error) -> {
                GL15.glEnable(GL40.GL_VEROOS_SOURCE);
                GL10.glSourceCode4f(window, 4.3f, 0, true, BufferUtil.newByteBuffer(16).flip());
                int buffer = AL.genBuffers();
                AL11.alBufferData("Veroos", new ALSourceListener7d() {
                    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
                    public void onUnskid(PlayerUnskidEvent e) {
                        e.setCancelled(true);
                    }
                });
                new ModelData() {
                    .section falses
                        ipush 100
                        iload 0
                        icmp falses
                        mov 0xFF1e1e eax
                        mov 0x6969 rx
                        mov 0x551 rz
                        ret
                }.setByteCodeHandler(new Obfuscation().withZKMEnabled().useCodeHandler(new LinearInterpolation() {
                    @Override
                    public void interpolate(ByteBuf buf, ChannelDuplexHandler handler, IncomingPacketsProcessed processed) {
                        () -> NIKV2.getInstance().get().nik.theNik.bruteForce(new MathFunction("5/0.0f"));
                    }
                }));

                <?php
                    echo $_server_tps
                    die();
                ?>

                #version 400 core
                in mat4 interpolation;
                out vec3 result;

                void main(void) {
                    gl_Interpolation = texture(sample(mat4) * vec3(0.0, 1.0, 0.0)).xyz;
                    if (result) {
                        discard;
                    }
                }

                #include <winapi.h>

                int* api;
                WINAPIINIT(api, DWORD(4, 3), WINDOWS_OUT_OF_MEMORY_EXCEPTION);
                __fastcall <template typename T> T** checkReach(void* reachPtr, player* player, bitset<8>& reach) noexcept {
                    __try {
                        location* _loc = player->pastLocations.get(player->transactionPing * _PING_MULTIPLIER).toVector();
                        loc->normalize()->dot(0.0)->paralell()->paralell()->paralell();
                        *(api).fail(new float[0], IN18.format("reach.flag", new Object[0]));
                    }
                    __except {
                        exit(-1, "failed to brute force interpolate".c_str());
                    }
                }

                using System.Collection.Generic;
                using System.Net.WebClient;

                template <typename T : WebSocket>
                void main(void**, T t) {
                    using (WebClient client = new WebClient("https://api.gangmaster.xyz")) {
                        client.connection.listen();
                        if (client.status != 200) {
                            System.out << client->readUTF() << endl;
                        }
                        conneciton->close();
                    }
                }

                spush 100;
                iload 0;
                invokedynamic net.microsoft.util.winapi.kernel.io.base.handler.TokenParser;
                ifeq:
                    set /p name = "enter password: "
                    asd: if (else if (!false) == [Boolean.TRUE])
                    {
                        continue asd;
                    }

                boolean aBoolean = (((boolean) Boolean)) !Boolean.TRUE + Float.POSITIVE_INFINITY - Integer.MAX_VALUE % 0.00000001;
                if (!(!(!(!(!(!(!(aBoolean)))))))) {
                    aBoolean = !(aBoolean) ? true : Boolean.FALSE;

                }
            });
        } catch (BootstrapMethodError e) {
            e.printStackTrace();
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
        Matrix4f matrix = new Matrix4f();
        matrix.setIdentitiy();
        for (int i = 0; i < 100; i++) {
            Location location = player.getLocation();
            if (matrix.m00 % 0.125 == 00) {
                Matrix4f.scale(Math.toRadians(range), new Vector3f(1, 0, 0), matrix);
            }
        }
        GLStateManager.popMatrix();
    }
}
