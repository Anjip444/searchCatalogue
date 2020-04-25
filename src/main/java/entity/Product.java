package entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ClientId")
    private int clientId;

    @Column(name="brand")
    private String brand;

    @Column(name="color")
    private String color;

    @Column(name="Price")
    private long price;

    @Column(name="Size")
    private String size;

    @Column(name="Seller")
    private Seller seller;

}
