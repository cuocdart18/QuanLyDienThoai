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
 * @author ongbi
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QLDTNhaCungCap {

    private UUID id;
    private UUID inhaCungCap;
    private UUID idienThoai;
    private String manhaCungCap;
    private String madienThoai;
    private BigDecimal giaNhap;
    private int soLuongNhap;
    private Date ngayNhap;

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

    public UUID getIdienThoai() {
        return idienThoai;
    }

    public void setIdienThoai(UUID idienThoai) {
        this.idienThoai = idienThoai;
    }

    public String getManhaCungCap() {
        return manhaCungCap;
    }

    public void setManhaCungCap(String manhaCungCap) {
        this.manhaCungCap = manhaCungCap;
    }

    public String getMadienThoai() {
        return madienThoai;
    }

    public void setMadienThoai(String madienThoai) {
        this.madienThoai = madienThoai;
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
