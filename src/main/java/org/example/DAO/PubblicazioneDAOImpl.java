package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.example.EntityManagerUtil;
import org.example.Pubblicazione;

import java.util.List;

public class PubblicazioneDAOImpl implements PublicazioneDAO {

	@Override
	public void save(Pubblicazione pubblicazione) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		try {
			em.getTransaction().begin();


			if (pubblicazione.getIsbn() != null) {
				Pubblicazione existingPubblicazione = em.find(Pubblicazione.class, pubblicazione.getIsbn());
				if (existingPubblicazione != null) {
					em.merge(pubblicazione);
				} else {

					em.persist(pubblicazione);
				}
			} else {

				em.persist(pubblicazione);
			}

			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	@Override
	public Pubblicazione findById(Long id) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			Pubblicazione pubTrovata = em.find(Pubblicazione.class, id);
			em.getTransaction().commit();
			return pubTrovata;
		} catch (Exception e) {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public void deleteById(Long id) {
		EntityManager em = EntityManagerUtil.getEntityManager();

		try {
			em.getTransaction().begin();
			Pubblicazione pubb = em.find(Pubblicazione.class, id);
			if (pubb != null)
				em.remove(pubb);

			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	@Override
	public List<Pubblicazione> findbyyears(int anno) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			String l = "SELECT p FROM Pubblicazione p WHERE p.annoPubblicazione = :anno";
			Query query = em.createQuery(l);
			query.setParameter("anno", anno);
			List<Pubblicazione> risultati = query.getResultList();
			em.getTransaction().commit();
			return risultati;
		} catch (Exception e) {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
			return null;
		} finally {
			em.close();
		}
	}

	public List<Pubblicazione> publperautore (String autore) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			String d="SELECT p FROM Pubblicazione p WHERE p.autore=:autore";
			Query query = em.createQuery(d);
			query.setParameter("autore",autore);
			List<Pubblicazione> risultati = query.getResultList();
			em.getTransaction().commit();
			return risultati;
		} catch (Exception e) {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public List<Pubblicazione> publperTitolo(String titolo) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			String d="SELECT p FROM Pubblicazione p WHERE p.titolo LIKE :titolo";
			Query query = em.createQuery(d);
			query.setParameter("titolo",titolo);
			List<Pubblicazione> risultati = query.getResultList();
			em.getTransaction().commit();
			return risultati;
		} catch (Exception e) {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
			return null;
		} finally {
			em.close();
		}
	}
}
