package com.formation.virgin.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	private Client client;

	private Date date;

	@LazyCollection(LazyCollectionOption.FALSE)
	private List<LigneCommande> lignesCommande = new ArrayList<LigneCommande>();

	public Commande() {
		super();

	}

	public Commande(final Client client, final Date date) {
		super();
		this.client = client;
		this.date = date;
	}

	public Client getClient() {
		return client;
	}

	public Date getDate() {
		return date;
	}

	public Integer getId() {
		return id;
	}

	public void setClient(final Client client) {
		this.client = client;
	}

	public void setDate(final Date date) {
		this.date = date;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public List<LigneCommande> getLignesCommande() {
		return lignesCommande;
	}

	public void setLignesCommande(List<LigneCommande> lignesCommande) {
		this.lignesCommande = lignesCommande;
	}
}
