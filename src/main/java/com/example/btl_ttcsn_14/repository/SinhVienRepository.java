package com.example.btl_ttcsn_14.repository;

import com.example.btl_ttcsn_14.entity.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien, Integer> {
	

}
