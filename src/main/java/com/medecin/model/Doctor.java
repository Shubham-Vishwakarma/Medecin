package com.medecin.model;

import lombok.*;

import javax.persistence.*;

@Table(name = "doctor")
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "doctor_generator")
    @TableGenerator(name = "doctor_generator", table = "doctor_sequence", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

}