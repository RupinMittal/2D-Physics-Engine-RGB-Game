
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
     * Constructor for the RedWall class
     * 
     * @param player the Player the wall interacts with
     */
    public RedWall(Player player)
    {
        interactPlayer = player;
    }
    
    /**
     * An interaction with the Wall when the player comes from the left
     * Stops and kills player
     * 
     * @param futureX the theoretical x position of the player on the next frame
      */
    public void interactLeft(double futureX)
    {
        //stop player's movement
        interactPlayer.setXVel(0);
        interactPlayer.setYVel(0);
        
        //kill player
        interactPlayer.setAliveStatus(false);
    }
    
    /**
     * An interaction with the Wall when the player comes from the right
     * Stops and kills player
     * 
     * @param futureX the theoretical x position of the player on the next frame
    */
    public void interactRight(double futureX)
    {
        //stop player's movement
        interactPlayer.setXVel(0);
        interactPlayer.setYVel(0);
        
        //kill player
        interactPlayer.setAliveStatus(false);
    }
    
    /**
     * An interaction with the Wall when the player comes from the top
     * Stops and kills player
     * 
     * @param futureY the theoretical y position of the player on the next frame
     */
    public void interactFloor(double futureY)
    {
        //stop player's movement
        interactPlayer.setXVel(0);
        interactPlayer.setYVel(0);
        
        //kill player
        interactPlayer.setAliveStatus(false);
    }
    
    /**
     * An interaction with the Wall when the player comes from the bottom
     * Stops and kills player
     * 
     * @param futureY the theoretical y position of the player on the next frame
     */
    public void interactCeiling(double futureY)
    {
        //stop player's movement
        interactPlayer.setXVel(0);
        interactPlayer.setYVel(0);
        
        //kill player
        interactPlayer.setAliveStatus(false);
    }
}
