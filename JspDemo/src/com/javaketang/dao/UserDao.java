package com.javaketang.dao;

import java.sql.Connection;

import com.javaketang.entity.User;

public interface UserDao {
	
	/**
	 * ��¼����
	 * @param username �û���
	 * @param password ����
	 * @return ��������ж��Ƿ��¼�ɹ�
	 */
	boolean Login(User u);
	
	/**
	 * ע�᷽��
	 * @param username �û���
	 * @param password ����
	 * @return �����Ƿ�ע��ɹ�
	 */
	boolean register(User u);
	
}
