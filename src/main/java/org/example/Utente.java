package org.example;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
public class Utente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numeroTessera;
	@OneToMany(mappedBy = "utente")
	private List<Prestito> prestiti;
	private String nome;
	private String cognome;
	@Column(name = "data_nascita")
	private LocalDate dataNascita;

	public Utente(LocalDate dataNascita, String cognome, String nome, List<Prestito> prestiti) {
		this.dataNascita = dataNascita;
		this.cognome = cognome;
		this.nome = nome;
		this.prestiti = prestiti;
	}



	public Long getNumeroTessera() {
		return numeroTessera;
	}

	public void setNumeroTessera(Long numeroTessera) {
		this.numeroTessera = numeroTessera;
	}

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
