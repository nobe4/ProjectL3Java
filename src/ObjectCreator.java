import org.jbox2d.collision.shapes.EdgeShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.collision.shapes.ShapeType;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.*;

public class ObjectCreator {

    static public Body createObject(World w){
        BodyDef bd = BodyDefCreator.defaultBodyDef();

        FixtureDef f = FixtureDefCreator.defaultFixtureDef();

        Body b = w.createBody(bd);

        b.createFixture(f);
        return b;
    }
}

class ShapeCreator {
    static public Shape defaultShape() {
        return createShape(ShapeType.POLYGON);
    }

    // todo make private
    static private Shape createShape(ShapeType type) {
        Shape s = null;

        if (type == ShapeType.EDGE) s = createEdgeShape(); // todo add position
        else if (type == ShapeType.POLYGON) s = createBoxShape(); // todo only handle boxes
        else if (type == ShapeType.CIRCLE) System.err.println("Not handled");
        else if (type == ShapeType.CHAIN) System.err.println("Not handled");
        else System.err.println("Not handled");

        return s;
    }

    static private EdgeShape createEdgeShape() {
        EdgeShape s = new EdgeShape();
        s.set(new Vec2(0f, 0f), new Vec2(0f, 0f));
        return s;
    }

    static private PolygonShape createBoxShape(){
        PolygonShape s = new PolygonShape();
        s.setAsBox(10f, 10f);
        return s;
    }
}

class FixtureDefCreator {
    static public FixtureDef defaultFixtureDef() {
        return createFixtureDef(ShapeCreator.defaultShape(), 0f, 0f, 0f);
    }

    // todo verify and make private
    static public FixtureDef createFixtureDef(Shape s, float friction, float restitution, float density) {
        FixtureDef f = new FixtureDef();
        f.shape = s;
        f.friction = friction;
        f.density = density;
        f.restitution = restitution;
        return f;
    }
}

class BodyDefCreator {
    static public BodyDef defaultBodyDef() {
        return createBodyDef(BodyType.DYNAMIC, new Vec2(100f, -100f), 45);
    }

    static private BodyDef createBodyDef(BodyType t, Vec2 p, float a) {
        BodyDef b = new BodyDef();
        b.type = t;
        b.position = p;
        b.angle = a * 0.0174532925199432957f;
        return b;
    }
}



 /*
    static public void createFromJSON(JSONObject o, World w) {

        if (o.get("type").equals("basic")) {
            createBasicBody2(((JSONArray) o.get("proprieties")), w);
        } else {
            System.err.println("Not handled now ...");
            // todo add other classes
        }
    }

    private static void createBasicBody(JSONObject o, World w) {
        System.out.println("Create a basic body");

        // BodyDef definition
        BodyDef bodyDefinition = new BodyDef();

        JSONObject jsonBodydef = (JSONObject) o.get("body");
        String type = (String) jsonBodydef.get("type");

        if (type.equals("dynamic")) bodyDefinition.type = BodyType.DYNAMIC;
        else if (type.equals("kinematic")) bodyDefinition.type = BodyType.KINEMATIC;
        else bodyDefinition.type = BodyType.STATIC;


        // Shape definition
        Shape shapeDefinition = null;
        JSONObject jsonShapedef = (JSONObject) o.get("shape");
        if (jsonShapedef.get("type").equals("edgeShape")) {

            shapeDefinition = new EdgeShape();
            JSONArray positions = (JSONArray) jsonShapedef.get("positions");

            // Default First and Second shape
            Vec2 f = new Vec2(100f, 100f);
            Vec2 s = new Vec2(200f, 200f);

            if (positions.size() != 0) {
                f.set(Float.parseFloat((((JSONArray) positions.get(0)).get(0)).toString()), Float.parseFloat((((JSONArray) positions.get(0)).get(1)).toString()));
                s.set(Float.parseFloat((((JSONArray) positions.get(1)).get(0)).toString()), Float.parseFloat((((JSONArray) positions.get(1)).get(1)).toString()));
            }
        } else if (jsonShapedef.get("type").equals("chainShape")) shapeDefinition = new ChainShape();
        else if (jsonShapedef.get("type").equals("circleShape")) shapeDefinition = new CircleShape();
        else shapeDefinition = new PolygonShape();
        //todo build other propreties

        // FixtureDef Definition
        FixtureDef fixtureDefinition = new FixtureDef();
        JSONObject jsonFixturedef = (JSONObject) o.get("fixture");
        fixtureDefinition.shape = shapeDefinition;
        fixtureDefinition.density = Float.parseFloat(jsonFixturedef.get("density").toString());
        fixtureDefinition.friction = Float.parseFloat(jsonFixturedef.get("friction").toString());

        System.out.println(fixtureDefinition.density);
        System.out.println(fixtureDefinition.friction);

        //if(fixtureDefinition.density == null) fixtureDefinition.density = 0.0f;
        //if(fixtureDefinition.density == null) fixtureDefinition.density = 0.0f;




        /*

            //add body to world
            ground = world.createBody(groundDef);
            FixtureDef fixtureGround = new FixtureDef();

            //set properties
            fixtureGround.shape = shapeGround;
            fixtureGround.density = 0.0f;
            fixtureGround.friction = 0.6f;

            //apply to body
            ground.createFixture(fixtureGround);


    }

    private static void createBasicBody2(JSONArray o, World w) {
        Iterator iterator = o.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getClass());
        }
    }*/
