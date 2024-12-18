package com.example.btl_ttcsn_14.entity;

import java.time.LocalDate;

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
@Table(name = "lich_hoc")
public class LichHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maLichHoc;

    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonIgnore
    private LopHoc lopHoc;

    @ManyToOne
    @JoinColumn( nullable = false)
    private MonHoc monHoc;

    @ManyToOne
    @JoinColumn( nullable = false)
    private GiangVien giangVien;

    @Column( nullable = false)
    private LocalDate thoiGianBatDau;

    @Column( nullable = false)
    private LocalDate thoiGianKetThuc;

	public LichHoc(int maLichHoc, LopHoc lopHoc, MonHoc monHoc, GiangVien giangVien, LocalDate thoiGianBatDau,
				   LocalDate thoiGianKetThuc) {
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

	public void setThoiGianBatDau(LocalDate thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}

	public String getThoiGianKetThuc() {
		return this.getThoiGianKetThuc();
	}

	public void setThoiGianKetThuc(LocalDate thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}
    
    
}
