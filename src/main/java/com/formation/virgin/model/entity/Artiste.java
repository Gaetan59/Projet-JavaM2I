package com.formation.virgin.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Artiste {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	protected String nom;
	private final List<Album> listeAlbum = new ArrayList<Album>();
	private final List<Titre> listeTitre = new ArrayList<Titre>();

	public Artiste(final int id, final String nom) {
		super();
		this.nom = nom;
	}

	public Artiste() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(final String nom) {
		this.nom = nom;
	}

	public List<Album> getListeAlbum() {
		return listeAlbum;
	}

	public List<Titre> getListeTitre() {
		return listeTitre;
	}

}
