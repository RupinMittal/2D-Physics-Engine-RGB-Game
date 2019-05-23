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

    /**
     * Method to get the map Image
     * @return Image map
     */
    public Image getMapImage()
    {
        return map; //return the map Image
    }

    /**
     * Method to find out if element at row, col is air or a wall
     * @param col int column number
     * @param row int row number
     * @return boolean true if collision, false if not
     */
    public boolean isCollision(int col, int row)
    {
        return collisionsArray[row][col] == 0;      //return true if [r][c] is 0 (air), false if [r][c] is not 0 (not air)
    }

    /**
     * Method to get the
     * @param col int column number
     * @param row int row number
     * @return int the tile type being collided with
     */
    public int getType(int col, int row)
    {
        return collisionsArray[row][col];           //returnn the int type of the tile that is at [r][c]
    }
}
