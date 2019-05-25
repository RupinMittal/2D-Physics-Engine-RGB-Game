
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
        //highest multiple of tileSize less than futureX - wall left edge
        int wallX = ((int)futureX / tileSize) * tileSize; 
        
        //set player to touching wall
        interactPlayer.setXPos(wallX - interactPlayer.getWidth());
        
        //stop player's horizontal movement
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
        //lowest multiple of tileSize more than futureX - wall right edge
        int wallX = ((int)futureX / tileSize + 1) * tileSize; 
        
        //set player to touching wall
        interactPlayer.setXPos(wallX);
        
        //stop player's horizontal movement
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
        //lowest multiple of tileSize less than futureY - wall top edge
        int wallY = ((int)futureY / tileSize) * tileSize; 
        
        //set player to touching wall
        interactPlayer.setXPos(wallY - interactPlayer.getHeight());
        
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
        //highest multiple of tileSize more than futureY - wall bottom edge
        int wallY = ((int)futureY / tileSize + 1) * tileSize; 
        
        //set player to touching wall
        interactPlayer.setXPos(wallY);
        
        interactPlayer.setYVelocity(0);
    }
}
