package com.hibernate.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.pojo.Account;
import com.hibernate.pojo.Category;
import com.hibernate.pojo.Product;
import com.hibernate.pojo.Student;
import com.hibernate.pojo.one2many.Customer;
import com.hibernate.pojo.one2many.Order;

import net.sf.ehcache.search.expression.Or;

public class Test {
	public static void main(String[] args) {
		// 创建configuration对象
		Configuration config = new Configuration()
				// 默认加载hibernate.cfg.xml文件
				.configure("hibernate.xml");
		// 创建表
		/*
		 * ServiceRegistry serviceRegistry = (ServiceRegistry) new
		 * StandardServiceRegistryBuilder().configure().build();
		 * MetadataImplementor metadataImplementor = (MetadataImplementor) new
		 * MetadataSources(serviceRegistry).buildMetadata(); SchemaExport export
		 * = new SchemaExport(serviceRegistry, metadataImplementor);
		 * export.create(true, true);
		 */
		// 创建session工厂
		SessionFactory factory = config.buildSessionFactory();
		// 打开session
		Session session = factory.openSession();
		// 事物管理
		Transaction tx = session.beginTransaction();

		/*
		 * Student student = new Student(); student.setAge(22); student.setName(
		 * "is me");
		 */

		
		/*Account account = new Account(); 
		account.setName("zeng");
		account.setAge(22);*/
		
		//查询数据，在这里account对象会缓存到session一级缓存中
		//在tx.commit()提交时，会把session缓存中的状态进行更新，然后清空缓存
		/*Student account = (Student) session.get(Student.class, 1);
		System.out.println(account);*/
		
		Customer customer = new Customer();
		customer.setName("custom");
		
		Order order = new Order();
		order.setOrderNumber("order1");
		
		/*
		Category category = new Category();
		category.setName("chanp");
		List<Product> list = new ArrayList<>();
		Product product = new Product();
		product.setName("pro");
		list.add(product);
		category.setProList(list);
		*/
		
		try {
			session.save(customer);
			session.save(order);
			long idOfCus = customer.getId();
			long idOfOr = order.getId();
			System.out.println(idOfCus+"------------------"+idOfOr);
			
			//customer和order关联
			customer = session.load(Customer.class, idOfCus);
			order = session.load(Order.class, idOfOr);
			order.setCustomer(customer);
			customer.getOrders().add(order);
			session.save(customer);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
			factory.close();
		}
	}
}
