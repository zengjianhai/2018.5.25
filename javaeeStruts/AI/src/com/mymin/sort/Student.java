package com.mymin.sort;

import com.briup.db.*;

@DBTableName(name="student")
public class Student {
	@DBString(name="name",size=15,constraints=Constraint.NOTNULL,
			type=@DBType(type=Type.varchar2))
	private String name;
	@DBString(name="score",size=3,constraints=Constraint.NOTNULL,
			type=@DBType(type=Type.number))
	private int score;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
