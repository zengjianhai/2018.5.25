package com.briup.Impl;

import java.util.List;

import com.briup.bean.ShopProduct;
import com.briup.bean.User;

public interface ShopImpl {
	public List<ShopProduct> findShopByUserName(User user);
	/**
	 * pros表示传递过来的确定要购买的商品的id集合，如1|2|3|
	 * amount表示每件商品所对应的购买的数量，如2|3|2
	 * 返回确定购买的商品订单集合
	 * @param pros
	 * @param amounts
	 * @return
	 */
	public List<ShopProduct> findShopByGether(String pros,String amounts);
	public String findMerchantById(int id);
}
