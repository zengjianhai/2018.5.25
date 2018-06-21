package com.hibernate.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "t_product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Version
	private int version;
	private String name;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cate_id")
	private Category category;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Product() {
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", version=" + version + ", name=" + name + ", category=" + category + "]";
	}

	public Product(int id, int version, String name, Category category) {
		super();
		this.id = id;
		this.version = version;
		this.name = name;
		this.category = category;
	}
}
