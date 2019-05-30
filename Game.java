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
    //MainMenu mainMenu;                        //the mainmenu object
    //PauseMenu pauseMenu;                      //the pause menu
    private Environment gameEnvironment;        //the game environment
    private IntroEnvironment introEnvironment;  //the intro environment
    private Player player;                      //the player
    private NormalWall nWall;                   //the normal wall
    private BlueWall bWall;                     //the blue wall
    private RedWall rWall;                      //the red wall
    private GreenWall gWall;                    //the green wall
    private AnimationTimer animationTimer;      //the animation timer to run everything

    //variables for movement
    private boolean up, down, right, left;      //the variables for the players movement
    private boolean escape;                     //for escaping the game
    private double cameraOffset;                //the variable to offset the screen for scrolling
    private double futureXVelocity;             //the future horizontal velocity
    private double futureYVelocity;             //the future vertical velocity
    private double futureX;                     //future horizontal position
    private double futureY;                     //future vertical position

    //constants
    private final double Y_ACC = 7, X_ACC = 7, FRICT_ACC = 5, GRAV_ACC = 5, JUMP_ACC = 5, MAX_VEL = 5; //the constants for movement
    private final int TILE_SIZE = 21;    //the tile size

    //methods to run class
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        initializeVariables();      //initialize all the variables
    }

    //methods
    /*
     * Method to initialize the variables in the Game class
     */
    private void initializeVariables()
    {
        //initialize main menu
        //initialize pause menu
        gameEnvironment = new Environment("Sector1CollisionsData.txt", "Sector1Map.png");   //create first game environment
        introEnvironment = new IntroEnvironment("IntroCollisionsData.txt", "IntroMap.png", "IntroForeground.png", "IntoBackground.png");    //create intro environment
        //player = mainMenu.getPlayer;              //initialize player
        nWall = new NormalWall(player, TILE_SIZE);  //initialize the wall variables
        bWall = new BlueWall(player, TILE_SIZE);
        gWall = new GreenWall(player, TILE_SIZE);
        rWall = new RedWall(player);
    }











}
