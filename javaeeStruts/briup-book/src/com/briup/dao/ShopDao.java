package com.briup.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.briup.Impl.ShopImpl;
import com.briup.bean.Product;
import com.briup.bean.ShopProduct;
import com.briup.bean.User;

public class ShopDao implements ShopImpl {
	List<ShopProduct> lists;
	private Product product;
	ShopProduct shopProduct;
	UserDao dao;
	private static Connection conn;
	static {
		conn = ConnectionFactory.getConnection();
	}

	@Override
	public List<ShopProduct> findShopByUserName(User user) {
		if (dao == null) {
			dao = new UserDao();
		}
		lists = null;
		lists = new ArrayList<ShopProduct>();
		int user_id = dao.findUserIdByName(user.getName());
		try {
			Statement statement = conn.createStatement();
			Statement statement1 = conn.createStatement();
			String sql1 = "select id,amount from d_shopcar where user_id='" + user_id + "'";
			ResultSet rs1 = statement.executeQuery(sql1);
			while (rs1.next()) {
				shopProduct = new ShopProduct();
				shopProduct.setAmount(rs1.getInt("amount"));
				int id = rs1.getInt("id");
				String sql = "select * from d_product where id='" + id + "'";
				ResultSet rs = statement1.executeQuery(sql);
				rs = statement1.executeQuery(sql);
				while (rs.next()) {
					product = new Product();
					product.setId(rs.getInt("id"));
					product.setName(rs.getString("name"));
					product.setCatalog_detail_id(rs.getInt("catalog_detail_id"));
					product.setPrice(rs.getInt("price"));
					product.setService(rs.getString("service"));
					product.setImg(rs.getString("img"));
					product.setVersion(rs.getString("version"));
					product.setAmount(rs.getInt("amount"));
					product.setHappy_price(rs.getInt("happy_price"));
					product.setEvaluate_id(rs.getInt("evaluate_id"));
					product.setSpecification_id(rs.getInt("specification_id"));
					product.setMerchant_id(rs.getInt("merchant_id"));
					product.setIntroduction(rs.getString("introduction"));
					product.setPublish(rs.getString("publish"));
					product.setAuthor(rs.getString("author"));
					product.setTime(rs.getTime("time"));
					System.out.println(id + "-----------------" + product);
					shopProduct.setProduct(product);
				}
				System.err.println("---------------==========" + shopProduct.getAmount());
				shopProduct.setUser(user);
				lists.add(shopProduct);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lists;
	}

	@Override
	public String findMerchantById(int id) {
		return null;
	}

	@Override
	public List<ShopProduct> findShopByGether(String pros, String amounts) {
		lists = null;
		lists = new ArrayList<ShopProduct>();
		String[] pro_id = pros.split("[|]");
		String[] amount = amounts.split("[|]");
		try {
			Statement statement1 = conn.createStatement();
			for (int i = 0; i < pro_id.length; i++) {
				System.out.println(pro_id[i].trim());
				shopProduct = new ShopProduct();
				int id=Integer.parseInt(pro_id[i].trim());
				shopProduct.setAmount(Integer.parseInt(amount[i].trim()));
				String sql = "select * from d_product where id='" + id + "'";
				ResultSet rs = statement1.executeQuery(sql);
				rs = statement1.executeQuery(sql);
				while (rs.next()) {
					product = new Product();
					product.setId(rs.getInt("id"));
					product.setName(rs.getString("name"));
					product.setCatalog_detail_id(rs.getInt("catalog_detail_id"));
					product.setPrice(rs.getInt("price"));
					product.setService(rs.getString("service"));
					product.setImg(rs.getString("img"));
					product.setVersion(rs.getString("version"));
					product.setAmount(rs.getInt("amount"));
					product.setHappy_price(rs.getInt("happy_price"));
					product.setEvaluate_id(rs.getInt("evaluate_id"));
					product.setSpecification_id(rs.getInt("specification_id"));
					product.setMerchant_id(rs.getInt("merchant_id"));
					product.setIntroduction(rs.getString("introduction"));
					product.setPublish(rs.getString("publish"));
					product.setAuthor(rs.getString("author"));
					product.setTime(rs.getTime("time"));
					System.out.println(id + "-----------------" + product);
					shopProduct.setProduct(product);
				}
				lists.add(shopProduct);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lists;
	}

}
