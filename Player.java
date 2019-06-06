/**
 * Player - represents the properties of a Player object in the game
 * @author Rupin Mittal
 * @version May 26, 2019
 */

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player extends Movable
{
    //variables
    //image variables
    private Image[] runningAnimation;        //array containing the frames of the character running
    private Image picJump;                   //the image of character jumping
    //private Image picStill is written in superclass Movable

    //state variables
    private boolean isAlive;                //true if character is alive, false if dead
    private boolean isOnGreenHorizontal;    //true if character is on green floor or ceiling, else false
    private boolean isOnGreenVertical;      //true if character is on green wall, else false

    //variables for updatingAnimation
    private int runTimer;                       //variable counter for how long to wait before switching the running image
    private int runState;                       //keeps track of what state the runner is in

    //constructor
    /**
     * Constructor for Player objects
     * @param pStill filepath of image of still player
     * @param pJump  filepath of image of jumping player
     */
    public Player(String pStill, String pJump)
    {
        //initialize variables in initial state
        defaultImage = new Image(pStill, 0, 50, true, false);
        runningAnimation = new Image[12];
        picJump = new Image(pJump, 0, 50, true, false);

        //initialize running images
        for(int frameNum = 1; frameNum <= 12; frameNum++)
            runningAnimation[frameNum - 1] = new Image(pJump.substring(0, 20) + frameNum + ".png", 0, 50, true, false);

        movableImageView = new ImageView(defaultImage);
        
        isAlive = true;
        isOnGreenHorizontal = false;
        isOnGreenVertical = false;
        runTimer = 0;
        runState = 0;
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
     * Method to kill or revive the Player
     */
    public void setAliveStatus(boolean life)
    {
        isAlive = life;    //change the player's alive status
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
    public void setGreenVerticalStatus(boolean onGVertical)
    {
        isOnGreenVertical = onGVertical;    //set new status status of isOnGreenVertical
    }

    /**
     * Method to update the animation of a player, like running, still, or jump
     */
    @Override
    public void updateAnimation()
    {
        if((xVel == 0) && (yVel == 0))                        //if character is completely still
        {
            movableImageView.setImage(defaultImage);
            runTimer = 0;
            runState = 0;
        }
        else
        {
            if (xVel > 0)                                 //if player is moving right
                movableImageView.setScaleX(1);          //character faces right
            else
                if(xVel < 0)                            //if character moves left
                    movableImageView.setScaleX(-1);     //character faces left
            
            if(yVel != 0)
                movableImageView.setImage(picJump);
            else
                if(runTimer == 0)                                //if it is time to change animation
                {
                    movableImageView.setImage(runningAnimation[runState]); //set the imageview to the frame
                    runState++; //increment animation frame number
                    
                    if(runState == 12) //reset animation
                        runState = 0;
                }
                
            runTimer++;
            if(runTimer == 2)
                runTimer = 0;                                 //reset timer
        }
    }
}