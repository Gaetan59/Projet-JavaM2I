package com.formation.virgin.model.dao;

import java.sql.SQLException;

public interface DAO<T> {

	/**
	 * M�thode de cr�ation.
	 *
	 * @param obj
	 *            the obj
	 * @return boolean
	 * @throws SQLException
	 *             the SQL exception
	 */
	public abstract boolean create(T obj) throws SQLException;

	/**
	 * M�thode pour effacer.
	 *
	 * @param obj
	 *            the obj
	 * @return boolean. true si la suppression � eut lien, false sinon
	 * @throws SQLException
	 *             the SQL exception
	 */
	public abstract boolean delete(T obj) throws SQLException;

	/**
	 * M�thode de mise � jour.
	 *
	 * @param obj
	 *            the obj
	 * @return boolean
	 * @throws SQLException
	 *             the SQL exception
	 */
	public abstract boolean update(T obj) throws SQLException;

	/**
	 * M�thode de recherche des informations.
	 *
	 * @param album
	 *            the id
	 * @return T
	 * @throws SQLException
	 *             the SQL exception
	 */

}
