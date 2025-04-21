package io.github.mooy1.infinityexpansion.common;

import java.util.function.Consumer;

import javax.annotation.ParametersAreNonnullByDefault;

import io.github.mooy1.infinityexpansion.InfinityExpansion;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

/**
 * A class for registering listeners and event handlers
 *
 * @author Mooy1
 */
@ParametersAreNonnullByDefault
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Events implements Listener {

    private static final Listener LISTENER = new Events();

    /**
     * Calls the given event
     */
    public static <T extends Event> T call(T event) {
        Bukkit.getPluginManager().callEvent(event);
        return event;
    }

    /**
     * Registers the given listener class
     */
    public static void registerListener(Listener listener) {
        Bukkit.getPluginManager().registerEvents(listener, InfinityExpansion.instance());
    }

    /**
     * Registers the given handler to the given event
     */
    @SuppressWarnings("unchecked")
    public static <T extends Event> void addHandler(Class<T> eventClass, EventPriority priority,
                                                    boolean ignoreCancelled, Consumer<T> handler) {
        Bukkit.getPluginManager().registerEvent(eventClass, LISTENER, priority,
                (listener, event) -> handler.accept((T) event), InfinityExpansion.instance(), ignoreCancelled);
    }

}