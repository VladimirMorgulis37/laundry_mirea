package com.example.laundry;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "orders_check")
public class Order_check {
    @Id
    private Long id_check;
    @Column(name = "code_check")
    private int code_check;
    public Order_check() {}

    public Order_check(Long id_check, int code_check) {
        this.id_check = id_check;
        this.code_check = code_check;
    }
}
