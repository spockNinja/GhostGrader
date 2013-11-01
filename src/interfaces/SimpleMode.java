/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.Container;
import java.awt.event.ActionListener;
import javax.swing.JButton;
/**
 *
 * @author Lilong
 */
public class SimpleMode extends javax.swing.JPanel implements ActionListener {

    public JButton newButton1 = new JButton();
    public JButton newButton2 = new JButton();
    public JButton newButton3 = new JButton();
    public JButton newButton4 = new JButton();
    public JButton newButton5 = new JButton();
    public JButton newButton6 = new JButton();
    public JButton newButton7 = new JButton();
    public JButton newButton8 = new JButton();
    public JButton newButton9 = new JButton();
    public JButton newButton10 = new JButton();
    public JButton newButton11 = new JButton();
    public JButton newButton12 = new JButton();
    public JButton newButton13 = new JButton();
    public JButton newButton14 = new JButton();
    public JButton newButton15 = new JButton();
    public JButton newButton16 = new JButton();
    public JButton newButton17 = new JButton();
    public JButton newButton18 = new JButton();
    public JButton newButton19 = new JButton();
    public JButton newButton20 = new JButton();
    
    private javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    /**
     * Creates new form SimpleMode
     */
    public SimpleMode() {
        initComponents();
        setup();
        getSimpleModeLayOut();
        //System.out.print(newButton1.getText() + "test");
    }
    
    private void setup() {
        newButton1.setText("");
        newButton2.setText("");
        newButton3.setText("");
        newButton4.setText("");
        newButton5.setText("");
        newButton6.setText("");
        newButton7.setText("");
        newButton8.setText("");
        newButton9.setText("");
        newButton10.setText("");
        newButton11.setText("");
        newButton12.setText("");
        newButton13.setText("");
        newButton14.setText("");
        newButton15.setText("");
        newButton16.setText("");
        newButton17.setText("");
        newButton18.setText("");
        newButton19.setText("");
        newButton20.setText("");
        
        newButton1.setVisible(false);
        newButton2.setVisible(false);
        newButton3.setVisible(false);
        newButton4.setVisible(false);
        newButton5.setVisible(false);
        newButton6.setVisible(false);
        newButton7.setVisible(false);
        newButton8.setVisible(false);
        newButton9.setVisible(false);
        newButton10.setVisible(false);
        newButton11.setVisible(false);
        newButton12.setVisible(false);
        newButton13.setVisible(false);
        newButton14.setVisible(false);
        newButton15.setVisible(false);
        newButton16.setVisible(false);
        newButton17.setVisible(false);
        newButton18.setVisible(false);
        newButton19.setVisible(false);
        newButton20.setVisible(false);
    }
    
    public JButton getButton() {
        if(newButton1.getText().equals("")) {
            return newButton1;
        } else if (newButton2.getText().equals("")) {
            return newButton2;
        } else if (newButton3.getText().equals("")) {
            return newButton3;
        } else if (newButton3.getText().equals("")) {
            return newButton3;
        } else if (newButton4.getText().equals("")) {
            return newButton4;
        } else if (newButton5.getText().equals("")) {
            return newButton5;
        } else if (newButton6.getText().equals("")) {
            return newButton6;
        } else if (newButton7.getText().equals("")) {
            return newButton7;
        } else if (newButton8.getText().equals("")) {
            return newButton8;
        } else if (newButton9.getText().equals("")) {
            return newButton9;
        } else if (newButton10.getText().equals("")) {
            return newButton10;
        } else if (newButton11.getText().equals("")) {
            return newButton11;
        } else if (newButton12.getText().equals("")) {
            return newButton12;
        } else if (newButton13.getText().equals("")) {
            return newButton13;
        } else if (newButton14.getText().equals("")) {
            return newButton14;
        } else if (newButton15.getText().equals("")) {
            return newButton15;
        } else if (newButton16.getText().equals("")) {
            return newButton17;
        } else if (newButton18.getText().equals("")) {
            return newButton18;
        } else if (newButton19.getText().equals("")) {
            return newButton19;
        } else if (newButton20.getText().equals("")) {
            return newButton20;
        } else return null;
    }
    
    private void createButtons(JButton button, String courseName) {
        button.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        button.setText(courseName);     
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Current Class", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 0, 14))); // NOI18N

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
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(newButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(newButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(newButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(newButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(newButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(newButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(newButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(newButton9, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(newButton10, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(newButton11, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(newButton12, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(newButton13, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(newButton14, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(newButton15, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(newButton16, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(newButton17, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(newButton18, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(newButton19, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(newButton20, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    )
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newButton9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newButton10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newButton11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newButton12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newButton13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newButton14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newButton15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newButton16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newButton17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newButton18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newButton19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newButton20)
                .addContainerGap(40, Short.MAX_VALUE))
        );
    }
    
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        if(!newButton1.isVisible()) {
            newButton1.setVisible(true);
        } else if (!newButton2.isVisible()) {
            newButton2.setVisible(true);
        } else if (!newButton3.isVisible()) {
            newButton3.setVisible(true);
        } else if (!newButton4.isVisible()) {
            newButton4.setVisible(true);
        } else if (!newButton5.isVisible()) {
            newButton5.setVisible(true);
        } else if (!newButton6.isVisible()) {
            newButton6.setVisible(true);
        } else if (!newButton7.isVisible()) {
            newButton7.setVisible(true);
        } else if (!newButton8.isVisible()) {
            newButton8.setVisible(true);
        } else if (!newButton9.isVisible()) {
            newButton9.setVisible(true);
        } else if (!newButton10.isVisible()) {
            newButton10.setVisible(true);
        } else if (!newButton11.isVisible()) {
            newButton11.setVisible(true);
        } else if (!newButton12.isVisible()) {
            newButton12.setVisible(true);
        } else if (!newButton13.isVisible()) {
            newButton13.setVisible(true);
        } else if (!newButton14.isVisible()) {
            newButton14.setVisible(true);
        } else if (!newButton15.isVisible()) {
            newButton15.setVisible(true);
        } else if (!newButton16.isVisible()) {
            newButton16.setVisible(true);
        } else if (!newButton17.isVisible()) {
            newButton17.setVisible(true);
        } else if (!newButton18.isVisible()) {
            newButton18.setVisible(true);
        } else if (!newButton19.isVisible()) {
            newButton19.setVisible(true);
        } else if (!newButton20.isVisible()) {
            newButton20.setVisible(true);
        } 
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
