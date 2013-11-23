package interfaces;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
/**
 *
 * @author Lilong
 * @edut Bret
 */
public class SimpleMode extends javax.swing.JPanel implements ActionListener {
    private MainFrame parent;
    private ArrayList<JButton> courseButtons = new ArrayList<JButton>();
    private javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    public int indexOfCourse; 
    
    public String courseToBeEdited;
    
    /**
     * Creates new form SimpleMode
     */
    public SimpleMode(MainFrame frame) {
    	parent = frame;
        initComponents();
        setup();
        getSimpleModeLayOut();
        setRemoveMenu();
    }
    
    
    private void setup() {
    	for (int i = 0; i < parent.getCourses().size(); i++) {
    		String buttonText = createButtonText(i);
            final JButton button = new JButton();
            button.setFont(new java.awt.Font("Georgia", 0, 14));
            button.setText(buttonText);
            button.setActionCommand(buttonText);
            button.setVisible(true);
            parent.addCourseWindow(i);             //add new single course into arrlaylist 
                                                                            //of edit class windows
            button.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    buttonActionPerformed(evt);
                }
            });
            courseButtons.add(button);
    	}
    }
    
    private String createButtonText(int i) {
		return parent.getCourses().get(i).getCourseID() + parent.getCourses().get(i).getCourseNumber() 
				+ "-" + parent.getCourses().get(i).getSection() + " " + parent.getCourses().get(i).getSemester();
    }
    
    public void setPanelMenu() {
        
    	parent.setJMenuBar(mainMenuBar);
    }
    
    public void setSimpleModeVisible() {
        parent.simpleMode.setPanelMenu();
        parent.setContentPane(this);
        parent.pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        
        mainMenuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        saveAll = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem_addNewClass = new javax.swing.JMenuItem();
        removeClass = new javax.swing.JMenu();
        jMenuItem_editClassMenu = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        
        fileMenu.setText("File");

        saveAll.setText("Save All");
        saveAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //FIXME Method which saves every course here
            }
        });
        fileMenu.add(saveAll);

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

        mainMenuBar.add(editMenu);

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Courses", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 0, 14))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 258, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 213, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     *those code are repeated from the above, Because we are not allowed to change the code above
     *therefore, I created my own layout here
     */
    public final void getSimpleModeLayOut() {
    	GroupLayout.ParallelGroup horizontal = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
        GroupLayout.SequentialGroup vertical = layout.createSequentialGroup();
        
        vertical.addContainerGap();
        
    	for (int i = 0; i < courseButtons.size(); i++) {
    		horizontal.addComponent(courseButtons.get(i), javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE);
    		vertical.addComponent(courseButtons.get(i));
    		if (i != courseButtons.size() - 1)
    			vertical.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
    	}
    	
    	vertical.addContainerGap(40, Short.MAX_VALUE);
    	
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(horizontal)
                .addContainerGap())
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vertical)
        );
        courseButtons.clear();
    }
    
    public void addToRemoveMenu(int i) {
        final JMenuItem course = new JMenuItem(createButtonText(i));
        removeClass.add(course);
        course.addActionListener(this);
        course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //removedName = evt.getActionCommand();
                courseActionPerformed(evt, course);
            }
        });
    }
    
    private void setRemoveMenu() {
    	for (indexOfCourse = 0; indexOfCourse < parent.courses.size(); indexOfCourse++) {
    		addCourseToTable(indexOfCourse);
    	}
    }
    
    public void addCourseToTable(int i) {
        addToRemoveMenu(i);
    }
    
    /* 
     * this actionPerformed will update the buttons on simple mode
     * note: open editselectedcalss is another action perform which
     * will be involved in this method
     */    
    public void actionPerformed(java.awt.event.ActionEvent evt) {
	    this.removeAll();
	    parent.courseWindows.clear();
	    setup();
	    getSimpleModeLayOut();
    }

    private void jMenuItem_addNewClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_addNewClassActionPerformed
    	parent.addNewClass.setAddNewClass();
    }//GEN-LAST:event_jMenuItem_addNewClassActionPerformed

     private void courseActionPerformed(java.awt.event.ActionEvent evt, JMenuItem course) {   
         String courseName = evt.getActionCommand();
         for (int i = 0; i < parent.courses.size(); i++) {
        	 String possibleText = createButtonText(i);
             if (possibleText.equals(courseName)) {
            	parent.courses.remove(i).getName(); //remove from course object
                removeClass.remove(course); // rmove from the menu
                indexOfCourse--;
                i = parent.courses.size();
             }
         }
     }
    
    /*
     * Action to be perform when user click on course button
     */
    public void buttonActionPerformed(java.awt.event.ActionEvent evt) {
        courseToBeEdited = evt.getActionCommand(); //knowing which couse selected
        for (int i = 0; i < parent.courses.size(); i++) {
        	String possibleText = createButtonText(i);
            if (possibleText.equals(courseToBeEdited)) {
                parent.currentCourseWindow.setEditSelectedClassVisible();
                break;
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem jMenuItem_addNewClass;
    private javax.swing.JMenuItem jMenuItem_editClassMenu;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuBar mainMenuBar;
    private javax.swing.JMenu removeClass;
    private javax.swing.JMenuItem saveAll;
    // End of variables declaration//GEN-END:variables
}
