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
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.geometry.Insets;

/**
 * MainMenu is a type of Menu and allows the user to start the game, look at the
 * credits, and turn volume on or off
 *
 * @author Jonathan Lee & Daniel Herrick
 * @version MainMenu JavaFx class - RGB
 */
public class MainMenu extends Application
{
    //Declaration of buttons that will be used in the main menu
    private Button playButton; //Button that starts the game
    private Button backToMenuButton; //Button that allows the user to go back to the MainMenu
    private Button creditsButton; //Button that brings the user to a credit page
    private Button howToButton; //Button that brings the user to a set of instruction
    
    //A top-level container that hosts a Scene
    private Stage window;
    
    //The scenes represent the physical contents of a JavaFX application in the mainMenu, creditMenu, and playMenu
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
        //Instatiation of the Stage window
        window = stage;
        
        //Have the music to play automatically as soon as the user opens the menu
        Music.loop("ollie.mp3");
        //Declaration and Instantiaion of color
        Color c = Color.GAINSBORO;
        
        //Instantiaion of buttons in MainMenu class
        playButton = new Button("Play");
        creditsButton = new Button("Credits");
        backToMenuButton = new Button("Back To Menu");
        howToButton = new Button("How to Play");
        
        //Sets the length of the button to a set size
        playButton.setMaxWidth(150);
        howToButton.setMaxWidth(150);
        creditsButton.setMaxWidth(150);
        
        //This class will handle the button event when user hits Play or Credits (changes the scene to Play and Credit)
        playButton.setOnAction(e -> window.setScene(playScene));
        howToButton.setOnAction(this::howTo);
        creditsButton.setOnAction(this::credits);
        
        //Layout for the Main scene - children are laid out in a veritcal column
        VBox main = new VBox(20);
        
        //Centers the layout in the middle of the scene
        main.setAlignment(Pos.CENTER);
        
        //Declaration and instantiation of a label
        Label label = new Label(); 
        ImageView iv = new ImageView(new Image("Title.PNG"));
        label.setGraphic(iv);

        //Adds the buttons and label onto the layout of the scene
        main.getChildren().addAll(label, playButton, howToButton, creditsButton);
        
       //Instantiation of the scene in MainMenu
        mainScene = new Scene(main, 900, 600, c);
        
        //Set the color of the background to Gainsboro
        main.setBackground(new Background(new BackgroundFill(c, CornerRadii.EMPTY, Insets.EMPTY)));

        //User can not resize the form
        window.setResizable(false);
        
        //Sets the title of the window
        window.setTitle("RGB GANG");
        window.setScene(mainScene);
        
        //Stage will now appear so that the user can interact with it
        window.show();
    }
    
    /**
     * This method will be called when the user clicks the play button. It
     * will switch screens to a character select screen.
     * 
     * @param pClick - an event representing the user clicking the play button
     */
    private void play(ActionEvent pClick)
    {
        //Layout for Credit Scene
        VBox creditLayout = new VBox(20);
        
        //Centers the layout of the Credit scene in the middle
        creditLayout.setAlignment(Pos.CENTER);
        creditLayout.setBackground(new Background(new BackgroundFill(Color.GAINSBORO, CornerRadii.EMPTY, Insets.EMPTY)));
        
        //This class will handle the button event when user hits Back To Menu
        playScene = new Scene(creditLayout, 900, 600);
        window.setScene(creditScene);
    }
    
    /**
     * This method will be called when the user clicks the how to play button. It
     * When clicked, it will switch screens and show instructions on how to
     * play.
     * 
     * @param howToClick - an event representing the user clicking the how to
     * play button
     */
    public void howTo(ActionEvent howtoClick)
    {
        //Layout for Credit Scene
        VBox instructionLayout = new VBox(20);
        
        //Centers the layout of the Credit scene in the middle
        instructionLayout.setAlignment(Pos.CENTER);
        
        //Set the color of the background to Gainsboro
        instructionLayout.setBackground(new Background(new BackgroundFill(Color.GAINSBORO, CornerRadii.EMPTY, Insets.EMPTY)));
        
        // Declaration and Instantiation of the Credit Texts
        Text instructionText = new Text();
       
        //Setting the font to Baskerville
        instructionText.setFont(Font.font("Baskerville", 20));
        
        String instructionString = "Press the arrow keys to move up, left, or right \n" 
                              + "Anything that is red will automatically kill you \n" 
                              + "Blue walls allow you to double jump while green wall causes you to stick to walls \n"
                              + "Complete all three sectors to beat the game\n"
                              + "Good luck Adventurer, may the RGB guide you through the game! \n";

        //Setting the value of the creditText to the string creditString
        instructionText.setText(instructionString);
        
        //Centering the text into middle of the scene
        instructionText.setTextAlignment(TextAlignment.CENTER);
        
        //Adding nodes to the layout
        instructionLayout.getChildren().add(instructionText);
        instructionLayout.getChildren().add(backToMenuButton);
        
        //This class will handle the button event when user hits Back To Menu
        backToMenuButton.setOnAction(e -> window.setScene(mainScene));
        creditScene = new Scene(instructionLayout, 900, 600);
        
        //Display the scene to the user so that he/she can interact with it
        window.setScene(creditScene);
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
        
        //Set the color of the background to Gainsboro
        creditLayout.setBackground(new Background(new BackgroundFill(Color.GAINSBORO, CornerRadii.EMPTY, Insets.EMPTY)));
        
        //Centers the layout of the Credit scene in the middle
        creditLayout.setAlignment(Pos.CENTER);
        
        //Declaration and Instantiation of the Credit Texts
        Text creditText = new Text();
        
        //Setting the font to Baskerville
        creditText.setFont(Font.font("Baskerville", 20));
        
        String creditString = "WELCOME to RGB \n\n" 
                              + "Creators - Daniel Herrick, Jonathan Lee, Rupin Mittal, and Brandon Wang \n"
                              + "Graphics by Maria Dhilla and Music by Cole Clarkson (IG: @cudi_cole)\n"                      
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
        
        //Display the scene to the user so that he/she can interact with it
        window.setScene(creditScene);
    }
}