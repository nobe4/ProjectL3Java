import org.jbox2d.callbacks.DebugDraw;

/**
 * Created by padawan on 12/11/13.
 */
public class GameModel {
    private GameSettings settings;
    private GameLevel level;
    private GameHeros heros;

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

    public GameHeros getHeros() {
        return heros;
    }

    public void setHeros(GameHeros heros) {
        this.heros = heros;
    }

    public void setDebugDraw(GamePanel panel) {
        System.out.println("setDebugDraw : Enter");
        // todo Could be better to grab settings instead of the current way
        DebugDraw dbSettings = new GameDebugDraw(panel);
        dbSettings.setFlags(DebugDraw.e_shapeBit);

        //Set debug on world
        level.getWorld().setDebugDraw(dbSettings);
        System.out.println("setDebugDraw  : End");
    }
}
