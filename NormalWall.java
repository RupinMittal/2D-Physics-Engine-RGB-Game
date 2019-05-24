
/**
 * Normal Wall - no effect on player except collision
 *
 * @author Brandon Wang
 * @version May 24 2019
 */
public class NormalWall implements Wall
{
    private Player interactPlayer; //the Player the wall interacts with
    private int tileSize; //the tile size in pixels
    
    /**
     * Constructor for the NormalWall class
     * 
     * @param player the Player the wall interacts with
     * @param tile the size of the game tiles
     */
    public NormalWall(Player player, int tile)
    {
        interactPlayer = player;
        tileSize = tile;
    }
    
    /**
     * An interaction with the Wall when the player comes from the left
     * Sets the x velocity of the player to 0
     */
    public void interactLeft(double futureX, double futureY)
    {
        
        interactPlayer.setXPos();
        interactPlayer.setXVelocity(0);
    }
    
    /**
     * An interaction with the Wall when the player comes from the right
     * Sets the x velocity of the player to 0
     */
    public void interactRight(double futureX, double futureY)
    {
        interactPlayer.setXVelocity(0);
    }
    
    /**
     * An interaction with the Wall when the player comes from the top
     * Sets the y velocity of the player to 0
     */
    public void interactFloor(double futureX, double futureY)
    {
        interactPlayer.setYVelocity(0);
    }
    
    /**
     * An interaction with the Wall when the player comes from the bottom
     * Sets the y velocity of the player to 0
     */
    public void interactCeiling(double futureX, double futureY)
    {
        interactPlayer.setYVelocity(0);
    }
}
