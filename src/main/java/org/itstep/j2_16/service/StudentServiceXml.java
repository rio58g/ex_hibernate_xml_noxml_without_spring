package org.itstep.j2_16.service;

import java.util.List;
import org.itstep.j2_16.dao.StudentDaoXml;
import org.itstep.j2_16.entity.Student;

public class StudentServiceXml implements StudentService {
    StudentDaoXml studentDaoXml = new StudentDaoXml();

    @Override
    public List<Student> getAll() {
        return studentDaoXml.getAll();
    }
}
