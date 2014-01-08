import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;

import java.util.Hashtable;

/**
 * Created by padawan on 12/11/13.
 */
public class GameLevel {
    private World world = null;
    private Body ground;

    //GameObjects list
    private Hashtable<String, GameObject> objects;
    private GameHeros heros;
    private int nbBox = 0;


    public Vec2 getInitCoords() {
        return initCoords;
    }

    public void setInitCoords(Vec2 initCoords) {
        this.initCoords = initCoords;
    }

    private Vec2 initCoords = new Vec2(100f, 10f);

    public GameLevel() {/*do nothing*/}

    void initWorld() {
        Vec2 gravity = new Vec2(0, -9.8f);
        world = new World(gravity);
    }

    void init() {
        //initialize world
        if (world == null) initWorld();

        //Init Hashtable
        objects = new Hashtable<String, GameObject>();
        //parseJSON("level1.json");

        //ground
        objects.put("ground", new GamePlatform(world, 0f, -500f, 10f, 800f, 0f));

        //left wall
        objects.put("leftWall", new GamePlatform(world, 0f, -400f, 100f, 10f, 0f));

        //right wall
        objects.put("rightWall", new GamePlatform(world, 800f, -400f, 100f, 10f, 0f));

        //First platform
        objects.put("firstPlatform", new GamePlatform(world, 200f, -450f, 10f, 50f, 0f));

        //Second platform
        objects.put("secondPlatform", new GamePlatform(world, 400f, -400f, 10f, 50f, 0f));

        //Third platform
        objects.put("thirdPlatform", new GamePlatform(world, 600f, -350f, 10f, 50f, 0f));

        //put rotated platform
        objects.put("rotate", new GamePlatform(world, 100f, -300f, 10f, 60f, 15f));

        //moving object
        GameMob mob = new GameMob(world, 250f, -325f, 10f, 50f, 0f);
        mob.body.setAngularVelocity(0.25f);
        mob.body.setAngularDamping(0.4f);
        objects.put("kine", mob);


        //init heros
        heros = GameHeros.getInstance();
        heros.init(world, initCoords);
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

    public GameHeros getHeros() {
        return heros;
    }


    public void addDynamicObject() {
        String s = "box" + nbBox;
        objects.put(s, new GameBox(world, 600f, -150f, 10f, 10f, 0f));
    }
}


   /*private void parseJSON(String path) {
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