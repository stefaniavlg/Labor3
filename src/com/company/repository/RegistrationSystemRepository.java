package com.company.repository;


import com.company.controller.RegistrationSystem;
import com.company.model.Course;
import com.company.model.Student;

import java.util.ArrayList;
import java.util.List;

public class RegistrationSystemRepository {
    RegistrationSystem registrationSystem = new RegistrationSystem();

    public boolean register(Course kurs, Student student){
        return registrationSystem.register(kurs, student);
    }

    public Course getKursbyName(String name) {
        return registrationSystem.getKursbyName(name);
    }

    public List<Course> retrieveCursesWithFreePlaces(){
        return registrationSystem.retrieveCursesWithFreePlaces();
    }

    public void listKurs(List<Course> kurses){
        registrationSystem.listKurs(kurses);
    }

    public void deleteKurs(long kurs){
        registrationSystem.deleteKurs(kurs);
    }

    public List<Student> retrieveStudentsEnrolledForACourse(Course kurs){
        return registrationSystem.retrieveStudentsEnrolledForACourse(kurs);
    }

    public void listStudent(List<Student> students){
        registrationSystem.listStudent(students);
    }

    public List<Course> getAllCurses() {
        return registrationSystem.getAllCourses();
    }

    public List<Student> getAllStudents() {
        return registrationSystem.getAllStudents();
    }

    public List<Student> sortStudentsByCredits(List<Student> students){
        return registrationSystem.sortStudentsByCredits((ArrayList<Student>) students);
    }

    public boolean addStudent(Student student){
        return registrationSystem.addStudent(student);
    }

    public List<Student> filterByCredit(List<Student> students, int credit){
        return registrationSystem.filterByCredit(students, credit);
    }

    public  boolean addKurs(Course kurs) { return registrationSystem.addKurs(kurs);}
}
