package com.formation.virgin.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.sun.istack.internal.NotNull;

@Entity
public class LigneCommande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	private Article article;
	@NotNull
	private Integer quantite;
	@ManyToOne
	private Commande commande;

	public LigneCommande() {
		super();
	}

	public LigneCommande(final Article article, final Integer quantite) {
		super();
		this.article = article;
		this.quantite = quantite;
	}

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(final Article article) {
		this.article = article;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(final Integer quantite) {
		this.quantite = quantite;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(final Commande commande) {
		this.commande = commande;
	}
}
