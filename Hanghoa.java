package Quanlyhanghoa;

import java.util.ArrayList;
import java.util.Scanner;

public class Hanghoa {
	public ArrayList Hanghoa = new ArrayList();
	private int mahang;
	private String tenhang;
	private String loaihang;
	private int soluong;
	public int getSoluongtonkho() {
		return soluong;
	}
	public void setSoluongtonkho(int soluongtonkho) {
		this.soluong = soluongtonkho;
	}

	private int gia;
	private String thuonghieu;
	private String xuatxu;
	Hanghoa(){
		
	}
	Hanghoa(int mahang, String tenhang,int gia){
		this.mahang=mahang;
		this.tenhang=tenhang;
		this.gia=gia;
	}
	
	public Hanghoa(String tenhang,String loaihang,int gia,String xuatxu) {
		this.tenhang=tenhang;
		this.loaihang=loaihang;
		this.gia=gia;
		this.xuatxu=xuatxu;
	}
	

	public Hanghoa(int mahang, String tenhang, int gia, String thuonghieu, String xuatxu) {
		super();
		this.mahang = mahang;
		this.tenhang = tenhang;
		this.gia = gia;
		this.thuonghieu = thuonghieu;
		this.xuatxu = xuatxu;
	}

	public String getLoaihang() {
		return loaihang;
	}
	public void setLoaihang(String loaihang) {
		this.loaihang = loaihang;
	}
	public int getMahang() {
		return mahang;
	}

	public void setMahang(int mahang) {
		this.mahang = mahang;
	}

	public String getTenhang() {
		return tenhang;
	}

	public void setTenhang(String tenhang) {
		this.tenhang = tenhang;
	}

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	public String getThuonghieu() {
		return thuonghieu;
	}

	public void setThuonghieu(String thuonghieu) {
		this.thuonghieu = thuonghieu;
	}

	public String getXuatxu() {
		return xuatxu;
	}

	public void setXuatxu(String xuatxu) {
		this.xuatxu = xuatxu;
	}
	
	public void themhang(Hanghoa hang,int sl) {
		hang.soluong =+sl;
	}
	public void themhang(Hanghoa hh) {
		Hanghoa.add(hh);
		
	}
	
	
}
