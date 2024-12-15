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
@Table(name = "KetQuaHocTap")
public class KetQuaHocTap {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maKetQua;

    @ManyToOne
    @JoinColumn(name = "maSinhVien", nullable = false)
    private SinhVien sinhVien;

    @ManyToOne
    @JoinColumn(name = "maMonHoc", nullable = false)
    private MonHoc monHoc;

    @Column(nullable = false)
    private Float diem;

	public KetQuaHocTap() {
		super();
	}

	public KetQuaHocTap(Integer maKetQua, SinhVien sinhVien, MonHoc monHoc, Float diem) {
		super();
		this.maKetQua = maKetQua;
		this.sinhVien = sinhVien;
		this.monHoc = monHoc;
		this.diem = diem;
	}

	public Integer getMaKetQua() {
		return maKetQua;
	}

	public void setMaKetQua(Integer maKetQua) {
		this.maKetQua = maKetQua;
	}

	public SinhVien getSinhVien() {
		return sinhVien;
	}

	public void setSinhVien(SinhVien sinhVien) {
		this.sinhVien = sinhVien;
	}

	public MonHoc getMonHoc() {
		return monHoc;
	}

	public void setMonHoc(MonHoc monHoc) {
		this.monHoc = monHoc;
	}

	public Float getDiem() {
		return diem;
	}

	public void setDiem(Float diem) {
		this.diem = diem;
	}
    
}
