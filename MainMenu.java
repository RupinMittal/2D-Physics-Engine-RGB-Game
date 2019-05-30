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
public class MainMenu extends Application implements EventHandler<ActionEvent>, Menu
{
    private Label menu;
    private Button play;
    private Button options;
    private Button credits;
    
    private Button volume;
    private Button quit;
   
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
        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(10,10,10,10));
        
        play = new Button();
        play.setText("Play");
        
        credits = new Button();
        credits.setText("Credits");
        
        play.setOnAction(this);
        credits.setOnAction(this);
        
        vBox.getChildren().addAll(play, credits);
        
        Scene scene = new Scene(vBox, 300, 250);
        
        stage.setTitle("RGB GANG");
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void handle(ActionEvent event)
    {
        if(event.getSource() == play)
        {
            play(event);
        }
        else
            if(event.getSource() == credits)
            {
                credits(event);
            }
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