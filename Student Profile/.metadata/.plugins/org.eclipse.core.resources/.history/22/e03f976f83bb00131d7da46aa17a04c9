package com.studentprofile.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import com.studentprofile.StudentProfileMain;

/** This class extends JMenuItem and is used to add a menu item to 
 * the menu bar. This class has functionality to add a action listener
 * to the JMenuItem. */
public final class JMenuLoadItem extends JMenuItem {

	/** Constructor initialises certain aspects of the JMenuItem, such
	 * as text and the key event.*/
    public JMenuLoadItem() {
        StudentProfileMain.loadingPhaseString += "\t\t\t\tLoading load item components.\n";
        this.setText("Load Student Data");
        this.setMnemonic(KeyEvent.VK_L);
        this.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        StudentProfileMain.loadingPhaseString += "\t\t\t\tLoaded load item components.\n";
    }

    /** void addAboutListener, add an action listener to the control.
     * @param al, the action listener handler. */
    public void addLoadListener(ActionListener al) {
        this.addActionListener(al);
    }
}