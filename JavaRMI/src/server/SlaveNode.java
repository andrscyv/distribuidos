/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import interfaces.Bioinformatics;
import interfaces.DataMining;
import interfaces.ImageProcessing;
import interfaces.Task;
import java.rmi.registry.Registry;

/**
 *
 * @author sdist
 */
public class SlaveNode implements Bioinformatics, DataMining, ImageProcessing {

    public SlaveNode() {
        super();
    }
    
    
    
    public void despliegue(String servicio, Registry registry){
        
        if(servicio == "bio"){
            Bioinformatics stub =
                (Bioinformatics) UnicastRemoteObjectject.exportObject(engine, 0);
        }
    }

    @Override
    public Task executeBioTask(Task t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Task executeDataTask(Task t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Task executeImageTask(Task t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
