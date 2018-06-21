package com.briup.struts;

/**
 * 用泛型来限定输入
 * @author xunfeng
 *
 * @param <K>
 * @param <V>
 */
public interface Mycon<K, V> {
	/**
	 * 添加
	 * 
	 * @param key
	 * @param value
	 */
	public void add(K key, V value);

	/**
	 * 根据键查找值
	 * 
	 * @param key
	 * @return
	 */
	public V get(K key);

	/**
	 * 得到存储大小
	 * 
	 * @return
	 */
	public int size();

	/**
	 * 替换指定位置的学生
	 * 
	 * @param key
	 * @param value
	 */
	public void set(K key, V value);

	/**
	 * 删除指定的学生
	 * 
	 * @param key
	 * @return
	 */
	public V remove(K key);
}
