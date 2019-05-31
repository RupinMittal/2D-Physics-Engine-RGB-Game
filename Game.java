/**
 * Class to actually run the game
 * @authors Rupin Mittal and Brandon Wang
 * @version May 29, 2019
 */

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
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
    private double futureXVel;                  //the future horizontal velocity
    private double futureYVel;                  //the future vertical velocity
    private double futureX;                     //future horizontal position
    private double futureY;                     //future vertical position

    //constants
    private final double Y_ACC = 7, X_ACC = 7, FRICT_ACC = 5, GRAV_ACC = 5, JUMP_ACC = 5, MAX_VEL = 5; //the constants for movement
    private final int TILE_SIZE = 21;    //the tile size

    //variables for the actual display of the game
    private ImageView environment;           //the environment being displayed
    private ImageView character;             //the character being used
    private Group root;                      //the Group
    private Scene scene;                     //the scene

    //methods to run class
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        initializeVariables();      //initialize all the variables
        //initialize the display
        root.getChildren().add(environment);
        root.getChildren().add(character);
        character.setX(300);
        character.setY(200);
        primaryStage.setTitle("RGB");
        primaryStage.setScene(scene);
        primaryStage.show();

        //run controls
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {            //on keys pressed
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:    up = true; break;
                    case LEFT:  left = true; break;
                    case RIGHT: right = true; break;
                    case DOWN:  down = true; break;
                    case ESCAPE:  escape = true; break;
                }
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {           //on keys released
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:    up = false; break;
                    case LEFT:  left = false; break;
                    case RIGHT: right = false; break;
                    case DOWN:  down = false; break;
                    case ESCAPE:  escape = false; break;
                }
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();

        //AnimationTimer to run game
        AnimationTimer timer = new AnimationTimer()
        {
            @Override
            public void handle(long now)
            {
                //initialize instance variables
                futureXVel = player.getXVel();              //get the future horizontal velocity
                futureYVel = player.getYVel();              //get the future vertical velocity
                futureX = player.getXPos();                 //get the future x position
                futureY = player.getYPos();                 //get the future y position

                //make changes to the velocity with the constants
                futureXVel -= Math.signum(player.getXVel()) * FRICT_ACC/30;     //apply friction
                futureYVel += GRAV_ACC/30;                                      //apply gravity
                if(futureXVel > MAX_VEL)                //if the velocity is more than the max
                    futureXVel = MAX_VEL;               //then limit the velocity
                if(futureXVel < 0)                      //if friction causes player to stop
                    futureXVel = 0;                     //stop the player




            }
        };
        timer.start();

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
        environment = introEnvironment.getMapImageView();   //get environment imageview
        character = player.getImageView();                  //get player imageview
        root = new Group();                                 //the Group\
        scene = new Scene(root);                            //the scene
    }
}