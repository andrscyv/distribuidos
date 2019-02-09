/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.io.Serializable;

/**
 *
 * @author sdist
 */
public class Task implements Serializable{
    
    public  int taskId;
    public String requirementId;
    public long length;
    public String output;

    public Task(int taskId, String requirementId, long length) {
        this.taskId = taskId;
        this.requirementId = requirementId;
        this.length = length;
    }
    
    
}
