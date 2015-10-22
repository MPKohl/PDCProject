package pdc.project.Model;

/**
 * Subclass of enemy for the Boss of the game. The Boss is always the same.
 */
public class Boss extends Enemy {


    /**
     * Constructor for Boss. Sets all stats to preset values.
     */
    public Boss() {
        super("Martini Lord of the Underworld", 280, 40, 50, 80, 10, "", false);
        setType(TileType.BOSS);
    }
}
