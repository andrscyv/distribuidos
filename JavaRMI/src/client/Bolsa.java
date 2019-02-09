/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import interfaces.Bioinformatics;
import interfaces.DataMining;
import interfaces.ImageProcessing;
import interfaces.Task;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sdist
 */
public class Bolsa extends Thread{
    
    Task[] tareas ;
    Registry reg;
    
    public Bolsa(Task[] tareas, Registry reg){
        this.tareas = tareas;
        this.reg = reg;
    }
    
    public void run(){
        
        Task aux,t = tareas[0];
        
        int tipo;
        try {
            if(t.requirementId == "img"){
                ImageProcessing service = (ImageProcessing) reg.lookup("img");
                for(Task tar : tareas){
                    aux = service.executeImageTask(tar);
                    System.out.println(aux.output);
                }
                    
            }else
                if(t.requirementId == "data"){
                    DataMining service = (DataMining) reg.lookup("data");
                    for(Task tar : tareas){
                        aux = service.executeDataTask(tar);
                        System.out.println(aux.output);
                    }
                }
                else{
                    Bioinformatics service = (Bioinformatics) reg.lookup("bio");
                    for(Task tar : tareas){
                        aux = service.executeBioTask(tar);
                        System.out.println(aux.output);
                    }
                }
        } catch (RemoteException ex) {
            Logger.getLogger(Bolsa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(Bolsa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
