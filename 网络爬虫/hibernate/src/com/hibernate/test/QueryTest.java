package com.hibernate.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.sql.Delete;
import org.hibernate.sql.Update;
import org.junit.Test;

import com.hibernate.pojo.Student;

public class QueryTest {
	private static SessionFactory factory;
	static {
		Configuration configuration = new Configuration().configure("hibernate.xml");
		factory = configuration.buildSessionFactory();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void select() {
		Transaction tx = null;
		Session session = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			// 1.���Ҷ������
			// from�������ʵ��������ƣ�hibernate��Ĭ�ϰ����ǲ���ʵ�����Ӧ�ı����
			String hql = "from Student";
			Query query = session.createQuery(hql);
			List<Student> lists = (List<Student>) query.list();
			for (Student student : lists) {
				System.out.println(student);
			}

			// 2.�鵥������
			Student student = (Student) session.createQuery(hql).setMaxResults(1).uniqueResult();
			System.out.println(student);

			// 3.ͶӰ��ѯ,Student���࣬name��Student���е�������
			query = session.createQuery("select a.name from Student a");
			List<String> list = (List<String>) query.list();
			for (String student1 : list) {
				System.out.println(student1);
			}

			// 4.ʵ����ͶӰ��ѯ����Student�����ж�Ӧ�Ĺ��캯��Student(name,age)
			query = session.createQuery("select new Student(a.name,a.age) from Student a");
			lists = query.list();
			for (Student student1 : lists) {
				System.out.println(student1);
			}

			query = session.createQuery("from Student where id=1");
			lists = query.list();
			for (Student student1 : lists) {
				System.out.println(student1);
			}

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}

	}

	/*
	 * HQL��������
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void select2() {
		Transaction tx = null;
		Session session = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			// ��дupper()
			String hql = "select upper(name) from Student where id=1";
			Query query = session.createQuery(hql);
			List<String> lists = (List<String>) query.list();
			for (String student : lists) {
				System.out.println(student);
			}

			// Сдlower()
			query = session.createQuery("select lower(name) from Student where id=1");
			lists = query.list();
			for (String string : lists) {
				System.out.println(string);
			}

			// ��ȡ�ַ���
			query = session.createQuery("select substring(name,0,3) from Student where id=1");
			lists = query.list();
			for (String string : lists) {
				System.out.println(string);
			}

			// �ַ�������
			query = session.createQuery("select length(name) from Student where id=1");
			List<Integer> len = (List<Integer>) query.list();
			for (Integer string : len) {
				System.out.println(string);
			}

			// �ַ�������
			query = session.createQuery("select concat(name,'nihao') from Student where id=1");
			lists = query.list();
			for (String string : lists) {
				System.out.println(string);
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}

	/*
	 * ռλ�����趨
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void select3() {
		Transaction tx = null;
		Session session = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			// ����ռλ��
			String hql = "select upper(name) from Student where id=? and name=?";
			Query query = session.createQuery(hql);
			// �󶨵�һ��ռλ��
			query.setInteger(0, 1);
			// �󶨵ڶ���ռλ��
			query.setString(1, "is me");
			List<String> lists = (List<String>) query.list();
			for (String student : lists) {
				System.out.println(student);
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}

	/*
	 * ͨ����������
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void select4() {
		Transaction tx = null;
		Session session = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			// ������:no :name
			String hql = "select upper(name) from Student where id=:no and name=:name";
			Query query = session.createQuery(hql);
			// �󶨵�һ����������
			query.setInteger("no", 1);
			// �󶨵ڶ�����������
			query.setString("name", "is me");
			List<String> lists = (List<String>) query.list();
			for (String student : lists) {
				System.out.println(student);
			}

			// distinctȥ���ظ�
			query = session.createQuery("select distinct name from Student");
			lists = query.list();
			for (String string : lists) {
				System.out.println(string);
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}

	/*
	 * ��ҳ��ѯ
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void select5() {
		Transaction tx = null;
		Session session = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			String hql = "select upper(name) from Student";
			int page = 3;
			int pageFirst = 1;
			// setFirstResult()����ÿһҳ�ĵ�һ�����ݵ�λ�ã�setMaxResults(3)ÿһҳ��������
			Query query = session.createQuery(hql).setFirstResult((pageFirst - 1) * page).setMaxResults(page);
			List<String> lists = (List<String>) query.list();
			for (String student : lists) {
				System.out.println(student);
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}

	/*
	 * ɾ��
	 */
	@Test
	public void select6() {
		Session session = null;
		Transaction tx = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			String hql = "delete from Student where id=:id";
			Query query = session.createQuery(hql);
			query.setInteger("id", 1);
			int i = query.executeUpdate();
			System.out.println(i);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void select7() {
		Session session = null;
		Transaction tx = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			String hql = "update Student set name=:name where id=:id";
			Query query = session.createQuery(hql);
			query.setString("name", "world");
			query.setInteger("id", 5);
			int i = query.executeUpdate();
			if (i > 0) {
				query = session.createQuery("select name from Student");
				List<String> list = query.list();
				for (String string : list) {
					System.out.println(string);
				}
			} else {
				System.out.println("����ʧ��");
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}

	/*
	 * ������ѯ
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void select8() {
		Session session = null;
		Transaction tx = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			// Student.xml�е�������ѯ������:allHql
			Query query = session.getNamedQuery("allHql");
			List<String> list = query.list();
			for (String string : list) {
				System.out.println(string);
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}

	@Test
	public void select9() {
		Session session = null;
		Transaction tx = null;
		Student student = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			student = (Student) session.load(Student.class, 21);
			System.out.println(student.getId());
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
	}

	@Test
	public void save1() {
		Session session = null;
		Transaction tx = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Student student = new Student();
			student.setName(".net");
			student.setAge(12);
			session.save(student);
			student.setAge(20);

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}

	@Test
	public void delete() {
		Session session = null;
		Transaction tx = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Student student = session.get(Student.class, 45);
			session.delete(student);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}

	@Test
	public void update() {
		Session session = null;
		Transaction tx = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Student student = session.get(Student.class, 41);
			student.setName("c++");
			//���ݲ����ж��Ǹ��»����޸�
			session.merge(student);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}

	@Test
	public void test() {
		String a1 = "hello";
		String a2 = "o";
		String a3 = "hell" + "o";
		String a4 = "hell";
		String a5 = a2 + a4;
		String a6 = "���";
		String a7 = "���";
		String a8 = new String("hello");
		System.out.println(a1 == a3);
		System.out.println(a1 == a5);
		System.out.println(a6 == a7);
		System.out.println(a1 == a8);
	}

}
