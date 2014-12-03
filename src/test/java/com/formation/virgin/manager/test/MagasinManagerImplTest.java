package com.formation.virgin.manager.test;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.virgin.model.dao.AlbumDAO;
import com.formation.virgin.model.dao.ArticleDAO;
import com.formation.virgin.model.dao.ArtisteDAO;
import com.formation.virgin.model.dao.ClientDAO;
import com.formation.virgin.model.dao.CommandeDAO;
import com.formation.virgin.model.dao.LigneCommandeDAO;
import com.formation.virgin.model.dao.PrixSupportDAO;
import com.formation.virgin.model.dao.TitreDAO;
import com.formation.virgin.model.entity.Album;
import com.formation.virgin.model.entity.Article;
import com.formation.virgin.model.entity.Client;
import com.formation.virgin.model.entity.Commande;
import com.formation.virgin.model.entity.LigneCommande;
import com.formation.virgin.model.manager.MagasinManager;

/**
 * The Class MagasinManagerImplTest.
 */
@RunWith(MockitoJUnitRunner.class)
public class MagasinManagerImplTest {

	/** The magasin manager. */
	private MagasinManager magasinManager;

	@Mock
	private final AlbumDAO albumDao = Mockito.mock(AlbumDAO.class);

	@Mock
	private final ArticleDAO articleDao = Mockito.mock(ArticleDAO.class);

	@Mock
	private final ArtisteDAO artisteDao = Mockito.mock(ArtisteDAO.class);

	@Mock
	private final ClientDAO clientDao = Mockito.mock(ClientDAO.class);

	@Mock
	private final CommandeDAO commandeDao = Mockito.mock(CommandeDAO.class);

	@Mock
	private final LigneCommandeDAO ligneCommandeDao = Mockito
			.mock(LigneCommandeDAO.class);

	@Mock
	private final PrixSupportDAO prixSupportDao = Mockito
			.mock(PrixSupportDAO.class);

	@Mock
	private final TitreDAO titreDao = Mockito.mock(TitreDAO.class);

	/**
	 * Sets the up.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		// clientDao = Mockito.mock(ClientDAO.class);
		// commandeDao = Mockito.mock(CommandeDAO.class);
		// articleDao = Mockito.mock(ArticleDAO.class);
		// ligneCommandeDao = Mockito.mock(LigneCommandeDAO.class);

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

		final LigneCommande ligne1 = new LigneCommande(article1, 1);
		final LigneCommande ligne2 = new LigneCommande(article2, 2);

		commande.addLigneCommande(ligne1);
		commande.addLigneCommande(ligne2);
		client.addCommande(commande);

		Mockito.when(clientDao.create(Matchers.any(Client.class))).thenReturn(
				Boolean.TRUE);
		Mockito.when(commandeDao.create(Matchers.any(Commande.class)))
				.thenReturn(Boolean.TRUE);
		Mockito.when(articleDao.create(Matchers.any(Article.class)))
				.thenReturn(Boolean.TRUE);
		Mockito.when(articleDao.find(1)).thenReturn(article1);
		Mockito.when(articleDao.find(2)).thenReturn(article2);
		Mockito.when(ligneCommandeDao.create(Matchers.any(LigneCommande.class)))
				.thenReturn(Boolean.TRUE);

		final Boolean b1 = magasinManager.addClient(client);
		Assert.assertTrue(b1);

		final Boolean b2 = magasinManager.addClient(null);
		Assert.assertFalse(b2);
	}
}
