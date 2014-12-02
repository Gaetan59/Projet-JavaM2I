package com.formation.virgin.model.dao.impl;

import java.sql.SQLException;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.formation.virgin.model.dao.AlbumDAO;
import com.formation.virgin.model.entity.Album;

@RunWith(MockitoJUnitRunner.class)
public class AlbumDAOImplJPATest {

	@Mock
	private final EntityManager em = Mockito.mock(EntityManager.class);

	@InjectMocks
	private final AlbumDAO albumDAO = new AlbumDAOImplJPA();

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCreate() throws SQLException {
		final Boolean albumNull = albumDAO.create(null);
		Assert.assertFalse(albumNull);

		final Boolean albumCreate = albumDAO.create(new Album());
		Assert.assertTrue(albumCreate);
	}

	@Test
	public void testDelete() throws SQLException {
		final Boolean albumDelete = albumDAO.delete(new Album());
		Assert.assertTrue(albumDelete);
	}

	@Test
	public void testUpdate() throws SQLException {
		final Boolean albumUpdate = albumDAO.update(new Album());
		Assert.assertTrue(albumUpdate);
	}

	@Test
	public void testFind() throws SQLException {
		final Album album1 = new Album("nom d'album", 2010);
		Mockito.when(em.find(Album.class, 1)).thenReturn(album1);
		final Album albumFind = albumDAO.find(1);
		Assert.assertNotNull(albumFind);
		Assert.assertEquals(album1, albumFind);
	}

}
