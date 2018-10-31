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
 * 数据库帮助类
 * 
 * @author yuanguangjie
 *
 */
public class DatabaseConnection {

	public static Logger log=Logger.getLogger(UserDaoImpl.class.getName()); //创建log4j对象
	private static String url; // 连接地址

	private static String driver; // 连接驱动

	private static String name;// 数据库用户名

	private static String pwd;// 数据库密码

	static {
		read();
	}

	/**
	 * 加载属性文件
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
	 * 获取数据库连接
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
	 * 关闭数据库资源
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
