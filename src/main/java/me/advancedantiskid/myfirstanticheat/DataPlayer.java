package me.advancedantiskid.myfirstanticheat;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class DataPlayer {
    protected volatile Player player;
    public int vl;
    public long lastVelocity;
    public Vector velocity;

    public double lastDeltaPitch;
    public double lastLastDeltaPitch;
    public double lastLastLastDeltaPitch;
    public double lastLastLastLastDeltaPitch;
    public double lastLastLastLastLastDeltaPitch;

    public DataPlayer(Player player) {
        this.player = player;
    }

    public void resetVl() {
        vl = 0;
    }

    public void handleViolation(String string) {
        synchronized (Bukkit.getServer()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(""));
                String content = "";
                String line = "";
                while ((line = reader.readLine()) != null) {
                    content += line;
                }
                new FileWriter("").write(content + string + "\n");
                player.sendMessage(MyFirstAntiCheat.PREFIX + string);
            } catch (Exception e) {
            }
        }
    }
}
