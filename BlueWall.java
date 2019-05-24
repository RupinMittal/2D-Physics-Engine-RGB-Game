
/**
 * Blue Wall - bounces player away
 *
 * @author Brandon Wang
 * @version May 24 2019
 */
public class BlueWall implements Wall
{
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
