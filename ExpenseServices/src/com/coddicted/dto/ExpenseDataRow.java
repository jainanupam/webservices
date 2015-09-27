package com.coddicted.dto;

import java.util.Date;

public class ExpenseDataRow {

	private int user_id;
	private float amount;
	private String particulars;
	private int isGroupExpense;
	private Date dated;
	
	public ExpenseDataRow(int user_id, float amount, String particulars, 
			int isGroupExpense, Date dated) {
		super();
		this.user_id = user_id;
		this.amount = amount;
		this.particulars = particulars;
		this.isGroupExpense = isGroupExpense;
		this.dated = dated;
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getParticulars() {
		return particulars;
	}
	public void setParticulars(String particulars) {
		this.particulars = particulars;
	}
	public int getIsGroupExpense() {
		return isGroupExpense;
	}
	public void setIsGroupExpense(int isGroupExpense) {
		this.isGroupExpense = isGroupExpense;
	}
	public Date getDated() {
		return dated;
	}
	public void setDated(Date dated) {
		this.dated = dated;
	}
	
	
}
