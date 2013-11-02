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
import java.util.ArrayList;

import objects.MyCourse;
import io.parseXML;

public class Preloader
{
    private static String directory = "gradebooks";
    private static File directoryFolder = new File(directory);
    private static File[] files;
	private static ArrayList<MyCourse> courses = new ArrayList<MyCourse>();
	
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
    public boolean setDirectory(String dir) {
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
    public boolean loadFiles(final String extension) {
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
    public File[] geFilesArray() {
        return files;
    }
    
    /**
     * @return MyCourse array
     * 
     */
	public ArrayList<MyCourse> getCourseArray() {
		return courses;
	}
	
	/**
     * @param  index int
     * @return a single MyCourse object.
     */
	public MyCourse getCourse(int index) {
		if (courses != null && index >= 0 && index < courses.size())
			return courses.get(index);
		return null;
	}
	
	/**
     * @return File which was most recently modified
     * 
     */
    public File getLastUpdated() {
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
	private void loadFileContents() {
		
		for (int i = 0; i < files.length; i++) {
			try {
				courses.add(parseXML.loadXML(files[i]));
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
    private String listPathsToString() {
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
}