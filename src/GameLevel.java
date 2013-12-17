import org.jbox2d.collision.AABB;
import org.jbox2d.collision.shapes.EdgeShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

import java.util.Hashtable;

/**
 * Created by padawan on 12/11/13.
 */
public class GameLevel {
    private World world = null;
    private Body ground;
    private Hashtable<String, GameObject> objects;

    public GameLevel() {/*do nothing*/}


    void initWorld(){
        Vec2 gravity = new Vec2(0, -10f);
        world = new World(gravity);
    }

    void init() {
        //initialize world
        if(world == null) initWorld();

        //Ground definition
        {

            BodyDef bd = new BodyDef();

            //add body to world
            ground = world.createBody(bd);
            FixtureDef fd = new FixtureDef();

            EdgeShape shape = new EdgeShape();
            shape.set(new Vec2(50.0f, -10.0f), new Vec2(100.0f, -30.0f));


            //set properties
            fd.shape = shape;
            fd.density = 0.0f;
            fd.friction = 0.6f;

            //apply to body
            ground.createFixture(fd);
        }
        //Add other stuff here
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public Body getGround() {
        return ground;
    }

    public void setGround(Body ground) {
        this.ground = ground;
    }

    public Hashtable<String, GameObject> getObjects() {
        return objects;
    }

    public void setObjects(Hashtable<String, GameObject> objects) {
        this.objects = objects;
    }
}
