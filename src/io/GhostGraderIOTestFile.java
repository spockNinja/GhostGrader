package io;

import objects.*;

public class GhostGraderIOTestFile {

    public static void main(String[] args) {
        Exporter exp = new Exporter();
        MyCourse course = new MyCourse("CSC 460 - 2");

        course.setCourseID("123");
        course.setCourseNumber(2);
        course.setSection("2");
        course.setBuilding("Cheek");
        course.setRoomID("212");
        course.setMeetingTime("10:35 MWF");

        exp.exportCourseToHTML(course, "exportedHTML.html");
    }

}
