package org.example.fibonacci.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "finabocci")
public class Finabocci {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "index")
    private Integer index;
    @Column(name = "value")
    private Long value;
}
