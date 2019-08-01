package de.networkchallenge.howto.canary.rectangle;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class HeaderMetadataFilter implements ContainerResponseFilter {

    @Context
    HttpServletResponse response;

    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
        response.addHeader("X-DEBUG-INSTANCE", String.join(", ", new ContainerInfo().getInfo()));
    }
}
