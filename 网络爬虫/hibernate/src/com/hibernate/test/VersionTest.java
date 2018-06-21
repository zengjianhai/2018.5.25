package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.hibernate.pojo.Person;

/**
 * read commited+¿÷π€À¯
 * @author xunfeng
 *
 */
public class VersionTest {
	private static Configuration config = null;
	private static SessionFactory factory = null;
	static {
		config = new Configuration().configure("hibernate.xml");
		factory = config.buildSessionFactory();
	}

	@Test
	public void testInsert() {
		Session session = null;
		Transaction tx = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			for (int i = 0; i < 100; i++) {
				Person person = new Person();
				person.setName("tom"+i);
				person.setAge(i);
				if(i%20==0){
					session.flush();
					session.clear();
				}
				session.save(person);
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}
	
	@Test
	public void testQuery() {
		Session session = null;
		Transaction tx = null;
		Session session2 = null;
		Transaction tx2 = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
//			String hql = "from Person";
//			Query query = session.createQuery(hql);
//			List<Person> list = query.list();
//			for (Person person : list) {
//				System.out.println(person);
//			}
			
			Person person = session.get(Person.class, 61);
			
			session2 = factory.openSession();
			tx2 = session2.beginTransaction();
			Person person2 = session2.get(Person.class, 61);
			person2.setName("php");
			System.out.println(person2);
			tx2.commit();
			
			person.setName("java");
			System.out.println(person);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			tx2.rollback();
		}
	}

}
