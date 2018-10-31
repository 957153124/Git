package com.javaketang.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaketang.entity.Product;
import com.javaketang.entity.Sale;
import com.javaketang.mybatis.Mybatis;
import com.javaketang.util.Page;

public class SaleServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");
		String action = req.getParameter("action");
		if (action.equals("add")) {
			saleAdd(req, resp);
		}else if(action.equals("queryStock")) {
			queryStock(req,resp);
		}else if(action.equals("queryQuantity")) {
			queryQuantity(req,resp);
		}else if(action.equals("addA")) {
			add(req,resp);
		}else if(action.equals("chaxun")) {
			querySale(req,resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	public void saleAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		PrintWriter out = resp.getWriter();

		// ���۵���
		double SellingPrice = req.getParameter("SellingPrice") == null ? 0.00
				: Double.parseDouble(req.getParameter("SellingPrice"));
		// ��������
		int SellingVolumes = req.getParameter("SellingVolumes") == null ? 0
				: Integer.valueOf(req.getParameter("SellingVolumes"));
		// ��Ʒid
		int productId = req.getParameter("commodity") == null ? 0 : Integer.valueOf(req.getParameter("commodity"));
		// ������Ʒ�ܼ۸�
		double totalPrice = SellingVolumes * SellingPrice;
		// ����ԱID
		int userId = req.getSession().getAttribute("userId") == null ? 0
				: (int) req.getSession().getAttribute("userId");

		Sale sale = new Sale();
		sale.setPrice(SellingPrice);
		sale.setTotalPrice(totalPrice);
		sale.setQuantity(SellingVolumes);
		sale.setProductId(productId);
		sale.setUserId(userId);

		int result = Mybatis.addSale(sale);

		if (result == 1) {
			out.print("<script type='text/javascript'>alert('��ӳɹ�!');window.location.href='SaleServlet?action=chaxun';</script>");
		} else {
			out.print("<script type='text/javascript'>alert('���ʧ��!');window.location.href='SaleServlet?action=chaxun';</script>");
		}

	}
	
	public void queryStock(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		
		List<Product> list = Mybatis.queryByProduct();

		System.out.println("���ȫ����Ʒ:" + list);

		req.setAttribute("ProductList", list);
		
		req.getRequestDispatcher("queryStock.jsp").forward(req, resp);
		
	}
	
	public void queryQuantity(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		
		int id = req.getParameter("commodity") == null ? 0 : Integer.valueOf(req.getParameter("commodity"));
		
		int quantity = Mybatis.queryByQuantity(id);
		
		req.setAttribute("quantity", quantity);
		
		req.setAttribute("zifu", "����Ʒ�Ŀ������Ϊ:");
		
		List<Product> list = Mybatis.queryByProduct();

		System.out.println("���ȫ����Ʒ:" + list);

		req.setAttribute("ProductList", list);
		
		req.setAttribute("id", id);
		
		req.getRequestDispatcher("queryStock.jsp").forward(req, resp);
		
	}
	
	public void add(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		List<Product> list = Mybatis.queryByProduct();

		System.out.println("���ȫ����Ʒ:" + list);

		req.setAttribute("ProductList", list);
		
		req.getRequestDispatcher("addSale.jsp").forward(req, resp);
		
	}
	
	public void querySale(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		String query = req.getParameter("Salequery") == null ? "id" : req.getParameter("Salequery");
		String ye = req.getParameter("yeshu") == null ? "moren" : req.getParameter("yeshu");
		Integer pageB = req.getParameter("page") == null ? 1 : Integer.valueOf(req.getParameter("page"));
		int count = Mybatis.selectNums();
		int page = 0;
		
		double totalPages = (double)count/5;
		
		if(ye.equals("shang")) {
			page = page - 5;
			pageB --;
		}else if(ye.equals("xia")){
			page = page + 5;
			pageB ++;
		}
		
		System.out.println("����ҳ���ҳ��������������������"+pageB);
		
		Page pageA = new Page(count,page,5);
		List<Sale> list = Mybatis.querySaleDesc(query,pageA);
	
		req.setAttribute("SaleList", list);
		
		req.setAttribute("pages", pageB );
		
		
		
		req.setAttribute("totalPages", totalPages > (int)totalPages ? ((int)totalPages)+1 : 1);

		req.getRequestDispatcher("querySaleInformation.jsp").forward(req, resp);
		
	}

}
