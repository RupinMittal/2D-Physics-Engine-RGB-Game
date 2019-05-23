import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

/**
 * The Music class will contain methods that have will allow the user to loop a music file and 
 * then play the music
 * @author Jonathan Lee
 */
public class Music 
{
    String fileName;    
    
    public Music(String file)
    {
        fileName = file;
    }
    
    public void loop()
    {
          Media media = new Media(fileName);
          MediaPlayer player = new MediaPlayer(media);
          
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
