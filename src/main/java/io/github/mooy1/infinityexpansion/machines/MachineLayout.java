package io.github.mooy1.infinityexpansion.machines;

import javax.annotation.ParametersAreNonnullByDefault;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ParametersAreNonnullByDefault
public final class MachineLayout {

    public static final MachineLayout MACHINE_DEFAULT = new MachineLayout()
            .setInputBorder(new int[] {
                    9, 10, 11, 12,
                    18, 21,
                    27, 28, 29, 30
            }).setInputSlots(new int[] { 19, 20 })
            .setOutputBorder(new int[] {
                    14, 15, 16, 17,
                    23, 26,
                    32, 33, 34, 35
            }).setOutputSlots(new int[] { 24, 25 })
            .setBackground(new int[] {
                    0, 1, 2, 3, 4, 5, 6, 7, 8,
                    13, 31,
                    36, 37, 38, 39, 40, 41, 42, 43, 44
            }).setStatusSlot(22);

    public static final MachineLayout CRAFTING_DEFAULT = new MachineLayout()
            .setInputBorder(new int[] {
                    0, 1, 2, 3, 4,
                    9, 13,
                    18, 22,
                    27, 31,
                    36, 37, 38, 39, 40
            }).setInputSlots(new int[] {
                    10, 11, 12,
                    19, 20, 21,
                    28, 29, 30
            }).setOutputBorder(new int[] {
                    15, 16, 17,
                    24, 26,
                    33, 34, 35
            }).setOutputSlots(new int[] { 25 })
            .setBackground(new int[] {
                    5, 6, 7, 8,
                    14,
                    32,
                    41, 42, 43, 44
            }).setStatusSlot(23);

    @Setter
    @Getter
    private int[] inputBorder;

    @Setter
    @Getter
    private int[] inputSlots;

    @Setter
    @Getter
    private int[] outputBorder;

    @Setter
    @Getter
    private int[] outputSlots;

    @Setter
    @Getter
    private int[] background;

    @Setter
    @Getter
    private int statusSlot;

}
