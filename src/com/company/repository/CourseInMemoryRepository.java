package com.company.repository;



import com.company.model.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseInMemoryRepository implements ICrudRepository<Course> {

    private List<Course> courses = new ArrayList<>();

    /**
     * @param id -the id of the entity to be returned id must not be null
     * @return the entity with the specified id or null - if there is no entity with the given id
     */
    @Override
    public Course findOne(Long id){
        for (Course course:courses) {
            if(course.getId()==id){
                return course;
            }
        }
        return null;
    }

    /**
     * @return all entities
     */
    @Override
    public Iterable<Course> findAll(){
        return courses;
    }

    /**
     * @param entity entity must be not null
     * @return null- if the given entity is saved otherwise returns the entity (id already exists)
     */
    @Override
    public Course save(Course entity){
        if(findOne(entity.getId())==null){
            courses.add(entity);
            return null;
        }
        return findOne(entity.getId());
    }

    /**
     * removes the entity with the specified id
     *
     * @param id id must be not null
     * @return the removed entity or null if there is no entity with the given id
     */
    @Override
    public Course delete(Long id){
        if(findOne(id)!=null){
            Course c = new Course();
            c = findOne(id);
            courses.remove(id);
            return c;
        }
        return null;
    }

    /**
     * @param entity entity must not be null
     * @return null - if the entity is updated, otherwise returns the entity - (e.g id does not exist).
     */
    @Override
    public Course update(Course entity){
        if(findOne(entity.getId())!=null){
            for (Course course : courses) {
                if(course.getId()==entity.getId()){
                    course.setName(entity.getName());
                    course.setMaxEnrollment(entity.getMaxEnrollment());
                    course.setCredits(entity.getCredits());
                    course.setTeacher(entity.getTeacher());
                    course.setStudentsEnrolled(entity.getStudentsEnrolled());
                }
                return null;
            }
        }
        return entity;
    }
}
