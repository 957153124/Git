package com.javaketang.dao;

import java.sql.Connection;

import com.javaketang.entity.User;

public interface UserDao {
	
	/**
	 * 登录方法
	 * @param username 用户名
	 * @param password 密码
	 * @return 返回真假判断是否登录成功
	 */
	boolean Login(User u);
	
	/**
	 * 注册方法
	 * @param username 用户名
	 * @param password 密码
	 * @return 返回是否注册成功
	 */
	boolean register(User u);
	
}
