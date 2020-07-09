package controller;

import app.App;
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
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 *
 * @author Esteban Guzmán Ramírez
 */
public class switcherController implements Initializable {

    @FXML
    private Button pascalButton;
    @FXML
    private Button galtonButton;
    @FXML
    private Pane pane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Label label = new Label("Select a mode to start");
        label.setStyle("-fx-font-size: 40px;");
        label.setLayoutX(207);
        label.setLayoutY(246);
        pane.getChildren().add(label);
        pane.getStylesheets().add(App.class.getResource("/view/config/general.css").toExternalForm());
        pascalButton.getStylesheets().add(App.class.getResource("/view/config/unpressMode.css").toExternalForm());
        galtonButton.getStylesheets().add(App.class.getResource("/view/config/unpressMode.css").toExternalForm());
    }

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
            Logger.getLogger(switcherController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
            Logger.getLogger(switcherController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
