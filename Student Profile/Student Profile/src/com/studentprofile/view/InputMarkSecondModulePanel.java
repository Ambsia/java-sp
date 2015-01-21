package com.studentprofile.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.studentprofile.StudentProfileMain;
import com.studentprofile.controller.ModuleMarkCollector;

/** This class extends JPanel and is used as one of the panels that
 *  are added to the second tab, this panel represents the input first marks
 *  panel. This class has functionality to add the text in both text fields to 
 *  the global array within the class ModuleMarkCollector. This class implements
 *  the ModuleMarkInterface which offers methods to setLabelText, setTextFields 
 *  and clearTextFields, an interface is used to allow the controller to iterate through
 *  all of the panels using the interface and access the methods of each panel. */
public final class InputMarkSecondModulePanel extends JPanel implements ModuleMarkInterface  {
	
	//fields
    private final JLabel lblSecondModule;
    private final JTextField txtSecondModuleCourseWorkMark;
    private final JTextField txtSecondModuleExamMark;

    /** Constructor instantiates the JLabel and each of the JTextFields and adds them
     * to the panel using GridBagLayout and GridBagConstraints to position each control. 
     * */
    public InputMarkSecondModulePanel() {
        StudentProfileMain.loadingPhaseString += "\t\t\t\t\tLoading second module panel components.\n";

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        lblSecondModule = new JLabel("No Profile");
        txtSecondModuleCourseWorkMark = new JTextField(2);
        txtSecondModuleExamMark = new JTextField(2);

        txtSecondModuleCourseWorkMark.setDocument(new TextFieldRestriction());
        txtSecondModuleExamMark.setDocument(new TextFieldRestriction());
        
        gbc.insets = new Insets(2, 2, 2, 40);
        gbc.weightx = 0.99;
        gbc.anchor = GridBagConstraints.WEST;
        this.add(lblSecondModule, gbc);
        gbc.gridx = 1;
        gbc.weightx = 0.001;
        gbc.insets = new Insets(2, 2, 2, 30);
        this.add(txtSecondModuleCourseWorkMark, gbc);
        gbc.gridx = 2;
        this.add(txtSecondModuleExamMark, gbc);
        
        StudentProfileMain.loadingPhaseString += "\t\t\t\t\tLoaded second module panel components.\n";
    }

    /** void addFirstModuleMarks, adds the text within each field to the
     * ModuleMarkCollector static array. Course work mark is always added first (even integer),
     * this allows the ModuleMarkCollector to know the difference between them both.  
     * */
    public void addSecondModuleMarks() {
        ModuleMarkCollector.moduleMarkList.add(txtSecondModuleCourseWorkMark.getText());
        ModuleMarkCollector.moduleMarkList.add(txtSecondModuleExamMark.getText());
    }
    
    @Override
    public void setTextFields(String cwkField, String examField) {
    	txtSecondModuleCourseWorkMark.setText(cwkField);
    	txtSecondModuleExamMark.setText(examField);
    }

    @Override
    public void setLabelText(String newText) {
        lblSecondModule.setText(newText);
    }
    
    @Override
    public void clearTextFields() {
        txtSecondModuleCourseWorkMark.setText("");
        txtSecondModuleExamMark.setText("");
    }
}
