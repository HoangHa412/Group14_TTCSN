package com.example.btl_ttcsn_14.service;

import java.util.List;

import com.example.btl_ttcsn_14.entity.GiangVien;
import com.example.btl_ttcsn_14.repository.GiangVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GiangVienService {
	@Autowired
	private GiangVienRepository giangVienRepository;
	
    public List<GiangVien> getAllGiangVien() {
        return giangVienRepository.findAll();
    }

    public GiangVien getGiangVienById(Integer id) {
        return giangVienRepository.findById(id).orElse(null);
    }

    public GiangVien addGiangVien(GiangVien giangVien) {
        return giangVienRepository.save(giangVien);
    }

    public void deleteGiangVien(Integer id) {
        giangVienRepository.deleteById(id);
    }
}
