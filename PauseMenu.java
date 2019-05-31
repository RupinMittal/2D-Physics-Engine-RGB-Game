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
 * PauseMenu is a type of Menu and allows the user to resume the game, turn 
 * volume on or off, and restart the sector the user is on
 *
 * @author Daniel Herrick & Jonathan Lee
 * @version MainMenu JavaFx class - RGB
 */
public class PauseMenu extends Application implements Menu
{
    private Button resume;
    private Button endGame;
    private Button restartSector;
    private Button restartGame;
    
    private void restartSector()
    {
    }
    
    private void restartGame()
    {
    }
    
    private void resume()
    {
    }
    
    public void runMenu()
    {
    }
    
    public void start(Stage stage) throws Exception {
    }
    
    /**
     * This the constructor for PauseMenu that will construct all the buttons
     * and run the pause menu via runMenu() 
     */
    public PauseMenu()
    {
        
    }
    
    /** 
     * This method will be called when the user clicks the resume button. It 
     * will take them back to the current part of the game they are on
     * 
     * @param rClick - an event representing the user clicking the 
     * the resume button
     */
    private void resume(ActionEvent rClick)
    {
        
    }
}