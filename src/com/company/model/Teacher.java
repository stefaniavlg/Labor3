package com.company.model;

import java.util.ArrayList;
import java.util.List;

/**
 * teacher model class
 */
public class Teacher extends Person {


    private List<Course> courses = new ArrayList<>();

    /**
     * getter list of courses
     * @return courses
     */
    public List<Course> getCourses() {
        return courses;
    }

    /**
     * setter list of courses
     * @param courses
     */
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

}
