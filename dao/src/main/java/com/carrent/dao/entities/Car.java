package com.carrent.dao.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "car")
public class Car extends BaseEntity {

    @Column(name = "model")
    private String model;

    @Column(name = "color")
    private String color;

    @Column(name = "rented")
    private boolean rented;

    @Column(name = "plate_num")
    private String plate_num;

    @Column(name = "year")
    private int year;

    @Column(name = "price")
    private int price;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToMany(mappedBy = "cars")
    private Set<Order> order;

    @OneToMany(mappedBy = "car")
    private List<Damage> damages;
}




