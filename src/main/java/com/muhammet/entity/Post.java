package com.muhammet.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tblpost")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String comment;
    Long date;
    String imageUrl;
    /**
     * Bir tablonun verisinin var olabilmesi için diğer tablodaki verinin kayıtlı olması gereklidir.
     * peki ilgili kayıt tabloda yok ise ne olacak, işte burada kayıt işleminin yerine getirenb
     * tablo kayıtlı olmayan entity nesnesini kayıt etmek için işlem yapar, ancak eğer diğer
     * tablo üzerinde yetkisi yok ise hata fırlatır.
     *  BU bir problemdir ve çözmümü basittir. İlgili tabloya yetki verilerek çözülür. Bu işlem
     *  yapmak için cascade = CacdateType.Persist - All - Update v.s. eklemek gerekir.
     */
    @ManyToOne(cascade = CascadeType.ALL)
    // sadece bağlantı kuram kolonun title adını değiştirmek için kullanılır.
    @JoinColumn(name = "kullanici_idsi_ekledim")
    User user;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Post{");
        sb.append("id=").append(id);
        sb.append(", comment='").append(comment).append('\'');
        sb.append(", date=").append(date);
        sb.append(", imageUrl='").append(imageUrl).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
