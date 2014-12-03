package com.formation.virgin.manager.test;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.virgin.model.entity.Album;
import com.formation.virgin.model.entity.Article;
import com.formation.virgin.model.entity.Client;
import com.formation.virgin.model.entity.Commande;
import com.formation.virgin.model.entity.LigneCommande;
import com.formation.virgin.model.manager.MagasinManager;

/**
 * The Class MagasinManagerImplTest.
 */

public class ITMagasinManagerImplTest {

	/** The magasin manager. */
	private MagasinManager magasinManager;

	/**
	 * Sets the up.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Before
	public void setUp() throws Exception {

		final ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring_test.xml");

		magasinManager = (MagasinManager) ctx.getBean("magasinManagerImpl");
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test add client.
	 *
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ParseException
	 */
	@Test
	public void testAddClient() throws SQLException, ParseException {

		final Client client = new Client("Patsou", "Jay", new SimpleDateFormat(
				"dd/mm/yyyy", Locale.FRANCE).parse("20/03/1984"),
				"impasse de la Haute Borne, 59000 Lille", "monmail@mail.fr");

		final Commande commande = new Commande();
		final Article article1 = new Album("OK Computer", 2);
		final Article article2 = new Album("In Rainbow", 3);
		magasinManager.addArticle(article1);
		magasinManager.addArticle(article2);
		final LigneCommande ligne1 = new LigneCommande(article1, 1);
		final LigneCommande ligne2 = new LigneCommande(article2, 2);

		commande.addLigneCommande(ligne1);
		commande.addLigneCommande(ligne2);
		client.addCommande(commande);

		final Boolean b1 = magasinManager.addClient(client);
		Assert.assertTrue(b1);

		final Boolean b2 = magasinManager.addClient(null);
		Assert.assertFalse(b2);
	}

}
