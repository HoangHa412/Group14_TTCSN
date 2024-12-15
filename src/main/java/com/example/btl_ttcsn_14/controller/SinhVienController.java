package com.example.btl_ttcsn_14.controller;

import java.util.List;

import com.example.btl_ttcsn_14.entity.SinhVien;
import com.example.btl_ttcsn_14.service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import jakarta.validation.Valid;

@Controller
@RequestMapping("/sinhvien")
public class SinhVienController {
	@Autowired
	private SinhVienService sinhVienService;
	// lấy tất cả sinh viên ra

	@GetMapping()
	public String viewAllSinhVien(Model model) {
		List<SinhVien> sinhvien = this.sinhVienService.getAllSinhVien();
		model.addAttribute("sinhVien", sinhvien);
		return "SinhVien/svList";
	}

	// thêm sinh viên mới
	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("sinhVien", new SinhVien());
		return "SinhVien/svadd";
	}

	@PostMapping("/add")
	public String addSinhVien(@ModelAttribute SinhVien sinhVien) {
		sinhVienService.saveSinhVien(sinhVien);
		return "redirect:/sinhvien";
	}
	// sửa sinh viên

	@GetMapping("/edit/{id}")
	public String editSinhVien(@PathVariable("id") Integer id, Model model) {
		// Lấy sinh viên từ database
		model.addAttribute("sinhVien", sinhVienService.getSinhVienById(id));
		return "SinhVien/svedit"; // Trả về trang edit.html
	}

	// lưu sinh viên
	@PostMapping("/edit/{id}")
	public String saveSinhvien(@PathVariable Integer id, @ModelAttribute("sinhVien") SinhVien sinhVien, Model model) {
		SinhVien existingSinhVien = sinhVienService.getSinhVienById(id);
		existingSinhVien.setMaSinhVien(id);
		existingSinhVien.setHoTen(sinhVien.getHoTen());
		existingSinhVien.setDiaChi(sinhVien.getDiaChi());
		existingSinhVien.setGioiTinh(sinhVien.getGioiTinh());
		existingSinhVien.setSoDienThoai(sinhVien.getSoDienThoai());
		existingSinhVien.setNgaySinh(sinhVien.getNgaySinh());
		
		sinhVienService.saveSinhVien(existingSinhVien);
		return "redirect:/sinhvien";
	}

	// xóa sinh viên
	@GetMapping("/delete/{id}")
	public String deleteSinhVien(@PathVariable Integer id) {
		sinhVienService.deleteSinhVien(id);
		return "redirect:/sinhvien";
	}

}
