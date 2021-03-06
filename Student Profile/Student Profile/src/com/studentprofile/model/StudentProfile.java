package com.studentprofile.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JFileChooser;

import com.studentprofile.StudentProfileMain;
import com.studentprofile.controller.MessageBox;
import com.studentprofile.view.JFileChooserLoader;


public class StudentProfile implements Serializable {


	private static final long serialVersionUID = 1L;
	private String pNumber;
	private String studentName;
	private Course course;

	public StudentProfile() {
		StudentProfileMain.loadingPhaseString += "\t\tLoading student profile model components.\n";
		pNumber = "";
		studentName = "";
		course = null;
		StudentProfileMain.loadingPhaseString += "\t\tLoaded student profile model components.\n";
	}

	public String getpNumber() {
		return pNumber;
	}

	public void setpNumber(String pNumber) {
		this.pNumber = pNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "StudentProfile:[pNumber=" + pNumber + ", studentName="
				+ studentName + ", course=" + course.actualToString() + "]";
	}

	/** boolean saveTofile. This method will show the user a file chooser dialog, which allows them
	 * to save an instance of model (StudentProfile) in a directory of their choice. 
	 * When the user approve the save, this method attempts to create an ObjectOutputStream and attempts to
	 * write the object "this" to the file and then will flush ObjectOutputStream created.
	 * If this succeeds then this method will return true, otherwise this method will return false.
	 * @throws IOException the input/output exception is caught.
	 * @return true or false, depending on whether the save succeeded or not.
	 * */	
	public boolean saveToFile() throws IOException {
		JFileChooserLoader fileDialog = new JFileChooserLoader();

		if (fileDialog.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			File file = fileDialog.getSelectedFile();

			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file + ".dat"))) {
				oos.writeObject(this);
				oos.flush();
				return true;
			} catch (IOException ioExcep) {
				MessageBox.errorMessageBox("Error Saving.");
				return false;
			}
		} else {
			MessageBox.infoMessageBox("Save canceled.");
			return false;
		}
	}
	
	/** boolean loadFromFile, this method will show the user file chooser dialog
	 * which allows them to choose a file they want to load, an ObjectInputStream 
	 * of the file the user choose is created and then attempted to be type casted to
	 * a instance of StudentProfile, if this fails or if the user cancels the save
	 * at any time then the method will return false. If this succeeds the current model
	 * instance will have all of the necessary information will be set to the loaded model's information.
	 * @throws ClassNotFoundException, the class not found exception is caught.
	 * @throws IOException this input/output exception is caught.
	 * @return true or false, depending on whether the load succeeded or not.
	 * */
	public boolean loadFromFile() throws ClassNotFoundException, IOException  {
		JFileChooserLoader fileDialog = new JFileChooserLoader();
		if (fileDialog.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File file = fileDialog.getSelectedFile();   
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {   	 
				StudentProfile local = (StudentProfile) ois.readObject();
				this.setCourse(local.getCourse());
				this.setpNumber(local.getpNumber());
				this.setStudentName(local.getStudentName());
				ois.close();
				return true;
			} catch (IOException | ClassNotFoundException exception) {
				MessageBox.errorMessageBox("Error Loading.");
				return false;
			} 
		} else {
			MessageBox.infoMessageBox("Load canceled.");
			return false;
		}
	}


}
