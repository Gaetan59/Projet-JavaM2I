package com.formation.virgin.model.dao.impl;

import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

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
		
		final Client client = new Client();
		client.setNom("Dupond");
		client.setPrenom("Jean");
		client.setNaissance(new  SimpleDateFormat("dd/mm/yyyy", Locale.FRANCE).parse("20/02/1980"));
		client.setAdresse("20, rue des pommiers, Lille");
		client.setEmail("jdupond@gmail.com");
		
		final Boolean b1 = clientDao.create(client);
		Assert.assertTrue(b1);
		
		final Boolean b2 = clientDao.create(null);
		Assert.assertTrue(b2);
		
	}

	@Test
	public void TestDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void TestUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void TestFind() {
		fail("Not yet implemented");
	}

}
