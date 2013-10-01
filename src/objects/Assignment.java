package objects;
/**
 * Object representing an assignment for a course
 * 
 * @author Jesse W. Milburn
 * @date 01 October, 2013
 */
public class Assignment {
    private String name;
    private int worth;
    
    /**
     * Creates an Assignment object
     * 
     * @param an	Name of the assignment
     * @param val	Maximum point value of the assignment
     */
    public Assignment(String an, int val) {
        name = an;
        worth = val;
    }
    
    /**
     * Sets a name to the name field
     * 
     * @param an	Sets the name of the assignment
     */
    public void setName(String an) {
    	name = an;    	
    }
    
    /**
     * Sets the maximum point value for the assignment
     * 
     * @param val	Maximum point value of the assignment
     */
    public void setWorth(int val) {
    	worth = val;
    }
    
    /**
     * Fetches the name field of the assignment
     * 
     * @return		The title of the assignment
     */
    public String getName() {
        return name;
    }
    
    /**
     * Fetches the maximum point value for the assignment
     * 
     * @return		Maximum point value of the assignment
     */
    public int getWorth() {
        return worth;
    }
}
