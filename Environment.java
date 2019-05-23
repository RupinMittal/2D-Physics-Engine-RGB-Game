/**
 * Environment (Abstract) - represents properties of the environments
 * @author Rupin Mittal
 * @version May 23, 2019
 */

import javafx.application.Application;
import javafx.scene.image.Image;

public abstract class Environment extends Application
{
    private Image map;                      //the Image that is the map of the environment, made on tiled
    private int[][] collisionsArray;        //the array that represents the tiles in the map


}
