package tests;

import java.io.File;
import io.*;

public class TestIO {

    public static void main(String[] args) {
        TestHelper t = new TestHelper();
        Exporter exp = new Exporter();

        String[] filePaths = new String[t.courses.length];

        for (int i=0; i< t.courses.length; i++) {
            filePaths[i] = "testExport" + i + ".html";
            exp.exportCourseToHTML(t.courses[i], filePaths[i]);
        }

        if (args.length > 0 && args[0].equals("keepFiles")) {
            for (int j=0; j<filePaths.length; j++) {
                System.out.println("Exported " + filePaths[j]);
            }
        }
        else {
            for (int j=0; j<filePaths.length; j++) {
                try {
                    File f = new File(filePaths[j]);
                    f.delete();
                }
                catch (Exception e) {
                    System.err.println("Failed to delete " + filePaths[j]);
                }
            }
        }
    }

}
