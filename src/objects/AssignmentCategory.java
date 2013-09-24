package objects;

import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class AssignmentCategory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AssignmentCategory
{
    private String categoryName;
    private List<Assignment> assignments = new ArrayList<Assignment>();
    
    //constructor/s
    /**
     * 
     */
    public AssignmentCategory(String ac) {
        categoryName = ac;
    }
    
    //setters
    /**
     * 
     */
    public void setName(String ac) {
        categoryName = ac;
    }
    
    //getters
    /**
     * 
     */
    public String getName() {
        return categoryName;
    }
    
    /**
     * 
     */
    public Assignment getAssignment(int index) {
        return assignments.get(index);    
    }
    
    //above has been tested
    
    
    
    
    
    
    //below has been tested
    
    public void addAssignment(String an, int val) {
        assignments.add(new Assignment(an, val));
    }
    
    
    
}
