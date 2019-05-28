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
    private ImageView enmenyImageView;  //the imageview for the enemy
    //the pic still variable is inherited from Movable

    //constructor
    public Enemy(Image pic)
    {
        picStill = pic;                                 //set the image for the enemy
        enmenyImageView= = new ImageView(picStill);     //create the imageview
    }
}
