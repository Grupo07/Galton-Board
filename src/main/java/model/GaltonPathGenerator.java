
package model;

/**
 * Offers useful utilities to work with the Galton board
 * 
 * @author Luis Mariano Ramirez Segura
 */
public class GaltonPathGenerator {
    
    /**
     * Generates the falling path of a ball 
     * based on the probability given
     * 
     * @param galtonBoardHeight height of the Galton board
     * @param rightProbability probability of falling to the right
     * @return array of right or left strings
     */
    public static String[] getPath(int galtonBoardHeight, float rightProbability) {
        String[] path = new String[galtonBoardHeight];
        for (int i = 0; i < path.length; i++) {
            path[i] = getLeftOrRight(rightProbability);
        }
        return path;
    }
    
    /**
     * Returns right or left based on a given probability
     * 
     * @param rightProbability probability of falling to the right
     * @return direction as string
     */
    public static String getLeftOrRight(float rightProbability) {
        if (Math.random() <= rightProbability)
            return "right";
        return "left";
    }
    
}
