/**
 * Player - represents the properties of a Player object in the game
 * @author Rupin Mittal
 * @version May 26, 2019
 */

import javafx.scene.image.Image;

public class Player extends Movable
{
    //variables
    //variable constants needed for movement
    private final double X_ACCEL = 7,       //horizontal acceleration constant
                         Y_ACCEL = 7,       //vertical acceleration constant
                         FRICT_ACCEL = 5,   //frictional force acceleration constant
                         GRAV_ACCEL = 5,    //gravitation force acceleration constant
                         JUMP_ACCEL = 5,    //acceleration of jumping constant
                         MAX_VEL = 5;       //maximum possible velocity in all directions

    //image variables
    private Image picRunning1;      //the first image of character running
    private Image picRunning2;      //the second image of character running
    private Image picJump;          //the image of character jumping
    //private Image picStill is written in superclass Movable
    private int animationState;     //which animation to be used (0 = still, 1 = running, 2 = jump)

    //state variables
    private boolean isAlive;                //true if character is alive, false if dead
    private boolean isOnGreenHorizontal;    //true if character is on green floor or ceiling, else false
    private boolean isOnGreenVertical;      //true if character is on green wall, else false

    //constructor

    /**
     * Constructor for Player objects
     * @param pStill Image of still player
     * @param pRun1  First Image of running PLayer
     * @param pRun2  Second Image of running Player
     * @param pJump  Image of jumping Player
     */
    public Player(Image pStill, Image pRun1, Image pRun2, Image pJump)
    {
        picStill = pStill;              //initialize variables in intitial state
        picRunning1 = pRun1;
        picRunning2 = pRun2;
        picJump = pJump;
        animationState = 0;
        isAlive = true;
        isOnGreenHorizontal = false;
        isOnGreenVertical = false;
    }

    //methods
    /**
     * Method to get the alive/dead status of player
     * @return boolean true is alive, false if dead
     */
    public boolean isAlive()
    {
        return isAlive;     //return alive status
    }

    /**
     * Method to kill the Player
     */
    public void kill()
    {
        isAlive = false;    //kill the player
    }

    /**
     * Method to get the onGreenHorizontal status of Player
     * @return boolean true if player is on green ceiling or floor, false if not
     */
    public boolean isOnGreenHorizontal()
    {
        return isOnGreenHorizontal; //return onGreenHorizontal status
    }

    /**
     * Method to set the onGreenHorizontal status of Player
     * @param onGHorizontal boolean true if player is on green ceiling or floor, false if not
     */
    public void setGreenHorizontalStatus(boolean onGHorizontal)
    {
        isOnGreenHorizontal = onGHorizontal;    //set new status status of isOnGreenHorizontal
    }

    /**
     * Method to get the onGreenVertical status of Player
     * @return boolean true if player is on green wall, false if not
     */
    public boolean isOnGreenHVertical()
    {
        return isOnGreenVertical; //return onGreenVertical status
    }

    /**
     * Method to set the onGreenVertical status of Player
     * @param onGVertical boolean true if player is on green wall, false if not
     */
    public void setVerticalStatus(boolean onGVertical)
    {
        isOnGreenVertical = onGVertical;    //set new status status of isOnGreenVertical
    }

}
