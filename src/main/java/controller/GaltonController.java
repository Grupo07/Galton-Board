
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
    
    int boardHeight;
    float rightProbability;

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
    
    /**
     * Updates the probability of the generated circles of falling to the right
     * @param rightProbability probability of falling to the right
     */
    public void updateRightProbability(float rightProbability) {
        this.rightProbability = rightProbability;
    }
    
}
