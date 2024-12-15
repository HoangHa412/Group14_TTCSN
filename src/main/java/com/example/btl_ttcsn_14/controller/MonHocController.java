package com.example.btl_ttcsn_14.controller;

import com.example.btl_ttcsn_14.entity.MonHoc;
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
@RequestMapping("/monhoc")
public class MonHocController {
	@Autowired
    private MonHocService monHocService;

    // Hiển thị danh sách môn học
    @GetMapping
    public String listMonHoc(Model model) {
        model.addAttribute("monHocs", monHocService.getAllMonHoc());
        return "MonHoc/mhList";
    }

    // Hiển thị form thêm môn học
    @GetMapping("/add")
    public String addMonHocForm(Model model) {
        model.addAttribute("monHoc", new MonHoc());
        return "MonHoc/mhAdd";
    }

    // Xử lý thêm môn học
    @PostMapping("/add")
    public String addMonHoc(@ModelAttribute("monHoc") MonHoc monHoc) {
        monHocService.saveMonHoc(monHoc);
        return "redirect:/monhoc";
    }

    // Xóa môn học
    @GetMapping("/delete/{id}")
    public String deleteMonHoc(@PathVariable("id") Integer id) {
        monHocService.deleteMonHocById(id);
        return "redirect:/monhoc";
    }
    // update

  @GetMapping("/editMonHocForm/{id}")
  public String editMonHocForm(@PathVariable(value = "id") Integer id , Model model) {
	   model.addAttribute("monHoc",monHocService.getMonHocById(id));
	   return "MonHoc/mhEdit";
  }
  @PostMapping("/editMonHocForm/{id}")
  public String SaveMonHoc(@PathVariable Integer id, @ModelAttribute("monHoc") MonHoc monHoc ,Model model) {
      
	  MonHoc existingMonHoc = monHocService.getMonHocById(id);
	  existingMonHoc.setMaMonHoc(id);
	  existingMonHoc.setTenMonHoc(monHoc.getTenMonHoc());
	  existingMonHoc.setSoTinChi(monHoc.getSoTinChi());
	  monHocService.saveMonHoc(existingMonHoc);
      return "redirect:/monhoc";
  }

  
}
