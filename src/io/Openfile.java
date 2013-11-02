/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.io.File;

import javax.swing.JFileChooser;

import objects.MyCourse;

import java.util.ArrayList;

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
    public void open(JFileChooser fc) {
        File file = fc.getSelectedFile();
        gradebookToOpen = io.parseXML.loadXML(file);
    }
}
