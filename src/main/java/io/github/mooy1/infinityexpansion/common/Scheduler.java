package io.github.mooy1.infinityexpansion.common;

import javax.annotation.ParametersAreNonnullByDefault;

import io.github.mooy1.infinityexpansion.InfinityExpansion;
import lombok.experimental.UtilityClass;

import org.bukkit.Bukkit;

/**
 * A class for scheduling tasks
 *
 * @author Mooy1
 */
@UtilityClass
@ParametersAreNonnullByDefault
public final class Scheduler {

    public static void run(Runnable runnable) {
        Bukkit.getScheduler().runTask(InfinityExpansion.getInstance(), runnable);
    }

    public static void runAsync(Runnable runnable) {
        Bukkit.getScheduler().runTaskAsynchronously(InfinityExpansion.getInstance(), runnable);
    }

    public static void run(int delayTicks, Runnable runnable) {
        Bukkit.getScheduler().runTaskLater(InfinityExpansion.getInstance(), runnable, delayTicks);
    }

    public static void runAsync(int delayTicks, Runnable runnable) {
        Bukkit.getScheduler().runTaskLaterAsynchronously(InfinityExpansion.getInstance(), runnable, delayTicks);
    }

    public static void repeat(int intervalTicks, Runnable runnable) {
        repeat(intervalTicks, 1, runnable);
    }

    public static void repeatAsync(int intervalTicks, Runnable runnable) {
        repeatAsync(intervalTicks, 1, runnable);
    }

    public static void repeat(int intervalTicks, int delayTicks, Runnable runnable) {
        Bukkit.getScheduler().runTaskTimer(InfinityExpansion.getInstance(), runnable, delayTicks, Math.max(1, intervalTicks));
    }

    public static void repeatAsync(int intervalTicks, int delayTicks, Runnable runnable) {
        Bukkit.getScheduler().runTaskTimerAsynchronously(InfinityExpansion.getInstance(), runnable, delayTicks, Math.max(1, intervalTicks));
    }

}
