package com.briup.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class UserDao {
	private DriverManagerDataSource dataSource;

	public DriverManagerDataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DriverManagerDataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void findUserByName(String name) throws SQLException {
		Connection conn = null;
		conn = dataSource.getConnection();
		try {
			Statement statement = conn.createStatement();
			String sql = "select * from d_user where name='" + name + "'";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString("address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws SQLException {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao dao = ac.getBean("userDao",UserDao.class);
		dao.findUserByName("Ôø½¨º£");
	}
}
