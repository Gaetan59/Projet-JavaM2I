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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + annee;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((titre == null) ? 0 : titre.hashCode());
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
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
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
