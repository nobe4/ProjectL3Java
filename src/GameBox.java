import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

/**
 * Created with IntelliJ IDEA.
 * User: Seb
 * Date: 08/01/14
 * Time: 19:24
 * To change this template use File | Settings | File Templates.
 */
public class GameBox extends GameObject {

    public GameBox(World world, float x, float y, float h, float w, float r) {
        shape = ShapeCreator.createBoxShape(w, h);
        FixtureDef f = FixtureDefCreator.createFixtureDef(shape, 0.9f, 0f, 1f);
        BodyDef bd = BodyDefCreator.createBodyDef(BodyType.DYNAMIC);
        body = ObjectCreator.createObject(world, f, bd);
        body.setTransform(new Vec2(x, y), r);
    }
}
