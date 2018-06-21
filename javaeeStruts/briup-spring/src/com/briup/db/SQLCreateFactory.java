package com.briup.db;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class SQLCreateFactory {
	public static String getCreate(String className) {
		String sql = null;
		try {
			Class<?> cl = Class.forName(className);
			DBTableName tableName = cl.getAnnotation(DBTableName.class);
			List<String> columns = new ArrayList<String>();
			for (Field field : cl.getDeclaredFields()) {
				String columnName = null;
				Annotation[] annotations = field.getAnnotations();
				if (annotations.length < 1) {
					continue;
				}
				if (annotations[0] instanceof DBString) {
					DBString sStr = (DBString) annotations[0];
					columnName = sStr.name().length() < 1 ? field.getName() : sStr.name();
					if (sStr.type().type().equals(Type.data)) {
						columns.add(columnName + " " + sStr.type().type() +" "+ sStr.constraints().getValue());
					} else {
						columns.add(columnName + " " + sStr.type().type() + "(" + sStr.size() + ") "
								+ sStr.constraints().getValue());
					}
				}
			}
			StringBuilder sb = new StringBuilder("create table " + tableName.name() + "(");
			for (String column : columns) {
				sb.append("\n    " + column + ",");
			}
			sql = sb.substring(0, sb.length() - 1) + ");";
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return sql;
	}
}
