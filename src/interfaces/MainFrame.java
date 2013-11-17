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
 */
public class MainFrame extends javax.swing.JFrame implements ActionListener {

    public boolean isDetialMode = false;
    
    public SimpleMode simpleMode;
    public AddNewClass addNewClass;
    public EditSelectedClass currentCourseWindow;
    
    public ArrayList<MyCourse> courses;
    public ArrayList<EditSelectedClass> courseWindows = new ArrayList<EditSelectedClass>();;
    public MyCourse currentCourse;
    private int indexOfCourse;     //track how many couress in myCourse object

    public MainFrame() {
        initComponents();
        SetUp();
    }

    private void SetUp() {
        this.setLocation(400, 300);
        preloadGradebooks();
        simpleMode = new SimpleMode(this);
        addNewClass = new AddNewClass();
        viewMenu.setVisible(false); //if needed we can add this feature
        

        if (courseWindows.size() > 0) {
            currentCourseWindow = courseWindows.get(0);
        }
        else {
            currentCourseWindow = new EditSelectedClass(this, null);
        }
    
        setRemoveMenu();
        getWelcomeWindowLayOut();  //add all the panels into the main frame
        setSimpleModeVisible();
        synchronize();    //Update all other JPanel classes
        pack();
    }
    
    public void setSimpleModeVisible() {
        setJMenuBar(mainMenuBar);
        setContentPane(simpleMode);
        simpleMode.setVisible(true);
        addNewClass.setVisible(false);
        currentCourseWindow.setVisible(false);
        pack();
    }
    
    public void setEditSelectedClassVisible(EditSelectedClass selectedCourse) {
        setCurrentCourseWindow(selectedCourse);
        setContentPane(selectedCourse);
        selectedCourse.setPanelMenu();
        simpleMode.setVisible(false);
        addNewClass.setVisible(false);
        currentCourseWindow.setVisible(true);
        pack();
    }
    
    /*
     * set which course needs to be edited
     */
    public void setCurrentCourseWindow(EditSelectedClass window) {
    	currentCourseWindow = window;
    }
    
    /*
     * add a single course into the edit course window arraylist
     * @course my courses object
     */
    public void addCourseWindow(MyCourse course) {
    	courseWindows.add(new EditSelectedClass(this, course));
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
    
    private void setRemoveMenu() {
    	for (indexOfCourse = 0; indexOfCourse < courses.size(); indexOfCourse++) {
    		addCourseToTable(indexOfCourse);
    	}
    }
    
    private void addCourseToTable(int i) {
        addToRemoveMenu(i);
    }

    private boolean checkRepeatedCourse(MyCourse newCourse) {
        for (int t = 0; t < courses.size(); t++) {
            if (courses.get(t).getName().equals(newCourse.getName()) &&
                courses.get(t).getSection().equals(newCourse.getSection())) {
                return false;
            }
        }
        return true;
    }
    
    private void addToRemoveMenu(int i) {
        final JMenuItem course = new JMenuItem(courses.get(i).getName() + 
                                                "-" + courses.get(i).getSection());
        removeClass.add(course);
        course.addActionListener(simpleMode);
        course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //removedName = evt.getActionCommand();
                courseActionPerformed(evt, course);
            }
        });
    }
    
    /*
     * important:
     * invokeLater in main method make the action performed to run in a reverse order 
     */
    private void synchronize() {
        addNewClass.addButton.addActionListener(simpleMode); //run last
        JMenuItem_addClassFromXML.addActionListener(simpleMode);
        addNewClass.addButton.addActionListener(this); 
        addNewClass.cancelButton.addActionListener(this);
        addNewClass.addButton.addActionListener(addNewClass); //run first        
    }
    
    @Override
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getActionCommand().equals("AddNewCLass_addToTable")) {
            if (addNewClass.actionStatus.equals("dataReady")) {
                if (checkRepeatedCourse(addNewClass.getNewCourse())) {
                    courses.add(addNewClass.getNewCourse());
                    addCourseToTable(indexOfCourse);
                    String temp = courses.get(indexOfCourse).getName();
                    JOptionPane.showMessageDialog(null,
                          String.format("%33s", temp + " added to current course"),"Success",
                          JOptionPane.PLAIN_MESSAGE);
                    indexOfCourse++;
                } else {
                    JOptionPane.showMessageDialog(null,
                            String.format("%33s",addNewClass.getNewCourse().getName() + " " +
                            addNewClass.getNewCourse().getSection() +
                            " already exited"),"Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                addNewClass.actionStatus = "waiting";
            }
        } else if (evt.getActionCommand().equals("Cancel/Go back")) {
            setSimpleModeVisible();
        } 
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainMenuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        JMenuItem_openFile = new javax.swing.JMenuItem();
        saveFile = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem_addNewClass = new javax.swing.JMenuItem();
        removeClass = new javax.swing.JMenu();
        jMenuItem_editClassMenu = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        JMenuItem_addClassFromXML = new javax.swing.JMenuItem();
        viewMenu = new javax.swing.JMenu();
        jMenuItem_simpleMode = new javax.swing.JMenuItem();
        jMenuItem_DetialMode = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GhostGradeBook 4.2");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        fileMenu.setText("File");

        JMenuItem_openFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        JMenuItem_openFile.setText("OpenFile");
        JMenuItem_openFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenuItem_openFileActionPerformed(evt);
            }
        });
        fileMenu.add(JMenuItem_openFile);

        saveFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveFile.setText("SaveFile");
        saveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFileActionPerformed(evt);
            }
        });
        fileMenu.add(saveFile);

        mainMenuBar.add(fileMenu);

        editMenu.setText("Edit");
        editMenu.add(jSeparator1);

        jMenuItem_addNewClass.setText("AddClass");
        jMenuItem_addNewClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_addNewClassActionPerformed(evt);
            }
        });
        editMenu.add(jMenuItem_addNewClass);

        removeClass.setText("RemoveClass");
        editMenu.add(removeClass);

        jMenuItem_editClassMenu.setText("EditClass");
        jMenuItem_editClassMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               // jMenuItem_editClassMenuActionPerformed(evt);
            }
        });
        editMenu.add(jMenuItem_editClassMenu);
        editMenu.add(jSeparator2);

        JMenuItem_addClassFromXML.setText("AddClassFromXML");
        JMenuItem_addClassFromXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenuItem_addClassFromXMLActionPerformed(evt);
            }
        });
        editMenu.add(JMenuItem_addClassFromXML);

        mainMenuBar.add(editMenu);

        viewMenu.setText("View");

        jMenuItem_simpleMode.setText("SimpleMode");
        jMenuItem_simpleMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
              //  jMenuItem_simpleModeActionPerformed(evt);
            }
        });
        viewMenu.add(jMenuItem_simpleMode);

        jMenuItem_DetialMode.setText("DetialMode");
        jMenuItem_DetialMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               // jMenuItem_DetialModeActionPerformed(evt);
            }
        });
        viewMenu.add(jMenuItem_DetialMode);

        mainMenuBar.add(viewMenu);

        setJMenuBar(mainMenuBar);

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
                .addComponent(currentCourseWindow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(simpleMode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addNewClass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(currentCourseWindow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        pack();
    }

    private void JMenuItem_addClassFromXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuItem_addClassFromXMLActionPerformed
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(MainFrame.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            io.Openfile fileReader = new io.Openfile();
            if (fileReader.open(fc)) {
                if (checkRepeatedCourse(fileReader.gradebookToOpen)) {
                    courses.add(fileReader.gradebookToOpen);
                    addCourseToTable(indexOfCourse);
                    indexOfCourse++;
                } else {
                    JOptionPane.showMessageDialog(null,
                            String.format("%33s",addNewClass.getNewCourse().getName() + " " +
                            addNewClass.getNewCourse().getSection() +
                            " already exited"),"Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_JMenuItem_addClassFromXMLActionPerformed

    private void saveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFileActionPerformed
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showSaveDialog(MainFrame.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            JOptionPane.showMessageDialog(null,
                    String.format("%100s", file.getName() + " is saved, but we will decide what type file to be saved"));
        }
    }//GEN-LAST:event_saveFileActionPerformed


    private void jMenuItem_addNewClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_addNewClassActionPerformed
        setContentPane(addNewClass);
        simpleMode.setVisible(false);
        currentCourseWindow.setVisible(false);
        addNewClass.setVisible(true);
        pack();
    }//GEN-LAST:event_jMenuItem_addNewClassActionPerformed

    private void JMenuItem_openFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuItem_openFileActionPerformed
        
    }//GEN-LAST:event_JMenuItem_openFileActionPerformed

     private void courseActionPerformed(java.awt.event.ActionEvent evt, JMenuItem course) {   
         String courseName = evt.getActionCommand();
         String[] courseInfo = courseName.split("-");
         for (int i = 0; i < courses.size(); i++) {
             if (courseInfo[0].equals(courses.get(i).getName()) &&
                     courseInfo[1].equals(courses.get(i).getSection())) {
                courses.remove(i).getName(); //remove from course object
                removeClass.remove(course); // rmove from the menu
                indexOfCourse--;
                i = courses.size();
             }
         }
         System.out.println();
     }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JMenuItem_addClassFromXML;
    private javax.swing.JMenuItem JMenuItem_openFile;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem jMenuItem_DetialMode;
    private javax.swing.JMenuItem jMenuItem_addNewClass;
    private javax.swing.JMenuItem jMenuItem_editClassMenu;
    private javax.swing.JMenuItem jMenuItem_simpleMode;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuBar mainMenuBar;
    private javax.swing.JMenu removeClass;
    private javax.swing.JMenuItem saveFile;
    private javax.swing.JMenu viewMenu;
    // End of variables declaration//GEN-END:variables

    private int toInteger(String string_courseNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
