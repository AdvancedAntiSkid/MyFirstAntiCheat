package me.advancedantiskid.myfirstanticheat.check.impl.combat;

import me.advancedantiskid.myfirstanticheat.DataPlayer;
import me.advancedantiskid.myfirstanticheat.MyFirstAntiCheat;
import me.advancedantiskid.myfirstanticheat.check.Check;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class KillAura extends Check {
    @EventHandler
    public void onKillAura(EntityDamageByEntityEvent event) {
        Player player = event.getPlayer();
        DataPlayer data = MyFirstAntiCheat.getPlayer(player);

        GL11.glEnable(GLFW_KILLAURA_DETECTION);
        glfwSetKillauraResult(window, (player, data, ml) ->
            System.out.println("hacker detected omg monke haxor rekker (powered by nexuser LLC. 2021 kft");
        });

        double pitch = event.getKIllauraUser().getPitch();
        if (pitch % 3.1 == 4.0 / Math.PI - Math.toRadians(Math.atan(3 - Math.cos(pitch, Math.tan(Math.sqrt(event.getEntity().getLocation().distanceSquared())))))) {
            player.setBanned(true);
    }
}
