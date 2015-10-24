package com.coddicted.jersey;

import java.sql.SQLException;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.coddicted.db.DBConnection;

//Path: http://localhost/<appln-folder-name>/register
@Path("/register")
public class RegisterUser {

	// HTTP POST method
	@POST
	// Path: http://localhost/<appln-folder-name>/register/registerUser
	@Path("/registerUser")
	//@Consumes(MediaType.APPLICATION_JSON)
	// Produces JSON as response
	@Produces(MediaType.APPLICATION_JSON)
	// JSON is parsed to get required parameters
	// user name, password (encrypted)
	public String registerUser(@FormParam("userName") String userName, 
			@FormParam("password") String password) {
		System.out.println("User name: " + userName);
		System.out.println("Password: " + password);
		
		int retCode = 2;
		try {
			if(DBConnection.registerUser(userName, password)){
				System.out.println("inserted row");
				retCode = 0;
			}
		} catch (SQLException e) {
			System.out.println("SQL Exception caught in insert expense row");
			e.printStackTrace();
			retCode = 1;
		}
		
		String response = "";
		switch (retCode) {
		case 0:
			response = Utility.constructJSON("insertExpense", true);
			break;
		case 1:
			response = Utility.constructJSON("insertExpense", false, 
					"Error occurred while inserting");
			break;
		default:
			response = Utility.constructJSON("insertExpense", false, 
					"Unknown status");
			break;
		}
		
		return response;
	}
}
