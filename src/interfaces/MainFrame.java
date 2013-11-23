/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import io.Preloader;
import interfaces.editClass.*;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import objects.MyCourse;

/**
 *
 * @author Lilong
 * @edit Zach; preloader changes
 * @edit Brett; whatever
 */
@SuppressWarnings("serial")
public class MainFrame extends javax.swing.JFrame {

    public boolean isDetialMode = false;
    
    public SimpleMode simpleMode;
    public AddNewClass addNewClass;
    public EditSelectedClass currentCourseWindow;
    public CreateCategoryPanel currentCategoryWindow;
    
    public ArrayList<MyCourse> courses;
    public ArrayList<EditSelectedClass> courseWindows = new ArrayList<EditSelectedClass>();;
    public MyCourse currentCourse;

    public MainFrame() {
        initComponents();
        SetUp();
    }

    private void SetUp() {
        this.setLocation(400, 300);
        preloadGradebooks();
        simpleMode = new SimpleMode(this);
        addNewClass = new AddNewClass(this);     

        if (courseWindows.size() > 0) {
            currentCourseWindow = courseWindows.get(0);
        }
        else {
            currentCourseWindow = new EditSelectedClass(this, -1);
        }
        currentCategoryWindow = new CreateCategoryPanel(currentCourseWindow);
    
        getWelcomeWindowLayOut();  //add all the panels into the main frame
        simpleMode.setSimpleModeVisible();
        synchronize();    //Update all other JPanel classes
        pack();
    }
    
    
    
    /**
     *  set which course needs to be edited
     * @param window a class for editSelectedClass
     */
    public void setCurrentCourseWindow(EditSelectedClass window) {
    	currentCourseWindow = window;
    }
    
    /**
     *  Set a category window to a edit class window
     * @param window category window to be called within the editc class window
     */
    public void setCurrentCategoryWindow(CreateCategoryPanel window) {
    	currentCategoryWindow = window;
    }
    
    /*
     * add a single course into the edit course window arraylist
     * @course my courses object
     */
    public void addCourseWindow(int courseIndex) {
    	courseWindows.add(new EditSelectedClass(this, courseIndex));
    }
    
    /*
     * return the single course object which is editing now
     */
    public MyCourse getCurrentCourse() {
    	return currentCourse;
    }
    
    /*
     * return the arralylist of MyCourses object
     */
    public  ArrayList<MyCourse> getCourses() {
    	return courses;
    }
    
    /*
     * return the the a single editClass in editClassArrayList
     */
    public EditSelectedClass getCourseWindow(int i) {
    	return courseWindows.get(i);
    }
    
    
    private void preloadGradebooks() {
    	Preloader preload = new Preloader(".xml");
    	courses = preload.getCourseArray();
    }
    
    /*
     * important:
     * invokeLater in main method make the action performed to run in a reverse order 
     */
    private void synchronize() {
        addNewClass.addButton.addActionListener(simpleMode);
    	addNewClass.cancelButton.addActionListener(addNewClass);
        addNewClass.addButton.addActionListener(addNewClass); //run first        
    }    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GhostGradeBook 5.4");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 589, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 433, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void getWelcomeWindowLayOut() {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(simpleMode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addNewClass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(currentCourseWindow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(currentCategoryWindow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(simpleMode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addNewClass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(currentCourseWindow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(currentCategoryWindow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        pack();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                MainFrame GhostGrader = new MainFrame();
                GhostGrader.setVisible(true);
            }
        });
    }
}
