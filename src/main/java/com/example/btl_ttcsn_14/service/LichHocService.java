package com.example.btl_ttcsn_14.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.example.btl_ttcsn_14.entity.GiangVien;
import com.example.btl_ttcsn_14.entity.LichHoc;
import com.example.btl_ttcsn_14.entity.LopHoc;
import com.example.btl_ttcsn_14.entity.MonHoc;
import com.example.btl_ttcsn_14.repository.GiangVienRepository;
import com.example.btl_ttcsn_14.repository.LichHocRepository;
import com.example.btl_ttcsn_14.repository.LopHocRepository;
import com.example.btl_ttcsn_14.repository.MonHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LichHocService {
	 @Autowired
	    private LichHocRepository lichHocRepository;

	    @Autowired
	    private LopHocRepository lopHocRepository;

	    @Autowired
	    private MonHocRepository monHocRepository;

    @Autowired
    private GiangVienRepository giangVienRepository;

    // Lấy danh sách tất cả Lịch Học
    public List<LichHoc> getAllLichHoc() {
        return lichHocRepository.findAll();
    }

    // Thêm mới Lịch Học
    public LichHoc addLichHoc(LichHoc lichHoc) {
        return lichHocRepository.save(lichHoc);
    }

    // Sửa Lịch Học
    public LichHoc updateLichHoc(LichHoc lichHoc) {
        // Kiểm tra tồn tại lịch học
        LichHoc existingLichHoc = lichHocRepository.findById(lichHoc.getMaLichHoc())
                .orElseThrow(() -> new RuntimeException("Lịch học không tồn tại với ID: " + lichHoc.getMaLichHoc()));

        // Cập nhật các thông tin
        existingLichHoc.setThoiGianBatDau(LocalDate.parse(lichHoc.getThoiGianBatDau()));
        existingLichHoc.setThoiGianKetThuc(LocalDate.parse(lichHoc.getThoiGianKetThuc()));

        LopHoc lopHoc = lopHocRepository.findById(lichHoc.getLopHoc().getMaLopHoc())
                .orElseThrow(() -> new RuntimeException("Lớp học không tồn tại!"));
        MonHoc monHoc = monHocRepository.findById(lichHoc.getMonHoc().getMaMonHoc())
                .orElseThrow(() -> new RuntimeException("Môn học không tồn tại!"));
        GiangVien giangVien = giangVienRepository.findById(lichHoc.getGiangVien().getMaGiangVien())
                .orElseThrow(() -> new RuntimeException("Giảng viên không tồn tại!"));

        existingLichHoc.setLopHoc(lopHoc);
        existingLichHoc.setMonHoc(monHoc);
        existingLichHoc.setGiangVien(giangVien);

        return lichHocRepository.save(existingLichHoc);
    }

    // Xóa Lịch Học
    public void deleteLichHoc(int maLichHoc) {
        lichHocRepository.deleteById(maLichHoc);
    }

    // Lấy Lịch Học theo ID
    public LichHoc getLichHocById(int id) {
        return lichHocRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lịch học không tồn tại với ID: " + id));
    }

    // Ánh xạ từ Entity sang DTO
//    private LichHocDTO convertToDTO(LichHoc lichHoc) {
//        LichHocDTO dto = new LichHocDTO();
//        dto.setMaLichHoc(lichHoc.getMaLichHoc());
//        dto.setMaLopHoc(lichHoc.getLopHoc().getMaLopHoc());
//        dto.setMaMonHoc(lichHoc.getMonHoc().getMaMonHoc());
//        dto.setMaGiangVien(lichHoc.getGiangVien().getMaGiangVien());
//        dto.setThoiGianBatDau(lichHoc.getThoiGianBatDau().toString());
//        dto.setThoiGianKetThuc(lichHoc.getThoiGianKetThuc().toString());
//        return dto;
//    }
//
//    // Ánh xạ từ DTO sang Entity
//    private LichHoc convertToEntity(LichHocDTO lichHocDTO) {
//        LichHoc lichHoc = new LichHoc();
//
//        if (lichHocDTO.getMaLichHoc() != 0) {
//            lichHoc.setMaLichHoc(lichHocDTO.getMaLichHoc());
//        }
//
//        LopHoc lopHoc = lopHocRepository.findById(lichHocDTO.getMaLopHoc())
//                .orElseThrow(() -> new RuntimeException("Lớp học không tồn tại!"));
//        MonHoc monHoc = monHocRepository.findById(lichHocDTO.getMaMonHoc())
//                .orElseThrow(() -> new RuntimeException("Môn học không tồn tại!"));
//        GiangVien giangVien = giangVienRepository.findById(lichHocDTO.getMaGiangVien())
//                .orElseThrow(() -> new RuntimeException("Giảng viên không tồn tại!"));
//
//        lichHoc.setLopHoc(lopHoc);
//        lichHoc.setMonHoc(monHoc);
//        lichHoc.setGiangVien(giangVien);
//        lichHoc.setThoiGianBatDau(LocalDateTime.parse(lichHocDTO.getThoiGianBatDau()));
//        lichHoc.setThoiGianKetThuc(LocalDateTime.parse(lichHocDTO.getThoiGianKetThuc()));
//
//        return lichHoc;
//    }
    
}
