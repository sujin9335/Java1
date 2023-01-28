package com.member.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.member.model.vo.Member;

//DB에 접속해서 해당하는 데이터를 조회, 추가, 수정, 삭제 기능을 제공
public class MemberDao {

	public List<Member> searchAll(){
		//BS계정의 Member테이블에 저장된 모든 데이터를 전달해주는 기능
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		List<Member> members=new ArrayList();
		try {
			Class.forName("oricale.jdbc.driver.OracleDreiver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BS","BS");
			conn.setAutoCommit(false);
			stmt=conn.createStatement();
			String sql="SELECT * FROM MEMBER";
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				Member m=getDataBaseMember(rs);
				members.add(m);
			}
			
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null && !rs.isClosed()) rs.close();
				if(stmt!=null && !rs.isClosed()) stmt.close();
				if(conn!=null && !conn.isClosed()) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return members;
		
	}
	public List<Member> searchName(String name){
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		List<Member> members=new ArrayList();
		try {
			Class.forName("oricale.jdbc.driver.OracleDreiver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BS","BS");
			stmt=conn.createStatement();
			String sql="SELECT * FROM MEMBER WHERE MEMBER_NAME LIKE '%"+name+"'";
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				Member m=getDataBaseMember(rs);
				members.add(m);
			}
				
				
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null && !rs.isClosed()) rs.close();
				if(stmt!=null && !stmt.isClosed()) stmt.close();
				if(conn!=null && !conn.isClosed()) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return members;
		
	}
	
	private Member getDataBaseMember(ResultSet rs) throws SQLException {
		Member m=new Member();
		m.setMemberId(rs.getString("member_id"));
		m.setMemberName(rs.getString("member_name"));
		m.setAge(rs.getInt("age"));
		m.setEmail(rs.getString("email"));
		m.setAddress(rs.getString("address"));
		m.setHobby(rs.getString("hobby").split(","));
		m.setEnrollDate(rs.getDate("enroll_date"));
		return m;
	}
	
	public int insertMember(Member m) {
		Connection conn=null;
//		Statement stmt=null;
		PreparedStatement pstmt=null;
		int result=0;
		try {
			Class.forName("oricale.jdbc.driver.OracleDreiver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BS","BS");
			conn.setAutoCommit(false);
			//매개변수값을 가지고 쿼리문을 구성할때 PreaparedStatement객체를 이용하는것이 좋다
			//PreparedStatement는 sql문에서 사용하는 값의 자료형을 알아서 처리해줌
			//자료형에 맞는 메소드를 제공해줌
			//메소드와 값을 매칭하기 위해서 ?표식을 사용을 함
			String sql="INSERT INTO MEMBER VALUES(?,?,?,?,?,?,?,?,?,SYSDATE)";
			pstmt=conn.prepareStatement(sql);
			//?에 들어갈 값을 preparedStatment객체가 제공하는 함수를 이용해서 대입
			//setString, setInt, setDouble, setDate....
			//각 set메소드의 매개변수는 두개를 가짐
			// 첫번째 매개변수 : ?의 위치 -> 왼쪽에서부터 1부터 시작
			// 두번째 매개변수 : 값
			//sql문에 설정된 모든 ?에 값을 대입해야한다 !!!!
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPwd());
			pstmt.setString(3, m.getMemberName());
			pstmt.setString(4, m.getGender());
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getEmail());
			pstmt.setInt(7, m.getPhone());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9, String.join(",",m.getHobby()));
			
			result=pstmt.executeUpdate();
			//PreparedStatement excuteUpdate메소드 실행시 인자값을 넣어주지않음
			
//			stmt=conn.createStatement();
//			String sql="INSERT INTO MEMBER VALUES('"+m.getMemberId()+"',"
//													+"'"+m.getMemberPwd()+"',"
//													+"'"+m.getMemberName()+"',"
//													+"'"+m.getGender()+"',"
//													+m.getAge()+","
//													+"'"+m.getEmail()+"',"
//													+"'"+m.getPhone()+"',"
//													+"'"+m.getAddress()+"',"
//													+"'"+String.join(",", m.getHobby())+"',"
//													+"sysdate)";
//			result=stmt.executeUpdate(sql);
			if(result>0) conn.commit();
			else conn.rollback();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null && !pstmt.isClosed()) pstmt.close();
				if(conn!=null && !conn.isClosed()) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}return result;
	}
	
}
