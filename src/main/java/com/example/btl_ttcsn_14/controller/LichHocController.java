package com.example.btl_ttcsn_14.controller;

import java.util.List;

import com.example.btl_ttcsn_14.entity.LichHoc;
import com.example.btl_ttcsn_14.service.GiangVienService;
import com.example.btl_ttcsn_14.service.LichHocService;
import com.example.btl_ttcsn_14.service.LopHocService;
import com.example.btl_ttcsn_14.service.MonHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lichhoc")
public class LichHocController {
    @Autowired
    private LichHocService lichHocService;
    @Autowired
    private LopHocService lopHocService;
    @Autowired
    private MonHocService monHocService;
    @Autowired
    private GiangVienService giangVienService;

    // Hiển thị danh sách lịch học
    @GetMapping
    public String listLichHoc(Model model) {
        List<LichHoc> lichHocList = lichHocService.getAllLichHoc();
        model.addAttribute("lichHocList", lichHocList);
        return "LichHoc/lhList"; // Đường dẫn tới file Thymeleaf hiển thị danh sách lịch học
    }

    // Hiển thị form thêm mới lịch học
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("lichHocDTO", new LichHoc());
        model.addAttribute("lopHocList", lopHocService.getAllLopHoc());
        model.addAttribute("monHocList", monHocService.getAllMonHoc());
        model.addAttribute("maGiangVienList", giangVienService.getAllGiangVien());
        return "LichHoc/lhAdd"; // Đường dẫn tới file Thymeleaf cho form thêm lịch học
    }

    // Xử lý thêm mới lịch học
    @PostMapping("/add")
    public String addLichHoc(@ModelAttribute("lichHocDTO") LichHoc lichHoc) {
        lichHocService.addLichHoc(lichHoc);
        return "redirect:/lichhoc";
    }

    // Hiển thị form sửa lịch học
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        LichHoc lichHocDTO = lichHocService.getLichHocById(id);
        model.addAttribute("lichHocDTO", lichHocDTO);
        model.addAttribute("lopHocList", lopHocService.getAllLopHoc());
        model.addAttribute("monHocList", monHocService.getAllMonHoc());
        model.addAttribute("maGiangVienList", giangVienService.getAllGiangVien());
        return "LichHoc/lhEdit"; // Đường dẫn tới file Thymeleaf cho form sửa lịch học
    }

    // Xử lý sửa lịch học
    @PostMapping("/edit")
    public String editLichHoc(@ModelAttribute("lichHocDTO") LichHoc lichHoc) {
        lichHocService.updateLichHoc(lichHoc);
        return "redirect:/lichhoc"; // Chuyển hướng về danh sách lịch học
    }

    // Xóa lịch học
    @GetMapping("/delete/{id}")
    public String deleteLichHoc(@PathVariable("id") int id) {
        lichHocService.deleteLichHoc(id);
        return "redirect:/lichhoc"; // Chuyển hướng về danh sách lịch học
    }
}
