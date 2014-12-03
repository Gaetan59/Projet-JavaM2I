package com.formation.virgin.model.dao.impl;

import static org.junit.Assert.fail;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.formation.virgin.model.dao.LigneCommandeDAO;
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
	public void testCreate() {
		final LigneCommande obj1 = new LigneCommande();

	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testFind() {
		fail("Not yet implemented");
	}

}