package com.example.btl_ttcsn_14.service;

import java.util.List;
import java.util.Optional;

import com.example.btl_ttcsn_14.entity.MonHoc;
import com.example.btl_ttcsn_14.repository.MonHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class MonHocService {
	@Autowired
    private MonHocRepository monHocRepository;

    public List<MonHoc> getAllMonHoc() {
        return monHocRepository.findAll();
    }

    public MonHoc getMonHocById(Integer id) {
    	Optional<MonHoc>optional = monHocRepository.findById(id);
    	MonHoc monHoc = null;
    	if(optional.isPresent()) {
    		monHoc = optional.get();
    	}else {
    		throw new RuntimeException("khong co mon hoc nao dc tim thay !");
    	}
        return monHoc;
    }

    public MonHoc saveMonHoc(MonHoc monHoc) {
        return monHocRepository.save(monHoc);
    }

    public void deleteMonHocById(Integer id) {
        monHocRepository.deleteById(id);
    }
}
