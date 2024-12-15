package com.example.btl_ttcsn_14.repository;

import com.example.btl_ttcsn_14.entity.MonHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonHocRepository extends JpaRepository<MonHoc, Integer> {

}
