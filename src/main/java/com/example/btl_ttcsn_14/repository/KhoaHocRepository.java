package com.example.btl_ttcsn_14.repository;

import com.example.btl_ttcsn_14.entity.KhoaHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhoaHocRepository extends JpaRepository<KhoaHoc, Integer> {

}
