package com.koreaIT.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreaIT.demo.service.RecommendPointService;
import com.koreaIT.demo.util.Util;
import com.koreaIT.demo.vo.RecommendPoint;
import com.koreaIT.demo.vo.ResultData;
import com.koreaIT.demo.vo.Rq;

@Controller
public class UsrRecommendPointController {
	private RecommendPointService recommendPointService;
	private Rq rq;
	
	public UsrRecommendPointController(RecommendPointService recommendPointService, Rq rq) {
		this.recommendPointService = recommendPointService;
		this.rq = rq;
	}
	
	@RequestMapping("/usr/recommendPoint/insertPoint")
	@ResponseBody
	public String insertPoint(String relTypeCode, int id) {
		recommendPointService.insertPoint(rq.getLoginedMemberId(), relTypeCode, id);
		return Util.jsReplace("좋아요 성공", Util.f("../article/detail?id=%d", id));
	}
	
	@RequestMapping("/usr/recommendPoint/deletePoint")
	@ResponseBody
	public String deletePoint(String relTypeCode, int id) {
		recommendPointService.deletePoint(rq.getLoginedMemberId(), relTypeCode, id);
		return Util.jsReplace("좋아요 취소 성공", Util.f("../article/detail?id=%d", id));
	}
	
	@RequestMapping("/usr/recommendPoint/getRecommendPoint")
	@ResponseBody
	public ResultData<RecommendPoint> getRecommendPoint(String relTypeCode, int relId) {
		RecommendPoint recommendPoint = recommendPointService.getRecommendPoint(rq.getLoginedMemberId(), relTypeCode, relId);
		return ResultData.from("S-1", "좋아요 조회", recommendPoint);
	}
}
