/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.io.File;
import javax.swing.JFileChooser;
import java.util.ArrayList;

/**
 *
 * @author Lilong
 */
public class Openfile {
    
    public ArrayList<String> dataFromOpenFile;
    io.loadXML loaderXML;
    public Openfile() {
        dataFromOpenFile = new ArrayList<String>();
    }
    
    //param fc: the file chooser which is when user clicked on the open in menu
    public void open(JFileChooser fc) {
        File file = fc.getSelectedFile();
        io.loadXML loaderXML = new io.loadXML(file);
        loaderXML.loadCourseInfo(file);
        getData();
    }
    
    public void getData() {
        dataFromOpenFile.add(loaderXML.courseName);
        dataFromOpenFile.add(loaderXML.courseID);
        String temp = Integer.toString(loaderXML.courseNumber);
        dataFromOpenFile.add(temp);
        dataFromOpenFile.add(loaderXML.section);
        dataFromOpenFile.add(loaderXML.building);
        dataFromOpenFile.add(loaderXML.roomID);
        dataFromOpenFile.add(loaderXML.meetingTime);
        //semester
        dataFromOpenFile.add("");
    }
}
