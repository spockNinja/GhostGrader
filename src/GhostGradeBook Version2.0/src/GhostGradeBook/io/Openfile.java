/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GhostGradeBook.io;

import java.io.File;
import javax.swing.JFileChooser;
import java.util.ArrayList;

/**
 *
 * @author Lilong
 */
public class Openfile {
    
    public ArrayList<Object> dataFromOpenFile;
    GhostGradeBook.io.loadXML loaderXML;
    public Openfile() {
        dataFromOpenFile = new ArrayList<Object>();
    }
    
    //param fc: the file chooser which is when user clicked on the open in menu
    public void open(JFileChooser fc) {
        File file = fc.getSelectedFile();
        GhostGradeBook.io.loadXML loaderXML = new GhostGradeBook.io.loadXML(file);
        loaderXML.loadCourseInfo(file);
        getData();
    }
    
    public void getData() {
        dataFromOpenFile.add(loaderXML.courseName);
        dataFromOpenFile.add(loaderXML.courseID);
        dataFromOpenFile.add(loaderXML.courseNumber);
        dataFromOpenFile.add(loaderXML.section);
        dataFromOpenFile.add(loaderXML.building);
        dataFromOpenFile.add(loaderXML.roomID);
        dataFromOpenFile.add(loaderXML.meetingTime);
    }
}
