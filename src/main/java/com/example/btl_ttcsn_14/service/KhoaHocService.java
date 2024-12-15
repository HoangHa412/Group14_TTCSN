package com.example.btl_ttcsn_14.service;

import java.util.List;

import com.example.btl_ttcsn_14.entity.KhoaHoc;
import com.example.btl_ttcsn_14.repository.KhoaHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class KhoaHocService {
	 @Autowired
	    private KhoaHocRepository khoaHocRepository;

	    public List<KhoaHoc> getAllKhoaHoc() {
	        return khoaHocRepository.findAll();
	    }

	    public KhoaHoc getKhoaHocById(Integer id) {
	        return khoaHocRepository.findById(id).orElse(null);
	    }

	    public KhoaHoc saveKhoaHoc(KhoaHoc khoaHoc) {
	        return khoaHocRepository.save(khoaHoc);
	    }

	    public void deleteKhoaHocById(Integer id) {
	        khoaHocRepository.deleteById(id);
	    }
}
