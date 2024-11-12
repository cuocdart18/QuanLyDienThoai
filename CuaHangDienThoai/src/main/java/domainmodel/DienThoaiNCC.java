/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import domainmodel.DienThoai;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import org.hibernate.annotations.Type;

/**
 *
 * @author ongbi
 */
@Table(name = "DienThoaiNCC")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class DienThoaiNCC implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "IdDTNCC")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "IdNCC")
    private NhaCungCap nhaCungCap;

    @ManyToOne
    @JoinColumn(name = "IdDT")
    private DienThoai dienThoai;

    @Column(name = "GiaNhap")
    private BigDecimal giaNhap;

    @Column(name = "SoLuongNhap")
    private int soLuongNhap;

    @Column(name = "NgayNhap")
    private Date ngayNhap;

    public DienThoaiNCC(UUID id, NhaCungCap nhaCungCap, DienThoai dienThoai, BigDecimal giaNhap, int soLuongNhap, Date ngayNhap) {
        this.id = id;
        this.nhaCungCap = nhaCungCap;
        this.dienThoai = dienThoai;
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

    public DienThoai getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(DienThoai dienThoai) {
        this.dienThoai = dienThoai;
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
