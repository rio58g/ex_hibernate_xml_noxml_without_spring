package org.itstep.j2_16;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.itstep.j2_16.entity.Student;
import org.itstep.j2_16.service.StudentService;
import org.itstep.j2_16.service.StudentServiceNoXml;
import org.itstep.j2_16.service.StudentServiceXml;
import org.itstep.j2_16.util.HrDepartment;

import static org.apache.commons.lang3.StringUtils.isEmpty;

public class App {

    public static void main( String[] args ) {
        System.out.println("== START ==");

        StudentService studentService;
        String is_xml = System.getProperty("is_xml");
        if (isEmpty(is_xml) || is_xml.equals("false")) {
            studentService = new StudentServiceNoXml();
            System.out.println("-- run NO xml --");
        } else {
            studentService = new StudentServiceXml();
            System.out.println("-- run xml --");
        }

        HrDepartment hrDepartment = new HrDepartment();
        List<Student> students = hrDepartment.getAllStudents(studentService);
        System.out.println("Students got: " + students.size());

        System.out.println("== END ==");
    }
}
