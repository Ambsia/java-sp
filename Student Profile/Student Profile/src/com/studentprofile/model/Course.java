package com.studentprofile.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.studentprofile.StudentProfileMain;


public class Course implements Serializable {

    private String courseName;
    private final Map<String, Module> modules;

    public Course(String courseName) {
        StudentProfileMain.loadingPhaseString += "\t\tLoading student course model components.\n";
        this.courseName = courseName;
        modules = new HashMap<String, Module>();
        StudentProfileMain.loadingPhaseString += "\t\tLoaded student course model components.\n";
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String name) {
        courseName = name;
    }

    public void addModule(Module m) {
        modules.put(m.getModuleCode(), m);
    }

    public Module getModule(String code) {
        return modules.get(code);
    }

    public Collection<Module> getModules() {
        return modules.values();
    }

    public int creditsPassed() {
        int credits = 0;
        for (Module m : getModules()) {
            if (!m.requireResit())
                credits += 30;
        }

        return credits;
    }

    public int yearAverageMark() {
        int mark = 0;
        for (Module m : getModules()) {
            mark += m.getModuleMark();
        }

        return (int) Math.round(mark / 4.0);
    }

    @Override
    public String toString() {
        //a non-standard toString that simply returns the course name,
        //so as to assist in displaying courses correctly in a JComboBox<Course>
        return courseName;
    }

    public String actualToString() {
        return "Course:[courseName=" + courseName + ", modules=" + modules + "]";
    }

}
