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
    public static void loop(String file)
    {            
          Media media = new Media(new File(file).toURI().toString());
          MediaPlayer player = new MediaPlayer(media);
        
          //Sets the player's ending of the music  
          //This is the interface Runnable and used to help create a thread
          
          player.setOnEndOfMedia(new Runnable() //This is the interface Runnable and used to help create a thread
          {
               public void run() //Impementing the run method from Runnable 
               {
                   player.seek(Duration.ZERO); //Separately executes this command in a different thread, tells the MediaPlayer to never end
               }
          });
          player.play(); //Starts playing the media resource, loops the music since the MediaPlayer has been told that it will not end
    }
    
    /**
     * The method will take a file and continuously play it back in a loop
     * @param volume The loudness of the music that is desired (on a scale from 0.0 to 1.0)
     */
    public static void loop(String file, double volume)
    {            
          Media media = new Media(new File(file).toURI().toString());
          MediaPlayer player = new MediaPlayer(media);
        
          player.setVolume(volume); //MediaPlayer sets the volume of how loud the music will be played
        
          player.setOnEndOfMedia(new Runnable() //This is the interface Runnable and used to help create a thread
          {
               public void run() //Impementing the run method from Runnable 
               {
                   player.seek(Duration.ZERO); //Separately executes this command in a different thread, tells the MediaPlayer to never end
               }
          });
          player.play(); //Starts playing the media resource, loops the music since the MediaPlayer has been told that it will not end
    }
}
