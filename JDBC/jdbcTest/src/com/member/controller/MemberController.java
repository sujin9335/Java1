package com.member.controller;

import java.util.List;

import com.member.model.service.MemberService;
import com.member.model.vo.Member;
import com.member.view.MainView;

public class MemberController {

//	private MemberDao dao=new MemberDao();
	private MemberService service=new MemberService();
	
	public void mainMenu() {
		new MainView().mainMenu();
	}
	
	public void searchAll() {
		List<Member> members=service.searchAll();
		
		new MainView().printMembers(members);
	}
	public void searchName() {
		String name=new MainView().searchData("이름");
		List<Member> members=service.searchName(name);
		new MainView().printMembers(members);
	}
	public void searchId() {
		String id=new MainView().searchData("아이디");
		Member m=service.searchId(id);
		new MainView().printMember(m);
		
	}
	public void insertMember() {
		Member m=new MainView().inputMembers();
		int result=service.insertMember(m);
		new MainView().printMsg(result>0?"회원가입성공":"회원가입실패");
	}
	public void updateMember() {
		
	}
	public void deleteMember() {
		String id=new MainView().searchData("삭제할 아이디");
		int result=service.deleteMember(id);
		new MainView().printMsg(result>0?"정상적으로 삭제되었습니다":"삭제실패");
		
		
	}
}
