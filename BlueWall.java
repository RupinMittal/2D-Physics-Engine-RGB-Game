
/**
 * Blue Wall - bounces player away
 *
 * @author Brandon Wang
 * @version May 24 2019
 */
public class BlueWall implements Wall
{
    private Player interactPlayer; //the Player the wall interacts with
    private int tileSize; //the tile size in pixels
    private static final int HORI_BOUNCE = 100;
    private static final int VERT_BOUNCE = 10;
    
    /**
     * Constructor for the BlueWall class
     * 
     * @param player the Player the wall interacts with
     * @param tile the size of the game tiles
     */
    public BlueWall(Player player, int tile)
    {
        interactPlayer = player;
        tileSize = tile;
    }
    
    /**
     * An interaction with the Wall when the player comes from the left
     * Sets the x velocity of the player to horizontal bounce constant
     * 
     * @param futureX the theoretical x position of the player on the next frame
     */
    public void interactLeft(double futureX)
    {
        //highest multiple of tileSize less than futureX - wall left edge
        int wallX = (int)futureX - (int)futureX % tileSize; 
        
        //set player to touching wall
        interactPlayer.setXPos(wallX - interactPlayer.getWidth());
        
        //set player's horizontal movement
        interactPlayer.setXVel(-1 * HORI_BOUNCE);
    }
    
    /**
     * An interaction with the Wall when the player comes from the right
     * Sets the x velocity of the player to horizontal bounce constant
     * 
     * @param futureX the theoretical x position of the player on the next frame
     */
    public void interactRight(double futureX)
    {
        //lowest multiple of tileSize more than futureX - wall right edge
        int wallX = (int)futureX - (int)futureX % tileSize + tileSize; 
        
        //set player to touching wall
        interactPlayer.setXPos(wallX);
        
        //set player's horizontal movement
        interactPlayer.setXVel(HORI_BOUNCE);
    }
    
    /**
     * An interaction with the Wall when the player comes from the top
     * Sets the y velocity of the player to vertical bounce constant
     * 
     * @param futureY the theoretical y position of the player on the next frame
     */
    public void interactFloor(double futureY)
    {
        //lowest multiple of tileSize less than futureY - wall top edge
        int wallY = (int)futureY - (int)futureY % tileSize;
        
        //set player to touching wall
        interactPlayer.setYPos(wallY - interactPlayer.getHeight());
        
        //set player's vertical movement
        interactPlayer.setYVel(-1 * VERT_BOUNCE);
    }
    
    /**
     * An interaction with the Wall when the player comes from the bottom
     * Sets the y velocity of the player to vertical bounce constant
     * 
     * @param futureY the theoretical y position of the player on the next frame
     */
    public void interactCeiling(double futureY)
    {
        //highest multiple of tileSize more than futureY - wall bottom edge
        int wallY = (int)futureY - (int)futureY % tileSize + tileSize;
        
        //set player to touching wall
        interactPlayer.setYPos(wallY);
        
        //set player's vertical movement
        interactPlayer.setYVel(VERT_BOUNCE);
    }
}
