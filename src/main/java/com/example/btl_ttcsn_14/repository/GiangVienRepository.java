package com.example.btl_ttcsn_14.repository;

import com.example.btl_ttcsn_14.entity.GiangVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiangVienRepository extends JpaRepository<GiangVien, Integer> {

}
