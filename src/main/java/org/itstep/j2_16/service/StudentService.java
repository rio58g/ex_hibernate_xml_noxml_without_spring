package org.itstep.j2_16.service;

import java.util.List;
import org.itstep.j2_16.dao.StudentDao;
import org.itstep.j2_16.entity.Student;

public class StudentService {
    StudentDao studentDao = new StudentDao();

    public List<Student> getAll() {
        return studentDao.getAll();
    }
}
