package rest;

import app.MandelbrotProperties;
import org.springframework.context.annotation.DependsOn;

import java.awt.*;

@DependsOn("mandelbrotProperties")
public class AnotherColorManager implements ColorManager {
    /**
     * number of colors per channel
     */
    public final int ccc = (int)Math.ceil(Math.pow(MandelbrotProperties.getMaxIteration(), 1.0/3));

    @Override
    public Color getColor (int cnt) {

        if (cnt == MandelbrotProperties.getMaxIteration()) return Color.BLACK;

        int r = (cnt % ccc) * (256/ccc);
        cnt = cnt / ccc;
        int g = (cnt % ccc) * (256/ccc);
        cnt = cnt / ccc;
        int b = cnt * (256/ccc);

        return new Color (r, g, b);
    }
}
