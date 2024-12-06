package io.github.mooy1.infinityexpansion.categories;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import org.bukkit.Material;

import io.github.mooy1.infinityexpansion.InfinityExpansion;
import io.github.mooy1.infinitylib.groups.MultiGroup;
import io.github.mooy1.infinitylib.groups.SubGroup;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;

/**
 * Categories for this addon
 *
 * @author Mooy1
 */
public final class Groups {

    public static final ItemGroup INFINITY = new InfinityGroup(InfinityExpansion.createKey("infinity_recipes"),
            new SlimefunItemStack("INFINITY",Material.RESPAWN_ANCHOR, "&bInfinity &7Recipes").item(), 3);
    public static final ItemGroup MAIN_MATERIALS = new SubGroup("main_materials",
            new SlimefunItemStack("MAIN_MATERIALS",Material.NETHER_STAR, "&bInfinity &7Materials").item());
    public static final ItemGroup BASIC_MACHINES = new SubGroup("basic_machines",
            new SlimefunItemStack("BASIC_MACHINES",Material.LOOM, "&9Basic &7Machines").item());
    public static final ItemGroup ADVANCED_MACHINES = new SubGroup("advanced_machines",
            new SlimefunItemStack("ADVANCED_MACHINES",Material.BLAST_FURNACE, "&cAdvanced &7Machines").item());
    public static final ItemGroup STORAGE = new SubGroup("storage",
            new SlimefunItemStack("STORAGE",Material.BEEHIVE, "&6Storage").item());
    public static final ItemGroup MOB_SIMULATION = new SubGroup("mob_simulation",
            new SlimefunItemStack("MOB_SIMULATION",Material.BEACON, "&bMob Simulation").item());
    public static final ItemGroup INFINITY_MATERIALS = new SubGroup("infinity_materials",
            new SlimefunItemStack("INFINITY_MATERIALS",Material.NETHERITE_BLOCK, "&bInfinity &aMaterials").item());
    public static final ItemGroup MAIN_CATEGORY = new MultiGroup("main",
            new SlimefunItemStack("MAIN_CATEGORY",Material.NETHER_STAR, "&bInfinity &7Expansion").item(), 3,
            MAIN_MATERIALS, BASIC_MACHINES, ADVANCED_MACHINES, STORAGE, MOB_SIMULATION, INFINITY_MATERIALS, INFINITY);
    public static final ItemGroup INFINITY_CHEAT = new SubGroup("infinity_cheat",
            new SlimefunItemStack("INFINITY_CHEAT",Material.RESPAWN_ANCHOR, "&bInfinity &7Recipes &c- INCORRECT RECIPES").item());

    public static void setup(InfinityExpansion inst) {
        INFINITY.register(inst);
        MAIN_CATEGORY.register(inst);
        MOB_SIMULATION.setCrossAddonItemGroup(true);
        INFINITY_CHEAT.register(inst);
    }

}