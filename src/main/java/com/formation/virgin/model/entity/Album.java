package com.formation.virgin.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.sun.istack.internal.NotNull;

@Entity
public class Album extends Article {

	@NotNull
	private String titre;

	@NotNull
	private int annee;

	@NotNull
	@ManyToOne
	private Artiste artiste;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "album")
	private List<Titre> listeTitre = new ArrayList<Titre>();

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

	public String getTitre() {
		return titre;
	}

	public void setAnnee(final int annee) {
		this.annee = annee;
	}


	public void setTitre(final String titre) {
		this.titre = titre;
	}

	public Artiste getArtiste() {
		return artiste;
	}

	public void setArtiste(Artiste artiste) {
		this.artiste = artiste;
	}

	public List<Titre> getListeTitre() {
		return listeTitre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + annee;
		result = prime * result + (titre == null ? 0 : titre.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Album other = (Album) obj;
		if (annee != other.annee) {
			return false;
		}
		if (titre == null) {
			if (other.titre != null) {
				return false;
			}
		} else if (!titre.equals(other.titre)) {
			return false;
		}
		return true;
	}

}
