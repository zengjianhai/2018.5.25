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
			// 1.查找多个数据
			// from后跟的是实体类的名称，hibernate会默认帮我们查找实体类对应的表对象
			String hql = "from Student";
			Query query = session.createQuery(hql);
			List<Student> lists = (List<Student>) query.list();
			for (Student student : lists) {
				System.out.println(student);
			}

			// 2.查单个数据
			Student student = (Student) session.createQuery(hql).setMaxResults(1).uniqueResult();
			System.out.println(student);

			// 3.投影查询,Student是类，name是Student类中的属性名
			query = session.createQuery("select a.name from Student a");
			List<String> list = (List<String>) query.list();
			for (String student1 : list) {
				System.out.println(student1);
			}

			// 4.实例化投影查询，在Student类中有对应的构造函数Student(name,age)
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
	 * HQL常见函数
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void select2() {
		Transaction tx = null;
		Session session = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			// 大写upper()
			String hql = "select upper(name) from Student where id=1";
			Query query = session.createQuery(hql);
			List<String> lists = (List<String>) query.list();
			for (String student : lists) {
				System.out.println(student);
			}

			// 小写lower()
			query = session.createQuery("select lower(name) from Student where id=1");
			lists = query.list();
			for (String string : lists) {
				System.out.println(string);
			}

			// 截取字符串
			query = session.createQuery("select substring(name,0,3) from Student where id=1");
			lists = query.list();
			for (String string : lists) {
				System.out.println(string);
			}

			// 字符串长度
			query = session.createQuery("select length(name) from Student where id=1");
			List<Integer> len = (List<Integer>) query.list();
			for (Integer string : len) {
				System.out.println(string);
			}

			// 字符串连接
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
	 * 占位符的设定
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void select3() {
		Transaction tx = null;
		Session session = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			// ？号占位符
			String hql = "select upper(name) from Student where id=? and name=?";
			Query query = session.createQuery(hql);
			// 绑定第一个占位符
			query.setInteger(0, 1);
			// 绑定第二个占位符
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
	 * 通过参数名称
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void select4() {
		Transaction tx = null;
		Session session = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			// 参数绑定:no :name
			String hql = "select upper(name) from Student where id=:no and name=:name";
			Query query = session.createQuery(hql);
			// 绑定第一个参数名称
			query.setInteger("no", 1);
			// 绑定第二个参数名称
			query.setString("name", "is me");
			List<String> lists = (List<String>) query.list();
			for (String student : lists) {
				System.out.println(student);
			}

			// distinct去掉重复
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
	 * 分页查询
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
			// setFirstResult()设置每一页的第一条数据的位置，setMaxResults(3)每一页三条数据
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
	 * 删除
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
				System.out.println("更新失败");
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}

	/*
	 * 命名查询
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void select8() {
		Session session = null;
		Transaction tx = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			// Student.xml中的命名查询的命名:allHql
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
			//根据操作判断是更新还是修改
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
		String a6 = "你好";
		String a7 = "你好";
		String a8 = new String("hello");
		System.out.println(a1 == a3);
		System.out.println(a1 == a5);
		System.out.println(a6 == a7);
		System.out.println(a1 == a8);
	}

}
