/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import objects.MyCourse;


/**
 *
 * @author Lilong
 * @edut Zach
 */
public class Openfile {
    public MyCourse gradebookToOpen;
    
    public Openfile() {
    }
    
    //param fc: the file chooser which is when user clicked on the open in menu
    public boolean open(JFileChooser fc) {
        File file = fc.getSelectedFile();
        if (fc.getTypeDescription(file).contains("XML")) {
            gradebookToOpen = io.parseXML.loadXML(file);
            return true;
        }
        else {
            JOptionPane.showMessageDialog(null,
		      String.format("%33s"," can't open " + fc.getTypeDescription(file)),"Error",
		      JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
