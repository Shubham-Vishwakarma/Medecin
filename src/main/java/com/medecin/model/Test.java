package com.medecin.model;

import lombok.*;

import javax.persistence.*;

@Table(name = "test")
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
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
}