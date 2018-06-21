package com.briup.http;

public class EcjtuClassId {
	private String softWareId;
	private String softWare;
	private String gradeClass;
	private String className;
	private String classId;
	public String getSoftWareId() {
		return softWareId;
	}
	public void setSoftWareId(String softWareId) {
		this.softWareId = softWareId;
	}
	public String getSoftWare() {
		return softWare;
	}
	public void setSoftWare(String softWare) {
		this.softWare = softWare;
	}
	public String getGradeClass() {
		return gradeClass;
	}
	public void setGradeClass(String gradeClass) {
		this.gradeClass = gradeClass;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public EcjtuClassId() {
	}
	public EcjtuClassId(String softWareId, String softWare) {
		this.softWareId = softWareId;
		this.softWare = softWare;
	}
	public EcjtuClassId(String softWareId, String softWare, String gradeClass, String className, String classId) {
		this.softWareId = softWareId;
		this.softWare = softWare;
		this.gradeClass = gradeClass;
		this.className = className;
		this.classId = classId;
	}
	@Override
	public String toString() {
		return softWareId + "|" + softWare + "|" + gradeClass
				+ "|" + className + "|" + classId;
	}
}
