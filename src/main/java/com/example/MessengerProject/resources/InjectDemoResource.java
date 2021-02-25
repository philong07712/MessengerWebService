package com.example.MessengerProject.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {

    @GET
    @Path("annotations")
    public String getParamsUsingAnnotations(@MatrixParam("param") String matrixParam,
                                            @HeaderParam("customContentType") String contentType,
                                            @CookieParam("name") String cookie) {
        return "Matrix param: " + matrixParam + " custom content type: " + contentType + " cookie: " + cookie;
    }

    @GET
    @Path("context")
    public String getContext(@Context UriInfo uriInfo,
                             @Context HttpHeaders httpHeaders) {
        String data = uriInfo.getAbsolutePath().toString();
        data += "Cookie: " + httpHeaders.getCookies();
        return data;
    }
}
