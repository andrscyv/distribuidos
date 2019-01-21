/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatcpsockets;

/**
 *
 * @author sdist
 */
public class Lanzador {
    
    public static void main(String[] args) {
        int numClientes = 10;
        int numMsg = 3;
        ClienteConc c;
        
        for(int i = 0; i < numClientes; i++){
        
            c = new ClienteConc(numMsg,i);
            c.start();
        }
    }
    
}
