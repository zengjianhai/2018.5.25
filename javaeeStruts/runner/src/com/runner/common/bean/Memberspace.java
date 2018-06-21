package com.runner.common.bean;

/**
 * Memberspace entity.
 * 
 * @author MyEclipse Persistence Tools
 */


//鐢ㄦ埛鎵�瀵瑰簲鐨勪釜浜虹┖闂�
public class Memberspace implements java.io.Serializable {

	// Fields
	
	private Long id;
	//褰撳墠杩欎釜涓汉绌洪棿瀵瑰簲鐨勭敤鎴�
	private Memberinfo memberinfo;
	//涓汉瀵硅窇姝ョ殑鐪嬫硶
	private String opinion;
	//璺戞鏃堕棿
	private String runtime;
	//璺戞鍦扮偣
	private String runplace;
	//鍠滄鐨勮窇姝ユ槑鏄�
	private String runstar;
	//璺戞鐨勪範鎯�
	private String runhabit;
	//姝ｅ湪浣跨敤鐨勬墜鏈虹被鍨�/鍙风爜
	private String cellphone;
	//涓汉绌洪棿涓殑澶村儚璺緞
	private String icon;

	// Constructors

	/** default constructor */
	public Memberspace() {
	}

	/** full constructor */
	public Memberspace(Memberinfo memberinfo, String opinion, String runtime,
			String runplace, String runstar, String runhabit, String cellphone,
			String icon) {
		this.memberinfo = memberinfo;
		this.opinion = opinion;
		this.runtime = runtime;
		this.runplace = runplace;
		this.runstar = runstar;
		this.runhabit = runhabit;
		this.cellphone = cellphone;
		this.icon = icon;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Memberinfo getMemberinfo() {
		return this.memberinfo;
	}

	public void setMemberinfo(Memberinfo memberinfo) {
		this.memberinfo = memberinfo;
	}

	public String getOpinion() {
		return this.opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public String getRuntime() {
		return this.runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public String getRunplace() {
		return this.runplace;
	}

	public void setRunplace(String runplace) {
		this.runplace = runplace;
	}

	public String getRunstar() {
		return this.runstar;
	}

	public void setRunstar(String runstar) {
		this.runstar = runstar;
	}

	public String getRunhabit() {
		return this.runhabit;
	}

	public void setRunhabit(String runhabit) {
		this.runhabit = runhabit;
	}

	public String getCellphone() {
		return this.cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

}