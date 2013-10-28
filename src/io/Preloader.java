/**
 * Collects files with a certain extension in a
 * specified directory and loads the contents into
 * memory.
 * 
 * @author Zach Hudson 
 * @date October 18, 2013
 */
package io;

import java.io.File;
import java.io.FilenameFilter;

import objects.MyCourse;
import io.parseXML;

public class Preloader
{
    private static String directory = "gradebooks";
    private static File directoryFolder = new File(directory);
    private static File[] files;
	private static MyCourse[] courses;
	
	/**
     * Constructs a new Preloader object with a default String directory.
     * Default directory: gradebooks
     * 
     * @param   extension  string designating what type of file to look for.
     */
	public Preloader(String extension) {
		if (loadFiles(extension))
			loadFileContents();
	}
	
	/**
     * Constructs a new Preloader object.
     * 
     * @param   extension  string designating what type of file to look for.
     * @param	dir		   string designating what directory to look into.
     */
	public Preloader(String extension, String dir) {
		directory = dir;
		if (loadFiles(extension))
			loadFileContents();
	}
	
	/**
     * Set the directory to be looked into.
     * 
     * @param   dir  string designating what directory to look into.
     */
    public static boolean setDirectory(String dir) {
        File folder = new File(dir);
        if (folder.isDirectory()) {
            directoryFolder = folder;
            return true;
        }
        return false;
    }
    
    /**
     * Loads all files with specified extension into a File[] object 
     * from the directory.
     * 
     * @param   extension  string designating what type of files to load.
     */
    public static boolean loadFiles(final String extension) {
        try {
            files = directoryFolder.listFiles(new FilenameFilter() {
                public boolean accept(File dir, String filename)
                    {return filename.endsWith(extension);}
            });
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
    /**
     * @return File array
     * 
     */
    public static File[] geFilesArray() {
        return files;
    }
    
    /**
     * @return MyCourse array
     * 
     */
	public static MyCourse[] getCourseArray() {
		return courses;
	}
	
	/**
     * @param  index int
     * @return a single MyCourse object.
     */
	public static MyCourse getCourse(int index) {
		if (courses != null && index >= 0 && index < courses.length)
			return courses[index];
		return null;
	}
	
	/**
     * @return File which was most recently modified
     * 
     */
    public static File getLastUpdated() {
        File current = files[0];
        for (int i = 1; i < files.length; i++) {
            if (current.lastModified() < files[i].lastModified())
                current = files[i];
        }
        return current;
    }
    
    /**
     * Populates MyCourse[] courses
     * 
     */
	private static void loadFileContents() {
		courses = new MyCourse[files.length];
		for (int i = 0; i < files.length; i++) {
			try {
				courses[i] = parseXML.loadXML(files[i]);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	/**
     * @return a string of canonical paths from File[] files.
     * Note: New line for each file.
     * 
     */
    private static String listPathsToString() {
    	String out ="";
        for (int i = 0; i < files.length; i++) {
            try {
                out = out + "\n" + files[i].getCanonicalPath();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return out;
    }
    
    public static void main (String argv[]) {
        directoryFolder =  new File(directory);
        if (loadFiles(".xml"))
        	loadFileContents();
        File last = getLastUpdated();
        System.out.println(listPathsToString() + "\n" + last.getName());
        for (int i = 0; i < courses.length; i++)
        	System.out.println(courses[i].toString());
    }
}