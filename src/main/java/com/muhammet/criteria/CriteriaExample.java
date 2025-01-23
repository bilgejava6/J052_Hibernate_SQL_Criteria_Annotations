package com.muhammet.criteria;

import com.muhammet.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class CriteriaExample {

    private EntityManagerFactory emf;
    private EntityManager em;
    private CriteriaBuilder cb;

    public CriteriaExample() {
        emf = Persistence.createEntityManagerFactory("criteria_example");
        em = emf.createEntityManager();
        cb = em.getCriteriaBuilder();
    }

    // select * from tblXXX
    public List<User> findAll(){
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> root = query.from(User.class);  // from tbluser
        query.select(root); // select *
        return em.createQuery(query).getResultList();
    }

    // select name from tblxxx
    public List<String> selectOneColumn(){
        CriteriaQuery<String> query = cb.createQuery(String.class);
        Root<User> root = query.from(User.class); // from tbluser
        // root.get([DATA_NAME]) burada select yapılacak sınıfın değişkenin adını giriyorsunuz.
        query.select(root.get("name")); // select name
        return em.createQuery(query).getResultList();
    }

    // select * from tblxx where name = Kenan
    public List<User> findAllByName(String name){
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> root = query.from(User.class); // from tbluser
        query.select(root); // select *
        query.where(cb.equal(root.get("name"),name)); // where root.name = name
        return em.createQuery(query).getResultList();
    }















}
