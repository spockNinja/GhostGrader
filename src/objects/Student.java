package objects;

/**
 * Write a description of class Student here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Student
{
    private String firstName, lastName, fullName;
    private String pseudoName;
        
    public Student(String fn, String ln, String p) {
        firstName = fn;
        lastName= ln;
        pseudoName = p;
        fullName = ln + ", " + fn;
    }
    //setters need to reconstruct full name for setting first name or setting last name
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
    	return lastName;
    }
    public String getPseudoName() {
        return pseudoName;
    }
    public String getFullName() {
    	return fullName;  	
    }
}
