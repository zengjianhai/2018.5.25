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
		// ����configuration����
		Configuration config = new Configuration()
				// Ĭ�ϼ���hibernate.cfg.xml�ļ�
				.configure("hibernate.xml");
		// ������
		/*
		 * ServiceRegistry serviceRegistry = (ServiceRegistry) new
		 * StandardServiceRegistryBuilder().configure().build();
		 * MetadataImplementor metadataImplementor = (MetadataImplementor) new
		 * MetadataSources(serviceRegistry).buildMetadata(); SchemaExport export
		 * = new SchemaExport(serviceRegistry, metadataImplementor);
		 * export.create(true, true);
		 */
		// ����session����
		SessionFactory factory = config.buildSessionFactory();
		// ��session
		Session session = factory.openSession();
		// �������
		Transaction tx = session.beginTransaction();

		/*
		 * Student student = new Student(); student.setAge(22); student.setName(
		 * "is me");
		 */

		
		/*Account account = new Account(); 
		account.setName("zeng");
		account.setAge(22);*/
		
		//��ѯ���ݣ�������account����Ỻ�浽sessionһ��������
		//��tx.commit()�ύʱ�����session�����е�״̬���и��£�Ȼ����ջ���
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
			
			//customer��order����
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
