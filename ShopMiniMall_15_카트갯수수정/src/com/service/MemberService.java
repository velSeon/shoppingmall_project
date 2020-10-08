package com.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;

import com.config.MySqlSessionFactory;
import com.dao.MemberDAO;
import com.dto.MemberDTO;

public class MemberService {
	
	public String idSearch(MemberDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
		String userid = null;
		try {
			MemberDAO dao = new MemberDAO();
			userid = dao.idSearch(session, dto);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return userid;
	}
	
	
  public int memberUpdate(MemberDTO dto) {
		  
		  SqlSession session = MySqlSessionFactory.getSession();
		  int n = 0;
		  try {
			  MemberDAO dao = new MemberDAO();
			  n = dao.memberUpdate(session, dto);
			  session.commit();
		  }finally {
			session.close();
		}
		  return n;
	   }//end memberUpdate
	
	  public int memberAdd(MemberDTO dto) {
		  
		  SqlSession session = MySqlSessionFactory.getSession();
		  int n = 0;
		  try {
			  MemberDAO dao = new MemberDAO();
			  n = dao.memberAdd(session, dto);
			  session.commit();
		  }finally {
			session.close();
		}
		  return n;
	   }//end memberAdd
	  public int idCheck(String userid) {
			SqlSession session = MySqlSessionFactory.getSession();
			int count = 0;
			try {
				 MemberDAO dao = new MemberDAO();
				count = dao.idCheck(session, userid);
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				session.close();
			}
			return count;
		}//end idCheck
	  
	  public MemberDTO login(HashMap<String, String> map) {
			SqlSession session = MySqlSessionFactory.getSession();
			MemberDTO dto = null;
			try {
				 MemberDAO dao = new MemberDAO();
				 dto = dao.login(session, map);
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				session.close();
			}
			return dto;
		}//end idCheck
	  
	  public MemberDTO mypage(String userid) {
			SqlSession session = MySqlSessionFactory.getSession();
			MemberDTO dto = null;
			try {
				 MemberDAO dao = new MemberDAO();
				 dto = dao.mypage(session, userid);
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				session.close();
			}
			return dto;
		}//end idCheck
}//end class
