package com.javaketang.mybatismapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.javaketang.util.Page;
import com.javaketang.entity.Sale;

public interface SaleMapper {

	int addSale(Sale sale);
	
	List<Sale> querySale();
	
	List<Sale> querySaleLimit(@Param("aa")String leix,@Param("page")Page page);
	
	int selectNums();
	
}
