/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces.editClass;

import interfaces.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;

import java.io.File;
import java.io.IOException;

import objects.AssignmentCategory;
import io.Exporter;
import io.parseXML;

import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 *
 * @author Lilong
 */
public class EditSelectedClass extends javax.swing.JPanel implements ActionListener{

    public CreateCategoryPanel categoryWindow  = new CreateCategoryPanel(this);
    public MainFrame parent;
    private int assignmentIndex, categoryIndex, courseIndex;
    private boolean isTableSet = false;
    private ArrayList<AssignmentCategory> assignmentCategories = new ArrayList<AssignmentCategory>();
    
    /**
     * Creates new form EditCourse
     * @param frame
     * @param currentCourseInd
     */
    public EditSelectedClass(MainFrame frame, int currentCourseInd) {
        parent = frame;
        courseIndex = currentCourseInd;
        initComponents();
        if (courseIndex != -1)
        	setup();
    }
    
    private void setup() {
        model = (DefaultTableModel)assignmentTable.getModel();
        if (parent.courses.get(courseIndex) != null)
        	courseName.setText(parent.courses.get(courseIndex).getName() 
        			+ "-" + parent.courses.get(courseIndex).getSection());
        if (parent.courses.get(courseIndex).getNumberOfAssignmentCategories() > 0) {
            loadCourseData();
        }
    }
    
    private void loadCourseData() {
        for (int i = 0; i < parent.courses.get(courseIndex).getNumberOfAssignmentCategories(); i++) {
            //FIXME Should have add/remove buttons
            javax.swing.JMenu categoryMenu = new javax.swing.JMenu();
            categoryMenu.setText(parent.courses.get(courseIndex).getAssignmentCategory(i).getName());

            for (int j = 0; j < parent.courses.get(courseIndex).getAssignmentCategory(i).getNumberOfAssignments(); j++) {
        	 	final int indexOfCategory = i;
        	 	final int indexOfAssignment = j;
        	 	assignmentIndex = j;
             	categoryIndex = i;
             	final javax.swing.JMenuItem assignmentMenuItem = new javax.swing.JMenuItem();
             	assignmentMenuItem.setText(parent.courses.get(courseIndex).getAssignmentCategory(i).getAssignment(j).getName());
             	assignmentMenuItem.addActionListener(new java.awt.event.ActionListener() {
             		public void actionPerformed(java.awt.event.ActionEvent evt) {
             			categoryIndex = indexOfCategory;
             			assignmentIndex  = indexOfAssignment;
             			isTableSet = false;
             			populateTable();
             			courseName.setText(parent.courses.get(courseIndex).getName() 
                     		+ "-" + parent.courses.get(courseIndex).getSection() 
                     		+ " " + assignmentMenuItem.getText());
                     }
                });
             	categoryMenu.add(assignmentMenuItem);   		
            }
            menuBar.add(categoryMenu);
            addToRemoveCategoryMenu(categoryMenu);
            categoryMenu.add(new javax.swing.JPopupMenu.Separator());
            addNewAssignmentButton(categoryMenu);
            removeAssignmentButton(categoryMenu);
        }     
    }
    
    
    private void addToRemoveCategoryMenu(JMenu category) {
        final JMenuItem caToBeRemove = new JMenuItem(category.getText());
        removeCategory.add(caToBeRemove);
        caToBeRemove.addActionListener(this);
        caToBeRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeCategoryActionPerformed(evt, caToBeRemove);
            }
        });
    }
    
    
    private void populateTable() {
    	for (int i = model.getRowCount()-1; i >= 0; i--) {
    		model.removeRow(i);
    	}
    	for (int i = 0; i < parent.courses.get(courseIndex).getNumberOfStudents(); i++) {
    		model.insertRow(i, new Object[]{ 
    				parent.courses.get(courseIndex).getStudent(i).getFullName(), 
    				parent.courses.get(courseIndex)
    				.getCategories().get(categoryIndex)
    				.getAssignment(assignmentIndex)
    				.getGrade(parent.courses.get(courseIndex).getStudent(i).getPseudoName())});
    	}
    	isTableSet = true;
    }
    
    public void setPanelMenu() {
    	parent.setJMenuBar(menuBar);
    }
    
    public void actionPerformed(ActionEvent evt) {
        if (categoryWindow.actionStatus.equals("addCategory")) {
            createNewCategory();
        }
    }
    
    private void createNewCategory() {
        if (repeatCategoryChecker()) {
            JMenu newCategory = new JMenu(categoryWindow.getCategoryName());
            menuBar.add(newCategory);
            //adding add new assignment button
            addNewAssignmentButton(newCategory);

            //adding remove assignment button
            removeAssignmentButton(newCategory);
            parent.courses.get(courseIndex).addAssignmentCategory(categoryWindow.getCategoryName()); // add new category
                                                                                                     // to the course object
            addToRemoveCategoryMenu(newCategory); //add to remove category menu
            categoryWindow.actionStatus = "waiting";
        }
    }
    
    private void addNewAssignmentButton(JMenu category) {
        JMenuItem addAssignmentButton = new JMenuItem("Add");
        category.add(addAssignmentButton, -1);
        addAssignmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAssignmentActionPerformed(evt);
            }
        });
    }
    
    private void removeAssignmentButton(JMenu category) {
        JMenuItem removeAssignmentButton = new JMenuItem("Remove");
        category.add(removeAssignmentButton, -1);
        removeAssignmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAssignmentActionPerformed(evt);
            }
        });
    }
    
    public boolean repeatCategoryChecker() {
        for (int i = 0; i < parent.courses.get(courseIndex).getNumberOfAssignmentCategories(); i++) {
            if (parent.courses.get(courseIndex).getAssignmentCategory(i).getName().equals(categoryWindow.getCategoryName())) {
                System.out.print(i);
                JOptionPane.showMessageDialog(null,
                            String.format("%33s",categoryWindow.getCategoryName() + 
                            " category already exited"),"Error",
                            JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }
    
    @SuppressWarnings("serial")
    public DefaultTableModel model = new DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Student", "Grade"
        }
    ) {
        public boolean isCellEditable(int row, int column) {
                if (column == 0)
                        return false;
                else
                        return true;
        }
    };
    
    public void setEditSelectedClassVisible() {
        parent.setCurrentCourseWindow(this);
        parent.setCurrentCategoryWindow(this.categoryWindow);
        parent.setContentPane(this);
        this.setPanelMenu();
        parent.pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        File_Save = new javax.swing.JMenuItem();
        File_ExportToHTML = new javax.swing.JMenuItem();
        createMenu = new javax.swing.JMenu();
        addCategory = new javax.swing.JMenuItem();
        removeCategory = new javax.swing.JMenu();
        studentMenu = new javax.swing.JMenu();
        addStudent = new javax.swing.JMenuItem();
        removeStudent = new javax.swing.JMenuItem();
        separator = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        assignmentTable = new javax.swing.JTable();
        goBackButton = new javax.swing.JButton();
        courseName = new javax.swing.JLabel();

        fileMenu.setText("File");

        File_Save.setText("Save");
        fileMenu.add(File_Save);

        File_ExportToHTML.setText("Export To HTML");
        File_ExportToHTML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                File_ExportToHTMLActionPerformed(evt);
            }
        });
        fileMenu.add(File_ExportToHTML);

        menuBar.add(fileMenu);

        createMenu.setText("Create");

        addCategory.setText("Add Category");
        addCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCategoryActionPerformed(evt);
            }
        });
        createMenu.add(addCategory);

        removeCategory.setText("removeCategory");
        createMenu.add(removeCategory);

        menuBar.add(createMenu);

        studentMenu.setText("Student");

        addStudent.setText("Add Student");
        studentMenu.add(addStudent);

        removeStudent.setText("Remove Student");
        studentMenu.add(removeStudent);

        menuBar.add(studentMenu);

        assignmentTable.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        assignmentTable.setModel(model);
        assignmentTable.getModel().addTableModelListener(changedData());
        jScrollPane1.setViewportView(assignmentTable);

        goBackButton.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        goBackButton.setText("Go Back");
        goBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackButtonActionPerformed(evt);
            }
        });

        courseName.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        courseName.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(goBackButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(courseName)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(courseName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(goBackButton)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private TableModelListener changedData() {
    	TableModelListener cha = new TableModelListener() {
    		public void tableChanged(TableModelEvent e) {
  			   if (isTableSet) {
  				   int r = e.getLastRow();
  				   parent.courses.get(courseIndex).getCategories()
  	    			.get(categoryIndex)
  	    			.getAssignment(assignmentIndex)
  	    			.setGrade(parent.courses.get(courseIndex).getStudent(r).getPseudoName(), 
  	    					Integer.parseInt(model.getValueAt(r, 1).toString()));
  			   }
		   }
		};
		return cha;
    }
    
    
    private void removeCategoryActionPerformed(java.awt.event.ActionEvent evt, JMenuItem category) {
         String categoryName = evt.getActionCommand();
         for (int i = 0; i < parent.courses.get(courseIndex).getNumberOfAssignmentCategories(); i++) {
             if (parent.courses.get(courseIndex).getAssignmentCategory(i).getName().equals(categoryName)) {
                //FIXME it does not remove after new class added
            	parent.courses.get(courseIndex).removeAssignmentCategory(categoryName); //remove from course object
                removeCategory.remove(category); // rmove from the menu
                for (int j = 0; j < menuBar.getComponentCount(); j++) {
                    if (menuBar.getMenu(j).getText().equals(category.getText())) {
                        menuBar.remove(j);
                        
                        j = menuBar.getComponentCount();
                    }
                }
                i = parent.courses.get(courseIndex).getNumberOfAssignmentCategories();
             }
         }
         this.setPanelMenu();
    }
    
    private void addAssignmentActionPerformed(java.awt.event.ActionEvent evt) {
        //TODO
    }
    
    private void removeAssignmentActionPerformed(java.awt.event.ActionEvent evt) {
        //TODO
    }
    
    private void goBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackButtonActionPerformed
        parseXML.saveXML(parent.courses.get(courseIndex));
        parent.simpleMode.setSimpleModeVisible();
    }//GEN-LAST:event_goBackButtonActionPerformed

    private void addCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCategoryActionPerformed
        categoryWindow.setCreateCategoryVisible();
    }//GEN-LAST:event_addCategoryActionPerformed

    private void File_ExportToHTMLActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showSaveDialog(EditSelectedClass.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            Exporter exp = new Exporter();
            File file = fc.getSelectedFile();
            try {
                exp.exportCourseToHTML(parent.courses.get(courseIndex), file.getCanonicalPath());
            }
            catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error exporting HTML.");
            }
        }
    }                                                      

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem File_ExportToHTML;
    private javax.swing.JMenuItem File_Save;
    private javax.swing.JMenuItem addCategory;
    private javax.swing.JMenuItem addStudent;
    private javax.swing.JTable assignmentTable;
    private javax.swing.JLabel courseName;
    private javax.swing.JMenu createMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JButton goBackButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu removeCategory;
    private javax.swing.JMenuItem removeStudent;
    private javax.swing.JSeparator separator;
    private javax.swing.JMenu studentMenu;
    // End of variables declaration//GEN-END:variables
}
