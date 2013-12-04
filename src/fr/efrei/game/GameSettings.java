package fr.efrei.game;

import fr.efrei.game.GameSetting.SettingType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Seb on 04/12/13.
 */
public class GameSettings {
    public static final String Hz = "Hz";
    public static final String PositionIterations = "Pos Iters";
    public static final String VelocityIterations = "Vel Iters";
    public static final String AllowSleep = "Sleep";
    public static final String WarmStarting = "Warm Starting";
    public static final String SubStepping = "SubStepping";
    public static final String ContinuousCollision = "Continuous Collision";
    public static final String DrawShapes = "Shapes";
    public static final String DrawJoints = "Joints";
    public static final String DrawAABBs = "AABBs";
    public static final String DrawContactPoints = "Contact Points";
    public static final String DrawContactNormals = "Contact Normals";
    public static final String DrawContactImpulses = "Contact Impulses";
    public static final String DrawFrictionImpulses = "Friction Impulses";
    public static final String DrawCOMs = "Center of Mass";
    public static final String DrawStats = "Stats";
    public static final String DrawHelp = "Help";
    public static final String DrawTree = "Dynamic Tree";
    private final HashMap<String, GameSetting> settingsMap;
    public boolean pause = false;
    public boolean singleStep = false;
    private ArrayList<GameSetting> settings;

    public GameSettings() {
        settings = new ArrayList<GameSetting>();
        settingsMap = new HashMap<String, GameSetting>();
        populateDefaultSettings();
    }

    private void populateDefaultSettings() {
        addSetting(new GameSetting(Hz, SettingType.ENGINE, 60, 1, 400));
        addSetting(new GameSetting(PositionIterations, SettingType.ENGINE, 3, 0, 100));
        addSetting(new GameSetting(VelocityIterations, SettingType.ENGINE, 8, 1, 100));
        addSetting(new GameSetting(AllowSleep, SettingType.ENGINE, true));
        addSetting(new GameSetting(WarmStarting, SettingType.ENGINE, true));
        addSetting(new GameSetting(ContinuousCollision, SettingType.ENGINE, true));
        addSetting(new GameSetting(SubStepping, SettingType.ENGINE, false));
        addSetting(new GameSetting(DrawShapes, SettingType.DRAWING, true));
        addSetting(new GameSetting(DrawJoints, SettingType.DRAWING, true));
        addSetting(new GameSetting(DrawAABBs, SettingType.DRAWING, false));
        addSetting(new GameSetting(DrawContactPoints, SettingType.DRAWING, false));
        addSetting(new GameSetting(DrawContactNormals, SettingType.DRAWING, false));
        addSetting(new GameSetting(DrawContactImpulses, SettingType.DRAWING, false));
        addSetting(new GameSetting(DrawFrictionImpulses, SettingType.DRAWING, false));
        addSetting(new GameSetting(DrawCOMs, SettingType.DRAWING, false));
        addSetting(new GameSetting(DrawStats, SettingType.DRAWING, false));
        addSetting(new GameSetting(DrawHelp, SettingType.DRAWING, true));
        addSetting(new GameSetting(DrawTree, SettingType.DRAWING, false));
    }

    /**
     * Adds a settings to the settings list
     *
     * @param argSetting
     */
    public void addSetting(GameSetting argSetting) {
        if (settingsMap.containsKey(argSetting.name)) {
            throw new IllegalArgumentException("Settings already contain a setting with name: "
                    + argSetting.name);
        }
        settings.add(argSetting);
        settingsMap.put(argSetting.name, argSetting);
    }

    /**
     * Returns an unmodifiable list of settings
     *
     * @return
     */
    public List<GameSetting> getSettings() {
        return Collections.unmodifiableList(settings);
    }

    /**
     * Gets a setting by name.
     *
     * @param argName
     * @return
     */
    public GameSetting getSetting(String argName) {
        return settingsMap.get(argName);
    }
}