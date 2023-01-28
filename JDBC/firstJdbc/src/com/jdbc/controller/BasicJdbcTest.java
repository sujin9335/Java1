package com.jdbc.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jdbc.model.vo.Member;

public class BasicJdbcTest {

	public static void main(String[] args) {
		//JDBC를 이용해서 DB에 있는 데이터 조작하기(CRUD, 추가수정삭제)
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		
		try {
			//1. jar가 제공하는 클래스가 있는지 확인 -> jar파일등록했는지 확인
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. DriverMananger클래슬르 이용해서 접속하는 객체를 생성한다
			// DriverManager클래스가 제공하는 getConnection()메소드(static)를 이용
			// getConnection메소드의 매개변수
			// 첫번째 매개변수 : DB접속주소(DB 서버의 ip주소), 이용포트, DB버전 String자료형
			// 				  jdbc에서 지정한 패턴이 있음
			// 문자열패턴 : jdbc:oracle:thin:@접속ip주소:포트번호:버전명 -> 오라클
			// 두번째 매개변수 : 사용자계정명(DB접속계정) String자료형
			// 세번째 매개변수 : 사용자계정비밀번호 String자료형
			conn=DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					//192.168.0.2||gd1class.iptime.org
					"BS",
					"BS");
			System.out.println("DB접속 완료!");
			// Connection에서 트렌젝션관련 처리하기 -> commit,rollback
			// 기본connection에서는 autocommit으로 실행됨
			conn.setAutoCommit(false);// 개발자가 직접 commit, rollback처리
			
			//3. Connection객체를 이용해서 sql문 실행 객체를 생성
			// statement, PreparedStatement 두개의 객체가 있음
			//Statemet : Connection객체의 createStatement()메소드를 이용
			//PreparedStatement : Connection객체의 preareStatement()메소드를 이용 생성
			stmt=conn.createStatement();
			//PreparedStatement pstmt=conn.prepareStatement("sql문");
			
			//4. 생성된 Statement, PreparedStatement객체가 제공하는 메소드를 이용해서 sql문을 실행
			// excuteQuery(["sql문"]) : SELECT문을 실행할때 사용 -> 반환형 ResultSet객체
			// excuteUpdate(["sql문"]) : INSERT, UPDATE, DELETE문을 실행할때 사용 -> 반환형 int
			// 1) 실행할 sql문을 작성하기
			//		주의 SQL문에 ;을 작성하지 않는다
			String sql="SELECT * FROM MEMBER";
			// 2) 쿼리문 실행하기
			//SELECT문 실행의 결과는 ResultSet객체에 저
			rs=stmt.executeQuery(sql);
			//int result=stmt.executeUpdate("update member set~~~");
			
			//5. 가져온 결과(data)활용하기 - ResultSet객체 활용하기
			// ResultSet객체에는 DB에서 조회한 데이터가 저장되어 있음
			// ResultSet이 제공하는 메소드를 이용해서 데이터를 가져온다
			// 1. next() : 다음 row를 지정할때 사용하는 메소드 -> 반환형 true/false
			// 2. getString||getInt||getDouble||getDate("컬럼명"||인덱스번호) 
			//			: 각 row의 컬럼데이터를 가져올때 사용하는 메소드
//			rs.next();//1번 row를 가져옴
//			String memberId=rs.getString("member_id");
//			String password=rs.getString("member_pwd");
//			int age=rs.getInt("age");
//			Date enrollDate=rs.getDate("enroll_date");
//			System.out.println(memberId+" "+password+" "+age+" "+enrollDate);
//			rs.next();//2번 row를 가져옴
//			memberId=rs.getString("member_id");
//			password=rs.getString("member_pwd");
//			age=rs.getInt("age");
//			enrollDate=rs.getDate("enroll_date");
//			System.out.println(memberId+" "+password+" "+age+" "+enrollDate);
//			rs.next();//3번 row를 가져옴
//			memberId=rs.getString("member_id");
//			password=rs.getString("member_pwd");
//			age=rs.getInt("age");
//			enrollDate=rs.getDate("enroll_date");
//			System.out.println(memberId+" "+password+" "+age+" "+enrollDate);
			
			//조회된 전체 데이터 출력하기
//			while(rs.next()) {
//				String memberId=rs.getString("member_id");
//				String password=rs.getString("member_pwd");
//				int age=rs.getInt("age");
//				Date enrollDate=rs.getDate("enroll_date");
//				System.out.println(memberId+" "+password+" "+age+" "+enrollDate);
//			}
			//컬럼데이터는 인덱스 번호로 가져올 수 있다
//			while(rs.next()) {
//				String memberId=rs.getString(1);
//				String password=rs.getString(2);
//				int age=rs.getInt(5);
//				Date enrollDate=rs.getDate(10);
//				System.out.println(memberId+" "+password+" "+age+" "+enrollDate);
//			}
			
			//DB에서 가져온 데이터는 VO클래스에 저장해서 관리
			//DB의 1개 row는 1개 VO객체와 매핑되어 처리
			List<Member> members=new ArrayList();
			while(rs.next()) {
				Member m=new Member();
				String memberId=rs.getString("member_id");
				m.setMemberId(memberId);
				String memberPwd=rs.getString("member_pwd");
				m.setMemberPwd(memberPwd);
				String memberName=rs.getString("member_name");
				m.setMemberName(memberName);
				String gender=rs.getString("gender");
				m.setGender(gender);
				int age=rs.getInt("age");
				m.setAge(age);
				String email=rs.getString("email");
				m.setEmail(email);
				m.setAddress(rs.getString("address"));
				m.setHobby(rs.getString("Hobby").split(","));
				m.setEnrollDate(rs.getDate("enroll_date"));
//				System.out.println(m);
				members.add(m);
			}
			
//			members.stream().forEach(e->System.out.println(e));
			
			for(Member m : members) {
				System.out.println(m);
			}
			
			System.out.println(members.get(3));
			
			//sql문 조건이 있는 경우 -> where 절
			//1. 성별이 남자인 회원을 검색
			System.out.println("남자 회원만 조회");
			Scanner sc=new Scanner(System.in);
			System.out.println("검색할 성별 : ");
			String keyword=sc.next();
			sql="SELECT * FROM MEMBER WHERE GENDER='"+keyword+"'";
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				Member m=new Member();
				m.setMemberId(rs.getString("member_id"));
				m.setMemberName(rs.getString("member_name"));
				m.setGender(rs.getString("gender"));
				m.setAge(rs.getInt("age"));
				System.out.println(m);
			}
			
			sc.nextLine();
			System.out.println("주소 조회하기");
			System.out.print("주소입력: ");
			String addrKeyword=sc.nextLine();
			sql="SELECT * FROM MEMBER WHERE ADDRESS LIKE '%"+addrKeyword+"%'";
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				Member m=new Member();
				String memberId=rs.getString("member_id");
				m.setMemberId(memberId);
				String memberPwd=rs.getString("member_pwd");
				m.setMemberPwd(memberPwd);
				String memberName=rs.getString("member_name");
				m.setMemberName(memberName);
				String gender=rs.getString("gender");
				m.setGender(gender);
				int age=rs.getInt("age");
				m.setAge(age);
				String email=rs.getString("email");
				m.setEmail(email);
				m.setAddress(rs.getString("address"));
				m.setHobby(rs.getString("Hobby").split(","));
				m.setEnrollDate(rs.getDate("enroll_date"));
				System.out.println(m);

			}
			
			//DML구문 실행하기
			//insert, update, delete구문 실행
			// 트랜젝션처리를 해줘야 한다
			System.out.println("회원가입");
			System.out.print("아이디: ");
			String id=sc.nextLine();
			System.out.print("패스워드: ");
			String pw=sc.nextLine();
			System.out.println("이름 : ");
			String name=sc.nextLine();
			System.out.println("나이 : ");
			int age=sc.nextInt();
			sc.nextLine();
			System.out.println("성별 : ");
			String gender=sc.nextLine();
			System.out.println("이메일 : ");
			String email=sc.nextLine();
			System.out.println("주소 : ");
			String addr=sc.nextLine();
			System.out.println("전화번호 : ");
			String phone=sc.nextLine();
			System.out.println("취미 : ");
			String hobby=sc.nextLine();
			
			sql="INSERT INTO MEMBER VALUES('"+id+"',"
					+ "'"+pw+"',"
					+ "'"+name+"', "
					+ "'"+gender+"',"
					+ ""+age+", "
					+ "'"+email+"',"
					+ "'"+phone+"',"
					+ "'"+addr+"', "
					+ "'"+hobby+"',"
					+ "sysdate)";
			int result=stmt.executeUpdate(sql);
			System.out.println(result);
			//트랜섹션처리
			if(result>0) conn.commit();
			else conn.rollback();
			
			//6. JDBC에서 제공하는 객체를 반드시 반환을 직접해줘야한다
			// close()메소드를 이용해서 객체를 닫아줘야한다
			// Connection, Statement||PrearedStatement, ResultSet
//			rs.close();
//			stmt.close();
//			conn.close();
			
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		
		
	}

}
