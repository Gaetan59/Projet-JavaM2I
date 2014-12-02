package com.formation.virgin.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.formation.virgin.model.entity.Article;
import com.formation.virgin.model.manager.MagasinManager;

@Controller
@RequestMapping("/article")
public class ArticleController {
	@RequestMapping(method = RequestMethod.GET)
	public String printClient(final ModelMap model) {
		final ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring.xml");

		final MagasinManager magasinManager = (MagasinManager) ctx
				.getBean("magasinManagerImpl");

		final List<Article> list = magasinManager.getArticles();

		model.addAttribute("articles", list);
		return null;
	}

}
