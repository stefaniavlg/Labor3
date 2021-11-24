package com.company;

import com.company.CSVFileParser.*;
import com.company.controller.RegistrationSystem;
import com.company.model.Course;
import com.company.model.Student;
import com.company.model.Teacher;
import com.company.repository.CourseInMemoryRepository;
import com.company.repository.StudentInMemoryRepository;
import com.company.repository.TeacherInMemoryRepository;
import com.company.view.ConsoleView;

import java.util.List;

public class StartApp {
    public static void main(String[] args) {
        TeacherInMemoryRepository teacherRepository = new TeacherInMemoryRepository();
        StudentInMemoryRepository studentRepository = new StudentInMemoryRepository();
        CourseInMemoryRepository courseRepository = new CourseInMemoryRepository();

        CSVStudentFileReader csvStudentFileReader = new CSVStudentFileReader(courseRepository);
        CSVTeacherFileReader csvTeacherFileReader = new CSVTeacherFileReader(courseRepository);
        CSVCourseFileReader csvCourseFileReader = new CSVCourseFileReader();

        CSVStudentFileWriter csvStudentFileWriter = new CSVStudentFileWriter();
        CSVCourseFileWriter csvCourseFileWriter = new CSVCourseFileWriter();
        CSVTeacherFileWriter csvTeacherFileWriter = new CSVTeacherFileWriter();

        courseRepository.setCourses(csvCourseFileReader.readFromCSVFile());
        teacherRepository.setTeachers(csvTeacherFileReader.readFromCSVFile());
        studentRepository.setStudents(csvStudentFileReader.readFromCSVFile());

        RegistrationSystem controller = new RegistrationSystem(courseRepository);

        ConsoleView console = new ConsoleView(controller, studentRepository);

        console.consoleApp();

        csvStudentFileWriter.writeToCSVFile((List<Student>) studentRepository.findAll());
        csvCourseFileWriter.writeToCSVFile((List<Course>) courseRepository.findAll());
        csvTeacherFileWriter.writeToCSVFile((List<Teacher>) teacherRepository.findAll());
    }
}
