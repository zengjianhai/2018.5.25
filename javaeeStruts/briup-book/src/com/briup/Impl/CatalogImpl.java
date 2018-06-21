package com.briup.Impl;

import java.util.List;

import com.briup.bean.Catalog;
import com.briup.bean.CatalogDetail;

public interface CatalogImpl {
	public Catalog findAllCatalog();
	public List<CatalogDetail> findCatalogDetailByName(String name);
	public String findCatalogNameByDetailId(int id);
}
