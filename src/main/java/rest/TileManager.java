package rest;

import mandelbrott.Block;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static java.awt.image.BufferedImage.TYPE_INT_ARGB;

@Service
public class TileManager {

    public final int TILE_SIZE = 256;
    public final double XLEFT = -2.5;
    public final double YTOP = 2;

    public double delta(int z) {
        return Math.pow(2, -z) * 4;
    }

    public byte[] getTextCoordTile(int z, int x, int y) throws IOException {
        BufferedImage image = new BufferedImage(TILE_SIZE, TILE_SIZE, TYPE_INT_ARGB);
        Graphics2D graphics = image.createGraphics();

        graphics.setColor(new Color(255, 0, 0));
        graphics.drawString(String.format("z=%s, x=%s, y=%s", z, x, y),0, 10);

        double delt = delta(z);
        double dd = delt / TILE_SIZE;

        double xx = delta(z) * x + XLEFT;
        double xxx = xx + delt - dd;

        double yy = YTOP - delta(z) * y;
        double yyy = yy - delt + dd;

        graphics.drawString(String.format("xmin=%s, xmax=%s", xx, xxx),0, 25);
        graphics.drawString(String.format("ytop=%s, ybottom=%s", yy, yyy),0, 40);

        graphics.setColor(new Color(128, 128, 128));
        graphics.drawRect(0, 0, 255, 255);



        return  image2byte(image);
    }

    public byte[] getTile(int z, long x, long y) throws IOException {
        BufferedImage image = new BufferedImage(TILE_SIZE, TILE_SIZE, TYPE_INT_ARGB);
        Graphics2D graphics = image.createGraphics();

      //  graphics.setColor(new Color(255, 0, 0));

        double delt = delta(z);
        double dd = delt / TILE_SIZE;

        double xx = delta(z) * x + XLEFT;
        double xxx = xx + delt - dd;

        double yy = YTOP - delta(z) * y;
        double yyy = yy - delt + dd;

        Block b = new Block(xx, yyy, dd, TILE_SIZE);
        b.calc(510);

      //  graphics.setColor(new Color(128, 128, 128));
      //  graphics.drawRect(0, 0, 255, 255);

        for (int ix = 0; ix < TILE_SIZE; ix++) {
            for (int iy = 0; iy < TILE_SIZE; iy++) {
                graphics.setColor(getColor(b.points[ix][iy].getCnt()));
                graphics.drawLine(ix, TILE_SIZE - iy - 1, ix, TILE_SIZE - iy);
            }
        }

//        graphics.setColor(new Color(0, 128, 128));
        //graphics.drawRect(0, 0, 255, 255);

        return  image2byte(image);
    }

    public final int ccc = 8;
    public Color getColor (int cnt) {
        int r = (cnt % ccc) * (256/ccc);
        cnt = cnt / ccc;
        int g = (cnt % ccc) * (256/ccc);
        cnt = cnt / ccc;
        int b = cnt * (256/ccc);

        return new Color (r, g, b);
    }

    public byte[] image2byte(BufferedImage image) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write( image, "png", baos);
        return baos.toByteArray();
    }
}