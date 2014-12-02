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

import com.formation.virgin.model.dao.ArtisteDAO;
import com.formation.virgin.model.entity.Artiste;

@RunWith(MockitoJUnitRunner.class)
public class ArtisteDAOImplJPATest {

	@Mock
	private final EntityManager em = Mockito.mock(EntityManager.class);

	@InjectMocks
	private final ArtisteDAO artisteDao = new ArtisteDAOImplJPA();

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCreate() throws SQLException {

		final Artiste obj1 = new Artiste();
		obj1.setNom("nom");
		final Boolean c = artisteDao.create(obj1);
		Assert.assertTrue(c);
	}

	@Test
	public void testDelete() throws SQLException {

		final Artiste obj1 = new Artiste();
		obj1.setNom("nom");
		final Boolean d = artisteDao.delete(obj1);
		Assert.assertTrue(d);
	}

	@Test
	public void testUpdate() throws SQLException {

		final Artiste obj1 = new Artiste();
		obj1.setNom("nom");
		final Boolean u = artisteDao.update(obj1);
		Assert.assertTrue(u);
	}

	@Test
	public void testFind() throws SQLException {
		final Artiste obj1 = new Artiste();
		Mockito.when(em.find(Artiste.class, 1)).thenReturn(obj1);
		final Artiste artisteFind = artisteDao.find(1);
		Assert.assertEquals(obj1, artisteFind);
		Assert.assertNotNull(obj1);

	}

}
