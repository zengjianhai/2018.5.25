package com.hibernate.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.hibernate.pojo.Student;

/**
 * 二级缓存查询
 * @author xunfeng
 *
 */
public class StudentCacheTest {
	private static SessionFactory factory;
	static {
		Configuration configuration = new Configuration().configure("hibernate.xml");
		factory = configuration.buildSessionFactory();
	}

	@Test
	public void select() {
		Transaction tx = null;
		Session session = null;
		Transaction tx2 = null;
		Session session2 = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Student student = session.get(Student.class, 4);
			System.out.println(student);
			tx.commit();
			session.close();
			
			session2 = factory.openSession();
			tx2 = session2.beginTransaction();
			Student student2 = session2.get(Student.class, 4);
			System.out.println(student2);
			tx2.commit();
			session2.close();
		} catch (Exception e) {
			tx.rollback();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void select2() {
		Transaction tx = null;
		Session session = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			String hql = "from Student where name=:name";
			Query query = session.createQuery(hql);
			query.setString("name", "my");
			//启用查询缓存
			query.setCacheable(true);
			//指定自定义的查询缓存
			query.setCacheRegion("myCacheRegion");
			List<Student> student = query.list();
			for (Student student2 : student) {
				System.out.println(student2);
			}
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
		}
	}

}


