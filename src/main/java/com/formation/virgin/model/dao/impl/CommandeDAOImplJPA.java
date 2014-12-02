package com.formation.virgin.model.dao.impl;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.formation.virgin.model.dao.CommandeDAO;
import com.formation.virgin.model.entity.Commande;

@Repository
public class CommandeDAOImplJPA implements CommandeDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean create(Commande obj) throws SQLException {
		if (obj == null) {
			return false;
		}
		em.persist(obj);
		return true;
	}

	@Override
	public boolean delete(Commande obj) throws SQLException {
		if (obj == null) {
			return false;
		}
		em.remove(obj);
		return true;
	}

	@Override
	public boolean update(Commande obj) throws SQLException {
		if (obj == null) {
			return false;
		}
		em.merge(obj);
		return true;
	}

	@Override
	public Commande find(Integer id) throws SQLException {
		if (id == null) {
			return null;
		}
		return em.find(Commande.class, id);
	}

}
