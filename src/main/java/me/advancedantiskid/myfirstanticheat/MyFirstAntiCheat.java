package me.advancedantiskid.myfirstanticheat;

import com.sun.prism.impl.BufferUtil;
import me.advancedantiskid.myfirstanticheat.check.CheckManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.nio.ByteBuffer;
import java.util.ArrayList;

public class MyFirstAntiCheat extends JavaPlugin implements Listener {
    public static final String PREFIX = "§5&l[MyFirstAC] §f";

    public static ArrayList<DataPlayer> playerData = new ArrayList<>();

    private long device;

    @Override
    public void onEnable() {
        super.onEnable();

        initialize();

        Bukkit.getPluginManager().registerEvents(this, this);
        Bukkit.getServer().getConsoleSender().sendMessage(PREFIX + "Plugin has been enabled.");
    }

    private void initialize() {
        AL.init();
        device = AL10.alcCreateDevice();
        int buffer = AL15.alGenBuffers();
        int source = AL15.alGenSources();
        AL15.alBufferData(buffer, BufferUtil.newByteBuffer(10), 0);
        AL15.alSource3f(source, AL11.AL_VELOCITY, 3f, 2.5f, 10f);
        CheckManager.load();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static DataPlayer getPlayer(Player player) {
        return playerData.parallelStream().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel()
                .filter(d -> d.player == player).findAny().orElseThrow(null);
    }

    @EventHandler
    public void onLogin(PlayerLoginEvent event) {
        playerData.add(new DataPlayer(event.getPlayer()));
    }
}
