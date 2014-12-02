package com.formation.virgin.model.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.formation.virgin.model.dao.TitreDAO;
import com.formation.virgin.model.entity.Titre;

@Repository
public class TitreDAOImplJPA implements TitreDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean create(Titre obj) throws SQLException {
		if (obj == null) {
			return false;
		}
		em.persist(obj);
		return true;
	}

	@Override
	public boolean delete(Titre obj) throws SQLException {
		if (obj == null) {
			return false;
		}
		em.remove(obj);
		return true;
	}

	@Override
	public boolean update(Titre obj) throws SQLException {
		if (obj == null) {
			return false;
		}
		em.merge(obj);
		return true;
	}

	@Override
	public Titre find(Integer id) throws SQLException {
		if (id == null) {
			return null;
		}
		return em.find(Titre.class, id);
	}

	@Override
	public List<Titre> findByTrack(String Track) {
		if (Track == null) {
			return null;
		}
		Track = "%" + Track + "%";
		final Query query = em
				.createQuery("select e from Titre as e where upper(e.Titre.Track) LIKE :trackTitre");
		query.setParameter("trackTitre", "%" + Track + "%");
		final List<Titre> listTitre = query.getResultList();
		return listTitre;
	}


}
