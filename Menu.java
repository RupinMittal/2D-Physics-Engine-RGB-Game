import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Abstract class Menu - This class contains the common functions of both 
 * PauseMenu and MainMenu
 *
 * @author Daniel Herrick
 * @version Menu Abstract Class - RGB
 */
public abstract class Menu implements EventHandler<ActionEvent>
{
    /**
     * This method will be called individually in both MainMenu and PauseMenu 
     * to load the buttons to the screen and hold all the user interactions
     */
    public abstract void runMenu();
    
    /**
     * This method will be called in options when the user clicks the volume 
     * button to turn the music on or off in the game
     * 
     * @param vClick - an event representing the user clicking on the 
     * volume button 
     */
    public void volume(ActionEvent vClick)
    {
        // using if-else block 
    }
    
    /**
     * This method can be called in both menus to quit the game if the user
     * clicks the quit button to exit the game
     * 
     * @param qClick - an event representing the user clicking on the 
     * quit button 
     */
    public void quit(ActionEvent qClick)
    {
        // Quit the game
    }
}