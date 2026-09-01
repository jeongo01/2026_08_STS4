package com.koreaIT.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreaIT.demo.service.MemberService;
import com.koreaIT.demo.util.Util;
import com.koreaIT.demo.vo.Member;
import com.koreaIT.demo.vo.ResultData;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsrMemberController {
	private MemberService memberService;
	
	public UsrMemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping("usr/member/join")
	@ResponseBody
	public ResultData<Member> doJoin(String loginId, String loginPw, String nickname, String name, String cellphoneNum, String email) {
		
		if(Util.empty(loginId)) {
			return ResultData.from("F-1", "아이디를 입력해주세요.");
		}
		
		if(Util.empty(loginPw)) {
			return ResultData.from("F-2", "비밀번호를 입력해주세요.");
		}
		
		if(Util.empty(nickname)) {
			return ResultData.from("F-3", "닉네임을 입력해주세요.");
		}
		
		if(Util.empty(name)) {
			return ResultData.from("F-4", "이름을 입력해주세요.");
		}
		
		if(Util.empty(cellphoneNum)) {
			return ResultData.from("F-5", "전화번호를 입력해주세요.");
		}
		
		if(Util.empty(email)) {
			return ResultData.from("F-6", "이메일을 입력해주세요.");
		}
		
		Member member = memberService.getMemberByLoginId(loginId);
		
		if(member != null) {
			return ResultData.from("F-A", loginId + "은(는) 현재 사용중인 아이디입니다.");
		}
		
		memberService.joinMember(loginId, loginPw, nickname, name, cellphoneNum, email);
		
		
		int id = memberService.getLastInsertId();
		
		
		return ResultData.from("S-1", "회원가입 성공", memberService.getMemberById(id));
	}
	
	public String test1(HttpSession session) {
		session.setAttribute("test", "test");
		
		return "session에 값 저장";
	}
	
	public String test2(HttpSession session) {
		if(session.getAttribute("test") != null) {
			return "session불러오기 성공: " + session.getAttribute("test") + " / success";
		}
		
		return "session 불러오기 실패";
	}
}
