import org.jbox2d.common.Color3f;
import org.jbox2d.common.Transform;
import org.jbox2d.common.Vec2;

import java.awt.*;

/**
 * Created by Seb on 13/12/13.
 */
public interface GameDraw {
    public void drawPoint(Vec2 argPoint, float argRadiusOnScreen, Color3f argColor);

    public void drawSolidPolygon(Vec2[] vec2s, int i, Color3f color3f);

    public void drawCircle(Vec2 vec2, float v, Color3f color3f);

    public void drawSolidCircle(Vec2 vec2, float v, Vec2 vec22, Color3f color3f);

    public void drawSegment(Vec2 p1, Vec2 p2, Color3f color);

    public void drawTransform(Transform transform);

    public void drawString(float v, float v2, String s, Color3f color3f);

    public Graphics2D getGraphics();

}
