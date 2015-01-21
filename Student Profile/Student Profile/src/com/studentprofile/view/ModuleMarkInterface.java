package com.studentprofile.view;

/** This interface is used by the input mark panels. This interface
 * offers functionality to setTextFields, setLabelText and clearTextFields.*/
public interface ModuleMarkInterface {
	
	/** void setTextFields, sets the text fields to the parameters passed, respectively.
	 * @param cwkField the string that the text field should be set to.
	 * @param examField the string that the text field should be set to.
	 * */
	public void setTextFields(String cwkField, String examField);
	
	/** void setLabelText, sets the label text to the parameter passed.
	 * @param newText the string that the text field should be set to.
	 * */
	public void setLabelText(String newText);

	/** void clearTextFields, clears each text field.
	 * */
	public void clearTextFields();
}

