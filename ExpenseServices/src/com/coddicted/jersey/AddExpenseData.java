package com.coddicted.jersey;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.coddicted.db.DBConnection;
import com.coddicted.dto.ExpenseDataRow;

//Path: http://localhost/<appln-folder-name>/expenses
@Path("/expenses")
public class AddExpenseData {

	// HTTP GET method
	@GET
	// Path: http://localhost/<appln-folder-name>/expenses/addexpense
	@Path("/addexpensestr")
	// Produces JSON as response
	@Produces(MediaType.APPLICATION_JSON)
	// Query parameters are parameters: 
	// http://localhost/<appln-folder-name>/expenses/addexpense?userid=1&amount=20.5
	// &particulars=xyz&group=1&dated=26-09-2015
	public String insertExpense(@QueryParam("userid") String id, @QueryParam("amount") String amount,
			@QueryParam("particulars") String particulars, @QueryParam("group") String isGroup, 
			@QueryParam("dated") String dated){
		String response = "";
		int retCode = insertExpenseRow(id, amount, particulars, isGroup, dated);
		
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
	
	private int insertExpenseRow(String id, String amount, 
			String particulars, String isGroup, String dated) {
		int userid = Integer.parseInt(id);
		float amnt = Float.parseFloat(amount);
		int grp = Integer.parseInt(isGroup);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		Date dt;
		int response = 2;
		try {
			dt = sdf.parse(dated);
		} catch (ParseException e1) {
			System.out.println("Incorrect Date format");
			e1.printStackTrace();
			return response;
		}
		
		ExpenseDataRow dataRow = new ExpenseDataRow(userid, amnt, particulars, grp, dt);
		
		try {
			if(DBConnection.insertExpenseRow(dataRow)){
				System.out.println("inserted row");
				response = 0;
			}
		} catch (SQLException e) {
			System.out.println("SQL Exception caught in insert expense row");
			e.printStackTrace();
			response = 1;
		}
		
		return response;
	}

	// HTTP GET method
	@GET
	// Path: http://localhost/<appln-folder-name>/expenses/addexpense
	@Path("/addexpense")
	// Produces JSON as response
	@Produces(MediaType.APPLICATION_JSON)
	// Query parameters are parameters: 
	// http://localhost/<appln-folder-name>/expenses/addexpense?userid=1&amount=20.5
	// &particulars=xyz&group=1&dated=26-09-2015
	public String insertExpense(@QueryParam("userid") int id, @QueryParam("amount") float amount,
			@QueryParam("particulars") String particulars, @QueryParam("group") int isGroup, 
			@QueryParam("dated") String dated){
		String response = "";
		System.out.println("Inside typed method");
		System.out.println("id: " + id + " amount: " + amount + " particulars: " + particulars 
				+ " group: " + isGroup + " dated: " + dated);
		//int retCode = insertExpenseRow(id, amount, particulars, isGroup, dated);
		int retCode = 0;
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

	// HTTP POST method
	@POST
	// Path: http://localhost/<appln-folder-name>/expenses/addexpensePost
	@Path("/addexpensePost")
	@Consumes("application/x-www-form-urlencoded")
	// Produces JSON as response
	@Produces(MediaType.APPLICATION_JSON)
	// Query parameters are parameters:
	// http://localhost/<appln-folder-name>/expenses/addexpensePost
	public String insertExpense(MultivaluedMap<String, String> formParams) {
		String response = "";
		System.out.println("Inside POST request method");
		System.out.println("id: " + formParams.get("userid") + " amount: "
				+ formParams.get("amount") + " particulars: "
				+ formParams.get("particulars") + " group: "
				+ formParams.get("group") + " dated: "
				+ formParams.get("dated"));
		// Call the method for inserting into database
		int retCode = insertExpenseRow(formParams.getFirst("userid"),
				formParams.getFirst("amount"),
				formParams.getFirst("particulars"),
				formParams.getFirst("group"), formParams.getFirst("dated"));
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
//	private int insertExpenseRow(int id, float amount, String particulars, 
//			int isGroup, Date dated) {
//		ExpenseDataRow dataRow = new ExpenseDataRow(id, amount, particulars, isGroup, dated);
//		int response = 2;
//		try {
//			if(DBConnection.insertExpenseRow(dataRow)){
//				System.out.println("inserted row");
//				response = 0;
//			}
//		} catch (SQLException e) {
//			System.out.println("SQL Exception caught in insert expense row");
//			response = 1;
//		}
//		
//		return response;
//	}
}
