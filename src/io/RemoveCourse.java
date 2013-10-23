/**
 * "Deletes" a class from preloading by moving the XML file to an
 * archive folder
 *
 * @author Chris Weddle
 * @version 10-22-13
 */
package io;

import java.io.File;

public class RemoveCourse {
    public static void removeCourse(File fileToBeArchived, String destination) {
        try {
            if(fileToBeArchived.renameTo(new File(destination + File.separator + fileToBeArchived.getName()))) {
                System.out.println("File archived successfully");
            } else {
                System.out.println("Failed to move");
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    /*
    public static void main (String argv []) {
        File test = new File("../../gradebooks/structure.xml");
        removeCourse(test, "../../archives");
    }*/
}

