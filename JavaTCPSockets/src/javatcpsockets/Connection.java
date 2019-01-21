/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatcpsockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author sdist
 */
class Connection extends Thread {
	DataInputStream in;
	DataOutputStream out;
	Socket clientSocket;
        AddressBook ad = new AddressBook();
	public Connection (Socket aClientSocket) {
	    try {
		clientSocket = aClientSocket;
		in = new DataInputStream(clientSocket.getInputStream());
		out =new DataOutputStream(clientSocket.getOutputStream());
	     } catch(IOException e)  {System.out.println("Connection:"+e.getMessage());}
	}
        
        @Override
	public void run(){
	    try {			                 // an echo server
		//String data = in.readUTF();	   
                int id = in.readInt();
                System.out.println("Message received from: " + clientSocket.getRemoteSocketAddress()+" "+id);
                
		out.writeUTF(ad.getRecord(id).getName());
                while( id >= 0){
                id = in.readInt();
                System.out.println("Message received from: " + clientSocket.getRemoteSocketAddress()+" "+id);
                
		out.writeUTF(ad.getRecord(id).getName());
                }
	    } 
            catch(EOFException e) {
                System.out.println("EOF:"+e.getMessage());
	    } 
            catch(IOException e) {
                System.out.println("IO:"+e.getMessage());
	    } 
//            finally {
//                try {
//                    clientSocket.close();
//                } catch (IOException e){
//                    System.out.println(e);
//                }
//                }
            }
}