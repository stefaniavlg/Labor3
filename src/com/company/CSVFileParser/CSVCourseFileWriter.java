package com.company.CSVFileParser;


import com.company.model.Course;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CSVCourseFileWriter {
    /**
     * Construct a Sting of Courses from a list
     * Writes the sting to the file
     *
     * @param courses
     */
    public void writeToCSVFile(List<Course> courses) {
        String data = "Id, Name, Credits, Max Students\n";
        for (Course course : courses) {
            data += course.getIdCourse() + ", " +
                    course.getName() + ", " +
                    course.getCredits() + ", " +
                    course.getMaxEnrollment();
            data += "\n";
        }
        try {
            Files.write(Paths.get("C:\\Users\\stefa\\IdeaProjects\\Labor3\\courses.csv"), data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
