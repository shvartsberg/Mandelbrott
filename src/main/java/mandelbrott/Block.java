package mandelbrott;

import org.springframework.util.StopWatch;

import java.io.Serializable;
import java.util.Date;


public class Block implements Serializable {
    int width;
    double x, y, delta;

    public Point[][] points;

    public Block(double x, double y, double delta, int width) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.delta = delta;

        points = new Point[width][width];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                points[i][j] = new Point((x + delta *i) + "", (y + delta * j) + "");
            }
        }
    }

    public int calc(int maxiteration) {

        StopWatch w = new StopWatch();
        w.start();

        int cnt = 0;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                Point p = points[i][j];
                cnt += p.iterate(maxiteration);
            }
        }

        w.stop();

        System.out.println(w.getTotalTimeMillis() + " " + Thread.currentThread().getName());

        return cnt;
    }
}
