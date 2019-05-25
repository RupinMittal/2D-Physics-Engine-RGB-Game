
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
     * Sets the x velocity of the player to 0
     * 
     * @param futureX the theoretical x position of the player on the next frame
     * @param futureY the theoretical y position of the player on the next frame
     */
    public void interactLeft(double futureX, double futureY)
    {
        //stop player's movement
        interactPlayer.setXVelocity(0);
        interactPlayer.setYVelocity(0);
        
        //kill player
        interactPlayer.setAlive(false);
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
        //stop player's movement
        interactPlayer.setXVelocity(0);
        interactPlayer.setYVelocity(0);
        
        //kill player
        interactPlayer.setAlive(false);
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
        //stop player's movement
        interactPlayer.setXVelocity(0);
        interactPlayer.setYVelocity(0);
        
        //kill player
        interactPlayer.setAlive(false);
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
        //stop player's movement
        interactPlayer.setXVelocity(0);
        interactPlayer.setYVelocity(0);
        
        //kill player
        interactPlayer.setAlive(false);
    }
}
