package no.hvl.dat107;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AnsattDAO {

	private EntityManagerFactory emf;
	
	public AnsattDAO() {
		emf = Persistence.createEntityManagerFactory("ansattPersistenceUnit");
	}
	
	public Ansatt finnAnsattMedId(int ansattid) {
		EntityManager em = emf.createEntityManager();
		
		try {
			return em.find(Ansatt.class, ansattid);
		} finally {
			em.close();
		}	
	}
	
	public Ansatt finnAnsattMedBrukernavn(String brukernavn) {
		EntityManager em = emf.createEntityManager();
		
		try {
			TypedQuery<Ansatt> query = em.createQuery 
					("SELECT t FROM Ansatt t WHERE t.brukernavn = :brukernavn", Ansatt.class);  
			query.setParameter("brukernavn", brukernavn);
			return query.getSingleResult();
		} finally {
			em.close();
		}
	}
	
	public List<Ansatt> alleAnsatte(){
		EntityManager em = emf.createEntityManager();
		
		try {
			TypedQuery<Ansatt> query = em.createQuery("SELECT t FROM Ansatt t", Ansatt.class);
			
			return query.getResultList();
		} finally {
			em.close();
		}
	}
	
	public void oppdaterStilling(int ansattid, String stilling) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			
			Ansatt ansatt = em.find(Ansatt.class, ansattid);
			ansatt.setStilling(stilling);
			
			tx.commit();
		} catch(Throwable e){
			e.printStackTrace();
			if(tx.isActive()) {
				tx.rollback();
			}
		}	finally {
			em.close();
		}
	}
	
	public void oppdaterLonn(int ansattid, BigDecimal maanedslonn) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			
			Ansatt ansatt = em.find(Ansatt.class, ansattid);
			ansatt.setMaanedslonn(maanedslonn);
			
			tx.commit();
		} catch(Throwable e) {
			e.printStackTrace();
			if(tx.isActive()) {
				tx.rollback();
			}
		} finally {
			em.close();
		}
	}
	
	public void oppdaterStillingOgLonn(int ansattid, String stilling, BigDecimal maanedslonn) {
		oppdaterStilling(ansattid, stilling);
		oppdaterLonn(ansattid, maanedslonn);
	}
	
	public void nyAnsatt(Ansatt ansatt) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			
			em.persist(ansatt);
			
			tx.commit();
		} catch(Throwable e) {
			e.printStackTrace();
			if(tx.isActive()) {
				tx.rollback();
			}
		} finally {
			em.close();
		}
	}
}
