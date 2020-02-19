package rest;

import app.MandelbrotProperties;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import java.awt.*;

/**
 * 8 bit per color, 8*8*8 different colors
 */
@Service
@DependsOn("mandelbrotProperties")
public class BasicColorManager implements ColorManager {

    /**
     * number of colors per channel
     */
    public final int ccc = (int)Math.round(Math.pow(MandelbrotProperties.getMaxIteration(), 1/3));

    @Override
    public Color getColor (int cnt) {
        int r = (cnt % ccc) * (256/ccc);
        cnt = cnt / ccc;
        int g = (cnt % ccc) * (256/ccc);
        cnt = cnt / ccc;
        int b = cnt * (256/ccc);

        return new Color (r, g, b);
    }
}
