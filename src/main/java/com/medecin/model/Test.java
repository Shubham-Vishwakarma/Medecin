package com.medecin.model;

import javax.persistence.*;

@Table(name = "test")
@Entity
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "test_generator")
    @TableGenerator(name = "test_generator", table = "test_sequence", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = true)
    private int price;

    public Test() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}