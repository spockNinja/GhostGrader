/**
 * "Deletes" a class from preloading by moving the XML file to an
 * archive folder
 *
 * @author Chris Weddle
 * @version 10-20-13
 */

import java.io.File;

public class RemoveCourse {
    public static void removeFile(String fileName) {
        String sourceDirectory = new String("./gradebooks/" + fileName);
        String destinationDirectory = new String("./archives/" + fileName);
        try {
            File fileToBeArchived = new File(sourceDirectory);
            if(fileToBeArchived.renameTo(new File(destinationDirectory))) {
                System.out.println("File archived successfully");
            } else {
                System.out.println("Failed to move");
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main (String argv []) {
        String test = new String("structure.xml");
        removeFile(test);
    }
}
