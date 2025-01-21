package com.muhammet;

import com.muhammet.entity.User;
import com.muhammet.entity.enums.Gender;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Date;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence
                        .createEntityManagerFactory("criteria_example");
        EntityManager em = emf.createEntityManager();
        User user = User.builder()
                .phone("0 555 999 8887")
                .email("muhammet@gmail.com")
                .name("Muhammet")
                .surname("HOCA")
                .bornDate(new Date())
                .gender(Gender.ERKEK)
                .hobiler(List.of("Yüzmek","Balık tutumak","Spor", "Sinama"))
                .password("123456")
                .userName("muhammet.hoca")
                .build();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
        emf.close();


    }
}
