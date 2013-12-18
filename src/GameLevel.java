import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;

import java.util.Hashtable;

/**
 * Created by padawan on 12/11/13.
 */
public class GameLevel {
    private World world = null;
    private Body ground, box;
    private Hashtable<String, GameObject> objects;

    public GameLevel() {/*do nothing*/}

    void initWorld() {
        Vec2 gravity = new Vec2(0, -9.8f);
        world = new World(gravity);
    }

    void init() {
        //initialize world
        if (world == null) initWorld();

        //parseJSON("level1.json");

        ObjectCreator.createObject(world);
        for(int i = 0; i < 10; i++){
            GamePlatform.create(world,(i*50) + 100,(i*50) + 100,10,100);
        }

       /* //Ground definition
        {
                BodyDef groundDef = new BodyDef();
                groundDef.type = BodyType.STATIC;

            //add body to world
            ground = world.createBody(groundDef);
            FixtureDef fixtureGround = new FixtureDef();

            EdgeShape shapeGround = new EdgeShape();
            shapeGround.set(new Vec2(50.0f, -100.0f), new Vec2(100.0f, -300.0f));

            //set properties
            fixtureGround.shape = shapeGround;
            fixtureGround.density = 0.0f;
            fixtureGround.friction = 0.6f;

            //apply to body
            ground.createFixture(fixtureGround);
        }

        //box def
        {
            BodyDef boxDef = new BodyDef();
            boxDef.type = BodyType.DYNAMIC;
            boxDef.position.set(300f,-50f);
            boxDef.angle = 45f*0.0174532925199432957f;

            box = world.createBody(boxDef);

            PolygonShape shapeBox = new PolygonShape();
            shapeBox.setAsBox(10f, 10f);

            FixtureDef fixtureBox = new FixtureDef();
            fixtureBox.density = 1f;
            fixtureBox.shape = shapeBox;

            box.createFixture(fixtureBox);

            box.setLinearVelocity(new Vec2(-50f,5f));
           // box.setAngularVelocity(-90f*0.0174532925199432957f);
        }
        //Add other stuff here*/
    }

   /* private void parseJSON(String path) {
        File file = new File("./levels/level1.json");
        FileInputStream fis = null;
        String s = null;
        byte[] data = new byte[(int) file.length()];
        try {
            fis = new FileInputStream(file);
            fis.read(data);
            fis.close();
            s = new String(data, "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        JSONObject o = (JSONObject) JSONValue.parse(s);
        System.out.println(o.toString());
        JSONArray bodies = (JSONArray) o.get("bodies"); // get an array of all the bodies

        for (Object body : bodies) {
            ObjectCreator.createFromJSON((JSONObject) body, world);
        }
    }*/

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
