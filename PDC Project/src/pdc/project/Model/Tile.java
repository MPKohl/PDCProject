/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdc.project.Model;

/**
 *
 * @author MPKohl
 */
public abstract class Tile {
    //Abstract class
    
    public Tile(){
        
    }
    //Visited - boolean
    private boolean isVisited(int[] position){
        return false;
    }
    
    //Method - boolean isReachable()
    public boolean isReachable(){
        return true;
    }
    //Type - Enumeration
    
    //Method - getTileType()
    
    
}
