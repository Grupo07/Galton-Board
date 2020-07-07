/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import model.PascalRectangle;

/**
 * FXML Controller class
 *
 * @author esteb
 */
public class PascalControllerFX implements Initializable {

    @FXML
    private Button generateButton;
    @FXML
    private Spinner<Integer> rowSpinner;
    @FXML
    private ComboBox<?> infoSelect;
    @FXML
    private Button showButton;
    
    private int triangleWidth = 40;
    
    SpinnerValueFactory<Integer> factoryValues = 
            new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 5, 1);
    @FXML
    private Pane pane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rowSpinner.setEditable(true);
        rowSpinner.setValueFactory(factoryValues);
        
        final Tooltip tool = new Tooltip("Vea que loquera");
        rowSpinner.setTooltip(tool);
        tool.setStyle("-fx-background-color: blue;");
    }

    @FXML
    private void generateTriangle(ActionEvent event) {
        pane.getChildren().clear();
        PascalController pascal = new PascalController(rowSpinner.getValue());
        ArrayList<PascalRectangle> pascalRectangles = pascal.getPascalRectangles();
        setCoordinates(rowSpinner.getValue(), pascalRectangles);
        for (int i = 0; i < pascalRectangles.size(); i++) {
            Rectangle rectangle = new Rectangle(
                    pascalRectangles.get(i).getDrawable().getBounds2D().getX(),
                    pascalRectangles.get(i).getDrawable().getBounds2D().getY(),
                    triangleWidth, triangleWidth);
            rectangle.setFill(Paint.valueOf("#87ceb0"));
            rectangle.setStyle("-fx-stroke: #5aa7a1; -fx-stroke-width: 1;");
            int binomialNumber = pascalRectangles.get(i).getBinomialCoefficient();
            Label binomialLabel = new Label(binomialNumber+"");
            binomialLabel.setStyle("-fx-text-fill: #324765;");
            if (binomialNumber > 99) {
                binomialLabel.setLayoutX(pascalRectangles.get(i).getDrawable().getBounds2D().getCenterX() - 10);
                binomialLabel.setLayoutY(pascalRectangles.get(i).getDrawable().getBounds2D().getCenterY() - 6);
            } else if (binomialNumber > 9 ) {
                binomialLabel.setLayoutX(pascalRectangles.get(i).getDrawable().getBounds2D().getCenterX() - 6);
                binomialLabel.setLayoutY(pascalRectangles.get(i).getDrawable().getBounds2D().getCenterY() - 6);
            } else {
                binomialLabel.setLayoutX(pascalRectangles.get(i).getDrawable().getBounds2D().getCenterX() - 2);
                binomialLabel.setLayoutY(pascalRectangles.get(i).getDrawable().getBounds2D().getCenterY() - 6);
            }
            pane.getChildren().addAll(rectangle,binomialLabel);
        }
        
        
    }

    private void setCoordinates(Integer rows, ArrayList<PascalRectangle> list) {
        int y = 30;
        int remainingRows = rows;
        int currentRow = 1;
        int count = 0;
        int x = (triangleWidth / 2) * (rows + 1 - currentRow) + triangleWidth/2;
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setDimensions(x, y, triangleWidth, triangleWidth);
            count++;
            if (count == currentRow) {
                remainingRows += -1;
                count = 0;
                x -= ((triangleWidth) * currentRow) - (triangleWidth / 2);
                currentRow++;
                y += triangleWidth;

            } else {
                x += triangleWidth;
            }
        }
    }

    
    
}
