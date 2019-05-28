/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ControllerEntity;

import com.mycompany.ControllerEntity.exceptions.NonexistentEntityException;
import com.mycompany.ControllerEntity.exceptions.RollbackFailureException;
import com.mycompany.Entity.Divisas;
import com.mycompany.Entity.Usuarios;
import com.mycompany.Pojo.User;
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
public class UsuariosJpaController implements Serializable {

    public UsuariosJpaController() {
        this.emf = Persistence.createEntityManagerFactory("com.mycompany_ProyectoFinal-ejb_ejb_1.0-SNAPSHOTPU").createEntityManager();
    }
    private UserTransaction utx = null;
    private EntityManager emf = null;

    public EntityManager getEntityManager() {
        return emf;
    }

    public void create(Usuarios usuarios) throws RollbackFailureException, Exception {
        try {
            emf.getTransaction().begin();
            emf.persist(usuarios);
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

    public void edit(Usuarios usuarios) throws NonexistentEntityException, RollbackFailureException, Exception {
        try {
            emf.getTransaction().begin();
            emf.merge(usuarios);
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

    public List<Usuarios> findUsuariosEntities() {
        return findUsuariosEntities(true, -1, -1);
    }

    public List<Usuarios> findUsuariosEntities(int maxResults, int firstResult) {
        return findUsuariosEntities(false, maxResults, firstResult);
    }

    private List<Usuarios> findUsuariosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuarios.class));
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

    public Usuarios findUsuarios(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuarios.class, id);
        } finally {
            em.close();
        }
    }

    public Usuarios validarUsuario(User usuario) {
        System.out.println("Prueba de llegada de datos"+usuario.getUser());
        try {
            Usuarios u;
            
            TypedQuery<Usuarios>consultaDivisa=emf.createNamedQuery("Usuarios.findByUserPass",Usuarios.class);
            consultaDivisa.setParameter("user",usuario.getUser());
            consultaDivisa.setParameter("pass",usuario.getPass());
            
            u=consultaDivisa.getSingleResult(); 
            return u;
            
        } catch(Exception e){
            System.out.println("Error: "+e.getMessage());
            Logger.getLogger(DivisasJpaController.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    public int getUsuariosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuarios> rt = cq.from(Usuarios.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
