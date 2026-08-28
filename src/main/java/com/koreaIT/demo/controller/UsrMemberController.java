package com.koreaIT.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreaIT.demo.service.MemberService;
import com.koreaIT.demo.util.Util;
import com.koreaIT.demo.vo.Member;

@Controller
public class UsrMemberController {
	private MemberService memberService;
	
	public UsrMemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping("usr/member/join")
	@ResponseBody
	public Object doJoin(String loginId, String loginPw, String nickname, String name, String cellphoneNum, String email) {
		
		if(Util.empty(loginId)) {
			return "다시 입력하시오.";
		}
		
		if(Util.empty(loginPw)) {
			return "다시 입력하시오.";
		}
		
		if(Util.empty(nickname)) {
			return "다시 입력하시오.";
		}
		
		if(Util.empty(name)) {
			return "다시 입력하시오.";
		}
		
		if(Util.empty(cellphoneNum)) {
			return "다시 입력하시오.";
		}
		
		if(Util.empty(email)) {
			return "다시 입력하시오.";
		}
		
		Member member = memberService.getMemberByLoginId(loginId);
		
		if(member != null) {
			return loginId + "은(는) 현재 사용중인 아이디입니다.";
		}
		
		memberService.joinMember(loginId, loginPw, nickname, name, cellphoneNum, email);
		
		int id = memberService.getLastInsertId();
		
		return memberService.getMemberById(id);
	}
}
