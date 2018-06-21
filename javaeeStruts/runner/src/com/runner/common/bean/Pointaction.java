package com.runner.common.bean;


import java.util.HashSet;
import java.util.Set;

/**
 * Pointaction entity.
 * 
 * @author MyEclipse Persistence Tools
 */


//浠ｈ〃鍝簺 鍙互鍔犲垎鐨勫姩浣�/琛屼负 鐨勭被 
public class Pointaction implements java.io.Serializable {

	// Fields

	private Long id;
	//褰撳墠杩欎釜鍙互鍔犲垎鐨勫姩浣�/琛屼负鐨勫悕瀛� 渚嬪:鐧诲綍 娉ㄥ唽绛�
	private String actionname;
	//瀹屾垚杩欎釜鍔ㄤ綔鍙互缁欑敤鎴峰姞澶氬皯鍒�
	private Long point;
	//瀵硅繖涓姩浣滄弿杩�
	private String description;
	//鏈夊摢浜涘姩浣滆褰曚腑鏄紩鐢ㄤ簡褰撳墠杩欎釜鍔ㄤ綔
	private Set pointrecords = new HashSet(0);

	// Constructors

	/** default constructor */
	public Pointaction() {
	}

	/** minimal constructor */
	public Pointaction(Long point) {
		this.point = point;
	}

	/** full constructor */
	public Pointaction(String actionname, Long point, String description,
			Set pointrecords) {
		this.actionname = actionname;
		this.point = point;
		this.description = description;
		this.pointrecords = pointrecords;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getActionname() {
		return this.actionname;
	}

	public void setActionname(String actionname) {
		this.actionname = actionname;
	}

	public Long getPoint() {
		return this.point;
	}

	public void setPoint(Long point) {
		this.point = point;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set getPointrecords() {
		return this.pointrecords;
	}

	public void setPointrecords(Set pointrecords) {
		this.pointrecords = pointrecords;
	}

}