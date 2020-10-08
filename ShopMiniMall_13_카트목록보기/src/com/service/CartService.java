package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.CartDAO;
import com.dao.GoodsDAO;
import com.dto.CartDTO;
import com.dto.GoodsDTO;

public class CartService {

	
	 public List<CartDTO> cartList(String userid) {
			SqlSession session = MySqlSessionFactory.getSession();
			List<CartDTO> list = null;
			try {
				CartDAO dao = new CartDAO();
				 list = dao.cartList(session, userid);
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				session.close();
			}
			return list;
		}//end idCheck
	public int cartAdd(CartDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			CartDAO dao = new CartDAO();
			n = dao.cartAdd(session, dto);
			session.commit();
		} finally {
			session.close();
		}
		return n;
	}// end cartAdd

}// end class
