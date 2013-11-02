package tests;

import tests.TestHelper;

/**
 * Testing the objects
 * 
 * @author Jesse W. Milburn
 * @author Jacob E. Foster
 * @date 01 October, 2013
 */
public class TestObjects {

    public static TestHelper t = new TestHelper();

    public static void main(String[] args) {
        // Add test cases here...
    	

        //need a check in case two students with the same name are added will need to differentiate between them
    	/*if(t.courses[0].addStudent("Wanda", "Styles")) {
    		System.out.println("Dual Students were allowed to be added");
    	}*/
    	
    	//removing a student who is not in the class by name

        //removing a student by index which is out of bounds

        //removing an assignment category which doesn't exist by name

        //removing an assignment category by index which is out of bounds

        //removing an assignment which doesn't exist by name

        //removing an assignment by index which is out of bounds
 
    	//adding a student adds a ghostStudent
    	for (int i = 0; i < 10; i++) {
    		t.courses[0].addStudent(Integer.toString(i), Integer.toString(i));
    	}
    	for (int i = 0; i < t.courses[0].getNumberOfGhostStudents(); i++) {
    		System.out.println(i + " " + t.courses[0].getGhostStudent(i).getPseudoName());
    	}
    }
}
