package com.formation.virgin.model.dao;

import java.sql.SQLException;

import com.formation.virgin.model.entity.LigneCommande;

public interface LigneCommandeDAO extends DAO<LigneCommande> {

	LigneCommande find(Integer id) throws SQLException;

}
