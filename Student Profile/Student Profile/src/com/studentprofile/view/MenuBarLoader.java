package com.studentprofile.view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

import com.studentprofile.StudentProfileMain;

/** This class extends JMenuBar. This class is used to build a JMenuBar
 * using 4 items, the first three items "loadItem, saveItem, exitItem" will
 * be added to the first menu "File". The "aboutItem" will be added to the second
 * menu "Help". 
 * */
public final class MenuBarLoader extends JMenuBar {
	
	//fields
    private final JMenuLoadItem loadItem;
    private final JMenuSaveItem saveItem;
    private final JMenuExitItem exitItem;
    private final JMenuAboutItem aboutItem;

    /** Constructor instantiates each JMenuItem and then adds
     * them to there correct JMenu which is instantiated twice
     * representing two different menus. */
    public MenuBarLoader() {
        StudentProfileMain.loadingPhaseString += "\t\tLoading menubar components.\n";

        StudentProfileMain.loadingPhaseString += "\t\t\tLoading load item component.\n";
        loadItem = new JMenuLoadItem();
        StudentProfileMain.loadingPhaseString += "\t\t\tLoaded load item component.\n";
        StudentProfileMain.loadingPhaseString += "\t\t\tLoading save item component.\n";
        saveItem = new JMenuSaveItem();
        StudentProfileMain.loadingPhaseString += "\t\t\tLoaded save item component.\n";
        StudentProfileMain.loadingPhaseString += "\t\t\tLoading exit item component.\n";
        exitItem = new JMenuExitItem();
        StudentProfileMain.loadingPhaseString += "\t\t\tLoaded exit item component.\n";
        StudentProfileMain.loadingPhaseString += "\t\t\tLoading about item component.\n";
        aboutItem = new JMenuAboutItem();
        StudentProfileMain.loadingPhaseString += "\t\t\tLoaded about item component.\n";
        
        JMenu menu;

        menu = new JMenu("File");
        menu.add(loadItem);
        menu.add(saveItem);
        menu.addSeparator();
        menu.add(exitItem);
        this.add(menu);

        menu = new JMenu("Help");
        menu.add(aboutItem);
        this.add(menu);
        
        StudentProfileMain.loadingPhaseString += "\t\tLoaded menubar components.\n";
    }

    /** JMenuLoadItem getLoadMenuItem, returns the load menu item.
     * @return loadItem, returns the load menu item.*/
    public JMenuLoadItem getLoadMenuItem() {
        return loadItem;
    }

    /** JMenuSaveItem getSaveMenuItem, returns the save menu item.
     * @return loadItem, returns the save menu item.*/
    public JMenuSaveItem getSaveMenuItem() {
        return saveItem;
    }

    /** JMenuExitItem getExitMenuItem, returns the exit menu item.
     * @return exitItem, returns the exit menu item.*/
    public JMenuExitItem getExitMenuItem() {
        return exitItem;
    }

    /** JMenuAboutItem getAboutMenuItem, returns the about menu item.
     * @return aboutItem, returns the about menu item.*/
    public JMenuAboutItem getAboutMenuItem() {
        return aboutItem;
    }
}
