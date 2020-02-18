package rest;

import java.awt.*;

public class AnotherColorManager implements ColorManager {
    public final int ccc = 12;

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
