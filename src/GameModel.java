import java.util.Vector;

/**
 * Created by padawan on 12/11/13.
 */
public class GameModel {

    public static interface LevelChangedListener {
        public void levelChanged(GameLevel level);
    }

    private GameSettings settings;
    private GameLevel level;
    private final Vector<LevelChangedListener> listeners = new Vector<LevelChangedListener>();

    //private GameHeros heros;

    public GameModel() {
        settings = new GameSettings();
        level = new GameLevel();
        level.init();

    }

    public GameSettings getSettings() {
        return settings;
    }

    public void setSettings(GameSettings settings) {
        this.settings = settings;
    }

    public GameLevel getLevel() {
        return level;
    }

    public void setLevel(GameLevel level) {
        this.level = level;
    }

    public void setCurrentLevel(int currentLevelIndex) {
        for (LevelChangedListener listener : listeners) {
            listener.levelChanged(level);
        }
    }

    public void addLevelChangeListener(LevelChangedListener argListener) {
        listeners.add(argListener);
    }

}
