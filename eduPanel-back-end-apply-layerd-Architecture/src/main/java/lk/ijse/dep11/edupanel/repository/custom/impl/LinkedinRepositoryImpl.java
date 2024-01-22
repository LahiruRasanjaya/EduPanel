package lk.ijse.dep11.edupanel.repository.custom.impl;

import lk.ijse.dep11.edupanel.entity.Lecturer;
import lk.ijse.dep11.edupanel.entity.LinkedIn;
import lk.ijse.dep11.edupanel.repository.CrudRepositoryImpl;
import lk.ijse.dep11.edupanel.repository.custom.LinkedInRepository;

import java.util.Optional;

public class LinkedinRepositoryImpl extends CrudRepositoryImpl<LinkedIn, Lecturer> implements LinkedInRepository{
//    @Override
//    public void deleteById(Lecturer pk) {
//        getEntityManager().remove(getEntityManager().find(LinkedIn.class, pk.getId()));
//    }
//
//    @Override
//    public Optional<LinkedIn> findById(Lecturer pk) {
//        return Optional.ofNullable(getEntityManager().find(LinkedIn.class, pk.getId()));
//    }
    //    private EntityManager em;
//
//    @Override
//    public void setEntityManager(EntityManager em) {
//        this.em = em;
//    }
//
//    @Override
//    public LinkedIn save(LinkedIn entity) {
//        em.persist(entity);
//        return entity;
//    }
//
//    @Override
//    public void update(LinkedIn entity) {
//        em.merge(entity);
//    }
//
//    @Override
//    public void deleteById(Lecturer pk) {
//        em.remove(em.find(LinkedIn.class, pk));
//    }
//
//    @Override
//    public boolean existsById(Lecturer pk) {
//        return findById(pk).isPresent();
//    }
//
//    @Override
//    public Optional<LinkedIn> findById(Lecturer pk) {
//        return Optional.ofNullable(em.find(LinkedIn.class, pk));
//    }
//
//    @Override
//    public List<LinkedIn> findAll() {
//        return em.createQuery("SELECT li FROM LinkedIn li", LinkedIn.class).getResultList();
//    }
//
//    @Override
//    public long count() {
//        return em.createQuery("SELECT COUNT(li) FROM LinkedIn li", Long.class).getSingleResult();
//    }
}
