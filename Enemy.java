/**
 * Enemy - represents the properties of a enemy object in the game
 * @author Rupin Mittal
 * @version May 28, 2019
 */

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Enemy extends Movable
{
    //variables
    private ImageView enemyImageView;  //the imageview for the enemy
    //the pic still variable is inherited from Movable

    //constructor
    /**
     * Constructor for Enemy Objects
     * @param pic Image of still enemy
     */
    public Enemy(Image pic)
    {
        picStill = pic;                                //set the image for the enemy
        enemyImageView = new ImageView(picStill);      //create the imageview
        enemyImageView.setRotate(0);                   //set initial rotation value
    }

    //methods
    /**
     * Method to update the animation of enemy, like rotate it.
     */
    @Override
    public void updateAnimation()
    {
        enemyImageView.setRotate(enemyImageView.getRotate() + 10);  //increment the rotation
    }
}
