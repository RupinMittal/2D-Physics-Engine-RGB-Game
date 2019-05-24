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
        //Creates a Music object
        Music music = new Music("ollie.mp3");
        //Looping the music at 1/5 of its loudness
        music.loop(0.2);
        
        VBox root = new VBox();
        root.getChildren().addAll();
        
        Scene scene = new Scene(root, 500, 500);
        stage.setScene(scene);
            
        stage.show();
    }
}
