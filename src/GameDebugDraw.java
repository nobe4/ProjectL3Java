import org.jbox2d.callbacks.DebugDraw;
import org.jbox2d.common.*;
import org.jbox2d.pooling.arrays.Vec2Array;
import polling.ColorPool;

import java.awt.*;

/**
 * Created by padawan on 12/11/13.
 */
public class GameDebugDraw extends DebugDraw implements GameDraw {

    public static int circlePoints = 13;

    private final GamePanel panel;

    private final ColorPool cpool = new ColorPool();
    Vec2 sp1 = new Vec2();
    Vec2 sp2 = new Vec2();
    private final Vec2Array vec2Array = new Vec2Array();

    // todo Not sure to keep like this
    public GameDebugDraw() {
        super(null);
        panel = null;
    }

    public GameDebugDraw(GamePanel argPanel) {
        super(new OBBViewportTransform());
        viewportTransform.setYFlip(true); // up is y rising
        panel = argPanel;
    }

    @Override
    public void drawPoint(Vec2 argPoint, float argRadiusOnScreen, Color3f argColor) {
        getWorldToScreenToOut(argPoint, sp1);
        Graphics2D g = getGraphics();

        Color c = cpool.getColor(argColor.x, argColor.y, argColor.z);
        g.setColor(c);
        sp1.x -= argRadiusOnScreen;
        sp1.y -= argRadiusOnScreen;
        g.fillOval((int) sp1.x, (int) sp1.y, (int) argRadiusOnScreen * 2, (int) argRadiusOnScreen * 2);
    }

    @Override
    public void drawSolidPolygon(Vec2[] vec2s, int i, Color3f color3f) {

    }

    //
    @Override
    public void drawCircle(Vec2 center, float radius, Color3f color) {
        Vec2[] vecs = vec2Array.get(circlePoints);
        generateCirle(center, radius, vecs, circlePoints);
        drawPolygon(vecs, circlePoints, color);
    }

    @Override
    public void drawSolidCircle(Vec2 vec2, float v, Vec2 vec22, Color3f color3f) {

    }

    @Override
    public void drawSegment(Vec2 p1, Vec2 p2, Color3f color) {
        getWorldToScreenToOut(p1, sp1);
        getWorldToScreenToOut(p2, sp2);

        Graphics2D g = getGraphics();
        Color c = cpool.getColor(color.x, color.y, color.z);
        g.setColor(c);

        g.drawLine((int) sp1.x, (int) sp1.y, (int) sp2.x, (int) sp2.y);
    }

    @Override
    public void drawTransform(Transform transform) {

    }

    @Override
    public void drawString(float v, float v2, String s, Color3f color3f) {

    }

    @Override
    public Graphics2D getGraphics() {
        return panel.getDBGraphics();
    }

    // CIRCLE GENERATOR

    private void generateCirle(Vec2 argCenter, float argRadius, Vec2[] argPoints, int argNumPoints) {
        float inc = MathUtils.TWOPI / argNumPoints;

        for (int i = 0; i < argNumPoints; i++) {
            argPoints[i].x = (argCenter.x + MathUtils.cos(i * inc) * argRadius);
            argPoints[i].y = (argCenter.y + MathUtils.sin(i * inc) * argRadius);
        }
    }
}
