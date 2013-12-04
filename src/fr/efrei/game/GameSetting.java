package fr.efrei.game;

/**
 * Created by Seb on 04/12/13.
 */
public class GameSetting {
    /**
     * Whether the setting effects the engine's behavior or
     * modifies drawing.
     */
    public static enum SettingType {
        DRAWING, ENGINE
    }

    /**
     * The type of value this setting pertains to
     */
    public static enum ConstraintType {
        BOOLEAN, RANGE
    }

    public final String name;
    public final SettingType settingsType;
    public final ConstraintType constraintType;
    public boolean enabled;
    public int value;
    public final int min;
    public final int max;

    public GameSetting(String argName, SettingType argType, boolean argValue) {
        name = argName;
        settingsType = argType;
        enabled = argValue;
        constraintType = ConstraintType.BOOLEAN;
        min = max = value = 0;
    }

    public GameSetting(String argName, SettingType argType, int argValue, int argMinimum, int argMaximum) {
        name = argName;
        settingsType = argType;
        value = argValue;
        min = argMinimum;
        max = argMaximum;
        constraintType = ConstraintType.RANGE;
        enabled = false;
    }
}
