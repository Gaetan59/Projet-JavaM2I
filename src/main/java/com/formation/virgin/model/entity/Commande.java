package com.formation.virgin.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	private Client client;

	@DateTimeFormat
	private Date date;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, orphanRemoval = true, mappedBy = "commande")
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

	public void setLignesCommande(final List<LigneCommande> lignesCommande) {
		this.lignesCommande = lignesCommande;
	}

	public void addLigneCommande(final LigneCommande ligne1) {


	}
}
