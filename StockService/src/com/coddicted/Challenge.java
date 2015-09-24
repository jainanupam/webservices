package com.coddicted;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path(value="Challenge")
public class Challenge {

	List<String> data = new ArrayList<>();
	
	public Challenge(){
		
	}
	
	@GET
	@Consumes("text/xml")
	@Produces("text/xml")
	public String get(int index){
		return data.get(index);
	}
	
	@PUT
	@Consumes("text/xml")
	public void put(int index, String value){
		if(data.get(index) == null){
			data.add(index, value);
		} else {
			data.set(index, value);
		}
	}
	
	@DELETE
	@Consumes("text/xml")
	public void delete(int index){
		data.remove(index);
	}
}
