package com.briup.db;

import java.lang.annotation.*;

import javax.servlet.annotation.WebServlet;
@WebServlet
@Inherited
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DBString {
	public String name();
	public int size() default 1;
	Constraint constraints() default Constraint.NULL;
	DBType type();
}
