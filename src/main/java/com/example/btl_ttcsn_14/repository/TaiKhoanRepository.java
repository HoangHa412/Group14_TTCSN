package com.example.btl_ttcsn_14.repository;

import com.example.btl_ttcsn_14.entity.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, Integer> {
    Optional<TaiKhoan> findByUsernameAndPassword(String username, String password);
}
