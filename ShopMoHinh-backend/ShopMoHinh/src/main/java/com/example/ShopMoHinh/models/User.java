package com.example.ShopMoHinh.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import javax.management.relation.Role;
import java.util.Date;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fullname",length = 100)
    private String fullName;

    @Column(name = "phone_number",length = 10, nullable = false)
    private String phoneNumber;

    @Column(name = "address",length = 200)
    private String address;

    @Column(name = "password",length = 200,nullable = false)
    private String password;

    @JsonProperty("is_active")
    private boolean active;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "facebook_account_id")
    private int facebookAccountId;

    @Column(name = "google_account_id")
    private int googleAccountId;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private com.example.ShopMoHinh.models.Role role;


}
