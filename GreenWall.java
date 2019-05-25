
/**
 * Green Wall - Player sticks to it
 *
 * @author Brandon Wang
 * @version May 24 2019
 */
public class GreenWall implements Wall
{
    private Player interactPlayer; //the Player the wall interacts with
    private int tileSize; //the tile size in pixels
    
    /**
     * Constructor for the NormalWall class
     * 
     * @param player the Player the wall interacts with
     * @param tile the size of the game tiles
     */
    public GreenWall(Player player, int tile)
    {
        interactPlayer = player;
        tileSize = tile;
    }
    
    /**
     * An interaction with the Wall when the player comes from the left
     *
     * @param player the Player the wall interacts with
     */
    public void interactLeft(Player player);
    
    /**
     * An interaction with the Wall when the player comes from the right
     *
     * @param player the Player the wall interacts with
     */
    public void interactRight(Player player);
    
    /**
     * An interaction with the Wall when the player comes from the top
     *
     * @param player the Player the wall interacts with
     */
    public void interactFloor(Player player);
    
    /**
     * An interaction with the Wall when the player comes from the bottom
     *
     * @param player the Player the wall interacts with
     */
    public void interactCeiling(Player player);
}
