package com.company.repository;



import com.company.model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherInMemoryRepository implements ICrudRepository<Teacher> {

    List<Teacher> teachers = new ArrayList<>();

    /**
     * @param id -the id of the entity to be returned id must not be null
     * @return the entity with the specified id or null - if there is no entity with the given id
     */
    @Override
    public Teacher findOne(Long id) {
        for (Teacher teacher : teachers) {
            if (teacher.getId() == id) {
                return teacher;
            }
        }
        return null;
    }

    /**
     * @return all entities
     */
    @Override
    public Iterable<Teacher> findAll() {
        return teachers;
    }

    /**
     * @param entity entity must be not null
     * @return null- if the given entity is saved otherwise returns the entity (id already exists)
     */
    @Override
    public Teacher save(Teacher entity) {
        if (findOne(entity.getId()) != null) {
            teachers.add(entity);
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
    public Teacher delete(Long id) {
        if (findOne(id) != null) {
            Teacher tea = new Teacher();
            tea = findOne(id);
            teachers.remove(id);
            return tea;
        }
        return null;
    }

    /**
     * @param entity entity must not be null
     * @return null - if the entity is updated, otherwise returns the entity - (e.g id does not exist).
     */
    @Override
    public Teacher update(Teacher entity) {
        if (findOne(entity.getId()) != null) {
            for (Teacher teacher : teachers) {
                if (teacher.getId()==entity.getId()) {
                    teacher.setFirstName(teacher.getLastName());
                    teacher.setLastName(teacher.getLastName());
                    teacher.setCourses(teacher.getCourses());
                }
                return null;
            }
        }
        return entity;
    }
}
