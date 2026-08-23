package com.koreaIT.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreaIT.demo.vo.Article;

@Controller
public class UsrArticleController {

	private int lastArticleId;
	private List<Article> articles;

	// 생성자
	public UsrArticleController() {
		this.lastArticleId = 0;
		this.articles = new ArrayList<>();
		
		makeTestData();
	}
	
	// 서비스 메서드
	private void makeTestData() {
		for(int i = 0; i < 10; i++) {
			
			String title = "제목" + i;
			String body = "내용" + i;
			
			writeArticle(title, body);
		}	
	}
	
	private Article getArticleById(int id) {
		for(Article article: articles) {
			if(article.getId() == id) {
				return article;
			}
		}
		return null;
	}
	
	private void modifyArticle(Article article, String title, String body) {
		article.setTitle(title);
		article.setBody(body);
	}
	
	private void deleteArticle(Article article) {
		articles.remove(article);		
	}

	private Article writeArticle(String title, String body) {
		
		lastArticleId++;
		
		Article article = new Article(lastArticleId, title, body);
		articles.add(article);
	
		return article;
	}
	
	// 액션 메서드
	@RequestMapping("usr/article/doWrite")
	@ResponseBody
	public Article doWrite(String title, String body) {
		Article article = writeArticle(title, body);
		return article;
	}
	
	@RequestMapping("usr/article/list")
	@ResponseBody
	public List<Article> showList() {
		return articles;
	}
	
	@RequestMapping("usr/article/detail")
	@ResponseBody
	public Object showDetail(int id) {
		Article article = getArticleById(id);
		
		if(article == null) {
			return id + "게시물이 없습니다.";
		}
		
		return article;
	}
	
	@RequestMapping("usr/article/modify")
	@ResponseBody
	public String doModify(int id, String title, String body) {
		Article article = getArticleById(id);
		
		if(article == null) {
			return id + "게시물이 없습니다.";
		}
		
		modifyArticle(article, title, body);
		
		return id + "게시물을 수정했습니다.";
	}
	
	@RequestMapping("usr/article/delete")
	@ResponseBody
	public String doDelete(int id) {
		Article article = getArticleById(id);
		
		if(article == null) {
			return id + "게시물이 없습니다.";
		}
		
		deleteArticle(article);
		
		return id + "게시물을 삭제했습니다.";
	}
}