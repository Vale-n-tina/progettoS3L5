package org.example;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("RIVISTA")
public class Rivista extends Pubblicazione {
	private String periodicita;

   //costruttore vuoto
	public Rivista(long isbn, int numeroPagine, int annoPubblicazione, String titolo) {
		super(isbn, numeroPagine, annoPubblicazione, titolo);

	}

	//COSTRUTTORE
	public Rivista(long isbn, int numeroPagine, int annoPubblicazione, String titolo, String periodicita) {
		super(isbn, numeroPagine, annoPubblicazione, titolo);
		this.periodicita = periodicita;
	}


	public String getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(String periodicita) {
		this.periodicita = periodicita;
	}

	@Override
	public String toString() {
		return "Rivista{" +
				  "periodicita='" + periodicita + '\'' +
				  '}';
	}
}
