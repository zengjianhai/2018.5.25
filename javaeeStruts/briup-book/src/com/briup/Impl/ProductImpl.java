package com.briup.Impl;

import java.util.List;

import com.briup.bean.Product;

public interface ProductImpl {
	public List<Product> findProductByCatalogId(String name);
	public List<Product> findProductByCatalogName(String name);
	public Product findProductById(int id);
	public String findCatalogDetailNameById(int id);
	public void updateProduct(int id,int amount);
	public List<Product> findProductBySearch(String target);
	public List<Product> findAllProduct();
	public List<Product> sellerProduct(int count);
	public List<Product> findProductByPublish(String publishName,String catalog,String detail);
	public List<Product> findProductByPrice(String price,String catalog,String detail);
	public List<Product> findProductByOther(String catalog,String detail);
	public List<Product> findProductByPriceAndPublish(String publishName,String price,String catalog,String detail);
}
