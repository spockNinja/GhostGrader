/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces.editClass;

import io.parseXML;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import objects.Assignment;

/**
 *
 * @author Lilong
 */
public class AddAssignmentPanel extends javax.swing.JPanel implements ActionListener{

    public String actionStatus = "waiting";
    private EditSelectedClass parent;
    private DefaultTableModel model;
    private int categoryIndex;
    private boolean isCorrectedFormat;
    /**
     * Creates new form AddAssigmentPanel
     */
    public AddAssignmentPanel(EditSelectedClass parent) {
        this.parent = parent;
        
        initComponents();
        setTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        courseInfo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();

        addButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        courseInfo.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        courseInfo.setText("Title");

        addButton.setText("Save Changes");
        addButton.addActionListener(parent.parent.currentCourseWindow);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(addButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 198, Short.MAX_VALUE)
                .addComponent(cancelButton))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(courseInfo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(courseInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void setTable() {
        table = new javax.swing.JTable() {
            public void changeSelection(final int row, final int column, boolean toggle, boolean extend) {
    		      super.changeSelection(row, column, toggle, extend);
    		      table.editCellAt(row, column);
    		      table.transferFocus();
        	   }
        };
        
        table.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Name", "Worth"
            }
        ));
        jScrollPane1.setViewportView(table);
        model = (DefaultTableModel) table.getModel();
    }

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        if (!parent.parent.currentAssignmentWindow.table.isEditing() && isInteger()) {
            for (int i = 0; i < parent.parent.currentAssignmentWindow.table.getRowCount(); i++) {
                if (isNullAndEmpty(i)
                        && i < parent.parent.courses.get(parent.parent.currentCourseWindow.courseIndex).getAssignmentCategory(categoryIndex).getNumberOfAssignments()) {
                    int worth = Integer.valueOf(parent.parent.currentAssignmentWindow.table.getValueAt(i, 1).toString());
                    parent.parent.courses.get(parent.parent.currentCourseWindow.courseIndex).getAssignmentCategory(categoryIndex)
                            .getAssignment(i).setName((String)parent.parent.currentAssignmentWindow.table.getValueAt(i, 0));
                    parent.parent.courses.get(parent.parent.currentCourseWindow.courseIndex).getAssignmentCategory(categoryIndex)
                            .getAssignment(i).setWorth(worth);
                }

               if (isNullAndEmpty(i)
                        && i >= parent.parent.courses.get(parent.parent.currentCourseWindow.courseIndex).getAssignmentCategory(categoryIndex).getNumberOfAssignments()) {
                    int worth = Integer.valueOf(parent.parent.currentAssignmentWindow.table.getValueAt(i, 1).toString());
                    parent.parent.courses.get(parent.parent.currentCourseWindow.courseIndex).getAssignmentCategory(categoryIndex)
                            .addAssignment((String)parent.parent.currentAssignmentWindow.table.getValueAt(i, 0) , worth);
                }
            }
            parent.parent.currentAssignmentWindow.table.clearSelection();
            parseXML.saveXML(parent.parent.courses.get(parent.parent.currentCourseWindow.courseIndex));
            actionStatus = "addAssignment";
            parent.parent.setEditSelectedClassVisible(parent.parent.currentCourseWindow);
        } else {
        	JOptionPane.showMessageDialog(null,
        			String.format("%33s","Selecting cell is editing, complete editing before save changes"),"Error",
        			JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_addButtonActionPerformed

    private boolean isInteger() {
        for (int k = 0; k < parent.parent.currentAssignmentWindow.table.getRowCount(); k++) {
            if (parent.parent.currentAssignmentWindow.table.getValueAt(k, 0) != null
                    && !parent.parent.currentAssignmentWindow.table.getValueAt(k, 0).equals("")) {
                try {
                    String s = parent.parent.currentAssignmentWindow.table.getValueAt(k, 1).toString();
                    Integer.parseInt(s);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,
                        String.format("%33s","Row " + (k + 1) + "'s worth is not an integer"),"Error",
                        JOptionPane.ERROR_MESSAGE);
                    isCorrectedFormat = false;
                    return false;
                }
            }
        }
        isCorrectedFormat = true;
        return true;
    }
    
    private boolean isNullAndEmpty(int i) {
        if (parent.parent.currentAssignmentWindow.table.getValueAt(i, 0) != null
                && parent.parent.currentAssignmentWindow.table.getValueAt(i, 1) != null
                && !parent.parent.currentAssignmentWindow.table.getValueAt(i, 0).equals("")
                && !parent.parent.currentAssignmentWindow.table.getValueAt(i, 0).equals("")) {
            return true;
        } else {
            return false;
        }
    }
    
    private boolean isNull(int i) {
        if (parent.parent.currentAssignmentWindow.table.getValueAt(i, 0) != null
        && parent.parent.currentAssignmentWindow.table.getValueAt(i, 1) != null) {
            return true;
        }   else {
            return false;
        }
    }
    
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        if (!parent.parent.currentAssignmentWindow.table.isEditing()) {
            parent.parent.setEditSelectedClassVisible(parent.parent.currentCourseWindow);
        } else {
            JOptionPane.showMessageDialog(null,
                String.format("%33s","Selecting cell is editing, complete editing before cancel"),"Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cancelButtonActionPerformed

    @Override
    public void actionPerformed(ActionEvent evt) {
        for (int i = 0; i < parent.parent.currentAssignmentWindow.table.getRowCount(); i++) {
            if (parent.parent.currentAssignmentWindow.table.getValueAt(i, 0) != null
                    || parent.parent.currentAssignmentWindow.table.getValueAt(i, 1) != null) {
                parent.parent.currentAssignmentWindow.table.setValueAt(null, i, 0);
                parent.parent.currentAssignmentWindow.table.setValueAt(null, i, 1);
            }
        }
        
        parent.parent.currentCourseWindow.changeTabActionsToEnterActions(parent.parent.currentAssignmentWindow.table);
        categoryIndex = parent.parent.courses.get(parent.parent.currentCourseWindow.courseIndex).getAssignmentCategoryIndex(parent.parent.currentCourseWindow.categorySelected);
        parent.parent.currentAssignmentWindow.courseInfo.setText(parent.parent.courses.get(parent.parent.currentCourseWindow.courseIndex).getName() + "-" +
                            parent.parent.courses.get(parent.parent.currentCourseWindow.courseIndex).getSection() + " " + 
                            parent.parent.currentCourseWindow.categorySelected);
        for (int i = 0; i < parent.parent.courses.get(parent.parent.currentCourseWindow.courseIndex).getAssignmentCategory(categoryIndex).getNumberOfAssignments(); i++) {
            String assignmentName = parent.parent.courses.get(parent.parent.currentCourseWindow.courseIndex).getAssignmentCategory(categoryIndex).getAssignment(i).getName();
            int assignmentGrade = parent.parent.courses.get(parent.parent.currentCourseWindow.courseIndex).getAssignmentCategory(categoryIndex).getAssignment(i).getWorth();
            parent.parent.currentAssignmentWindow.table.setValueAt(assignmentName, i, 0);
            parent.parent.currentAssignmentWindow.table.setValueAt(assignmentGrade, i, 1);
            parent.parent.currentAssignmentWindow.model.addRow(new Object[]{null, null});
        }
        parent.parent.currentAssignmentWindow.categoryIndex = categoryIndex;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton cancelButton;
    public javax.swing.JLabel courseInfo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
