package com.formation.virgin.model.manager.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.virgin.model.dao.ArticleDAO;
import com.formation.virgin.model.dao.ClientDAO;
import com.formation.virgin.model.dao.CommandeDAO;
import com.formation.virgin.model.dao.LigneCommandeDAO;
import com.formation.virgin.model.entity.Article;
import com.formation.virgin.model.entity.Client;
import com.formation.virgin.model.entity.Commande;
import com.formation.virgin.model.entity.LigneCommande;
import com.formation.virgin.model.manager.MagasinManager;

@Service
public class MagasinManagerImpl implements MagasinManager {

	@Autowired
	/** The client dao. */
	private ClientDAO clientDao;

	@Autowired
	/** The compte dao. */
	private CommandeDAO commandeDao;

	@Autowired
	/** The argent dao. */
	private ArticleDAO articleDao;

	@Autowired
	/** The ligne commande dao. */
	private LigneCommandeDAO ligneCommandeDao;

	/**
	 * Instantiates a new magasin manager impl.
	 */
	public MagasinManagerImpl() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.magasin.model.service.MagasinManager#addCommande(com
	 * .formation .magasin.model.entity.Commande)
	 */
	@Override
	@Transactional(readOnly = false)
	public Boolean addCommande(final Commande commande) {
		if (commande.getClient() == null) {
			return Boolean.FALSE;
		}
		try {
			// Verification
			for (final LigneCommande ligne : commande.getLignesCommande()) {
				if (ligne.getArticle() == null
						|| articleDao.find(ligne.getArticle().getId()) == null) {
					return Boolean.FALSE;
				}
			}
			// sauvegarde
			commandeDao.create(commande);
			for (final LigneCommande ligne : commande.getLignesCommande()) {
				ligneCommandeDao.create(ligne);
			}
		} catch (final SQLException e) {
			e.printStackTrace();
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.magasin.model.service.MagasinManager#removeCommande
	 * (com. formation.magasin.model.entity.Commande)
	 */
	@Override
	@Transactional(readOnly = false)
	public Boolean removeCommande(final Commande commande) {
		try {
			for (final LigneCommande ligne : commande.getLignesCommande()) {
				ligneCommandeDao.delete(ligne);
			}
			commandeDao.delete(commande);
		} catch (final SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.magasin.model.service.MagasinManager#addClient(com.
	 * formation .magasin.model.entity.Client)
	 */
	@Override
	@Transactional(readOnly = false)
	public Boolean addClient(final Client client) {
		try {
			// Verification
			if (client == null) {
				return Boolean.FALSE;
			}
			for (final Commande commande : client.getCommande()) {
				if (commande.getLignesCommande() == null) {
					return Boolean.FALSE;
				}
				for (final LigneCommande ligne : commande.getLignesCommande()) {
					if (ligne.getArticle() == null
							|| articleDao.find(ligne.getArticle().getId()) == null) {
						return Boolean.FALSE;
					}
				}
			}
			// Sauvegarde
			clientDao.create(client);
		} catch (final SQLException e) {
			try {
				clientDao.delete(client);
			} catch (final SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return Boolean.FALSE;
		}

		return Boolean.TRUE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.magasin.model.manager.MagasinManager#addArticle(com
	 * .formation .magasin.model.entity.Article)
	 */
	@Override
	@Transactional(readOnly = false)
	public Boolean addArticle(final Article article) {
		try {
			articleDao.create(article);
		} catch (final SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.magasin.model.manager.MagasinManager#getClients()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Client> getClients() {
		return clientDao.findAll();
	}

	@Override
	public List<Commande> getListeCommande() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client getClient(final Integer clientId) {
		if (clientId == null) {
			return null;
		}
		try {
			return clientDao.find(clientId);
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional(readOnly = false)
	public void updateClient(final Client client) {
		try {
			clientDao.update(client);
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	@Transactional(readOnly = false)
	public void removeClient(final Integer clientId) {
		try {
			final Client client = clientDao.find(clientId);
			if (client == null) {
				throw new IllegalArgumentException();
			}
			clientDao.delete(client);
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Article> getArticles() {
		// TODO Auto-generated method stub
		return null;
	}

}
