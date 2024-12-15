package com.example.btl_ttcsn_14.controller;

import com.example.btl_ttcsn_14.entity.KhoaHoc;
import com.example.btl_ttcsn_14.service.KhoaHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/khoahoc")
public class KhoaHocController {
	@Autowired
    private KhoaHocService khoaHocService;

    // Hiển thị danh sách khóa học
    @GetMapping
    public String listKhoaHoc(Model model) {
        model.addAttribute("khoaHocs", khoaHocService.getAllKhoaHoc());
        return "khoahoc/khList";
    }

    // Hiển thị form thêm khóa học
    @GetMapping("/add")
    public String addKhoaHocForm(Model model) {
        model.addAttribute("khoaHoc", new KhoaHoc());
        return "khoahoc/khAdd";
    }

    // Xử lý thêm khóa học
    @PostMapping("/add")
    public String addKhoaHoc(@ModelAttribute("khoaHoc") KhoaHoc khoaHoc) {
        khoaHocService.saveKhoaHoc(khoaHoc);
        return "redirect:/khoahoc";
    }

    // Hiển thị form chỉnh sửa khóa học
    @GetMapping("/edit/{id}")
    public String editKhoaHocForm(@PathVariable("id") Integer id, Model model) {
        KhoaHoc khoaHoc = khoaHocService.getKhoaHocById(id);
        model.addAttribute("khoaHoc", khoaHoc);
        return "khoahoc/khEdit";
    }

    // Xử lý chỉnh sửa khóa học
    @PostMapping("/edit/{id}")
    public String editKhoaHoc(@PathVariable("id") Integer id, @ModelAttribute("khoaHoc") KhoaHoc khoaHoc) {
        khoaHoc.setMaKhoaHoc(id); // Đảm bảo ID không thay đổi
        khoaHocService.saveKhoaHoc(khoaHoc);
        return "redirect:/khoahoc";
    }

    // Xóa khóa học
    @GetMapping("/delete/{id}")
    public String deleteKhoaHoc(@PathVariable("id") Integer id) {
        khoaHocService.deleteKhoaHocById(id);
        return "redirect:/khoahoc";
    }

}
