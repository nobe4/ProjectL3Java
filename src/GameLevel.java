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


    private Vec2 initCoords = new Vec2(50, 50);

    public GameLevel() {/*do nothing*/}

    void initWorld() {
        Vec2 gravity = new Vec2(0, -9.8f);
        world = new World(gravity);
    }

    void init() {
        //initialize world
        if (world == null) initWorld();
        //parseJSON("level1.json");


        GamePlatform b = new GamePlatform(world, 0, -300, 10f, 300f, 0f);

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