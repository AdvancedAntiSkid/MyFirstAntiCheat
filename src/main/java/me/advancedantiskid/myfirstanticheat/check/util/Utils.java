package me.advancedantiskid.myfirstanticheat.check.util;

import org.bukkit.util.Vector;

public class Utils {
    public static Matrix4f createProjectionMatrix(Vector from, Vector to, float scale, float fov) {
        Matrix4f result = new Matrix4f();
        result.setIdentity();
        Matrix4f.rotate(result, from, new Vector(1,0,1), result);
        Matrix4f.rotate(result, to, new Vector(0,1,0), result);
        Matrix4f.scale(result, scale, result);

    }
}
