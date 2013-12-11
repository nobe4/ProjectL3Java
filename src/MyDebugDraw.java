import org.jbox2d.callbacks.DebugDraw;
import org.jbox2d.common.*;

/**
 * Created by padawan on 12/11/13.
 */
public class MyDebugDraw extends DebugDraw{
    public MyDebugDraw() {
        super(new OBBViewportTransform());
        viewportTransform.setYFlip(true); // up is y rising
    }

    @Override
    public void drawPoint(Vec2 vec2, float v, Color3f color3f) {
    }

    @Override
    public void drawSolidPolygon(Vec2[] vec2s, int i, Color3f color3f) {

    }

    @Override
    public void drawCircle(Vec2 vec2, float v, Color3f color3f) {

    }

    @Override
    public void drawSolidCircle(Vec2 vec2, float v, Vec2 vec22, Color3f color3f) {

    }

    @Override
    public void drawSegment(Vec2 vec2, Vec2 vec22, Color3f color3f) {

    }

    @Override
    public void drawTransform(Transform transform) {

    }

    @Override
    public void drawString(float v, float v2, String s, Color3f color3f) {

    }
}
