package com.formation.virgin.model.dao.impl;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.formation.virgin.model.dao.ArtisteDAO;
import com.formation.virgin.model.entity.Artiste;

@Repository
public class ArtisteDAOImplJPA implements ArtisteDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean create(Artiste obj) throws SQLException {
		if (obj == null) {
			return false;
		}
		em.persist(obj);
		return true;
	}

	@Override
	public boolean delete(Artiste obj) throws SQLException {
		if (obj == null) {
			return false;
		}
		em.remove(obj);
		return true;
	}

	@Override
	public boolean update(Artiste obj) throws SQLException {
		if (obj == null) {
			return false;
		}
		em.merge(obj);
		return true;
	}

	@Override
	public Artiste find(Integer id) throws SQLException {
		if (id == null) {
			return null;
		}
		return em.find(Artiste.class, id);
	}

}
