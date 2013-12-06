package org.jbox2d.testbed.tests;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.testbed.framework.TestbedTest;

/**
 * Created with IntelliJ IDEA.
 * User: padawan
 * Date: 12/6/13
 * Time: 4:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyTest extends TestbedTest {

    private boolean firstTime = true;
    @Override
    public void initTest(boolean deserialized) {
        if (firstTime) {
            setCamera(new Vec2(0,2), 35f);
            firstTime = false;
        }

        Body ground = null;
        {
            BodyDef bd = new BodyDef();
            bd.position.set(0.0f, 0.0f);
            ground = getWorld().createBody(bd);
            PolygonShape shape = new PolygonShape();
            shape.setAsBox(5.0f, 0.5f);
            ground.createFixture(shape, 0);
        }
    }

    @Override
    public String getTestName() {
        return "MyTest";
    }
}
