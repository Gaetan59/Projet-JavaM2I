package com.formation.virgin.model.dao;

import java.sql.SQLException;

import com.formation.virgin.model.entity.Article;

public interface ArticleDAO extends DAO<Article> {

	Article find(Integer id) throws SQLException;

}
