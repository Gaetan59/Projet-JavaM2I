package com.formation.virgin.model.dao;

import java.util.List;

import com.formation.virgin.model.entity.Client;

public interface ClientDAO extends DAO<Client> {


	/**
	 * Find all.
	 *
	 * @return the list
	 */
	List<Client> findAll();

}
