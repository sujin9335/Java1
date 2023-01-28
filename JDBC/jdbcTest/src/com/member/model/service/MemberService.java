package com.member.model.service;

import java.sql.Connection;
import java.util.List;

import com.member.common.JDBCTemplate;
import com.member.model.dao.MemberDao2;
import com.member.model.vo.Member; 
import com.member.common.JDBCTemplate.*;
import static com.member.common.JDBCTemplate.*
;
//DB에 접속하는 Connection 및 트렌젝션을 처리하는 클래스
public class MemberService {
	
	private MemberDao2 dao=new MemberDao2();
	
	
	public List<Member> searchAll(){
		Connection conn=JDBCTemplate.getConnection();
		List<Member> members=dao.searchAll(conn);
		JDBCTemplate.close(conn);
		return members;
	}
	
	public List<Member> searchName(String name){
		Connection conn=getConnection();
		List<Member> result=dao.searchName(conn, name);
		close(conn);
		
		return result;
	}
	
	public Member searchId(String id) {
		Connection conn=getConnection();
		Member m=dao.searchId(conn, id);
		close(conn);
		return m;
	}
	
	public int insertMember(Member m) {
		Connection conn=getConnection();
		int result=dao.insertMember(conn, m);
		//트렌젝션관리
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		
		return result;
	}

	public int updateMember(Member m) {
		return 0;
	}
	
	public int deleteMember(String id) {
		Connection conn=getConnection();
		int result=dao.deleteMember(conn, id);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		
		return result;
	}
	
	
}
