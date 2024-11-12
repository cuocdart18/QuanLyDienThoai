/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

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
public class QLNhaCungCap {

    private UUID id;
    private String ma;
    private String diaChi;
    private String ten;
    private String sdt;
    private String email;
    private int trangThai;

    public String convertTrangThai(int number) {
        if (number == 0) {
            return "Dang Hoat Dong";
        } else {
            return "Khong Hoat Dong";
        }
    }

    public QLNhaCungCap() {
    }

    public QLNhaCungCap(UUID id, String ma, String diaChi, String ten, String sdt, String email, int trangThai) {
        this.id = id;
        this.ma = ma;
        this.diaChi = diaChi;
        this.ten = ten;
        this.sdt = sdt;
        this.email = email;
        this.trangThai = trangThai;
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

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

}
