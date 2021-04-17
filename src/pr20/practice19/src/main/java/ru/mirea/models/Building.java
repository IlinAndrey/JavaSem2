package ru.mirea.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 20)
    private String creationDate;
    @Column(nullable = false, length = 20)
    private String type;
    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;
}
