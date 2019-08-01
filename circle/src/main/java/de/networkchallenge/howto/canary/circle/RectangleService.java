package de.networkchallenge.howto.canary.circle;

import de.networkchallenge.howto.canary.circle.svg.SvgJson;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/local")
@RegisterRestClient
@Singleton
public interface RectangleService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/json/RECTANGLE/{id}")
    SvgJson getRectangle(@PathParam("id") String id);
}
