/**
 * Write a description of class Preloader here.
 * 
 * @author Zach Hudson 
 * @version (a version number or a date)
 */
import java.io.File;
import java.io.FilenameFilter;

public class Preloader
{
    private static String directory = ".\\gradebooks\\";
    private static File directoryFolder = new File(directory);
    private static File[] files;
    
    public static boolean setDirectory(String dir) {
        File folder = new File(dir);
        if (folder.isDirectory()) {
            directoryFolder = folder;
            return true;
        }
        return false;
    }
    
    public static boolean loadFiles(final String extension) {
        try {
            files = directoryFolder.listFiles(new FilenameFilter() {
                public boolean accept(File dir, String filename)
                    {return filename.endsWith(extension);}
            });
            listFilesOfFolder();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
    public static File[] getXmlFiles() {
        return files;
    }
    
    public static File getLastUpdated() {
        File current = files[0];
        for (int i = 1; i < files.length; i++) {
            if (current.lastModified() < files[i].lastModified())
                current = files[i];
        }
        return current;
    }
    
    private static void listFilesOfFolder() {
        for (int i = 0; i < files.length; i++) {
            try {
                System.out.println(files[i].getCanonicalPath());
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
    public static void main (String argv[]) {
        directoryFolder =  new File(".\\zach\\gradebooks\\");
        loadFiles(".xml");
        File last = getLastUpdated();
        System.out.println(last.getName());
    }
}
