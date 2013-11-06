/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import interfaces.editClass.EditSelectedClass;
import io.Preloader;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import objects.MyCourse;

/**
 *
 * @author Lilong
 * @edit Zach; preloader changes
 */
public class MainFrame extends javax.swing.JFrame implements ActionListener {

    public boolean isDetialMode = false;
    
    private SimpleMode simpleMode;
    private AddNewClass addNewClass;
    private GradebooksWindow gradebookWindow;
    private EditSelectedClass editSelectedClassWindow;
    
    private static ArrayList<MyCourse> courses;
    private MyCourse currentCourse;
    /**
     * Creates new form WelcomeWindow Initial form of WelcomeWindow
     */
    public MainFrame() {
        initComponents();
        SetUp();
        //interactWithEditSelectedClass();
        //isRuningInDetialMode();
    }

    private void SetUp() {
        this.setLocation(400, 300);
        preloadGradebooks();
        simpleMode = new SimpleMode(this);
        addNewClass = new AddNewClass();
        gradebookWindow = new GradebooksWindow();
        editSelectedClassWindow = new EditSelectedClass(this);        

        populateTable();
        getWelcomeWindowLayout();  //add all the panels into the main frame
        setSimpleModeVisible();
        //jMenuItem_simpleMode.doClick();
    }
    
    public void setSimpleModeVisible() {
        simpleMode.setVisible(true);
        addNewClass.setVisible(false);
        gradebookWindow.setVisible(false);
        editSelectedClassWindow.setVisible(false);
        pack();
    }
    
    public void setEditSelectedClassVisible() {
        simpleMode.setVisible(false);
        addNewClass.setVisible(false);
        gradebookWindow.setVisible(false);
        editSelectedClassWindow.setVisible(true);
        pack();
    }
    
    public void setEditSelectedClass(EditSelectedClass window) {
    	editSelectedClassWindow = window;
    }
    
    public MyCourse getCurrentCourse() {
    	return currentCourse;
    }
    
    public  ArrayList<MyCourse> getCourses() {
    	return courses;
    }
    
    private void preloadGradebooks() {
    	Preloader preload = new Preloader(".xml");
    	courses = preload.getCourseArray();
    }
    
    private void populateTable() {
    	gradebookWindow.model.removeRow(0);
    	for (int i = 0; i < courses.size(); i++) {
    		addCourseToTable(i);
    		//Does not add to simple mode just yet
    	}
    }
    
    private void addCourseToTable(int i) {
        gradebookWindow.model.addRow(new Object[]{
        							gradebookWindow.classTable.getRowCount()+1,
        							courses.get(i).getName(), 
        							courses.get(i).getCourseID(), 
        							courses.get(i).getCourseNumber(), 
        							courses.get(i).getSection(), 
        							courses.get(i).getBuilding(), 
        							courses.get(i).getRoomID(), 
        							courses.get(i).getMeetingTime()});
    }
    
    //important:
    //invokeLater make the action performed to run in a reverse order 
    private void synchronize() {
        addNewClass.addButton.addActionListener(simpleMode); //run last
        JMenuItem_addClassFromXML.addActionListener(simpleMode);
        addNewClass.addButton.addActionListener(this); //run second
        addNewClass.cancelButton.addActionListener(this); //run first        
    }
    
    @Override
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getActionCommand().equals("AddNewCLass_addToTable")) {
            readNewClassData();
            if (addNewClass.actionStatus.equals("dataReady")) {
                newClassCreater();
                String temp = addNewClass.courseData.get(0);
                JOptionPane.showMessageDialog(null,
		      String.format("%33s", temp + " added to current course"),"Success",
		      JOptionPane.PLAIN_MESSAGE);
            }
        } else if (evt.getActionCommand().equals("Cancel/Go back")) {
            addNewClass.setVisible(false);
            simpleMode.setVisible(false);
            gradebookWindow.setVisible(true);
            pack();
        }
        addNewClass.courseData.clear();
    }
    
    private void readNewClassData() {
        String string_courseName = addNewClass.classNameTextField.getText();
        String string_courseID = addNewClass.courseIDTextField.getText();
        String string_courseNumber = addNewClass.courseNumberTextField.getText();
        String string_classSection = addNewClass.classSectionTextField.getText();
        String string_classBuilding = addNewClass.classBuildingTextField.getText();
        String string_classRoom = addNewClass.classRoomNumberTextField.getText();
        String string_meetingTime = addNewClass.meetingTimeTextField.getText();
        String string_semester = addNewClass.semesterTextField.getText();
        if (!textChecker(string_courseName, addNewClass.courseName) ||
            !textChecker(string_courseID, addNewClass.courseID) ||
            !textChecker(string_courseNumber, addNewClass.courseNumber)) {
        } else {
            addNewClass.courseData.add(string_courseName);
            addNewClass.courseData.add(string_courseID);
            addNewClass.courseData.add(string_courseNumber);
            addNewClass.courseData.add(string_classSection);
            addNewClass.courseData.add(string_classBuilding);
            addNewClass.courseData.add(string_classRoom);
            addNewClass.courseData.add(string_meetingTime);
            addNewClass.courseData.add(string_semester);
            addNewClass.actionStatus = "dataReady";
        }
    }
    
    private boolean textChecker(String text, JLabel textLabel) {
        if (text.equals((""))) {
            JOptionPane.showMessageDialog(null,
		      String.format("%33s",textLabel.getText() + " can't be empty"),"Error",
		      JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    private void newClassCreater() {
        gradebookWindow.model.addRow(new Object[]{null, null, null, null, null, null, null, null, null});
        for (int r = 0; r < gradebookWindow.classTable.getRowCount() - 1; r++) {
            if (gradebookWindow.classTable.getValueAt(r, 0) == null) {
                gradebookWindow.classTable.setValueAt(r, r, 0);
                for (int c = 0; c < gradebookWindow.classTable.getColumnCount() - 1; c++) {
                    gradebookWindow.classTable.setValueAt(addNewClass.courseData.get(c), r, c + 1);
                }               
            }
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

        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        JMenuItem_openFile = new javax.swing.JMenuItem();
        saveFile = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem_addNewClass = new javax.swing.JMenuItem();
        jMenuItem_removeClassMenu = new javax.swing.JMenuItem();
        jMenuItem_editClassMenu = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        JMenuItem_addClassFromXML = new javax.swing.JMenuItem();
        viewMenu = new javax.swing.JMenu();
        jMenuItem_simpleMode = new javax.swing.JMenuItem();
        jMenuItem_DetialMode = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GhostGradeBook 2.1");
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

        jMenuBar1.add(fileMenu);

        editMenu.setText("Edit");
        editMenu.add(jSeparator1);

        jMenuItem_addNewClass.setText("AddClass");
        jMenuItem_addNewClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_addNewClassActionPerformed(evt);
            }
        });
        editMenu.add(jMenuItem_addNewClass);

        jMenuItem_removeClassMenu.setText("RemoveClass");
        jMenuItem_removeClassMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_removeClassMenuActionPerformed(evt);
            }
        });
        editMenu.add(jMenuItem_removeClassMenu);

        jMenuItem_editClassMenu.setText("EditClass");
        jMenuItem_editClassMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_editClassMenuActionPerformed(evt);
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

        jMenuBar1.add(editMenu);

        viewMenu.setText("View");

        jMenuItem_simpleMode.setText("SimpleMode");
        jMenuItem_simpleMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_simpleModeActionPerformed(evt);
            }
        });
        viewMenu.add(jMenuItem_simpleMode);

        jMenuItem_DetialMode.setText("DetialMode");
        jMenuItem_DetialMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_DetialModeActionPerformed(evt);
            }
        });
        viewMenu.add(jMenuItem_DetialMode);

        jMenuBar1.add(viewMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 963, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 433, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void getWelcomeWindowLayout() {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(gradebookWindow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(simpleMode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(editSelectedClassWindow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addNewClass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(gradebookWindow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(simpleMode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(editSelectedClassWindow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addNewClass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        pack();
    }

    private void JMenuItem_addClassFromXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuItem_addClassFromXMLActionPerformed
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(MainFrame.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            io.Openfile fileReader = new io.Openfile();
            fileReader.open(fc);
            courses.add(fileReader.gradebookToOpen);
            addCourseToTable(courses.size()-1);
        }
        addNewClass.courseData.clear();
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


    
    private void jMenuItem_simpleModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_simpleModeActionPerformed
        if (gradebookWindow.isVisible()) {
            gradebookWindow.setVisible(false);
            addNewClass.setVisible(false);
            simpleMode.setVisible(true);
            editSelectedClassWindow.setVisible(false);
            pack();
        }
    }//GEN-LAST:event_jMenuItem_simpleModeActionPerformed

    private void jMenuItem_DetialModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_DetialModeActionPerformed
        if (simpleMode.isVisible()) {
            simpleMode.setVisible(false);
            addNewClass.setVisible(false);
            gradebookWindow.setVisible(true);
            editSelectedClassWindow.setVisible(false);
            pack();
        }
    }//GEN-LAST:event_jMenuItem_DetialModeActionPerformed

    private void jMenuItem_addNewClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_addNewClassActionPerformed
        gradebookWindow.setVisible(false);
        simpleMode.setVisible(false);
        addNewClass.setVisible(true);
        editSelectedClassWindow.setVisible(false);
        pack();
    }//GEN-LAST:event_jMenuItem_addNewClassActionPerformed

    private void jMenuItem_removeClassMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_removeClassMenuActionPerformed
        if (gradebookWindow.classTable.getSelectedRow() != -1 && gradebookWindow.isVisible()) {
            if (gradebookWindow.classTable.getValueAt(gradebookWindow.classTable.getSelectedRow(), 0) != null) {
                int r = gradebookWindow.classTable.getSelectedRow();
                gradebookWindow.model.removeRow(gradebookWindow.classTable.getSelectedRow());
                while (gradebookWindow.classTable.getValueAt(r, 0) != null) {
                    gradebookWindow.classTable.setValueAt(r, r, 0);
                    r++;
                }
            }
        }
    }//GEN-LAST:event_jMenuItem_removeClassMenuActionPerformed

    private void jMenuItem_editClassMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_editClassMenuActionPerformed
        if (gradebookWindow.classTable.getSelectedRow() != -1) {
            if (gradebookWindow.classTable.getValueAt(gradebookWindow.classTable.getSelectedRow(), 0) != null) {
                this.setVisible(false);
                //editCourses.setVisible(true);
                this.setVisible(true);
            }
        }
    }//GEN-LAST:event_jMenuItem_editClassMenuActionPerformed

    private void JMenuItem_openFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuItem_openFileActionPerformed
        
    }//GEN-LAST:event_JMenuItem_openFileActionPerformed

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
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem_DetialMode;
    private javax.swing.JMenuItem jMenuItem_addNewClass;
    private javax.swing.JMenuItem jMenuItem_editClassMenu;
    private javax.swing.JMenuItem jMenuItem_removeClassMenu;
    private javax.swing.JMenuItem jMenuItem_simpleMode;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuItem saveFile;
    private javax.swing.JMenu viewMenu;
    // End of variables declaration//GEN-END:variables
}