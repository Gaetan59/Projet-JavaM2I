package com.formation.virgin.model.dao;

import java.sql.SQLException;

import com.formation.virgin.model.entity.Commande;

public interface CommandeDAO extends DAO<Commande> {

	Commande find(Integer id) throws SQLException;

}
