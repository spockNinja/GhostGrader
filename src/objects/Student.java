package objects;

/**
 * Class Student models a students first, last, and full name as well
 * as holding a pseudo name that can not be altered after being assigned
 * to aid in obfuscation.
 * 
 * @Jesse W Milburn
 * @version
 */
public class Student {
    private String firstName, lastName, fullName;
    private String pseudoName;
    
    /**
     * Constructs a student object
     * 
     * @param fn	first name of the student	
     * @param ln	last name of the student
     * @param p		pseudo name of the student
     */
    public Student(String fn, String ln, String p) {
        firstName = fn;
        lastName= ln;
        pseudoName = p;
        fullName = ln + ", " + fn;
    }
    
    //begin setter methods
    /**
     * Sets the students first name, in case of a correction to the first name
     * it re-factors the full name of the student by changing the first name in 
     * the full name parameter
     * 
     * @param fn	first name
     */
    public void setFirstName(String fn) {
    	firstName = fn;
    	fullName = lastName + ", " + firstName;
    }
    
    /**
     * Sets the students last name, in case of a correction to the last name
     * it re-factors the full name of the student by changing the last name in
     * the full name parameter
     * 
     * @param ln	last name
     */
    public void setLastName(String ln) {
    	lastName = ln;
    	fullName = lastName + ", " + firstName;    	
    }
    //end setter methods
    
    //begin getter methods
    /**
     * Returns the first name of the student
     * 
     * @return		First name of the student
     */
    public String getFirstName() {
        return firstName;
    }
    
    /**
     * Returns the last name of the student
     * 
     * @return		Last name of the student
     */
    public String getLastName() {
    	return lastName;
    }
    
    /**
     * Returns the full name of the student in 'last, first' format
     * 
     * @return		Full name of the student
     */
    public String getFullName() {
    	return fullName;  	
    }
    
    /**
     * Returns the pseudo name assigned to the student
     * 
     * @return		Pseudo name8
     */
    public String getPseudoName() {
        return pseudoName;
    }
    //end getter methods
    
}
