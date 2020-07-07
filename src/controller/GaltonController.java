
package controller;

import model.GaltonCircle;
import model.GaltonPathGenerator;
import static model.GaltonPathGenerator.getPath;

/**
 * Controller to access backend Galton board functionality
 * 
 * @author Luis Mariano Ramírez Segura
 */
public class GaltonController {
    
    private int boardHeight;
    private float rightProbability;

    public GaltonController(int boardHeight) {
        this.boardHeight = boardHeight;
        this.rightProbability = 0.5f;
    }
    
    /**
     * Returns a new GaltonCircle instance
     * @return new GaltonCircle instance
     */
    public GaltonCircle generateCircle() {
        return new GaltonCircle(GaltonPathGenerator.getPath(boardHeight, rightProbability));
    }

    public void setRightProbability(float rightProbability) {
        this.rightProbability = rightProbability;
    }

    public void setBoardHeight(int boardHeight) {
        this.boardHeight = boardHeight;
    }
    
}
