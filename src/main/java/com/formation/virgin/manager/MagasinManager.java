package com.formation.virgin.manager;

import java.util.List;

import com.formation.virgin.entity.Article;
import com.formation.virgin.entity.Client;
import com.formation.virgin.entity.Commande;

public class MagasinManager {

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
