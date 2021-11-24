package com.company.repository;



import com.company.model.Course;
import com.company.model.Student;
import com.company.model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class InMemoryRepository {

    private List<Course> kursList = new ArrayList<>();
    private List<Teacher> teacherList = new ArrayList<>();
    private List<Student> studentList = new ArrayList<>();

    public InMemoryRepository() {
        Teacher bob = new Teacher("Bob", "Stefan");
        Teacher raducu = new Teacher("Raducu", "Vasile");
        Teacher greg = new Teacher("Gregorian", "Plenicioiu");
        Teacher eric = new Teacher("Eric", " ");
        teacherList.add(bob);
        teacherList.add(raducu);
        teacherList.add(greg);
        teacherList.add(eric);

        Course info = new Course(1, "Info", bob, 5, 5);
        Course info2 = new Course(2, "Info2", bob, 1, 5);
        Course info3 = new Course(3, "Info3", raducu, 2, 5);
        Course info4 = new Course(4, "Info4", greg, 2, 5);
        Course info5 = new Course(5, "Info5", eric, 5, 5);
        Course info6 = new Course(6, "Info6", raducu, 2, 5);
        kursList.add(info);
        kursList.add(info2);
        kursList.add(info3);
        kursList.add(info4);
        kursList.add(info5);
        kursList.add(info6);

        Student theodor = new Student("Theodor", "Ranga", 1, 0);
        Student vlad = new Student("Vladut", "Nitup", 2, 0);
        Student ana = new Student("Ana", "Ion", 3, 0);
        studentList.add(theodor);
        studentList.add(vlad);
        studentList.add(ana);
    }

    public List<Course> getKursList() {
        return kursList;
    }

    public void setKursList(List<Course> kursList) {
        this.kursList = kursList;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
