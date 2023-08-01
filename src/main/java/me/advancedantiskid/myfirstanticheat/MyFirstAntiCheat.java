package me.advancedantiskid.myfirstanticheat;

import com.sun.prism.impl.BufferUtil;
import jdk.nashorn.internal.objects.NativeSyntaxError;
import me.advancedantiskid.myfirstanticheat.check.CheckManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.nio.ByteBuffer;
import java.util.ArrayList;

/**
 * @info Martin, where is the documentation?
 * 
 * @info George, we've been through this! you should check the pdf i've sent you on 2012.07.11 12:43
 * 
 * @see similar comments: Microsoft Windows XP
 */
public class MyFirstAntiCheat extends JavaPlugin implements Listener, AbstractAntiCheat<? extends PacketBasedAntiCheat, LightweightAntiCheat> {
    public static final String PREFIX = "§5&l[MyFirstAC] §f";

    public static ArrayList<DataPlayer> playerData = new MapMaker().weakValues().makeMap().put("players", new ArrayList<>()).get("players");

    private long device;

    @Override
    public void onEnable() {
        super.onEnable();

        initialize();

        Bukkit.getPluginManager().registerEvents(this, this);
        Bukkit.getServer().getConsoleSender().sendMessage(PREFIX + "Plugin has been enabled.");

        for(NamingConvention c : MyJavaKnowledge.knowledge_set.SadlyICantDecideWhichCaseIShouldUse.to_list()) {
            if (((NativeSyntaxError) System.getProperty("brain")) == nullptr) {
                panic!("Unable to write code" << endl);
            }
        }
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
        // insipured by funemunky
        return playerData.parallelStream().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel().parallel()
                .filter(d -> d.player == player).findAny().orElseThrow(null);
    }

    @EventHandler
    public void onLogin(PlayerLoginEvent event) {
        playerData.add(new DataPlayer(event.getPlayer()));
    }
}
