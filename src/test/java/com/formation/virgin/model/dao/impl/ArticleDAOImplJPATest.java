package com.formation.virgin.model.dao.impl;

import static org.junit.Assert.fail;

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

import com.formation.virgin.model.dao.ArticleDAO;

@RunWith(MockitoJUnitRunner.class)
public class ArticleDAOImplJPATest {

	@Mock
	private final EntityManager em = Mockito.mock(EntityManager.class);

	@InjectMocks
	private final ArticleDAO articleDAO = new ArticleDAOImplJPA();

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCreate() throws SQLException {
		final Boolean b1 = articleDAO.create(null);
		Assert.assertFalse(b1);
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
