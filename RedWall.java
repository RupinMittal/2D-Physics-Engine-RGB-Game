
/**
 * Red Wall - kills player
 *
 * @author Brandon Wang
 * @version May 24 2019
 */
public class RedWall implements Wall
{
    private Player interactPlayer; //the Player the wall interacts with
    
    /**
     * Constructor for the NormalWall class
     * 
     * @param player the Player the wall interacts with
     */
    public RedWall(Player player)
    {
        interactPlayer = player;
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
