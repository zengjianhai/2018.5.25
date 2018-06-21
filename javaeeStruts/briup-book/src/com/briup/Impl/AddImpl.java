package com.briup.Impl;

import com.briup.bean.Consignee;
import com.briup.bean.Order;
import com.briup.bean.ShopCar;

public interface AddImpl {
	/**
	 * 添加购物车
	 * @param shopCar
	 */
	public void addShopCar(ShopCar shopCar);
	/**
	 * 通过用户id和商品id查询到购物车的商品数量
	 * @param userId
	 * @param proId
	 * @return
	 */
	public int findShopCarByUserIdAndProId(int userId,int proId);
	/**
	 * 如果购物车中存在商品，判断是否继续增加商品数量
	 * @param count
	 * @param userId
	 * @param proId
	 */
	public void updataShopCar(int count,int userId, int proId);
	/**
	 * 添加收货人信息
	 * @param consignee
	 */
	public void addConsignee(Consignee consignee);
	/**
	 * 添加订单
	 * @param order
	 */
	public void addOrder(Order order);
}
