package com.example.btl_ttcsn_14.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "LopHoc")
public class LopHoc {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maLopHoc;

    @Column(nullable = false, length = 100)
    private String tenLopHoc;
    
    @Column(nullable = false, length = 100)
    private String diaChi;
    
    @ManyToOne
    @JoinColumn(name = "maKhoaHoc", nullable = false)
    private KhoaHoc khoaHoc;

	public LopHoc() {
		super();
	}

	public LopHoc(Integer maLopHoc, String tenLopHoc, String diaChi, KhoaHoc khoaHoc) {
		super();
		this.maLopHoc = maLopHoc;
		this.tenLopHoc = tenLopHoc;
		this.diaChi = diaChi;
		this.khoaHoc = khoaHoc;
	}

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

	public KhoaHoc getKhoaHoc() {
		return khoaHoc;
	}

	public void setKhoaHoc(KhoaHoc khoaHoc) {
		this.khoaHoc = khoaHoc;
	}
    
    
}
