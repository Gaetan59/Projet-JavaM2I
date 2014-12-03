package com.formation.virgin.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.internal.NotNull;

@Entity
public class Artiste {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	private String nom;
	private final List<Album> listeAlbum = new ArrayList<Album>();
	private final List<Titre> listeTitre = new ArrayList<Titre>();

	public Artiste(final String nom) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result
				+ ((listeAlbum == null) ? 0 : listeAlbum.hashCode());
		result = prime * result
				+ ((listeTitre == null) ? 0 : listeTitre.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Artiste other = (Artiste) obj;
		if (id != other.id) {
			return false;
		}
		if (listeAlbum == null) {
			if (other.listeAlbum != null) {
				return false;
			}
		} else if (!listeAlbum.equals(other.listeAlbum)) {
			return false;
		}
		if (listeTitre == null) {
			if (other.listeTitre != null) {
				return false;
			}
		} else if (!listeTitre.equals(other.listeTitre)) {
			return false;
		}
		if (nom == null) {
			if (other.nom != null) {
				return false;
			}
		} else if (!nom.equals(other.nom)) {
			return false;
		}
		return true;
	}

}
