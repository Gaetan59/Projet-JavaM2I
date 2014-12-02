package com.formation.virgin.model.manager;

import java.util.List;

import com.formation.virgin.model.entity.Article;
import com.formation.virgin.model.entity.Client;
import com.formation.virgin.model.entity.Commande;

public interface MagasinManager {

	public Boolean addArticle(Article article);

	public List<Client> getClients();

	public Boolean addClient(Client client);

	public Boolean addCommande(Commande commande);

	public Boolean removeCommande(Commande commande);

	public List<Commande> getListeCommande();

	public Client getClient(Integer clientId);

	public void updateClient(Client client);

	void removeClient(Integer clientId);

}
