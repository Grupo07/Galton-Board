/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import app.App;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import model.PascalPositions;
import model.PascalRectangle;
import model.Position;

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
    private ComboBox<String> infoSelect;
    @FXML
    private Button showButton;
    
    private int triangleWidth = 40;
    
    SpinnerValueFactory<Integer> factoryValues = 
            new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 5, 1);
    @FXML
    private Pane pane;
    
    private PascalController pascal;
    private ObservableList<String> infoOptions = FXCollections.observableArrayList(
        "Diagonals",
        "Fibonacci",
        "OddEven",
        "Powers",
        "Simmetry"
        );
    private boolean nullTriangle = true;
    private ArrayList<PascalRectangle> pascalRectangles;
    @FXML
    private Label infoExplain;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rowSpinner.setEditable(true);
        rowSpinner.setValueFactory(factoryValues);
        pascal = new PascalController(rowSpinner.getValue());
        final Tooltip tool = new Tooltip("Vea que loquera");
        rowSpinner.setTooltip(tool);
        tool.setStyle("-fx-background-color: blue;");
        
        infoSelect.getItems().addAll(infoOptions);
        
    }

    @FXML
    private void generateTriangle(ActionEvent event) {
        paintTriangle();
        nullTriangle = false;
        generateButton.getStylesheets().clear();
        generateButton.getStylesheets().add(App.class.getResource("/view/config/general.css").toExternalForm());
        generateButton.setText("Generate");
    }

    private void setCoordinates(Integer rows, ArrayList<PascalRectangle> list) {
        int y = 30;
        int remainingRows = rows;
        int currentRow = 1;
        int count = 0;
        int x = (triangleWidth / 2) * (rows + 1 - currentRow) + triangleWidth / 2;
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

    @FXML
    private void showInfo(ActionEvent event) {
        
        if (infoSelect.getValue() == null) {
            infoSelect.getStylesheets().clear();
            infoSelect.getStylesheets().add(App.class.getResource("/view/config/error.css").toExternalForm());
        } else {
            infoSelect.getStylesheets().clear();
            infoSelect.getStylesheets().add(App.class.getResource("/view/config/general.css").toExternalForm());
            paintTriangle();
            String pattern = infoSelect.getValue().toLowerCase();
            ArrayList<PascalPositions> patternList = new ArrayList<PascalPositions>();
            String explain = "";
            int row = rowSpinner.getValue();
            if (pattern.equals("diagonals")) {
                patternList = pascal.getPascalPattern("first");
                patternList.addAll(pascal.getPascalPattern("second"));
                patternList.addAll(pascal.getPascalPattern("third"));
                patternList.addAll(pascal.getPascalPattern("fourth"));
                explain = pascal.getPatternInfo("first");
                explain += "\n" + pascal.getPatternInfo("second");
                explain += "\n" + pascal.getPatternInfo("third");
                explain += "\n" + pascal.getPatternInfo("fourh");
            } else if(pattern.equals("simmetry")){
                explain = pascal.getPatternInfo(pattern);
                int withd = (row/2)*triangleWidth;
                if(row % 2 != 0){
                    withd += triangleWidth/2;
                }
                Rectangle sideA = new Rectangle(searchX(row+1,0,row),30,
                        withd,row*triangleWidth);
                sideA.setFill(Color.web("#5aa7a1", 0.5));
                Rectangle sideB = new Rectangle(searchX(row + 1, 0 , 0),30,
                        withd,row*triangleWidth);
                sideB.setFill(Color.web("#1d284f", 0.5));
                pane.getChildren().addAll(sideA,sideB);
            } else if (pattern.equals("powers")){
                explain = pascal.getPatternInfo(pattern);
                patternList = pascal.getPascalPattern(pattern);
                paintPowers(row);
                
            } else {
                explain = pascal.getPatternInfo(pattern);
                patternList = pascal.getPascalPattern(pattern);
            }
            for (PascalPositions pascalPosition : patternList) {
                for (Position position : pascalPosition.getPositions()) {
                    int x = searchX(row, position.getColumn(), position.getRow());
                    int y = (position.getRow() * triangleWidth) + 30;
                    String color = "rgb(" + pascalPosition.getColor().getRed()
                            + "," + pascalPosition.getColor().getGreen()
                            + "," + pascalPosition.getColor().getBlue()
                            + ")";
                    Rectangle rectangle = new Rectangle(x, y,
                            triangleWidth, triangleWidth);
                    rectangle.setFill(Color.TRANSPARENT);
                    rectangle.setStyle("-fx-stroke:" + color
                            + "; -fx-stroke-width: 10;"
                            + "-fx-stroke-type:INSIDE");
                    pane.getChildren().add(rectangle);
                }
            }
            generateButton.setText("Reset");
            infoExplain.setText("Info explain:\n"+explain);
            infoExplain.setStyle("-fx-border-color: #87ceb0");
            pane.getChildren().add(infoExplain);
        }
    }
    
    private int searchX(int rows, int wantColum, int wantRow){
        int x = (triangleWidth / 2) * (rows) + triangleWidth/2;
        for (int row = 0; row <= wantRow; row++) {
            for (int colum = 0; colum <= row; colum++) {
                if (wantColum == colum && wantRow == row) {
                    return x;
                } else {
                    if (colum == row) {
                        x -= ((triangleWidth) * (row + 1)) - (triangleWidth / 2);
                    } else {
                        x += triangleWidth;
                    }

                }
            }
        }
        return 0;
    }

    private void paintTriangle() {
        pane.getChildren().clear();
        pascal.updateTriangleHeight(rowSpinner.getValue());
        pascalRectangles = pascal.getPascalRectangles();
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
    private void paintPowers(int rows){
        for(int row = 0; row < rows; row++){
            Label powerLabel = new Label("= "+Math.pow(2, row));
            powerLabel.setLayoutX(searchX(rows+1,row,row) + triangleWidth);
            powerLabel.setLayoutY( 36 + (row)*triangleWidth);
            pane.getChildren().add(powerLabel);
        }
    }
    
}
