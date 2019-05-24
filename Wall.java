
/**
 * Interface for all types of surfaces
 *
 * @author Brandon Wang
 * @version May 24 2019
 */
public interface Wall
{
    /**
     * An interaction with the Wall when the player comes from the left
     * 
     * @param futureX the theoretical x position of the player on the next frame
     * @param futureY the theoretical y position of the player on the next frame
     */
    public void interactLeft(double futureX, double futureY);
    
    /**
     * An interaction with the Wall when the player comes from the right
     * 
     * @param futureX the theoretical x position of the player on the next frame
     * @param futureY the theoretical y position of the player on the next frame
     */
    public void interactRight(double futureX, double futureY);
    
    /**
     * An interaction with the Wall when the player comes from the top
     * 
     * @param futureX the theoretical x position of the player on the next frame
     * @param futureY the theoretical y position of the player on the next frame
     */
    public void interactFloor(double futureX, double futureY);
    
    /**
     * An interaction with the Wall when the player comes from the bottom
     * 
     * @param futureX the theoretical x position of the player on the next frame
     * @param futureY the theoretical y position of the player on the next frame
     */
    public void interactCeiling(double futureX, double futureY);
}
