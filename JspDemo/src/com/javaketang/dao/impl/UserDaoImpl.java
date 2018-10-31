package com.javaketang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.javaketang.dao.UserDao;
import com.javaketang.entity.User;
import com.javaketang.util.DatabaseConnection;
import org.apache.log4j.Logger;

public class UserDaoImpl implements UserDao{
	public static Logger log=Logger.getLogger(UserDaoImpl.class.getName());
	public boolean Login(User u) {
		// TODO Auto-generated method stub
		//SQL���
		String sql = "select username from login where username='"+u.getUsername()+"' and password='"+u.getPassword()+"'";
		//��ȡ���ݿ�����
		
		Connection conn = DatabaseConnection.getConnection();
		//
		PreparedStatement pre = null;
		//�������������
		ResultSet result = null;
		
		boolean falg = false;
		try {
			pre = conn.prepareStatement(sql);
			result = pre.executeQuery();
			if(result.next()){
				falg=true;
			}
			log.debug("�Ƿ��¼�ɹ�---������"+falg);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.debug("�쳣---������"+e);
	
		}finally {
			//���ùر����ݿ���Դ����
			DatabaseConnection.close(conn, pre, result);
		}
		
		return falg;
	}

	public boolean register(User u) {
		// TODO Auto-generated method stub
		String sql = "insert into login select null,'"+u.getUsername()+"','"+u.getPassword()+"' from dual ";
		
		Connection conn = DatabaseConnection.getConnection();
		
		PreparedStatement pre = null;

		boolean falg = false;
		
		try {
			pre = conn.prepareStatement(sql);
			falg = pre.executeUpdate() > 0;
			log.debug("�Ƿ���ӳɹ�---������"+falg);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("�쳣---������"+e);
		}finally {
			//���ùر����ݿ���Դ����
			DatabaseConnection.close(conn, pre , null);
		}
		return falg;
		
	}

}
