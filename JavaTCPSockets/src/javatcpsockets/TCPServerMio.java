/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatcpsockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author sdist
 */
public class TCPServerMio {
    
    public static void main (String args[]) {
	try{
		int serverPort = 7897; 
		ServerSocket listenSocket = new ServerSocket(serverPort);
                AddressBook ad = new AddressBook();
		while(true) {
			System.out.println("Waiting for messages..."); 
                        Socket clientSocket = listenSocket.accept();  // Listens for a connection to be made to this socket and accepts it. The method blocks until a connection is made. 
			Connection c = new Connection(clientSocket);
                        c.start();
		}
	} catch(IOException e) {System.out.println("Listen :"+ e.getMessage());}
    }
   
}