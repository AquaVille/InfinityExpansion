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
                                    + " is out of bounds for " + e.getKeyOrNull()
                                    + ", resetting to default!"
                    );
                }
            }
        }
        return enchants;
    }

    @Nullable
    private static Enchantment enchantmentByPath(@Nonnull String path) {
        return switch (path) {
            case "sharpness" -> Enchantment.SHARPNESS;
            case "smite" -> Enchantment.SMITE;
            case "bane-of-arthropods" -> Enchantment.BANE_OF_ARTHROPODS;
            case "efficiency" -> Enchantment.EFFICIENCY;
            case "protection" -> Enchantment.PROTECTION;
            case "fire-aspect" -> Enchantment.FIRE_ASPECT;
            case "fortune" -> Enchantment.FORTUNE;
            case "looting" -> Enchantment.LOOTING;
            case "silk-touch" -> Enchantment.SILK_TOUCH;
            case "thorns" -> Enchantment.THORNS;
            case "aqua-affinity" -> Enchantment.AQUA_AFFINITY;
            case "power" -> Enchantment.POWER;
            case "flame" -> Enchantment.FLAME;
            case "infinity" -> Enchantment.INFINITY;
            case "punch" -> Enchantment.PUNCH;
            case "feather-falling" -> Enchantment.FEATHER_FALLING;
            case "unbreaking" -> Enchantment.UNBREAKING;
            default -> null;
        };
    }
}
