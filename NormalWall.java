
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
     * 
     * @param futureX the theoretical x position of the player on the next frame
     * @param futureY the theoretical y position of the player on the next frame
     */
    public void interactLeft(double futureX, double futureY)
    {
        double wallX = 
        interactPlayer.setXPos();
        interactPlayer.setXVelocity(0);
    }
    
    /**
     * An interaction with the Wall when the player comes from the right
     * Sets the x velocity of the player to 0
     * 
     * @param futureX the theoretical x position of the player on the next frame
     * @param futureY the theoretical y position of the player on the next frame
     */
    public void interactRight(double futureX, double futureY)
    {
        interactPlayer.setXVelocity(0);
    }
    
    /**
     * An interaction with the Wall when the player comes from the top
     * Sets the y velocity of the player to 0
     * 
     * @param futureX the theoretical x position of the player on the next frame
     * @param futureY the theoretical y position of the player on the next frame
     */
    public void interactFloor(double futureX, double futureY)
    {
        interactPlayer.setYVelocity(0);
    }
    
    /**
     * An interaction with the Wall when the player comes from the bottom
     * Sets the y velocity of the player to 0
     * 
     * @param futureX the theoretical x position of the player on the next frame
     * @param futureY the theoretical y position of the player on the next frame
     */
    public void interactCeiling(double futureX, double futureY)
    {
        interactPlayer.setYVelocity(0);
    }
}
