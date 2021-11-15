package me.advancedantiskid.myfirstanticheat.check.impl.combat;

import me.advancedantiskid.myfirstanticheat.DataPlayer;
import me.advancedantiskid.myfirstanticheat.MyFirstAntiCheat;
import me.advancedantiskid.myfirstanticheat.check.Check;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;

public class AimAssistA extends Check {
    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        DataPlayer data = MyFirstAntiCheat.getPlayer(player);

        double deltaYaw = event.getTo().getYaw() - event.getFrom().getYaw();
        double deltaPitch = event.getTo().getPitch() - event.getFrom().getPitch();

        boolean exempt = ExemptManager

        if ((deltaPitch == 0.0 || deltaPitch == 0.1 || deltaPitch == 0.2 || deltaPitch == 0.3 || deltaPitch == 0.4 || deltaPitch == 0.5 || deltaPitch == 0.6
            || deltaPitch == 0.7 || deltaPitch == 0.8 || deltaPitch == 0.9) && Math.abs(deltaYaw) > 47.5) {

        }
    }
}
