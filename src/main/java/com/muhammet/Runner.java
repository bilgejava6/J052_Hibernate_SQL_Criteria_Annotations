package com.muhammet;

import com.muhammet.entity.Post;
import com.muhammet.entity.User;
import com.muhammet.entity.enums.Gender;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.Date;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence
                        .createEntityManagerFactory("criteria_example");
        EntityManager em = emf.createEntityManager();
        User user = User.builder()
                .phone("0 555 999 8887")
                .email("kenan@gmail.com")
                .name("Kenan")
                .surname("HOCA")
                .bornDate(new Date())
                .gender(Gender.ERKEK)
                .hobiler(List.of("Yüzmek","Balık tutumak","Spor", "Sinama"))
                .password("123456")
                .userName("kenan.hoca")
                .build();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();


        User user1 = User.builder()
                .phone("0 555 999 8887")
                .email("canan@gmail.com")
                .name("Canan")
                .surname("HOCA")
                .bornDate(new Date())
                .gender(Gender.KADIN)
                .hobiler(List.of("Yüzmek","Balık tutumak","Spor", "Sinama"))
                .password("123456")
                .userName("canan.hoca")
                .build();
        em.getTransaction().begin();
        em.persist(user1);
        em.getTransaction().commit();


        User user2 = User.builder()
                .phone("0 555 999 8887")
                .email("eylem@gmail.com")
                .name("Eylem")
                .surname("HOCA")
                .bornDate(new Date())
                .gender(Gender.KADIN)
                .hobiler(List.of("Yüzmek","Balık tutumak","Spor", "Sinama"))
                .password("123456")
                .userName("eylem.hoca")
                .build();
        em.getTransaction().begin();
        em.persist(user2);
        em.getTransaction().commit();
//        Post post = Post.builder()
//                .comment("Bu gün java ile  hibernate annotations  öğrenildi.")
//                .date(5L)
//                .imageUrl("")
//                .user(user)
//                .build();
//        em.getTransaction().begin();
//        em.persist(post);
//        em.getTransaction().commit();

//        Post post1 = Post.builder()
//                .comment("hibernate  sorguları")
//                .date(10L)
//                .imageUrl("")
//                .user(user)
//                .build();
//        em.getTransaction().begin();
//        em.persist(post1);
//        em.getTransaction().commit();

        em.close();


        /**
         * SQL - Criteria ile tüm verileri DB den çekmek.
         * LazyLoad ->, geç bağlanma ve yükleme yapar. yani veriler çekilmez erişilmek istenildiğinde çekilir.
         * select * from tbluser
         * id
         * name
         * select * from tblpost where userid = ?
         * postlist
         *
         * EagerLoad -> veriler ilk sorguda çekilir.
         * Select * from tbluser
         * select * from tblpost where userid = ?
         * id
         * name
         * postlist
         */

        em = emf.createEntityManager();
        /**
         * Builder sınıfı criteria yı üretmek için kullanılır.
         * sorgu için gerekli olan temel işlem Criteria
         */
        CriteriaBuilder cb = em.getCriteriaBuilder();
        // sorguyu buradan itibaren oluşturuyoruz.
        CriteriaQuery<User> criteriaQuery = cb.createQuery(User.class);
        // select * from tbluser
        Root<User> root = criteriaQuery.from(User.class); // alan adlarının ne olduğunu bildiriyoruz.
        criteriaQuery.select(root); // select *
        List<User> users = em.createQuery(criteriaQuery).getResultList();

        users.forEach(u->{
            System.out.println(u.getId());
            System.out.println(u.getName());
            System.out.println(u.getPostList());
        });

    }
}
