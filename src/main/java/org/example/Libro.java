package org.example;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("LIBRO")
public class Libro extends Pubblicazione {
	private String autore;
	private String genere;



	//costruttore vuoto
	public Libro(long isbn, int numeroPagine, int annoPubblicazione, String titolo) {
		super(isbn, numeroPagine, annoPubblicazione, titolo);
	}


	//costruttore
	public Libro(long isbn, int numeroPagine, int annoPubblicazione, String titolo,String autore, String genere) {
		super(isbn, numeroPagine, annoPubblicazione, titolo);
		this.autore = autore;
		this.genere = genere;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	@Override
	public String toString() {
		return  super.toString() +
				  "autore='" + autore + '\'' +
				  ", genere='" + genere + '\'' +
				  '}';
	}
}
