package com.hibernate.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "t_account")
@Cache(region = "com.hibernate.pojo.Account", include = "all", usage = CacheConcurrencyStrategy.READ_WRITE)
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "acc_name")
	private String name;
	@Basic
	private int age;
	private double score;
	@Temporal(TemporalType.TIMESTAMP)
	private Date bir;
	// 表示这个字段在表中不会生成对应的属性
	@Transient
	private String address;
	@Version
	private int version;

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public Date getBir() {
		return bir;
	}

	public void setBir(Date bir) {
		this.bir = bir;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Account() {
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", age=" + age + ", score=" + score + ", bir=" + bir
				+ ", address=" + address + ", version=" + version + "]";
	}

	public Account(int id, String name, int age, double score, Date bir, String address, int version) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.score = score;
		this.bir = bir;
		this.address = address;
		this.version = version;
	}
}
