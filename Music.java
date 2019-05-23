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
    public static void loop(String file)
    {
          Media media = new Media(file);
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
    
    public static void main(String[] args)
    {
       Music.loop("ollie.mp3");
    }
}
