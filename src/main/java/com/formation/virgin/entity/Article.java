<<<<<<< HEAD
package com.formation.virgin.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;

	private List<Artiste> ListeArtiste = new ArrayList<Artiste>();


	public Article(){

	}

	public Article(final List<Artiste> listeArtiste) {
		super();
		ListeArtiste = listeArtiste;
	}


	/**
	 * @return the listeArtiste
	 */
	public List<Artiste> getListeArtiste() {
		return ListeArtiste;
	}


	/**
	 * @param listeArtiste
	 *            the listeArtiste to set
	 */
	public void setListeArtiste(final List<Artiste> listeArtiste) {
		ListeArtiste = listeArtiste;
	}
}
=======
package com.formation.virgin.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;

	private List<Artiste> ListeArtiste = new ArrayList<Artiste>();

	public Article() {

	}

	public Article(final List<Artiste> listeArtiste) {
		super();
		ListeArtiste = listeArtiste;
	}

	/**
	 * @return the listeArtiste
	 */
	public List<Artiste> getListeArtiste() {
		return ListeArtiste;
	}

	/**
	 * @param listeArtiste
	 *            the listeArtiste to set
	 */
	public void setListeArtiste(final List<Artiste> listeArtiste) {
		ListeArtiste = listeArtiste;
	}

}
>>>>>>> branch 'master' of https://github.com/Gaetan59/Projet-JavaM2I.git
