package com.formation.virgin.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Titre extends Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String track;
	private Date anneeTitre;

	public Titre() {
		super();
	}

	public Titre(String track, Date anneeTitre) {
		super();
		this.track = track;
		this.anneeTitre = anneeTitre;

	}

	public Date getAnneeTitre() {
		return anneeTitre;
	}

	public void setAnneeTitre(Date anneeTitre) {
		this.anneeTitre = anneeTitre;
	}

	public String getTrack() {
		return track;
	}

	public void setTrack(String track) {
		this.track = track;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
