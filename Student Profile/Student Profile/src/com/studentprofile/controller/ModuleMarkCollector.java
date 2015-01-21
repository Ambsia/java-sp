package com.studentprofile.controller;

import java.util.ArrayList;

/** This class is used to allow the control to add all of the marks input from the view components
 * to be added to a static list, this list is then processed when needed and split into two lists,
 * one dedicated to exam marks and one dedicated to course work marks.
 * This class also offers methods which allow the two separate lists to be retrieved,
 * to check if the last run was an exception and to retrieve the exception string. */
public final class ModuleMarkCollector {

	//fields
	public static final ArrayList<String> moduleMarkList = new ArrayList<String>();
	private final ArrayList<Integer> examMarkList;
	private final ArrayList<Integer> cwkMarkList;
	private boolean lastRunWasException = false;
	private String exceptionString;

	/** ModuleMarkCollector constructor, instantiates the two lists
	 * and sets the exceptionString to empty. */
	public ModuleMarkCollector() {
		examMarkList = new ArrayList<Integer>();
		cwkMarkList = new ArrayList<Integer>();
		exceptionString = "";
	}

	/** void createMarkLists, this method is used to split the static list into two lists.
	 * This method checks if the last run was an exception, if it was then it will set the lastRunWasException boolean
	 * to false and then recursively call the createMarkLists method. If the last run was not an exception then
	 * both lists are cleared and each string within the main static list is processed and checked whether it is an integer
	 * and it is less than or equal to 100. If the String meets these two requirements, then the method will choose which list to
	 * add the integer to (course work marks are always added at even integers). When this method ends, two list of course work marks and
	 * exam marks are available to be used. */
	public void createMarkLists() {
		if (!lastRunWasException) {
			cwkMarkList.clear();
			examMarkList.clear();
			try {
				for (int i = 0; i < moduleMarkList.size(); i++) {
					if (Integer.parseInt(moduleMarkList.get(i)) > 100)	{
						this.exceptionString = "Values greater than 100 found.";
						this.lastRunWasException = true;
					} else if (i % 2 == 0 && cwkMarkList.size() != 4) {
						cwkMarkList.add(Integer.parseInt(moduleMarkList.get(i)));
					} else if (examMarkList.size() != 4) {
						examMarkList.add(Integer.parseInt(moduleMarkList.get(i)));
					}
				}
			} catch (Exception e) {
				this.exceptionString = "Non numeric values found.";
				this.lastRunWasException = true;
			}
		} else {
			this.exceptionString = "";
			this.lastRunWasException = false;
			createMarkLists();
		}
	}
	
	/** String getException, returns the exception string.
	 * @return String exceptionString, the last exception string. */
	public String getException() {
		return this.exceptionString;
	}

	/** boolean getLastRunWasException, returns whether or not the 
	 * last run of the method caused an exception.
	 * @return boolean lastRunWasException, whether the the last run caused and exception.*/
	public boolean getLastRunWasException() {
		return this.lastRunWasException;
	}

	/** ArrayList<Integer> getCwkWorkMarks, returns the list of course work marks.
	 * @return ArraList<Integer>, returns a list of integers, known as course work marks. */
	public ArrayList<Integer> getCwkWorkMarks() {
		return this.cwkMarkList;
	}

	/** ArrayList<Integer> getExamWorkMarks, returns the list of exam marks.
	 * @return ArraList<Integer>, returns a list of integers, known as exam marks. */
	public ArrayList<Integer> getExamWorkMarks() {
		return this.examMarkList;
	}
}
