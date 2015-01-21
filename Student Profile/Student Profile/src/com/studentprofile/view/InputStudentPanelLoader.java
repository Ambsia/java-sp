package com.studentprofile.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.studentprofile.StudentProfileMain;
import com.studentprofile.model.Course;

/** This class is used to add to the tab pane as the first tab, this class
 * extends the JPanel class. This class initialises and adds all of the
 * controls belonging to this tab in one place. This class has functionality to
 * set a red border around the text fields, set default fields, return the text
 * of each text field, return the course of the course combo box, populate the
 * combo box and add action events to each of the buttons.
 **/
public final class InputStudentPanelLoader extends JPanel {
	//fields

    private final JTextField txtStudentName;
    private final JTextField txtStudentPNumber;
    private final JComboBox<Course> cmbCourseList;
    private final JButton btnSubmit;
    private final JButton btnClear;
    private final JPanel txtNameErrorPanel = new JPanel();
    private final JPanel txtPNumberErrorPanel = new JPanel();
    private final Border border = BorderFactory.createLineBorder(Color.red);
    
    /** Constructor instantiates all of the JTextFields, JButtons and the JComboBox,
     * then using the GridBagLayout and GridBagConstraints each control is added to the panel.  */
    public InputStudentPanelLoader() {

        StudentProfileMain.loadingPhaseString += "\t\t\tLoading first tab components.\n";
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 2, 2, 40);
        txtStudentName = new JTextField(13);
        txtStudentName.setToolTipText("Enter name.");
        txtNameErrorPanel.add(txtStudentName);

        txtStudentPNumber = new JTextField(13);
        txtStudentPNumber.setToolTipText("Enter Personal ID Number PXXXXXXX.");
        txtPNumberErrorPanel.add(txtStudentPNumber);
        cmbCourseList = new JComboBox<Course>();
        cmbCourseList.setToolTipText("Choose course.");

        btnSubmit = new JButton("Create Profile");
        btnClear = new JButton("Clear");

        this.add(new JLabel("Name:"), gbc);
        gbc.gridx = 1;
        this.add(txtNameErrorPanel, gbc);
        gbc.gridx = 0;

        gbc.gridy = 1;
        this.add(new JLabel("P number:"), gbc);
        gbc.gridx = 1;
        this.add(txtPNumberErrorPanel, gbc);
        gbc.gridx = 0;

        gbc.gridy = 2;

        this.add(new JLabel("Choose course:"), gbc);
        gbc.gridx = 1;
        this.add(cmbCourseList, gbc);

        gbc.insets = new Insets(30, 2, 2, 2);
        gbc.gridy = 3;
        gbc.gridx = 0;
        this.add(btnSubmit, gbc);
        gbc.gridx = 1;
        this.add(btnClear, gbc);
        StudentProfileMain.loadingPhaseString += "\t\t\tLoaded first tab components.\n";


    }
    /** void setNameErrorBorder, sets the border of the JPanel surrounding
     * the txtStudentName text field.
     * @param borderActive, the boolean value that should be set. 
     * */
    public void setNameErrorBorder(boolean borderActive) {
    	if (borderActive) 
    		txtNameErrorPanel.setBorder(border);
    	else
    		txtNameErrorPanel.setBorder(null);
    }
    
    /** void setNameErrorBorder, sets the border of the JPanel surrounding
     * the txtStudentPNumber text field.
     * @param borderActive, the boolean value that should be set. 
     * */
    public void setStudentPNumberErrorBorder(boolean borderActive) {
      	if (borderActive) 
      		txtPNumberErrorPanel.setBorder(border);
    	else
    		txtPNumberErrorPanel.setBorder(null);
    }
    /** void setDefaultStudentDetails, sets all of the text fields to an empty string,
     * also sets the index of the combo box cmbCourseList to index 0.
     * */
    public void setDefaultStudentDetails() {
        txtStudentName.setText("");
        txtStudentPNumber.setText("");
        cmbCourseList.setSelectedIndex(0);
    }

    /** String getStudentName, returns the text in the txtStudentName field.
     * @return the text in the field txtStudentName. 
     * */
    public String getStudentName() {
        return txtStudentName.getText();
    }

    /** String getStudentPNumber, returns the text in the txtStudentPNumber field.
     * @return the text in the field txtStudentPNumber. 
     * */
    public String getStudentPNumber() {
        return txtStudentPNumber.getText();
    }

    /** Course getStudentCourse, returns a Course type casted from the text selected in the combo box.
     * @return the type casted value of the course from the combo box. */
    public Course getStudentCourse() {
        return (Course) cmbCourseList.getSelectedItem();
    }

    /** void addSubmitListener, adds a event listener to the btnSubmit control.
     * @param al, the action listener handler.
     * */
    public void addSubmitListener(ActionListener al) {
        btnSubmit.addActionListener(al);
    }

    /** void addClearListener, adds a event listener to the btnClear control.
     * @param al, the action listener handler.
     * */
    public void addClearListener(ActionListener al) {
        btnClear.addActionListener(al);
    }

    /** void populateComboBox, for every course a combo box item will be added
     * containing the name of the course. 
     * @param courses, the array of courses to be added to the combo box. 
     * */
    public void populateComboBox(Course[] courses) {
        for (Course c : courses) {
            cmbCourseList.addItem(c);
        }
    }


}