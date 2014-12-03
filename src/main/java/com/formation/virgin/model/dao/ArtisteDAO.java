package com.formation.virgin.model.dao;

import java.sql.SQLException;

import com.formation.virgin.model.entity.Artiste;

public interface ArtisteDAO extends DAO<Artiste> {

	Artiste find(Integer id) throws SQLException;

}
