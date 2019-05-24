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
     * The volume of the music for this method is at its max volume
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
    
    /**
     * The method will take a file and continuously play it back in a loop
     * @param volume The loudness of the music that is desired (on a scale from 0.0 to 1.0)
     */
    public void loop(double volume)
    {            
          player.setVolume(volume);
        
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
