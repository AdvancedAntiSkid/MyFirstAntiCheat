package me.advancedantiskid.myfirstanticheat.check;

import me.advancedantiskid.myfirstanticheat.check.impl.combat.AimGCD;
import me.advancedantiskid.myfirstanticheat.check.impl.combat.ReachA;
import me.advancedantiskid.myfirstanticheat.check.impl.movement.HighJumpA;
import me.advancedantiskid.myfirstanticheat.check.impl.movement.PredictionA;
import me.advancedantiskid.myfirstanticheat.check.impl.other.BadPacketsA;

import java.util.ArrayList;

public class CheckManager {
    public static ArrayList<Check> checks = new ArrayList<Check>();

    public static void load() {
        checks.add(new ReachA());
        checks.add(new PredictionA());
        checks.add(new BadPacketsA());
        checks.add(new AimGCD());
        checks.add(new HighJumpA());
    }
}
