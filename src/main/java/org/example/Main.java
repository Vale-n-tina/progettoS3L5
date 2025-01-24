package org.example;

import org.example.DAO.PubblicazioneDAOImpl;
import org.example.DAO.PublicazioneDAO;
import org.example.DAO.UtenteDAO;
import org.example.DAO.UtenteDAOImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Main {
	public static void main(String[] args) {

		PublicazioneDAO publDao=new PubblicazioneDAOImpl();
		UtenteDAO utDao=new UtenteDAOImpl();


		Pubblicazione libro2 = new Libro(12346L, 300, 1997, "Harry Potter e la Pietra Filosofale", "J.K. Rowling", "Fantasy");
		Pubblicazione rivista1 = new Rivista(23456L, 50, 2024, "Time", "Settimanale");
		Pubblicazione rivista2 = new Rivista(23457L, 60, 2024, "National Geographic", "Mensile");

		//publDao.save(libro1);
		//publDao.save(libro2);
		//publDao.save(rivista1);
		//publDao.save(rivista2);
		//System.out.println(libro1);
		List<Prestito> prestitiVuoti = new ArrayList<>();
		Utente utente1 = new Utente(LocalDate.of(1995, 5, 15), "Gargiulo", "Valentina", prestitiVuoti);
		//utDao.save(utente1);
		Utente utente2 = new Utente(LocalDate.of(1988, 12, 10), "Bianchi", "Luca", prestitiVuoti);
		//utDao.save(utente2);
   //TODO:AGGIUNTA DI UN ELEMENTO AL CATALOGO
		Pubblicazione libro1 = new Libro(12345L, 1200, 1954, "Il Signore degli Anelli", "J.R.R. Tolkien", "Fantasy");
		//publDao.save(libro1);
	//TODO:RIMOZIONE DI UN ELEMENTO DEL CATALOGO DATO UN CODICE ISBN
		publDao.deleteById(2L);
	//TODO:RICERCA PER ISBN
		publDao.findById(3L);
	//TODO:RICERCA PER ANNO DI PUBBLICAZIONE
		List<Pubblicazione> pubblicazioniperanno=publDao.findbyyears(1995);
	//TODO:RICERCA PER AUTORE
		List<Pubblicazione> publperautore=publDao.publperautore("valentina");
	//TODO:RICERCA PER TITOLO O PARTE DI ESSO
		List<Pubblicazione> publperTitolooparte=publDao.publperTitolo("mondo");
	//TODO:rICERCA DEGLI ELEMENTI ATTUALMENTE IN PRESTITO DATO UN NUMERO DI TESSERE UTENTE



	}
}