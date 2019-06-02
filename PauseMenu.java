import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
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
    private Button restart;
    private Button quit;
    
    private Stage window;
    private Scene pauseScene, resumeScene, restartScene, quitScene;
    
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
        window = stage;
        Label label = new Label("RGB");
        
        resume = new Button("Resume");
        restart = new Button("Restart");
        quit = new Button("Quit");
        
        //This class will handle the button event when user hits Resume, Restart, or Quit (changes the scenes to respective location)
        resume.setOnAction(e -> window.setScene(resumeScene));
        restart.setOnAction(e -> window.setScene(restartScene));
        quit.setOnAction(e -> window.setScene(MainMenu.mainScene));
        
        //Layout for the Pause scene - children are laid out in a veritcal column
        VBox pause = new VBox(20);
        pause.getChildren().addAll(resume, restart, quit);
        pauseScene = new Scene(pause, 600, 600);
        
        //Layout for Resume Scene
            // Will deliberate this part of the code after figuring out how to set up the actual game
        
        
        
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