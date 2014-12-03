
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

import com.formation.virgin.model.dao.TitreDAO;
import com.formation.virgin.model.entity.Titre;

@RunWith(MockitoJUnitRunner.class)
public class TitreDAOImplJPATest {

	@Mock
	private final EntityManager em = Mockito.mock(EntityManager.class);

	@InjectMocks
	private final TitreDAO titreDAO = new TitreDAOImplJPA();

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void testCreate() throws SQLException {
		final Titre track = new Titre();

		track.setTrack("Again");
		track.setAnnee(1998);
		Boolean t1 = titreDAO.create(track);
		Assert.assertTrue(t1);


	}

	@Test
	public void testDelete() throws SQLException {
		final Titre track = new Titre();

		track.setTrack("Again");
		track.setAnnee(1998);

		Boolean t1 = titreDAO.delete(track);
		Assert.assertTrue(t1);


	}

	@Test
	public void testUpdate() throws SQLException {
		final Titre track = new Titre();
		track.setTrack("Again");
		track.setAnnee(1998);
		Boolean t1 = titreDAO.update(track);
		Assert.assertTrue(t1);
	}

	@Test
	public void testFind() throws SQLException {
		final Titre track = new Titre();
		Mockito.when(em.find(Titre.class, 2)).thenReturn(track);
		final Titre titreFind = titreDAO.find(2);
		Assert.assertEquals(track, titreFind);

	}

	@Test
	public void testFindByTrack() throws SQLException {
		final Titre track = new Titre();
		Mockito.when(em.find(Titre.class, 2)).thenReturn(track);
		final Titre titreFind = titreDAO.find(2);
		Assert.assertEquals(track, titreFind);

	}

}
