package pl.edu.agh.school.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.school.dao.TeacherDAO;
import pl.edu.agh.school.models.Class;
import pl.edu.agh.school.models.Teacher;

public class TeacherDAOImpl implements TeacherDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public void saveTeacher(Teacher teacher) {
		Session session = sessionFactory.getCurrentSession();
		session.save(teacher);
	}

	@Transactional
	public List<Teacher> findAll() {
		System.out.println("findall");
			Session session = sessionFactory.getCurrentSession();
			System.out.println(session);
			List teachers = session.createQuery("from Teacher").list();
			System.out.println("findallend");
			return teachers;
	}

}