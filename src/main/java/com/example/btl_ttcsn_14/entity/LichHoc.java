package com.example.btl_ttcsn_14.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "LichHoc")
public class LichHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maLichHoc;

    @ManyToOne
    @JoinColumn(name = "MaLopHoc", nullable = false)
    @JsonIgnore
    private LopHoc lopHoc;

    @ManyToOne
    @JoinColumn(name = "MaMonHoc", nullable = false)
    private MonHoc monHoc;

    @ManyToOne
    @JoinColumn(name = "MaGiangVien", nullable = false)
    private GiangVien giangVien;

    @Column(name = "ThoiGianBatDau", nullable = false)
    private LocalDateTime thoiGianBatDau;

    @Column(name = "ThoiGianKetThuc", nullable = false)
    private LocalDateTime thoiGianKetThuc;

	public LichHoc(int maLichHoc, LopHoc lopHoc, MonHoc monHoc, GiangVien giangVien, LocalDateTime thoiGianBatDau,
			LocalDateTime thoiGianKetThuc) {
		super();
		this.maLichHoc = maLichHoc;
		this.lopHoc = lopHoc;
		this.monHoc = monHoc;
		this.giangVien = giangVien;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
	}

	public LichHoc() {
		super();
	}

	public int getMaLichHoc() {
		return maLichHoc;
	}

	public void setMaLichHoc(int maLichHoc) {
		this.maLichHoc = maLichHoc;
	}

	public LopHoc getLopHoc() {
		return lopHoc;
	}

	public void setLopHoc(LopHoc lopHoc) {
		this.lopHoc = lopHoc;
	}

	public MonHoc getMonHoc() {
		return monHoc;
	}

	public void setMonHoc(MonHoc monHoc) {
		this.monHoc = monHoc;
	}

	public GiangVien getGiangVien() {
		return giangVien;
	}

	public void setGiangVien(GiangVien giangVien) {
		this.giangVien = giangVien;
	}

	public String getThoiGianBatDau() {
		return this.getThoiGianBatDau();
	}

	public void setThoiGianBatDau(LocalDateTime thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}

	public String getThoiGianKetThuc() {
		return this.getThoiGianKetThuc();
	}

	public void setThoiGianKetThuc(LocalDateTime thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}
    
    
}
