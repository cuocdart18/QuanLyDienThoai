/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import java.time.LocalDateTime;
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
 * @author sktfk
 */
@Entity
@Table(name = "HoaDon")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HoaDon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDHD")
    private UUID idHD;

    @Column(name = "MaHD")
    private String MaHD;

    @Column(name = "NgayTao")
    private LocalDateTime ngayTao;

    @Column(name = "NgayThanhToan")
    private LocalDateTime NgayThanhToan;

    @Column(name = "DiemTichLuy")
    private Integer DiemTichLuy;

    @Column(name = "TrangThai")
    private Integer trangThai;
    
    @OneToMany(mappedBy = "hoaDon", fetch = FetchType.LAZY)
    private List<HoaDonChiTiet> list;
    @ManyToOne
    @JoinColumn(name = "IdKH")
    private KhachHang khachHang;
    
    @ManyToOne
    @JoinColumn(name = "IdNhanVien")
    private NhanVien nhanVien;

    public String getTrangThaiStr() {
        return trangThai == 0 ? "Chờ thanh toán" : trangThai==1?"Đã thanh toán":"Huỷ";
    }

    @Override
    public String toString() {
        return "HoaDon{" + "idHD=" + idHD + ", MaHD=" + MaHD + ", NgayTao=" + ngayTao + ", NgayThanhToan=" + NgayThanhToan + ", DiemTichLuy=" + DiemTichLuy + ", TrangThai=" + trangThai + '}';
    }

    public HoaDon() {
    }

    public HoaDon(UUID idHD, String MaHD, LocalDateTime ngayTao, LocalDateTime NgayThanhToan, Integer DiemTichLuy, Integer trangThai, List<HoaDonChiTiet> list, KhachHang khachHang, NhanVien nhanVien) {
        this.idHD = idHD;
        this.MaHD = MaHD;
        this.ngayTao = ngayTao;
        this.NgayThanhToan = NgayThanhToan;
        this.DiemTichLuy = DiemTichLuy;
        this.trangThai = trangThai;
        this.list = list;
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
    }

    public UUID getIdHD() {
        return idHD;
    }

    public void setIdHD(UUID idHD) {
        this.idHD = idHD;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public LocalDateTime getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDateTime ngayTao) {
        this.ngayTao = ngayTao;
    }

    public LocalDateTime getNgayThanhToan() {
        return NgayThanhToan;
    }

    public void setNgayThanhToan(LocalDateTime NgayThanhToan) {
        this.NgayThanhToan = NgayThanhToan;
    }

    public Integer getDiemTichLuy() {
        return DiemTichLuy;
    }

    public void setDiemTichLuy(Integer DiemTichLuy) {
        this.DiemTichLuy = DiemTichLuy;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    public List<HoaDonChiTiet> getList() {
        return list;
    }

    public void setList(List<HoaDonChiTiet> list) {
        this.list = list;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    
}
