package org.itstep.j2_16;

import java.util.List;
import org.itstep.j2_16.entity.Student;
import org.itstep.j2_16.service.StudentService;

public class App {

    public static void main( String[] args ) {
        System.out.println("== START ==");

        StudentService studentService = new StudentService();
        List<Student> students = studentService.getAll();
        System.out.println("Students got: " + students.size());

        System.out.println("== END ==");
    }
}
