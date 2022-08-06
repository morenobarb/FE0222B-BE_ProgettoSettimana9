package com.film.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.film.util.JpaUtil;

import org.springframework.security.crypto.bcrypt.BCrypt;

import com.film.model.Film;

public class FilmDAOImpl implements FilmDAO {
	EntityManager em;

	public void salva(Film f) {
		System.out.println("metodo film SALVATAGGIO");
		em = JpaUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction et = em.getTransaction();
		try {

			// Salvataggio entity film
			et.begin();
			String incasso = BCrypt.hashpw(f.getIncasso(), BCrypt.gensalt());
			f.setIncasso(incasso);
			em.persist(f);
			et.commit();
		} catch (Exception e) {
			e.printStackTrace();
			// Rollback se ci fosse errore, si torna indietro
			et.rollback();
		} finally {
			em.close();
		}

	}

	@SuppressWarnings("unchecked")
	public List<Film> trovaPerRegista(String regista) {
		System.out.println("metodo cittadino RICERCA_PER_REGISTA");
		em = JpaUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction et = em.getTransaction();
		List<Film> f = new ArrayList<Film>();
		try {
			et.begin();
			Query q = em.createQuery("SELECT f FROM Film f WHERE f.regista LIKE :regista");
			q.setParameter("regista", regista);
			f = (List<Film>) q.getResultList();
			et.commit();

		} catch (Exception e) {
			e.printStackTrace();
			et.rollback();
		} finally {
			em.close();
		}
		return f;
	}

	public void aggiorna(Film f) {
		System.out.println("metodo film AGGIORNAMENTO");
		em = JpaUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction et = em.getTransaction();

		try {

			// Aggiornamento entity film
			et.begin();
			String incassoCriptato = BCrypt.hashpw(f.getIncasso(), BCrypt.gensalt());
			f.setIncasso(incassoCriptato);
			em.merge(f);
			et.commit();
		} catch (Exception e) {
			e.printStackTrace();
			// Rollback se ci fosse errore, si torna indietro
			et.rollback();
		} finally {
			em.close();
		}

	}

	public void cancella(Long id) {
		System.out.println("metodo cittadino CANCELLA");
		em = JpaUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction et = em.getTransaction();

		try {

			// Rimozione entity film
			et.begin();
			Film f = em.find(Film.class, id);
			em.remove(f);
			et.commit();
		} catch (Exception e) {
			e.printStackTrace();
			// Rollback se ci fosse errore, si torna indietro
			et.rollback();
		} finally {
			em.close();
		}

	}

	public Film trovaPerId(Long id) {
		System.out.println("metodo film RICERCA_PER_ID");
		em = JpaUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction et = em.getTransaction();
		Film f = null;

		try {
			// Ricerca entity film
			et.begin();
			f = em.find(Film.class, id);
			et.commit();
		} catch (Exception e) {
			e.printStackTrace();
			// Rollback se ci fosse errore si torna indietro
			et.rollback();
		} finally {
			em.close();
		}
		return f;
	}

}
