package com.formation.virgin.entity;

import javax.persistence.Entity;

@Entity
public class Prixsupport {

	private double prix;

	/**
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}

	/**
	 * @param prix
	 *            the prix to set
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Prixsupport(double prix) {
		super();
		this.prix = prix;
	}

	public Prixsupport() {

	}
}
