
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
     */
    public void interactLeft(double futureX, double futureY);
    
    /**
     * An interaction with the Wall when the player comes from the right
     */
    public void interactRight(double futureX, double futureY);
    
    /**
     * An interaction with the Wall when the player comes from the top
     */
    public void interactFloor(double futureX, double futureY);
    
    /**
     * An interaction with the Wall when the player comes from the bottom
     */
    public void interactCeiling(double futureX, double futureY);
}
