/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Lilong
 */
public class GradebooksWindow extends javax.swing.JPanel {
    public DefaultTableModel model;
    public ArrayList<String> courseData = new ArrayList<String>();
    /**
     * Creates new form CurrentClass
     */
    public GradebooksWindow() {
        initComponents();
        setup();
    }
    
    private void setup() {
        model = (DefaultTableModel) classTable.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        classTable = new javax.swing.JTable();

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Courses", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 0, 14))); // NOI18N

        classTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Row", "Class Name", "Course Prefix", "Course Number", "Class Section", "Class Building", "Class Room Number", "Meeting Time", "Semester"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(classTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 787, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public int upDateWelcomeWindow() {
        model.addRow(new Object[]{null, null, null, null, null, null, null, null, null});
        int r = 0;
        for (r = 0; r < classTable.getRowCount() - 1; r++) {
            if (classTable.getValueAt(r, 0) == null) {
                classTable.setValueAt(r, r, 0);
                for (int c = 0; c < classTable.getColumnCount() - 1; c++) {
                    classTable.setValueAt(courseData.get(c), r, c + 1);
                }
            return r;
            }
        }
        return 0;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable classTable;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
