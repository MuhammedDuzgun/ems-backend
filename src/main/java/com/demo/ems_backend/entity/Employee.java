package com.demo.ems_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees",
        uniqueConstraints = {
        @UniqueConstraint(
                name = "UX_EMAIL",
                columnNames = "email"
        )
        }
)
public class Employee {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_id_generator"
    )
    @SequenceGenerator(
            name = "employee_id_generator",
            sequenceName = "employee_id_sequence",
            allocationSize = 1
    )
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String email;
}
