
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
    private static final int HORI_BOUNCE = 10;
    private static final int VERT_BOUNCE = 10;
    
    /**
     * Constructor for the NormalWall class
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
        
        //set player's horizontal movement
        interactPlayer.setXVelocity(-1 * HORI_BOUNCE);
    }
    
    /**
     * An interaction with the Wall when the player comes from the right
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
        
        //set player's horizontal movement
        interactPlayer.setXVelocity(HORI_BOUNCE);
    }
    
    /**
     * An interaction with the Wall when the player comes from the top
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
        
        //set player's horizontal movement
        interactPlayer.setYVelocity(VERT_BOUNCE);
    }
    
    /**
     * An interaction with the Wall when the player comes from the bottom
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
        
        //set player's horizontal movement
        interactPlayer.setYVelocity(-1 * VERT_BOUNCE);
    }
}
