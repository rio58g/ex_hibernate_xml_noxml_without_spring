package org.itstep.j2_16;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.function.Consumer;
import org.apache.commons.lang3.StringUtils;
import org.itstep.j2_16.entity.Student;
import org.itstep.j2_16.service.StudentService;
import org.itstep.j2_16.service.StudentServiceNoXml;
import org.itstep.j2_16.service.StudentServiceXml;
import org.itstep.j2_16.util.HrDepartment;

import static java.util.Arrays.stream;
import static org.apache.commons.lang3.StringUtils.isEmpty;

public class App {

    public static void main( String[] args ) {
        System.out.println("== START ==");

        System.out.println("-- Program arguments: -");

        // creating anonimous class implementing Consumer interface without using keyword 'implement'
        Consumer<String> stringConsumer_1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("v_1: " + s);
            }
        };
        stream(args).forEach(stringConsumer_1);

        Consumer<String> stringConsumer_2 = (s) -> {
            // some comment
            System.out.println("v_2: " + s);
        };
        stream(args).forEach(stringConsumer_2);

        stream(args).forEach(arg -> {
            System.out.println("v_3: " + arg);
        });

        System.out.println("-- JVM arguments --");
        Properties properties = System.getProperties();
        properties.forEach((key, value) -> {
            System.out.println("" + key + ": " + value);
        });

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
