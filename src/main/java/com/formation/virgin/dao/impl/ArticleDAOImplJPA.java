package com.formation.virgin.dao.impl;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.formation.virgin.dao.ArticleDAO;
import com.formation.virgin.entity.Article;

@Repository
public class ArticleDAOImplJPA implements ArticleDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean create(Article obj) throws SQLException {
		if (obj == null) {
			return false;
		}
		em.persist(obj);
		return true;
	}

	@Override
	public boolean delete(Article obj) throws SQLException {
		if (obj == null) {
			return false;
		}
		em.remove(obj);
		return true;
	}

	@Override
	public boolean update(Article obj) throws SQLException {
		if (obj == null) {
			return false;
		}
		em.merge(obj);
		return true;
	}

	@Override
	public Article find(Integer id) throws SQLException {
		if (id == null) {
			return null;
		}
		return em.find(Article.class, id);
	}

}
