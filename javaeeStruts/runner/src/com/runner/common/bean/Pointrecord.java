package com.runner.common.bean;


import java.util.Date;

/**
 * Pointrecord entity.
 * 
 * @author MyEclipse Persistence Tools
 */

//鐢ㄦ埛鎵�瀹屾垚鐨� 鍙互澧炲姞绉垎鐨勫姩浣�/琛屼负涔嬪悗 鐨勮褰�
public class Pointrecord implements java.io.Serializable {

	// Fields

	private Long id;
	//鐢ㄦ埛鎵�瀹屾垚鐨勫彲浠ュ鍔犵Н鍒嗙殑鍔ㄤ綔/琛屼负  渚嬪:鐧诲綍銆佹敞鍐屻�佸彂鏂囩珷绛夌瓑
	private Pointaction pointaction;
	//瀹屾垚杩欎釜鍔ㄤ綔鐨勭敤鎴风殑鏄电О
	private String nickname;
	//瀹屾垚鐨勬椂闂寸偣
	private Date receivedate;

	// Constructors

	/** default constructor */
	public Pointrecord() {
	}

	/** minimal constructor */
	public Pointrecord(String nickname, Date receivedate) {
		this.nickname = nickname;
		this.receivedate = receivedate;
	}

	/** full constructor */
	public Pointrecord(Pointaction pointaction, String nickname,
			Date receivedate) {
		this.pointaction = pointaction;
		this.nickname = nickname;
		this.receivedate = receivedate;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pointaction getPointaction() {
		return this.pointaction;
	}

	public void setPointaction(Pointaction pointaction) {
		this.pointaction = pointaction;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Date getReceivedate() {
		return this.receivedate;
	}

	public void setReceivedate(Date receivedate) {
		this.receivedate = receivedate;
	}

}