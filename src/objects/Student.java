package objects;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * Class Student models a students first, last, and full name as well
 * as holding a pseudo name that can not be altered after being assigned
 * to aid in obfuscation.
 * 
 * @Jesse W Milburn
 * @date 01 October, 2013
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
     * @return		Pseudo name
     */
    public String getPseudoName() {
        return pseudoName;
    }
    
    /**
     * Places student into in a text file found in "archive/records/StudentName-CourseIDCourseNumber-Semeste.txtr"
     */
    public void archiveStudent(MyCourse course) {
    	String name = getLastName() + getFirstName();
    	String courseInfo = '-' +  course.getCourseID() + course.getCourseNumber() + '-' + course.getSemester();
    	name = name.replaceAll("\\s+", "");
    	courseInfo = courseInfo.replaceAll("\\s+", "");
    	
    	String filePath = "gradebooks" + System.getProperty("file.separator") + "archive" + System.getProperty("file.separator") + 
    						"records" + System.getProperty("file.separator");

    	//FIXME mkdir doesn't work, directory must exist before file creation
    	File path = new File(filePath);
    	path.mkdir();
    	
    	filePath += name + courseInfo;
    	
    	File file = new File(filePath + ".txt");
    	
    	//FIXME should add current date to end of file instead of random number
    	if (file.exists()) {
    		int random = (int)(Math.random() * 1000 + 1);
    		filePath += "-" + random;
    		file = new File(filePath + ".txt");
    	}
    	
    	try {
    		file.createNewFile();
    		Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"));
    		
    		writer.write(getFullName() + " - " + course.getName() + System.getProperty("line.separator"));
    		
    		for (int i = 0; i < course.getNumberOfAssignmentCategories(); i++) {
    			AssignmentCategory asnCat = course.getAssignmentCategory(i);
    			writer.write(System.getProperty("line.separator") + asnCat.getName() + System.getProperty("line.separator"));
    			
    			for (int j = 0; j < asnCat.getNumberOfAssignments(); j++) {
    				Assignment asn = asnCat.getAssignment(j);
    				writer.write(asn.getName() + ": " + asn.getGrade(getPseudoName()) + 
    					"/" + asn.getWorth() + System.getProperty("line.separator"));
    			}
    		}
    		
    		writer.close();
    	} catch (IOException e) {
    		System.out.println(e);
    	}
    }
    
    /**
     * Takes all of the student's information and converts it to a GhostStudent
     * 
     * @return		GhostStudent object
     */
}
