package org.itstep.j2_16;

import java.util.Arrays;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.itstep.j2_16.config.HibernateConfig;
import org.itstep.j2_16.dao.StudentDao;
import org.itstep.j2_16.dao.StudentDaoUniversal;
import org.itstep.j2_16.entity.Passport;
import org.itstep.j2_16.entity.Student;
import org.itstep.j2_16.service.StudentService;
import org.itstep.j2_16.service.StudentServiceUniversal;
import org.itstep.j2_16.util.HrDepartment;

import static java.lang.System.getProperty;
import static org.apache.commons.lang3.StringUtils.isEmpty;
import static org.apache.commons.lang3.StringUtils.join;
import static org.apache.commons.lang3.SystemUtils.LINE_SEPARATOR;

public class AppUniversal {

    public static void main( String[] args ) {
        System.out.println("== START ==");

        List<Student> studentsForSaving = Arrays.asList(
                new Student("Oleh", "Pinta", new Passport("MC", "723901")),
                new Student("Alex", "Kochetyga", new Passport("MC", "723902")),
                new Student("Igor", "Demennikov", new Passport("MC", "723903")));

        // define hibernate config to use
        SessionFactory sessionFactory;
        String is_xml = getProperty("is_xml");
        if (isEmpty(is_xml) || is_xml.equals("false")) {
            sessionFactory = HibernateConfig.getSessionFactory();
            System.out.println("-- run NO xml --");
        } else {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            System.out.println("-- run xml --");
        }

        // initialization process
        StudentDao studentDao = new StudentDaoUniversal(sessionFactory);
        StudentService studentService = new StudentServiceUniversal(studentDao);
        HrDepartment hrDepartment = new HrDepartment(studentService);

        // save students
        studentsForSaving.forEach(hrDepartment::saveStudent);

        // get all students
        List<Student> students = hrDepartment.getAllStudents();
        System.out.println(join(students, LINE_SEPARATOR));

        System.out.println("== END ==");
    }
}
