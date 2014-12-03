package com.formation.virgin.model.dao.impl;

import java.sql.SQLException;
import java.text.ParseException;
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

import com.formation.virgin.model.dao.ClientDAO;
import com.formation.virgin.model.entity.Client;


@RunWith(MockitoJUnitRunner.class)
public class ClientDAOImplJPATest {
	
	@Mock
	private final EntityManager em = Mockito.mock(EntityManager.class);
	
	@InjectMocks
	private final ClientDAO clientDao = new ClientDAOImplJPA();
	
	

	@Before
	public void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
		
	}

	
	@Test
	public void TestCreate() throws SQLException, ParseException {
		
		final Boolean clientNull = clientDao.create(null);
		Assert.assertFalse(clientNull);

		final Boolean clientCreate = clientDao.create(new Client());
		Assert.assertTrue(clientCreate);
	}

	@Test
	public void TestDelete() throws SQLException, ParseException {
		
		final boolean clientDelete = clientDao.delete(new Client());
		Assert.assertTrue(clientDelete);
	}

	@Test
	public void testUpdate() throws SQLException, ParseException {
		final boolean clientUpdate = clientDao.update(new Client());
		Assert.assertTrue(clientUpdate);
	}

	@Test
	public void testFind() throws SQLException, ParseException {
		
		final Client client = new Client("Dupond", "Jean", new Date(), "12 rue des pommiers, Lille", "jdupond@mail.com");
		Mockito.when(em.find(Client.class, 1)).thenReturn(client);
		final Client clientFind = clientDao.find(1);
		Assert.assertNotNull(clientFind);
		Assert.assertEquals(client, clientFind);
	}

}

