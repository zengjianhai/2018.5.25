package com.briup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.briup.Impl.AddImpl;
import com.briup.bean.Consignee;
import com.briup.bean.Order;
import com.briup.bean.ShopCar;

public class AddDao implements AddImpl {
	private static Connection conn;
	static {
		conn = ConnectionFactory.getConnection();
	}

	@Override
	public void addShopCar(ShopCar shopCar) {
		PreparedStatement ps;
		try {
			String sql = "insert into d_shopcar(id,amount,user_id) values(?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, shopCar.getId());
			ps.setInt(2, shopCar.getCount());
			ps.setInt(3, shopCar.getUser_id());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int findShopCarByUserIdAndProId(int userId, int proId) {
		int flag = 0;
		try {
			Statement statement = conn.createStatement();
			String sql1 = "select * from d_shopcar where user_id='" + userId + "' and id='" + proId + "'";
			ResultSet rs1 = statement.executeQuery(sql1);
			while (rs1.next()) {
				flag = rs1.getInt("amount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public void updataShopCar(int count, int userId, int proId) {
		PreparedStatement ps;
		try {
			String sql = "update d_shopcar set amount='" + count + "' where id='" + proId + "' and " + "user_id='"
					+ userId + "'";
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addConsignee(Consignee consignee) {
		PreparedStatement ps;
		try {
			String sql = "insert into d_consignee values(my_consignee.nextval,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, consignee.getName());
			ps.setString(2, consignee.getPhone());
			ps.setString(3, consignee.getAddress());
			ps.setInt(4, consignee.getUser_id());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addOrder(Order order) {
		PreparedStatement ps;
		try {
			String sql = "insert into d_order(id,product_id,amount,user_id,consignee_id) values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, order.getId());
			ps.setInt(2, order.getProduct_id());
			ps.setInt(3, order.getAmount());
			ps.setInt(4, order.getUser_id());
			ps.setInt(5, order.getConsignee_id());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
