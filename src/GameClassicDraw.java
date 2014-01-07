import org.jbox2d.common.Color3f;
import org.jbox2d.common.Transform;
import org.jbox2d.common.Vec2;

import java.awt.*;
import java.util.Hashtable;

/**
 * Created by Seb on 13/12/13.
 */
public class GameClassicDraw implements GameDraw {
    private Hashtable<String, Component> objects;

    @Override
    public void drawPoint(Vec2 argPoint, float argRadiusOnScreen, Color3f argColor) {
//        getWorldToScreenToOut(argPoint, sp1);
//        Graphics2D g = getGraphics();
//
//        Color c = cpool.getColor(argColor.x, argColor.y, argColor.z);
//        g.setColor(c);
//        sp1.x -= argRadiusOnScreen;
//        sp1.y -= argRadiusOnScreen;
//        g.fillOval((int) sp1.x, (int) sp1.y, (int) argRadiusOnScreen * 2, (int) argRadiusOnScreen * 2);
    }

    @Override
    public void drawSolidPolygon(Vec2[] vec2s, int i, Color3f color3f) {

    }

    //
    @Override
    public void drawCircle(Vec2 vec2, float v, Color3f color3f) {
//        Vec2[] vecs = vec2Array.get(circlePoints);
//        generateCirle(center, radius, vecs, circlePoints);
//        drawPolygon(vecs, circlePoints, color);
    }

    @Override
    public void drawSolidCircle(Vec2 vec2, float v, Vec2 vec22, Color3f color3f) {

    }

    @Override
    public void drawSegment(Vec2 p1, Vec2 p2, Color3f color) {
//        getWorldToScreenToOut(p1, sp1);
//        getWorldToScreenToOut(p2, sp2);
//
//        Graphics2D g = getGraphics();
//        Color c = cpool.getColor(color.x, color.y, color.z);
//        g.setColor(c);
//
//        g.drawLine((int) sp1.x, (int) sp1.y, (int) sp2.x, (int) sp2.y);
    }

    @Override
    public void drawTransform(Transform transform) {

    }

    @Override
    public void drawString(float v, float v2, String s, Color3f color3f) {

    }


    @Override
    public Graphics2D getGraphics() {
        return null;
    }


    @Override
    public void setCamera(Vec2 position) {

    }

    @Override
    public Vec2 getCamera() {
        return null;
    }
}
