package com.company.CSVFileParser;

import com.company.model.Course;
import com.company.model.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CSVStudentFileWriter {
    /**
     * Construct a Sting of Students from a list
     * Writes the sting to the file
     *
     * @param students
     */
    public void writeToCSVFile(List<Student> students) {
        String data = "Id, First Name, Last Name, Credits, Courses\n";
        for (Student student : students) {
            data += student.getStudentId() + ", " +
                    student.getFirstName() + ", " +
                    student.getLastName() + ", " +
                    student.getTotalCredits() + ", [";
            for (Course course : student.getEnrolledCourses()) {
                data += course.getIdCourse() + "; ";
            }
            if (student.getEnrolledCourses().size() > 0) {
                data = data.substring(0, data.length() - 2);
            }
            data += "]\n";
        }
        try {
            Files.write(Paths.get("C:\\Users\\stefa\\IdeaProjects\\Labor3\\students.csv"), data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
