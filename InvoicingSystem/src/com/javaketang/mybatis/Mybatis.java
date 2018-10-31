package com.javaketang.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.javaketang.entity.Product;
import com.javaketang.entity.Sale;
import com.javaketang.entity.User;
import com.javaketang.mybatismapper.ProductMapper;
import com.javaketang.mybatismapper.SaleMapper;
import com.javaketang.mybatismapper.UserMapper;
import com.javaketang.util.Page;

public class Mybatis {

	public static User login(User user) throws IOException {

		Reader reader = Resources.getResourceAsReader("conf.xml");

		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);

		SqlSession session = sessionFactory.openSession();

		UserMapper userMapper = session.getMapper(UserMapper.class);

		System.out.println("----->>>>>" + userMapper);

		User userA = userMapper.login(user);

		System.out.println("id---->>>>>>>>>" + userA);

		session.close();

		return userA == null ? new User() : userA;
	}

	public static int addSale(Sale sale) throws IOException {

		Reader reader = Resources.getResourceAsReader("conf.xml");

		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);

		SqlSession session = sessionFactory.openSession();

		SaleMapper saleMapper = session.getMapper(SaleMapper.class);

		int result = saleMapper.addSale(sale);

		session.commit();

		session.close();

		return result;

	}

	public static List<Product> queryByProduct() throws IOException {

		Reader reader = Resources.getResourceAsReader("conf.xml");

		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);

		SqlSession session = sessionFactory.openSession();

		ProductMapper productMapper = session.getMapper(ProductMapper.class);

		System.out.println(productMapper + "========>>>>>>>");

		List<Product> list = productMapper.queryByProduct();
		System.out.println(list + "---->>>>>>>>>>>>>");

		session.close();

		return list;

	}

	public static List<Sale> querySale() throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");

		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);

		SqlSession session = sessionFactory.openSession();

		SaleMapper productMapper = session.getMapper(SaleMapper.class);

		List<Sale> list = productMapper.querySale();
		System.out.println(list + "---->>>>>>>>>>>>>");

		session.close();

		return list;
	}

	public static int queryByQuantity(int id) throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");

		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);

		SqlSession session = sessionFactory.openSession();

		ProductMapper productMapper = session.getMapper(ProductMapper.class);

		int quantity = productMapper.queryByQuantity(id);

		session.close();

		return quantity;

		
		
	}
	
	public static List<Sale> querySaleDesc(String leix,Page page) throws IOException{
		System.out.println("mybatis leix -- -- -- --  >>>>>>>"+leix);
		Reader reader = Resources.getResourceAsReader("conf.xml");

		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);

		SqlSession session = sessionFactory.openSession();

		SaleMapper saleMapper = session.getMapper(SaleMapper.class);

		List<Sale> list = saleMapper.querySaleLimit(leix,page);

		session.close();
		
		return list;
		
	}
	
	public static int selectNums() throws IOException { 
		Reader reader = Resources.getResourceAsReader("conf.xml");

		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);

		SqlSession session = sessionFactory.openSession();

		SaleMapper saleMapper = session.getMapper(SaleMapper.class);

		int count = saleMapper.selectNums();

		session.close();
		return count;
	}

}
