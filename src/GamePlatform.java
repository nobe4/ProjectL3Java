import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

/**
 * Created by Seb on 13/12/13.
 */
public class GamePlatform extends GameObject {

    // todo why not directly as a constructor ?...
//    public static Body create(World world, float x, float y, float h, float w, float r) {
//        this.shape = ShapeCreator.createBoxShape(w, h);
//        FixtureDef f = FixtureDefCreator.createFixtureDef(this.shape, 0.9f, 0f, 1f);
//        BodyDef bd = BodyDefCreator.createBodyDef(BodyType.STATIC);
//        this.body = ObjectCreator.createObject(world, f, bd);
//        this.body.setTransform(new Vec2(x, y), r);
//        return this.body;
//    }

    //todo ....like this
    public GamePlatform(World world, float x, float y, float h, float w, float r) {
        shape = ShapeCreator.createBoxShape(w, h);
        FixtureDef f = FixtureDefCreator.createFixtureDef(shape, 0.9f, 0f, 1f);
        BodyDef bd = BodyDefCreator.createBodyDef(BodyType.STATIC);
        body = ObjectCreator.createObject(world, f, bd);
        body.setTransform(new Vec2(x, y), r);
    }
}
