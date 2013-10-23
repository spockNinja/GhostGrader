/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GhostGradeBook;

import java.awt.Container;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Xiou
 */
public class AddNewClass extends javax.swing.JPanel {

    public String[] dataFromNewClass;
    public String actionStatus;
    /**
     * Creates new form AddNewClass
     */
    public AddNewClass() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        className = new javax.swing.JLabel();
        courseID = new javax.swing.JLabel();
        courseNumber = new javax.swing.JLabel();
        classSection = new javax.swing.JLabel();
        classBuilding = new javax.swing.JLabel();
        classRoomNumber = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        classNameTextField = new javax.swing.JTextField();
        courseIDTextField = new javax.swing.JTextField();
        courseNumberTextField = new javax.swing.JTextField();
        classSectionTextField = new javax.swing.JTextField();
        classBuildingTextField = new javax.swing.JTextField();
        classRoomNumberTextField = new javax.swing.JTextField();
        meetingTimeTextField = new javax.swing.JTextField();
        add = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add New Class", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 0, 14))); // NOI18N

        className.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        className.setText("Class Name (require):");

        courseID.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        courseID.setText("Course ID(rrequire):");

        courseNumber.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        courseNumber.setText("Course Number(require):");

        classSection.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        classSection.setText("Class section:");

        classBuilding.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        classBuilding.setText("Class Building:");

        classRoomNumber.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        classRoomNumber.setText("Class room number:");

        jLabel9.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel9.setText("Meeting Time:");

        courseIDTextField.setText(null);

        courseNumberTextField.setText(null);

        classSectionTextField.setText(null);

        classBuildingTextField.setText(null);

        classRoomNumberTextField.setText(null);

        meetingTimeTextField.setText(null);

        add.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        add.setText("Add to table");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        cancelButton.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        cancelButton.setText("Cancel/Go back");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(className)
                            .addComponent(courseID)
                            .addComponent(courseNumber)
                            .addComponent(classSection)
                            .addComponent(classBuilding)
                            .addComponent(classRoomNumber)
                            .addComponent(jLabel9))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(classNameTextField)
                            .addComponent(courseIDTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                            .addComponent(courseNumberTextField)
                            .addComponent(classSectionTextField)
                            .addComponent(classBuildingTextField)
                            .addComponent(classRoomNumberTextField)
                            .addComponent(meetingTimeTextField)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(add)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelButton)))
                .addGap(11, 11, 11))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(className)
                    .addComponent(classNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(courseID)
                    .addComponent(courseIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(courseNumber)
                    .addComponent(courseNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(classSection)
                    .addComponent(classSectionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(classBuilding)
                    .addComponent(classBuildingTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(classRoomNumber)
                    .addComponent(classRoomNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(meetingTimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void getLayOut(Container pane) {
        
    }
    
    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        String string_className = classNameTextField.getText();
        String string_courseID = courseIDTextField.getText();
        String string_courseNumber = courseNumberTextField.getText();
        String string_classSection = classSectionTextField.getText();
        String string_classBuilding = classBuildingTextField.getText();
        String string_classRoom = classRoomNumberTextField.getText();
        String string_meetingTime = meetingTimeTextField.getText();
        if (!textChecker(string_className, className) ||
            !textChecker(string_courseID, courseID) ||
            !textChecker(string_courseNumber, courseNumber)) {
        } else  if (evt.getActionCommand().equals("Add to table")) {
            String[] temp = {string_className, string_courseID, string_courseNumber,
                string_classSection, string_classBuilding, string_classRoom,
                string_meetingTime};
            dataFromNewClass = temp;
            actionStatus = "Add to table";
            setVisible(false);
        }
    }//GEN-LAST:event_addActionPerformed

    private boolean textChecker(String text, JLabel textLabel) {
        if (text.equals((""))) {
            JOptionPane.showMessageDialog(null,
		      String.format("%33s",textLabel.getText() + " can't be empty"),"Error",
		      JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        if (evt.getActionCommand().equals("Cancel")) {
            actionStatus = "Cancel";
            setVisible(false);
        }
    }//GEN-LAST:event_cancelButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton add;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel classBuilding;
    private javax.swing.JTextField classBuildingTextField;
    private javax.swing.JLabel className;
    private javax.swing.JTextField classNameTextField;
    private javax.swing.JLabel classRoomNumber;
    private javax.swing.JTextField classRoomNumberTextField;
    private javax.swing.JLabel classSection;
    private javax.swing.JTextField classSectionTextField;
    private javax.swing.JLabel courseID;
    private javax.swing.JTextField courseIDTextField;
    private javax.swing.JLabel courseNumber;
    private javax.swing.JTextField courseNumberTextField;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField meetingTimeTextField;
    // End of variables declaration//GEN-END:variables
}
