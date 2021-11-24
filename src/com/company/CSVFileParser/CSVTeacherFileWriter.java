package com.company.CSVFileParser;

import com.company.model.Course;
import com.company.model.Teacher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CSVTeacherFileWriter {
    /**
     * Construct a Sting of Teachers from a list
     * Writes the sting to the file
     *
     * @param teachers
     */
    public void writeToCSVFile(List<Teacher> teachers) {
        String data = "Id, First Name, Last Name, courses\n";
        for (Teacher teacher : teachers) {
            data += teacher.getIdPerson() + ", " +
                    teacher.getFirstName() + ", " +
                    teacher.getLastName() + ", [";
            for (Course course : teacher.getCourses()) {
                data += course.getIdCourse() + "; ";
            }
            if (teacher.getCourses().size() > 0) {
                data = data.substring(0, data.length() - 2);
            }
            data += "]\n";
        }
        try {
            Files.write(Paths.get("C:\\Users\\stefa\\IdeaProjects\\Labor3\\teachers.csv"), data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
