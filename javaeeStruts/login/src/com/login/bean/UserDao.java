package com.login.bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public boolean findUserByName(String name, String passwd) throws SQLException {
		boolean flag = false;
		Connection conn = null;
		conn = dataSource.getConnection();
		try {
			Statement statement = conn.createStatement();
			String sql = "select * from t_users where name='" + name + "' and passwd='" + passwd + "'";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
}
