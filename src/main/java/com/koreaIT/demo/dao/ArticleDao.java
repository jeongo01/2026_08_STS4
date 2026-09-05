package com.koreaIT.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.koreaIT.demo.vo.Article;

@Mapper
public interface ArticleDao {
	
	// 돌려받을 데이터가 없기 때문에 void
	@Insert("""
			INSERT INTO article
				SET regDate = NOW()
					, updateData = NOW()
					, memberId = {memberId};
					, title = #{title}
					, `body` = #{body}
			
			""")
	public void writeArticle(int memberId, String title, String body);

	@Select("""
			SELECT *
			    FROM article
			    WHERE id = #{id}
			""")
	public Article getArticleById(int id);

	@Update("""
			<script>
				UPDATE article
					SET updateDate = NOW()
						<if test="title != null and title !=''">
							, title = #{title}
						</if>
						<if test = "body != null and body != ''">
						, `body` = #{body}
						</if>
					WHERE id = #{id}
			</script>
			""")
	public void modifyArticle(int id, String title, String body);

	@Delete("""
			SELECT *
				FROM article
				WHERE id = #{id}
			""")
	public void deleteArticle(int id);

	@Select("""
			SELECT A.*, nickname AS writerName
			    FROM article AS A
			    INNER JOIN `member` AS M
			    ON A.memberId = M.id
			    ORDER BY id DESC
			""")
	public List<Article> getArticles();

	
	// 데이터 조회용 메서드
	// DB에 PK값 요청
	@Select("""
			SELECT *
				FROM article
				LAST_INSERT_ID()
			""")
	public int getLastInsertId();

	@Select("""
			SELECT A.*, nickname AS writerName
				FROM article AS A
				INNER JOIN `member` AS M
				ON A.memberId = M.id 
			""")
	public Article forPrintArticle(int id);
	
}
