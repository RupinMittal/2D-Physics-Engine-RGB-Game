import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import java.io.File;

/**
 * The Music class will contain methods that have will allow the user to loop a music file and 
 * then play the music
 * 
 * @author Jonathan Lee
 * @version 23 May 2019
 */
public class Music 
{
    //Instance variable for a media resource
    Media media;
    //Instance variable for controlling the media resource
    MediaPlayer player;
    
    public Music (String file)
    {
        //Instantiation of instance variables
        media = new Media(new File(file).toURI().toString());
        player = new MediaPlayer(media);
    }
    
    /**
     * The method will take a file and continuously play it back in a loop
     * @param file The string for the music file
     */
    public void loop()
    {            
          player.setOnEndOfMedia(new Runnable() 
          {
               public void run() 
               {
                   player.seek(Duration.ZERO);
               }
          });
          player.play();
    }
}
