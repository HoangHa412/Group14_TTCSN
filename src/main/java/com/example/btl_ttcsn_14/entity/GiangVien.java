package com.example.btl_ttcsn_14.entity;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "GiangVien")
public class GiangVien {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "MaGiangVien")
	    private int maGiangVien;

	    @Column(name = "HoTen", nullable = false, length = 100)
	    private String hoTen;

	    @Column(name = "NgaySinh", nullable = false)
	    private String ngaySinh;

	    @Column(name = "GioiTinh", nullable = false, length = 10)
	    private String gioiTinh;

	    @Column(name = "DiaChi", length = 255)
	    private String diaChi;

	    @Column(name = "SoDienThoai", length = 15)
	    private String soDienThoai;

		public GiangVien(int maGiangVien, String hoTen, String ngaySinh, String gioiTinh, String diaChi,
				String soDienThoai) {
			
			this.maGiangVien = maGiangVien;
			this.hoTen = hoTen;
			this.ngaySinh = ngaySinh;
			this.gioiTinh = gioiTinh;
			this.diaChi = diaChi;
			this.soDienThoai = soDienThoai;
		}

		public GiangVien() {

		}

		public int getMaGiangVien() {
			return maGiangVien;
		}

		public void setMaGiangVien(int maGiangVien) {
			this.maGiangVien = maGiangVien;
		}

		public String getHoTen() {
			return hoTen;
		}

		public void setHoTen(String hoTen) {
			this.hoTen = hoTen;
		}

		public String getNgaySinh() {
			return ngaySinh;
		}

		public void setNgaySinh(String ngaySinh) {
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
