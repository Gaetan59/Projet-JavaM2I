package com.formation.virgin.model.dao.impl;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.formation.virgin.model.dao.LigneCommandeDAO;
import com.formation.virgin.model.entity.LigneCommande;

@Repository
public class LigneCommandeDAOImplJPA implements LigneCommandeDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean create(LigneCommande obj) throws SQLException {
		if (obj == null) {
			return false;
		}
		em.persist(obj);
		return true;
	}

	@Override
	public boolean delete(LigneCommande obj) throws SQLException {
		if (obj == null) {
			return false;
		}
		em.remove(obj);
		return true;
	}

	@Override
	public boolean update(LigneCommande obj) throws SQLException {
		if (obj == null) {
			return false;
		}
		em.merge(obj);
		return true;
	}

	@Override
	public LigneCommande find(Integer id) throws SQLException {
		if (id == null) {
			return null;
		}
		return em.find(LigneCommande.class, id);
	}

}
