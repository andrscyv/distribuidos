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
import java.net.UnknownHostException;

/**
 *
 * @author sdist
 */
public class ClienteConc extends Thread {
    public int numMsg;
    public int idClient;
    public long[] tiempos;
    
    public ClienteConc(int n,int id){
        this.numMsg = n;
        this.idClient = id;
        tiempos = new long[numMsg];
    }
    
    @Override
    public void run(){
    
        Socket s = null;
	    try {
	    	int serverPort = 7897;
	   	
                s = new Socket("localhost", serverPort);   
                String data;
                long startTime, spentTime;
             //   s = new Socket("127.0.0.1", serverPort);    
		DataInputStream in = new DataInputStream( s.getInputStream());
		DataOutputStream out =
			new DataOutputStream( s.getOutputStream());
                
                for(int i = 0; i < this.numMsg; i++){
		//out.writeUTF("Hello desde cliente: "+this.idClient);        	// UTF is a string encoding 
                //out.writeUTF(" "+i);
                    startTime = System.currentTimeMillis();
                    out.writeInt(3);
                    data = in.readUTF();
                    spentTime = System.currentTimeMillis() - startTime;
                    //System.out.println("Dentro de cliente: "+spentTime);
                    this.tiempos[i] = spentTime;
                    System.out.println("Received: "+ data) ; 
                }
                out.writeInt(-1);
                
		//String data = in.readUTF();	      
                //System.out.println("Received: "+ data) ;      
       	    } 
            catch (UnknownHostException e) {
		System.out.println("Sock:"+e.getMessage()); 
	    }
            catch (EOFException e) {
                System.out.println("EOF:"+e.getMessage());
    	    } 
            catch (IOException e) {
                System.out.println("IO:"+e.getMessage());
            } finally {
                if(s!=null) 
                    try {
                        s.close();
                    } catch (IOException e){
                    System.out.println("close:"+e.getMessage());}
                    }
            }
        
    }
    
