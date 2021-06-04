package com.iamcujo.hurayUser.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "user")               
public class Board {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
 
    @Column(name = "name")
    private String name;
 
    @Column(name = "created_date")
    private String created_date;
 
    @Builder
    public Board(String name, String created_date) {
        this.name = name;
        this.created_date = created_date;
    }
 
    public void update(String name, String created_date) {
        this.name = name;
        this.created_date = created_date;
    }
}
