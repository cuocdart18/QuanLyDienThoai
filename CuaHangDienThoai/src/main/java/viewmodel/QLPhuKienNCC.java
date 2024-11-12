/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Admin
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QLPhuKienNCC {

    private UUID id;
    private UUID inhaCungCap;
    private UUID iphuKien;
    private String manhaCungCap;
    private String maphuKien;
    private BigDecimal giaNhap;
    private int soLuongNhap;
    private Date ngayNhap;

    public BigDecimal tongTien(BigDecimal gia, int soLuong) {
        BigDecimal convertSo = new BigDecimal(soLuong);
        BigDecimal tongTien = gia.multiply(convertSo);
        return tongTien;

    }

    public QLPhuKienNCC() {
    }

    public QLPhuKienNCC(UUID id, UUID inhaCungCap, UUID iphuKien, String manhaCungCap, String maphuKien, BigDecimal giaNhap, int soLuongNhap, Date ngayNhap) {
        this.id = id;
        this.inhaCungCap = inhaCungCap;
        this.iphuKien = iphuKien;
        this.manhaCungCap = manhaCungCap;
        this.maphuKien = maphuKien;
        this.giaNhap = giaNhap;
        this.soLuongNhap = soLuongNhap;
        this.ngayNhap = ngayNhap;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getInhaCungCap() {
        return inhaCungCap;
    }

    public void setInhaCungCap(UUID inhaCungCap) {
        this.inhaCungCap = inhaCungCap;
    }

    public UUID getIphuKien() {
        return iphuKien;
    }

    public void setIphuKien(UUID iphuKien) {
        this.iphuKien = iphuKien;
    }

    public String getManhaCungCap() {
        return manhaCungCap;
    }

    public void setManhaCungCap(String manhaCungCap) {
        this.manhaCungCap = manhaCungCap;
    }

    public String getMaphuKien() {
        return maphuKien;
    }

    public void setMaphuKien(String maphuKien) {
        this.maphuKien = maphuKien;
    }

    public BigDecimal getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(BigDecimal giaNhap) {
        this.giaNhap = giaNhap;
    }

    public int getSoLuongNhap() {
        return soLuongNhap;
    }

    public void setSoLuongNhap(int soLuongNhap) {
        this.soLuongNhap = soLuongNhap;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

}
