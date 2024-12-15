package com.example.btl_ttcsn_14.controller;

import com.example.btl_ttcsn_14.entityDTO.LopHocDTO;
import com.example.btl_ttcsn_14.service.KhoaHocService;
import com.example.btl_ttcsn_14.service.LopHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lophoc")
public class LopHocController {
    @Autowired
    private LopHocService lopHocService;

    @Autowired
    private KhoaHocService khoaHocService;

    @GetMapping
    public String listLopHoc(Model model) {
        model.addAttribute("lopHocs", lopHocService.getAllLopHoc());
        return "lophoc/lhList";
    }

    @GetMapping("/add")
    public String addLopHocForm(Model model) {
        model.addAttribute("lopHoc", new LopHocDTO());
        model.addAttribute("khoaHocs", khoaHocService.getAllKhoaHoc());
        return "lophoc/lhAdd";
    }

    @PostMapping("/add")
    public String addLopHoc(@ModelAttribute("lopHoc") LopHocDTO lopHocDTO) {
        lopHocService.saveLopHoc(lopHocDTO);
        return "redirect:/lophoc";
    }

    @GetMapping("/edit/{id}")
    public String editLopHocForm(@PathVariable("id") Integer id, Model model) {
        LopHocDTO lopHocDTO = lopHocService.getLopHocById(id);
        model.addAttribute("lopHoc", lopHocDTO);
        model.addAttribute("khoaHocs", khoaHocService.getAllKhoaHoc());
        return "lophoc/lhEdit";
    }

    @PostMapping("/edit/{id}")
    public String editLopHoc(@PathVariable("id") Integer id, @ModelAttribute("lopHoc") LopHocDTO lopHocDTO) {
        lopHocDTO.setMaLopHoc(id);
        lopHocService.saveLopHoc(lopHocDTO);
        return "redirect:/lophoc";
    }

    @GetMapping("/delete/{id}")
    public String deleteLopHoc(@PathVariable("id") Integer id) {
        lopHocService.deleteLopHocById(id);
        return "redirect:/lophoc";
    }

}
