package ru.mirea.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "university_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 20, unique = true)
    private String addressName;
    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
    private List<Building> buildings;
}
