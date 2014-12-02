package com.formation.virgin.model.dao.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.formation.virgin.model.entity.Artiste;

public class ArtisteDAOImplJPATest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCreate() {

		Artiste obj1 = new Artiste(1, "Nom 1");
		Assert.assertTrue(true);
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
