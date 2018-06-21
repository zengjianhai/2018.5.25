package com.briup.test.struts;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
public class UploadAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String title;
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	private String savePath;
	private String allowTypes;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getSavePath() {
		return ServletActionContext.getServletContext().getRealPath(savePath);
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println("getSavePath():"+getSavePath()+"---getUploadFileName()："+getUploadFileName());
		FileOutputStream fos = new FileOutputStream(getSavePath()+File.separator+getUploadFileName());
		FileInputStream fis = new FileInputStream(getUpload());
		byte[] bs = new byte[1024];
		int len=0;
		while ((len=fis.read(bs))!=-1) {
			fos.write(bs,0,len);
		}
		fos.flush();
		fos.close();
		fis.close();
		return SUCCESS;
	}
	public String getAllowTypes() {
		return allowTypes;
	}
	public void setAllowTypes(String allowTypes) {
		this.allowTypes = allowTypes;
	}
	
//	public String filterType(String[] types){
//		String fileType = getUploadContentType();
//		for (String type : types) {
//			if(type.equals(fileType)){
//				return null;
//			}
//		}
//		return ERROR;
//	}
//	public String filterLenght(File file){
//		if(file.length()<20000){
//			return null;
//		}
//		return ERROR;
//	} 
//	@Override
//	public void validate() {
//		String filterResult = filterType(getAllowTypes().split(","));
//		String filterLenght=filterLenght(getUpload());
//		if(filterResult!=null){
//			addFieldError("upload", "上传的文件类型不正确");
//		}
//		if(filterLenght!=null){
//			addFieldError("upload", "上传的文件过大");
//		}
//	}
//	
}
