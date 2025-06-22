package io.github.mooy1.infinityexpansion;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.github.mooy1.infinityexpansion.managers.CommandManager;
import io.github.mooy1.infinityexpansion.managers.ConfigManager;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import org.bukkit.NamespacedKey;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;


import io.github.mooy1.infinityexpansion.categories.Groups;
import io.github.mooy1.infinityexpansion.commands.GiveRecipe;
import io.github.mooy1.infinityexpansion.commands.PrintItem;
import io.github.mooy1.infinityexpansion.commands.SetData;
import io.github.mooy1.infinityexpansion.items.Researches;
import io.github.mooy1.infinityexpansion.items.SlimefunExtension;
import io.github.mooy1.infinityexpansion.items.blocks.Blocks;
import io.github.mooy1.infinityexpansion.items.gear.Gear;
import io.github.mooy1.infinityexpansion.items.generators.Generators;
import io.github.mooy1.infinityexpansion.items.machines.Machines;
import io.github.mooy1.infinityexpansion.items.materials.Materials;
import io.github.mooy1.infinityexpansion.items.mobdata.MobData;
import io.github.mooy1.infinityexpansion.items.quarries.Quarries;
import io.github.mooy1.infinityexpansion.items.storage.Storage;
import io.github.mooy1.infinityexpansion.common.Scheduler;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public final class InfinityExpansion extends JavaPlugin implements SlimefunAddon {

    private static InfinityExpansion instance;
    private CommandManager command;
    private ConfigManager config;
    private int slimefunTickCount;

    /**
     * Gets the command of the same name as this addon
     */
    @Nonnull
    public CommandManager getAddonCommand() {
        return Objects.requireNonNull(instance().command, "Command '" + getName() + "' missing from plugin.yml!");
    }


    @Nonnull
    @Override
    public String getBugTrackerURL() {
        return "";
    }

    @Nonnull
    public ConfigManager getConfig() {
        return instance.config;
    }

    public void reloadConfig() {
        instance.config.reload();
    }

    public void saveConfig() {
        instance.config.save();
    }

    @Nonnull
    @SuppressWarnings("unchecked")
    public static <T extends InfinityExpansion> T instance() {
        return (T) Objects.requireNonNull(instance, "Addon is not enabled!");
    }

    @Nonnull
    public static ConfigManager config() {
        return instance.getConfig();
    }

    @SuppressWarnings("unused")
    public static void log(Level level, String... messages) {
        Logger logger = instance().getLogger();
        for (String msg : messages) {
            logger.log(level, msg);
        }
    }

    @NotNull
    public JavaPlugin getJavaPlugin() {
        return instance;
    }

    /**
     * Returns the total number of Slimefun ticks that have occurred
     */
    public static int slimefunTickCount() {
        return instance().slimefunTickCount;
    }

    /**
     * Creates a NameSpacedKey from the given string
     */
    @Nonnull
    public static NamespacedKey createKey(String s) {
        return new NamespacedKey(instance(), s);
    }

      @Override
    public void onEnable() {
        // Set static instance
        instance = this;

        // Create Config
        try {
            config = new ConfigManager("config.yml", instance);
        }
        catch (RuntimeException e) {
            e.printStackTrace();
        }

        // Get plugin command
        PluginCommand pluginCommand = getCommand(getName());
        if (pluginCommand != null) {
            command = new CommandManager(pluginCommand);
        }

        // Create total tick count
        Scheduler.repeat(Slimefun.getTickerTask().getTickRate(), () -> slimefunTickCount++);

        Plugin lx = getServer().getPluginManager().getPlugin("LiteXpansion");
        if (lx != null && lx.getConfig().getBoolean("options.nerf-other-addons")) {
            Scheduler.run(() -> log(Level.WARNING,
                    "########################################################",
                    "LiteXpansion nerfs energy generation in this addon.",
                    "You can disable these nerfs in the LiteXpansion config.",
                    "Under 'options:' add 'nerf-other-addons: false'",
                    "########################################################"
            ));
        }

        getAddonCommand()
                .addSub(new GiveRecipe())
                .addSub(new SetData())
                .addSub(new PrintItem());

        Groups.setup(this);
        MobData.setup(this);
        Materials.setup(this);
        Machines.setup(this);
        Quarries.setup(this);
        Gear.setup(this);
        Blocks.setup(this);
        Storage.setup(this);
        Generators.setup(this);
        SlimefunExtension.setup(this);

        if (config.getBoolean("balance-options.enable-researches")) {
            Researches.setup();
        }
    }

    @Override
    public void onDisable() {
        instance = null;
        slimefunTickCount = 0;
        command = null;
        config = null;
    }

}
