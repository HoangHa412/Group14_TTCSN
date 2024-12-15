package com.example.btl_ttcsn_14.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MonHoc")
public class MonHoc {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maMonHoc;

    @Column(nullable = false, length = 100)
    private String tenMonHoc;

    @Column(nullable = false)
    private Integer soTinChi;

	public MonHoc() {
		super();
	}
	

	public MonHoc(Integer maMonHoc, String tenMonHoc, Integer soTinChi) {
		super();
		this.maMonHoc = maMonHoc;
		this.tenMonHoc = tenMonHoc;
		this.soTinChi = soTinChi;
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

	public Integer getSoTinChi() {
		return soTinChi;
	}

	public void setSoTinChi(Integer soTinChi) {
		this.soTinChi = soTinChi;
	}
    
}

