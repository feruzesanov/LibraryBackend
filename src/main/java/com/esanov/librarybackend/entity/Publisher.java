package com.esanov.librarybackend.entity;

import com.esanov.librarybackend.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "is_deleted = 0")
@Entity
@Table(name = "publishers")
public class Publisher extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "street")
    private String street;

    @Column(name = "country")
    private String country;

    @Column(name = "house")
    private String house;

    @Column(name = "description")
    private String description;

}
