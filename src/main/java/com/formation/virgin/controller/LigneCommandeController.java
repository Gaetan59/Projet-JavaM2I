package com.formation.virgin.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.formation.virgin.entity.Client;
import com.formation.virgin.entity.Commande;
import com.formation.virgin.manager.MagasinManager;

public class LigneCommandeController {

	@Controller
	@RequestMapping("/ligneCommande")
	public class LigneCommandeControler {

		@RequestMapping(value = "/{clientId}/{commandeId}", method = RequestMethod.GET)
		public String printCommande(@PathVariable("clientId") Integer clientId,
				@PathVariable("commandeId") Integer commandeId, ModelMap model) {
			final ApplicationContext ctx = new ClassPathXmlApplicationContext(
					"spring.xml");

			final MagasinManager magasinManager = MagasinManager
					.getBean("magasinManagerImpl");

			Client client;
			try {
				client = magasinManager.getClient(clientId);
				final List<Commande> listCommande = client.getCommande();
				for (final Commande commande : listCommande) {
					if (commande.getId() == commandeId) {
						model.addAttribute("lignescommandes",
								commande.getLignesCommande());

						break;
					}
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}

			return "ligneCommande";

		}
	}

}
