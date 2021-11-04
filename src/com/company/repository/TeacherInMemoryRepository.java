package com.company.repository;



import com.company.model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherInMemoryRepository implements ICrudRepository<Teacher> {

    List<Teacher> teachers = new ArrayList<>();

    @Override
    public Teacher findOne(Long id) {
        for (Teacher teacher : teachers) {
            if (teacher.getId() == id) {
                return teacher;
            }
        }
        return null;
    }

    @Override
    public Iterable<Teacher> findAll() {
        return teachers;
    }

    @Override
    public Teacher save(Teacher entity) {
        if (findOne(entity.getId()) != null) {
            teachers.add(entity);
            return null;
        }
        return findOne(entity.getId());
    }

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
