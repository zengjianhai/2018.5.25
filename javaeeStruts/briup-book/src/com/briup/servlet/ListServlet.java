package com.briup.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.Product;
import com.briup.dao.ProductDao;

@WebServlet("/list.do")
public class ListServlet extends HttpServlet {
	ProductDao pDao;
	List<Product> lProducts;
	TreeSet<Product> ts;
	MyTs myTs;
	Collection<Product> collection;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		lProducts = new ArrayList<Product>();
		pDao = new ProductDao();
		PrintWriter out = resp.getWriter();
		String val = req.getParameter("chance");
		String catalog = req.getParameter("catalog");
		String detail = req.getParameter("detail");
		String price = req.getParameter("price");
		String publish = req.getParameter("publish");
		String search = req.getParameter("search");
		if ("null".equals(catalog)) {
			catalog = null;
		}
		if ("null".equals(search)) {
			search = null;
		}
		if ("null".equals(detail)) {
			detail = null;
		}
		if ("null".equals(price)) {
			price = null;
		}
		if ("null".equals(publish)) {
			publish = null;
		}
		System.err.println(catalog + ":" + detail + ":" + price + ":" + publish);
		if ("" != search && search != null) {
			lProducts = pDao.findProductBySearch(search);
		} else if (("" != price && price != null) || ("" != publish && publish != null)) {
			if (("" != price && price != null) && ("" != publish && publish != null)) {
				if ("不限".equals(price) || "不限".equals(publish)) {
					if ("不限".equals(price) && "不限".equals(publish)) {
						if (catalog == null && detail == null) {
							lProducts = pDao.findAllProduct();
						} else if (detail != null) {
							lProducts = pDao.findProductByCatalogId(detail);
						} else {
							lProducts = pDao.findProductByCatalogName(catalog);
						}
					} else if (!"不限".equals(price)) {
						lProducts = pDao.findProductByPrice(price, catalog, detail);
					} else {
						if ("其他".equals(publish)) {
							lProducts = pDao.findProductByOther(catalog, detail);
						} else {
							lProducts = pDao.findProductByPublish(publish, catalog, detail);
						}
					}
				} else {
					lProducts = pDao.findProductByPriceAndPublish(publish, price, catalog, detail);
				}
			} else {
				if ("" != price && price != null) {
					if ("不限".equals(price)) {
						if (catalog == null && detail == null) {
							lProducts = pDao.findAllProduct();
						} else if (detail != null) {
							lProducts = pDao.findProductByCatalogId(detail);
						} else {
							lProducts = pDao.findProductByCatalogName(catalog);
						}
					} else {
						lProducts = pDao.findProductByPrice(price, catalog, detail);
					}
				} else if ("" != publish && publish != null) {
					if ("不限".equals(publish)) {
						if (catalog == null && detail == null) {
							lProducts = pDao.findAllProduct();
						} else if (detail != null) {
							lProducts = pDao.findProductByCatalogId(detail);
						} else {
							lProducts = pDao.findProductByCatalogName(catalog);
						}
					} else if ("其他".equals(publish)) {
						lProducts = pDao.findProductByOther(catalog, detail);
					} else {
						lProducts = pDao.findProductByPublish(publish, catalog, detail);
					}
				}
			}
		} else {
			if ("".equals(catalog) || catalog == null) {
				lProducts = pDao.findAllProduct();
			} else {
				if ("".equals(detail) || detail == null) {
					lProducts = pDao.findProductByCatalogName(catalog);
				} else {
					lProducts = pDao.findProductByCatalogId(detail);
				}
			}
		}
		myTs = new MyTs(Integer.parseInt(val));
		if ("0".equals(val)) {
			collection = lProducts;
		} else {
			ts = new TreeSet<Product>(myTs);
			ts.addAll(lProducts);
			collection = ts;
		}
		for (Product product : collection) {
			out.write("<li class=\"c4_b5_c_box\">");
			out.write("<div class=\"c4_b5_c_box_pic\">");
			out.write("<div class=\"c4b5_pic_view\">");
			out.write("<a href=\"viewBook.jsp?product_id=" + product.getId() + " &detail_id="
					+ product.getCatalog_detail_id() + " &catalog=" + catalog + "\">");
			out.write("<img src=\"" + product.getImg() + "\"></a></div></div>");
			out.write("<div class=\"c4_b5_c_box_txt\">");
			out.write("<h1>￥" + product.getPrice() + "</h1><h2>");
			out.write("<a href=\"viewBook.jsp?product_id=" + product.getId() + "&detail_id="
					+ product.getCatalog_detail_id() + "&catalog=" + catalog + "\">");
			out.write("" + product.getName() + "</a></h2></div>");
			out.write("<div class=\"c4b5_el\">");
			out.write("<div class=\"c4b5_el_x\"><span class=\"wjx01\"></span>");
			out.write("</div></div>");
			out.write("<ul class=\"c4b5_option\">");
			out.write("<li class=\"shopcar_box\"><span class=\"shopcar01\"></span>加入购物车</li>");
			out.write("</ul></li>");
			out.flush();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	class MyTs implements Comparator<Object> {
		private int count;

		public MyTs() {
		}

		public MyTs(int count) {
			this.count = count;
		}

		@Override
		public int compare(Object o1, Object o2) {
			Product product1 = (Product) o1;
			Product product2 = (Product) o2;
			long amount1 = 0, amount2 = 0;
			switch (count) {
			case 0:

				break;
			case 1:
				amount1 = product1.getAmount();
				amount2 = product2.getAmount();
				break;
			case 2:
				amount1 = product1.getPrice();
				amount2 = product2.getPrice();
				break;
			case 3:
				amount1 = product1.getTime().getTime();
				amount2 = product2.getTime().getTime();
				break;
			default:
				break;
			}
			if (amount1 > amount2)
				return 1;
			if (amount1 < amount2)
				return -1;
			else
				return 0;
		}
	}
}
