import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;

/**
 * MainMenu is a type of Menu and it begins the game by having the user choose a
 * character and then proceeding with the rest of the game
 *
 * @author Jonathan Lee
 * @version 28 May 2019
 */
public class MainMenu extends Menu
{
    private Button play;
    private Button options;
    private Button credits;
    
    private Player characterSelect()
    {
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    
    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(root, 300, 250);
        
        stage.setTitle("RGB GANG");
        
        play = new Button();
        play.setText("Play");
        
        options = new Button();
        options.setText("Option");
        
        credits = new Button();
        credits.setText("Credits");
        
            
    }
    
    private void playClicked(ActionEvent event)
    {
        
    }
}
