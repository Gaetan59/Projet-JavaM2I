package com.formation.virgin.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.formation.virgin.model.entity.Titre;

public interface TitreDAO extends DAO<Titre> {

	List<Titre> findByTrack(String Track);

	Titre find(Integer id) throws SQLException;

}