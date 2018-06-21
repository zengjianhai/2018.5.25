package com.runner.common.bean;


import java.util.HashSet;
import java.util.Set;

/**
 * Graderecord entity.
 * 
 * @author MyEclipse Persistence Tools
 */


//琛ㄧず绛夌骇鐨勪竴涓被  绉垎澧炲姞 绛夌骇浼氬崌楂�
public class Graderecord implements java.io.Serializable {

	// Fields

	private Long id;
	//褰撳墠绛夌骇绉垎鐨勬渶浣庡��
	private Long minpoint;
	//褰撳墠绛夌骇绉垎鐨勬渶楂樺��
	private Long maxpoint;
	//褰撳墠绛夌骇鐨勫悕瀛�
	private String gradename;
	//褰撳墠绛夌骇鐨勫浘鏍囪矾寰�
	private String iconpath;
	//鏈夊摢浜涚敤鎴峰睘浜庡綋鍓嶈繖涓瓑绾�
	private Set memberinfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public Graderecord() {
	}

	/** minimal constructor */
	public Graderecord(Long minpoint, Long maxpoint, String gradename,
			String iconpath) {
		this.minpoint = minpoint;
		this.maxpoint = maxpoint;
		this.gradename = gradename;
		this.iconpath = iconpath;
	}

	/** full constructor */
	public Graderecord(Long minpoint, Long maxpoint, String gradename,
			String iconpath, Set memberinfos) {
		this.minpoint = minpoint;
		this.maxpoint = maxpoint;
		this.gradename = gradename;
		this.iconpath = iconpath;
		this.memberinfos = memberinfos;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMinpoint() {
		return this.minpoint;
	}

	public void setMinpoint(Long minpoint) {
		this.minpoint = minpoint;
	}

	public Long getMaxpoint() {
		return this.maxpoint;
	}

	public void setMaxpoint(Long maxpoint) {
		this.maxpoint = maxpoint;
	}

	public String getGradename() {
		return this.gradename;
	}

	public void setGradename(String gradename) {
		this.gradename = gradename;
	}

	public String getIconpath() {
		return this.iconpath;
	}

	public void setIconpath(String iconpath) {
		this.iconpath = iconpath;
	}

	public Set getMemberinfos() {
		return this.memberinfos;
	}

	public void setMemberinfos(Set memberinfos) {
		this.memberinfos = memberinfos;
	}

}