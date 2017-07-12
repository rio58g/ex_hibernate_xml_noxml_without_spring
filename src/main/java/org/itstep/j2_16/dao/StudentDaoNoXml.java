package org.itstep.j2_16.dao;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.itstep.j2_16.HibernateUtil;
import org.itstep.j2_16.entity.Student;

public class StudentDaoNoXml {

    public List<Student> getAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Student> query = builder.createQuery(Student.class);
        Root<Student> variableRoot = query.from(Student.class);
        query.select(variableRoot);
        List<Student> students = session.createQuery(query).getResultList();

        session.getTransaction().commit();
        session.close();

        HibernateUtil.shutdown();

        return students;
    }
}
