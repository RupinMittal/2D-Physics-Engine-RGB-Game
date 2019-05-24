import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

/**
 * Test class for the method in the Music Class
 *
 * @author Jonathan Lee
 * @version 23 May 2019
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
        Music music = new Music("ollie.mp3");
        music.loop();
        
        VBox root = new VBox();
        root.getChildren().addAll();
        
        Scene scene = new Scene(root, 500, 500);
        stage.setScene(scene);
            
        stage.show();
    }
    
}
