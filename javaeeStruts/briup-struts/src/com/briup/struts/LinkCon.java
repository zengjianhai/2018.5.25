package com.briup.struts;

/**
 * 键值对数据存储结构 key-value 
 * key:表示键值，可以是定义的任意类型 
 * value:可以插入任意的类型值
 * <K,V>通过泛型指定输入规则
 * @author xunfeng
 *
 */
@SuppressWarnings("unchecked")
public class LinkCon<K,V> implements Mycon<K,V> {
	private Link[] links;
	private int count = 0;

	public LinkCon() {
		links = new Link[10];
	}

	public LinkCon(int count) {
		links = new Link[count];
	}

	public void ensureCapacity() {
		if (count >= links.length) {
			Link[] linksCapacity = new Link[count + 10];
			/* 把links数组中的数据拷贝到linksCapacity中 */
			System.arraycopy(links, 0, linksCapacity, 0, links.length);
			links = linksCapacity;
		}
	}

	@Override
	public void add(K key, V value) {
		if (key != null) {
			if (get(key) == null) {
				ensureCapacity();
				// 将index之后所有的数据向后移动
				links[count] = new Link(key, value);
				count++;
			}
		} else {
			throw new RuntimeException("key值为空");
		}
	}

	@Override
	public V get(K key) {
		for (Link link : links) {
			if (link == null) {
			} else {
				if (link.getKey().equals(key)) {
					return (V)link;
				}
			}
		}
		return null;
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public void set(K key, V value) {
		for (int i = 0; i < links.length; i++) {
			if (links[i] != null) {
				if (links[i].getKey().equals(key)) {
					links[i].setValue(value);
				}
			}
		}
	}

	@Override
	public V remove(K key) {
		if (key != null) {
			for (int i = 0; i < links.length; i++) {
				if (links[i].getKey().equals(key)) {
					Link link = links[i];
					for (int j = i; j < count - 1; j++) {
						links[j] = links[j + 1];
					}
					links[--count] = null;
					return (V)link;
				}
			}
		} else {
			throw new RuntimeException("key值为空");
		}
		return null;
	}

}
