package com.company.controller;


import com.company.model.Course;
import com.company.model.Student;
import com.company.repository.CourseInMemoryRepository;
import com.company.repository.StudentInMemoryRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RegistrationSystem {

    private final CourseInMemoryRepository kursRepository = new CourseInMemoryRepository();
    private final StudentInMemoryRepository studentRepository = new StudentInMemoryRepository();

    /**
     *
     * @param name Name eines Kurs
     * @return ein Kurs
     */
    public Course getKursbyName(String name) {
        List<Course> kurses = getAllCourses();
        int i = 0;
        while(i < kurses.size()){
            if (kurses.get(i).getName().equals(name)){
                break;
            }
            i ++;
        }
        return kurses.get(i);
    }

    /**
     *
     * @param kurs Einen Kurs
     * @param student Einen Student
     * @return gibt true wenn der Student sich an den Kurs registrieren kann und false wenn es nocht moglich ist
     */
    public boolean register(Course kurs, Student student){
        List<Student> students = kurs.getStudentsEnrolled();
        List<Course> kursList = student.getEnrolledCourses();
        if (students==null){
            students = new ArrayList();
        }
        if (kursList==null){
            kursList = new ArrayList();
        }

        if (kurs.getMaxEnrollment() == students.size()) {
            return false;
        } else
            if (student.getTotalCredits() + kurs.getCredits() < 30) {
                kursList.add(kurs);
                students.add(student);
                kurs.setStudentsEnrolled(students);
                student.setEnrolledCourses(kursList);
                student.setTotalCredits(student.getTotalCredits() + kurs.getCredits());
                return true;
        } else return false;
    }

    /**
     *
     * @return Alle Kurse die noch freie platze haben
     */
    public List<Course> retrieveCursesWithFreePlaces(){
        List<Course> availableKurse = new ArrayList<>();
        Iterable<Course> kursList = kursRepository.findAll();
        for (Course kurs : kursList) {
            if (kurs.getStudentsEnrolled() == null) {
                availableKurse.add(kurs);
            } else {
                if (kurs.getStudentsEnrolled().size() < kurs.getMaxEnrollment()) {
                    availableKurse.add(kurs);
                }

            }
        }
        return availableKurse;
    }

    /**
     *
     * @param kurses Liste der Kurse die in der Console dargestellt werden
     */
    public void listKurs(List<Course> kurses){
        for (Course kurs : kurses) {
            System.out.println("ID: " + kurs.getIdCourse() + " Name: " + kurs.getName() + " Lehrer: " + kurs.getTeacher().getFirstName() + " " + kurs.getTeacher().getLastName() + " Credit: " + kurs.getCredits() + " MaxStudenten: " + kurs.getMaxEnrollment());
        }
        System.out.println("\n");
    }

    /**
     *
     * @param kurs Kurs der geloscht werden soll
     */
    public void deleteKurs(long kurs){
        kursRepository.delete(kurs);
    }

    /**
     *
     * @param kurs ein Kurs
     * @return gibt eine List aller Studenten die an einen Kurs registriert sind
     */
    public List<Student> retrieveStudentsEnrolledForACourse(Course kurs){
        return kurs.getStudentsEnrolled();
    }

    public void listStudent(List<Student> students){
        for (Student student : students) {
            System.out.println("StudentID: " + student.getStudentId() + " FistName: " + student.getFirstName() + " LastName: " + student.getLastName() + " Credits: " + student.getTotalCredits());
        }
        System.out.println("\n");
    }

    /**
     *
     * @return gibt eine List mit alle Kurse
     */
    public List<Course> getAllCourses() {
        return (List<Course>) kursRepository.findAll();

    }

    /**
     *
     * @return alle Studenten
     */
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    /**
     *
     * @param studentList liste von Studenten
     * @return eine Liste von studenten Sortiert nach anzahl Credits ASC
     */
    public ArrayList<Student> sortStudentsByCredits(ArrayList<Student> studentList){
        Collections.unmodifiableList(studentList);
        return studentList;
    }

    /**
     *
     * @param student ein Student
     * @return true wenn der Student zu die Liste hinzugefugt wurde, false wenn nicht
     */
    public boolean addStudent(Student student){
        if (studentRepository.save(student) != null){
            return false;
        }
        return true;
    }

    public boolean addKurs(Course kurs){
        if (kursRepository.save(kurs) != null){
            return false;
        }
        return true;
    }

    /**
     *
     * @param students Liste von Studenten
     * @param credit anzahl Credits nach dem man die Liste sortiert
     * @return die Filtrierte Liste von Studenten
     */
    public List<Student> filterByCredit(List<Student> students, int credit){
        List<Student> filteredList = new ArrayList<>();
        for (Student student: students){
            if (student.getTotalCredits() > credit){
                filteredList.add(student);
            }
        }
        return filteredList;
    }




}
