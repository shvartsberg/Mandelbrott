package rest;

import org.springframework.stereotype.Service;

import java.awt.*;

/**
 * 8 bit per color, 8*8*8 different colors
 */
@Service
public class BasicColorManager implements ColorManager {

    public final int ccc = 8;

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
