/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import java.util.List;
import java.math.BigDecimal;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "HoaDonChiTiet")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HoaDonChiTiet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdHDCT")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "IdDienThoai")
    private DienThoai dienThoai;

    @ManyToOne
    @JoinColumn(name = "IdHD")
    private HoaDon hoaDon;

    @ManyToOne
    @JoinColumn(name = "IdPK")
    private PhuKien phuKien;

    @OneToOne
    @JoinColumn(name = "IdCTKM")
    private ChiTietKhuyenMai ctkm;

    @Column(name = "SoLuong")
    private int soLuong;

    @Column(name = "DonGia")
    private BigDecimal donGia;

    @Override
    public String toString() {
        return dienThoai == null ? phuKien.getTen() : dienThoai.getTenDienThoai();
    }

    public BigDecimal getGia() {
        return donGia.multiply(BigDecimal.valueOf(soLuong));
    }

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(UUID id, DienThoai dienThoai, HoaDon hoaDon, PhuKien phuKien, ChiTietKhuyenMai ctkm, int soLuong, BigDecimal donGia) {
        this.id = id;
        this.dienThoai = dienThoai;
        this.hoaDon = hoaDon;
        this.phuKien = phuKien;
        this.ctkm = ctkm;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public DienThoai getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(DienThoai dienThoai) {
        this.dienThoai = dienThoai;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public PhuKien getPhuKien() {
        return phuKien;
    }

    public void setPhuKien(PhuKien phuKien) {
        this.phuKien = phuKien;
    }

    public ChiTietKhuyenMai getCtkm() {
        return ctkm;
    }

    public void setCtkm(ChiTietKhuyenMai ctkm) {
        this.ctkm = ctkm;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

}
