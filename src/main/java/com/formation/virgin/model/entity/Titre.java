package com.formation.virgin.model.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.sun.istack.internal.NotNull;

@Entity
public class Titre extends Article {


	@NotNull
	private String track;
	@NotNull
	private int annee;

	@NotNull
	@ManyToOne
	private Artiste artiste;

	@ManyToOne
	private Album album;

	public Titre() {
		super();
	}

	public Titre(String track, int annee) {
		super();
		this.track = track;
		this.annee = annee;

	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public String getTrack() {
		return track;
	}

	public void setTrack(String track) {
		this.track = track;
	}



	/**
	 * @return the artiste
	 */
	public Artiste getArtiste() {
		return artiste;
	}

	/**
	 * @param artiste
	 *            the artiste to set
	 */
	public void setArtiste(Artiste artiste) {
		this.artiste = artiste;
	}

	/**
	 * @return the album
	 */
	public Album getAlbum() {
		return album;
	}

	/**
	 * @param album
	 *            the album to set
	 */
	public void setAlbum(Album album) {
		this.album = album;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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
		final Titre other = (Titre) obj;
		if (annee != other.annee) {
			return false;
		}
		if (track == null) {
			if (other.track != null) {
				return false;
			}
		} else if (!track.equals(other.track)) {
			return false;
		}
		return true;
	}

}
