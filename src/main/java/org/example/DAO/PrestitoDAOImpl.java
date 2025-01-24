package org.example.DAO;

import jakarta.persistence.EntityManager;
import org.example.EntityManagerUtil;
import org.example.Prestito;
import org.example.Pubblicazione;

public class PrestitoDAOImpl implements PrestitoDAO{
	@Override
	public void save(Prestito prestito) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(prestito);
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
	public Prestito findById(Long id) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			Prestito pr = em.find(Prestito.class,id);
			em.getTransaction().commit();
			return pr;
		} catch (Exception e) {
			if(em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}
		finally {
			em.close();
		}
	}

	@Override
	public void deleteById(Long id) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			//Evento evento = findById(id);
			Prestito pr = em.find(Prestito.class,id);
			if(pr!=null)
				em.remove(pr);

			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
		}
		finally {
			em.close();
		}

	}
}
