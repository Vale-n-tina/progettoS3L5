package org.example.DAO;

import org.example.Prestito;
import org.example.Utente;

public interface UtenteDAO {
	void save(Utente utente);

	Utente findById(Long id);

	void deleteById(Long id);
}
