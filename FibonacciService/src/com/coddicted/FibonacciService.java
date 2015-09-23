package com.coddicted;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class FibonacciService {

	public void constructor(){
		
	}
	
	@WebMethod
	public int fibonacciNumber(int n){
		return this.getFibo(n);
	}
	
	private int getFibo(int n){
		if(n < 2){
			return 1;
		}
		return getFibo(n-1) + getFibo(n-2);
	}
}
