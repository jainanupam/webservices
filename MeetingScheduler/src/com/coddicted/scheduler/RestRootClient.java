package com.coddicted.scheduler;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class RestRootClient {

	public static void main(String[] args) {
		Client c = ClientBuilder.newClient();
		c.target("");
	}
}
