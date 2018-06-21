package com.briup.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.briup.Impl.FindImpl;
import com.briup.bean.Consignee;

public class FindDao implements FindImpl {
	private static Connection conn;
	static {
		conn = ConnectionFactory.getConnection();
	}


	@Override
	public int findConsigneeId(Consignee consignee) {
		int flag = 0;
		try {
			Statement statement = conn.createStatement();
			String sql1 = "select id from d_consignee where name='" + consignee.getName() + "' and phone="
					+ "'" + consignee.getPhone() + "' and address='"+consignee.getAddress()+"' and user_id='"+consignee.getUser_id()+"'";
			ResultSet rs1 = statement.executeQuery(sql1);
			while (rs1.next()) {
				flag = rs1.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}


}
