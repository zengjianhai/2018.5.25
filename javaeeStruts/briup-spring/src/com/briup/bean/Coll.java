package com.briup.bean;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Coll {
	private List<String> schools;
	private String[] books;
	private Map scores;
	private Map<String, String> maps;
	private Properties healths;
	public List<String> getSchools() {
		return schools;
	}
	public void setSchools(List<String> schools) {
		this.schools = schools;
	}
	public String[] getBooks() {
		return books;
	}
	public void setBooks(String[] books) {
		this.books = books;
	}
	public Map getScores() {
		return scores;
	}
	public void setScores(Map scores) {
		this.scores = scores;
	}
	public Map<String, String> getMaps() {
		return maps;
	}
	public void setMaps(Map<String, String> maps) {
		this.maps = maps;
	}
	public Properties getHealths() {
		return healths;
	}
	public void setHealths(Properties healths) {
		this.healths = healths;
	}
	public Coll() {
	}
	public Coll(List<String> schools, String[] books, Map scores, Map<String, String> maps, Properties healths) {
		super();
		this.schools = schools;
		this.books = books;
		this.scores = scores;
		this.maps = maps;
		this.healths = healths;
	}
	@Override
	public String toString() {
		return "Coll [schools=" + schools + ", books=" + Arrays.toString(books) + ", scores=" + scores + ", maps="
				+ maps + ", healths=" + healths + "]";
	}
}
