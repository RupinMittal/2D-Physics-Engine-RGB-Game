/**
 * Environment - represents properties of the environments
 * @author Rupin Mittal
 * @version May 23, 2019
 */

import javafx.scene.image.Image;
import chn.util.*;
import javafx.scene.image.ImageView;

public class Environment
{
    private ImageView map;                      //the ImageView that is the map of the environment, made on tiled
    private int[][] collisionsArray;            //the array that represents the tiles in the map
    private final int TILE_SIDE_SIZE = 21;      //the height and width of each tile

    //constructor
    /**
     * Constructor for Environment class
     * @param collisionsDataFile String that is txt file name that comes from .json file with tile data
     * @param mapFile String that is png file for map
     */
    public Environment(String collisionsDataFile, String mapFile)
    {
        createCollisionsArray(collisionsDataFile);        //call to create the collisionsArray
        map = new ImageView(new Image(mapFile, 0, 0, true, true));     //create the map imageview
    }

    /**
     * Method to get the map ImageView
     * @return ImageView map
     */
    public ImageView getMapImageView()
    {
        return map; //return the map ImageView
    }

    /**
     * Method to find out if element at row, col is air or a wall
     * @param col int column number
     * @param row int row number
     * @return boolean true if collision, false if not
     */
    public boolean isCollision(double col, double row)
    {
        return collisionsArray[(int)(row / TILE_SIDE_SIZE)][(int)(col / TILE_SIDE_SIZE)] != 0;      //return false if [r][c] is 0 (air), true if [r][c] is not 0 (not air)
    }

    /**
     * Method to get the int type of the tile that is being collided with
     * @param col int column number
     * @param row int row number
     * @return int the tile type being collided with
     */
    public int getType(double col, double row)
    {
        return collisionsArray[(int)(row / TILE_SIDE_SIZE)][(int)(col / TILE_SIDE_SIZE)];           //returnn the int type of the tile that is at [r][c]
    }

    /**
     * Method to create the collisions array from the text file that comes from the .json file
     * @param collisionsDataFile String the string of the png fileName
     */
    private void createCollisionsArray(String collisionsDataFile)
    {
        FileInput reader  = new FileInput(collisionsDataFile);    //create FileInput object to read data from the file

        collisionsArray = new int[reader.readInt()][reader.readInt()];      //create the array using sizes provided by file

        for(int r = 0; r < collisionsArray.length; r++)                     //add the elements as corresponding positions in map to
            for(int c = 0; c < collisionsArray[0].length; c++)              //positions in the collisions array
                collisionsArray[r][c] = reader.readInt();
    }
}