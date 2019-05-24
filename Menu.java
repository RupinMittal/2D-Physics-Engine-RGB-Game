import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Abstract class Menu - This class contains the common functions of both 
 * PauseMenu and MainMenu
 *
 * @author Daniel Herrick
 * @version Menu Abstract Class - RGB
 */
public abstract class Menu
{
    protected Button options;
    protected Button credits;
    protected Button back;
    protected Button endGame;
    
    public abstract void createButtons();
    public abstract void displayButtons();
    public abstract void runMenu();
    public abstract void back();
    
    public void options()
    {
    }
    
    public void credits()
    {
    }
    
    public void efffecrs()
    {
    }
}
