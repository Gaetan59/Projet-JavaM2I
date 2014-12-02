package com.formation.virgin.model.dao.impl;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.formation.virgin.model.dao.ArticleDAO;
import com.formation.virgin.model.entity.Article;

@Repository
public class ArticleDAOImplJPA implements ArticleDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean create(final Article obj) throws SQLException {
		if (obj == null) {
			return false;
		}
		em.persist(obj);
		return true;
	}

	@Override
	public boolean delete(final Article obj) throws SQLException {
		if (obj == null) {
			return false;
		}
		em.remove(obj);
		return true;
	}

	@Override
	public boolean update(final Article obj) throws SQLException {
		if (obj == null) {
			return false;
		}
		em.merge(obj);
		return true;
	}

	@Override
	public Article find(final Integer id) throws SQLException {
		if (id == null) {
			return null;
		}
		return em.find(Article.class, id);
	}

}
