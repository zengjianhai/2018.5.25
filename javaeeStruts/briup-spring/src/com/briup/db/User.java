package com.briup.db;

@DBTableName(name = "user")
public class User {
	@DBString(name = "name", size = 16, constraints = Constraint.NOTNULL, 
			type = @DBType(type = Type.varchar2))
	private String name;
	@DBString(name = "pass", size = 10, constraints = Constraint.NOTNULL, type = @DBType(type = Type.varchar2))
	private String pass;
	@DBString(name = "id", size = 6, constraints = Constraint.PRIMARYKEY, type = @DBType(type = Type.number))
	private int id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", pass=" + pass + ", id=" + id + "]";
	}

	public User(String name, String pass, int id) {
		super();
		this.name = name;
		this.pass = pass;
		this.id = id;
	}

	public User() {
	}
}
