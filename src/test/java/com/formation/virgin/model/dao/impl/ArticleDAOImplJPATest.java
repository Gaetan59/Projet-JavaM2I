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

import com.formation.virgin.model.dao.ArticleDAO;
import com.formation.virgin.model.entity.Article;

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

		final Boolean articleNull = articleDAO.create(null);
		Assert.assertFalse(articleNull);

		final Boolean articleCreate = articleDAO.create(new Article());
		Assert.assertTrue(articleCreate);
	}

	@Test
	public void testDelete() throws SQLException {
		final Boolean articleDelete = articleDAO.delete(new Article());
		Assert.assertTrue(articleDelete);
	}

	@Test
	public void testUpdate() throws SQLException {
		final Boolean articleUpdate = articleDAO.update(new Article());
		Assert.assertTrue(articleUpdate);
	}

	@Test
	public void testFind() throws SQLException {
		final Article article1 = new Article("test");
		Mockito.when(em.find(Article.class, 1)).thenReturn(article1);
		final Article articleFind = articleDAO.find(1);
		Assert.assertNotNull(articleFind);
		Assert.assertEquals(article1, articleFind);
	}

}
