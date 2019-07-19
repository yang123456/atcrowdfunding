package com.atguigu.atcrowdfunding.proxy.staticProxy;

/** 1：首先定义一个接口，说明业务逻辑。       
 * 定义一个账户接口
 * 
 * @author Administrator
 */
public interface Count {
	// 查询账户
	public void queryCount();

	// 修改账户
	public void updateCount();

}