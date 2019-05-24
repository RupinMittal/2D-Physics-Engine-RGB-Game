
/**
 * Normal Wall - no effect on player except collision
 *
 * @author Brandon Wang
 * @version May 24 2019
 */
public class NormalWall implements Wall
{
    /**
     * An interaction with the Wall when the player comes from the left
     * Sets the x velocity of the player to 0
     *
     * @param player the Player the wall interacts with
     */
    public void interactLeft(Player player)
    {
        player.setXVelocity(0);
    }
    
    /**
     * An interaction with the Wall when the player comes from the right
     * Sets the x velocity of the player to 0
     *
     * @param player the Player the wall interacts with
     */
    public void interactRight(Player player)
    {
        player.setXVelocity(0);
    }
    
    /**
     * An interaction with the Wall when the player comes from the top
     * Sets the y velocity of the player to 0
     *
     * @param player the Player the wall interacts with
     */
    public void interactFloor(Player player)
    {
        player.setYVelocity(0);
    }
    
    /**
     * An interaction with the Wall when the player comes from the bottom
     * Sets the y velocity of the player to 0
     *
     * @param player the Player the wall interacts with
     */
    public void interactCeiling(Player player)
    {
        player.setYVelocity(0);
    }
}
