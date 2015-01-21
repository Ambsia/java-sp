package com.studentprofile.view;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.studentprofile.StudentProfileMain;

/** This class extends JFrame. This class is used to create a window
 * and add the menu bar and the tab pane to it. This class has functionality
 * to return the instances of tab pane, menu bar and the JFrame itself. */
public final class StudentProfileFrame extends JFrame {

	//fields
    private final TabbedPaneLoader tabbedPane;
    private final MenuBarLoader menuBar;

    /** Constructor used to change the size of the window, set the
     * window title, instantiate the TabbedPaneLoader and MenuBarLoader,
     * and then add them to the JFrame instance. The default close operation
     * is set at do nothing, this allows me to confirm the exit in case unsaved
     * changes were made. 
     * */
    public StudentProfileFrame() {
    	
        this.setSize(new Dimension(750, 410));
        this.setMinimumSize(new Dimension(750, 410));
        
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        this.setTitle("Student Profile");

        StudentProfileMain.loadingPhaseString += "\n\tGetting tabbed pane.\n";
        tabbedPane = new TabbedPaneLoader();
        StudentProfileMain.loadingPhaseString += "\tLoaded tabbed pane.\n";
        StudentProfileMain.loadingPhaseString += "\tGetting menubar.\n";
        menuBar = new MenuBarLoader();
        StudentProfileMain.loadingPhaseString += "\tLoaded menubar.";
        this.setJMenuBar(menuBar);

        this.add(tabbedPane);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }
    /** StudentProfileFrame getMainFrame, returns the 
     * current instance of this JFrame.
     * @return this, the current instance of this class. 
     * */
    public StudentProfileFrame getMainFrame() {
        return this;
    }

    /** TabbedPaneLoader getTabbedPane, returns the
     * current instance of TabbedPaneLoader.
     * @return tabbedPane, the current instance of TabbedPaneLoader.
     * */
    public TabbedPaneLoader getTabbedPane() {
        return tabbedPane;
    }
    
    /** MenuBarLoader getFrameMenuBar, returns the
     * current instance of MenuBarLoader. 
     * @return menuBar, the current instance of MenuBarLoader.
     * */
    public MenuBarLoader getFrameMenuBar() {
        return menuBar;
    }

    /** void Exit, used to exit the JFrame. */
    public void Exit() {
        System.exit(JFrame.EXIT_ON_CLOSE);
    }
}
