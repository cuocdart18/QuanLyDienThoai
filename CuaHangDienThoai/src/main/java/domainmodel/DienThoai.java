/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author dungp
 */
@Entity
@Table(name = "DienThoai")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DienThoai implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdDienThoai")
    private UUID idDienThoai;

    @Column(name = "MaDienThoai")
    private String maDienThoai;

    @Column(name = "TenDienThoai")
    private String tenDienThoai;

    @Column(name = "SoLuongTon")
    private int soLuongTon;

    @Column(name = "CPU")
    private String CPU;

    @Column(name = "RAM")
    private String RAM;

    @Column(name = "ROM")
    private String ROM;

    @Column(name = "ManHinh")
    private String manHinh;

    @Column(name = "MauSac")
    private String mauSac;
//Dung Code
    @Column(name = "Pin")
    private String pin;

    @Column(name = "Camera")
    private String camera;

    @Column(name = "HeDieuHanh")
    private String heDieuHanh;

    @Column(name = "Anh")
    private byte[] anh;
//
//    @Column(name = "QR")
//    private String qr;

    @Column(name = "GiaBan")
    private BigDecimal giaBan;

    @Column(name = "ThoiGianBaoHanh")
    private int thoiGianBaoHanh;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "TrangThai")
    private int trangThai;

    @ManyToOne
    @JoinColumn(name = "IdHang")
    private Hang hang;

    @OneToMany(mappedBy = "dienThoai", fetch = FetchType.LAZY)
    private List<HoaDonChiTiet> listHDCT;

    @OneToMany(mappedBy = "dienThoai", fetch = FetchType.LAZY)
    private List<ChiTietKhuyenMai> listCTKM;

    public BigDecimal getGia(int soLuong) {
        return giaBan.multiply(BigDecimal.valueOf(soLuong));
    }

    @Override
    public String toString() {
        return tenDienThoai;
    }

    public DienThoai(UUID idDienThoai, String maDienThoai) {
        this.idDienThoai = idDienThoai;
        this.maDienThoai = maDienThoai;

    }

    public DienThoai(UUID idDienThoai, String maDienThoai, String tenDienThoai, int soLuongTon, String CPU, String RAM, String ROM, String manHinh, String mauSac, String pin, String camera, String heDieuHanh, byte[] anh, BigDecimal giaBan, int thoiGianBaoHanh, String moTa, int trangThai, Hang hang, List<HoaDonChiTiet> listHDCT, List<ChiTietKhuyenMai> listCTKM) {
        this.idDienThoai = idDienThoai;
        this.maDienThoai = maDienThoai;
        this.tenDienThoai = tenDienThoai;
        this.soLuongTon = soLuongTon;
        this.CPU = CPU;
        this.RAM = RAM;
        this.ROM = ROM;
        this.manHinh = manHinh;
        this.mauSac = mauSac;
        this.pin = pin;
        this.camera = camera;
        this.heDieuHanh = heDieuHanh;
        this.anh = anh;
        this.giaBan = giaBan;
        this.thoiGianBaoHanh = thoiGianBaoHanh;
        this.moTa = moTa;
        this.trangThai = trangThai;
        this.hang = hang;
        this.listHDCT = listHDCT;
        this.listCTKM = listCTKM;
    }

    public DienThoai(UUID idDienThoai, String maDienThoai, String tenDienThoai, int soLuongTon, String CPU, String RAM, String ROM, String manHinh, String mauSac, String pin, String camera, String heDieuHanh, byte[] anh, BigDecimal giaBan, int thoiGianBaoHanh, String moTa, int trangThai) {
        this.idDienThoai = idDienThoai;
        this.maDienThoai = maDienThoai;
        this.tenDienThoai = tenDienThoai;
        this.soLuongTon = soLuongTon;
        this.CPU = CPU;
        this.RAM = RAM;
        this.ROM = ROM;
        this.manHinh = manHinh;
        this.mauSac = mauSac;
        this.pin = pin;
        this.camera = camera;
        this.heDieuHanh = heDieuHanh;
        this.anh = anh;
        this.giaBan = giaBan;
        this.thoiGianBaoHanh = thoiGianBaoHanh;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }

    public UUID getIdDienThoai() {
        return idDienThoai;
    }

    public void setIdDienThoai(UUID idDienThoai) {
        this.idDienThoai = idDienThoai;
    }

    public String getMaDienThoai() {
        return maDienThoai;
    }

    public void setMaDienThoai(String maDienThoai) {
        this.maDienThoai = maDienThoai;
    }

    public String getTenDienThoai() {
        return tenDienThoai;
    }

    public void setTenDienThoai(String tenDienThoai) {
        this.tenDienThoai = tenDienThoai;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getRAM() {
        return RAM;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public String getROM() {
        return ROM;
    }

    public void setROM(String ROM) {
        this.ROM = ROM;
    }

    public String getManHinh() {
        return manHinh;
    }

    public void setManHinh(String manHinh) {
        this.manHinh = manHinh;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getHeDieuHanh() {
        return heDieuHanh;
    }

    public void setHeDieuHanh(String heDieuHanh) {
        this.heDieuHanh = heDieuHanh;
    }

    public byte[] getAnh() {
        return anh;
    }

    public void setAnh(byte[] anh) {
        this.anh = anh;
    }

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }

    public int getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }

    public void setThoiGianBaoHanh(int thoiGianBaoHanh) {
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public Hang getHang() {
        return hang;
    }

    public void setHang(Hang hang) {
        this.hang = hang;
    }

    public List<HoaDonChiTiet> getListHDCT() {
        return listHDCT;
    }

    public void setListHDCT(List<HoaDonChiTiet> listHDCT) {
        this.listHDCT = listHDCT;
    }

    public List<ChiTietKhuyenMai> getListCTKM() {
        return listCTKM;
    }

    public void setListCTKM(List<ChiTietKhuyenMai> listCTKM) {
        this.listCTKM = listCTKM;
    }

}
