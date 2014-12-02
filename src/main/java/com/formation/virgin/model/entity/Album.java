package com.formation.virgin.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.sun.istack.internal.NotNull;

@Entity
public class Album extends Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@NotNull
	private String titre;

	@NotNull
	private int annee;

	public Album() {
		super();

	}

	public Album(final String titre, final int annee) {
		super();
		this.titre = titre;
		this.annee = annee;
	}

	public int getAnnee() {
		return annee;
	}

	@Override
	public Integer getId() {
		return id;
	}

	public String getTitre() {
		return titre;
	}

	public void setAnnee(final int annee) {
		this.annee = annee;
	}

	@Override
	public void setId(final Integer id) {
		this.id = id;
	}

	public void setTitre(final String titre) {
		this.titre = titre;
	}

}
