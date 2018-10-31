package com.javaketang.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.javaketang.dao.impl.UserDaoImpl;

/**
 * ���ݿ������
 * 
 * @author yuanguangjie
 *
 */
public class DatabaseConnection {

	public static Logger log=Logger.getLogger(UserDaoImpl.class.getName()); //����log4j����
	private static String url; // ���ӵ�ַ

	private static String driver; // ��������

	private static String name;// ���ݿ��û���

	private static String pwd;// ���ݿ�����

	static {
		read();
	}

	/**
	 * ���������ļ�
	 */
	public static void read() {
		Properties pro = new Properties();

		String file = "database.properties";

		InputStream str = DatabaseConnection.class.getClassLoader().getResourceAsStream(file);
		try {
			pro.load(str);
			url = pro.getProperty("url");
			driver = pro.getProperty("driver");
			name = pro.getProperty("name");
			pwd = pro.getProperty("password");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug(e);
		}
	}

	/**
	 * ��ȡ���ݿ�����
	 * 
	 * @return
	 */
	public static Connection getConnection() {

		Connection conn = null;
		try {
			Class.forName(driver);

			conn = DriverManager.getConnection(url, name, pwd);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug(e);
		}
		return conn;
	}

	/**
	 * �ر����ݿ���Դ
	 * 
	 * @param conn
	 * @param pre
	 * @param result
	 */
	public static void close(Connection conn, PreparedStatement pre, ResultSet result) {

		try {
			if (conn != null) {
				conn.close();
			}

			if (pre != null) {
				pre.close();
			}

			if (result != null) {
				result.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug(e);
		}

	}

	public static void main(String[] args) {

		Connection conn = DatabaseConnection.getConnection();
		System.out.println(conn);

	}

}
