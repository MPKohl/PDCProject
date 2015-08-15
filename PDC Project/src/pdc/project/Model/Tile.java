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
    
    TileType type;
    boolean isVisited = false;
    
    public Tile(){
        
    }
    //Visited - boolean
    private boolean isVisited(){
        return isVisited;
    }
    
    //Method - boolean isReachable()
    public boolean isReachable(){
        if (getType() != TileType.BLOCKED)
            return true;
        else
            return false;
    }

    /**
     * @return the type
     */
    public TileType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(TileType type) {
        this.type = type;
    }
}
