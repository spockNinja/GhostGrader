package objects;


/**
 * Write a description of class Assignment here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Assignment
{
    private String name;
    private int worth;
    
    public Assignment(String an, int val) {
        name = an;
        worth = val;
    }
    
    public int getWorth() {
        return worth;
    }
    
    public String getName() {
        return name;
    }
}
