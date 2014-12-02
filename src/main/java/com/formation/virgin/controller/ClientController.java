package com.formation.virgin.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.formation.virgin.model.entity.Client;
import com.formation.virgin.model.manager.MagasinManager;

@Controller
@RequestMapping("/client")
public class ClientController {

	private MagasinManager magasinManager;
	private ApplicationContext ctx;

	public void init() {

		ctx = new ClassPathXmlApplicationContext("spring.xml");

		magasinManager = (MagasinManager) ctx.getBean("magasinManagerImpl");
	}

	@RequestMapping(method = RequestMethod.GET)
	public String printClient(final ModelMap model) {
		init();
		final List<Client> list = magasinManager.getClients();
		model.addAttribute("clients", list);
		return "client";

	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String ajouterClients(final ModelMap model) {

		model.addAttribute("client", new Client());
		return "addClient";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String handleForm(@ModelAttribute("client") final Client client,
			final ModelMap model) {
		init();

		if (client != null && client.getNom() != null
				&& !client.getNom().isEmpty() && client.getPrenom() != null
				&& !client.getPrenom().isEmpty()) {

			magasinManager.addClient(client);
			return "redirect:/client";
		}
		model.addAttribute("client", client);
		return "addClient";
	}

	@RequestMapping(value = "/modif/{clientId}", method = RequestMethod.GET)
	public String editClient(@PathVariable("clientId") final Integer clientId,
			final ModelMap model) throws SQLException {
		init();
		final Client client = magasinManager.getClient(clientId);
		model.addAttribute("client", client);
		return "modif";
	}

	@RequestMapping(value = "/modif/{clientId}", method = RequestMethod.POST)
	public String editClientReponse(
			@ModelAttribute("client") final Client client,
			@PathVariable("clientId") final Integer clientId,
			final ModelMap model) {
		init();

		if (client != null && client.getNom() != null
				&& !client.getNom().isEmpty() && client.getPrenom() != null
				&& !client.getPrenom().isEmpty()) {

			// client.setId(clientId);
			magasinManager.updateClient(client);
			return "redirect:/client";
		}
		model.addAttribute("client", client);
		return "modif";
	}

	@RequestMapping(value = "/delete/{clientId}", method = RequestMethod.GET)
	public String SuppClientReponse(
			@PathVariable("clientId") final Integer clientId,
			final ModelMap model) throws SQLException {
		init();
		final Client client = magasinManager.getClient(clientId);

		if (client != null && client.getNom() != null
				&& !client.getNom().isEmpty() && client.getPrenom() != null
				&& !client.getPrenom().isEmpty()) {

			/**/client.setId(clientId);
			magasinManager.removeClient(client.getId());
			return "redirect:/client";
		}
		model.addAttribute("client", client);
		return "client";

	}
}