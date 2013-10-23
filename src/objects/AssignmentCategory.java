package objects;

import java.util.ArrayList;
import java.util.List;
/**
 * Object representing a category of assignments for a course
 * i.e. tests, exams, labs, homework, etc
 * 
 * @Jesse W Milburn
 * @date 01 October, 2013
 */
public class AssignmentCategory {
    private String categoryName;
    private List<Assignment> assignments = new ArrayList<Assignment>();
    
    /**
     * Creates a category of assignments
     * 
     * @param ac	Name of the category being created
     */
    public AssignmentCategory(String ac) {
        categoryName = ac;
    }
    
    /**
     * Sets the name of the AssignmentCategory object
     * 
     * @param ac	Name of the category
     */
    public void setName(String ac) {
        categoryName = ac;
    }
    
    /**
     * Returns the name assigned to the assignment category
     * 
     * @return		String name of the category
     */
    public String getName() {
        return categoryName;
    }
    
    /**
     * Returns an Assignment object by index in the object ArrayList
     * 
     * @param index	The integer index in the ArrayList
     * @return		Assignment object
     */
    public Assignment getAssignment(int index) {
        return assignments.get(index);    
    }

    /**
     * Returns a List of Assignment objects
     * 
     * @return		List<Assignment> object
     */
    public List<Assignment> getAssignments() {
        return assignments;    
    }
    
    /**
     * Fetches the index of the assignment in the internal ArrayList by name
     * 
     * @param name	The name of the assignment the user is looking for
     * @return		The index of the assignment in the AssignmentCategory ArrayList
     */
    public int getAssignmentIndex(String name) {
        for (int i = 0; i < assignments.size(); i++) {
        	if (name == assignments.get(i).getName()) return i;
        }
    	return -1;
    }
    
    /**
     * Fetches the number of assignments currently stored in the assignments
     * ArrayList
     * 
     * @return		Number of assignments in this AssignmentCategory object
     */
    public int getNumberOfAssignments() {
    	return assignments.size();
    }
    
    /**
     * Adds and Assignment to the end of the assignments ArrayList
     * 
     * @param an	Name of the assignment
     * @param val	The maximum point value of the assignment
     */
    public void addAssignment(String an, int val) {
        assignments.add(new Assignment(an, val));
    }
    
    /**
     * Removes an assignment from the assignments ArrayList. Returns
     * null if the assignment does not exist in the list
     * 
     * @param name	The name of the assignment
     * @return		The Assignment object removed
     */
    public Assignment removeAssignment(String name) {
    	try {
    		return assignments.remove(getAssignmentIndex(name));
    	} catch (ArrayIndexOutOfBoundsException e) {
    		return null;
    	}
    	
    }
}
