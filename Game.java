/**
 * Class to actually run the game
 * @author Rupin Mittal
 * @version May 29, 2019
 */

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Game extends Application
{
    //object variables
    //MainMenu mainMenu;                        //the mainmenu object
    //PauseMenu pauseMenu;                      //the pause menu
    private Environment currentEnvironment;     //the current environment being used
    private Environment gameEnvironment;        //the game environment
    private IntroEnvironment introEnvironment;  //the intro environment
    private Player player;                      //the player
    private NormalWall nWall;                   //the normal wall
    private BlueWall bWall;                     //the blue wall
    private RedWall rWall;                      //the red wall
    private GreenWall gWall;                    //the green wall
    private AnimationTimer animationTimer;      //the animation timer to run everything
    private Wall colliderWall;                  //the wall that the user is colliding into in collisions
    private Rectangle2D viewport;               //the rectangle to have offset in the game

    //variables for movement
    private boolean up, down, right, left;      //the variables for the players movement
    private boolean escape;                     //for escaping the game
    private double cameraOffset;                //the variable to offset the screen for scrolling
    private double futureXVel;                  //the future horizontal velocity
    private double futureYVel;                  //the future vertical velocity
    private double futureX;                     //future horizontal position
    private double futureY;                     //future vertical position
    private int hDirection;                     //the horizontal direction
    private int vDirection;                     //the vertical direction

    //constants
    private final double Y_ACC = 10, X_ACC = 10, FRICT_ACC = 5, GRAV_ACC = 5, JUMP_ACC = 5, MAX_VEL = 50; //the constants for movement
    private final int TILE_SIZE = 32;    //the tile size

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
        player.setXPos(100);
        player.setYPos(100);
        character.setX(player.getXPos());
        character.setY(player.getYPos());
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
                if(player.isAlive())
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

                    //keypresses
                    if(up && player.getYVel() == 0)
                        futureYVel -= JUMP_ACC;
                    if(left)
                        futureXVel -= X_ACC / 30;
                    if(right)
                        futureXVel += X_ACC / 30;

                    //update the player's future position
                    futureX += futureXVel;
                    futureY += futureYVel;

                    //check collisions
                    if(currentEnvironment.isCollision(futureX, futureY))  //top left corner of player
                    {
                        colliderWall = getColliderWall(futureX, futureY);
                        
                        //top left collision with ceiling
                        if(currentEnvironment.isCollision(player.getXPos(), futureY)
                            && (currentEnvironment.getTypeNumber(player.getXPos(), futureY) == 1
                            || currentEnvironment.getTypeNumber(player.getXPos(), futureY) % 4 == 3))
                            colliderWall.interactCeiling(futureY);
                        
                        //top left collision with left wall
                        if(currentEnvironment.isCollision(futureX, player.getYPos())
                            && (currentEnvironment.getTypeNumber(futureX, player.getYPos()) == 1
                            || currentEnvironment.getTypeNumber(futureX, player.getYPos()) % 4 == 2))
                            colliderWall.interactLeft(futureX);
                    }
                    else
                        if(currentEnvironment.isCollision(futureX + player.getWidth(), futureY))  //top right corner of player
                        {
                            colliderWall = getColliderWall(futureX + player.getWidth(), futureY);
                            
                            //top right collision with ceiling
                            if(currentEnvironment.isCollision(player.getXPos() + player.getWidth(), futureY)
                                && (currentEnvironment.getTypeNumber(player.getXPos() + player.getWidth(), futureY) == 1
                                || currentEnvironment.getTypeNumber(player.getXPos() + player.getWidth(), futureY) % 4 == 3))
                                colliderWall.interactCeiling(futureY);
                            
                            //top right collision with right wall
                            if(currentEnvironment.isCollision(futureX + player.getWidth(), player.getYPos())
                                && (currentEnvironment.getTypeNumber(futureX + player.getWidth(), player.getYPos()) == 1
                                || currentEnvironment.getTypeNumber(futureX + player.getWidth(), player.getYPos()) % 4 == 1))
                                colliderWall.interactRight(futureX);
                        }
                        else
                            if(currentEnvironment.isCollision(futureX, futureY + player.getHeight()))  //bottom left corner of player
                            {
                                colliderWall = getColliderWall(futureX, futureY + player.getHeight());
                                
                                //bottom left collision with floor
                                if(currentEnvironment.isCollision(player.getXPos(), futureY + player.getHeight())
                                    && (currentEnvironment.getTypeNumber(player.getXPos(), futureY + player.getHeight()) == 1
                                    || currentEnvironment.getTypeNumber(player.getXPos(), futureY + player.getHeight()) % 4 == 4))
                                    colliderWall.interactFloor(futureY);
                                
                                //bottom left collision with left wall
                                if(currentEnvironment.isCollision(futureX, player.getYPos() + player.getHeight())
                                    && (currentEnvironment.getTypeNumber(futureX, player.getYPos() + player.getHeight()) == 1
                                    || currentEnvironment.getTypeNumber(futureX, player.getYPos() + player.getHeight()) % 4 == 2))
                                    colliderWall.interactLeft(futureX);
                            }
                            else
                                if(currentEnvironment.isCollision(futureX + player.getWidth(), futureY + player.getHeight()))  //bottom right corner of player
                                {
                                    colliderWall = getColliderWall(futureX + player.getWidth(), futureY + player.getHeight());
                                    
                                    //bottom left collision with floor
                                    if(currentEnvironment.isCollision(player.getXPos() + player.getWidth(), futureY + player.getHeight())
                                        && (currentEnvironment.getTypeNumber(player.getXPos() + player.getWidth(), futureY + player.getHeight()) == 1
                                        || currentEnvironment.getTypeNumber(player.getXPos() + player.getWidth(), futureY + player.getHeight()) % 4 == 4))
                                        colliderWall.interactFloor(futureY);
                                    
                                    //bottom left collision with left wall
                                    if(currentEnvironment.isCollision(futureX + player.getWidth(), player.getYPos() + player.getHeight())
                                        && (currentEnvironment.getTypeNumber(futureX + player.getWidth(), player.getYPos() + player.getHeight()) == 1
                                        || currentEnvironment.getTypeNumber(futureX + player.getWidth(), player.getYPos() + player.getHeight()) % 4 == 1))
                                        colliderWall.interactRight(futureX);
                                }
                                else
                                {
                                    //if there are no collisions, increment the player position normally
                                    player.setXPos(futureX);
                                    player.setYPos(futureY);
            
                                    //if there are no collisions, increment the player velocities normally
                                    player.setXVel(futureXVel);
                                    player.setYVel(futureYVel);
                                }

                    if(player.isAlive())                        //moving only happens if player is now alive
                    {
                        character.setX(player.getXPos());       //move player
                        character.setY(player.getYPos());

                        //update the animation that is being run
                        player.updateAnimation();

                        //check out of bounds movement
                        //if(player.getYPos() > environment.getFitHeight())   //if player is out of screen vertically
                            //player.setAliveStatus(false);                                  //kill the player
                        //if(player.getXPos() > environment.getFitWidth())    //if player is to left of sector
                        //move to next sector

                        //check if interacting with enemies
                        //if player and enemy's position is the same, kill the player

                        //do offset
                        //if(character.getX() > cameraOffset)     //if character is out of offsetrange
                            //environment.setViewport(new Rectangle2D(character.getX() - character.getFitWidth(), 0, 200, 200));  //scroll screen
                    }
                    //else
                        //show game over screen
                        //reset to sector 1
                }
                //else
                    //show game over screen
                    //reset to sector 1
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
        gameEnvironment = new Environment("test.txt", "Test.png");   //create first game environment
        //introEnvironment = new IntroEnvironment("IntroCollisionsData.txt", "IntroMap.png", "IntroForeground.png", "IntoBackground.png");    //create intro environment
        currentEnvironment = gameEnvironment;
        //player = mainMenu.getPlayer;              //initialize player
        player = new Player(new Image("player.png", 0, 50, true, false), new Image("player.png", 0, 50, true, false), new Image("player.png", 0, 50, true, false), new Image("player.png", 0, 50, true, false));
        nWall = new NormalWall(player, TILE_SIZE);  //initialize the wall variables
        bWall = new BlueWall(player, TILE_SIZE);
        gWall = new GreenWall(player, TILE_SIZE);
        rWall = new RedWall(player);
        environment = gameEnvironment.getMapImageView();                            //get environment imageview
        character = player.getImageView();                                          //get player imageview
        root = new Group();                                                         //the Group
        scene = new Scene(root);                                                    //the scene
        viewport = new Rectangle2D(0, 0, 200, 200);       //the rectangle to have offset in the game
        //environment.setViewport(viewport);                                          //set imageview to have the rectangle
        //cameraOffset = viewport.getWidth() - ((viewport.getWidth() - character.getFitWidth())/2);   //the amount to offset camera by for scrolling
    }

    /*
     * Method to get the direction that the player is moving horizontally
     * @param currentXPos double the current position
     * @oaram nextX double the next position being moved to
     * @return: 1 - right, 2- left
     */
    private int getHorizontalDirection(double currentXPos, double nextX)
    {
        int direction;  //the direction being travelled that will be returned

        if(nextX > currentXPos)     //if player is moving to right
            direction = 1;          //set direction to right
        else
            direction = 2;          ///else, set direction to left

        return direction;
    }

    /*
     * Method to get the direction that the player is moving vertically
     * @param currentYPos double the current position
     * @param nextY double the next position being moved to
     * @return: 3 - up, 4- down
     */
    private int getVerticalDirection(double currentYPos, double nextY)
    {
        int direction;  //the direction being travelled that will be returned

        if(nextY > currentYPos)     //if player is moving up
            direction = 3;          //set direction to up
        else
            direction = 4;          ///else, set direction to down

        return direction;
    }

    /*
     * Method to get the object of the type of wall by color
     * @param nextX the next horizontal position being moved to
     * @param nextY the next vertical position being moved to
     */
    private Wall getColliderWall(double nextX, double nextY)
    {
        Wall wall;                                                //the wall object that will be returned
        int typeNumber = currentEnvironment.getTypeNumber(nextX, nextY); //get the wall number

        if((typeNumber >= 1) && (typeNumber <= 4))      //if the wall number is 1, 2, 3, 4
            wall = nWall;
        else
            if((typeNumber >= 5) && (typeNumber <= 8))      //if the wall number is 5, 6, 7, 8
                wall = rWall;
            else
                if((typeNumber >= 9) && (typeNumber <= 12))      //if the wall number is 9, 10, 11, 12
                    wall = gWall;
                else
                    wall = bWall;                                //else blue wall

        return wall;
    }

    /*
     * Method to reset the player to the start of sector 1 after they die
     */
    private void resetToSectorStart()
    {
        player.setAliveStatus(true);  //revive player
        //reset players position to start of sector 1
        //display everything
    }
}
