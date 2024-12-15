package com.example.btl_ttcsn_14.controller;

import java.util.List;

import com.example.btl_ttcsn_14.entityDTO.KetQuaHocTapDTO;
import com.example.btl_ttcsn_14.service.KetQuaHocTapService;
import com.example.btl_ttcsn_14.service.MonHocService;
import com.example.btl_ttcsn_14.service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/ketquahoctap")
public class KetQuaHocTapController {
    @Autowired
    private KetQuaHocTapService ketQuaHocTapService;

    @Autowired
    private SinhVienService sinhVienService;

    @Autowired
    private MonHocService monHocService;

    // Hiển thị danh sách kết quả học tập
    @GetMapping
    public String listKetQuaHocTap(Model model) {
        List<KetQuaHocTapDTO> ketQuaHocTapList = ketQuaHocTapService.getAllKetQuaHocTap();
        model.addAttribute("ketQuaHocTapList", ketQuaHocTapList);
        return "KetQuaHocTap/kqhtList";
    }

    // Hiển thị form thêm mới kết quả học tập
    @GetMapping("/add")
    public String addKetQuaHocTapForm(Model model) {
        KetQuaHocTapDTO ketQuaHocTapDTO = new KetQuaHocTapDTO();
        model.addAttribute("ketQuaHocTap", ketQuaHocTapDTO);
        model.addAttribute("sinhVienList", sinhVienService.getAllSinhVien());
        model.addAttribute("monHocList", monHocService.getAllMonHoc());
        return "KetQuaHocTap/kqhtAdd";
    }

    // Xử lý thêm mới kết quả học tập
    @PostMapping("/add")
    public String saveKetQuaHocTap(@ModelAttribute("ketQuaHocTap") KetQuaHocTapDTO ketQuaHocTapDTO) {
        ketQuaHocTapService.addKetQuaHocTap(ketQuaHocTapDTO);
        return "redirect:/ketquahoctap";
    }

    // Hiển thị form sửa kết quả học tập
    @GetMapping("/edit/{id}")
    public String editKetQuaHocTapForm(@PathVariable("id") Integer id, Model model) {
        KetQuaHocTapDTO ketQuaHocTapDTO = ketQuaHocTapService.getKetQuaHocTapById(id);
        if (ketQuaHocTapDTO == null) {
            throw new IllegalArgumentException("Không tìm thấy kết quả học tập với ID: " + id);
        }

        model.addAttribute("ketQuaHocTap", ketQuaHocTapDTO);
        model.addAttribute("sinhVienList", sinhVienService.getAllSinhVien());
        model.addAttribute("monHocList", monHocService.getAllMonHoc());
        return "KetQuaHocTap/kqhtEdit";
    }

    // Xử lý cập nhật kết quả học tập
    @PostMapping("/edit")
    public String updateKetQuaHocTap(@ModelAttribute("ketQuaHocTap") KetQuaHocTapDTO ketQuaHocTapDTO) {
        ketQuaHocTapService.updateKetQuaHocTap(ketQuaHocTapDTO);
        return "redirect:/ketquahoctap";
    }

    // Xóa kết quả học tập theo ID
    @GetMapping("/delete/{id}")
    public String deleteKetQuaHocTap(@PathVariable("id") Integer id) {
        ketQuaHocTapService.deleteKetQuaHocTapById(id);
        return "redirect:/ketquahoctap";
    }

    
}
