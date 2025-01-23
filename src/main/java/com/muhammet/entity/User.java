package com.muhammet.entity;

import com.muhammet.entity.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tbluser")
public class User {
    /**
     * Identity, her bir tablo için ayrı sequence oluştururlur ve bunlar üzerinden
     * atama yapılır.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;// -xxxx, 0, +xxxx
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    Long id_auto;
//    @GeneratedValue(strategy = GenerationType.TABLE)
//    Long id_table;
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    Long id_sequence;
//    @GeneratedValue(strategy = GenerationType.UUID)
//    UUID uuid;
//    @SequenceGenerator(name = "user_sq_id", sequenceName = "user_sq_id",
//    allocationSize = 5, initialValue = 500)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sq_id")
//    Long user_id;

    //------------------
    @Column(length = 50, name = "name")
    String name;
    String surname;
    @Column(name = "user_name",length = 64, nullable = false, unique = true)
    String userName;
    @Column(length = 250, nullable = false, unique = true)
    String email;
    @Column(length = 64, nullable = false)
    String password;
    String phone;
    /**
     * Tarih, Saat, Tarih-saat tanımlarını
     * belirtmek için kullanıyoruz.
     * TemporalType.DATE
     * TemporalType.TIME
     * TemporalType.TIMESTAMP
     */
    @Temporal(TemporalType.DATE)
    Date bornDate;
    /**
     * ENUM, Key,Value şeklinde değer saklandığı için
     * DB de tutulacak değerin seçilmesi gerekiyor. Eğer
     * default olarak bırakırsanız int olarak değer tutar.
     * EnumType.ORDINAL - int
     * EnumType.STRING - varchar
     *
    */
    @Enumerated(EnumType.ORDINAL)
    Gender gender;
    /**
     * Embedable bir sınıf içerisindeki alanları olduğu gibi bu sınıfın
     * içerisine eklemek için kullanılır.
     */
    @Embedded
    BaseEntity baseEntity;
//    Long createAt;
//    Long updateAt;
//    State state;
    /**
     * Veritabanında tutulmasını istemediğimiz ancak sınıf içerisinde
     * taşımak, kullanmak isteyeceğimiz alanları işaretlemek için
     * kullanırız.
     */
    @Transient
    String nameAndSurname;

    /**
     * Colleciton listler için bu anostaayon kullanılır. böylece
     * hibernate bu alanlar için ayrı bir tablo üretir ve kayıtları
     * burada tutar. user ve hobiler tablosunu ilişkide kalırlar.
     */
    @ElementCollection
    /**
     * oluşacak yeni tablonun özelleştirilmesi gerekiyor ise bunu
     * @CollectionTable - oluşacak tabloyu düzenleyebiliriz.
     */
    @CollectionTable(name = "tbl_user_hobi",
            joinColumns = @JoinColumn(name = "user_id_olacak_tamam_mi"))
    List<String> hobiler;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    List<Post> postList;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", bornDate=").append(bornDate);
        sb.append(", gender=").append(gender);
        sb.append(", baseEntity=").append(baseEntity);
        sb.append(", nameAndSurname='").append(nameAndSurname).append('\'');
        sb.append(", hobiler=").append(hobiler);
        sb.append(", postList=").append(postList);
        sb.append('}');
        return sb.toString();
    }
}
