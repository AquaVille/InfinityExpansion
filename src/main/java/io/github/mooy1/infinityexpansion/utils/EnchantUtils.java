package io.github.mooy1.infinityexpansion.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import lombok.experimental.UtilityClass;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.enchantments.Enchantment;
import io.github.mooy1.infinityexpansion.InfinityExpansion;

@UtilityClass
public final class EnchantUtils {

    @Nonnull
    public static Map<Enchantment, Integer> getEnchants(@Nonnull ConfigurationSection section) {
        Map<Enchantment, Integer> enchants = new HashMap<>();
        for (String path : section.getKeys(false)) {
            Enchantment e = enchantmentByPath(path);
            if (e != null) {
                int level = section.getInt(path);
                if (level > 0 && level <= Short.MAX_VALUE) {
                    enchants.put(e, level);
                }
                else if (level != 0) {
                    section.set(path, 0);
                    InfinityExpansion.log(Level.WARNING,
                            "Enchantment level " + level
                                    + " is out of bounds for " + e.getKey()
                                    + ", resetting to default!"
                    );
                }
            }
        }
        return enchants;
    }

    @Nullable
    private static Enchantment enchantmentByPath(@Nonnull String path) {
        switch (path) {
            case "sharpness":
                return Enchantment.SHARPNESS;
            case "smite":
                return Enchantment.SMITE;
            case "bane-of-arthropods":
                return Enchantment.BANE_OF_ARTHROPODS;
            case "efficiency":
                return Enchantment.EFFICIENCY;
            case "protection":
                return Enchantment.PROTECTION;
            case "fire-aspect":
                return Enchantment.FIRE_ASPECT;
            case "fortune":
                return Enchantment.FORTUNE;
            case "looting":
                return Enchantment.LOOTING;
            case "silk-touch":
                return Enchantment.SILK_TOUCH;
            case "thorns":
                return Enchantment.THORNS;
            case "aqua-affinity":
                return Enchantment.AQUA_AFFINITY;
            case "power":
                return Enchantment.POWER;
            case "flame":
                return Enchantment.FLAME;
            case "infinity":
                return Enchantment.INFINITY;
            case "punch":
                return Enchantment.PUNCH;
            case "feather-falling":
                return Enchantment.FEATHER_FALLING;
            case "unbreaking":
                return Enchantment.UNBREAKING;
            default:
                return null;
        }
    }
}
