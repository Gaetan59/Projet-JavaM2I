package com.formation.virgin.model.dao.impl;

import java.sql.SQLException;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.formation.virgin.model.dao.LigneCommandeDAO;
import com.formation.virgin.model.entity.Article;
import com.formation.virgin.model.entity.LigneCommande;

@RunWith(MockitoJUnitRunner.class)
public class LigneCommandeDAOImplJPATest {

	@Mock
	private final EntityManager em = Mockito.mock(EntityManager.class);

	@InjectMocks
	private final LigneCommandeDAO ligneCommandeDao = new LigneCommandeDAOImplJPA();

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreate() throws SQLException {
		final LigneCommande obj1 = new LigneCommande();
		obj1.setQuantite(12);
		obj1.getArticle();
		final Boolean c1 = ligneCommandeDao.create(obj1);
		Assert.assertTrue(c1);

	}

	@Test
	public void testDelete() throws SQLException {
		final LigneCommande obj1 = new LigneCommande();
		obj1.setQuantite(12);
		obj1.getArticle();
		final Boolean c1 = ligneCommandeDao.delete(obj1);
		Assert.assertTrue(c1);
	}

	@Test
	public void testUpdate() throws SQLException {
		final LigneCommande obj1 = new LigneCommande();
		obj1.setQuantite(12);
		obj1.getArticle();
		final Boolean c1 = ligneCommandeDao.update(obj1);
		Assert.assertTrue(c1);
	}

	@Test
	public void testFind() throws SQLException {
		final LigneCommande obj1 = new LigneCommande(new Article(), 13);
		Mockito.when(em.find(LigneCommande.class, 1)).thenReturn(obj1);
		final LigneCommande ligneCommandeFind = ligneCommandeDao.find(1);
		Assert.assertEquals(obj1, ligneCommandeFind);
		Assert.assertNotNull(ligneCommandeFind);
	}

}