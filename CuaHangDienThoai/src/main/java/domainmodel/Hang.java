package domainmodel;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Hang")
public class Hang implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", length = 36)
    private UUID id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "TrangThai")
    private int trangThai;

    @OneToMany(mappedBy = "hang", fetch = FetchType.LAZY)
    private List<PhuKien> phuKien;

    @OneToMany(mappedBy = "hang", fetch = FetchType.LAZY)
    private List<DienThoai> dienThoai;

    public Hang(UUID id, String ma, String ten, int trangThai, List<PhuKien> phuKien, List<DienThoai> dienThoai) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.trangThai = trangThai;
        this.phuKien = phuKien;
        this.dienThoai = dienThoai;
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

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public List<PhuKien> getPhuKien() {
        return phuKien;
    }

    public void setPhuKien(List<PhuKien> phuKien) {
        this.phuKien = phuKien;
    }

    public List<DienThoai> getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(List<DienThoai> dienThoai) {
        this.dienThoai = dienThoai;
    }

}
