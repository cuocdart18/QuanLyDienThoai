/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import domainmodel.Hang;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author dungp
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QLDienThoai {
// Dũng Code

    private UUID idDienThoai;
    private String maDienThoai;
    private String tenDienThoai;
    private Integer soLuongTon;
    private String CPU;
    private String RAM;
    private String ROM;
    private String manHinh;
    private String mauSac;
    private String pin;
    private String camera;
    private String heDieuHanh;
    private byte[] anh;
    private BigDecimal giaBan;
    private int thoiGianBaoHanh;
    private String mota;
    private int trangThai;
    private Hang hang;

//    public QLDienThoai(String tenDienThoai, int soLuongTon, String RAM, String ROM, String manHinh, String mauSac, BigDecimal giaBan, int thoiGianBaoHanh, int trangThai) {
//        this.tenDienThoai = tenDienThoai;
//        this.soLuongTon= soLuongTon;
//        this.RAM = RAM;
//        this.ROM = ROM;
//        this.manHinh = manHinh;
//        this.mauSac = mauSac;
//        this.giaBan = giaBan;
//        this.thoiGianBaoHanh = thoiGianBaoHanh;
//        this.trangThai = trangThai;
//    }
    public QLDienThoai(UUID idDienThoai, String maDienThoai, String tenDienThoai, Integer soLuongTon, String CPU, String RAM, String ROM, String manHinh, String mauSac, String pin, String camera, String heDieuHanh, byte[] anh, BigDecimal giaBan, int thoiGianBaoHanh, String mota, int trangThai) {
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
        this.mota = mota;
        this.trangThai = trangThai;
    }

    public QLDienThoai(UUID idDienThoai, String maDienThoai, String tenDienThoai, Integer soLuongTon, String CPU, String RAM, String ROM, String manHinh, String mauSac, String pin, String camera, String heDieuHanh, byte[] anh, BigDecimal giaBan, int thoiGianBaoHanh, String mota, int trangThai, Hang hang) {
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
        this.mota = mota;
        this.trangThai = trangThai;
        this.hang = hang;
    }

    public QLDienThoai() {
    }

    @Override
    public String toString() {
        return "QLDienThoai{" + "idDienThoai=" + idDienThoai + ", maDienThoai=" + maDienThoai + ", tenDienThoai=" + tenDienThoai + ", soLuongTon=" + soLuongTon + ", CPU=" + CPU + ", RAM=" + RAM + ", ROM=" + ROM + ", manHinh=" + manHinh + ", mauSac=" + mauSac + ", pin=" + pin + ", camera=" + camera + ", heDieuHanh=" + heDieuHanh + ", anh=" + anh + ", giaBan=" + giaBan + ", thoiGianBaoHanh=" + thoiGianBaoHanh + ", mota=" + mota + ", trangThai=" + trangThai + ", hang=" + hang + '}';
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

    public Integer getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(Integer soLuongTon) {
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

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
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
