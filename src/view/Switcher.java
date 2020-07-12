package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 *
 * @author Esteban Guzmán Ramírez
 */
public class Switcher implements Initializable {

    @FXML
    private Button pascalButton;
    @FXML
    private Button galtonButton;
    @FXML
    private Pane pane;
    
    private static int rows = 8;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        pane.getStylesheets().add(App.class.getResource("/view/config/general.css").toExternalForm());
        pascalButton.getStylesheets().add(App.class.getResource("/view/config/pressedMode.css").toExternalForm());
        galtonButton.getStylesheets().add(App.class.getResource("/view/config/unpressMode.css").toExternalForm());
        try {
            Pane newPanel = (Pane) FXMLLoader.load(getClass().getResource("/view/PascalView.fxml"));
            pane.getChildren().add(newPanel);
            
        } catch (IOException ex) {
            Logger.getLogger(Switcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * init Pascal mode
     * @param event onClick PascalModeButton
     */
    @FXML
    private void loadPascalView(ActionEvent event) {
        try {
            Pane newPanel = (Pane) FXMLLoader.load(getClass().getResource("/view/PascalView.fxml"));
            pane.getChildren().clear();
            pane.getChildren().add(newPanel);
            galtonButton.getStylesheets().clear();
            pascalButton.getStylesheets().clear();
            pascalButton.getStylesheets().add(App.class.getResource("/view/config/pressedMode.css").toExternalForm());
            galtonButton.getStylesheets().add(App.class.getResource("/view/config/unpressMode.css").toExternalForm());
        } catch (IOException ex) {
            Logger.getLogger(Switcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * init Galton Mode
     * @param event onClick GaltonModeButton
     */
    @FXML
    private void loadGaltonView(ActionEvent event) {
        try {
            Pane newPanel = FXMLLoader.load(getClass().getResource("/view/GaltonView.fxml"));
            pane.getChildren().clear();
            pane.getChildren().add(newPanel);
            galtonButton.getStylesheets().clear();
            pascalButton.getStylesheets().clear();
            galtonButton.getStylesheets().add(App.class.getResource("/view/config/pressedMode.css").toExternalForm());
            pascalButton.getStylesheets().add(App.class.getResource("/view/config/unpressMode.css").toExternalForm());
        } catch (IOException ex) {
            Logger.getLogger(Switcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static int getRows() {
        return rows;
    }

    public static void setRows(int rows) {
        Switcher.rows = rows;
    }
    
    

}
