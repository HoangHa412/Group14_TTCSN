package com.example.btl_ttcsn_14.repository;

import java.util.List;

import com.example.btl_ttcsn_14.entity.KetQuaHocTap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface KetQuaHocTapRepository  extends JpaRepository<KetQuaHocTap, Integer>{
    @Query("SELECT k.monHoc.tenMonHoc, AVG(k.diem) as avgDiem " +
            "FROM KetQuaHocTap k " +
            "GROUP BY k.monHoc.tenMonHoc " +
            "HAVING AVG(k.diem) >= :minScore")
     List<Object[]> findMonHocWithHighScores(@Param("minScore") float minScore);
}
