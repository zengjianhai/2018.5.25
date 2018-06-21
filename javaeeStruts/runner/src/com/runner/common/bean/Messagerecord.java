package com.runner.common.bean;


import java.util.Date;

/**
 * Messagerecord entity.
 * 
 * @author MyEclipse Persistence Tools
 */


//璁板綍鐢ㄦ埛涔嬮棿鎵�鍙戦�佺殑鐭俊淇℃伅
public class Messagerecord implements java.io.Serializable {

	// Fields

	private Long id;
	//鍙戦�佷汉
	private String sender;
	//鎺ユ敹浜�
	private String receiver;
	//鍙戦�佹椂闂�
	private Date senddate;
	//淇℃伅涓婚
	private String title;
	//淇℃伅鍐呭
	private String content;
	//鍙戦�佺姸鎬�:  0:鍙戦�佸畬浣嗘槸鏈垹闄� 1:鍙戦�佸畬骞朵笖宸插垹闄�
	private Long senderstatus;
	//鎺ユ敹鐘舵��:  0:宸茬粡鎺ユ敹浣嗘湭鍒犻櫎 1:鎺ユ敹鑰屼笖宸插垹闄�
	private Long receiverstatus;
	//淇℃伅闃呰鐘舵��: 0:鏈 1:宸茶
	private Long status;

	// Constructors

	/** default constructor */
	public Messagerecord() {
	}

	/** minimal constructor */
	public Messagerecord(String sender, String receiver, Date senddate,
			String title, String content) {
		this.sender = sender;
		this.receiver = receiver;
		this.senddate = senddate;
		this.title = title;
		this.content = content;
	}

	/** full constructor */
	public Messagerecord(String sender, String receiver, Date senddate,
			String title, String content, Long senderstatus,
			Long receiverstatus, Long status) {
		this.sender = sender;
		this.receiver = receiver;
		this.senddate = senddate;
		this.title = title;
		this.content = content;
		this.senderstatus = senderstatus;
		this.receiverstatus = receiverstatus;
		this.status = status;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSender() {
		return this.sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return this.receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public Date getSenddate() {
		return this.senddate;
	}

	public void setSenddate(Date senddate) {
		this.senddate = senddate;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getSenderstatus() {
		return this.senderstatus;
	}

	public void setSenderstatus(Long senderstatus) {
		this.senderstatus = senderstatus;
	}

	public Long getReceiverstatus() {
		return this.receiverstatus;
	}

	public void setReceiverstatus(Long receiverstatus) {
		this.receiverstatus = receiverstatus;
	}

	public Long getStatus() {
		return this.status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

}