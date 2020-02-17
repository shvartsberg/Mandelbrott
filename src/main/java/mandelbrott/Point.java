package mandelbrott;

import java.io.Serializable;

public class Point implements Serializable {
    double x0, y0;

    public final double R = 20;

    int cnt = 0;
    boolean over = false;
    public Point(String x, String y) {
        x0 = Double.parseDouble(x);
        y0 = Double.parseDouble(y);

    }

    double xi = 0;
    double yi = 0;

    // i -> i+1
    public void iterate() {
        if (over) return;

        double xi2 = xi * xi;
        double yi2 = yi * yi;
        double x = xi2 - yi2 + x0;
        double y = 2 * xi * yi + y0;

        cnt++;
        xi = x;
        yi = y;

        if (xi2 + yi2 > R)
            over = true;
    }

    public int iterate(int maxiteration) {
        while (!over && cnt < maxiteration) {
            iterate();
        }
        return cnt;
    }

    public int getCnt() {
        return  cnt;
    }
}

