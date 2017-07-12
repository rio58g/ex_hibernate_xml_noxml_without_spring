package org.itstep.j2_16.util;

import java.util.List;
import org.itstep.j2_16.entity.Student;
import org.itstep.j2_16.service.StudentService;

public class HrDepartment {

    public List<Student> getAllStudents(StudentService studentService) {
        return studentService.getAll();
    }
}
