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
}
