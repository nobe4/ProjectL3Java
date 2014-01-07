import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

/**
 * Created by Seb on 13/12/13.
 */
public class GameMob extends GameCharacter {
    public GameMob(World world, float x, float y, float h, float w, float r) {
        shape = ShapeCreator.createBoxShape(w, h);
        FixtureDef f = FixtureDefCreator.createFixtureDef(shape, 0.9f, 0f, 1f);
        BodyDef bd = BodyDefCreator.createBodyDef(BodyType.KINEMATIC);
        body = ObjectCreator.createObject(world, f, bd);
        body.setTransform(new Vec2(x, y), r);
    }
}

