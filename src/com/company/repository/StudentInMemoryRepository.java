package com.company.repository;



import com.company.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentInMemoryRepository implements ICrudRepository<Student> {

    private List<Student> students = new ArrayList<>();

    /**
     *
     * @param id -the id of the entity to be returned id must not be null
     * @return
     */
    @Override
    public Student findOne(Long id){
        for(Student student : students){
            if(student.getStudentId()==id){
                return student;
            }
        }
        return null;
    }

    /**
     *
     * @return
     */
    @Override
    public List<Student> findAll(){
        return students;
    }

    /**
     *
     * @param entity entity must be not null
     * @return
     */
    @Override
    public Student save(Student entity){
        if(findOne(entity.getStudentId())==null){
            students.add(entity);
            return null;
        }
        return findOne((entity.getStudentId()));
    }

    /**
     *
     * @param id id must be not null
     * @return
     */
    @Override
    public Student delete(Long id){
        if(findOne(id)!=null) {
            Student s = new Student();
            s= findOne(id);
            students.remove(findOne(id));
            return s;
        }
        return null;
    }

    /**
     *
     * @param entity entity must not be null
     * @return
     */
    @Override
    public Student update(Student entity){
        if(findOne(entity.getStudentId())!=null) {
            for (int i = 0; i <= students.size(); i++) {
                if (students.get(i).getStudentId() == entity.getStudentId()) {
                    students.get(i).setFirstName(entity.getFirstName());
                    students.get(i).setLastName(entity.getLastName());
                    students.get(i).setTotalCredits(entity.getTotalCredits());
                    return null;
                }
            }
        }
        return entity;
    }
}
