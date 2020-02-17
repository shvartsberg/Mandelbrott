package rest;
/*
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.io.ByteArrayInputStream;
import java.io.IOException;


@Path("/tiles")
@Stateless
public class tiles {

    TileManager tileManager = new TileManager();

    @GET
    @Produces("image/png")
    @Path("/{z}/{x}/{y}")
    public Response getTile(@PathParam("z") int z,@PathParam("x") long x, @PathParam("y") long y) throws IOException {

        return Response.ok(new ByteArrayInputStream(tileManager.getTile(z, x, y))).build();
        //return "" + z + x + y + "";

    }
}
*/