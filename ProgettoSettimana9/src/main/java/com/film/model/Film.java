package com.film.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Film {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String titolo;

	private String regista;

	private String tipo;

	private String incasso; // Scelta string vincolata dalla criptazione

	@JsonFormat(pattern = "yyyy") //Aggiunto di default mese e giorno dal db
	@Temporal(TemporalType.DATE)
	private Date anno;

	////////////////////// COSTRUTTORE VUOTO////////////////////////////

	public Film() {
	}

	////////////// GETTERS/////////////////////

	public Long getId() {
		return id;
	}

	public String getTitolo() {
		return titolo;
	}

	public String getRegista() {
		return regista;
	}

	public String getTipo() {
		return tipo;
	}

	public String getIncasso() {
		return incasso;
	}

	public Date getAnno() {
		return anno;
	}

	/////////////////// SETTERS////////////////////////////////////////

//	public void setId(Long id) {
//		this.id = id;
//	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public void setRegista(String regista) {
		this.regista = regista;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setIncasso(String incasso) {
		this.incasso = incasso;
	}

	public void setAnno(Date anno) {
		this.anno = anno;
	}

}