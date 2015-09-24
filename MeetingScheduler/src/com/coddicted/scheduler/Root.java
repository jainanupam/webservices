package com.coddicted.scheduler;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path(value="/root")
public class Root {

	public Root(){
		
	}
	
	@POST
	@Consumes("text/plain")
	@Produces("text/plain")
	public String post(String s) throws IOException{
		if(ScheduleFunction.updateTime(s)){
			return "Success!";
		}
		return "Failure!";
	}
	
	@GET
	@Consumes("text/plain")
	@Produces("text/plain")
	public String get(String s) throws IOException{
		if(ScheduleFunction.isTimeAvailable(s)){
			return "Not filled";
		}
		return "filled";
	}
}
