package com.formation.virgin.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Album extends Article {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private String titre;
	private Date annee;
	
	public Album() {
		super();
	
	}
	
	public Album(final String titre, final Date annee) {
		super();
		this.titre = titre;
		this.annee = annee;
	}
	
	public Date getAnnee() {
		return annee;
	}
	public Integer getId() {
		return id;
	}
	public String getTitre() {
		return titre;
	}
	public void setAnnee(final Date annee) {
		this.annee = annee;
	}
	public void setId(final Integer id) {
		this.id = id;
	}
	public void setTitre(final String titre) {
		this.titre = titre;
	}
	
	
	

}
