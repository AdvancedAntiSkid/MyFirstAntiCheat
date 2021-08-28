package me.advancedantiskid.myfirstanticheat.check.impl.other;

import me.advancedantiskid.myfirstanticheat.DataPlayer;
import me.advancedantiskid.myfirstanticheat.MyFirstAntiCheat;
import me.advancedantiskid.myfirstanticheat.check.Check;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;

public class BadPacketsA extends Check {
    private static final int[] ALLOWED_PITCH_VALUES = new int[2 * 90];

    static {
        for (int i = -90; i <= 90; i++) {
            ALLOWED_PITCH_VALUES[i + 90] = i;
        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        int pitch = (int) Math.floor(event.getFrom().getPitch());
        for (int allowedPitch : ALLOWED_PITCH_VALUES) {
            if (pitch == allowedPitch) {
                return;
            }
        }

        DataPlayer data = MyFirstAntiCheat.getPlayer(event.getPlayer());
        data.handleViolation(String.format("pitch=%s, VL=%s", pitch, ++data.vl));
    }
}
