package com.company.model;

import java.util.ArrayList;
import java.util.List;

/**
 * student model class
 */
public class Student extends Person {

    private long studentId;
    private int totalCredits;
    private List<Course> enrolledCourses = new ArrayList<>();

    /**
     * constructor
     * @param studentId
     * @param totalCredits
     * @param enrolledCourses
     */
    public Student(long studentId, int totalCredits, List<Course> enrolledCourses) {
        this.studentId = studentId;
        this.totalCredits = totalCredits;
        this.enrolledCourses = enrolledCourses;
    }

    /**
     * constructor
     */
    public Student(){}


    /**
     * getter student id
     * @return studentId
     */
    public long getStudentId() {
        return studentId;
    }

    /**
     * setter studentId
     * @param studentId
     */
    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    /**
     * getter total credits
     * @return totalCredits
     */
    public int getTotalCredits() {
        return totalCredits;
    }

    /**
     * setter total credits
     * @param totalCredits
     */
    public void setTotalCredits(int totalCredits) {
        this.totalCredits = totalCredits;
    }

    /**
     * getter enrolled courses
     * @return enrolledCourses
     */
    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    /**
     * setter enrolled coureses
     * @param enrolledCourses
     */
    public void setEnrolledCourses(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }
}
