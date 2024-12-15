package com.example.btl_ttcsn_14.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "KhoaHoc")
public class KhoaHoc {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer maKhoaHoc;

	    @Column(nullable = false, length = 100)
	    private String tenKhoaHoc;

	    @Column(nullable = false)
	    private LocalDate tgBatDau;

	    @Column(nullable = false)
	    private LocalDate tgKetThuc;
	    
	    @Column(nullable = false)
	    private String moTa;

		public KhoaHoc() {
			super();
		}

		public KhoaHoc(Integer maKhoaHoc, String tenKhoaHoc, LocalDate tgBatDau, LocalDate tgKetThuc, String moTa) {
			super();
			this.maKhoaHoc = maKhoaHoc;
			this.tenKhoaHoc = tenKhoaHoc;
			this.tgBatDau = tgBatDau;
			this.tgKetThuc = tgKetThuc;
			this.moTa = moTa;
		}

		public Integer getMaKhoaHoc() {
			return maKhoaHoc;
		}

		public void setMaKhoaHoc(Integer maKhoaHoc) {
			this.maKhoaHoc = maKhoaHoc;
		}

		public String getTenKhoaHoc() {
			return tenKhoaHoc;
		}

		public void setTenKhoaHoc(String tenKhoaHoc) {
			this.tenKhoaHoc = tenKhoaHoc;
		}

		public LocalDate getTgBatDau() {
			return tgBatDau;
		}

		public void setTgBatDau(LocalDate tgBatDau) {
			this.tgBatDau = tgBatDau;
		}

		public LocalDate getTgKetThuc() {
			return tgKetThuc;
		}

		public void setTgKetThuc(LocalDate tgKetThuc) {
			this.tgKetThuc = tgKetThuc;
		}

		public String getMoTa() {
			return moTa;
		}

		public void setMoTa(String moTa) {
			this.moTa = moTa;
		}
	    
	    
	    
	    
}
