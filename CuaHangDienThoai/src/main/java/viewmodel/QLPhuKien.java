/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import domainmodel.Hang;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QLPhuKien {
    
    private UUID id;
    private String ma;
    private String ten;
    private int soLuong;
    private BigDecimal giaBan;
    private byte[] anh;
    private int thoiGianBaoHanh;
    private String moTa;
    private int trangThai;
    private Hang hang;
    
    public Object[] toDataRow(){
        return new Object[]{ten, soLuong, giaBan, thoiGianBaoHanh, moTa, trangThai == 1 ? "Đang bán" : "Ngừng bán"};
    }

    @Override
    public String toString() {
        return "QLPhuKien{" + "id=" + id + ", ma=" + ma + ", ten=" + ten + ", soLuong=" + soLuong + ", giaBan=" + giaBan + ", anh=" + anh + ", thoiGianBaoHanh=" + thoiGianBaoHanh + ", moTa=" + moTa + ", trangThai=" + trangThai + ", hang=" + hang + '}';
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

    
}
