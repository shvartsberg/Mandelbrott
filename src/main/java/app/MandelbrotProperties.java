package app;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Configuration
@ConfigurationProperties(prefix="mandelbrot")
@Service("mandelbrotProperties")
public class MandelbrotProperties {
    public static double getR() {
        return R;
    }

    public static void setR(double r) {
        R = r;
    }

    protected static double R;

    public static int getMaxIteration() {
        return maxIteration;
    }

    public static void setMaxIteration(int maxIteration) {
        MandelbrotProperties.maxIteration = maxIteration;
    }

    protected static int maxIteration;

    public static int getTileSize() {
        return tileSize;
    }

    public static void setTileSize(int tileSize) {
        MandelbrotProperties.tileSize = tileSize;
    }

    protected static int tileSize;
}
