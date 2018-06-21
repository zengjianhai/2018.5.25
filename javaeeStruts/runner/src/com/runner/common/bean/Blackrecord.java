package com.runner.common.bean;

/**
 * Blackrecord entity.
 * 
 * @author MyEclipse Persistence Tools
 */

//璁板綍榛戝悕鍗曠殑涓�涓被
public class Blackrecord implements java.io.Serializable {

	// Fields

	private Long id;
	//鐢ㄦ埛鍚�
	private String selfname;
	//鐢ㄦ埛鎵�鎷夐粦鐨勫叾浠栦細鍛樼殑鍚嶅瓧
	private String blackname;

	// Constructors

	/** default constructor */
	public Blackrecord() {
	}

	/** full constructor */
	public Blackrecord(String selfname, String blackname) {
		this.selfname = selfname;
		this.blackname = blackname;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSelfname() {
		return this.selfname;
	}

	public void setSelfname(String selfname) {
		this.selfname = selfname;
	}

	public String getBlackname() {
		return this.blackname;
	}

	public void setBlackname(String blackname) {
		this.blackname = blackname;
	}

}