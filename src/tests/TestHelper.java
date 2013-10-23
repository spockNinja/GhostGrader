package tests;

import java.util.ArrayList;
import java.util.Random;
import java.text.DecimalFormat;

import objects.*;

public class TestHelper {

    // This class makes it easy to create test cases
    // It has a lot of default data so you don't have to write any

    public int seed = 1234;
    public int totalStudents = 20;
    public String[] studentList = {"Wanda Styles", "Peter Frampton", "Bobby Cox", "Linda Friendly",
                                    "Grinds Gears", "Super Cheeky", "Randy Baby", "Seth McFarlane",
                                    "Andy Dick", "Ten Isenuf"};
    public String[] pns = {"Alice Blue", "Acid Green", "Brown", "Deep Champagne", "Donkey Brown",
                            "Flame", "Han Purple", "Iceberg", "Kombu Green", "Ghost White",
                            "Patriarch", "Phlox", "Light Coral", "Khaki", "Lavender Blush",
                            "Medium Turquoise", "Navy", "Olive", "Plum", "Salmon"};
    public String[] courseNames = {"Physics", "Physics Lab", "Calculus I", "Calculus II", "Business", "Theatre"};
    public String[] courseID = {"PHY", "PHY", "MTH", "MTH", "BUS", "THR"};
    public int[] courseNumbers = {204, 204, 280, 281, 135, 110};
    public String[] sections = {"002", "A", "001", "003", "002", "001"};
    public String[] buildings = {"Kemper", "Kemper", "Cheek Hall", "Cheek Hall", "Glass Hall", "Craig Hall"};
    public String[] roomIDs = {"201", "221", "101A", "205", "102", "312"};
    public String[] meetingTimes = {"MTWRF 9:00-9:50", "R 2:00-3:50", "MTWRF 10:05-10:55", "MTWRF 11:10-12:00",
                                    "MWF 9:00-9:50", "MWF 7:55-8:45"};
    public String[] assignmentCategories = {"Homework", "Quizes", "Exams"};
    public String[] homeworkAssignments = {"HW I", "HW II", "HW III", "HW IV", "HW V", "HW VI", "HW VII",
                                            "HW VIII", "IX", "X", "XI"};
    public int homeworkValue = 10;
    public String[] quizes = {"Q1", "Q2", "Q3", "Q4", "Q5"};
    public int quizValue = 25;
    public String[] exams = {"Exam 1", "Exam 2", "Final"};
    public int examValue = 100;
    public int numberOfAssignments = homeworkAssignments.length + quizes.length + exams.length;
    public int numberOfStudents = studentList.length;
    public double[][] grades = new double[numberOfAssignments][numberOfStudents];
    public DecimalFormat twoDecimals = new DecimalFormat("#.##");
    public Random rng = new Random(seed);
    private PseudoNameGenerator pnGenerator = new PseudoNameGenerator();

    public MyCourse[] courses = new MyCourse[courseNames.length];

    public TestHelper() {
        generateTestCourses();
    }

    public TestHelper(int seed) {
        rng = new Random(seed);
        generateTestCourses();
    }

    public void generateTestCourses() {
        //  populate courses for testing
        // can be called after initial creation as well if you've
        // altered the public variables for more test cases
        for (int i = 0; i < courseNames.length; i++) {
            courses[i] = new MyCourse(courseNames[i]);
            courses[i].setCourseID(courseID[i]);
            courses[i].setCourseNumber(courseNumbers[i]);
            courses[i].setSection(sections[i]);
            courses[i].setBuilding(buildings[i]);
            courses[i].setRoomID(roomIDs[i]);
            courses[i].setMeetingTime(meetingTimes[i]);

            //add in students
            for (int j = 0; j < studentList.length; j++) {
                int randomNumber = ((int)(rng.nextFloat() * (totalStudents - j)));
                String[] tempName = studentList[j].split(" ");
                courses[i].addStudent(tempName[0], tempName[1], pnGenerator.generateName());
            }

            //add in ghosts
            for (int j = 0; j < totalStudents - studentList.length; j++) {
                int randomNumber = ((int)(rng.nextFloat() * (totalStudents - studentList.length - j)));
                courses[i].addGhostStudent(pnGenerator.generateName());
            }

            //add in basic assignmentCategories
            for (int j = 0; j < assignmentCategories.length; j++) {
                courses[i].addAssignmentCategory(assignmentCategories[j]);
            }

            //add in homework
            for (int k = 0; k < homeworkAssignments.length; k++) {
                courses[i].getAssignmentCategory(0).addAssignment(homeworkAssignments[k], homeworkValue);
            }

            //add in quizes
            for (int j = 0; j < quizes.length; j++) {
                courses[i].getAssignmentCategory(1).addAssignment(quizes[j], quizValue); 
            }

            //add in exams
            for (int j = 0; j < exams.length; j++) {
                courses[i].getAssignmentCategory(2).addAssignment(exams[j], examValue); 
            }

            //populate random hw grades
            for (int j = 0; j < homeworkAssignments.length; j++) {
                courses[i].getGradeBook().addAssignmentColumn(studentList.length);
                for (int k = 0; k < studentList.length; k++) {
                    double randomGrade = Double.valueOf(twoDecimals.format((rng.nextFloat() * homeworkValue)));
                    courses[i].getGradeBook().setGrade(j, k, randomGrade);
                }
            }
            for (int j = 0; j < quizes.length; j++) {
                courses[i].getGradeBook().addAssignmentColumn(studentList.length);
                for (int k = 0; k < studentList.length; k++) {
                    double randomGrade = Double.valueOf(twoDecimals.format((rng.nextFloat() * quizValue)));
                    courses[i].getGradeBook().setGrade((homeworkAssignments.length + j), k, randomGrade);
                }
            }
            for (int j = 0; j < exams.length; j++) {
                courses[i].getGradeBook().addAssignmentColumn(studentList.length);
                for (int k = 0; k < studentList.length; k++) {
                    double randomGrade = Double.valueOf(twoDecimals.format((rng.nextFloat() * examValue)));
                    courses[i].getGradeBook().setGrade((homeworkAssignments.length + quizes.length + j), k, randomGrade);
                }
            }
        }
    }
}
