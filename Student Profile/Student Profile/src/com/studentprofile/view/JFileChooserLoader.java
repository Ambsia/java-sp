package com.studentprofile.view;

import java.io.File;

import javax.swing.JFileChooser;
/** This class extends JFileChoose and is used to create an instance
 * of JFileChooser where the current directory is always set where the
 * user is. */
public final class JFileChooserLoader extends JFileChooser {

	/** Constructor sets the current instance of JFileChooser directory
	 * where the user is currently at.  */
    public JFileChooserLoader() {
        String workingDir = System.getProperty("user.dir");
        File theDirectory = new File(workingDir);

        this.setCurrentDirectory(theDirectory);
    }
}
