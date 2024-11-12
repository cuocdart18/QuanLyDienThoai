/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

/**
 *
 * @author Admin
 */
import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

@Table(name = "NhaCungCap")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class NhaCungCap implements Serializable {

    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    @Column(name = "IdNCC")
    private UUID id;

    @Column(name = "MaNCC", unique = true)
    private String ma;

    @Column(name = "DiaChi", columnDefinition = "nvarchar(Max)")
    private String diaChi;

    @Column(name = "TenNhaCC", columnDefinition = "nvarchar(Max)")
    private String ten;

    @Column(name = "SDT")
    private String sdt;

    @Column(name = "Email")
    private String email;

    @Column(name = "TrangThai")
    private int trangThai;

    @OneToMany(mappedBy = "nhaCungCap", fetch = FetchType.LAZY)
    private List<DienThoaiNCC> listDienThoaiNCC;

    @OneToMany(mappedBy = "nhaCungCap", fetch = FetchType.LAZY)
    private List<PhuKienNCC> listPhuKienNCC;

    public NhaCungCap(UUID id, String ma) {
        this.id = id;
        this.ma = ma;
    }

    public NhaCungCap(UUID id, String ma, String diaChi, String ten, String sdt, String email, int trangThai, List<DienThoaiNCC> listDienThoaiNCC, List<PhuKienNCC> listPhuKienNCC) {
        this.id = id;
        this.ma = ma;
        this.diaChi = diaChi;
        this.ten = ten;
        this.sdt = sdt;
        this.email = email;
        this.trangThai = trangThai;
        this.listDienThoaiNCC = listDienThoaiNCC;
        this.listPhuKienNCC = listPhuKienNCC;
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

    public List<DienThoaiNCC> getListDienThoaiNCC() {
        return listDienThoaiNCC;
    }

    public void setListDienThoaiNCC(List<DienThoaiNCC> listDienThoaiNCC) {
        this.listDienThoaiNCC = listDienThoaiNCC;
    }

    public List<PhuKienNCC> getListPhuKienNCC() {
        return listPhuKienNCC;
    }

    public void setListPhuKienNCC(List<PhuKienNCC> listPhuKienNCC) {
        this.listPhuKienNCC = listPhuKienNCC;
    }

}
