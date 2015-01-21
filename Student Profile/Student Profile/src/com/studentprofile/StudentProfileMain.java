package com.studentprofile;

import com.studentprofile.controller.Controller;
import com.studentprofile.model.StudentProfile;
import com.studentprofile.view.StudentProfileFrame;

public final class StudentProfileMain {

    //this static string will be used constantly throughout the application loading phase, each class will append what is loading.
    public static String loadingPhaseString = "";

    /** static void main, this will be called when the application is first ran
     * a instance of StudentProfileMain() is instantiated.
     */
    public static void main(String[] args) {
        new StudentProfileMain();
    }

    //fields
    private final Controller controller;

    private final StudentProfileFrame view;

    private final StudentProfile model;

    /** Constructor instantiates view and model and then controller,
     * passing the view and model to the controller class.
     */
    private StudentProfileMain() {
        loadingPhaseString += "Getting View...";

        this.view = new StudentProfileFrame();

        loadingPhaseString += "\nView Loaded.";
        loadingPhaseString += "\nGetting model.\n";

        this.model = new StudentProfile();

        loadingPhaseString += "Model loaded.";
        loadingPhaseString += "\nGetting controller.\n";

        this.controller = new Controller(view, model);

        loadingPhaseString += "Controller loaded.";
        System.out.println(loadingPhaseString);

    }

    /** getController, returns the current controller instance.
     * @return controller, the current instance of Controller.
     */
    public Controller getController() {
        return controller;
    }

    /** getModel, returns the current model instance.
     * @return model, the current instance of Model.
     */
    public StudentProfile getModel() {
        return model;
    }

    /** getView, returns the current view instance.
     * @return view, the current instance of View.
     */
    public StudentProfileFrame getView() {
        return view;
    }

}
