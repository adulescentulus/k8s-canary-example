package de.networkchallenge.howto.canary.frontend;

import de.networkchallenge.howto.canary.frontend.svg.SvgJson;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/local")
@RegisterRestClient
@Singleton
public interface RectangleService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/json/RECTANGLE/{id}")
    SvgJson getRectangle(@PathParam("id") String id);
}
