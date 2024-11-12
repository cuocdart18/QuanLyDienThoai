/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import domainmodel.PhuKien;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
@Entity
@Table(name = "PhuKienNCC")
public class PhuKienNCC implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdPhuKienNCC")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "IdNCC")
    private NhaCungCap nhaCungCap;

    @ManyToOne
    @JoinColumn(name = "IdPK")
    private PhuKien phuKien;

    @Column(name = "GiaNhap")
    private BigDecimal giaNhap;

    @Column(name = "SoLuongNhap")
    private int soLuongNhap;

    @Column(name = "ngayNhap")
    private Date ngayNhap;

    public PhuKienNCC(UUID id, NhaCungCap nhaCungCap, PhuKien phuKien, BigDecimal giaNhap, int soLuongNhap, Date ngayNhap) {
        this.id = id;
        this.nhaCungCap = nhaCungCap;
        this.phuKien = phuKien;
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

    public NhaCungCap getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(NhaCungCap nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public PhuKien getPhuKien() {
        return phuKien;
    }

    public void setPhuKien(PhuKien phuKien) {
        this.phuKien = phuKien;
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
