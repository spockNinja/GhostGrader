package tests;

import io.*;

public class TestIO {

    public static TestHelper t = new TestHelper();

    public static void main(String[] args) {
        Exporter exp = new Exporter();

        for (int i=0; i< t.courses.length; i++) {
            exp.exportCourseToHTML(t.courses[i], "testExport" + i + ".html");
        }
    }

}
