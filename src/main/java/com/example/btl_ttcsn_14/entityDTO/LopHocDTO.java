package com.example.btl_ttcsn_14.entityDTO;

public class LopHocDTO {
    private Integer maLopHoc;
    private String tenLopHoc;
    private String diaChi;
    private Integer maKhoaHoc; // Chỉ lưu mã khóa học
    
 // Getters và Setters
    public Integer getMaLopHoc() {
        return maLopHoc;
    }

    public void setMaLopHoc(Integer maLopHoc) {
        this.maLopHoc = maLopHoc;
    }

    public String getTenLopHoc() {
        return tenLopHoc;
    }

    public void setTenLopHoc(String tenLopHoc) {
        this.tenLopHoc = tenLopHoc;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Integer getMaKhoaHoc() {
        return maKhoaHoc;
    }

    public void setMaKhoaHoc(Integer maKhoaHoc) {
        this.maKhoaHoc = maKhoaHoc;
    }

}
