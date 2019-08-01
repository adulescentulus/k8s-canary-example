package de.networkchallenge.howto.canary.frontend;

import de.networkchallenge.howto.canary.frontend.svg.Shape;
import de.networkchallenge.howto.canary.frontend.svg.Svg;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/remote")
public class RemoteSvgResource {

    @Inject
    @RestClient
    RectangleService rs;

    @Inject
    @RestClient
    CircleService cs;

    @GET
    @Produces("image/svg+xml")
    @Path("/RECTANGLE/{id}")
    public Response rect(@PathParam("id") String id) {
        return Response.ok(rs.getRectangle(id).getXml()).build();
    }

    @GET
    @Produces("image/svg+xml")
    @Path("/CIRCLE/{id}")
    public Response circle(@PathParam("id") String id) {
        return Response.ok(cs.getCircle(id).getXml()).build();
    }
}
