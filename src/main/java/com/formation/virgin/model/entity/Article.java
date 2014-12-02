package com.formation.virgin.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * The Class Article.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Article {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/** The nom. */
	private String nom;

	/** The prix. */
	private Integer prix;

	/**
	 * Instantiates a new article.
	 */
	public Article() {
		super();
	}

	/**
	 * Instantiates a new article.
	 *
	 * @param nom
	 *            the nom
	 * @param prix
	 *            the prix
	 */
	public Article(final String nom, final int prix) {
		this.nom = nom;
		this.prix = prix;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * Gets the nom.
	 *
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Sets the nom.
	 *
	 * @param nom
	 *            the new nom
	 */
	public void setNom(final String nom) {
		this.nom = nom;

	}

	/**
	 * Gets the prix.
	 *
	 * @return the prix
	 */
	public Integer getPrix() {
		return prix;
	}

	/**
	 * Sets the prix.
	 *
	 * @param prix
	 *            the new prix
	 */
	public void setPrix(final Integer prix) {
		this.prix = prix;

	}
}
