package com.medecin.model;

import lombok.*;

import javax.persistence.*;

@Table(name = "report")
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "report_generator")
    @TableGenerator(name = "report_generator", table = "report_sequence", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "patient_id", nullable = false)
    private long patientId;

    @Column(name = "doctor_id", nullable = true)
    private long doctorId;

}