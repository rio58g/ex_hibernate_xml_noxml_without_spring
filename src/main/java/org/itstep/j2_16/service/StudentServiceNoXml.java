package org.itstep.j2_16.service;

import java.util.List;
import org.itstep.j2_16.dao.StudentDaoNoXml;
import org.itstep.j2_16.entity.Student;

public class StudentServiceNoXml implements StudentService {
    StudentDaoNoXml studentDaoNoXml = new StudentDaoNoXml();

    @Override
    public List<Student> getAll() {
        return studentDaoNoXml.getAll();
    }
}
