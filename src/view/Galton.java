package view;

import controller.GaltonController;
import view.Switcher;
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

public class Galton implements Initializable {

    @FXML
    private Pane pane;
    @FXML
    private Button simulateButton;
    @FXML
    private Spinner<Integer> rowsSpinner;
    @FXML
    private Spinner<Integer> ballsSpinner;
    @FXML
    private Spinner<Double> probabilitySpinner;
    @FXML
    private Spinner<Integer> speedSpinner;

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
        int rows = Switcher.getRows();
        initSpinners(rows);
        galton = new GaltonController(rows);
        drawDots(rows);
    }

    /**
     * Define fatory values of spinners
     *
     * @param rows rows
     */
    private void initSpinners(int rows) {
        SpinnerValueFactory<Integer> factoryValuesRows
                = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, rows, 1);
        rowsSpinner.setEditable(true);
        rowsSpinner.setValueFactory(factoryValuesRows);
        SpinnerValueFactory<Integer> factoryValuesBalls
                = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10000, 100, 1);
        ballsSpinner.setEditable(true);
        ballsSpinner.setValueFactory(factoryValuesBalls);
        SpinnerValueFactory<Double> factoryValuesProbability
                = new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 1, 0.5, 0.1);
        probabilitySpinner.setEditable(true);
        probabilitySpinner.setValueFactory(factoryValuesProbability);
        SpinnerValueFactory<Integer> factoryValuesSpeed
                = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 4, 1);
        speedSpinner.setEditable(true);
        speedSpinner.setValueFactory(factoryValuesSpeed);
    }

    /**
     * start galton simulation
     *
     * @param event onClick of simulateButton
     */
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
            Logger.getLogger(Galton.class.getName()).log(Level.SEVERE, null, ex);
        }
        Switcher.setRows(rowsSpinner.getValue());
    }

    /**
     * Draw dots of galton board
     *
     * @param rows triangle height
     */
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

    /**
     * Draw balls droping in galton board
     *
     * @throws InterruptedException runneable
     */
    private void dropBalls() throws InterruptedException {
        for (int i = 0; i < ballsSpinner.getValue(); i++) {
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
                    pathTransition.setDuration(Duration.millis(10000 / speedSpinner.getValue()));
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

    /**
     * save the final position of one ball
     *
     * @param path path of one ball
     */
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

    /**
     * Update counters labels
     */
    private void updateCounters() {
        for (int i = 0; i < labelCounts.length; i++) {
            labelCounts[i].textProperty().bind(new SimpleIntegerProperty(countFinals[i]).asString());
        }
    }

    /**
     * init labels of counters
     */
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
