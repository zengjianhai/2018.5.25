package com.briup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.briup.Impl.ProductImpl;
import com.briup.bean.Product;

public class ProductDao implements ProductImpl {
	private static Connection conn;
	private Product product;
	static {
		conn = ConnectionFactory.getConnection();
	}

	@Override
	public List<Product> findProductByCatalogId(String name) {
		List<Product> lists = new ArrayList<Product>();
		try {
			Statement statement = conn.createStatement();
			String sql = "select * from d_product where catalog_detail_id=("
					+ "select id from d_catalog_detail where name='" + name + "')";
			ResultSet rs = statement.executeQuery(sql);
			lists = init(rs, lists);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lists;
	}

	@Override
	public Product findProductById(int id) {
		try {
			Statement statement = conn.createStatement();
			String sql = "select * from d_product where id='" + id + "'";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				product = new Product();
				product = setProduct(rs, product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public String findCatalogDetailNameById(int id) {
		String detail = null;
		try {
			Statement statement = conn.createStatement();
			String sql = "select name from d_catalog_detail where id='" + id + "'";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				detail = rs.getString("name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return detail;
	}

	@Override
	public List<Product> findProductByCatalogName(String name) {
		List<Product> lists = new ArrayList<Product>();
		List<Integer> idLists = new ArrayList<Integer>();
		try {
			Statement statement = conn.createStatement();
			String catalog_detail_idSql = "select id from d_catalog_detail where catalog_id=(select id from d_catalog where name='"
					+ name + "')";
			ResultSet rsC = statement.executeQuery(catalog_detail_idSql);
			while (rsC.next()) {
				idLists.add(rsC.getInt("id"));
			}
			for (Integer integer : idLists) {
				String sql = "select * from d_product where catalog_detail_id='" + integer + "'";
				ResultSet rs = statement.executeQuery(sql);
				rs = statement.executeQuery(sql);
				lists = init(rs, lists);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lists;
	}

	@Override
	public void updateProduct(int id, int amount) {
		Product product = findProductById(id);
		PreparedStatement ps;
		try {
			String sql = "update d_product set amount='" + (product.getAmount() - amount) + "' where id='" + id + "'";
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Product> findProductBySearch(String target) {
		List<Product> lists = new ArrayList<Product>();
		try {
			Statement statement = conn.createStatement();
			String sql = "select * from d_product where name like '%" + target + "%'";
			ResultSet rs = statement.executeQuery(sql);
			lists = init(rs, lists);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lists;
	}

	@Override
	public List<Product> findAllProduct() {
		List<Product> lists = new ArrayList<Product>();
		try {
			Statement statement = conn.createStatement();
			String sql = "select * from d_product";
			ResultSet rs = statement.executeQuery(sql);
			lists = init(rs, lists);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lists;
	}

	@Override
	public List<Product> sellerProduct(int count) {
		List<Product> lists = new ArrayList<Product>();
		List<Integer> ids = new ArrayList<Integer>();
		int i = 1;
		try {
			Statement statement = conn.createStatement();
			String sql1 = "select sum(amount),product_id from d_order "
					+ "group by product_id order by sum(amount) desc";
			ResultSet rs1 = statement.executeQuery(sql1);

			while (rs1.next()) {
				if (count < i) {
					break;
				}
				ids.add(rs1.getInt("product_id"));
				i++;
			}
			for (Integer integer : ids) {
				String sql = "select * from d_product where id='" + integer + "'";
				ResultSet rs = statement.executeQuery(sql);
				rs = statement.executeQuery(sql);
				lists = init(rs, lists);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lists;
	}

	@Override
	public List<Product> findProductByPublish(String publishName, String catalog, String detail) {
		List<Product> lists = new ArrayList<Product>();
		try {
			Statement statement = conn.createStatement();
			String sql = null;
			if (!"".equals(detail) && detail != null) {
				sql = "select * from d_product where publish='" + publishName
						+ "' and catalog_detail_id in(select id from d_catalog_detail where name='" + detail + "')";
			} else if (!"".equals(catalog) && catalog != null) {
				sql = "select * from d_product where publish='" + publishName
						+ "' and catalog_detail_id in(select id from d_catalog_detail where catalog_id=(select id from d_catalog where name='"
						+ catalog + "'))";
			} else {
				sql = "select * from d_product where publish='" + publishName + "'";
			}

			ResultSet rs = statement.executeQuery(sql);
			lists = init(rs, lists);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lists;
	}

	@Override
	public List<Product> findProductByOther(String catalog, String detail) {
		List<Product> lists = new ArrayList<Product>();
		try {
			Statement statement = conn.createStatement();
			String sql = null;
			if (!"".equals(detail) && detail != null) {
				sql = "select * from d_product where publish not in"
						+ "(select name from d_publish) and catalog_detail_id in(select id from d_catalog_detail where name='"
						+ detail + "')";
			} else if (!"".equals(catalog) && catalog != null) {
				sql = "select * from d_product where publish not in"
						+ "(select name from d_publish) and catalog_detail_id in(select id from d_catalog_detail where catalog_id=(select id from d_catalog where name='"
						+ catalog + "'))";
			} else {
				sql = "select * from d_product where publish not in" + "(select name from d_publish)";
			}
			ResultSet rs = statement.executeQuery(sql);
			lists = init(rs, lists);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lists;
	}
	/**
	 * 设置product的值
	 * @param rs
	 * @param product
	 * @return
	 */
	public Product setProduct(ResultSet rs, Product product) {
		System.err.println("this is setProduct");
		try {
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}
	/**
	 * 得到product产品集合
	 * @param rs
	 * @param lists
	 * @return
	 */
	public List<Product> init(ResultSet rs, List<Product> lists) {
		System.err.println("this is init()");
		try {
			while (rs.next()) {
				product = new Product();
				product = setProduct(rs, product);
				lists.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lists;
	}

	@Override
	public List<Product> findProductByPrice(String price, String catalog, String detail) {
		List<Product> lists = new ArrayList<Product>();
		try {
			Statement statement = conn.createStatement();
			String sql = null;
			String[] value = price.split("-");
			if (!"".equals(detail) && detail != null) {
				if (price.indexOf("-") > 0) {

					sql = "select * from d_product where price>=" + value[0] + " and price<=" + value[1]
							+ " and catalog_detail_id in(select id from d_catalog_detail where name='" + detail + "')";
				} else {
					sql = "select * from d_product where price>2000 and catalog_detail_id in(select id from d_catalog_detail where name='"
							+ detail + "')";
				}
			} else if (!"".equals(catalog) && catalog != null) {
				if (price.indexOf("-") > 0) {
					sql = "select * from d_product where price>=" + value[0] + " and price<=" + value[1]
							+ " and catalog_detail_id in(select id from d_catalog_detail where catalog_id=(select id from d_catalog where name='"
							+ catalog + "'))";
				} else {
					sql = "select * from d_product where price>2000 and catalog_detail_id in(select id from d_catalog_detail where catalog_id=(select id from d_catalog where name='"
							+ catalog + "'))";
				}
			} else {
				if (price.indexOf("-") > 0) {
					System.err.println("-------------");
					sql = "select * from d_product where price>=" + value[0] + " and price<=" + value[1] + "";
				} else {
					sql = "select * from d_product where price>2000";
				}
			}

			ResultSet rs = statement.executeQuery(sql);
			lists = init(rs, lists);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lists;
	}

	@Override
	public List<Product> findProductByPriceAndPublish(String publishName, String price, String catalog, String detail) {
		List<Product> lists = new ArrayList<Product>();
		try {
			Statement statement = conn.createStatement();
			String sql = null;
			String[] value = price.split("-");
			if (!"".equals(detail) && detail != null) {
				if (price.indexOf("-") > 0 && !publishName.equals("其他")) {
					sql = "select * from d_product where price>=" + value[0] + " and price<=" + value[1] + " "
							+ "and publish='" + publishName
							+ "' and catalog_detail_id in(select id from d_catalog_detail where name='" + detail + "')";

				} else if (price.indexOf("-") <= 0) {
					if (!publishName.equals("其他")) {
						sql = "select * from d_product where price>2000 and publish='" + publishName
								+ "' and catalog_detail_id in(select id from d_catalog_detail where name='" + detail
								+ "')";
					} else {
						sql = "select * from d_product where price>2000 and publish not "
								+ "in(select name from d_publish) and catalog_detail_id in(select id from d_catalog_detail where name='"
								+ detail + "')";
					}
				} else {
					sql = "select * from d_product where price>=" + value[0] + " and price<=" + value[1] + ""
							+ "and publish not in(select name from d_publish) and catalog_detail_id in(select id from d_catalog_detail where name='"
							+ detail + "')";
				}
			} else if (!"".equals(catalog) && catalog != null) {
				System.err.println(detail + "-----------------" + catalog);
				if (price.indexOf("-") > 0 && !publishName.equals("其他")) {
					sql = "select * from d_product where price>=" + value[0] + " and price<=" + value[1] + " "
							+ "and publish='" + publishName
							+ "' and catalog_detail_id in(select id from d_catalog_detail where catalog_id=(select id from d_catalog where name='"
							+ catalog + "')) ";

				} else if (price.indexOf("-") <= 0) {
					if (!publishName.equals("其他")) {
						sql = "select * from d_product where price>2000 and publish='" + publishName
								+ "' and catalog_detail_id in(select id from d_catalog_detail where catalog_id=(select id from d_catalog where name='"
								+ catalog + "')) ";
					} else {
						sql = "select * from d_product where price>2000 and publish not "
								+ "in(select name from d_publish) and catalog_detail_id in(select id from d_catalog_detail where catalog_id (select id from d_catalog where name='"
								+ catalog + "')) ";
					}
				} else {
					sql = "select * from d_product where price>=" + value[0] + " and price<=" + value[1] + ""
							+ "and publish not in(select name from d_publish) and catalog_detail_id in(select id from d_catalog_detail where catalog_id=(select id from d_catalog where name='"
							+ catalog + "')) ";
				}
			} else {
				if (price.indexOf("-") > 0 && !publishName.equals("其他")) {
					sql = "select * from d_product where price>=" + value[0] + " and price<=" + value[1] + " "
							+ "and publish='" + publishName + "'";

				} else if (price.indexOf("-") <= 0) {
					if (!publishName.equals("其他")) {
						sql = "select * from d_product where price>2000 and publish='" + publishName + "'";
					} else {
						sql = "select * from d_product where price>2000 and publish not "
								+ "in(select name from d_publish)";
					}
				} else {
					sql = "select * from d_product where price>=" + value[0] + " and price<=" + value[1] + ""
							+ "and publish not in(select name from d_publish)";
				}
			}
			ResultSet rs = statement.executeQuery(sql);
			lists = init(rs, lists);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lists;
	}
}
