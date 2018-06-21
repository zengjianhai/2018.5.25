package com.briup.struts;

/**
 * 定义键值对都为Object型
 * @author xunfeng
 *
 */
public class Link {
	private Object key;
	private Object value;
	public Object getKey() {
		return key;
	}
	public void setKey(Object key) {
		this.key = key;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Link [key=" + key + ", value=" + value + "]";
	}
	public Link(Object key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}
}
