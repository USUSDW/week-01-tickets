package com.github.ususdw.tickets;

/**
 * Removes priority magic numbers and replaces them with more human-readable versions.
 *
 * Use {@link Priority#priority priority} to get an integer value from the named version.
 */
public enum Priority {
    LOW(20),
    MEDIUM(15),
    HIGH(10),
    IMPORTANT(5),
    CRITICAL(1);

    /**
     * The integer representation of this priority.
     */
    public final int priority;

    /**
     * Enum constructor. Used to map integers to the enum values.
     *
     * @param priority The integer that this priority maps to.
     */
    Priority(int priority) {
        this.priority = priority;
    }

    /**
     * Generates a priority value from an int value. <br><br>
     *
     * >= 16 returns {@link #LOW}, <br>
     * >= 11 returns {@link #MEDIUM}, <br>
     * >= 6 returns {@link #HIGH}, <br>
     * >= 2 returns {@link #IMPORTANT}, <br>
     * <= 1 returns {@link #CRITICAL}.
     *
     * @param priority The int value to convert into a priority.
     * @return The Priority from the given value.
     */
    public static Priority fromInt(int priority) {
        if(priority >= 16) {
            return LOW;
        }
        else if (priority >= 11) {
            return MEDIUM;
        }
        else if (priority >= 6) {
            return HIGH;
        }
        else if (priority >= 2) {
            return IMPORTANT;
        }
        else {
            return CRITICAL;
        }
    }
}
