package de.networkchallenge.howto.canary.rectangle;


import de.networkchallenge.howto.canary.rectangle.svg.Shape;
import de.networkchallenge.howto.canary.rectangle.svg.Svg;
import de.networkchallenge.howto.canary.rectangle.svg.SvgJson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/local")
public class LocalSvgResource {

    @GET
    @Produces("image/svg+xml")
    @Path("/svg/{shape}/{id}")
    public Response svg(@PathParam("shape") String shape, @PathParam("id") String id) {
        return Response.ok(new Svg(200, 100, id, Shape.valueOf(shape),
                new ContainerInfo().getInfo()).toString()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/json/{shape}/{id}")
    public SvgJson json(@PathParam("shape") String shape, @PathParam("id") String id) {
        SvgJson json = new SvgJson();
        json.setXml(new Svg(200, 100, id, Shape.valueOf(shape),
                new ContainerInfo().getInfo()).toString());
        return json;
    }

}