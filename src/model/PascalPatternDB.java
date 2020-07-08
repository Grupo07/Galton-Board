
package model;

import java.util.Hashtable;

/**
 * Contains information related to a set of Pascal triangle patterns
 * 
 * @author Luis Mariano Ramírez Segura
 */
public class PascalPatternDB {
    
    private Hashtable<String, String> database;

    public PascalPatternDB() {
        this.database = new Hashtable<String, String>(); 
        database.put("first", "The first diagonal contains exclusively the number one");
        database.put("second", "The second diagonal contains all the natural consecutive numbers (1, 2, 3, 4 ...)");
        database.put("third", "The third diagonal contains the triangular numbers (1, 3, 6, 10...)");
        database.put("fourh", "The third diagonal contains the tetrahedral numbers (1, 4, 10, 20...)");
        database.put("oddeven", "If odd and even numbers have different number, the Sierpinski Triangle pattern can be seen");
        database.put("powers", "Summing the rows gives the powers of two");
        database.put("simmetry", "The triangle is perfectly symmetrical");
        database.put("simmetry", "The triangle is perfectly symmetrical");
        database.put("fibonacci", "The Fibonacci sequence can be seen");
    }
    
    /**
     * Returns the information related to a Pascal triangle pattern
     * 
     * @param patternName name of the Pascal triangle pattern
     * @return pattern information
     */
    public String getPatternInfo(String patternName) {
        String info = (database.containsKey(patternName)) ? database.get(patternName) : "";
        return info;
    }
    
}
