package com.example.ShopMoHinh.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "fullname",length = 100)
    private String fullname;

    @Column(name = "email",length = 100)
    private String email;

    @Column(name = "phone_number",nullable = false,length = 100)
    private String phone_number;

    @Column(name = "address",length = 100)
    private String address;

    @Column(name = "note",length = 100)
    private String note;

    @Column(name = "oders_date")
    private Date orderDate;

    @Column(name = "status")
    private String status;

    @Column(name = "total_money")
    private Double total_money;

    @Column(name = "shipping_method")
    private String shipping_method;

    @Column(name = "shipping_address")
    private String shipping_address;

    @Column(name = "shipping_date")
    private LocalDate shippingDate;

    @Column(name = "tracking_number")
    private String tracking_number;

    @Column(name = "payment_method")
    private String payment_method;

    @Column(name = "active")
    private Boolean active;
}



