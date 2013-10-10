package objects;

import java.util.ArrayList;
import java.util.Random;
import java.text.DecimalFormat;
/**
 * Populate objects poke at them
 * 
 * @author Jesse W. Milburn
 * @date 01 October, 2013
 */
public class GhostGraderObjectsTestFile {
    public static void main(String[] args) {
    	int totalStudents = 20;
        String[] studentList = {"Wanda Styles", "Peter Frampton", "Bobby Cox", "Linda Friendly",
                                "Grinds Gears", "Super Cheeky", "Randy Baby", "Seth McFarlane",
                                "Andy Dick", "Ten Isenuf"};
        String[] pns = {"Alice Blue", "Acid Green", "Brown", "Deep Champagne", "Donkey Brown",
        				"Flame", "Han Purple", "Iceberg", "Kombu Green", "Ghost White",
                        "Patriarch", "Phlox", "Light Coral", "Khaki", "Lavender Blush",
                        "Medium Turquoise", "Navy", "Olive", "Plum", "Salmon"};
        ArrayList<String> pseudoNames;
        String[] courseNames = {"Physics", "Physics Lab", "Calculus I", "Calculus II", "Business", "Theatre"};
        String[] courseID = {"PHY", "PHY", "MTH", "MTH", "BUS", "THR"};
        int[] courseNumbers = {204, 204, 280, 281, 135, 110};
        String[] sections = {"002", "A", "001", "003", "002", "001"};
        String[] buildings = {"Kemper", "Kemper", "Cheek Hall", "Cheek Hall", "Glass Hall", "Craig Hall"};
        String[] roomIDs = {"201", "221", "101A", "205", "102", "312"};
        String[] meetingTimes = {"MTWRF 9:00-9:50", "R 2:00-3:50", "MTWRF 10:05-10:55", "MTWRF 11:10-12:00",
                                 "MWF 9:00-9:50", "MWF 7:55-8:45"};
        String[] assignmentCategories = {"Homework", "Quizes", "Exams"};
        String[] homeworkAssignments = {"HW I", "HW II", "HW III", "HW IV", "HW V", "HW VI", "HW VII",
                                        "HW VIII", "IX", "X", "XI"};
        int homeworkValue = 10;
        String[] quizes = {"Q1", "Q2", "Q3", "Q4", "Q5"};
        int quizValue = 25;
        String[] exams = {"Exam 1", "Exam 2", "Final"};
        int examValue = 100;
        int numberOfAssignments = homeworkAssignments.length + quizes.length + exams.length; 
        int numberOfStudents = studentList.length;
        double[][] grades = new double[numberOfAssignments][numberOfStudents];
        Random rng = new Random(12323423);//rng remove number to unseed
        DecimalFormat twoDecimals = new DecimalFormat("#.##");
        MyCourse[] courses = new MyCourse[courseNames.length];
        
        
        //create courses for testing
        for (int i = 0; i < courseNames.length; i++) {
            courses[i] = new MyCourse(courseNames[i]);
            courses[i].setCourseID(courseID[i]);
            courses[i].setCourseNumber(courseNumbers[i]);
            courses[i].setSection(sections[i]);
            courses[i].setBuilding(buildings[i]);
            courses[i].setRoomID(roomIDs[i]);
            courses[i].setMeetingTime(meetingTimes[i]);
            //System.out.println(courses[i].toString());
            pseudoNames = resetPSNS(pns);//stupid name but this class is only for testing and this will be
                                         //replaced upon finishing up the pseudo name generator class
            
            //add in students
            for (int j = 0; j < studentList.length; j++) {
                int randomNumber = ((int)(rng.nextFloat() * (totalStudents - j)));
                String[] tempName = studentList[j].split(" ");
                courses[i].addStudent(tempName[0], tempName[1], pseudoNames.get(randomNumber));
                pseudoNames.remove(pseudoNames.get(randomNumber));
                //System.out.println(courses[i].getStudent(j).getFullName() + "\t\t" + 
                //                   courses[i].getStudent(j).getPseudoName());
            }
            
            //add in ghosts
            for (int j = 0; j < totalStudents - studentList.length; j++) {
            	int randomNumber = ((int)(rng.nextFloat() * (totalStudents - studentList.length - j)));
            	courses[i].addGhostStudent(pseudoNames.get(randomNumber));
            	pseudoNames.remove(pseudoNames.get(randomNumber));
            	//System.out.println(courses[i].getGhostStudent(j).getPseudoName());
            }
            
            
            //add in basic assignmentCategories
            for (int j = 0; j < assignmentCategories.length; j++) {
                courses[i].addAssignmentCategory(assignmentCategories[j]);
                //System.out.println(courses[i].getAssignmentCategory(j).getName());
            }
            
            //add in homework
            for (int k = 0; k < homeworkAssignments.length; k++) {
                courses[i].getAssignmentCategory(0).addAssignment(homeworkAssignments[k], homeworkValue); 
                //System.out.println(courses[i].getAssignmentCategory(0).getAssignment(k).getName() +
                //				   "\tis worth: " + courses[i].getAssignmentCategory(0).getAssignment(k).getWorth() +
                //				   " points");
            
            }
            //add in quizes
            for (int j = 0; j < quizes.length; j++) {
                courses[i].getAssignmentCategory(1).addAssignment(quizes[j], quizValue); 
                //System.out.println(courses[i].getAssignmentCategory(1).getAssignment(j).getName() +
                //				   "\tis worth: " + courses[i].getAssignmentCategory(1).getAssignment(j).getWorth() +
                //				   " points");
            
            }
            //add in exams
            for (int j = 0; j < exams.length; j++) {
                courses[i].getAssignmentCategory(2).addAssignment(exams[j], examValue); 
                //System.out.println(courses[i].getAssignmentCategory(2).getAssignment(j).getName() +
                //				   "\tis worth: " + courses[i].getAssignmentCategory(2).getAssignment(j).getWorth() +
                //				   " points");
            }
            //populate random hw grades
            for (int j = 0; j < homeworkAssignments.length; j++) {
            	courses[i].getGradeBook().addAssignmentColumn(studentList.length);
            	for (int k = 0; k < studentList.length; k++) {
            		double randomGrade = Double.valueOf(twoDecimals.format((rng.nextFloat() * homeworkValue)));
            		courses[i].getGradeBook().setGrade(j, k, randomGrade);
            		//System.out.println(randomGrade + "\t" + courses[i].getGradeBook().getGrade(j, k));
            	}
            }
            for (int j = 0; j < quizes.length; j++) {
            	courses[i].getGradeBook().addAssignmentColumn(studentList.length);
            	for (int k = 0; k < studentList.length; k++) {
            		double randomGrade = Double.valueOf(twoDecimals.format((rng.nextFloat() * quizValue)));
            		courses[i].getGradeBook().setGrade((homeworkAssignments.length + j), k, randomGrade);
            		//System.out.println(randomGrade + "\t" + courses[i].getGradeBook().getGrade((homeworkAssignments.length + j), k));
            	}
            }
            for (int j = 0; j < exams.length; j++) {
            	courses[i].getGradeBook().addAssignmentColumn(studentList.length);
            	for (int k = 0; k < studentList.length; k++) {
            		double randomGrade = Double.valueOf(twoDecimals.format((rng.nextFloat() * examValue)));
            		courses[i].getGradeBook().setGrade((homeworkAssignments.length + 
            											quizes.length + j), k, randomGrade);
            		//System.out.println(randomGrade + "\t" + courses[i].getGradeBook().getGrade(homeworkAssignments.length + quizes.length + j, k));
            	}
            }
        }
        
       
        
        
        
        
        //test cases go below this comment line
        //need a check in case two students with the same name are added will need to differentiate between them
        
        
        //removing a student who is not in the class by name
        
        
        //removing a student by index which is out of bounds
        
        
        //removing an assignment category which doesn't exist by name
        
        
        //removing an assignment category by index which is out of bounds
        
        
        //removing an assignment which doesn't exist by name
        
        
        //removing an assignment by index which is out of bounds
        
        //test gradebook
    }
    
    //resets pseudoName array for creation of more than one course
    
    public static ArrayList<String> resetPSNS(String[] pns) {
        ArrayList<String> temp = new ArrayList<String>(); 
        for (int i = 0; i < pns.length; i++) {
            temp.add(pns[i]);
        }
        return temp;
    }
}
