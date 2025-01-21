package com.muhammet.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id_auto;
    @GeneratedValue(strategy = GenerationType.TABLE)
    Long id_table;
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id_sequence;
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID uuid;
    @SequenceGenerator(name = "user_sq_id", sequenceName = "user_sq_id",
    allocationSize = 5, initialValue = 500)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sq_id")
    Long user_id;
    

}
