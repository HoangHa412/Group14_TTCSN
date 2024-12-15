package com.example.btl_ttcsn_14.entityDTO;

public class LichHocDTO {
    private Integer maLichHoc;
    private Integer maLopHoc;
    private Integer maMonHoc;
    private Integer maGiangVien;
    private String thoiGianBatDau;
    private String thoiGianKetThuc;
	public LichHocDTO(int maLichHoc, int maLopHoc, int maMonHoc, int maGiangVien, String thoiGianBatDau,
			String thoiGianKetThuc) {
		super();
		this.maLichHoc = maLichHoc;
		this.maLopHoc = maLopHoc;
		this.maMonHoc = maMonHoc;
		this.maGiangVien = maGiangVien;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
	}
	public LichHocDTO() {
		super();
	}
	public Integer getMaLichHoc() {
		return maLichHoc;
	}
	public void setMaLichHoc(Integer maLichHoc) {
		this.maLichHoc = maLichHoc;
	}
	public Integer getMaLopHoc() {
		return maLopHoc;
	}
	public void setMaLopHoc(Integer maLopHoc) {
		this.maLopHoc = maLopHoc;
	}
	public Integer getMaMonHoc() {
		return maMonHoc;
	}
	public void setMaMonHoc(Integer maMonHoc) {
		this.maMonHoc = maMonHoc;
	}
	public Integer getMaGiangVien() {
		return maGiangVien;
	}
	public void setMaGiangVien(Integer maGiangVien) {
		this.maGiangVien = maGiangVien;
	}
	public String getThoiGianBatDau() {
		return thoiGianBatDau;
	}
	public void setThoiGianBatDau(String thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}
	public String getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}
	public void setThoiGianKetThuc(String thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}
    
}
