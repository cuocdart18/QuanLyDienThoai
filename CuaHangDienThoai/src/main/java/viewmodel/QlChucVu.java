/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.math.BigDecimal;
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
public class QlChucVu {

    private UUID id;
    private String Ma;
    private String Ten;
    private BigDecimal Luong;
    private int QuyenSD;

    public QlChucVu() {
    }

    public QlChucVu(UUID id, String Ma, String Ten, BigDecimal Luong, int QuyenSD) {
        this.id = id;
        this.Ma = Ma;
        this.Ten = Ten;
        this.Luong = Luong;
        this.QuyenSD = QuyenSD;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String Ma) {
        this.Ma = Ma;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public BigDecimal getLuong() {
        return Luong;
    }

    public void setLuong(BigDecimal Luong) {
        this.Luong = Luong;
    }

    public int getQuyenSD() {
        return QuyenSD;
    }

    public void setQuyenSD(int QuyenSD) {
        this.QuyenSD = QuyenSD;
    }

}
