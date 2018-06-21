package com.hibernate.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;


@Entity
@Table(name = "t_category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Version
	private int version;
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Product> proList;

	public Category(int id, int version, String name, List<Product> proList) {
		super();
		this.id = id;
		this.version = version;
		this.name = name;
		this.proList = proList;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", version=" + version + ", name=" + name + ", proList=" + proList + "]";
	}

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

	public Category() {
	}

	public List<Product> getProList() {
		return proList;
	}

	public void setProList(List<Product> proList) {
		this.proList = proList;
	}

}
