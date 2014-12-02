package com.formation.virgin.model.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.formation.virgin.model.dao.ClientDAO;
import com.formation.virgin.model.entity.Client;

@Repository
public class ClientDAOImplJPA implements ClientDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean create(final Client obj) throws SQLException {
		if (obj == null) {
			return false;
		}
		em.persist(obj);
		return true;

	}

	@Override
	public boolean delete(final Client obj) throws SQLException {
		if (obj == null) {
			return false;
		}
		em.remove(obj);
		return true;
	}

	@Override
	public boolean update(final Client obj) throws SQLException {
		if (obj == null) {
			return false;
		}
		em.merge(obj);
		return true;
	}

	@Override
	public Client find(final Integer id) throws SQLException {
		if (id == null) {
			return null;
		}
		return em.find(Client.class, id);
	}

	@Override
	public List<Client> findAll() {
		final CriteriaBuilder builder = em.getCriteriaBuilder();
		final CriteriaQuery<Client> cq = builder.createQuery(Client.class);
		final Root<Client> root = cq.from(Client.class);
		cq.select(root);
		return em.createQuery(cq).getResultList();
	}

}
