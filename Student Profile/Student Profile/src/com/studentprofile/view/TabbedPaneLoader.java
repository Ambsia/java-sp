package com.studentprofile.view;


import javax.swing.JTabbedPane;

import com.studentprofile.StudentProfileMain;

/** This class extends JTabbedPane. This class is used to 
 * instantiate the firstTab, secondTab and the thirdTab and add
 * them to the tab pane accordingly. This class offers functionality
 * to return each of the tabs individually and to change the tab index. 
 * */
public final class TabbedPaneLoader extends JTabbedPane {
	
	//fields
    private final InputStudentPanelLoader firstTab;
    private final InputMarkPanelLoader secondTab;
    private final OutputPanelLoader thirdTab;

    /** Constructor instantiates the firstTab, secondTab and thirdTab
     * and then adds them to the instance of JTabbedPane with labels that
     * briefly describe their nature. */
    public TabbedPaneLoader() {

        StudentProfileMain.loadingPhaseString += "\t\tGetting first tab.\n";
        firstTab = new InputStudentPanelLoader();
        StudentProfileMain.loadingPhaseString += "\t\tLoaded first tab.\n";
        StudentProfileMain.loadingPhaseString += "\t\tGetting second tab.\n";
        secondTab = new InputMarkPanelLoader();
        StudentProfileMain.loadingPhaseString += "\t\tLoaded second tab.\n";
        StudentProfileMain.loadingPhaseString += "\t\tGetting third tab.\n";
        thirdTab = new OutputPanelLoader();
        StudentProfileMain.loadingPhaseString += "\t\tLoaded third tab.\n";

        this.addTab("Student Details", firstTab);
        this.addTab("Input Marks", secondTab);
        this.addTab("Overview", thirdTab);
    }

    /** InputStudentPanelLoader getInputStudentPanel, returns the instance of InputStudentPanelLoader
     * @return firstTab, the instance of InputStudentPanelLoader. 
     * */
    public InputStudentPanelLoader getInputStudentPanel() {
        return firstTab;
    }

    /** InputMarkPanelLoader getInputMarkPanel, returns the instance of InputMarkPanelLoader
     * @return secondTab, the instance of InputMarkPanelLoader. 
     * */
    public InputMarkPanelLoader getInputMarkPanel() {
        return secondTab;
    }

    /** OutputPanelLoader getOutputPanel, returns the instance of OutputPanelLoader
     * @return thirdTab, the instance of OutputPanelLoader. 
     * */
    public OutputPanelLoader getOutputPanel() {
        return thirdTab;
    }

    /** void changeTab, changes the tab index of JTabbedPane. 
     * */
    public void changeTab(int index) {
        this.setSelectedIndex(index);
    }


}
