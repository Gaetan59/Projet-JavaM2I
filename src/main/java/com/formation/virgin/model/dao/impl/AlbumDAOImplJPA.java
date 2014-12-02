package com.formation.virgin.model.dao.impl;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.formation.virgin.model.dao.AlbumDAO;
import com.formation.virgin.model.entity.Album;

@Repository
public class AlbumDAOImplJPA implements AlbumDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean create(Album obj) throws SQLException {
		if (obj == null) {
			return false;
		}
		em.persist(obj);
		return true;
	}

	@Override
	public boolean delete(Album obj) throws SQLException {
		if (obj == null) {
			return false;
		}
		em.remove(obj);
		return true;
	}

	@Override
	public boolean update(Album obj) throws SQLException {
		if (obj == null) {
			return false;
		}
		em.merge(obj);
		return true;
	}

	@Override
	public Album find(Integer id) throws SQLException {
		if (id == null) {
			return null;
		}
		return em.find(Album.class, id);
	}

}
