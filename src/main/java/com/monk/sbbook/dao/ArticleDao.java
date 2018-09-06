package com.monk.sbbook.dao;

import com.monk.sbbook.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ArticleDao{
//    @Query("update LoginTicket u set u.status=?1 where u.ticket=?2")

//    JPA自带接口
//    int insertArticle(Article article);

//    Article selectById(int id);

    List<Article> selectLatestArticles(int offset, int limit);

    List<Article> selectArticlesByCategory(String category, int offset, int limit);

    int getArticleCountByCategory(String category);

    int getArticleCount();

    void updateCommentCount(int questionId, int commentCount);

    void deleteById(int id);
}
