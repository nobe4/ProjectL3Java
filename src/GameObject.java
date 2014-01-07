import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;


/**
 * Created by Seb on 13/12/13.
 */

public abstract class GameObject {

    protected Body body;
    protected Shape shape;

    public GameObject() {

//        BodyDef bd = new BodyDef();
//        FixtureDef fixture = new FixtureDef();
    }

    public Vec2 getPosition() {
        return body.getPosition();
    }

    public void setPosition(Vec2 position) {
        body.setTransform(position, 0);
    }


}
