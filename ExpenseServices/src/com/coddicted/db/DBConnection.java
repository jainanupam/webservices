package com.coddicted.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.coddicted.dto.ExpenseDataRow;

public class DBConnection {

	/**
     * Method to create DB Connection
     * 
     * @return
     * @throws Exception
     */
    @SuppressWarnings("finally")
    private static Connection createConnection() throws SQLException {
        Connection con = null;
        try {
            Class.forName(Constants.dbClass);
            con = DriverManager.getConnection(Constants.dbUrl, Constants.dbUser, Constants.dbPwd);
        } catch (SQLException e) {
        	System.out.println("SQL Exception while creating connection");
            throw e;
        } finally {
            return con;
        }
    }
    
    /**
     * Method to insert expense data row
     * 
     * @param dataRow
     * @return
     * @throws SQLException
     */
    public static boolean insertExpenseRow(ExpenseDataRow dataRow) throws SQLException{
    	Boolean rowInserted = false;
    	Connection dbConn = null;
    	try {
			dbConn = DBConnection.createConnection();
		} catch (SQLException e) {
			throw e;
		}
    	
    	// SQL query for inserting the data
    	String sql = "INSERT INTO expenses_data(user_id, amount, particulars, "
    			+ " group_expense, dated) values(?, ?, ?, ?, ?)";
    	
    	// Prepare the statement
    	PreparedStatement pStatement = dbConn.prepareStatement(sql);
    	// set the parameters to complete the SQL statement
    	pStatement.setInt(1, dataRow.getUser_id());
    	pStatement.setFloat(2, dataRow.getAmount());
    	pStatement.setString(3, dataRow.getParticulars());
    	pStatement.setShort(4, (short) dataRow.getIsGroupExpense());
    	pStatement.setDate(5, new java.sql.Date(dataRow.getDated().getTime()));
    	
    	try {
    		int result  = pStatement.executeUpdate();
    		if(result > 0)
    			rowInserted = true;
    	} catch(SQLException e){
    		System.out.println("SQL Exception while inserting the row");
    		if(dbConn != null)
    			dbConn.close();
    		throw e;
    	} finally {
    		if(dbConn != null)
    			dbConn.close();
		}
    	
    	return rowInserted;
    }

}