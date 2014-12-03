package com.formation.virgin.model.dao;

import java.sql.SQLException;

import com.formation.virgin.model.entity.PrixSupport;

public interface PrixSupportDAO extends DAO<PrixSupport> {

	PrixSupport find(Integer id) throws SQLException;

}
