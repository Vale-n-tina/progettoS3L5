package org.example.DAO;

import org.example.Prestito;


public interface PrestitoDAO {

	void save(Prestito prestito);

	Prestito findById(Long id);

	void deleteById(Long id);
}
