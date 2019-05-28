/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ControllerEntity;

import com.mycompany.ControllerEntity.exceptions.NonexistentEntityException;
import com.mycompany.ControllerEntity.exceptions.RollbackFailureException;
import com.mycompany.Entity.Tokens;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;

/**
 *
 * @author orlan
 */
public class TokensJpaController implements Serializable {

    public TokensJpaController() {
        this.emf =Persistence.createEntityManagerFactory("com.mycompany_ProyectoFinal-ejb_ejb_1.0-SNAPSHOTPU").createEntityManager();
    }
    private UserTransaction utx = null;
    private EntityManager emf = null;

    public EntityManager getEntityManager() {
        return emf;
    }

    public void create(Tokens token) throws RollbackFailureException, Exception {
        try {
            emf.getTransaction().begin();
            emf.persist(token);
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

    public void edit(Tokens token) throws NonexistentEntityException, RollbackFailureException, Exception {
        try {
            emf.getTransaction().begin();
            emf.merge(token);
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

    public List<Tokens> findTokensEntities() {
        return findTokensEntities(true, -1, -1);
    }

    public List<Tokens> findTokensEntities(int maxResults, int firstResult) {
        return findTokensEntities(false, maxResults, firstResult);
    }

    private List<Tokens> findTokensEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tokens.class));
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

    public Tokens findTokens(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tokens.class, id);
        } finally {
            em.close();
        }
    }

    public int getTokensCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tokens> rt = cq.from(Tokens.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
