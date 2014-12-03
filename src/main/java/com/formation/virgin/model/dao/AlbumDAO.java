package com.formation.virgin.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.formation.virgin.model.entity.Album;

public interface AlbumDAO extends DAO<Album> {

	List<Album> findByTitre(String titre);

	Album find(Integer id) throws SQLException;

}
