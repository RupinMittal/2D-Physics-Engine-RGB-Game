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


}
