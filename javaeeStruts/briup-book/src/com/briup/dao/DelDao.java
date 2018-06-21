package com.briup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.briup.Impl.DelImpl;

public class DelDao implements DelImpl{
	private static Connection conn;
	static {
		conn = ConnectionFactory.getConnection();
	}
	@Override
	public void delShopcarByProIdAndUserId(int proId, int userId) {
		PreparedStatement ps;
		try {
			String sql = "delete from d_shopcar where id='"+proId+"' and user_id='"+userId+"'";
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

}
