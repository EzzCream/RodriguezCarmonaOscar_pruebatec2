package com.hackaboss.persistencia;

import com.hackaboss.logica.Ciudadano;
import com.hackaboss.logica.Usuario;
import com.hackaboss.persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class CiudadanoJpaController implements Serializable {

    public CiudadanoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public CiudadanoJpaController() {
        emf = Persistence.createEntityManagerFactory("ciudadanoJspPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<Ciudadano> getCiudadanosByCurp(String curp) {
        String jpql = "SELECT u FROM Ciudadano u WHERE u.curp = :curp";
        TypedQuery<Ciudadano> query = getEntityManager().createQuery(jpql, Ciudadano.class);
        query.setParameter("curp", curp);
        return query.getResultList();
    }

    public void create(Ciudadano ciudadano) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(ciudadano);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ciudadano ciudadano) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ciudadano = em.merge(ciudadano);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = ciudadano.getId();
                if (findCiudadano(id) == null) {
                    throw new NonexistentEntityException("The ciudadano with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ciudadano ciudadano;
            try {
                ciudadano = em.getReference(Ciudadano.class, id);
                ciudadano.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ciudadano with id " + id + " no longer exists.", enfe);
            }
            em.remove(ciudadano);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ciudadano> findCiudadanoEntities(String curp) {
        return findCiudadanoEntities(true, -1, -1);
    }

    public List<Ciudadano> findCiudadanoEntities(int maxResults, int firstResult) {
        return findCiudadanoEntities(false, maxResults, firstResult);
    }

    private List<Ciudadano> findCiudadanoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ciudadano.class));
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

    public Ciudadano findCiudadano(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ciudadano.class, id);
        } finally {
            em.close();
        }
    }

    public int getCiudadanoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ciudadano> rt = cq.from(Ciudadano.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public Ciudadano getCiudadanoByCurp(String curp) {
        EntityManager em = getEntityManager();
        try{
            String jpql = "SELECT u FROM Ciudadano u WHERE u.curp = :curp";
            Query query = em.createQuery(jpql, Ciudadano.class);
            query.setParameter("curp", curp);
            query.setMaxResults(1);
            return (Ciudadano) query.getSingleResult();
        }catch(NoResultException e){
            return null;
        }
        finally {
            em.close();
        }
    }
}
