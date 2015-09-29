package com.coddicted.jersey.client;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.representation.Form;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class AddExpenseClient {

	public static void testGetService(){
		Client c = Client.create();
		WebResource r = c.resource("http://localhost:8080/ExpenseServices/expenses/addexpense");
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("userid", "1");
		params.add("amount", "11.5");
		params.add("particulars", "XYZ");
		params.add("group", "1");
		params.add("dated", "29-09-2015");
		
		System.out.println("Sending get request");
		String response = r.queryParams(params).get(String.class);
		System.out.println("GET Response received");
		System.out.println(response);
	}
	
	public static void testPostService(){
		Client c = Client.create();
		WebResource r = c.resource("http://localhost:8080/ExpenseServices/expenses/addexpensePost");
		Form f = new Form();
		f.add("userid", "1");
		f.add("amount", "11.5");
		f.add("particulars", "XYZ");
		f.add("group", "1");
		f.add("dated", "29-09-2015");
		
		System.out.println("Sending post request");
		ClientResponse response = r.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
				.accept(MediaType.APPLICATION_JSON_TYPE).post(ClientResponse.class, f);
		System.out.println("POST Response received");
		System.out.println(response.getEntity(String.class));
	}
	
	public static void main(String[] args) {

		AddExpenseClient.testGetService();
		AddExpenseClient.testPostService();
	}

}
