package com.briup.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.briup.Impl.PublishImpl;
import com.briup.bean.Publish;

public class PublishDao implements PublishImpl {
	private static Connection conn;
	private Publish publish;
	static {
		conn = ConnectionFactory.getConnection();
	}

	@Override
	public List<Publish> findAllPublish() {
		List<Publish> lists = new ArrayList<Publish>();
		try {
			Statement statement = conn.createStatement();
			String sql = "select * from d_publish";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				publish = new Publish();
				publish.setId(rs.getInt("id"));
				publish.setName(rs.getString("name"));
				lists.add(publish);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lists;
	}

}
