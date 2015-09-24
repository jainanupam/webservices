package com.coddicted;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@ApplicationPath("/MeetingScheduler")
@Path("/restfulpath")
public class REST {

	public REST(){
		
	}
	
	@GET
	@Produces("text/xml")
	public Object get(){
		return "Hello World";
	}
	
	@PUT
	@Consumes("text/xml")
	public void put(String content){
		
	}
}
