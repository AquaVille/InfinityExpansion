package io.github.mooy1.infinityexpansion.groups;

import javax.annotation.ParametersAreNonnullByDefault;

import io.github.mooy1.infinityexpansion.InfinityExpansion;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;

/**
 * A category that is hidden from the main guide page
 *
 * @author Mooy1
 */
@ParametersAreNonnullByDefault
public final class SubGroup extends ItemGroup {

    public SubGroup(String key, ItemStack item) {
        this(key, item, 3);
    }

    public SubGroup(String key, ItemStack item, int tier) {
        super(InfinityExpansion.createKey(key), item, tier);
    }

    @Override
    public boolean isHidden(Player p) {
        return true;
    }

}
