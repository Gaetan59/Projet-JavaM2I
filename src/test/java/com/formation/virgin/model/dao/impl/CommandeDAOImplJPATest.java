package com.formation.virgin.model.dao.impl;

import java.sql.SQLException;
import java.util.Date;

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

import com.formation.virgin.model.dao.CommandeDAO;
import com.formation.virgin.model.entity.Client;
import com.formation.virgin.model.entity.Commande;

@RunWith(MockitoJUnitRunner.class)
public class CommandeDAOImplJPATest {
	
	@Mock
	private final EntityManager em = Mockito.mock(EntityManager.class);
	
	@InjectMocks
	private final CommandeDAO commandeDAO = new CommandeDAOImplJPA();
	

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCreate() throws SQLException {
		final Boolean commandeNull = commandeDAO.create(null);
		Assert.assertFalse(commandeNull);

		final Boolean commandeCreate = commandeDAO.create(new Commande());
		Assert.assertTrue(commandeCreate);
	}

	@Test
	public void testDelete() throws SQLException {
		final boolean commandeDelete = commandeDAO.delete(new Commande());
		Assert.assertTrue(commandeDelete);
	}

	@Test
	public void testUpdate() throws SQLException {
		final Boolean commandeUpdate = commandeDAO.update(new Commande());
		Assert.assertTrue(commandeUpdate);
	}

	@Test
	public void TestFind() throws SQLException {
		final Commande commande1 = new Commande(new Client(), new Date());
		Mockito.when(em.find(Commande.class, 1)).thenReturn(commande1);
		final Commande commandeFind = commandeDAO.find(1);
		Assert.assertNotNull(commandeFind);
		Assert.assertEquals(commande1, commandeFind);
	}

}
