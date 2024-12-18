package com.example.btl_ttcsn_14.controller;

import com.example.btl_ttcsn_14.entity.GiangVien;
import com.example.btl_ttcsn_14.service.GiangVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/giangvien")
public class GiangVienController {
    @Autowired
    private GiangVienService giangVienService;

    @GetMapping
    public String listGiangVien(Model model) {
        List<GiangVien> GiangVienList = giangVienService.getAllGiangVien();
        model.addAttribute("giangVienList", GiangVienList);
        return "GiangVien/giangVienList";
    }

    @GetMapping("/add")
    public String addGiangVien(Model model){
        model.addAttribute("giangVien", new GiangVien());
        return "GiangVien/giangVienAdd";
    }

    @PostMapping("/add")
    public String saveGiangVien(GiangVien giangVien){
        giangVienService.addGiangVien(giangVien);
        return "redirect:/giangvien";
    }

    @GetMapping("/edit/{id}")
    public String editGiangVien(Model model,@PathVariable("id") Integer id){
        GiangVien giangVien = giangVienService.getGiangVienById(id);
        model.addAttribute("giangVien",  giangVien);
        return "GiangVien/giangVienEdit";
    }

    @PostMapping("/edit")
    public String updateGiangVien(GiangVien giangVien){
        giangVienService.addGiangVien(giangVien);
        return "redirect:/giangvien";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteGiangVien(@PathVariable("id") Integer id){
        giangVienService.deleteGiangVien(id);
        return "redirect:/giangvien";
    }
}


