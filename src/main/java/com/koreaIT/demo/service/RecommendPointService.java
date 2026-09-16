package com.koreaIT.demo.service;

import org.springframework.stereotype.Service;

import com.koreaIT.demo.dao.RecommendPointDao;
import com.koreaIT.demo.vo.RecommendPoint;

@Service
public class RecommendPointService {
	
	private RecommendPointDao recommendPointDao;
	
	public RecommendPointService(RecommendPointDao recommendPointDao) {
		this.recommendPointDao = recommendPointDao;
	}

	public void insertPoint(int memberId, String relTypeCode, int relId) {
		recommendPointDao.insertPoint(memberId, relTypeCode, relId);
	}

	public void deletePoint(int loginedMemberId, String relTypeCode, int id) {
		recommendPointDao.deletePoint(loginedMemberId, relTypeCode, id);
	}

	public RecommendPoint getRecommendPoint(int loginedMemberId, String relTypeCode, int relId) {
		return recommendPointDao.getRecommendPoint(loginedMemberId, relTypeCode, relId);
	}
}
