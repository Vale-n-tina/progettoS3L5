package org.example;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_pubblicazione", discriminatorType = DiscriminatorType.STRING)
public abstract class Pubblicazione {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long isbn;
	private String titolo;
	@Column(name = "anno_pubblicazione")
	private int annoPubblicazione;
	@Column(name = "numero_pagine")
	private int numeroPagine;

	public Pubblicazione(Long isbn, int numeroPagine, int annoPubblicazione, String titolo) {
		this.isbn = isbn;
		this.numeroPagine = numeroPagine;
		this.annoPubblicazione = annoPubblicazione;
		this.titolo = titolo;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getNumeroPagine() {
		return numeroPagine;
	}

	public void setNumeroPagine(int numeroPagine) {
		this.numeroPagine = numeroPagine;
	}

	public int getAnnoPubblicazione() {
		return annoPubblicazione;
	}

	public void setAnnoPubblicazione(int annoPubblicazione) {
		this.annoPubblicazione = annoPubblicazione;
	}

	public Long getIsbn() {
		return isbn;
	}

	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Pubblicazione{" +
				  "isbn=" + isbn +
				  ", titolo='" + titolo + '\'' +
				  ", annoPubblicazione=" + annoPubblicazione +
				  ", numeroPagine=" + numeroPagine +
				  '}';
	}
}
