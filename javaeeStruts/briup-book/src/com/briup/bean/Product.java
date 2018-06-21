package com.briup.bean;

import java.util.Date;

public class Product {
	private int id; 
	private String name;
	private int catalog_detail_id; 
	private int price;
	private String service;
	private String img; 
	private String version; 
	private int amount;
	private int happy_price;
	private int evaluate_id;
	private int specification_id; 
	private int merchant_id;
	private String introduction; 
	private String publish; 
	private String author; 
	private Date time;
	public Product(int id, String name, int catalog_detail_id, int price, String service, String img, String version,
			int amount, int happy_price, int evaluate_id, int specification_id, int merchant_id, String introduction,
			String publish, String author, Date time) {
		super();
		this.id = id;
		this.name = name;
		this.catalog_detail_id = catalog_detail_id;
		this.price = price;
		this.service = service;
		this.img = img;
		this.version = version;
		this.amount = amount;
		this.happy_price = happy_price;
		this.evaluate_id = evaluate_id;
		this.specification_id = specification_id;
		this.merchant_id = merchant_id;
		this.introduction = introduction;
		this.publish = publish;
		this.author = author;
		this.time = time;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Product() {
	}
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
	public int getCatalog_detail_id() {
		return catalog_detail_id;
	}
	public void setCatalog_detail_id(int catalog_detail_id) {
		this.catalog_detail_id = catalog_detail_id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getHappy_price() {
		return happy_price;
	}
	public void setHappy_price(int happy_price) {
		this.happy_price = happy_price;
	}
	public int getEvaluate_id() {
		return evaluate_id;
	}
	public void setEvaluate_id(int evaluate_id) {
		this.evaluate_id = evaluate_id;
	}
	public int getSpecification_id() {
		return specification_id;
	}
	public void setSpecification_id(int specification_id) {
		this.specification_id = specification_id;
	}
	public int getMerchant_id() {
		return merchant_id;
	}
	public void setMerchant_id(int merchant_id) {
		this.merchant_id = merchant_id;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public Product(int id, String name, int catalog_detail_id, int price, String service, String img, String version,
			int amount, int happy_price, int evaluate_id, int specification_id, int merchant_id, String introduction,
			String publish, String author) {
		this.id = id;
		this.name = name;
		this.catalog_detail_id = catalog_detail_id;
		this.price = price;
		this.service = service;
		this.img = img;
		this.version = version;
		this.amount = amount;
		this.happy_price = happy_price;
		this.evaluate_id = evaluate_id;
		this.specification_id = specification_id;
		this.merchant_id = merchant_id;
		this.introduction = introduction;
		this.publish = publish;
		this.author = author;
	}
	public Product(int id, String name, int catalog_detail_id, int price, String service, String img, String version,
			int amount, int happy_price, int evaluate_id, int specification_id, int merchant_id, String introduction) {
		this.id = id;
		this.name = name;
		this.catalog_detail_id = catalog_detail_id;
		this.price = price;
		this.service = service;
		this.img = img;
		this.version = version;
		this.amount = amount;
		this.happy_price = happy_price;
		this.evaluate_id = evaluate_id;
		this.specification_id = specification_id;
		this.merchant_id = merchant_id;
		this.introduction = introduction;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", catalog_detail_id=" + catalog_detail_id + ", price=" + price
				+ ", service=" + service + ", img=" + img + ", version=" + version + ", amount=" + amount
				+ ", happy_price=" + happy_price + ", evaluate_id=" + evaluate_id + ", specification_id="
				+ specification_id + ", merchant_id=" + merchant_id + ", introduction=" + introduction + ", publish="
				+ publish + ", author=" + author + ", time=" + time + "]";
	}
}
