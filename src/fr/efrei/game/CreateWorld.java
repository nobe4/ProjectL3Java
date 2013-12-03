package fr.efrei.game;

import org.jbox2d.callbacks.DebugDraw;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Color3f;
import org.jbox2d.common.IViewportTransform;
import org.jbox2d.common.Transform;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.*;

/**
 * Created with IntelliJ IDEA.
 * User: Seb
 * Date: 01/12/13
 * Time: 18:38
 * To change this template use File | Settings | File Templates.
 */
public class CreateWorld {

    public static void InitWorld(){
        Vec2 gravity = new Vec2(0.0f, -10.0f);
//        boolean doSleep = true;
        World world = new World(gravity);

        //Init ground body
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(0.0f, -10.0f);
        Body groundBody = world.createBody(bodyDef);

        //Create the ground polygon
        PolygonShape groundBox = new PolygonShape();
        groundBox.setAsBox(50.0f, 10.0f);
        groundBody.createFixture(groundBox, 0.0f);

        //Create a dynamic body
        bodyDef.position.set(0.0f,4.0f);
        Body body = world.createBody(bodyDef);
        
        //Create the shape of this body
        PolygonShape dynamicBox = new PolygonShape();
        dynamicBox.setAsBox(1.0f,1.0f);


        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = dynamicBox;
        fixtureDef.density = 1.0f;
        fixtureDef.friction = 0.3f;

        body.createFixture(fixtureDef);

        //Start simulation
        float timeStep = 1.0f / 60.0f;
        int velocityIterations = 8;
        int positionIterations = 3;
        world.step(timeStep, velocityIterations, positionIterations);

        //activate debug draw
        IViewportTransform view;
//        DebugDraw draw = new Debug(view);
//        world.setDebugDraw(draw);






        while (true)
        {

        }
    }

}
