package com.company.CSVFileParser;

import com.company.model.Course;
import com.company.model.Student;
import com.company.model.Teacher;
import com.company.repository.CourseInMemoryRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CSVReader {


    public CSVReader(CourseInMemoryRepository courseRepository) {}

    private static List<List<String>> readFile(String file){
        List<List<String>> toReturn = new ArrayList<>();

        String line;
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(file));
            while( (line = br.readLine()) != null){

                String[] data = line.split(", ");
                toReturn.add(Arrays.asList(data));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
            if(br != null){
                try{
                    br.close();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return toReturn;
    }

    /**
     *
     * @return studentList
     */
    public static List<Student> readStudents(){
        List<Student> studentList = new ArrayList<>();

        List<List<String>> unparsedStudents = readFile("C:\\Users\\stefa\\IdeaProjects\\Labor3\\students.csv");
        for(List<String> l: unparsedStudents){

            Student s = new Student(l.get(1),l.get(2), l.subList(3,l.size())
                    .stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList())
            );
            studentList.add(s);
        }
        return studentList;
    }

    /**
     *
     * @return teacherList
     */
    public static List<Teacher> readTeachers(){
        List<Teacher> teacherList = new ArrayList<>();

        List<List<String>> unparsedTeachers = readFile("C:\\Users\\stefa\\IdeaProjects\\Labor3\\teachers.csv");
        for(List<String> l: unparsedTeachers){

            Teacher t = new Teacher(l.get(1),l.get(2), l.subList(3, l.size())
                    .stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList())
            );

            teacherList.add(t);
        }
        return teacherList;
    }

    /**
     *
     * @return courseList
     */
    public static List<Course> readCourses(){
        List<Course> localCourseList = new ArrayList<>();

        List<List<String>> unparsedCourses = readFile("C:\\Users\\stefa\\IdeaProjects\\Labor3\\courses.csv");
        for(List<String> l:unparsedCourses){

            Course k = new Course(l.get(1), Long.parseLong(l.get(2)), Integer.parseInt(l.get(3)), Integer.parseInt(l.get(4)), l.subList(5, l.size())
                    .stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList()));

            localCourseList.add(k);
        }
        return localCourseList;
    }

}
