package com.briup.Impl;

import com.briup.bean.Consignee;

public interface FindImpl {
	/**
	 * 查找收货人的id
	 * @param consignee
	 * @return
	 */
	public int findConsigneeId(Consignee consignee);
}
