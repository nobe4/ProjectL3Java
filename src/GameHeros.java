import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

/**
 * Created by Seb on 13/12/13.
 */
public class GameHeros extends GameCharacter {

    private static final GameHeros instance = new GameHeros();
    float width = 10f;
    float height = 10f;
    float xSpeed = 20;


    //    private static class GameHerosHolder {
    float ySpeed = 40;
//    }

    private GameHeros() {

    }

    public static GameHeros getInstance() {
        return GameHeros.instance;
    }

    /**
     * Used to initialized the heros body
     */
    public void init(World world, Vec2 position) {
        shape = ShapeCreator.createBoxShape(width, height);
        FixtureDef f = FixtureDefCreator.createFixtureDef(shape, 0.5f, 0.2f, 1f);
        BodyDef bd = BodyDefCreator.createBodyDef(BodyType.DYNAMIC);
        body = ObjectCreator.createObject(world, f, bd);
        body.setTransform(position, 0);
    }

    public void moveLeft() {
        System.out.println("moveLeft");
        instance.body.setLinearVelocity(instance.body.getLinearVelocity().add(new Vec2(-xSpeed, 0)));
    }

    public void moveRight() {
        System.out.println("moveRigth");
        instance.body.setLinearVelocity(instance.body.getLinearVelocity().add(new Vec2(xSpeed, 0)));
    }

    public void jump() {
        System.out.println("jump");
        instance.body.setLinearVelocity(instance.body.getLinearVelocity().add(new Vec2(0, ySpeed)));
    }
}
