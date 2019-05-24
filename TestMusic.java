import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

/**
 * Write a description of class TestMusic here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestMusic extends Application
{
    MediaPlayer player;
    
    public static void main(String[] args)
    {
        launch(args);
    }
    
    public void start(Stage stage)
    {
        Music.loop("ollie.mp3");
        
        VBox root = new VBox();
        root.getChildren().addAll();
        
        Scene scene = new Scene(root, 500, 500);
        stage.setScene(scene);
            
        stage.show();
    }
    
}
