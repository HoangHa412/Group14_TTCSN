package com.example.btl_ttcsn_14.entity;

import jakarta.persistence.*;
import org.springframework.data.relational.core.sql.In;

@Entity
@Table(name = "tai_khoan")
public class TaiKhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;
}
