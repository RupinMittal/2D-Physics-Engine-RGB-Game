import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;

import static java.awt.Event.DOWN;


public class Test extends Application
{
    public static void main(String[] args)
    {
        Application.launch(args);
    }

    public void start(Stage stage) throws Exception {
        Image platform = new Image(new FileInputStream("map1.png"), 210.0, 210.0, false, false);
        ImageView iv1 = new ImageView(platform);
        iv1.setImage(platform);

        Image character = new Image(new FileInputStream("Mario.png"));
        ImageView iv2 = new ImageView(platform);
        iv2.setImage(character);

        Group root = new Group();
        root.getChildren().add(iv1);

        iv2.setX(0);
        iv2.setY(100);

        boolean a = true;


        while (a){
            root.setOnKeyPressed(e ->
            {
                switch (e.getCode()) {
                    case DOWN:
                        iv2.setY(iv2.getY() - 5);
                        break;
                    case UP:
                        iv2.setY(iv2.getY() + 5);
                        break;
                    case RIGHT:
                        iv2.setX(iv2.getX() + 5);
                        break;
                    case LEFT:
                        iv2.setX(iv2.getY() - 5);
                        break;
                }
            });

            root.getChildren().add(iv2);

            Scene scence = new Scene(root, 210, 210);
            stage.setScene(scence);
            stage.setResizable(false);
            stage.show();


        }
    }





}
