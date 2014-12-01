package com.formation.virgin.dao.impl;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.formation.virgin.dao.ClientDAO;
import com.formation.virgin.entity.Client;

@Repository
public class ClientDAOImplJPA implements ClientDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean create(Client obj) throws SQLException {
		if (obj == null) {
			return false;
		}
		em.persist(obj);
		return true;

	}

	@Override
	public boolean delete(Client obj) throws SQLException {
		if (obj == null) {
			return false;
		}
		em.remove(obj);
		return true;
	}

	@Override
	public boolean update(Client obj) throws SQLException {
		if (obj == null) {
			return false;
		}
		em.merge(obj);
		return true;
	}

	@Override
	public Client find(Integer id) throws SQLException {
		if (id == null) {
			return null;
		}
		return em.find(Client.class, id);
	}

}
