import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.*;

/**
 * Created by Seb on 13/12/13.
 */
public class GamePlatform extends GameObject {
    static public Body create(World world, float x, float y, float h, float w, float r) {
        Shape s = ShapeCreator.createBoxShape(w, h);
        FixtureDef f = FixtureDefCreator.createFixtureDef(s, 0, 0, 0);
        BodyDef bd = BodyDefCreator.createBodyDef(BodyType.STATIC);
        Body b = ObjectCreator.createObject(world, f, bd);
        b.setTransform(new Vec2(x, y), r);
        return b;
    }
}
