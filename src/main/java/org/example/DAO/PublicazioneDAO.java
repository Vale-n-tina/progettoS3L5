package org.example.DAO;

import org.example.Pubblicazione;

import java.util.List;

public interface PublicazioneDAO {
	void save(Pubblicazione pubblicazione);

	Pubblicazione findById(Long id);

	void deleteById(Long id);

	List<Pubblicazione>findbyyears(int anno);

	List<Pubblicazione> publperautore(String autore);
	List<Pubblicazione> publperTitolo(String titolo);
}
