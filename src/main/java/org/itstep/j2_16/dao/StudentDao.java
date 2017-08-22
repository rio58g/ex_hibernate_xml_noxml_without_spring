package org.itstep.j2_16.dao;

import java.util.List;
import org.itstep.j2_16.entity.Student;
// test Bemrut frome home PC
public interface StudentDao {

    List<Student> getAll();

    Student save(Student student);
}
