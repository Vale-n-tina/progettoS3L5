package org.example;


import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Prestito {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "id_utente")
	private Utente utente;

	@ManyToOne
	@JoinColumn(name = "id_pubblicazione")
	private Pubblicazione pubblicazione;
	@Column(name = "data_inizio_prestito" )
	private Date dataInizioPrestito;
	@Column(name = "data_restituzione")
	private Date dataRestituzione;
	@Column(name = "dara_restituzione_effettiva")
	private Date dataRestituzioneEffettiva;

	public Prestito() {

	}

	public Prestito(Date dataRestituzioneEffettiva, Date dataInizioPrestito, Pubblicazione pubblicazione, Utente utente, Date dataRestituzione) {
		this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
		this.dataInizioPrestito = dataInizioPrestito;
		this.pubblicazione = pubblicazione;
		this.utente = utente;
		this.dataRestituzione = dataRestituzione;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataRestituzioneEffettiva() {
		return dataRestituzioneEffettiva;
	}

	public void setDataRestituzioneEffettiva(Date dataRestituzioneEffettiva) {
		this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
	}

	public Pubblicazione getPubblicazione() {
		return pubblicazione;
	}

	public void setPubblicazione(Pubblicazione pubblicazione) {
		this.pubblicazione = pubblicazione;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Date getDataInizioPrestito() {
		return dataInizioPrestito;
	}

	public void setDataInizioPrestito(Date dataInizioPrestito) {
		this.dataInizioPrestito = dataInizioPrestito;
	}

	public Date getDataRestituzione() {
		return dataRestituzione;
	}

	public void setDataRestituzionePrestito(Date dataRestituzione) {
		this.dataRestituzione = dataRestituzione;
	}

	@Override
	public String toString() {
		return "Prestito{" +
				  "id=" + id +
				  ", utente=" + utente +
				  ", pubblicazione=" + pubblicazione +
				  ", dataInizioPrestito=" + dataInizioPrestito +
				  ", dataRestituzione=" + dataRestituzione +
				  ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva +
				  '}';
	}
}
