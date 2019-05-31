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
 * MainMenu is a type of Menu and allows the user to start the game, look at the
 * credits, and turn volume on or off
 *
 * @author Daniel Herrick & Jonathan Lee
 * @version MainMenu JavaFx class - RGB
 */
public class MainMenu extends Application implements Menu
{
    private Button playButton;
    private Button backToMenuButton;
    private Button creditsButton;
    
    
    private Button volumeButton;
    private Button quitButton;
    
    private Stage window;
    private Scene mainScene, creditScene, playScene;
   
    /**
     * This the constructor for MainMenu that will construct all the buttons
     * and run the main menu via runMenu() 
     */
    public MainMenu()
    {
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    public void start(Stage stage) throws Exception {
        window = stage;
        Label label = new Label("RGB");
        
        playButton = new Button("Play");
        creditsButton = new Button("Credits");
        backToMenuButton = new Button("Back To Menu");
        
        //This class will handle the button event when user hits Play or Credits (changes the scene to Play and Credit)
        playButton.setOnAction(e -> window.setScene(playScene));
        creditsButton.setOnAction(e -> window.setScene(creditScene));
        
        //Layout for the Main scene - children are laid out in a veritcal column
        VBox main = new VBox(20);
        main.getChildren().addAll(playButton, creditsButton);
        mainScene = new Scene(main, 600, 600);
        
        //Layout for Credit Scene
        VBox creditLayout = new VBox(20);
        creditLayout.getChildren().add(backToMenuButton);
        backToMenuButton.setOnAction(e -> window.setScene(mainScene));
        creditScene = new Scene(creditLayout, 600, 600);
        
        window.setTitle("RGB GANG");
        window.setScene(mainScene);
        stage.show();
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