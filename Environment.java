/**
 * Environment (Abstract) - represents properties of the environments
 * @author Rupin Mittal
 * @version May 23, 2019
 */

import javafx.scene.image.Image;
import chn.util.;

public class Environment
{
    private Image map;                      //the Image that is the map of the environment, made on tiled
    private int[][] collisionsArray;        //the array that represents the tiles in the map
    private final int TILE_SIDE = 21;       //the height and width of each tile

    //constructor

    /**
     * Constructor for Environment class
     * @param fileName String that is png file name that comes from .json file
     */
    public Environment(String fileName)
    {
        createCollisionsArray(fileName);        //call to create the collisionsArray
    }

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
     * Method to get the int type of the tile that is being collided with
     * @param col int column number
     * @param row int row number
     * @return int the tile type being collided with
     */
    public int getType(int col, int row)
    {
        return collisionsArray[row][col];           //returnn the int type of the tile that is at [r][c]
    }

    /**
     * Method to create the collisions array from the text file that comes from the .json file
     * @param fileName String the string of the png fileName
     */
    private void createCollisionsArray(String fileName)
    {
        FileInput reader  = new FileInput(fileName);    //create FileInput object to read data from the file

        collisionsArray = new int[reader.readInt()][reader.readInt()];



    }
}
