/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GhostGradeBook;

import java.awt.event.ActionListener;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Lilong
 */
public class MainFrame extends javax.swing.JFrame implements ActionListener {

    private GhostGradeBook.editClass.EditSelectedClass editCurrentClass;
    public boolean isDetialMode = false;
    public boolean callToUpDate = false;
    
    private SimpleMode simpleMode;
    private AddNewClass addNewClass;
    private CurrentClass currentClass;
    
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

        simpleMode = new SimpleMode();
        addNewClass = new AddNewClass();
        currentClass = new CurrentClass();
        editCurrentClass = new GhostGradeBook.editClass.EditSelectedClass(this, true);
        editCurrentClass.setLocation(500, 300);
        
        getWelcomeWindowLayOut();  //add all the panels into the main frame
        simpleMode.setVisible(false);
        addNewClass.setVisible(false);
        currentClass.setVisible(true);
        synchronize();    //Update between all other java classes
        pack();
        //jMenuItem_simpleMode.doClick();
    }
    
    private void synchronize() {
        Synchronize_AddNewClassAndCurrentClass();
    }
    
    private void Synchronize_AddNewClassAndCurrentClass() {
        addNewClass.addButton.addActionListener(this);
        currentClass.addClassButton.addActionListener(this);
        addNewClass.cancelButton.addActionListener(this);
    }
    
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
        } else if (evt.getActionCommand().equals("createNewClass")) {
            addNewClass.setVisible(true);
            pack();
        } else if (evt.getActionCommand().equals("Cancel/Go back")) {
            currentClass.setVisible(true);
        }
    }
    
    private void readNewClassData() {
        String string_className = addNewClass.classNameTextField.getText();
        String string_courseID = addNewClass.courseIDTextField.getText();
        String string_courseNumber = addNewClass.courseNumberTextField.getText();
        String string_classSection = addNewClass.classSectionTextField.getText();
        String string_classBuilding = addNewClass.classBuildingTextField.getText();
        String string_classRoom = addNewClass.classRoomNumberTextField.getText();
        String string_meetingTime = addNewClass.meetingTimeTextField.getText();
        if (!textChecker(string_className, addNewClass.className) ||
            !textChecker(string_courseID, addNewClass.courseID) ||
            !textChecker(string_courseNumber, addNewClass.courseNumber)) {
        } else {
            addNewClass.courseData.add(string_className);
            addNewClass.courseData.add(string_courseID);
            addNewClass.courseData.add(string_courseNumber);
            addNewClass.courseData.add(string_classSection);
            addNewClass.courseData.add(string_classBuilding);
            addNewClass.courseData.add(string_classRoom);
            addNewClass.courseData.add(string_meetingTime);
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
        currentClass.model.addRow(new Object[]{null, null, null, null, null, null, null, null});
        for (int r = 0; r < currentClass.classTable.getRowCount() - 1; r++) {
            if (currentClass.classTable.getValueAt(r, 0) == null) {
                currentClass.classTable.setValueAt(r, r, 0);
                for (int c = 0; c < currentClass.classTable.getColumnCount() - 1; c++) {
                    currentClass.classTable.setValueAt(addNewClass.courseData.get(c), r, c + 1);
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
        openFile = new javax.swing.JMenuItem();
        saveFile = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        cut = new javax.swing.JMenuItem();
        copy = new javax.swing.JMenuItem();
        paste = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem_addNewClass = new javax.swing.JMenuItem();
        jMenuItem_removeClassMenu = new javax.swing.JMenuItem();
        jMenuItem_editClassMenu = new javax.swing.JMenuItem();
        viewMenu = new javax.swing.JMenu();
        jMenuItem_simpleMode = new javax.swing.JMenuItem();
        jMenuItem_DetialMode = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GhostGradeBook 2.1");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        fileMenu.setText("File");

        openFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openFile.setText("OpenFile");
        openFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileActionPerformed(evt);
            }
        });
        fileMenu.add(openFile);

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

        cut.setText("Cut");
        editMenu.add(cut);

        copy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        copy.setText("Copy");
        editMenu.add(copy);

        paste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        paste.setText("Paste");
        editMenu.add(paste);
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

    private void getWelcomeWindowLayOut() {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(currentClass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(simpleMode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addNewClass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(currentClass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(simpleMode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addNewClass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        pack();
    }

    private void openFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileActionPerformed
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(MainFrame.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            GhostGradeBook.io.Openfile fileReader = new GhostGradeBook.io.Openfile();
            fileReader.open(fc);
            currentClass.courseData = fileReader.dataFromOpenFile;
            callToUpDate = true;
            currentClass.upDateWelcomeWindow();
        }
    }//GEN-LAST:event_openFileActionPerformed

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
        if (currentClass.isVisible()) {
            currentClass.setVisible(false);
            addNewClass.setVisible(false);
            simpleMode.setVisible(true);
            pack();
        }
    }//GEN-LAST:event_jMenuItem_simpleModeActionPerformed

    private void jMenuItem_DetialModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_DetialModeActionPerformed
        if (simpleMode.isVisible()) {
            simpleMode.setVisible(false);
            addNewClass.setVisible(false);
            currentClass.setVisible(true);
            pack();
        }
    }//GEN-LAST:event_jMenuItem_DetialModeActionPerformed

    private void jMenuItem_addNewClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_addNewClassActionPerformed
        currentClass.setVisible(false);
        simpleMode.setVisible(false);
        addNewClass.setVisible(true);
    }//GEN-LAST:event_jMenuItem_addNewClassActionPerformed

    private void jMenuItem_removeClassMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_removeClassMenuActionPerformed
        if (currentClass.classTable.getSelectedRow() != -1 && currentClass.isVisible()) {
            if (currentClass.classTable.getValueAt(currentClass.classTable.getSelectedRow(), 0) != null) {
                int r = currentClass.classTable.getSelectedRow();
                currentClass.model.removeRow(currentClass.classTable.getSelectedRow());
                while (currentClass.classTable.getValueAt(r, 0) != null) {
                    currentClass.classTable.setValueAt(r, r, 0);
                    r++;
                }
            }
        }
    }//GEN-LAST:event_jMenuItem_removeClassMenuActionPerformed

    private void jMenuItem_editClassMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_editClassMenuActionPerformed
        if (currentClass.classTable.getSelectedRow() != -1) {
            if (currentClass.classTable.getValueAt(currentClass.classTable.getSelectedRow(), 0) != null) {
                this.setVisible(false);
                //editCurrentClass.setVisible(true);
                this.setVisible(true);
            }
        }
    }//GEN-LAST:event_jMenuItem_editClassMenuActionPerformed

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
    private javax.swing.JMenuItem copy;
    private javax.swing.JMenuItem cut;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem_DetialMode;
    private javax.swing.JMenuItem jMenuItem_addNewClass;
    private javax.swing.JMenuItem jMenuItem_editClassMenu;
    private javax.swing.JMenuItem jMenuItem_removeClassMenu;
    private javax.swing.JMenuItem jMenuItem_simpleMode;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem openFile;
    private javax.swing.JMenuItem paste;
    private javax.swing.JMenuItem saveFile;
    private javax.swing.JMenu viewMenu;
    // End of variables declaration//GEN-END:variables
}
