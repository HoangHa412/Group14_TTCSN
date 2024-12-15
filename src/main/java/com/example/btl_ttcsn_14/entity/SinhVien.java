package com.example.btl_ttcsn_14.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sinh_vien")
public class SinhVien {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ma_sinh_vien")
    private Integer maSinhVien; // Mã sinh viên (khóa chính)

    @Column(name = "ho_ten", nullable = false, length = 100)
    private String hoTen; // Họ và tên sinh viên

    @Column(name = "ngay_sinh", nullable = false)
    private LocalDate ngaySinh; // Ngày sinh

    @Column(name = "gioi_tinh", length = 10)
    private String gioiTinh; // Giới tính

    @Column(name = "dia_chi", length = 255)
    private String diaChi; // Địa chỉ

    @Column(name = "so_dien_thoai", length = 15, unique = true)
    private String soDienThoai; // Số điện thoại

	public SinhVien() {
		super();
	}

	public SinhVien(Integer maSinhVien, String hoTen, LocalDate ngaySinh, String gioiTinh, String diaChi,
			String soDienThoai) {
		super();
		this.maSinhVien = maSinhVien;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
	}

	public Integer getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(Integer maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public LocalDate getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

}
