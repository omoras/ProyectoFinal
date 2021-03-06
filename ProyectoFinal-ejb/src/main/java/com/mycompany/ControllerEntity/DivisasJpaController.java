/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ControllerEntity;

import com.mycompany.ControllerEntity.exceptions.NonexistentEntityException;
import com.mycompany.ControllerEntity.exceptions.RollbackFailureException;
import com.mycompany.Entity.Divisas;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;

/**
 *
 * @author orlan
 */
public class DivisasJpaController implements Serializable {

    public DivisasJpaController() {
        this.emf = Persistence.createEntityManagerFactory("com.mycompany_ProyectoFinal-ejb_ejb_1.0-SNAPSHOTPU").createEntityManager();
    }
    private UserTransaction utx = null;
    private EntityManager emf = null;

    public EntityManager getEntityManager() {
        return emf;
    }

    public void create(Divisas divisas) throws RollbackFailureException, Exception {
        try {
            emf.getTransaction().begin();
            emf.persist(divisas);
            emf.getTransaction().commit();
        } catch (Exception ex) {
            try {

            } catch (Exception re) {
                throw ex;
            }
            throw ex;
        } finally {
            if (emf != null) {
                emf.close();
            }
        }
    }

    public void edit(Divisas divisas) throws NonexistentEntityException, RollbackFailureException, Exception {
        try {
            emf.getTransaction().begin();
            emf.merge(divisas);
            emf.getTransaction().commit();
        } catch (Exception ex) {

            throw ex;
        } finally {
            if (emf != null) {
                emf.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        try {

            emf.getTransaction().begin();
            emf.remove(id);
            emf.getTransaction().commit();

        } catch (Exception ex) {

            throw ex;
        } finally {
            if (emf != null) {
                emf.close();
            }
        }
    }

    public List<Divisas> findDivisasEntities() {
        return findDivisasEntities(true, -1, -1);
    }

    public List<Divisas> findDivisasEntities(int maxResults, int firstResult) {
        return findDivisasEntities(false, maxResults, firstResult);
    }

    private List<Divisas> findDivisasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Divisas.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Divisas findDivisas(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Divisas.class, id);
        } finally {
            em.close();
        }
    }

    public Divisas busacaDivisasNombre(String name) {
        System.out.println("Prueba de llegada de datos"+name);
        try {
            Divisas d;
            
            TypedQuery<Divisas>consultaDivisa=emf.createNamedQuery("Divisas.findByNombre",Divisas.class);
            consultaDivisa.setParameter("nombre",name);
            d=consultaDivisa.setMaxResults(1).getSingleResult(); 
            System.out.println("LLego a buscar la divisa");
            return d;
            
        } catch(Exception e){
            System.out.println("Error: "+e.getMessage());
            Logger.getLogger(DivisasJpaController.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public int getDivisasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Divisas> rt = cq.from(Divisas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
