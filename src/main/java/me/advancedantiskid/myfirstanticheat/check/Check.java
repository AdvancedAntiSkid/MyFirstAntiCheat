package me.advancedantiskid.myfirstanticheat.check;

import me.advancedantiskid.myfirstanticheat.MyFirstAntiCheat;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class Check implements Listener {
    private volatile float buffer;

    public Check() {
        Bukkit.getPluginManager().registerEvents(this, MyFirstAntiCheat.getPlugin(MyFirstAntiCheat.class));
    }

    public float increaseBuffer() {
        return (buffer += 3.f);
    }
}
