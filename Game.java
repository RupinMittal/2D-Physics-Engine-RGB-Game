/**
 * Class to actually run the game
 * @authors Rupin Mittal and Brandon Wang
 * @version May 29, 2019
 */

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;

public class Game extends Application
{
    //object variables
    //Menu menu;                                //the menu object
    private Environment gameEnvironment;        //the game environment
    private IntroEnvironment introEnvironment;  //the intro environment
    private Player player;                      //the player
    private NormalWall nWall;                   //the normal wall
    private BlueWall bWall;                     //the blue wall
    private RedWall rWall;                      //the red wall
    private GreenWall gWall;                    //the green wall
    private boolean up, down, right, left;      //the variables for the players movement
    private AnimationTimer animationTimer;      //the animation timer to run everything

    //constants and movement variables
    private final double Y_ACC = 7,         //the constants for movement
                         X_ACC = 7,
                         FRICT_ACC = 5,
                         GRAV_ACC = 5,
                         JUMP_ACC = 5,
                         MAX_VEL = 5;
    private final double TILE_SIZE = 21;    //the tile size






    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {

    }
}
