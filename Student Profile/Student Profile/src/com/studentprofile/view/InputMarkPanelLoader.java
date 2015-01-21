package com.studentprofile.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.studentprofile.StudentProfileMain;

/** This class used to add to the tab pane as the second tab, this class
 * adds a single instance of a JPanel which consists of 6 other panels.
 * This class has functionality to set the profile found label to text passed
 * in the parameter and functionality to return the instance of the panel added.   
 * */
public final class InputMarkPanelLoader extends JPanel {
	//fields
    private final InputMarkPanels panel;
    private final JLabel lblProfileFound;

    /** Constructor instantiates the JLabel and the panel and then adds
     * the controls using GridBagLayout and GridBagConstraints to position the controls.  
     * */
    public InputMarkPanelLoader() {
        StudentProfileMain.loadingPhaseString += "\t\t\tLoading second tab panels.\n";
        panel = new InputMarkPanels();


        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(2, 2, 25, 2);
        lblProfileFound = new JLabel("No profile found, please load one or create one.");
        this.add(lblProfileFound, gbc);

        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.gridy = 1;
        this.add(panel, gbc);


        StudentProfileMain.loadingPhaseString += "\t\t\tLoaded second tab panels.\n";
    }

    /** InputMarkPanels getMainPanel, returns the instance of the panel added.
     * @return the current instance of InputMarkPanels. 
     * */
    public InputMarkPanels getMainPanel() {
        return panel;
    }

    /** void setProfileFound, sets the label text to the parameter passed.
     * @param profileName, the name of the profile.
     * */
    public void setProfileFound(String profileName) {
        this.lblProfileFound.setText("Profile found: " + profileName + ".");
    }


}
