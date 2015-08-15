package pdc.project.Model;

/**
 * Super class for all tiles.
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
    
    public void visit(){
        isVisited = true;
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
