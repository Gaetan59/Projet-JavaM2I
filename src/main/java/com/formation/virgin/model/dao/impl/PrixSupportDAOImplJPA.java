package com.formation.virgin.model.dao.impl;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.formation.virgin.model.dao.PrixSupportDAO;
import com.formation.virgin.model.entity.PrixSupport;

@Repository
public class PrixSupportDAOImplJPA implements PrixSupportDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean create(PrixSupport obj) throws SQLException {
		if (obj == null) {
			return false;
		}
		em.persist(obj);
		return true;
	}

	@Override
	public boolean delete(PrixSupport obj) throws SQLException {
		if (obj == null) {
			return false;
		}
		em.remove(obj);
		return true;
	}

	@Override
	public boolean update(PrixSupport obj) throws SQLException {
		if (obj == null) {
			return false;
		}
		em.merge(obj);
		return true;
	}

	@Override
	public PrixSupport find(Integer id) throws SQLException {
		if (id == null) {
			return null;
		}
		return em.find(PrixSupport.class, id);
	}

}
