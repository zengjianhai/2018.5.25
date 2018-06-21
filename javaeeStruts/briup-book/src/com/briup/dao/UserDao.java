package com.briup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.briup.Impl.UserImpl;
import com.briup.bean.User;

public class UserDao implements UserImpl {
	private static Connection conn;
	static {
		conn = ConnectionFactory.getConnection();
	}

	@Override
	public void addUser(User user) {
		PreparedStatement ps;
		try {
			String sql = "insert into d_user values(my_d_user.nextval,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPass());
			ps.setString(3, user.getAddress());
			ps.setString(4, user.getPhone());
			ps.setString(5, user.getEmail());
			ps.setInt(6, Integer.valueOf(user.getPostcode()));
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean findUserByName(String name) {
		boolean flag = false;
		try {
			Statement statement = conn.createStatement();
			String sql = "select * from d_user where name='" + name + "'";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public User findUserByNameAndPwd(String name, String pass) {
		User user = null;
		try {
			user = new User();
			Statement statement = conn.createStatement();
			String sql = "select * from d_user where name='" + name + "' and pass='" + pass + "'";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				user.setName(name);
				user.setPass(pass);
				user.setAddress(rs.getString("address"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setPostcode(String.valueOf(rs.getInt("postcode")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int findUserIdByName(String name) {
		int id = 0;
		try {
			Statement statement = conn.createStatement();
			String sql = "select id from d_user where name='" + name + "'";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				id = rs.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public void updateUser(User user) {
		PreparedStatement ps;
		try {
			String sql = "update d_user set pass='" + user.getPass() + "',address='" + user.getAddress() + "',"
					+ "phone='" + user.getPhone() + "',email='" + user.getEmail() + "'," + "postcode='"
					+ user.getPostcode() + "' where name='" + user.getName() + "'";
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
