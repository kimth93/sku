package kr.ac.skuniv.guestbook.service;

import java.util.List;

import javax.servlet.RequestDispatcher;

import kr.ac.skuniv.guestbook.dao.MemberDAO;
import kr.ac.skuniv.guestbook.dto.Member;

public class MemberService {
	MemberDAO dao = new MemberDAO();
	
	public boolean login(String id, String password) {
		boolean loginFlag = false;
		Member member = dao.getMember(id);
		if(member != null && member.getPassword().equals(password)) {
			loginFlag = true;
		}
		
		return loginFlag;
		
	}
	
	public boolean memberJoin(Member member) {
		//Member 데이터를 얻어와서 회원가입 하기 위해
		//필요한 로직이 존재한다면 여기에서 수행함
		
		//DB에 저장할 정보가 있다면 저장
		boolean resultFlag = dao.addMember(member);
		
		
		return resultFlag;
		
		
	}
	
	public List<Member> getMemberList() {
		
		return dao.getMemberList();
		
		
	}
	
	public void deleteMember(String id) {
		//삭제하기 전에 수행할 로직이 있다면 여기서 수행
		dao.deleteMember(id);
		
	}
	
	public Member getMember(String id) {
		return dao.getMember(id);
	}
	
	public void updateMember(Member member) {
		dao.updateMember(member);
	}
}
