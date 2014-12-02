package com.formation.virgin.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.internal.NotNull;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	private String nom;
	
	@NotNull
	private String prenom;
	
	@NotNull
	@DateTimeFormat
	private Date naissance;
	
	@NotNull
	private String adresse;
	
	@NotNull
	@Pattern(regexp = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$")
	private String email;

	@OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true, mappedBy = "client")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Commande> listeCommande = new ArrayList<Commande>();

	public Client(final String nom, final String prenom,
			final Date naissance, final String adresse, final String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.naissance = naissance;
		this.adresse = adresse;
		this.email = email;
	}

	public Client() {
		super();
	}

	public Integer getId() {
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(final String prenom) {
		this.prenom = prenom;
	}

	public Date getNaissance() {
		return naissance;
	}

	public void setNaissance(final Date naissance) {
		this.naissance = naissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(final String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public List<Commande> getListeCommande() {
		return listeCommande;
	}

	public List<Commande> getCommande() {
		return listeCommande;
	}

	public void setListeCommande(final List<Commande> listeCommande) {
		this.listeCommande = listeCommande;
	}

	public void addCommande(final Commande commande) {
		// TODO Auto-generated method stub

	}

}
