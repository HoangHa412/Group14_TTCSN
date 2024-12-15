package com.example.btl_ttcsn_14.entityDTO;

public class KetQuaHocTapDTO {
    private Integer maKetQua;

    private Integer maSinhVien;
    private String tenSinhVien; // Để hiển thị tên sinh viên dễ dàng hơn trong giao diện

    private Integer maMonHoc;
    private String tenMonHoc; // Để hiển thị tên môn học dễ dàng hơn trong giao diện

    private Float diem;

    // Getters và Setters
    public Integer getMaKetQua() {
        return maKetQua;
    }

    public void setMaKetQua(Integer maKetQua) {
        this.maKetQua = maKetQua;
    }

    public Integer getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(Integer maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getTenSinhVien() {
        return tenSinhVien;
    }

    public void setTenSinhVien(String tenSinhVien) {
        this.tenSinhVien = tenSinhVien;
    }

    public Integer getMaMonHoc() {
        return maMonHoc;
    }

    public void setMaMonHoc(Integer maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public Float getDiem() {
        return diem;
    }

    public void setDiem(Float diem) {
        this.diem = diem;
    }
    
}
