package com.coddicted.scheduler;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

@Path("generic")
public class TestRest {
    //@SuppressWarnings("unused")
    @Context
    private UriInfo context;

    /**
     * Default constructor. 
     */
    public TestRest() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Retrieves representation of an instance of TestRest
     * @return an instance of String
     */
    @GET
    @Produces("text/plain")
    public String getText() {
    	return "Hello from Rest";
    }

    /**
     * PUT method for updating or creating an instance of TestRest
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/plain")
    public void putText(String content) {
    }

}