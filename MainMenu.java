import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.text.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Group;
import javafx.scene.layout.Background;

/**
 * MainMenu is a type of Menu and allows the user to start the game, look at the
 * credits, and turn volume on or off
 *
 * @author Jonathan Lee & Daniel Herrick
 * @version MainMenu JavaFx class - RGB
 */
public class MainMenu extends Application implements Menu
{
    private Button playButton;
    private Button backToMenuButton;
    private Button creditsButton;
    
    private Button volumeButton;
    private Button sound1;
    private Button sound2;
    
    private Stage window;
    //Is this a good idea to do public static?
    private Scene mainScene, creditScene, playScene; 
   
    /**
     * This the constructor for MainMenu that will construct all the buttons
     * and run the main menu via runMenu() 
     */
    public MainMenu()
    {
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    public void start(Stage stage) throws Exception {
        window = stage;
        
        //Code to add background image
        Image image = new Image("file:MarioBackground.png");
        ImageView mv = new ImageView(image);
        mv.setPreserveRatio(true);
        
        //Instantiaion of buttons in MainMenu class
        playButton = new Button("Play");
        creditsButton = new Button("Credits");
        backToMenuButton = new Button("Back To Menu");
        volumeButton = new Button("Volume");
        sound1 = new Button("Volume on");
        sound2 = new Button("Volume off");
        
        //Sets the length of the button to a set size
        playButton.setMaxWidth(100);
        creditsButton.setMaxWidth(100);
        
        //This class will handle the button event when user hits Play or Credits (changes the scene to Play and Credit)
        playButton.setOnAction(e -> window.setScene(playScene));
        volumeButton.setOnAction(this::volume);
        creditsButton.setOnAction(this::credits);
        
        //Layout for the Main scene - children are laid out in a veritcal column
        VBox main = new VBox(20);
        //Centers the layout in the middle of the scene
        main.setAlignment(Pos.CENTER);
        //Declaration and instantiation of a label
        Label label = new Label("RGB"); 
        
        
        //Adds the buttons and label onto the layout of the scene
        main.getChildren().addAll(label, playButton, creditsButton);
        //Instantiation of the scene in MainMenu
        mainScene = new Scene(main, 600, 600);

        //User can not resize the form
        window.setResizable(false);
        window.setTitle("RGB GANG");
        window.setScene(mainScene);
        stage.show();
    }
    
    /**
     * This method will be called when the user clicks the play button. It
     * will switch screens to a character select screen.
     * 
     * @param pClick - an event representing the user clicking the play button
     */
    private void play(ActionEvent pClick)
    {
        
    }
    
    /**
     * This method will be called when the user clicks the volume button. It
     * will toggle the button so that volume is "off" and "on".
     * 
     * @param soundClick - an event representing the user clicking the sound
     * button
     */
    public void volume(ActionEvent soundClick)
    {
        // Get access to loop() method in Music class
        Music music = new Music("ollie.mp3");
        
        // Test to see if the on button is being clicked
        if(soundClick.getSource() == sound1)
        {
            // Change volume of music
            music.loop(0);
            // switch buttons
            volumeButton = sound2;
        }  
        
        // Test to see if the off button is being clicked
        if(soundClick.getSource() == sound2)
        {
            // Change volume of music
            music.loop(100);
            // switch buttons
            volumeButton = sound1;
        }     
    }
    
    /**
     * This method will be called when the user clicks the credits button. It
     * will switch screens to a credits screen that displays all necessary 
     * credits of the game 
     * 
     * @param cClick - an event representing the user clicking the credits 
     * button 
     */
    private void credits(ActionEvent cClick)
    {
        //Layout for Credit Scene
        VBox creditLayout = new VBox(20);
        //Centers the layout of the Credit scene in the middle
        creditLayout.setAlignment(Pos.CENTER);
        
        //Declaration and Instantiation of the Credit Texts
        Text creditText = new Text();
        creditText.setFont(Font.font("Baskerville", 20));
        String creditString = "WELCOME to RGB \n" 
                              + "Creators - Daniel Herrick, Jonathan Lee, Rupin Mittal, and Brandon Wang \n"
                              + "Graphics by Maria Dhilla and Music by Cole Clarkson (IG: @cudi_cole)\n"
                              + "Press the arrow keys to move up, left, or right \n" 
                              + "Anything that is red will automatically kill you \n" 
                              + "Blue walls allow you to double jump while green wall causes you to stick to walls \n"
                              + "Complete all three sectors to beat the game, good luck Adventurer! \n"
                              + "Thank you Mr. Lantsberger for everything you've taught us. \n" 
                              + "It has been our pleasure being your students!";

        //Setting the value of the creditText to the string creditString
        creditText.setText(creditString);
        //Centering the text into middle of the scene
        creditText.setTextAlignment(TextAlignment.CENTER);
        //Adding nodes to the layout
        creditLayout.getChildren().add(creditText);
        creditLayout.getChildren().add(backToMenuButton);
        
        //This class will handle the button event when user hits Back To Menu
        backToMenuButton.setOnAction(e -> window.setScene(mainScene));
        creditScene = new Scene(creditLayout, 900, 600);
        window.setScene(creditScene);
    }
}