/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.animation.PathTransition;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;
import model.GaltonCircle;

/**
 *
 * @author esteb
 */
public class DropBallThread implements Runnable {
    
    private Pane pane;
    private Circle circle;
    private GaltonCircle galtonCircle;
    private int radius;
    private int x;
    private int y;

    public DropBallThread(Pane pane, GaltonCircle galtonCircle, int radius, int x, int y) {
        this.pane = pane;
        this.galtonCircle = galtonCircle;
        this.radius = radius;
        this.x = x;
        this.y = y;
    }
    
    public Circle getCircle() {
        return circle;
    }

    @Override
    public void run() {
        circle = new Circle(x , y , radius/4);
        circle.setFill(Color.web("#87ceb0"));
        circle.setStyle("-fx-stroke: #5aa7a1; -fx-stroke-width: 1;");
        Path path = new Path();
        MoveTo moveTo = new MoveTo(x, y);
        path.getElements().add(moveTo);
        for (int i = 0; i < galtonCircle.getPath().length ; i++) {
            LineTo line;
            y += radius;
            if (galtonCircle.getPath()[i].equalsIgnoreCase("right")) {
                x += radius/2;
            } else {
                x -= radius/2;
            }
            line = new LineTo(x, y);
            path.getElements().add(line);
        }

        //Creating the path transition 
        PathTransition pathTransition = new PathTransition();

        //Setting the duration of the transition 
        pathTransition.setDuration(Duration.millis(10000));

        //Setting the node for the transition 
        pathTransition.setNode(circle);

        //Setting the path for the transition 
        pathTransition.setPath(path);

        //Playing the animation 
        pathTransition.play();
        
    }
    
}
