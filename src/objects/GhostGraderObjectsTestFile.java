package objects;

import java.util.ArrayList;
import java.util.Random;
/**
 * Write a description of course GhostGrader here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GhostGraderObjectsTestFile {
    public static void main(String[] args) {
        String[] studentList = {"Wanda Styles", "Peter Frampton", "Bobby Cox", "Linda Friendly",
                                "Grinds Gears", "Super Cheeky", "Randy Baby", "Seth McFarlane",
                                "Andy Dick", "Ten Isenuf"};
        String[] pns = {"Acid Green", "Deep Champagne", "Donkey Brown", "Flame", 
                        "Han Purple", "Iceberg", "Kombu Green", "Lavendar Blue",
                        "Patriarch", "Phlox"};
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
        MyCourse[] courses = new MyCourse[courseNames.length];
        Random rng = new Random(12323423);//rng remove number to unseed
        
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
                int randomNumber = ((int)(rng.nextFloat() * (10 - j)));
                String[] tempName = studentList[j].split(" ");
                courses[i].addStudent(tempName[0], tempName[1], pseudoNames.get(randomNumber));
                pseudoNames.remove(pseudoNames.get(randomNumber));
                //System.out.println(courses[i].getStudent(j).getFullName() + "\t\t" + 
                //                   courses[i].getStudent(j).getPseudoName());
            }
            
            //add in basic assignmentCategories
            for (int j = 0; j < assignmentCategories.length; j++) {
                courses[i].addAssignmentCategory(assignmentCategories[j]);
            }
            
            //add in assignments
            for (int j = 0; j < homeworkAssignments.length; j++) {
                //courses[i].getAssignmentCategory //need to finish writing AssignmentCategory 
                //and Assignment first
            }
            
        }
        
        
        //test cases go here
        
        //need a check in case two students with the same name are added will need to differentiate between them
        //removing a student who is not in the class by name
        //removing a student by index which is out of bounds
        
        //removing an assignment category which doesn't exist by name
        //removing an assignment category by index which is out of bounds
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
