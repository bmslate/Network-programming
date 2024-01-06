/*
 * Name: Huijun BU
 * Student Number: 041121881
 * Lab: Lab 10
 * Description: This program is to create a client.*/

import java.io.IOException;
import java.io.EOFException;
import java.net.*;
import java.io.*;

public class Client1 {
	
	private int serverPort;
	
	private String hostServer="localhost";
	
	private Socket connection;
	
	private DataInputStream input;
	
	private DataOutputStream output;
	
	
	//for certain port use
	public Client1(String host) {
		
		this.hostServer=host;
		this.serverPort=1254;
	}
	
	//for client defined port.
	public Client1(String host,int serverPort) {
		this.hostServer=host;
		this.serverPort=serverPort;
	}
	
	// starting method
	public void runClient1() throws EOFException, IOException {
		connectToServer1();
		getStream();
		processConnection();
		closeConnection();
		
	}
	
	//connect to server
	private void connectToServer1()  {
		try {
			
			connection=new Socket(hostServer,serverPort);
			
			}catch(IOException ioException) {
			
			ioException.printStackTrace();
			
		}
		
		
		}
				
	
	//get input and output stream from server.
	private void getStream() {
		try {
		
			input = new DataInputStream(connection.getInputStream());
		
			output = new DataOutputStream(connection.getOutputStream());
		
		}catch(IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	// process connection
	private void processConnection() throws IOException {
		
		// 
		while(true) {
			String message= input.readUTF();
			//if condition is matched , loop will be stoped.
			if(message.equalsIgnoreCase("finish")) {
				break;
			}
			
			System.out.println("Server: " + message);
		}
		
		closeConnection();
	}
	
	//recycle resources
	private void closeConnection() throws IOException {
		
		input.close();
		
		output.close();
		
		connection.close();
		
	}
	

}
