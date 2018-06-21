package com.briup.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.briup.Impl.CatalogImpl;
import com.briup.bean.Catalog;
import com.briup.bean.CatalogDetail;

public class CatalogDao implements CatalogImpl {
	private static Connection conn;
	private Catalog catalog;
	private CatalogDetail detail;
	static {
		conn = ConnectionFactory.getConnection();
	}

	@Override
	public Catalog findAllCatalog() {
		List<String> lists = new ArrayList<String>();
		if (catalog == null) {
			catalog = new Catalog();
		}
		try {
			Statement statement = conn.createStatement();
			String sql = "select name from d_catalog";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				lists.add(rs.getString("name"));
			}
			catalog.setCatalogs(lists);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return catalog;
	}

	@Override
	public List<CatalogDetail> findCatalogDetailByName(String name) {
		List<CatalogDetail> lists = new ArrayList<CatalogDetail>();
		try {
			Statement statement = conn.createStatement();
			String sql = "select * from d_catalog_detail where catalog_id=("
					+ "select id from d_catalog where name='" + name + "')";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				detail = new CatalogDetail();
				detail.setId(rs.getInt("id"));
				detail.setName(rs.getString("name"));
				detail.setCatalog_id(rs.getInt("catalog_id"));
				lists.add(detail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lists;
	}

	@Override
	public String findCatalogNameByDetailId(int id) {
		String catalog = null;
		try {
			Statement statement = conn.createStatement();
			String sql = "select name from d_catalog where id=(select catalog_id from d_catalog_detail where id='"+id+"')";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				catalog = rs.getString("name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return catalog;
	}

}
