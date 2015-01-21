package com.studentprofile.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.studentprofile.StudentProfileMain;
/** This class extends JPanel and is used as one of the panels that
 *  are added to the second tab, this panel represents the header
 *  panel. This class has functionality to set a button to be visible
 *  or not and adds a action listener to the button.  */
public final class InputMarkHeaderPanel extends JPanel {
	//fields
    private final JButton btnLoadMarks;

    /** Constructor instantiates and adds the btnLoadMarks and adds 3 labels to 
     * this panel using GridBagLayout and GridBagConstraints to position each 
     * of the controls. 
     * */
    public InputMarkHeaderPanel() {
        StudentProfileMain.loadingPhaseString += "\t\t\t\t\tLoading header panel components.\n";
        btnLoadMarks = new JButton("Load Marks");
        btnLoadMarks.setVisible(false);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.insets = new Insets(2, 2, 2, 40);
        this.add(btnLoadMarks,gbc);
        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.weightx = 0.9;
        this.add(new JLabel("Module"), gbc);
        gbc.insets = new Insets(2, 0, 2, 5);
        gbc.weightx = 0.05;
        gbc.gridx = 1;
        this.add(new JLabel("Cwk Mark"), gbc);
        gbc.gridx = 2;
        gbc.insets = new Insets(2, 0, 2, 0);
        this.add(new JLabel("Exam Mark"), gbc);
 
        StudentProfileMain.loadingPhaseString += "\t\t\t\t\tLoaded header panel components.\n";

    }
    
    /** void setLoadMarksVisiblity, sets the visibility of 
     * the btnLoadMarks to the parameter passed.
     * @param visible, either true or false.
     * */
    public void setLoadMarksVisibility(boolean visible) {
    	btnLoadMarks.setVisible(visible);
    }
    
    /** void addLoadMarkListener, adds an action listener to
     * btnLoadMarks.
     * @param al the action listener handler to be used. 
     * */
    public void addLoadMarkListener(ActionListener al) {
    	btnLoadMarks.addActionListener(al);
    }
}