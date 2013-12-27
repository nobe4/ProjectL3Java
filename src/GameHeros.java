import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

/**
 * Created by Seb on 13/12/13.
 */
public class GameHeros extends GameCharacter {

    float width = 40f;
    float height = 50f;


//    private static class GameHerosHolder {

    private static final GameHeros instance = new GameHeros();
//    }

    private GameHeros() {
        System.out.println("constructor");
        //todo may need a better one
        //body must be initialized in an external function
    }

    /**
     * Used to initialized the heros body
     */
    public void init(World world, Vec2 position) {
        System.out.println("init");
        shape = ShapeCreator.createBoxShape(width, height);
        FixtureDef f = FixtureDefCreator.createFixtureDef(shape, 0.5f, 0.5f, 1f);
        BodyDef bd = BodyDefCreator.createBodyDef(BodyType.DYNAMIC);
        body = ObjectCreator.createObject(world, f, bd);
        body.setTransform(position, 0);

        //Set heros position in class
    }

    public static GameHeros getInstance() {
//        return GameHerosHolder.instance;
        return GameHeros.instance;
    }

}
