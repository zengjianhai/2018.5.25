package com.briup.bean;

import java.util.List;

public class Catalog {
	private List<String> catalogs;

	public List<String> getCatalogs() {
		return catalogs;
	}

	public void setCatalogs(List<String> catalogs) {
		this.catalogs = catalogs;
	}
	public Catalog() {
	}

	public Catalog(List<String> catalogs) {
		super();
		this.catalogs = catalogs;
	}

	@Override
	public String toString() {
		return "Catalog [catalogs=" + catalogs + "]";
	}
}
