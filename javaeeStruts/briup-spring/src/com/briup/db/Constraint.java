package com.briup.db;

public enum Constraint {
	NOTNULL("NOT NULL"),PRIMARYKEY("PRIMARY KEY"),UNIQUE("UNIQUE"),NULL("");
	private String value;
	private Constraint(String value){
		this.value = value;
	}
	public String getValue(){
		return value;
	}
}
