/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import domainmodel.ChucVu;
import domainmodel.TaiKhoan;
import java.util.UUID;
import javax.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author lethi
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QLNhanVien {

    private UUID id;
    private String ma;
    private String hoTen;
    private Integer gioiTinh;
    private Integer namSinh;
    private String diaChi;
    private String cccd;
    private String email;
    private String sdt;
    private Integer trangThai;
    private byte[] anh;
    private String qr;
    private TaiKhoan taiKhoan;
    private ChucVu chucVu;

    public Object[] toDataRow() {
        return new Object[]{ma, hoTen, gioiTinh == 1 ? "Nam" : "Nữ", namSinh, diaChi, cccd, email, sdt, trangThai == 1 ? "Đang làm việc" : "Đã nghỉ việc"};
    }

    @Override
    public String toString() {
        return "QLNhanVien{" + "id=" + id + ", ma=" + ma + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", namSinh=" + namSinh + ", diaChi=" + diaChi + ", cccd=" + cccd + ", email=" + email + ", sdt=" + sdt + ", trangThai=" + trangThai + ", anh=" + anh + ", qr=" + qr + '}';
    }

    public QLNhanVien() {
    }

    public QLNhanVien(UUID id, String ma, String hoTen, Integer gioiTinh, Integer namSinh, String diaChi, String cccd, String email, String sdt, Integer trangThai, byte[] anh, String qr, TaiKhoan taiKhoan, ChucVu chucVu) {
        this.id = id;
        this.ma = ma;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.namSinh = namSinh;
        this.diaChi = diaChi;
        this.cccd = cccd;
        this.email = email;
        this.sdt = sdt;
        this.trangThai = trangThai;
        this.anh = anh;
        this.qr = qr;
        this.taiKhoan = taiKhoan;
        this.chucVu = chucVu;
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

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Integer getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Integer gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Integer getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(Integer namSinh) {
        this.namSinh = namSinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    public byte[] getAnh() {
        return anh;
    }

    public void setAnh(byte[] anh) {
        this.anh = anh;
    }

    public String getQr() {
        return qr;
    }

    public void setQr(String qr) {
        this.qr = qr;
    }

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public ChucVu getChucVu() {
        return chucVu;
    }

    public void setChucVu(ChucVu chucVu) {
        this.chucVu = chucVu;
    }

}
