/**
 * Created by padawan on 12/11/13.
 */
public class GameModel {
    private GameSettings settings;
    private GameLevel level;

    //remove from here, will be in GameLevel (because heros has to be with other GameObjects)
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

//    public GameHeros getHeros() {
//        return heros;
//    }

//    public void setHeros(GameHeros heros) {
//        this.heros = heros;
//    }
}
