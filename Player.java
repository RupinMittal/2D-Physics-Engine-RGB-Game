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
    private ImageView characterImageView;    //the imageview for the player and the current image being used
    private Image picRunning1;               //the first image of character running
    private Image picRunning2;               //the second image of character running
    private Image picJump;                   //the image of character jumping
    //private Image picStill is written in superclass Movable

    //state variables
    private boolean isAlive;                //true if character is alive, false if dead
    private boolean isOnGreenHorizontal;    //true if character is on green floor or ceiling, else false
    private boolean isOnGreenVertical;      //true if character is on green wall, else false

    //variables for updatingAnimation
    private int runTimer;                       //variable counter for how long to wait before switching the running image
    private boolean useRunPic1;                 //used to alternate between the two running pictures for running effect

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
        picStill = pStill;              //initialize variables in initial state
        picRunning1 = pRun1;
        picRunning2 = pRun2;
        picJump = pJump;
        characterImageView = new ImageView(picStill);
        isAlive = true;
        isOnGreenHorizontal = false;
        isOnGreenVertical = false;
        runTimer = 0;
        useRunPic1 = true;
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
    public void setVerticalStatus(boolean onGVertical)
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
            characterImageView.setImage(picStill);
            runTimer = 0;
        }
        else
        {
            if ((yVel != 0))                                  //if character is moving vertically
                characterImageView.setImage(picJump);
            else
                if (xVel > 0)                                 //if player is moving right
                    characterImageView.setScaleX(1);          //character faces right
                else                                          //if character moves left
                    characterImageView.setScaleX(-1);         //character faces left

            if(runTimer == 0)                                //if it is time to alternate sprites
            {
                if(useRunPic1)                                //if picRunning1 is to be used
                    characterImageView.setImage(picRunning1);
                else                                          //if picRunning2 is to be used
                    characterImageView.setImage(picRunning2);
                useRunPic1 = !useRunPic1;                     //alternate usage
            }
            runTimer++;
            if(runTimer == 15)
                runTimer = 0;                                 //reset timer
        }
    }

    /**
     * Method to return the ImageView of the character
     * @return ImageView of the player
     */
    @Override
    public ImageView getImageView()
    {
        return characterImageView;
    }
}