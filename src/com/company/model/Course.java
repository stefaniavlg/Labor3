package com.company.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Course model class
 */
public class Course {

    private Long id;
    private String name;
    private Person teacher;
    private int maxEnrollment;
    private List<Student> studentsEnrolled = new ArrayList<>();
    private int credits;


    /**
     * Getter name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * GETTER teacher
     * @return teacher
     */
    public Person getTeacher() {
        return teacher;
    }

    /**
     * Setter teacher
     * @param teacher
     */
    public void setTeacher(Person teacher) {
        this.teacher = teacher;
    }

    /**
     * Getter max enrollment
     * @return maxEnrollment
     */
    public int getMaxEnrollment() {
        return maxEnrollment;
    }

    /**
     * Setter max enrollment
     * @param maxEnrollment
     */
    public void setMaxEnrollment(int maxEnrollment) {
        this.maxEnrollment = maxEnrollment;
    }

    /**
     * Getter list of students enrolled
     * @return studentsEnrolled
     */
    public List<Student> getStudentsEnrolled() {
        return studentsEnrolled;
    }

    /**
     * Setter studentsEnrolled
     * @param studentsEnrolled
     */
    public void setStudentsEnrolled(List<Student> studentsEnrolled) {
        this.studentsEnrolled = studentsEnrolled;
    }

    /**
     * Getter credits
     * @return
     */
    public int getCredits() {
        return credits;
    }

    /**
     * Setter Credits
     * @param credits
     */
    public void setCredits(int credits) {
        this.credits = credits;
    }

    /**
     * Constructor Course
     * @param id
     * @param name
     * @param teacher
     * @param maxEnrollment
     * @param studentsEnrolled
     * @param credits
     */
    public Course(Long id, String name, Person teacher, int maxEnrollment, List<Student> studentsEnrolled, int credits) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.maxEnrollment = maxEnrollment;
        this.studentsEnrolled = studentsEnrolled;
        this.credits = credits;
    }

    /**
     * Construcotr
     */
    public Course(){}


    /**
     * Getter id
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter id
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }
}
