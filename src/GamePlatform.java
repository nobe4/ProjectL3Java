import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;

/**
 * Created by Seb on 13/12/13.
 */
public class GamePlatform extends GameObject {
    static public Body create(World world, float x, float y, float h, float w) {
        Body b = ObjectCreator.createObject(world);
        b.setTransform(new Vec2(x,y),0);
        return b;
    }
}
