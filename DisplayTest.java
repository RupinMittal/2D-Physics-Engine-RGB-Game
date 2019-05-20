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
     double vertspeed, horispeed = 0;
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
                    case UP:    vertspeed = -2; break;
                    case DOWN:  vertspeed = 2; break;
                    case LEFT:  horispeed = -2; break;
                    case RIGHT: horispeed = 2; break;
                }
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:    vertspeed = 0; break;
                    case DOWN:  vertspeed = 0; break;
                    case LEFT:  horispeed = 0; break;
                    case RIGHT: horispeed = 0; break;
                }
            }
        });

        stage.setScene(scene);
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
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