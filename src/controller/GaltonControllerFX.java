package controller;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PathTransition;
import javafx.application.Platform;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;
import model.GaltonCircle;

/**
 * FXML Controller class
 *
 * @author Esteban Guzmán Ramírez
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

    SpinnerValueFactory<Integer> factoryValuesRows
            = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 5, 1);

    SpinnerValueFactory<Integer> factoryValuesBalls
            = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10000, 100, 1);

    SpinnerValueFactory<Double> factoryValuesProbability
            = new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 1, 0.5, 0.1);
    @FXML
    private Pane pane;

    private GaltonController galton;
    private int triangleWidth = 40;
    private Random rand = new Random();
    private Label labelCounts[];
    private int countFinals[];

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

        //Setting galton values
        galton.setBoardHeight(rowsSpinner.getValue());
        galton.setRightProbability(Float.parseFloat(probabilitySpinner.getValue() + ""));
        labelCounts = new Label[rowsSpinner.getValue() + 1];
        countFinals = new int[rowsSpinner.getValue() + 1];
        paintCounters();
        try {
            dropBalls();
        } catch (InterruptedException ex) {
            Logger.getLogger(GaltonControllerFX.class.getName()).log(Level.SEVERE, null, ex);
        }
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
                if (celd == row - 1) {
                    x -= ((triangleWidth) * row) - (triangleWidth / 2);
                    y += triangleWidth;
                } else {
                    x += triangleWidth;
                }
                pane.getChildren().add(circle);
            }

        }

    }

    private void dropBalls() throws InterruptedException {
        for (int i = 0; i < speedSpinner.getValue(); i++) {
            Circle circle = new Circle(0, 0, triangleWidth / 4);
            circle.setFill(Color.rgb(rand.nextInt(200), rand.nextInt(200), rand.nextInt(200)));
            circle.setStyle("-fx-stroke: #5aa7a1; -fx-stroke-width: 1;");
            pane.getChildren().add(circle);
            Thread taskThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    int x = (triangleWidth / 2) * (rowsSpinner.getValue()) + triangleWidth;
                    int y = 25;
                    Path path = new Path();
                    MoveTo moveTo = new MoveTo(x, y);
                    path.getElements().add(moveTo);
                    PathTransition pathTransition = new PathTransition();
                    pathTransition.setDuration(Duration.millis(1000));
                    GaltonCircle galtonCircle = galton.generateCircle();
                    increaseAmountBalls(galtonCircle.getPath());
                    for (int j = 0; j < galtonCircle.getPath().length; j++) {
                        LineTo line;
                        y += triangleWidth;
                        if (galtonCircle.getPath()[j].equalsIgnoreCase("right")) {
                            x += triangleWidth / 2;
                        } else {
                            x -= triangleWidth / 2;
                        }
                        line = new LineTo(x, y);
                        path.getElements().add(line);
                    }
                    pathTransition.setNode(circle);
                    pathTransition.setPath(path);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            pathTransition.play();
                            updateCounters();

                        }
                    });
                }
            });
            taskThread.start();
        }

    }

    private void increaseAmountBalls(String[] path) {
        float position = (rowsSpinner.getValue() / 2);
        if (rowsSpinner.getValue() % 2 != 0) {
            position += 0.5;
        }
        for (int i = 0; i < path.length; i++) {
            if (path[i].equalsIgnoreCase("right")) {
                position += 0.5;
            } else {
                position -= 0.5;
            }

        }
        countFinals[(int) position] += 1;
    }

    private void updateCounters() {
        for (int i = 0; i < labelCounts.length; i++) {
            labelCounts[i].textProperty().bind(new SimpleIntegerProperty(countFinals[i]).asString());
        }
    }

    private void paintCounters() {
        int x = getX(0, rowsSpinner.getValue()) + 15;
        int y = 40 + triangleWidth * rowsSpinner.getValue();
        for (int i = 0; i < labelCounts.length; i++) {
            countFinals[i] = 0;
            labelCounts[i] = new Label(String.valueOf(countFinals[i]));
            labelCounts[i].setLayoutX(x);
            labelCounts[i].setLayoutY(y);
            x += triangleWidth;
            pane.getChildren().add(labelCounts[i]);
        }
    }

    private int getX(int wantColum, int wantRow) {
        int x = (triangleWidth / 2) * (rowsSpinner.getValue()) + triangleWidth / 2;
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
        return -1;
    }

}
