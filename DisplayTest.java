 import java.io.FileInputStream;
 import java.io.FileNotFoundException;
 import javafx.application.Application;
 import javafx.geometry.Rectangle2D;
 import javafx.scene.Group;
 import javafx.scene.Scene; 
 import javafx.scene.image.Image;
 import javafx.scene.image.ImageView;
 import javafx.scene.layout.HBox;
 import javafx.stage.Stage; 
 import javafx.scene.input.KeyEvent;
 import javafx.animation.AnimationTimer;
 import javafx.event.EventHandler;
/**
 * Testing display methods
 *
 * @author (your name)
 * @version (a version number or a date)
 */
 public class DisplayTest extends Application 
 {
     double vertacc, horiacc, vertspeed, horispeed;
     boolean slowX, slowY;
     @Override 
     public void start(Stage stage) throws FileNotFoundException
     {
         ImageView iv1 = new ImageView(new Image("file:background_Test.jpg", 1000, 0, true, false));
         ImageView iv2 = new ImageView(new Image("file:character_test.png", 50, 0, true, false));

         Group root = new Group();
         Scene scene = new Scene(root);
         root.getChildren().add(iv1);
         root.getChildren().add(iv2);
         iv2.setX(300);
         iv2.setY(200);
         
         stage.setTitle("ImageView");
         stage.setScene(scene);
         stage.show();
         
         scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:    vertacc = -2; slowY = false; break;
                    case DOWN:  vertacc = 2; slowY = false; break;
                    case LEFT:  horiacc = -2; slowX = false; break;
                    case RIGHT: horiacc = 2; slowX = false; break;
                }
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:    slowY = true; break;
                    case DOWN:  slowY = true; break;
                    case LEFT:  slowX = true; break;
                    case RIGHT: slowX = true; break;
                }
            }
        });

        stage.setScene(scene);
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(slowY)
                    vertspeed = Math.signum(vertspeed) * (Math.abs(vertspeed)-5.0/30);
                else
                    vertspeed += vertacc / 30;
                if(slowX)
                    horispeed = Math.signum(horispeed) * (Math.abs(horispeed)-5.0/30);
                else
                    horispeed += horiacc / 30;
                iv2.setX(iv2.getX() + horispeed);
                iv2.setY(iv2.getY() + vertspeed);
            }
        };
        timer.start();
         
     }

     public static void main(String[] args) {
         Application.launch(args);
     }
 }