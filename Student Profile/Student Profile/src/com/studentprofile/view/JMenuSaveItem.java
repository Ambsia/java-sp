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
public final class JMenuSaveItem extends JMenuItem {
	
	/** Constructor initialises certain aspects of the JMenuItem, such
	 * as text and the key event.*/
    public JMenuSaveItem() {
        StudentProfileMain.loadingPhaseString += "\t\t\t\tLoading save item components.\n";
        this.setText("Save Student Data");
        this.setMnemonic(KeyEvent.VK_S);
        this.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        StudentProfileMain.loadingPhaseString += "\t\t\t\tLoaded save item components.\n";
    }

    /** void addAboutListener, add an action listener to the control.
     * @param al, the action listener handler. */
    public void addSaveListener(ActionListener al) {
        this.addActionListener(al);
    }
}