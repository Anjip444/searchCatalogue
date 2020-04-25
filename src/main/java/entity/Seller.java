package entity;

import javax.persistence.*;

@Entity
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToMany
    @Column(name="Id")
    private int id;

    @Column(name="Name")
    private String name;
}
