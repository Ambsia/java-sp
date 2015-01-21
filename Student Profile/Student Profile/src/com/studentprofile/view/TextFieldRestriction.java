package com.studentprofile.view;

import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import com.studentprofile.controller.MessageBox;

/** This class extends PlainDocument. This class is used to
 * set each of the text fields with in the second tab (input marks)
 * document type to TextFieldRestriction, this allows me to enforce 
 * certain rules on the text fields this is used on. This class offers
 * functionality to block characters being input into certain text fields and
 * prevents more than 3 characters to be input at any one time.  
 * */
final class TextFieldRestriction extends PlainDocument {

	//fields
    private final int limit;

    /** Constructor used to set the limit to 3, do not offer a
     * parameter due to all of the text fields using this document
     * require the same treatment.
     * */
    public TextFieldRestriction() {
        this.limit = 3;
    }

    /** void insertString, overridden to allow some specific rules to be met,
     * this method will check if s is null, try to parse s to an integer and
     * check if the limit is reached. 
     * */
    @Override
	public void insertString(int offset, String s, javax.swing.text.AttributeSet a)
            throws BadLocationException {

        if (s == null)
            return;
        try {
            Integer.parseInt(s);
        } catch (Exception e) {
            MessageBox.errorMessageBox("These fields only accept integers.");
            super.remove(offset, 4);
        }

        if ((getLength() + s.length()) <= limit) {
            super.insertString(offset, s, a);
        }

    }
}