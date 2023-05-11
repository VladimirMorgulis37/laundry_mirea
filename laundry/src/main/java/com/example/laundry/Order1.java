package com.example.laundry;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order1 {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "products_seq")
    @SequenceGenerator(name = "products_seq", sequenceName = "products_seq", allocationSize = 1)
    private Long id;
    @Column(name = "clothes")
    private int clothes;
    @Column(name = "bedclothes")
    private int bedclothes;
    @Column(name = "curtains")
    private int curtains;
    @Column(name = "washing")
    private boolean washing;
    @Column(name = "ironing")
    private boolean ironing;
    @Column(name = "telephone_number")
    private String telephone_number;
    @Column(name = "code")
    private double code = Math.random()*10000;
    public Order1() {}

    public Order1(int bedclothes, int clothes, int curtains, boolean ironing, boolean washing, String telephone_number, double code) {
        this.bedclothes = bedclothes;
        this.clothes = clothes;
        this.curtains = curtains;
        this.ironing = ironing;
        this.washing = washing;
        this.telephone_number = telephone_number;
        this.code = code;
    }
}
