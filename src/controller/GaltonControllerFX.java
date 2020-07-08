/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static java.lang.Thread.sleep;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import model.GaltonCircle;

/**
 * FXML Controller class
 *
 * @author esteb
 */
public class GaltonControllerFX implements Initializable {

    @FXML
    private Button simulateButton;
    @FXML
    private Spinner<Integer> rowsSpinner;
    @FXML
    private Spinner<Integer> speedSpinner;
    @FXML
    private Spinner<Double> probabilitySpinner;
    
    SpinnerValueFactory<Integer> factoryValuesRows = 
            new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 5, 1);
    
    SpinnerValueFactory<Integer> factoryValuesBalls = 
            new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 10, 1);
    
    SpinnerValueFactory<Double> factoryValuesProbability = 
            new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 1, 0.5, 0.1);
    @FXML
    private Pane pane;
    
    private GaltonController galton;
    private int triangleWidth = 40;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rowsSpinner.setEditable(true);
        rowsSpinner.setValueFactory(factoryValuesRows);
        speedSpinner.setEditable(true);
        speedSpinner.setValueFactory(factoryValuesBalls);
        probabilitySpinner.setEditable(true);
        probabilitySpinner.setValueFactory(factoryValuesProbability);
        galton = new GaltonController(rowsSpinner.getValue());
    }    

    @FXML
    private void simulateGaltonBoard(ActionEvent event) {
        pane.getChildren().clear();
        drawDots(rowsSpinner.getValue());
        int x = (triangleWidth / 2) * (rowsSpinner.getValue()) + triangleWidth;
        //Setting galton values
        galton.setBoardHeight(rowsSpinner.getValue());
        galton.setRightProbability(Float.parseFloat(probabilitySpinner.getValue()+""));
        
        
        for (int j = 0; j < speedSpinner.getValue() ;  j++) {
            try {
                
                GaltonCircle galtonCircle = galton.generateCircle();
                DropBallThread drop = new DropBallThread(pane,
                        galtonCircle,triangleWidth,x,25);
                Runnable r = drop;
                Thread t = new Thread(r);
                t.start();
                sleep(100);
                pane.getChildren().add(drop.getCircle());
                increaseAmountBalls(galtonCircle.getPath());
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(GaltonControllerFX.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void increaseAmountBalls(String[] path){
        
    }
    
    private void paintDots(){
        
    }
    
     private void drawDots(int rows) {
        int y = 40;
        int remainingRows = rows;
        int currentRow = 1;
        int count = 0;
        int x = (triangleWidth / 2) * (rows + 1 - currentRow) + triangleWidth;
        int first = (triangleWidth / 2) * (rows + 1 - currentRow);
        for (int row = 1; row < rows + 1; row++) {
            for (int celd = 0; celd < row; celd++) {
                Circle circle = new Circle(x, y, 5);
                circle.setFill(Color.web("#1d284f"));
                if (celd == row-1) {
                    x -= ((triangleWidth) * row) - (triangleWidth / 2);
                    y += triangleWidth;
                } else {
                    x += triangleWidth;
                }
                pane.getChildren().add(circle);
            }

        }

    }
    
    
    
}
