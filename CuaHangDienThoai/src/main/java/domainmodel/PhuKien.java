/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import domainmodel.Hang;
import java.math.BigDecimal;
import java.util.Date;
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
 * @author Admin
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "PhuKien")
public class PhuKien {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDPhuKien", length = 36)
    private UUID id;

    @Column(name = "MaPhuKien")
    private String ma;

    @Column(name = "TenPhuKien")
    private String ten;

    @Column(name = "SoLuongTon")
    private int soLuong;

    @Column(name = "GiaBan")
    private BigDecimal giaBan;

    @Column(name = "Anh", nullable = true)
    private byte[] anh;

    @Column(name = "ThoiGianBaoHanh")
    private int thoiGianBaoHanh;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "TrangThai")
    private int trangThai;

    @ManyToOne
    @JoinColumn(name = "IDHang")
    private Hang hang;

    @OneToMany(mappedBy = "phuKien", fetch = FetchType.LAZY)
    private List<HoaDonChiTiet> listHDCT;

    @OneToMany(mappedBy = "phuKien", fetch = FetchType.LAZY)
    private List<ChiTietKhuyenMai> listCTKM;

    public PhuKien(UUID id, String ma, String ten, int soLuong, BigDecimal giaBan, byte[] anh, int thoiGianBaoHanh, String moTa, int trangThai) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.anh = anh;
        this.thoiGianBaoHanh = thoiGianBaoHanh;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }

    public PhuKien(UUID id, String ma, String ten, int soLuong, BigDecimal giaBan, byte[] anh, int thoiGianBaoHanh, String moTa, int trangThai, Hang hang, List<HoaDonChiTiet> listHDCT, List<ChiTietKhuyenMai> listCTKM) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.anh = anh;
        this.thoiGianBaoHanh = thoiGianBaoHanh;
        this.moTa = moTa;
        this.trangThai = trangThai;
        this.hang = hang;
        this.listHDCT = listHDCT;
        this.listCTKM = listCTKM;
    }

    public PhuKien(UUID id, String ma) {
        this.id = id;
        this.ma = ma;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }

    public byte[] getAnh() {
        return anh;
    }

    public void setAnh(byte[] anh) {
        this.anh = anh;
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
