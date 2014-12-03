package com.formation.virgin.model.dao;

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

import com.formation.virgin.model.entity.PrixSupport;

@RunWith(MockitoJUnitRunner.class)
public class PrixSupportDAOImplJPATest {

	@Mock
	private final EntityManager em = Mockito.mock(EntityManager.class);

	@InjectMocks
	private PrixSupportDAO pdao;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCreate() throws SQLException {
		final PrixSupport p1 = new PrixSupport();

		Boolean creation = pdao.create(p1);
		Assert.assertTrue(creation);

	}

	@Test
	public void testDelete() throws SQLException {
		final PrixSupport p1 = new PrixSupport();

		Boolean supprimer = pdao.delete(p1);
		Assert.assertTrue(supprimer);

	}

	@Test
	public void testUpdate() throws SQLException {
		final PrixSupport p1 = new PrixSupport();


		Boolean miseajour = pdao.update(p1);
		Assert.assertTrue(miseajour);

	}

	@Test
	public void testFind() throws SQLException {
		final PrixSupport p1 = new PrixSupport();
		Mockito.when(em.find(PrixSupport.class, 2)).thenReturn(p1);
		PrixSupport p1Find = pdao.find(2);
		Assert.assertEquals(p1, p1Find);


	}

}
