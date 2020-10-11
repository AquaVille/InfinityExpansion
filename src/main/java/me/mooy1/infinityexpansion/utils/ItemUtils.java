package me.mooy1.infinityexpansion.utils;

import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class ItemUtils {

    private ItemUtils() {}

    public static String getIDFromItem(ItemStack item) {
        if (SlimefunItem.getByItem(item) != null) {
            return SlimefunItem.getByItem(item).getID();
        } else if (item != null){
            return item.getType().toString();
        } else {
            return "";
        }
    }

    public static ItemStack getItemFromID(String id, int amount) {
        if (SlimefunItem.getByID(id) != null) {
            return new CustomItem(SlimefunItem.getByID(id).getItem(), amount);
        } else {
            return new ItemStack(Material.getMaterial(id), amount);
        }
    }
}