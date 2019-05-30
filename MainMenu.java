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
 * MainMenu is a type of Menu and allows the user to start the game, look at the
 * credits, and turn volume on or off
 *
 * @author Daniel Herrick 
 * @version MainMenu JavaFx class - RGB
 */
public class MainMenu extends Menu implements EventHandler<ActionEvent>
{
    private Label menu;
    private Button play;
    private Button volume;
    private Button credits;
    private Button quit;
   
    /**
     * This the constructor for MainMenu that will construct all the buttons
     * and run the main menu via runMenu() 
     */
    public MainMenu()
    {
        
    }
    
    /**
     * This method will be called in the MainMenu constructor once the user
     * reaches the main menu section of the game. This method will display
     * the title, buttons, and contain all the event handlers for the main
     * menu (call subsequent methods where neede
     */
    public void runMenu()
    {
        
    }
    
    /**
     * This method will be called when the user clicks the play button. It
     * will switch screens to a character select screen.
     * 
     * @param pClick - an event representing the user clicking the play button
     */
    private void play(ActionEvent pClick)
    {
        
    }
    
    /**
     * This method will be called when the user clicks the credits button. It
     * will switch screens to a credits screen that displays all necessary 
     * credits of the game 
     * 
     * @param cClick - an event representing the user clicking the credits 
     * button 
     */
    private void credits(ActionEvent cClick)
    {
        
    }
}