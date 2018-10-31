package com.javaketang.mybatismapper;

import java.util.List;

import com.javaketang.entity.Product;

public interface ProductMapper {

	List<Product> queryByProduct();
	
	int queryByQuantity(int id);
}
