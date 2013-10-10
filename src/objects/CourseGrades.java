package objects;

import java.util.ArrayList;
/**
 * Two dimensional dynamic array to store grades for the MyCourse object.
 * 
 * @author Tarah K Marlow
 * @author Jesse W Milburn
 * @date 9 October, 2013
 */
public class CourseGrades
{
    private ArrayList<ArrayList<Double>> gradeBook;
    
    /**
     * Constructs a grade book
     */
    public CourseGrades() {
        gradeBook = new ArrayList<ArrayList<Double>>();
    }
    
    /**
     * Adds an assignment 'column' to the grade book. At the same time
     * it creates a placeholder for all of the students in the course
     * 
     * @param 	numberOfStudents	The number of students so the grade 'column'
     * 								can be padded with nulls
     */
    public void addAssignmentColumn(int numberOfStudents) {
    	gradeBook.add(new ArrayList<Double>());
    	for (int i = 0; i < numberOfStudents; i++) {
    		Double placeHolder = null;
    		gradeBook.get(gradeBook.size() - 1).add(placeHolder);//add student row for each assignment
    	}
    }
    
    /**
     * Adds a null Double field to the end of each AssignmentCategory
     * Assignment 
     */
    public void addStudentRow() {
    	Double temp = null;
    	for (int i = 0; i < gradeBook.size(); i++) {
    		gradeBook.get(i).add(temp);
    	}
    	
    }
    
    /**
     * remove an assignment 'column' of grades. Doesn't need to 
     * 
     * @param 	index	The index 'column' in the gradebook to be removed
     */
    public void removeAssignmentColumn(int index) {
    	gradeBook.remove(index);
    }
    
    /**
     * removes a students grades from the grade book
     * 
     * @param 	index	The index of the student in the gradebook
     */
    public void removeStudentRow(int index) {
    	for (int i = 0; i < gradeBook.size(); i++) {
    		gradeBook.get(i).remove(index);
    	}
    }
    
    /**
     * Sets a double value within the 2d array
     *     
     * @param	acIndex			the assignment category index
     * @param 	studentIndex	the student index
     * @param 	grade			the value to be added/replaced in the array
     */
    public void setGrade(int acIndex, int studentIndex, double grade) {
    	gradeBook.get(acIndex).set(studentIndex, grade);
    }
    
    /**
     * Returns a value stored in the array(check for null)
     * 
     * @param 	acIndex			The assignment category index
     * @param 	studentIndex	The students index
     * @return					double value in the specified position
     */
    public Double getGrade(int acIndex, int studentIndex) {
    	return gradeBook.get(acIndex).get(studentIndex);
    	
    }
}
