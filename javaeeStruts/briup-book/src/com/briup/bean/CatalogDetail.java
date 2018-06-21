package com.briup.bean;

public class CatalogDetail {
	private int id;
	private String name;
	private int catalog_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCatalog_id() {
		return catalog_id;
	}
	public void setCatalog_id(int catalog_id) {
		this.catalog_id = catalog_id;
	}
	public CatalogDetail() {
	}
	public CatalogDetail(int id, String name, int catalog_id) {
		super();
		this.id = id;
		this.name = name;
		this.catalog_id = catalog_id;
	}
	@Override
	public String toString() {
		return "CatalogDetail [id=" + id + ", name=" + name + ", catalog_id=" + catalog_id + "]";
	}
}
