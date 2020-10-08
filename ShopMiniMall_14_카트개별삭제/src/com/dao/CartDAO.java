package com.dao;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

import com.dto.CartDTO;
import com.dto.GoodsDTO;

public class CartDAO {

	
	public int cartUpdate(SqlSession session, HashMap<String, Integer> map) {
		int n = session.update("CartMapper.cartUpdate", map);
		return n;
	}
	
	public int cartDel(SqlSession session, int num) {
		int n = session.delete("CartMapper.cartDel", num);
		return n;
	}
	
	 public List<CartDTO> cartList(SqlSession session, String userid) {
		   List<CartDTO> list = 
				   session.selectList("CartMapper.cartList", userid);
		   return list;
	   }
	public int cartAdd(SqlSession session, CartDTO dto) {
		int n = session.insert("CartMapper.cartAdd", dto);
		return n;
	}

}
