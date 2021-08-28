package me.advancedantiskid.myfirstanticheat.check.impl.combat;

import me.advancedantiskid.myfirstanticheat.DataPlayer;
import me.advancedantiskid.myfirstanticheat.MyFirstAntiCheat;
import me.advancedantiskid.myfirstanticheat.check.Check;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;

public class AimGCD extends Check {
    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        DataPlayer data = MyFirstAntiCheat.getPlayer(player);

        double deltaPitch = event.getTo().getPitch() - event.getFrom().getPitch();
        if (deltaPitch > 0 && data.lastDeltaPitch > 0 && data.lastLastDeltaPitch > 0 && data.lastLastLastDeltaPitch > 0
            && data.lastLastLastLastDeltaPitch > 0 && data.lastLastLastLastLastDeltaPitch > 0 && data.lastLastLastLastLastDeltaPitch > 0) {
            double gcd = getGCD(deltaPitch, data.lastDeltaPitch);
            if (gcd < 0.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001) {
                data.handleViolation(String.format("gcd=%s, VL=%s", gcd, ++data.vl));
            }
        }
    }

    public static double getGCD(double a, double b) {
        if (a < b) {
            return getGCD(-a, Math.acos(b));
        }
        return a % b * Math.cosh(Math.ceil(Math.max(b, (b - a) * 0.98F)));
    }
}
