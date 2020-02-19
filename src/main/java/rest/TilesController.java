package rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/tiles")
public class TilesController {

    @Autowired
    TileManager tileManager;

    @RequestMapping("/")
    String hello() {
        return "future map!";
    }

    @RequestMapping(value="/{z}/{x}/{y}", produces = {"image/png"})
    public byte[] getTile(@PathVariable("z") int z, @PathVariable("x") long x, @PathVariable("y") long y) throws IOException {
        return tileManager.getTile(z, x, y);
    }
}
