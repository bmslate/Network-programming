/*
 * Name: Huijun BU
 * Student Number: 041121881
 * Lab: Lab 10
 * Description: This program is to create a server.*/
import java.util.Scanner;
import java.io.IOException;
import java.io.EOFException;
import java.net.*;
import java.io.*;

public class Server1 {

		
		private int serverPort = 1254;
		
		private ServerSocket serverSocket;
		
		private Socket connection;
		
		private DataInputStream input;
		
		private DataOutputStream output;
		
		//Default port
		public Server1() {
			
			this.serverPort=1254;
			
		}
		
		//User defined port
		public Server1(int port) {
			
			this.serverPort=port;
			
		}
		
		//server starting point method
		public void runServer1() throws EOFException {
		
			try {
			//server now is listening on the port.	
			serverSocket=new ServerSocket(serverPort);
			//prompt the user port number.
			System.out.println("Server is listening: "+serverPort);
			//use wile loop to create a new threads after last connection is closed.
				while (true) {
				
					try {
					waitForConnection();
					getStream();
					processConnection();
					}finally {
						
					closeConnection();
						
					}
				}
			
			}catch(IOException e) {
				
				e.printStackTrace();
			}
			
		}
		
		//wait for a connection
		private void waitForConnection() {
			
			try {
				
				connection=serverSocket.accept();
				
				//prompt user the IP address of in coming stream.
				System.out.println("Connection received from " + connection.getInetAddress().getHostName());
			}catch(IOException e) {
				System.out.println("Error accepting connection");
				e.printStackTrace();
				}
		}
		//get Steams to send and receive data
		private void getStream() throws IOException {
			
			input = new DataInputStream(connection.getInputStream());
			
			output = new DataOutputStream(connection.getOutputStream());
			
			
		}
		
		private void processConnection() throws IOException{
			Scanner input=new Scanner(System.in);
			String message = null;
			
			// Server can allow user using keyboard to send message to the client, 
			//and terminate the connection while send "finish" to client
			do {
				System.out.println("Enter message (type 'finish' to terminate)");
				message=input.nextLine();
				output.writeUTF(message);
			}while(!message.equalsIgnoreCase("finish"));
			
			input.close();
		}
		
		//recycle resources
		private void closeConnection() throws IOException{
			
			
			input.close();
			output.close();
			connection.close();
			System.out.println("Connection Closed");
			
		}
		
		

}
