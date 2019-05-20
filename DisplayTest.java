 import java.io.FileInputStream;
 import java.io.FileNotFoundException;
 import javafx.application.Application;
 import javafx.scene.Group;
 import javafx.scene.Scene; 
 import javafx.scene.image.Image;
 import javafx.scene.image.ImageView;
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
     static final double Y_ACC = 7, 
                         X_ACC = 7, 
                         FRICT_ACC = 5,
                         GRAV_ACC = 5,
                         JUMP_ACC = 5,
                         MAX_VEL = 5;
     double XVel, YVel;
     boolean up, left, right;
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
                    case UP:    up = true; break;
                    case LEFT:  left = true; break;
                    case RIGHT: right = true; break;
                }
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:    up = false; break;
                    case LEFT:  left = false; break;
                    case RIGHT: right = false; break;
                }
            }
        });

        stage.setScene(scene);
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                double futureXVel = XVel, futureYVel = YVel;
                
                //Every frame, do friction and gravity(to be implemented)
                futureXVel -= Math.signum(XVel) * FRICT_ACC/30;
                futureYVel += GRAV_ACC/30;
                
                //keypresses
                if(up && iv2.getY() == 300)
                    futureYVel -= JUMP_ACC;
                if(left)
                    futureXVel -= X_ACC / 30;
                if(right)
                    futureXVel += X_ACC / 30;
                
                //Stopping player if velocity passes 0 (friction)
                if((int)Math.signum(futureXVel) == -1 * (int)Math.signum(XVel)
                    && !left && !right)
                    XVel = 0;
                else
                    if(Math.abs(XVel) <= MAX_VEL && Math.abs(futureXVel) > MAX_VEL) //velocity cap
                        XVel = Math.signum(XVel) * MAX_VEL;
                    else
                        XVel = futureXVel; //normal acceleration
                
                //collision with floor
                if(iv2.getY() + futureYVel > 300)
                {
                    YVel = 0;
                    iv2.setY(300);
                }
                else
                    YVel = futureYVel; //normal acceleration
                
                //increment position
                iv2.setX(iv2.getX() + XVel);
                iv2.setY(iv2.getY() + YVel);
            }
        };
        timer.start();
         
     }

     public static void main(String[] args) {
         Application.launch(args);
     }
 }