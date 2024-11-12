/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author hoant
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class KhuyenMaiViewModel {

    private UUID id;
    private String maKM;
    private String tenKM;
    private BigDecimal mucKhuyenMai;
    private String hinhThucKhuyenMai;
    private Date ngayBatDau;
    private Date ngayKT;
    private Integer trangThai;
    private String moTa;

    public Object[] toDataRow() {
//        Date today = new Date(System.currentTimeMillis());
        return new Object[]{maKM, tenKM, hinhThucKhuyenMai, mucKhuyenMai, ngayBatDau, ngayKT, trangThai == 1 ? "Đang hoạt động" : "Hết hiệu lực", moTa};
    }

    public KhuyenMaiViewModel() {
    }

    public KhuyenMaiViewModel(String maKM, String tenKM, BigDecimal mucKhuyenMai, String hinhThucKhuyenMai, Date ngayBatDau, Date ngayKT, Integer trangThai, String moTa) {
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.mucKhuyenMai = mucKhuyenMai;
        this.hinhThucKhuyenMai = hinhThucKhuyenMai;
        this.ngayBatDau = ngayBatDau;
        this.ngayKT = ngayKT;
        this.trangThai = trangThai;
        this.moTa = moTa;
    }

    public KhuyenMaiViewModel(UUID id, String maKM, String tenKM, BigDecimal mucKhuyenMai, String hinhThucKhuyenMai, Date ngayBatDau, Date ngayKT, Integer trangThai, String moTa) {
        this.id = id;
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.mucKhuyenMai = mucKhuyenMai;
        this.hinhThucKhuyenMai = hinhThucKhuyenMai;
        this.ngayBatDau = ngayBatDau;
        this.ngayKT = ngayKT;
        this.trangThai = trangThai;
        this.moTa = moTa;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public String getTenKM() {
        return tenKM;
    }

    public void setTenKM(String tenKM) {
        this.tenKM = tenKM;
    }

    public BigDecimal getMucKhuyenMai() {
        return mucKhuyenMai;
    }

    public void setMucKhuyenMai(BigDecimal mucKhuyenMai) {
        this.mucKhuyenMai = mucKhuyenMai;
    }

    public String getHinhThucKhuyenMai() {
        return hinhThucKhuyenMai;
    }

    public void setHinhThucKhuyenMai(String hinhThucKhuyenMai) {
        this.hinhThucKhuyenMai = hinhThucKhuyenMai;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(Date ngayKT) {
        this.ngayKT = ngayKT;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

}
