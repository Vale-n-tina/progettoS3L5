package org.example.DAO;

import jakarta.persistence.EntityManager;
import org.example.EntityManagerUtil;
import org.example.Utente;

public class UtenteDAOImpl implements UtenteDAO {
	@Override
	public void save(Utente utente) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		try {

			em.getTransaction().begin();
			em.persist(utente);

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
	public Utente findById(Long id) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			Utente utt = em.find(Utente.class, id);
			em.getTransaction().commit();
			return utt;
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
			Utente ut = em.find(Utente.class, id);
			if (ut != null)
				em.remove(ut);

			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}

	}
}
