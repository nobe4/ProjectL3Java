package polling;

import java.awt.*;
import java.util.HashMap;

/**
 * Created by Seb on 12/12/13.
 */
public class ColorPool {

    private final ColorKey queryKey = new ColorKey();
    private HashMap<ColorKey, Color> colorMap = new HashMap<ColorKey, Color>();

    public Color getColor(float r, float g, float b, float alpha) {

        queryKey.set(r, g, b, alpha);
        if (colorMap.containsKey(queryKey)) {
            return colorMap.get(queryKey);
        } else {
            Color c = new Color(r, g, b, alpha);
            ColorKey ck = new ColorKey();
            ck.set(r, g, b, alpha);
            colorMap.put(ck, c);
            return c;
        }
    }

    public Color getColor(float r, float g, float b) {
        return getColor(r, g, b, 1);
    }
}

class ColorKey {
    float r, g, b, a;

    public void set(float argR, float argG, float argB) {
        set(argR, argG, argB, 1);
    }

    public void set(float argR, float argG, float argB, float argA) {
        r = argR;
        g = argG;
        b = argB;
        a = argA;
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Float.floatToIntBits(a);
        result = prime * result + Float.floatToIntBits(b);
        result = prime * result + Float.floatToIntBits(g);
        result = prime * result + Float.floatToIntBits(r);
        return result;
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ColorKey other = (ColorKey) obj;
        if (Float.floatToIntBits(a) != Float.floatToIntBits(other.a))
            return false;
        if (Float.floatToIntBits(b) != Float.floatToIntBits(other.b))
            return false;
        if (Float.floatToIntBits(g) != Float.floatToIntBits(other.g))
            return false;
        if (Float.floatToIntBits(r) != Float.floatToIntBits(other.r))
            return false;
        return true;
    }
}