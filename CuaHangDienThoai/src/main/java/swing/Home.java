/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import domainmodel.DienThoai;
import domainmodel.Hang;
import domainmodel.HoaDon;
import domainmodel.HoaDonChiTiet;
import domainmodel.KhachHang;
import domainmodel.KhuyenMai;
import domainmodel.PhuKien;
import domainmodel.TaiKhoan;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
//import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;
import qr_code.Main;
import qr_code.MainDienThoai;
import qr_code.MainKH;
import repository.impl.ChiTietKhuyenMaiRepository;
import repository.impl.DienThoaiRepository;
import repository.impl.HoaDonChiTietRepository;
import repository.impl.HoaDonRepository;
import repository.impl.KhachHangRepository;
import repository.impl.KhuyenMaiRepository;
import service.CTKMService;
import service.IChucVuService;
import service.IDTNhaCungCapService;
import service.IDienThoaiService;
import service.IHangService;
import service.INhaCungCapService;
import service.INhanVienService;
import service.IPhuKienNCCService;
import service.IPhuKienService;
import service.ITaiKhoanService;
import service.KhachHangService;
import service.KhuyenMaiService;
import service.impl.CTKMServiceImpl;
import service.impl.ChucVuSevice;
import service.impl.DTNhaCungCapService;
import service.impl.DienThoaiService;
import service.impl.HangService;
import service.impl.KhachHangServiceImpl;
import service.impl.KhuyenMaiServiceImpl;
import service.impl.NhaCungCapService;
import util.ImageHelper;
import viewmodel.QLDienThoai;
import viewmodel.QLPhuKien;
import service.impl.PhuKienService;
import service.impl.NhanVienService;
import service.impl.PhuKienNCCService;
import service.impl.TaiKhoanService;
import support.ViewKhachHang;
import util.EmailSender;
import util.GenMa;
import viewmodel.ChiTietKMCustom;
import viewmodel.KhachHangViewMD;
import viewmodel.KhuyenMaiViewModel;
import viewmodel.QLHang;
import viewmodel.QLDTNhaCungCap;
import viewmodel.QLNhaCungCap;
import viewmodel.QLNhanVien;
import viewmodel.QLPhuKienNCC;
import viewmodel.QLTaiKhoan;
import viewmodel.QlChucVu;

/**
 *
 * @author Admin
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    //Tuấn Anh code
    DienThoaiRepository dienThoaiRepo = new DienThoaiRepository();
    public static KhachHang khachHangMua;
    //Test source tree
    //Tuấn Anh test
    //Hoa thêm code
    //Hoá Đơn
    HoaDonRepository hoaDonRepo = new HoaDonRepository();
    DefaultTableModel modelHoaDon;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    //Hoá đơn chi tiết
    static DefaultTableModel modelHDCT;
    HoaDonChiTietRepository hoaDonChiTietRepo;
//DienThoai Dũng Code
    private DefaultTableModel dtm = new DefaultTableModel();
    private DefaultComboBoxModel dcbmTrangThai = new DefaultComboBoxModel();
    private IDienThoaiService dienThoaiService = new DienThoaiService();
    private List<QLDienThoai> listQLDienThoai = new ArrayList<>();
    private List<String> cbbDienThoai = new ArrayList<>();
    private byte[] personalImage;
    private DefaultComboBoxModel dcbmHangDT = new DefaultComboBoxModel();
    private List<String> listCBBDT = new ArrayList<>();
    private IHangService iHangService = new HangService();
    private List<QLHang> listHang = new ArrayList<>();
    //Hết code của Dũng
    //Code của Vanh
    private DefaultTableModel dtmPhuKien1 = new DefaultTableModel();
    private List<QLPhuKien> listQLPhuKien = new ArrayList<>();
    private IPhuKienService iPhuKienService = new PhuKienService();
    private DefaultComboBoxModel dcbmTrangThaiPK = new DefaultComboBoxModel();
    private List<String> listCBBPK = new ArrayList<>();
    private DefaultTableModel dtmNhanVien = new DefaultTableModel();
    private List<QLNhanVien> listQLNhanVien = new ArrayList<>();
    private INhanVienService iNhanVienService = new NhanVienService();
    private DefaultComboBoxModel dcbmTrangThaiNV = new DefaultComboBoxModel();
    private List<String> listCBBNV = new ArrayList<>();
    private List<QLHang> listQLHang = new ArrayList<>();
    private DefaultComboBoxModel dcbmHangPK = new DefaultComboBoxModel();
    private List<QLTaiKhoan> listQLTaiKhoan = new ArrayList<>();
    private List<QlChucVu> listQlChucVu = new ArrayList<>();
    private DefaultComboBoxModel dcbmTenTK = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcbmMK = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcbmChucVu = new DefaultComboBoxModel();
    private ITaiKhoanService iTaiKhoanService = new TaiKhoanService();
    private IChucVuService iChucVuService = new ChucVuSevice();
    private EmailSender emailSender = new EmailSender();
    //Hết code của Vanh
    //Code của Hoa
    private DefaultTableModel dtmKH = new DefaultTableModel();
    private DefaultTableModel dtmKMFT;
    private DefaultTableModel dtmKM;
    private DefaultTableModel dtmDTKM;
    private DefaultTableModel dtmPKKM;
    private DefaultComboBoxModel dcmTT = new DefaultComboBoxModel();
    private List<KhachHangViewMD> listKH = new ArrayList<>();
    private List<ChiTietKMCustom> listKM = new ArrayList<>();
    private KhachHangService khService = new KhachHangServiceImpl();
    private KhuyenMaiService kmService = new KhuyenMaiServiceImpl();
    private CTKMService ctkmService = new CTKMServiceImpl();
    private DefaultComboBoxModel dcbm = new DefaultComboBoxModel();

    /**
     * Random string with a-zA-Z0-9, not included special characters
     */
    private static Random generator = new Random();
    private static final String alpha = "abcdefghijklmnopqrstuvwxyz"; // a-z
    private static final String alphaUpperCase = alpha.toUpperCase(); // A-Z
    private static final String digits = "0123456789"; // 0-9
    private static final String ALPHA_NUMERIC = alpha + alphaUpperCase + digits;

    //CodeTien
    private int row;

    private DefaultTableModel dtmNcc = new DefaultTableModel();
    private DefaultTableModel dtmNccVc = new DefaultTableModel();
    private DefaultTableModel dtmPhuKien = new DefaultTableModel();
    private DefaultTableModel dtmPhuKienNcc = new DefaultTableModel();
    private DefaultTableModel dtmChonDt = new DefaultTableModel();
    private DefaultTableModel dtmChonNccDt = new DefaultTableModel();
    private DefaultTableModel dtmDtNcc = new DefaultTableModel();
    private INhaCungCapService nccService = new NhaCungCapService();
    private IPhuKienService phuKienService = new PhuKienService();
    private IPhuKienNCCService phuKienNCCService = new PhuKienNCCService();
    private INhaCungCapService iNhaCungCapService = new NhaCungCapService();
//    private IDienThoaiService dienThoaiService = new DienThoaiService();
    private IDTNhaCungCapService dtNccService = new DTNhaCungCapService();
    private List<QLNhaCungCap> listNcc = new ArrayList<>();
    private List<QLPhuKien> listPhuKien = new ArrayList<>();
    private List<QLPhuKienNCC> listPKNCC = new ArrayList<>();
    private List<QLDienThoai> listDt = new ArrayList<>();
    private List<QLDTNhaCungCap> listDTNCC = new ArrayList<>();

    public String randomAlphaNumeric(int numberOfCharactor) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfCharactor; i++) {
            int number = randomNumber(0, ALPHA_NUMERIC.length() - 1);
            char ch = ALPHA_NUMERIC.charAt(number);
            sb.append(ch);
        }
        return sb.toString();
    }

    public static int randomNumber(int min, int max) {
        return generator.nextInt((max - min) + 1) + min;
    }
//    public static void main(String[] args) {
//        System.out.println(new RandomStringUtils().randomAlphanumeric(6));
//    }
//Hết code Hoa

    public Home() {
        initComponents();
        resetColor(new JPanel[]{btn_2, btn_3, btn_4}, new JPanel[]{ind_2, ind_3, ind_4});
        this.setExtendedState(MAXIMIZED_BOTH);
        modelHoaDon = (DefaultTableModel) tblHoaDon.getModel();
        modelHDCT = (DefaultTableModel) tblHoaDonChiTiet.getModel();
        GridLayout gridLayout = new GridLayout(0, 6, 7, 5);
//        FlowLayout flowLayout = new FlowLayout();
//        flowLayout.setAlignment(FlowLayout.LEFT);
//        flowLayout.setHgap(5);
//        flowLayout.setVgap(5);
//        flowLayout.setAlignOnBaseline(true);
        pnlSanPham.setLayout(gridLayout);
        pnlSanPham.setAutoscrolls(true);
//        Dimension maxSize = pnlSanPham.getMaximumSize();
//        maxSize.setSize(maxSize.getWidth(), maxSize.getHeight() * 2);
        //pnlSanPham.setPreferredSize(maxSize);

        codeTuanAnh();
        codeDung();
        codeHoa();
        codeVanh();
        codeTien();
    }

    void codeTien() {
        tbNcc.setModel(dtmNcc);
        tbChonNCCPK.setModel(dtmNccVc);
        tbChonPK.setModel(dtmPhuKien);
        tbPKNCC.setModel(dtmPhuKienNcc);
        tbChonDt.setModel(dtmChonDt);
        tbChonNccDt.setModel(dtmChonNccDt);
        tbDTNCC.setModel(dtmDtNcc);
        listNcc = nccService.getAll();
        listPhuKien = phuKienService.getAll();
        listPKNCC = phuKienNCCService.getAll();
        listDt = dienThoaiService.getAll();
        listDTNCC = dtNccService.getAll();
        String[] headerNhaCungCap = {"Ma", "Ten", "Dia chi", "Email", "Sdt", "Trang Thai"};
        String[] headerNhaCungCap2 = {"Ma", "Ten", "Trang Thai"};
        String[] headerPhuKien = {"Ma", "Ten"};
        String[] headerPKNCC = {"Ma Phu Kien", "Ma Nha Cung Cap", "So Luong", "Gia Nhap", "Tong Tien"};
        String[] headerDienThoai = {"Ma", "Ten"};
        String[] headerDtNcc = {"Ma Dien Thoai", "Ma Nha Cung Cap", "So Luong", "Gia Nhap"};
        dtmNcc.setColumnIdentifiers(headerNhaCungCap);
        dtmPhuKien.setColumnIdentifiers(headerPhuKien);
        dtmPhuKienNcc.setColumnIdentifiers(headerPKNCC);
        dtmNccVc.setColumnIdentifiers(headerNhaCungCap2);
        dtmChonDt.setColumnIdentifiers(headerDienThoai);
        dtmChonNccDt.setColumnIdentifiers(headerNhaCungCap2);
        dtmDtNcc.setColumnIdentifiers(headerDtNcc);
        showDataTable();
    }

    void codeTuanAnh() {
        //code Tuấn Anh
        hoaDonChiTietRepo = new HoaDonChiTietRepository();
        fillToHoaDon(hoaDonRepo.getAll());
        addPanelDienThoai();
        addPanelPhuKien();
    }

    private void codeHoa() {
        //Code của Hoa
        dtmPKKM = (DefaultTableModel) tblPKKM.getModel();
        dtmDTKM = (DefaultTableModel) tblDienThoaiKM.getModel();
        dtmKM = (DefaultTableModel) tblKM.getModel();
        tblListData.setModel(dtmKH);
        tblPKKM.setModel(dtmPKKM);
        tblKM.setModel(dtmKM);
        tblDienThoaiKM.setModel(dtmDTKM);
        tblListData.setModel(dtmKH);
        cbbHTKM.setModel(dcbm);
        dcbm.addElement("%");
        dcbm.addElement("Giá tiền");

        String[] headerKH = {"Mã KH", "Họ và tên", "Giới tính", "SĐT", "Email", "Địa chỉ", "Ngày sinh", "Điểm tích lũy", "Ghi chú"};
        dtmKH.setColumnIdentifiers(headerKH);
        dcmTT.addElement("Đang hoạt động");
        dcmTT.addElement("Hết hiệu lực");
        listKH = khService.getAll();
//        listKM = ctkmService.getAll();
        showTableKH(listKH);
        // showTableKM(listKM);
        showTableKM();
        showTableDTKM(listQLDienThoai);
        showTablePKKM(listQLPhuKien);
        tblHoaDon.getTableHeader().setBackground(new Color(13, 83, 193));
        tblHoaDon.getTableHeader().setOpaque(false);
        tblHoaDon.getTableHeader().setForeground(Color.WHITE);
        tblHoaDon.getTableHeader().setFont(new Font("Segoe UI", Font.PLAIN, 16));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//Hết code Hoa
    }

    void codeVanh() {
        // Code của Vanh
        String[] headersPK = {"Tên", "Số lượng", "Giá bán", "Thời gian bảo hành", "Mô tả", "Trạng thái"};
        dtmPhuKien1.setColumnIdentifiers(headersPK);
        tblPhuKien.setModel(dtmPhuKien1);
        cbbTenHangPK.setModel(dcbmHangPK);
        cbbChucVuNV.setModel(dcbmChucVu);
        cbbTenTKNV.setModel(dcbmTenTK);
        cbbMKNV.setModel(dcbmMK);
        listQLPhuKien = iPhuKienService.getAll();
        listQLHang = iHangService.getHHD();
        listQLTaiKhoan = iTaiKhoanService.getAll();
        listQlChucVu = iChucVuService.getAll();
        showDataTablePK(listQLPhuKien);
        cbbTrangThaiPK.setModel(dcbmTrangThaiPK);
        listCBBPK.add("Đang bán");
        listCBBPK.add("Ngừng bán");
        for (String item : listCBBPK) {
            dcbmTrangThaiPK.addElement(item);
        }
        String[] headersNV = {"Mã NV", "Họ tên", "Giới tính", "Năm Sinh", "Địa chỉ", "CCCD", "Email", "SĐT", "Trạng Thái"};
        dtmNhanVien.setColumnIdentifiers(headersNV);
        tblNhanVien.setModel(dtmNhanVien);
        listQLNhanVien = iNhanVienService.getAll();
        showDataTableNV(listQLNhanVien);
        cbbTrangThaiNV.setModel(dcbmTrangThaiNV);
        listCBBNV.add("Đang làm việc");
        listCBBNV.add("Đã nghỉ việc");
        for (String item : listCBBNV) {
            dcbmTrangThaiNV.addElement(item);
        }
        for (QLHang tenHang : listQLHang) {
            dcbmHangPK.addElement(tenHang.getTen());
        }
        for (QLTaiKhoan tk : listQLTaiKhoan) {
            dcbmTenTK.addElement(tk.getTenTaiKhoan());
            dcbmMK.addElement(tk.getMatKhau());
        }
        for (QlChucVu cv : listQlChucVu) {
            dcbmChucVu.addElement(cv.getTen());
        }

    }

    void codeDung() {
        //Dũng Code
        String[] header = {"Tên Điện Thoại", "Số Lượng", "RAM", "ROM", "Màn Hình", "Màu Sắc", "Giá Bán", "Thời Gian Bảo Hành", "Trạng Thái"};
        tblListDienThoai.setModel(dtm);
        dtm.setColumnIdentifiers(header);
        showData(listQLDienThoai = dienThoaiService.getAll());
        cbbTrangThaiDT.setModel(dcbmTrangThai);
        cbbTenHangDT.setModel(dcbmHangDT);
        cbbDienThoai.add("Đang Bán");
        cbbDienThoai.add("Ngừng Bán");
        for (String a : cbbDienThoai) {
            dcbmTrangThai.addElement(a);
        }
        listHang = iHangService.getHHD();
        cbbTenHangDT.setModel(dcbmHangDT);
        for (QLHang icon : listHang) {
            dcbmHangDT.addElement(icon.getTen());
        }
        txtGiaNhapDienThoai.setEnabled(false);
        txtSoLuongDienThoai.setEnabled(false);
        txtMaDienThoai.setEnabled(false);
    }

    private String maDTTuTang() {
        String maHD = " ";
        String s1 = "DT";
        for (int i = 1; i < listQLDienThoai.size() + 2; i++) {
            maHD = s1 + i;
        }
        return maHD;
    }

    private String maPK() {
        String maPK = " ";
        String s1 = "PK";
        for (int i = 1; i < listQLPhuKien.size() + 2; i++) {
            maPK = s1 + i;
        }
        return maPK;
    }
    // Hết code Dũng
//code Hoa

    //code Hoa
    private void showTableKH(List<KhachHangViewMD> lists) {
        listQLDienThoai = dienThoaiService.getAll();
        dtmKH.setRowCount(0);
        for (KhachHangViewMD x : lists) {
            dtmKH.addRow(x.toDataRow());
        }
    }

    private String maKH() {
        String maKH = " ";
        String s1 = "KH";
        for (int i = 1; i < listKH.size() + 2; i++) {
            maKH = s1 + i;
        }
        return maKH;
    }

    private void showTableKM(List<ChiTietKMCustom> lists) {
        //vấn đề???  listQLPhuKien = iPhuKienService.getAll();
        dtmKM.setRowCount(0);
        for (ChiTietKMCustom x : lists) {
            dtmKM.addRow(x.toDataRow());
        }
    }

    private void showTableKM() {
        //vấn đề???  listQLPhuKien = iPhuKienService.getAll();
        dtmKM.setRowCount(0);
        for (KhuyenMai x : ChiTietKhuyenMaiRepository.getAll1()) {
            dtmKM.addRow(new Object[]{x, x.getTenKM(), x.getHT(), x.getMucKhuyenMai(), x.getNgayBatDau(), x.getNgayKT(), x.getHD(), x.getMoTa()});
        }
    }

    private void showTableKM(List<KhuyenMai> l, String a) {
        //vấn đề???  listQLPhuKien = iPhuKienService.getAll();
        dtmKM.setRowCount(0);
        if (l == null) {
            return;
        }
        for (KhuyenMai x : l) {
            dtmKM.addRow(new Object[]{x, x.getTenKM(), x.getHT(), x.getMucKhuyenMai(), x.getNgayBatDau(), x.getNgayKT(), x.getHD(), x.getMoTa()});
        }
    }

    private void showTableDTKM(List<QLDienThoai> lists) {
        dtmDTKM.setRowCount(0);
        int stt = 1;
        for (QLDienThoai x : lists) {
            dtmDTKM.addRow(new Object[]{stt++, x.getMaDienThoai(), x.getTenDienThoai(), false});
        }
    }

    private void showTablePKKM(List<QLPhuKien> lists) {
        dtmPKKM.setRowCount(0);
        int stt = 1;
        for (QLPhuKien x : lists) {
            dtmPKKM.addRow(new Object[]{stt++, x.getMa(), x.getTen(), false});
        }
    }

    //Code FillData Hoa
    private void fillDataKH(int i) {
        java.util.Date date = new java.util.Date();
        SimpleDateFormat formatter = new SimpleDateFormat("d/MM/yyyy");
//        String strDate = formatter.format(date);
        KhachHangViewMD kh = listKH.get(i);
        txtCCCD.setText(kh.getMaKH());
        txtDiaChi.setText(kh.getDiaChi());
        txtDiemTichLuy.setText(kh.getDiemTichLuy() + "");
        txtEmail.setText(kh.getEmail());
        txtSDT.setText(kh.getSDT());
        txtGhiChu.setText(kh.getGhiChu());
        if (kh.getGioiTinh() == 1) {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }
        datePKNgaySinh.setDate(kh.getNgaySinh().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        txtHoVaTen.setText(kh.getHoTen());
    }

    private void fillDataKM(int i) {
        ChiTietKMCustom kh = listKM.get(i);
        //maKM, tenKM, soTienGiam, chietKhau, ngayBatDau, ngayKT
        txtMaKM.setText(kh.getMaKM());
        txtTenKM.setText(kh.getTenKM());
        dPNgayBD.setDate(kh.getNgayBatDau().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        dPNgayKT.setDate(kh.getNgayKT().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        txtMoTaKM.setText(kh.getMoTa());
        txtMucGG.setText(kh.getMucKhuyenMai() + "");
        cbbHTKM.setSelectedItem(kh.getHinhThucKhuyenMai());
    }

//getData Hoa
    private KhachHangViewMD getDataKH() {
        KhachHangViewMD kh = new KhachHangViewMD();
        kh.setMaKH(maKH());
        kh.setHoTen(txtHoVaTen.getText());
        kh.setDiaChi(txtDiaChi.getText());
        kh.setDiemTichLuy(Integer.valueOf(txtDiemTichLuy.getText()));
        kh.setEmail(txtEmail.getText());
        kh.setNgaySinh(java.sql.Date.valueOf(datePKNgaySinh.getDate()));
        kh.setSDT(txtSDT.getText());
        kh.setGhiChu(txtGhiChu.getText());
        if (rdoNam.isSelected()) {
            kh.setGioiTinh(1);
        } else {
            kh.setGioiTinh(0);
        }
        return kh;
    }

    private KhuyenMaiViewModel getDataKM() {
        KhuyenMaiViewModel km = new KhuyenMaiViewModel();
        km.setMaKM(txtMaKM.getText());
        km.setTenKM(txtTenKM.getText());
        km.setNgayBatDau(java.sql.Date.valueOf(dPNgayBD.getDate()));
        km.setNgayKT(java.sql.Date.valueOf(dPNgayKT.getDate()));
        km.setHinhThucKhuyenMai((String) cbbHTKM.getSelectedItem());
        km.setMucKhuyenMai(new BigDecimal(txtMucGG.getText()));
        km.setNgayBatDau(java.sql.Date.valueOf(dPNgayBD.getDate()));
        km.setNgayKT(java.sql.Date.valueOf(dPNgayKT.getDate()));
        java.util.Date today = new java.util.Date(System.currentTimeMillis());
        if (km.getNgayKT().after(today)) {
            km.setTrangThai(1);
        } else {
            km.setTrangThai(0);
        }
        return km;
    }
//Hết fill Hoa
    //code Tuấn Anh

    void fillToHoaDon(List<HoaDon> list) {
        modelHoaDon.setRowCount(0);
        for (HoaDon x : list) {
            modelHoaDon.addRow(new Object[]{x.getMaHD(), "NV1", x.getNgayTao().format(formatter), x.getNgayThanhToan() == null ? "Chưa thanh toán" : x.getNgayThanhToan(), x.getTrangThaiStr()});
        }
    }

    void setButtonClick(JPanel panelClick) {
        JPanel panel[] = {btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_10};
        for (JPanel x : panel) {
            x.setBackground(new Color(23, 35, 51));
        }
        panelClick.setBackground(new Color(40, 57, 80));
        panelClick.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        JOptionPane.showMessageDialog(this, "Hello");
    }
//    void setTable(){
//        tblThongKe.getTableHeader().setReorderingAllowed(false);
//        tblThongKe.setShowHorizontalLines(true);
//        tblThongKe.setOpaque(true);
//        tblThongKe.setBorder(new EmptyBorder(0, 0, 0, 0));
//    }

    void addPanelDienThoai() {
        List<DienThoai> list = dienThoaiRepo.getAll1();
        for (DienThoai x : list) {
            clickProduct(x);
        }
    }

    void addPanelPhuKien() {
        List<PhuKien> dsPhuKien = iPhuKienService.getAll1();
        for (PhuKien x : dsPhuKien) {
//            clickProduct(x);
            clickProductPK(x);
        }
//        System.out.println(dsPhuKien.size());
    }

    void clickProduct(DienThoai x) {
        BorderLayout layout = new BorderLayout();
        layout.setHgap(5);
        layout.setVgap(5);
        Image img = null;
        try {
            img = ImageHelper.createFromByteArray(x.getAnh(), "png");
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        JPanel panel = new JPanel();
        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setSize(120, 70);
        panel.setLayout(layout);
//                panel.setBackground(Color.red);
        JLabel label = new JLabel(new ImageIcon(ImageHelper.resige(img, 100, 60)));
        panel.add(label, BorderLayout.NORTH);
        JLabel ten = new JLabel(x.getTenDienThoai());
        ten.setSize(120, HEIGHT);
        ten.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(ten, BorderLayout.CENTER);
        JLabel giaTien = new JLabel(String.format("%.0f", x.getGiaBan()) + " Đ");
        panel.add(giaTien, BorderLayout.SOUTH);
        giaTien.setHorizontalAlignment(SwingConstants.CENTER);
        panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tblHoaDon.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(null, "Bạn chưa chọn hoá đơn");
                    return;
                }
                if (!tblHoaDon.getValueAt(row, 4).toString().equals("Chờ thanh toán")) {
                    JOptionPane.showMessageDialog(null, "Chỉ có hoá đơn chờ thanh toán mới được sửa");
                    return;
                }
                HoaDon hoaDon = hoaDonRepo.getOne(tblHoaDon.getValueAt(row, 0).toString());
                ShowProduct.getValues(x, hoaDon);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                panel.setBackground(new java.awt.Color(100, 149, 237));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel.setBackground(new java.awt.Color(255, 255, 255));

            }
        });
        pnlSanPham.add(panel);
    }

    void clickProductPK(PhuKien y) {
        BorderLayout layout = new BorderLayout();
        layout.setHgap(5);
        layout.setVgap(5);
        Image img = null;
        try {
            img = ImageHelper.createFromByteArray(y.getAnh(), "png");
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        JPanel panel = new JPanel();
        panel.setLayout(layout);
        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setSize(120, 70);
//                panel.setBackground(Color.red);
        JLabel label = new JLabel(new ImageIcon(ImageHelper.resige(img, 100, 60)));
        panel.add(label, BorderLayout.NORTH);
        JLabel ten = new JLabel(y.getTen());
        ten.setSize(120, HEIGHT);
        ten.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(ten, BorderLayout.CENTER);
        JLabel giaTien = new JLabel(String.format("%.0f", y.getGiaBan()) + " Đ");
        //    panel.add(giaTien, BorderLayout.CENTER);
        giaTien.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(giaTien, BorderLayout.SOUTH);
        panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tblHoaDon.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(null, "Bạn chưa chọn hoá đơn");
                    return;
                }
                if (!tblHoaDon.getValueAt(row, 4).toString().equals("Chờ thanh toán")) {
                    JOptionPane.showMessageDialog(null, "Chỉ có hoá đơn chờ thanh toán mới được sửa");
                    return;
                }
                HoaDon hoaDon = hoaDonRepo.getOne(tblHoaDon.getValueAt(row, 0).toString());
                ShowPhuKien.getValues(y, hoaDon);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                panel.setBackground(new java.awt.Color(100, 149, 237));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel.setBackground(new java.awt.Color(255, 255, 255));

            }
        });
        pnlSanPham.add(panel);
    }

    public static void fillToHDCT(String maHD) {
//        HoaDon hoaDon = HoaDonRepository.getOne(maHD);
//        List<HoaDonChiTiet> list = hoaDon.getList();
        modelHDCT.setRowCount(0);
        for (HoaDonChiTiet x : HoaDonChiTietRepository.getAll(maHD)) {
            modelHDCT.addRow(new Object[]{x, x.getSoLuong(), x.getDonGia(), x.getGia()});
        }
    }
    //Hết code Tuấn ANh

    //Code Dũng
    private void showData(List<QLDienThoai> showList) {
        dtm.setRowCount(0);
        for (QLDienThoai dienThoai : showList) {
            dtm.addRow(new Object[]{dienThoai.getTenDienThoai(), dienThoai.getSoLuongTon(), dienThoai.getRAM(), dienThoai.getROM(), dienThoai.getManHinh(), dienThoai.getMauSac(), dienThoai.getGiaBan(), dienThoai.getThoiGianBaoHanh(), dienThoai.getTrangThai() == 1 ? "Đang Bán" : "Ngừng Bán"});
        }
    }

    //Hết code Dũng
    //Code của Vanh
    private void showDataTablePK(List<QLPhuKien> lists) {
        dtmPhuKien1.setRowCount(0);
        for (QLPhuKien pk : lists) {
            dtmPhuKien1.addRow(pk.toDataRow());
        }
    }

    private void fillDataPK(int i) {
        QLPhuKien qLPhuKien = listQLPhuKien.get(i);
        txtTenPK.setText(qLPhuKien.getTen());
        txtGiaBanPK.setText(String.valueOf(qLPhuKien.getGiaBan()));
        txtSoLuongTonPK.setText(String.valueOf(qLPhuKien.getSoLuong()));
        txtMaPK.setText(qLPhuKien.getMa());
        txtMoTaPK.setText(qLPhuKien.getMoTa());
        txtThoiGianBaoHanhPK.setText(String.valueOf(qLPhuKien.getThoiGianBaoHanh()));
        if (qLPhuKien.getTrangThai() == 1) {
            cbbTrangThaiPK.setSelectedItem("Đang bán");
        } else {
            cbbTrangThaiPK.setSelectedItem("Ngừng bán");
        }
        cbbTenHangPK.setSelectedItem(qLPhuKien.getHang().getTen());
        if (qLPhuKien.getAnh() != null) {
            try {
                Image img = ImageHelper.createFromByteArray(qLPhuKien.getAnh(), "jpg");
                lblAnhPK.setIcon(new ImageIcon(ImageHelper.resige(img, lblAnhPK.getWidth(), lblAnhPK.getHeight())));
                personalImage = qLPhuKien.getAnh();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            lblAnhPK.setIcon(null);
        }
    }

    private void showDataTableNV(List<QLNhanVien> lists) {
        dtmNhanVien.setRowCount(0);
        for (QLNhanVien nv : lists) {
            dtmNhanVien.addRow(nv.toDataRow());
        }
    }

    private void fillDataNV(int i) {
        QLNhanVien qLNhanVien = listQLNhanVien.get(i);
        txtMaNV.setText(qLNhanVien.getMa());
        txtHovaTenNV.setText(qLNhanVien.getHoTen());
        if (qLNhanVien.getGioiTinh() == 1) {
            radioNamNV.setSelected(true);
        } else {
            radioNuNV.setSelected(true);
        }
        txtNamSinhNV.setText(String.valueOf(qLNhanVien.getNamSinh()));
        txtDiaChiNV.setText(qLNhanVien.getDiaChi());
        txtCccdNV.setText(qLNhanVien.getCccd());
        txtEmailNV.setText(qLNhanVien.getEmail());
        txtSoDienThoaiNV.setText(qLNhanVien.getSdt());
        if (qLNhanVien.getTrangThai() == 1) {
            cbbTrangThaiNV.setSelectedItem("Đang làm việc");
        } else {
            cbbTrangThaiNV.setSelectedItem("Đã nghỉ việc");
        }
        cbbChucVuNV.setSelectedItem(qLNhanVien.getChucVu().getTen());
        cbbTenTKNV.setSelectedItem(qLNhanVien.getTaiKhoan().getTenTaiKhoan());
        cbbMKNV.setSelectedItem(qLNhanVien.getTaiKhoan().getMatKhau());
        if (qLNhanVien.getAnh() != null) {
            try {
                Image img = ImageHelper.createFromByteArray(qLNhanVien.getAnh(), "jpg");
                lblAnhNV.setIcon(new ImageIcon(ImageHelper.resige(img, lblAnhNV.getWidth(), lblAnhNV.getHeight())));
                personalImage = qLNhanVien.getAnh();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            lblAnhNV.setIcon(null);
        }
    }
    //Hết code của Vanh

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        button1 = new java.awt.Button();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPasswordField1 = new javax.swing.JPasswordField();
        pnlTong = new javax.swing.JPanel();
        pnlMain = new javax.swing.JPanel();
        ind_1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btn_2 = new javax.swing.JPanel();
        ind_2 = new javax.swing.JPanel();
        ind_5 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btn_3 = new javax.swing.JPanel();
        ind_3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btn_4 = new javax.swing.JPanel();
        ind_4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        btn_5 = new javax.swing.JPanel();
        ind_6 = new javax.swing.JPanel();
        ind_7 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btn_6 = new javax.swing.JPanel();
        ind_8 = new javax.swing.JPanel();
        ind_9 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        btn_7 = new javax.swing.JPanel();
        ind_10 = new javax.swing.JPanel();
        ind_11 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        btn_8 = new javax.swing.JPanel();
        ind_12 = new javax.swing.JPanel();
        ind_13 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lblAnh = new javax.swing.JLabel();
        btn_9 = new javax.swing.JPanel();
        ind_14 = new javax.swing.JPanel();
        ind_15 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        btn_10 = new javax.swing.JPanel();
        ind_16 = new javax.swing.JPanel();
        ind_17 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        btn_exit = new javax.swing.JLabel();
        btn_11 = new javax.swing.JPanel();
        ind_18 = new javax.swing.JPanel();
        ind_19 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        pnlTong1 = new javax.swing.JPanel();
        pnlMain1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        pnlDienThoai = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblListDienThoai = new javax.swing.JTable();
        jLabel46 = new javax.swing.JLabel();
        txtTenDienThoai = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        lbAnhDT = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        txtGiaNhapDienThoai = new javax.swing.JTextField();
        txtGiaBanDienThoai = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        txtMaDienThoai = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtMoTaDienThoai = new javax.swing.JTextArea();
        jLabel67 = new javax.swing.JLabel();
        txtSoLuongDienThoai = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        cbbTenHangDT = new javax.swing.JComboBox<>();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        txtRomDT = new javax.swing.JTextField();
        txtRamDT = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        txtCPUDT = new javax.swing.JTextField();
        txtHeDieuHanhDT = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        txtManHinhDT = new javax.swing.JTextField();
        txtCameraDT = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        txtPinDT = new javax.swing.JTextField();
        txtMauSacDT = new javax.swing.JTextField();
        txtBaoHanhDT = new javax.swing.JTextField();
        cbbTrangThaiDT = new javax.swing.JComboBox<>();
        btnTrangTruoc = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnTrangSau = new javax.swing.JButton();
        btnLamMoiDT = new javax.swing.JButton();
        btnDoiTrangThaiDienThoai = new javax.swing.JButton();
        btnSuaDT = new javax.swing.JButton();
        btnThemDT = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        txtTimKiemDienThoai = new javax.swing.JTextField();
        btnTimKiemDienThoai = new javax.swing.JButton();
        btnTaoMaQRDienThoai = new javax.swing.JButton();
        rdoTatCa = new javax.swing.JRadioButton();
        rdoDangBan = new javax.swing.JRadioButton();
        rdoNgungBan = new javax.swing.JRadioButton();
        jPanel32 = new javax.swing.JPanel();
        jLabel111 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        pnlPhuKien = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPhuKien = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        txtTimKiemPK = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        lblAnhPK = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtTenPK = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        txtGiaBanPK = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        txtGiaNhapPK = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txtMaPK = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtMoTaPK = new javax.swing.JTextArea();
        jLabel40 = new javax.swing.JLabel();
        cbbTenHangPK = new javax.swing.JComboBox<>();
        jLabel41 = new javax.swing.JLabel();
        txtSoLuongTonPK = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        txtThoiGianBaoHanhPK = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        cbbTrangThaiPK = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        btnThemPK = new javax.swing.JButton();
        btnSuaPK = new javax.swing.JButton();
        btnDoiTrangThaiPK = new javax.swing.JButton();
        btnClearPK = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        btnTaoMaPK = new javax.swing.JButton();
        radioDangBanPK = new javax.swing.JRadioButton();
        radioNgungBanPK = new javax.swing.JRadioButton();
        radioTatCaPK = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        pnlNhanVien = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        txtSoDienThoaiNV = new javax.swing.JTextField();
        jButton17 = new javax.swing.JButton();
        btnThemNV = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        btnSuaNV = new javax.swing.JButton();
        btnDoiTrangThaiNv = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        jLabel54 = new javax.swing.JLabel();
        txtNamSinhNV = new javax.swing.JTextField();
        btnClearNV = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtDiaChiNV = new javax.swing.JTextArea();
        txtHovaTenNV = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        lblAnhNV = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jButton19 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jLabel52 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        txtEmailNV = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        radioNamNV = new javax.swing.JRadioButton();
        radioNuNV = new javax.swing.JRadioButton();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        cbbChucVuNV = new javax.swing.JComboBox<>();
        jLabel61 = new javax.swing.JLabel();
        txtCccdNV = new javax.swing.JTextField();
        cbbTrangThaiNV = new javax.swing.JComboBox<>();
        btnQuetMaNV = new javax.swing.JButton();
        jPanel33 = new javax.swing.JPanel();
        txtTimKiemNV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbbTenTKNV = new javax.swing.JComboBox<>();
        cbbMKNV = new javax.swing.JComboBox<>();
        radioDangLamViec = new javax.swing.JRadioButton();
        radioDaNghiViec = new javax.swing.JRadioButton();
        radioTatCaNV = new javax.swing.JRadioButton();
        pnlThongKe = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jButton29 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel89 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblThongKe = new javax.swing.JTable();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        pnlKhachHang = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel29 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblListData = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        txtHoVaTen = new javax.swing.JTextField();
        jLabel101 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel104 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel105 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        datePKNgaySinh = new com.github.lgooddatepicker.components.DatePicker();
        jLabel107 = new javax.swing.JLabel();
        txtDiemTichLuy = new javax.swing.JTextField();
        jLabel108 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jLabel109 = new javax.swing.JLabel();
        txtCCCD = new javax.swing.JTextField();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel30 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btnTao = new javax.swing.JButton();
        pnlSearch = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        pnlHoaDon = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        txtTimKiemHoaDon = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        tblhoadon = new javax.swing.JTable();
        jScrollPane13 = new javax.swing.JScrollPane();
        tblhdct = new javax.swing.JTable();
        pnlKhuyenMai = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jLabel117 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jPanel36 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jLabel115 = new javax.swing.JLabel();
        txtMaKM = new javax.swing.JTextField();
        jLabel116 = new javax.swing.JLabel();
        txtTenKM = new javax.swing.JTextField();
        jLabel118 = new javax.swing.JLabel();
        txtMucGG = new javax.swing.JTextField();
        jLabel119 = new javax.swing.JLabel();
        cbbHTKM = new javax.swing.JComboBox<>();
        jLabel120 = new javax.swing.JLabel();
        dPNgayBD = new com.github.lgooddatepicker.components.DatePicker();
        jLabel121 = new javax.swing.JLabel();
        dPNgayKT = new com.github.lgooddatepicker.components.DatePicker();
        jLabel122 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        txtMoTaKM = new javax.swing.JTextArea();
        btnThemKM = new javax.swing.JButton();
        btnSuaKM = new javax.swing.JButton();
        jPanel39 = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        tblKM = new javax.swing.JTable();
        txtSearchKM = new javax.swing.JTextField();
        jLabel126 = new javax.swing.JLabel();
        cboLoc = new javax.swing.JComboBox<>();
        jPanel42 = new javax.swing.JPanel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jScrollPane15 = new javax.swing.JScrollPane();
        tblDienThoaiKM = new javax.swing.JTable();
        jScrollPane17 = new javax.swing.JScrollPane();
        tblPKKM = new javax.swing.JTable();
        jPanel41 = new javax.swing.JPanel();
        jLabel123 = new javax.swing.JLabel();
        txtSearchTenDT = new javax.swing.JTextField();
        jLabel124 = new javax.swing.JLabel();
        txtSearchTenPK = new javax.swing.JTextField();
        jLabel125 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        cbSelectAll = new javax.swing.JCheckBox();
        cbClearAll = new javax.swing.JCheckBox();
        show = new javax.swing.JButton();
        pnlBanHang = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDonChiTiet = new javax.swing.JTable();
        jButton40 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jPanel24 = new javax.swing.JPanel();
        jScrollPane18 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        cboHoaDon = new javax.swing.JComboBox<>();
        btnTaoHoaDon = new javax.swing.JButton();
        btnHuyHoaDon = new javax.swing.JButton();
        jPanel25 = new javax.swing.JPanel();
        jTextField100 = new javax.swing.JTextField();
        scpSanPhamBH = new javax.swing.JScrollPane();
        pnlSanPham = new javax.swing.JPanel();
        cboLocSanPham = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        lblManV = new javax.swing.JLabel();
        lblNgayTao = new javax.swing.JLabel();
        lblMaHD = new javax.swing.JLabel();
        btnLayThongTin = new javax.swing.JButton();
        jLabel45 = new javax.swing.JLabel();
        lblTenKhachHang = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jLabel137 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        jLabel143 = new javax.swing.JLabel();
        jScrollPane20 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        btnThanhToan = new javax.swing.JButton();
        jLabel144 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        jTextField97 = new javax.swing.JTextField();
        txtTienKhachDua = new javax.swing.JTextField();
        txtTienTraKhach = new javax.swing.JTextField();
        txtDiem = new javax.swing.JTextField();
        chkDiemTichLuy = new javax.swing.JCheckBox();
        pnlNhaCungCap = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel44 = new javax.swing.JPanel();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        txtMaNcc = new javax.swing.JTextField();
        txtDiaChiNcc = new javax.swing.JTextField();
        txtTenNcc = new javax.swing.JTextField();
        txtSdtNcc = new javax.swing.JTextField();
        txtEmailNcc = new javax.swing.JTextField();
        jScrollPane19 = new javax.swing.JScrollPane();
        tbNcc = new javax.swing.JTable();
        txtTimKiemNcc = new javax.swing.JTextField();
        cbbLocNcc = new javax.swing.JComboBox<>();
        btnThemNcc = new javax.swing.JButton();
        btnSuaNcc = new javax.swing.JButton();
        btnXoaNcc = new javax.swing.JButton();
        btnKhoiPhucNcc = new javax.swing.JButton();
        jPanel45 = new javax.swing.JPanel();
        jPanel46 = new javax.swing.JPanel();
        jScrollPane21 = new javax.swing.JScrollPane();
        tbChonPK = new javax.swing.JTable();
        txtTimPk = new javax.swing.JTextField();
        jPanel47 = new javax.swing.JPanel();
        jScrollPane22 = new javax.swing.JScrollPane();
        tbChonNCCPK = new javax.swing.JTable();
        txtTimNccPk = new javax.swing.JTextField();
        jPanel48 = new javax.swing.JPanel();
        btnThemPKNCC = new javax.swing.JButton();
        btnSuaPKNCC = new javax.swing.JButton();
        btnXoaPKNCC = new javax.swing.JButton();
        btnNhapPKNCC = new javax.swing.JButton();
        jPanel49 = new javax.swing.JPanel();
        jScrollPane23 = new javax.swing.JScrollPane();
        tbPKNCC = new javax.swing.JTable();
        txtTimKiemPKNCC = new javax.swing.JTextField();
        cbbPKNCC = new javax.swing.JComboBox<>();
        jPanel50 = new javax.swing.JPanel();
        jPanel51 = new javax.swing.JPanel();
        jScrollPane24 = new javax.swing.JScrollPane();
        tbChonDt = new javax.swing.JTable();
        txtTimDt = new javax.swing.JTextField();
        jPanel52 = new javax.swing.JPanel();
        jScrollPane25 = new javax.swing.JScrollPane();
        tbChonNccDt = new javax.swing.JTable();
        txtTimNccDt = new javax.swing.JTextField();
        jPanel53 = new javax.swing.JPanel();
        jScrollPane26 = new javax.swing.JScrollPane();
        tbDTNCC = new javax.swing.JTable();
        txtTimKiemDTNCC = new javax.swing.JTextField();
        cbbDTNCC = new javax.swing.JComboBox<>();
        jPanel54 = new javax.swing.JPanel();
        btnthemDTNCC1 = new javax.swing.JButton();
        btnSuaDTNCC1 = new javax.swing.JButton();
        btnXoaDTNCC1 = new javax.swing.JButton();
        btnNhapDTNCC = new javax.swing.JButton();
        jPanel31 = new javax.swing.JPanel();
        side_pane = new javax.swing.JPanel();
        btn_1 = new javax.swing.JPanel();
        ind_20 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        btn_12 = new javax.swing.JPanel();
        ind_21 = new javax.swing.JPanel();
        ind_22 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        btn_13 = new javax.swing.JPanel();
        ind_23 = new javax.swing.JPanel();
        jLabel90 = new javax.swing.JLabel();
        btn_14 = new javax.swing.JPanel();
        ind_24 = new javax.swing.JPanel();
        jLabel91 = new javax.swing.JLabel();
        btn_15 = new javax.swing.JPanel();
        ind_25 = new javax.swing.JPanel();
        ind_26 = new javax.swing.JPanel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        btn_16 = new javax.swing.JPanel();
        ind_27 = new javax.swing.JPanel();
        ind_28 = new javax.swing.JPanel();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        btn_17 = new javax.swing.JPanel();
        ind_29 = new javax.swing.JPanel();
        ind_30 = new javax.swing.JPanel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        btn_18 = new javax.swing.JPanel();
        ind_31 = new javax.swing.JPanel();
        ind_32 = new javax.swing.JPanel();
        jLabel106 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        lblAnh1 = new javax.swing.JLabel();
        btn_19 = new javax.swing.JPanel();
        ind_33 = new javax.swing.JPanel();
        ind_34 = new javax.swing.JPanel();
        jLabel133 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        btn_20 = new javax.swing.JPanel();
        ind_35 = new javax.swing.JPanel();
        ind_36 = new javax.swing.JPanel();
        jLabel135 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        btn_exit1 = new javax.swing.JLabel();
        btn_21 = new javax.swing.JPanel();
        ind_37 = new javax.swing.JPanel();
        ind_38 = new javax.swing.JPanel();
        jLabel138 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        button1.setBackground(new java.awt.Color(71, 120, 197));
        button1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setLabel("Book");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(269, 269, 269)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(813, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(375, Short.MAX_VALUE))
        );

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocationByPlatform(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlTong.setBackground(new java.awt.Color(23, 35, 51));
        pnlTong.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMain.setBackground(new java.awt.Color(23, 35, 51));
        pnlMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_1MouseExited(evt);
            }
        });

        ind_1.setPreferredSize(new java.awt.Dimension(3, 43));
        ind_1.setOpaque(false);

        javax.swing.GroupLayout ind_1Layout = new javax.swing.GroupLayout(ind_1);
        ind_1.setLayout(ind_1Layout);
        ind_1Layout.setHorizontalGroup(
            ind_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_1Layout.setVerticalGroup(
            ind_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png"))); // NOI18N
        jLabel8.setText("Trang chủ");
        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addComponent(ind_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addComponent(ind_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlTong.add(pnlMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 160, 60));

        btn_2.setBackground(new java.awt.Color(23, 35, 51));
        btn_2.setPreferredSize(new java.awt.Dimension(158, 60));
        btn_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_2MouseExited(evt);
            }
        });

        ind_2.setPreferredSize(new java.awt.Dimension(3, 43));
        ind_2.setOpaque(false);

        ind_5.setPreferredSize(new java.awt.Dimension(3, 43));
        ind_5.setOpaque(false);

        javax.swing.GroupLayout ind_5Layout = new javax.swing.GroupLayout(ind_5);
        ind_5.setLayout(ind_5Layout);
        ind_5Layout.setHorizontalGroup(
            ind_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_5Layout.setVerticalGroup(
            ind_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel17.setText("Bán hàng");
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout ind_2Layout = new javax.swing.GroupLayout(ind_2);
        ind_2.setLayout(ind_2Layout);
        ind_2Layout.setHorizontalGroup(
            ind_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ind_2Layout.createSequentialGroup()
                .addComponent(ind_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel17)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        ind_2Layout.setVerticalGroup(
            ind_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ind_2Layout.createSequentialGroup()
                .addComponent(ind_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(ind_2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/selling.png"))); // NOI18N
        jLabel9.setText("Bán hàng");
        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout btn_2Layout = new javax.swing.GroupLayout(btn_2);
        btn_2.setLayout(btn_2Layout);
        btn_2Layout.setHorizontalGroup(
            btn_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_2Layout.createSequentialGroup()
                .addComponent(ind_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 31, Short.MAX_VALUE))
        );
        btn_2Layout.setVerticalGroup(
            btn_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_2Layout.createSequentialGroup()
                .addComponent(ind_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlTong.add(btn_2);

        btn_3.setBackground(new java.awt.Color(23, 35, 51));
        btn_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_3MouseExited(evt);
            }
        });

        ind_3.setPreferredSize(new java.awt.Dimension(3, 43));
        ind_3.setOpaque(false);

        javax.swing.GroupLayout ind_3Layout = new javax.swing.GroupLayout(ind_3);
        ind_3.setLayout(ind_3Layout);
        ind_3Layout.setHorizontalGroup(
            ind_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_3Layout.setVerticalGroup(
            ind_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/smartphone-call.png"))); // NOI18N
        jLabel10.setText("Điện thoại");
        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout btn_3Layout = new javax.swing.GroupLayout(btn_3);
        btn_3.setLayout(btn_3Layout);
        btn_3Layout.setHorizontalGroup(
            btn_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_3Layout.createSequentialGroup()
                .addComponent(ind_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel10)
                .addGap(0, 35, Short.MAX_VALUE))
        );
        btn_3Layout.setVerticalGroup(
            btn_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_3Layout.createSequentialGroup()
                .addComponent(ind_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlTong.add(btn_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 160, 60));

        btn_4.setBackground(new java.awt.Color(23, 35, 51));
        btn_4.setPreferredSize(new java.awt.Dimension(158, 60));
        btn_4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_4MouseExited(evt);
            }
        });

        ind_4.setPreferredSize(new java.awt.Dimension(3, 43));
        ind_4.setOpaque(false);

        javax.swing.GroupLayout ind_4Layout = new javax.swing.GroupLayout(ind_4);
        ind_4.setLayout(ind_4Layout);
        ind_4Layout.setHorizontalGroup(
            ind_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_4Layout.setVerticalGroup(
            ind_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/headphone.png"))); // NOI18N
        jLabel11.setText("Phụ kiện");
        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout btn_4Layout = new javax.swing.GroupLayout(btn_4);
        btn_4.setLayout(btn_4Layout);
        btn_4Layout.setHorizontalGroup(
            btn_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_4Layout.createSequentialGroup()
                .addComponent(ind_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel11)
                .addGap(0, 43, Short.MAX_VALUE))
        );
        btn_4Layout.setVerticalGroup(
            btn_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_4Layout.createSequentialGroup()
                .addComponent(ind_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlTong.add(btn_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 160, 60));

        btn_5.setBackground(new java.awt.Color(23, 35, 51));
        btn_5.setPreferredSize(new java.awt.Dimension(158, 60));
        btn_5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_5MouseExited(evt);
            }
        });

        ind_6.setPreferredSize(new java.awt.Dimension(3, 43));
        ind_6.setOpaque(false);

        ind_7.setPreferredSize(new java.awt.Dimension(3, 43));
        ind_7.setOpaque(false);

        javax.swing.GroupLayout ind_7Layout = new javax.swing.GroupLayout(ind_7);
        ind_7.setLayout(ind_7Layout);
        ind_7Layout.setHorizontalGroup(
            ind_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_7Layout.setVerticalGroup(
            ind_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel18.setText("Bán hàng");
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout ind_6Layout = new javax.swing.GroupLayout(ind_6);
        ind_6.setLayout(ind_6Layout);
        ind_6Layout.setHorizontalGroup(
            ind_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ind_6Layout.createSequentialGroup()
                .addComponent(ind_7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel18)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        ind_6Layout.setVerticalGroup(
            ind_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ind_6Layout.createSequentialGroup()
                .addComponent(ind_7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(ind_6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bill.png"))); // NOI18N
        jLabel19.setText("Hóa đơn");
        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout btn_5Layout = new javax.swing.GroupLayout(btn_5);
        btn_5.setLayout(btn_5Layout);
        btn_5Layout.setHorizontalGroup(
            btn_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_5Layout.createSequentialGroup()
                .addComponent(ind_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
        );
        btn_5Layout.setVerticalGroup(
            btn_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_5Layout.createSequentialGroup()
                .addComponent(ind_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlTong.add(btn_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 160, -1));

        btn_6.setBackground(new java.awt.Color(23, 35, 51));
        btn_6.setPreferredSize(new java.awt.Dimension(158, 60));
        btn_6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_6MouseExited(evt);
            }
        });

        ind_8.setPreferredSize(new java.awt.Dimension(3, 43));
        ind_8.setOpaque(false);

        ind_9.setPreferredSize(new java.awt.Dimension(3, 43));
        ind_9.setOpaque(false);

        javax.swing.GroupLayout ind_9Layout = new javax.swing.GroupLayout(ind_9);
        ind_9.setLayout(ind_9Layout);
        ind_9Layout.setHorizontalGroup(
            ind_9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_9Layout.setVerticalGroup(
            ind_9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel20.setText("Bán hàng");
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout ind_8Layout = new javax.swing.GroupLayout(ind_8);
        ind_8.setLayout(ind_8Layout);
        ind_8Layout.setHorizontalGroup(
            ind_8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ind_8Layout.createSequentialGroup()
                .addComponent(ind_9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel20)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        ind_8Layout.setVerticalGroup(
            ind_8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ind_8Layout.createSequentialGroup()
                .addComponent(ind_9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(ind_8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_user_20px_1.png"))); // NOI18N
        jLabel21.setText("Nhà cung cấp");
        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout btn_6Layout = new javax.swing.GroupLayout(btn_6);
        btn_6.setLayout(btn_6Layout);
        btn_6Layout.setHorizontalGroup(
            btn_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_6Layout.createSequentialGroup()
                .addComponent(ind_8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel21)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        btn_6Layout.setVerticalGroup(
            btn_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_6Layout.createSequentialGroup()
                .addComponent(ind_8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlTong.add(btn_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 160, -1));

        btn_7.setBackground(new java.awt.Color(23, 35, 51));
        btn_7.setPreferredSize(new java.awt.Dimension(158, 60));
        btn_7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_7MouseExited(evt);
            }
        });

        ind_10.setPreferredSize(new java.awt.Dimension(3, 43));
        ind_10.setOpaque(false);

        ind_11.setPreferredSize(new java.awt.Dimension(3, 43));
        ind_11.setOpaque(false);

        javax.swing.GroupLayout ind_11Layout = new javax.swing.GroupLayout(ind_11);
        ind_11.setLayout(ind_11Layout);
        ind_11Layout.setHorizontalGroup(
            ind_11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_11Layout.setVerticalGroup(
            ind_11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel22.setText("Bán hàng");
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout ind_10Layout = new javax.swing.GroupLayout(ind_10);
        ind_10.setLayout(ind_10Layout);
        ind_10Layout.setHorizontalGroup(
            ind_10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ind_10Layout.createSequentialGroup()
                .addComponent(ind_11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel22)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        ind_10Layout.setVerticalGroup(
            ind_10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ind_10Layout.createSequentialGroup()
                .addComponent(ind_11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(ind_10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/price-tag.png"))); // NOI18N
        jLabel23.setText("Khuyến mãi");
        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout btn_7Layout = new javax.swing.GroupLayout(btn_7);
        btn_7.setLayout(btn_7Layout);
        btn_7Layout.setHorizontalGroup(
            btn_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_7Layout.createSequentialGroup()
                .addComponent(ind_10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
        );
        btn_7Layout.setVerticalGroup(
            btn_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_7Layout.createSequentialGroup()
                .addComponent(ind_10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlTong.add(btn_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 160, -1));

        btn_8.setBackground(new java.awt.Color(23, 35, 51));
        btn_8.setPreferredSize(new java.awt.Dimension(158, 60));
        btn_8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_8MouseExited(evt);
            }
        });

        ind_12.setPreferredSize(new java.awt.Dimension(3, 43));
        ind_12.setOpaque(false);

        ind_13.setPreferredSize(new java.awt.Dimension(3, 43));
        ind_13.setOpaque(false);

        javax.swing.GroupLayout ind_13Layout = new javax.swing.GroupLayout(ind_13);
        ind_13.setLayout(ind_13Layout);
        ind_13Layout.setHorizontalGroup(
            ind_13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_13Layout.setVerticalGroup(
            ind_13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel24.setText("Bán hàng");
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout ind_12Layout = new javax.swing.GroupLayout(ind_12);
        ind_12.setLayout(ind_12Layout);
        ind_12Layout.setHorizontalGroup(
            ind_12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ind_12Layout.createSequentialGroup()
                .addComponent(ind_13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel24)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        ind_12Layout.setVerticalGroup(
            ind_12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ind_12Layout.createSequentialGroup()
                .addComponent(ind_13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(ind_12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/staff.png"))); // NOI18N
        jLabel25.setText("Nhân viên");
        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout btn_8Layout = new javax.swing.GroupLayout(btn_8);
        btn_8.setLayout(btn_8Layout);
        btn_8Layout.setHorizontalGroup(
            btn_8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_8Layout.createSequentialGroup()
                .addComponent(ind_12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel25)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        btn_8Layout.setVerticalGroup(
            btn_8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_8Layout.createSequentialGroup()
                .addComponent(ind_12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlTong.add(btn_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 160, -1));

        lblAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imge_1.jpg"))); // NOI18N
        pnlTong.add(lblAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 60, 60));

        btn_9.setBackground(new java.awt.Color(23, 35, 51));
        btn_9.setPreferredSize(new java.awt.Dimension(158, 60));
        btn_9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_9MouseExited(evt);
            }
        });

        ind_14.setPreferredSize(new java.awt.Dimension(3, 43));
        ind_14.setOpaque(false);

        ind_15.setPreferredSize(new java.awt.Dimension(3, 43));
        ind_15.setOpaque(false);

        javax.swing.GroupLayout ind_15Layout = new javax.swing.GroupLayout(ind_15);
        ind_15.setLayout(ind_15Layout);
        ind_15Layout.setHorizontalGroup(
            ind_15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_15Layout.setVerticalGroup(
            ind_15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel26.setText("Bán hàng");
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout ind_14Layout = new javax.swing.GroupLayout(ind_14);
        ind_14.setLayout(ind_14Layout);
        ind_14Layout.setHorizontalGroup(
            ind_14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ind_14Layout.createSequentialGroup()
                .addComponent(ind_15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel26)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        ind_14Layout.setVerticalGroup(
            ind_14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ind_14Layout.createSequentialGroup()
                .addComponent(ind_15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(ind_14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bar-chart.png"))); // NOI18N
        jLabel27.setText("Thống kê");
        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout btn_9Layout = new javax.swing.GroupLayout(btn_9);
        btn_9.setLayout(btn_9Layout);
        btn_9Layout.setHorizontalGroup(
            btn_9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_9Layout.createSequentialGroup()
                .addComponent(ind_14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 29, Short.MAX_VALUE))
        );
        btn_9Layout.setVerticalGroup(
            btn_9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_9Layout.createSequentialGroup()
                .addComponent(ind_14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlTong.add(btn_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 660, 160, -1));

        btn_10.setBackground(new java.awt.Color(23, 35, 51));
        btn_10.setPreferredSize(new java.awt.Dimension(158, 60));
        btn_10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_10MouseExited(evt);
            }
        });

        ind_16.setPreferredSize(new java.awt.Dimension(3, 43));
        ind_16.setOpaque(false);

        ind_17.setPreferredSize(new java.awt.Dimension(3, 43));
        ind_17.setOpaque(false);

        javax.swing.GroupLayout ind_17Layout = new javax.swing.GroupLayout(ind_17);
        ind_17.setLayout(ind_17Layout);
        ind_17Layout.setHorizontalGroup(
            ind_17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_17Layout.setVerticalGroup(
            ind_17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel28.setText("Bán hàng");
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout ind_16Layout = new javax.swing.GroupLayout(ind_16);
        ind_16.setLayout(ind_16Layout);
        ind_16Layout.setHorizontalGroup(
            ind_16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ind_16Layout.createSequentialGroup()
                .addComponent(ind_17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel28)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        ind_16Layout.setVerticalGroup(
            ind_16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ind_16Layout.createSequentialGroup()
                .addComponent(ind_17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(ind_16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/people.png"))); // NOI18N
        jLabel29.setText("Khách hàng");
        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout btn_10Layout = new javax.swing.GroupLayout(btn_10);
        btn_10.setLayout(btn_10Layout);
        btn_10Layout.setHorizontalGroup(
            btn_10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_10Layout.createSequentialGroup()
                .addComponent(ind_16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel29)
                .addGap(0, 25, Short.MAX_VALUE))
        );
        btn_10Layout.setVerticalGroup(
            btn_10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_10Layout.createSequentialGroup()
                .addComponent(ind_16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
            .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlTong.add(btn_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, 160, -1));

        btn_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_exitMousePressed(evt);
            }
        });
        pnlTong.add(btn_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 640, -1, 46));

        btn_11.setBackground(new java.awt.Color(23, 35, 51));
        btn_11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_11.setPreferredSize(new java.awt.Dimension(158, 60));
        btn_11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_11MouseExited(evt);
            }
        });

        ind_18.setPreferredSize(new java.awt.Dimension(3, 43));
        ind_18.setOpaque(false);

        ind_19.setPreferredSize(new java.awt.Dimension(3, 43));
        ind_19.setOpaque(false);

        javax.swing.GroupLayout ind_19Layout = new javax.swing.GroupLayout(ind_19);
        ind_19.setLayout(ind_19Layout);
        ind_19Layout.setHorizontalGroup(
            ind_19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_19Layout.setVerticalGroup(
            ind_19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel44.setText("Bán hàng");
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout ind_18Layout = new javax.swing.GroupLayout(ind_18);
        ind_18.setLayout(ind_18Layout);
        ind_18Layout.setHorizontalGroup(
            ind_18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ind_18Layout.createSequentialGroup()
                .addComponent(ind_19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel44)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        ind_18Layout.setVerticalGroup(
            ind_18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ind_18Layout.createSequentialGroup()
                .addComponent(ind_19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(ind_18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel98.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Exit_25px.png"))); // NOI18N
        jLabel98.setText("Đăng xuất");
        jLabel98.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout btn_11Layout = new javax.swing.GroupLayout(btn_11);
        btn_11.setLayout(btn_11Layout);
        btn_11Layout.setHorizontalGroup(
            btn_11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_11Layout.createSequentialGroup()
                .addComponent(ind_18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel98)
                .addGap(0, 37, Short.MAX_VALUE))
        );
        btn_11Layout.setVerticalGroup(
            btn_11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_11Layout.createSequentialGroup()
                .addComponent(ind_18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
            .addComponent(jLabel98, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlTong.add(btn_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 720, 160, 50));

        getContentPane().add(pnlTong, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 840));

        pnlTong1.setBackground(new java.awt.Color(255, 255, 255));
        pnlTong1.setLayout(new java.awt.CardLayout());

        pnlMain1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setText("jLabel5");

        javax.swing.GroupLayout pnlMain1Layout = new javax.swing.GroupLayout(pnlMain1);
        pnlMain1.setLayout(pnlMain1Layout);
        pnlMain1Layout.setHorizontalGroup(
            pnlMain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMain1Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 1368, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlMain1Layout.setVerticalGroup(
            pnlMain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
        );

        pnlTong1.add(pnlMain1, "cardMain");

        pnlDienThoai.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        tblListDienThoai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Tên Điện Thoại", "Số Lượng Tồn", "RAM", "ROM", "Pin", "Màu Sắc", "Giá bán", "Thời Gian Bảo Hành", "Trạng Thái"
            }
        ));
        tblListDienThoai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblListDienThoai.setSelectionBackground(new java.awt.Color(0, 0, 0));
        tblListDienThoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListDienThoaiMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblListDienThoai);

        jLabel46.setText("Tên Điện Thoại");
        jLabel46.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtTenDienThoai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTenDienThoai.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 153)));

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbAnhDT.setBorder(new javax.swing.border.MatteBorder(null));
        lbAnhDT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbAnhDTMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(lbAnhDT, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbAnhDT, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
        );

        jLabel51.setText("Giá Nhập");
        jLabel51.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel62.setText("Giá Bán");
        jLabel62.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtGiaNhapDienThoai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtGiaNhapDienThoai.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 153)));

        txtGiaBanDienThoai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtGiaBanDienThoai.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 153)));

        jLabel63.setText("VNĐ");
        jLabel63.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel64.setText("VNĐ");
        jLabel64.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel65.setText("Mã Điện Thoại");
        jLabel65.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtMaDienThoai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaDienThoai.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 153)));

        jLabel66.setText("Mô Tả");
        jLabel66.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtMoTaDienThoai.setColumns(20);
        txtMoTaDienThoai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMoTaDienThoai.setRows(5);
        txtMoTaDienThoai.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 153)));
        jScrollPane7.setViewportView(txtMoTaDienThoai);

        jLabel67.setText("Số Lượng");
        jLabel67.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtSoLuongDienThoai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSoLuongDienThoai.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 153)));

        jLabel68.setText("Tên Hãng");
        jLabel68.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cbbTenHangDT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbTenHangDT.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 153)));

        jLabel70.setText("RAM");
        jLabel70.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel71.setText("ROM");
        jLabel71.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtRomDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtRomDT.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 153)));

        txtRamDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtRamDT.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 153)));

        jLabel72.setText("Hệ Điều Hành");
        jLabel72.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel73.setText("CPU");
        jLabel73.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtCPUDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCPUDT.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 153)));

        txtHeDieuHanhDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtHeDieuHanhDT.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 153)));

        jLabel74.setText("Màn Hình");
        jLabel74.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel75.setText("Camera");
        jLabel75.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtManHinhDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtManHinhDT.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 153)));

        txtCameraDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCameraDT.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 153)));

        jLabel76.setText("Pin");
        jLabel76.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel77.setText("Màu Sắc");
        jLabel77.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel78.setText("Bảo Hành");
        jLabel78.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel79.setText("Trạng Thái");
        jLabel79.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtPinDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPinDT.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 153)));

        txtMauSacDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMauSacDT.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 153)));

        txtBaoHanhDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBaoHanhDT.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 153)));

        cbbTrangThaiDT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbTrangThaiDT.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 153)));

        btnTrangTruoc.setText("<|");
        btnTrangTruoc.setPreferredSize(new java.awt.Dimension(90, 30));

        btnPrev.setText("<<");
        btnPrev.setPreferredSize(new java.awt.Dimension(90, 30));

        btnNext.setText(">>");
        btnNext.setPreferredSize(new java.awt.Dimension(90, 30));

        btnTrangSau.setText("|>");
        btnTrangSau.setPreferredSize(new java.awt.Dimension(90, 30));

        btnLamMoiDT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clear.png"))); // NOI18N
        btnLamMoiDT.setBackground(new java.awt.Color(51, 51, 51));
        btnLamMoiDT.setBorder(null);
        btnLamMoiDT.setPreferredSize(new java.awt.Dimension(90, 30));
        btnLamMoiDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiDTActionPerformed(evt);
            }
        });

        btnDoiTrangThaiDienThoai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hoanDoiTrang.png"))); // NOI18N
        btnDoiTrangThaiDienThoai.setBackground(new java.awt.Color(51, 51, 51));
        btnDoiTrangThaiDienThoai.setBorder(null);
        btnDoiTrangThaiDienThoai.setPreferredSize(new java.awt.Dimension(90, 30));
        btnDoiTrangThaiDienThoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiTrangThaiDienThoaiActionPerformed(evt);
            }
        });

        btnSuaDT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sua.png"))); // NOI18N
        btnSuaDT.setBackground(new java.awt.Color(51, 51, 51));
        btnSuaDT.setBorder(null);
        btnSuaDT.setPreferredSize(new java.awt.Dimension(90, 30));
        btnSuaDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaDTActionPerformed(evt);
            }
        });

        btnThemDT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/them.png"))); // NOI18N
        btnThemDT.setBackground(new java.awt.Color(0, 0, 0));
        btnThemDT.setBorder(null);
        btnThemDT.setPreferredSize(new java.awt.Dimension(90, 30));
        btnThemDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDTActionPerformed(evt);
            }
        });

        txtTimKiemDienThoai.setBorder(null);
        txtTimKiemDienThoai.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemDienThoaiCaretUpdate(evt);
            }
        });

        btnTimKiemDienThoai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Search_18px.png"))); // NOI18N
        btnTimKiemDienThoai.setBorder(null);
        btnTimKiemDienThoai.setEnabled(false);
        btnTimKiemDienThoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemDienThoaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(txtTimKiemDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTimKiemDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnTimKiemDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiemDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        btnTaoMaQRDienThoai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/qr.png"))); // NOI18N
        btnTaoMaQRDienThoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoMaQRDienThoaiActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdoTatCa);
        rdoTatCa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rdoTatCa.setText("Tất Cả");
        rdoTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoTatCaActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdoDangBan);
        rdoDangBan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rdoDangBan.setText("Đang Bán");
        rdoDangBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoDangBanActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdoNgungBan);
        rdoNgungBan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rdoNgungBan.setText("Ngừng Bán");
        rdoNgungBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNgungBanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel68)
                                    .addComponent(cbbTenHangDT, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel79)
                                    .addComponent(cbbTrangThaiDT, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtRomDT, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtRamDT, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel70, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(39, 39, 39)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCPUDT, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel73)
                                    .addComponent(jLabel72)
                                    .addComponent(txtHeDieuHanhDT, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtManHinhDT, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel74)
                                    .addComponent(txtCameraDT, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel75))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMauSacDT, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPinDT, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel78)
                                    .addComponent(txtBaoHanhDT, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnTrangTruoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnTrangSau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnTaoMaQRDienThoai)
                                .addGap(18, 18, 18)
                                .addComponent(btnThemDT, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSuaDT, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDoiTrangThaiDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLamMoiDT, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rdoTatCa)
                        .addGap(18, 18, 18)
                        .addComponent(rdoDangBan)
                        .addGap(18, 18, 18)
                        .addComponent(rdoNgungBan)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel46)
                            .addComponent(txtTenDienThoai)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel65)
                                .addGap(96, 96, 96)
                                .addComponent(jLabel67))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel51)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(txtGiaNhapDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel63)))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtGiaBanDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel64)
                                        .addGap(6, 6, 6))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabel62)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtMaDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(txtSoLuongDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane7))
                        .addGap(29, 29, 29))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnSuaDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnDoiTrangThaiDienThoai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLamMoiDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnTrangTruoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnTrangSau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnThemDT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnTaoMaQRDienThoai, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel74)
                            .addComponent(jLabel76)
                            .addComponent(jLabel78))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbTenHangDT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRamDT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCPUDT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtManHinhDT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPinDT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBaoHanhDT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel75)
                            .addComponent(jLabel77)
                            .addComponent(jLabel79))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRomDT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHeDieuHanhDT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCameraDT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMauSacDT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbTrangThaiDT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rdoTatCa)
                                .addComponent(rdoDangBan)
                                .addComponent(rdoNgungBan))
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtTenDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtMaDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, 0)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtGiaNhapDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtGiaBanDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel63)
                                    .addComponent(jLabel64)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtSoLuongDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(20, 20, 20)
                        .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))))
        );

        jPanel32.setBackground(new java.awt.Color(71, 120, 197));
        jPanel32.setPreferredSize(new java.awt.Dimension(1455, 93));

        jLabel111.setText("Điện thoại");
        jLabel111.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel111.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator6)
                    .addComponent(jLabel111, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel111)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout pnlDienThoaiLayout = new javax.swing.GroupLayout(pnlDienThoai);
        pnlDienThoai.setLayout(pnlDienThoaiLayout);
        pnlDienThoaiLayout.setHorizontalGroup(
            pnlDienThoaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, 1380, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlDienThoaiLayout.setVerticalGroup(
            pnlDienThoaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDienThoaiLayout.createSequentialGroup()
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlTong1.add(pnlDienThoai, "cardDienThoai");

        pnlPhuKien.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(71, 120, 197));
        jPanel2.setPreferredSize(new java.awt.Dimension(1455, 93));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tblPhuKien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Tên phụ kiện", "Số lượng tồn", "Giá bán", "Thời gian bảo hành", "Mô tả", "Trạng thái"
            }
        ));
        tblPhuKien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhuKienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPhuKien);

        jLabel15.setText("Tìm kiếm");
        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtTimKiemPK.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemPKCaretUpdate(evt);
            }
        });

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblAnhPK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAnhPKMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblAnhPK, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblAnhPK, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel33.setText("Tên phụ kiện");
        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel34.setText("Giá nhập");
        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel35.setText("Giá bán");
        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel36.setText("VND");
        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel37.setText("VND");
        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel38.setText("Số lượng tồn");
        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel39.setText("Mô tả");
        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtMoTaPK.setColumns(20);
        txtMoTaPK.setRows(5);
        jScrollPane3.setViewportView(txtMoTaPK);

        jLabel40.setText("Tên hãng");
        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cbbTenHangPK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel41.setText("Mã phụ kiện");
        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel42.setText("Thời gian bảo hành");
        jLabel42.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel43.setText("Trạng thái");
        jLabel43.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cbbTrangThaiPK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton2.setText("+");

        btnThemPK.setText("Thêm");
        btnThemPK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemPKActionPerformed(evt);
            }
        });

        btnSuaPK.setText("Sửa");
        btnSuaPK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaPKActionPerformed(evt);
            }
        });

        btnDoiTrangThaiPK.setText("Đổi trạng thái");
        btnDoiTrangThaiPK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiTrangThaiPKActionPerformed(evt);
            }
        });

        btnClearPK.setText("Clear");
        btnClearPK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearPKActionPerformed(evt);
            }
        });

        jButton7.setText("|<");

        jButton8.setText(">|");

        jButton9.setText(">>");

        jButton10.setText("<<");

        btnTaoMaPK.setText("Tạo mã");
        btnTaoMaPK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoMaPKActionPerformed(evt);
            }
        });

        buttonGroup2.add(radioDangBanPK);
        radioDangBanPK.setText("Đang bán");
        radioDangBanPK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioDangBanPKActionPerformed(evt);
            }
        });

        buttonGroup2.add(radioNgungBanPK);
        radioNgungBanPK.setText("Ngừng bán");
        radioNgungBanPK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNgungBanPKActionPerformed(evt);
            }
        });

        buttonGroup2.add(radioTatCaPK);
        radioTatCaPK.setText("Tất cả");
        radioTatCaPK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioTatCaPKActionPerformed(evt);
            }
        });

        jLabel1.setText("Tháng");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel40)
                            .addComponent(cbbTenHangPK, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel42)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtThoiGianBaoHanhPK, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel43)
                            .addComponent(cbbTrangThaiPK, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addComponent(txtTimKiemPK, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(radioTatCaPK)
                                .addGap(18, 18, 18)
                                .addComponent(radioNgungBanPK)
                                .addGap(18, 18, 18)
                                .addComponent(radioDangBanPK))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton7)
                                .addGap(18, 18, 18)
                                .addComponent(jButton10)
                                .addGap(18, 18, 18)
                                .addComponent(jButton9)
                                .addGap(18, 18, 18)
                                .addComponent(jButton8)))
                        .addGap(33, 33, 33)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(btnThemPK)
                            .addGap(67, 67, 67)
                            .addComponent(btnSuaPK)
                            .addGap(44, 44, 44)
                            .addComponent(btnDoiTrangThaiPK)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnClearPK))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addGap(142, 142, 142)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTaoMaPK))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel34)
                            .addGap(173, 173, 173)
                            .addComponent(jLabel35))
                        .addComponent(txtTenPK, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(txtGiaNhapPK, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel37))
                                .addComponent(jLabel41))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel38)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(txtGiaBanPK, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel36))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(txtMaPK, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtSoLuongTonPK, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtTimKiemPK, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioDangBanPK)
                    .addComponent(radioNgungBanPK)
                    .addComponent(radioTatCaPK))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton8)
                    .addComponent(jButton9)
                    .addComponent(jButton10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbTrangThaiPK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel42)
                            .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtThoiGianBaoHanhPK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbTenHangPK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel33))
                    .addComponent(btnTaoMaPK))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenPK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGiaBanPK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGiaNhapPK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36)
                    .addComponent(jLabel37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jLabel41))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaPK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoLuongTonPK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel39)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemPK)
                    .addComponent(btnSuaPK)
                    .addComponent(btnDoiTrangThaiPK)
                    .addComponent(btnClearPK))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setText("Phụ Kiện");
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(1333, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 67, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlPhuKienLayout = new javax.swing.GroupLayout(pnlPhuKien);
        pnlPhuKien.setLayout(pnlPhuKienLayout);
        pnlPhuKienLayout.setHorizontalGroup(
            pnlPhuKienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPhuKienLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlPhuKienLayout.setVerticalGroup(
            pnlPhuKienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
        );

        pnlTong1.add(pnlPhuKien, "cardPhuKien");

        pnlNhanVien.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(71, 120, 197));
        jPanel8.setPreferredSize(new java.awt.Dimension(1455, 93));

        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));

        jLabel7.setText("Nhân Viên");
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(282, 282, 282)
                .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 842, Short.MAX_VALUE)
                .addGap(94, 94, 94))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(jLabel30)
                .addGap(45, 45, 45))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        txtSoDienThoaiNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSoDienThoaiNV.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(71, 120, 197)));

        jButton17.setText(">|");

        btnThemNV.setText("Thêm");
        btnThemNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNVActionPerformed(evt);
            }
        });

        jLabel48.setText("Mã NV");
        jLabel48.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel49.setText("Số điện thoại");
        jLabel49.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnSuaNV.setText("Sửa");
        btnSuaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaNVActionPerformed(evt);
            }
        });

        btnDoiTrangThaiNv.setText("Đổi trạng thái");
        btnDoiTrangThaiNv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiTrangThaiNvActionPerformed(evt);
            }
        });

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Họ tên", "Giới tính", "Ngày sinh", "Địa chỉ", "CCCD", "Email", "Sdt", "Trạng thái", "Tên tài khoản", "Chức vụ"
            }
        ));
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblNhanVien);

        jLabel54.setText("Năm sinh");
        jLabel54.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtNamSinhNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNamSinhNV.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(71, 120, 197)));

        btnClearNV.setText("Clear");
        btnClearNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearNVActionPerformed(evt);
            }
        });

        txtDiaChiNV.setColumns(20);
        txtDiaChiNV.setRows(5);
        jScrollPane5.setViewportView(txtDiaChiNV);

        txtHovaTenNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtHovaTenNV.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(71, 120, 197)));

        jLabel53.setText("Địa chỉ");
        jLabel53.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblAnhNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAnhNVMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAnhNV, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblAnhNV, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel47.setText("Họ và tên");
        jLabel47.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtMaNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaNV.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(71, 120, 197)));

        jButton19.setText("<<");

        jButton18.setText(">>");

        jButton16.setText("|<");

        jLabel52.setText("Giới tính");
        jLabel52.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel56.setText("Email");
        jLabel56.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtEmailNV.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(71, 120, 197)));

        jLabel57.setText("Mật khẩu");
        jLabel57.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel58.setText("Tên tài khoản");
        jLabel58.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        radioNamNV.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(radioNamNV);
        radioNamNV.setText("Nam");

        radioNuNV.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(radioNuNV);
        radioNuNV.setText("Nữ");

        jLabel59.setText("Chức vụ");
        jLabel59.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel60.setText("Trạng thái");
        jLabel60.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cbbChucVuNV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel61.setText("CCCD");
        jLabel61.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtCccdNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCccdNV.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(71, 120, 197)));

        cbbTrangThaiNV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnQuetMaNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/qr.png"))); // NOI18N
        btnQuetMaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuetMaNVActionPerformed(evt);
            }
        });

        txtTimKiemNV.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemNVCaretUpdate(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Search_18px.png"))); // NOI18N
        jLabel3.setEnabled(false);

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimKiemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTimKiemNV, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        cbbTenTKNV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbMKNV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        buttonGroup2.add(radioDangLamViec);
        radioDangLamViec.setText("Đang làm việc");
        radioDangLamViec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioDangLamViecActionPerformed(evt);
            }
        });

        buttonGroup2.add(radioDaNghiViec);
        radioDaNghiViec.setText("Đã Nghỉ Việc");
        radioDaNghiViec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioDaNghiViecActionPerformed(evt);
            }
        });

        buttonGroup2.add(radioTatCaNV);
        radioTatCaNV.setText("Tất Cả");
        radioTatCaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioTatCaNVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton16)
                        .addGap(31, 31, 31)
                        .addComponent(jButton19)
                        .addGap(40, 40, 40)
                        .addComponent(jButton18)
                        .addGap(42, 42, 42)
                        .addComponent(jButton17)
                        .addGap(70, 70, 70))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(radioTatCaNV)
                                .addGap(18, 18, 18)
                                .addComponent(radioDaNghiViec)
                                .addGap(18, 18, 18)
                                .addComponent(radioDangLamViec)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel47)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel57)
                                    .addComponent(jLabel61)
                                    .addComponent(jLabel54))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel49)
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(jLabel52)
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(radioNuNV)
                                                    .addComponent(radioNamNV)))
                                            .addComponent(txtSoDienThoaiNV, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel60)
                                            .addComponent(cbbTrangThaiNV, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnQuetMaNV, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtNamSinhNV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtCccdNV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtMaNV)
                                                .addComponent(cbbTenTKNV, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(cbbMKNV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnThemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnDoiTrangThaiNv, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnSuaNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnClearNV, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jLabel48)
                            .addComponent(jLabel58)))
                    .addComponent(jLabel56)
                    .addComponent(txtEmailNV, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHovaTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                        .addComponent(jLabel59)
                        .addComponent(cbbChucVuNV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(btnQuetMaNV)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbbTenTKNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbbMKNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCccdNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNamSinhNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel48)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel58)
                                        .addGap(20, 20, 20)
                                        .addComponent(jLabel57)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel61)
                                        .addGap(20, 20, 20)
                                        .addComponent(jLabel54)))
                                .addGap(49, 49, 49)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel47)
                            .addComponent(jLabel52)
                            .addComponent(radioNamNV))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHovaTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radioNuNV))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel56)
                            .addComponent(jLabel49))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmailNV, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoDienThoaiNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel60)
                            .addComponent(jLabel59))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbTrangThaiNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbChucVuNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addComponent(jLabel53))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(radioDangLamViec)
                                    .addComponent(radioDaNghiViec)
                                    .addComponent(radioTatCaNV))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton17)
                            .addComponent(jButton18)
                            .addComponent(jButton19)
                            .addComponent(jButton16))
                        .addGap(223, 223, 223))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnThemNV)
                                    .addComponent(btnSuaNV))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnClearNV)
                                    .addComponent(btnDoiTrangThaiNv)))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout pnlNhanVienLayout = new javax.swing.GroupLayout(pnlNhanVien);
        pnlNhanVien.setLayout(pnlNhanVienLayout);
        pnlNhanVienLayout.setHorizontalGroup(
            pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 1380, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNhanVienLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlNhanVienLayout.setVerticalGroup(
            pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlTong1.add(pnlNhanVien, "cardNhanVien");

        pnlThongKe.setBackground(new java.awt.Color(255, 255, 255));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jPanel13.setBackground(new java.awt.Color(255, 255, 204));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel80.setText("Doanh Thu");
        jLabel80.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        jLabel80.setPreferredSize(new java.awt.Dimension(100, 32));

        jLabel31.setText("150.0000.000 Đồng");
        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 14, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel31)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 204));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel81.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel81.setText("Số Hoá Đơn");
        jLabel81.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        jLabel81.setPreferredSize(new java.awt.Dimension(100, 32));

        jLabel82.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel82.setText("12");
        jLabel82.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel15.setBackground(new java.awt.Color(255, 255, 204));
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel83.setText("Tổng khách hàng");
        jLabel83.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        jLabel83.setPreferredSize(new java.awt.Dimension(100, 32));

        jLabel84.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel84.setText("15");
        jLabel84.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel84, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel16.setBackground(new java.awt.Color(255, 255, 204));
        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel85.setText("Số hoá đơn huỷ");
        jLabel85.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        jLabel85.setPreferredSize(new java.awt.Dimension(100, 32));

        jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel86.setText("1");
        jLabel86.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel86, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel87.setText("Ngày bắt đầu");
        jLabel87.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel88.setText("Ngày kết thúc");
        jLabel88.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButton29.setText("Lọc");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thời Gian", "Doanh Thu", "Hoá Đơn" }));

        jLabel89.setText("Sắp xếp theo");
        jLabel89.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel88, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel87, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel89, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        tblThongKe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Thời gian", "Doanh Thu", "Số hoá đơn thanh toán", "Số hoá đơn huỷ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(tblThongKe);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 1335, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 831, Short.MAX_VALUE))
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                    .addContainerGap(1579, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(310, 310, 310)))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(46, 46, 46)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(567, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Doanh Thu", jPanel12);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2178, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Hoá Đơn", jPanel18);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2178, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Sản phẩm", jPanel19);

        javax.swing.GroupLayout pnlThongKeLayout = new javax.swing.GroupLayout(pnlThongKe);
        pnlThongKe.setLayout(pnlThongKeLayout);
        pnlThongKeLayout.setHorizontalGroup(
            pnlThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        pnlThongKeLayout.setVerticalGroup(
            pnlThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pnlTong1.add(pnlThongKe, "cardThongKe");

        pnlKhachHang.setBackground(new java.awt.Color(255, 255, 255));
        pnlKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlKhachHangMouseClicked(evt);
            }
        });

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane2.setBackground(new java.awt.Color(0, 0, 0));
        jTabbedPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jTabbedPane2.setInheritsPopupMenu(true);

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));
        jPanel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        tblListData.setAutoCreateRowSorter(true);
        tblListData.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tblListData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblListData.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        tblListData.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblListData.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tblListData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListDataMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tblListData);

        jPanel29.add(jScrollPane10);

        jLabel16.setText("Họ và tên : ");
        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel29.add(jLabel16);

        txtHoVaTen.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel29.add(txtHoVaTen);

        jLabel101.setText("Giới tính :");
        jLabel101.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel29.add(jLabel101);

        rdoNam.setSelected(true);
        rdoNam.setText("Nam");
        rdoNam.setBackground(new java.awt.Color(255, 255, 255));
        rdoNam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel29.add(rdoNam);

        rdoNu.setText("Nữ");
        rdoNu.setBackground(new java.awt.Color(255, 255, 255));
        rdoNu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel29.add(rdoNu);

        jLabel102.setText("Ngày sinh");
        jLabel102.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel29.add(jLabel102);

        jLabel103.setText("Địa chỉ");
        jLabel103.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel29.add(jLabel103);

        txtDiaChi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel29.add(txtDiaChi);

        jLabel104.setText("Số điện thoại :");
        jLabel104.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel29.add(jLabel104);

        txtSDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel29.add(txtSDT);

        jLabel105.setText("Email");
        jLabel105.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel29.add(jLabel105);

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel29.add(txtEmail);

        datePKNgaySinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel29.add(datePKNgaySinh);

        jLabel107.setText("Điểm tích lũy");
        jLabel107.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel29.add(jLabel107);

        txtDiemTichLuy.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDiemTichLuy.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel29.add(txtDiemTichLuy);

        jLabel108.setText("Ghi chú");
        jLabel108.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel29.add(jLabel108);

        txtGhiChu.setColumns(20);
        txtGhiChu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtGhiChu.setRows(5);
        jScrollPane11.setViewportView(txtGhiChu);

        jPanel29.add(jScrollPane11);

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/them.png"))); // NOI18N
        btnThem.setBackground(new java.awt.Color(71, 120, 197));
        btnThem.setBorder(null);
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnThemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnThemMouseExited(evt);
            }
        });
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel29.add(btnThem);

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sua.png"))); // NOI18N
        btnSua.setBackground(new java.awt.Color(71, 120, 197));
        btnSua.setBorder(null);
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jPanel29.add(btnSua);

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/xoa.png"))); // NOI18N
        btnXoa.setBackground(new java.awt.Color(71, 120, 197));
        btnXoa.setBorder(null);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel29.add(btnXoa);

        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clear.png"))); // NOI18N
        btnClear.setBackground(new java.awt.Color(71, 120, 197));
        btnClear.setBorder(null);
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel29.add(btnClear);

        jLabel109.setText("Số CCCD:");
        jLabel109.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel29.add(jLabel109);

        txtCCCD.setBackground(new java.awt.Color(253, 253, 255));
        txtCCCD.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtCCCD.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtCCCD.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        txtCCCD.setSelectedTextColor(new java.awt.Color(102, 255, 204));
        txtCCCD.setSelectionColor(new java.awt.Color(0, 0, 0));
        txtCCCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCCCDerformed(evt);
            }
        });
        jPanel29.add(txtCCCD);

        jTabbedPane2.addTab("Danh sách Khách hàng", jPanel29);

        jTabbedPane3.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTabbedPane3.setForeground(new java.awt.Color(71, 120, 197));

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));
        jPanel30.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel30.setForeground(new java.awt.Color(255, 255, 255));

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(64, 103, 164)));
        txtSearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSearchCaretUpdate(evt);
            }
        });
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        jLabel13.setText("Tên/ CCCD/ Địa chỉ");
        jLabel13.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Tìm kiếm", jPanel30);

        btnTao.setText("Tạo mã");
        btnTao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1027, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTao))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnTao)
                .addGap(405, 405, 405))
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addGap(41, 41, 41))
        );

        pnlSearch.setBackground(new java.awt.Color(71, 120, 197));
        pnlSearch.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlSearchMouseDragged(evt);
            }
        });
        pnlSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlSearchMousePressed(evt);
            }
        });

        jLabel32.setText("Khách hàng");
        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlSearchLayout = new javax.swing.GroupLayout(pnlSearch);
        pnlSearch.setLayout(pnlSearchLayout);
        pnlSearchLayout.setHorizontalGroup(
            pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator4)
                    .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(1270, Short.MAX_VALUE))
        );
        pnlSearchLayout.setVerticalGroup(
            pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlKhachHangLayout = new javax.swing.GroupLayout(pnlKhachHang);
        pnlKhachHang.setLayout(pnlKhachHangLayout);
        pnlKhachHangLayout.setHorizontalGroup(
            pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKhachHangLayout.createSequentialGroup()
                .addComponent(pnlSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlKhachHangLayout.setVerticalGroup(
            pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlKhachHangLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlTong1.add(pnlKhachHang, "cardKhachHang");

        pnlHoaDon.setBackground(new java.awt.Color(255, 255, 255));
        pnlHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlHoaDonMouseClicked(evt);
            }
        });

        jPanel34.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        txtTimKiemHoaDon.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemHoaDonCaretUpdate(evt);
            }
        });
        txtTimKiemHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemHoaDonActionPerformed(evt);
            }
        });
        txtTimKiemHoaDon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemHoaDonKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(txtTimKiemHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel50)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimKiemHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jPanel35.setBorder(javax.swing.BorderFactory.createTitledBorder("Lọc\n"));

        jLabel12.setText("Đến");

        jLabel110.setText("Từ");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel113.setText("Sản phẩm");

        jLabel114.setText("Trạng thái hóa đơn");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton3.setText("Tìm");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox2, 0, 248, Short.MAX_VALUE)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel113, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel114))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
                        .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(23, 23, 23))))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addGap(13, 13, 13)
                        .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel113)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel114)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jButton1.setText("XUẤT EXEL  ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tblhoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        jScrollPane12.setViewportView(tblhoadon);

        tblhdct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jScrollPane13.setViewportView(tblhdct);

        javax.swing.GroupLayout pnlHoaDonLayout = new javax.swing.GroupLayout(pnlHoaDon);
        pnlHoaDon.setLayout(pnlHoaDonLayout);
        pnlHoaDonLayout.setHorizontalGroup(
            pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlHoaDonLayout.createSequentialGroup()
                        .addGroup(pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHoaDonLayout.createSequentialGroup()
                                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 982, Short.MAX_VALUE)
                                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(97, 97, 97)))
                        .addGap(29, 29, 29))
                    .addGroup(pnlHoaDonLayout.createSequentialGroup()
                        .addComponent(jScrollPane12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        pnlHoaDonLayout.setVerticalGroup(
            pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHoaDonLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane13)
                    .addGroup(pnlHoaDonLayout.createSequentialGroup()
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pnlTong1.add(pnlHoaDon, "cardHoaDon");

        pnlKhuyenMai.setBackground(new java.awt.Color(255, 255, 255));

        jPanel38.setBackground(new java.awt.Color(71, 120, 197));
        jPanel38.setPreferredSize(new java.awt.Dimension(1457, 92));

        jLabel117.setText("Khuyến mãi");
        jLabel117.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        jLabel117.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator7.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel117, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator7))
                .addContainerGap(2016, Short.MAX_VALUE))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel117)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        jPanel36.setBackground(new java.awt.Color(255, 255, 255));
        jPanel36.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chương trình khuyến mãi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        jPanel36.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel115.setText("Mã Khuyến mãi");
        jLabel115.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtMaKM.setEditable(false);
        txtMaKM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel116.setText("Tên khuyến mãi");
        jLabel116.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtTenKM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel118.setText("Mức giảm giá ");
        jLabel118.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtMucGG.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel119.setText("Hình thức khuyến mãi");
        jLabel119.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cbbHTKM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbHTKM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel120.setText("Ngày bắt đầu");
        jLabel120.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        dPNgayBD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel121.setText("Ngày kết thúc");
        jLabel121.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        dPNgayKT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel122.setText("Mô tả");
        jLabel122.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtMoTaKM.setColumns(20);
        txtMoTaKM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMoTaKM.setRows(5);
        jScrollPane14.setViewportView(txtMoTaKM);

        btnThemKM.setText("Thêm");
        btnThemKM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnThemKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKMActionPerformed(evt);
            }
        });

        btnSuaKM.setText("Sửa");
        btnSuaKM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSuaKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaKMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel115)
                            .addComponent(jLabel120)
                            .addComponent(jLabel121)
                            .addComponent(dPNgayBD, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .addComponent(cbbHTKM, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMaKM)
                            .addComponent(dPNgayKT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel119, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel122, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel116)
                    .addComponent(jLabel118)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(txtMucGG)
                    .addComponent(txtTenKM))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(btnThemKM)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
                .addComponent(btnSuaKM)
                .addGap(153, 153, 153))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel116)
                    .addComponent(jLabel115))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel119)
                    .addComponent(jLabel118))
                .addGap(10, 10, 10)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbHTKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMucGG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel120)
                    .addComponent(jLabel122))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addComponent(dPNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(jLabel121)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dPNgayKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane14))
                .addGap(66, 66, 66)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemKM)
                    .addComponent(btnSuaKM))
                .addContainerGap(288, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel39.setBackground(new java.awt.Color(255, 255, 255));
        jPanel39.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách khuyến mãi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        tblKM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khuyến mãi", "Tên khuyến mãi", "Hình thức khuyến mãi", "Mức giảm giá", "Ngày bắt đầu", "Ngày kết thúc", "Trạng thái", "Mô tả"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblKM.setRowHeight(25);
        tblKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKMMouseClicked(evt);
            }
        });
        jScrollPane16.setViewportView(tblKM);

        txtSearchKM.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(71, 120, 197)));
        txtSearchKM.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSearchKMCaretUpdate(evt);
            }
        });

        jLabel126.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Search_18px.png"))); // NOI18N
        jLabel126.setEnabled(false);

        cboLoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Đang hoạt động", "Ngừng giảm giá" }));
        cboLoc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboLocItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel126, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearchKM, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cboLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSearchKM, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboLoc))
                    .addComponent(jLabel126, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane5.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        tblDienThoaiKM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Mã điện thoại", "Tện điện thoại", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblDienThoaiKM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblDienThoaiKM.setRowHeight(25);
        tblDienThoaiKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDienThoaiKMMouseClicked(evt);
            }
        });
        jScrollPane15.setViewportView(tblDienThoaiKM);

        jTabbedPane5.addTab("Điện thoại", jScrollPane15);

        tblPKKM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Mã phụ kiện", "Tên phụ kiện", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblPKKM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblPKKM.setRowHeight(25);
        jScrollPane17.setViewportView(tblPKKM);

        jTabbedPane5.addTab("Phụ kiện", jScrollPane17);

        jPanel41.setBackground(new java.awt.Color(255, 255, 255));

        jLabel123.setText("Tên điện thoại");
        jLabel123.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtSearchTenDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearchTenDT.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel124.setText("Tên phụ kiện");
        jLabel124.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtSearchTenPK.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearchTenPK.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel125.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Search_18px.png"))); // NOI18N
        jLabel125.setEnabled(false);

        jLabel127.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Search_18px.png"))); // NOI18N
        jLabel127.setEnabled(false);

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel123)
                    .addComponent(jLabel124))
                .addGap(18, 18, 18)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSearchTenDT)
                    .addComponent(txtSearchTenPK))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel125, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel127, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSearchTenDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel123))
                    .addComponent(jLabel125, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel127, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSearchTenPK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel124)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cbSelectAll.setText("Select All");
        cbSelectAll.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbSelectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSelectAllActionPerformed(evt);
            }
        });

        cbClearAll.setText("Clear All");
        cbClearAll.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbClearAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbClearAllActionPerformed(evt);
            }
        });

        show.setText("Show");
        show.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1611, Short.MAX_VALUE)
                .addGap(20, 20, 20))
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbSelectAll)
                    .addComponent(cbClearAll))
                .addGap(18, 18, 18)
                .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(show)
                .addGap(46, 46, 46))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel42Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel41, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel42Layout.createSequentialGroup()
                        .addComponent(cbClearAll)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbSelectAll))
                    .addComponent(show, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlKhuyenMaiLayout = new javax.swing.GroupLayout(pnlKhuyenMai);
        pnlKhuyenMai.setLayout(pnlKhuyenMaiLayout);
        pnlKhuyenMaiLayout.setHorizontalGroup(
            pnlKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, 1380, Short.MAX_VALUE)
            .addGroup(pnlKhuyenMaiLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlKhuyenMaiLayout.setVerticalGroup(
            pnlKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKhuyenMaiLayout.createSequentialGroup()
                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlKhuyenMaiLayout.createSequentialGroup()
                        .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlTong1.add(pnlKhuyenMai, "cardKhuyenMai");

        pnlBanHang.setBackground(new java.awt.Color(255, 255, 255));
        pnlBanHang.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel22.setMinimumSize(new java.awt.Dimension(200, 200));

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 228, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel23.setMinimumSize(new java.awt.Dimension(200, 200));

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Giỏ hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 16), new java.awt.Color(13, 83, 193))); // NOI18N

        tblHoaDonChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên SP", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDonChiTiet.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        tblHoaDonChiTiet.setRowHeight(25);
        tblHoaDonChiTiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonChiTietMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDonChiTiet);

        jButton40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/okcart.png"))); // NOI18N
        jButton40.setBackground(new java.awt.Color(0, 0, 0));
        jButton40.setBorderPainted(false);
        jButton40.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton40.setForeground(new java.awt.Color(255, 255, 255));
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton40ActionPerformed(evt);
            }
        });

        jButton41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clear.png"))); // NOI18N
        jButton41.setBackground(new java.awt.Color(71, 120, 197));
        jButton41.setBorderPainted(false);
        jButton41.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton41.setForeground(new java.awt.Color(255, 255, 255));
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });

        jButton42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/qr.png"))); // NOI18N
        jButton42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton42MouseClicked(evt);
            }
        });
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton40, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton41, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton42, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton42)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách Hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 16), new java.awt.Color(13, 83, 193))); // NOI18N
        jPanel24.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Hóa đơn", "Mã Nhân viên", "Ngày Tạo", "Ngày Thanh Toán", "Tình trạng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        tblHoaDon.setOpaque(false);
        tblHoaDon.setRowHeight(25);
        tblHoaDon.setSelectionBackground(new java.awt.Color(0, 0, 0));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane18.setViewportView(tblHoaDon);

        cboHoaDon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Chờ thanh toán", "Đã thanh toán", "Đã Hủy" }));
        cboHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboHoaDon.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboHoaDonItemStateChanged(evt);
            }
        });

        btnTaoHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addbill.png"))); // NOI18N
        btnTaoHoaDon.setBackground(new java.awt.Color(71, 120, 197));
        btnTaoHoaDon.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnTaoHoaDon.setBorderPainted(false);
        btnTaoHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnTaoHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        btnHuyHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delbill.png"))); // NOI18N
        btnHuyHoaDon.setBackground(new java.awt.Color(0, 0, 0));
        btnHuyHoaDon.setBorderPainted(false);
        btnHuyHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnHuyHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnHuyHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyHoaDonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addComponent(cboHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHuyHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane18)
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHuyHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboHoaDon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));
        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 16), new java.awt.Color(13, 83, 193))); // NOI18N

        jTextField100.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        pnlSanPham.setPreferredSize(new java.awt.Dimension(700, 200));
        scpSanPhamBH.setViewportView(pnlSanPham);

        cboLocSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả", "Điện thoại", "Phụ Kiện" }));
        cboLocSanPham.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        cboLocSanPham.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboLocSanPhamItemStateChanged(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Search_18px.png"))); // NOI18N
        jLabel2.setEnabled(false);

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jTextField100, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cboLocSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
            .addComponent(scpSanPhamBH, javax.swing.GroupLayout.DEFAULT_SIZE, 819, Short.MAX_VALUE)
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField100, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboLocSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scpSanPhamBH))
        );

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));
        jPanel26.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin chung", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 16), new java.awt.Color(13, 83, 193))); // NOI18N

        jLabel6.setText("Mã NV");
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabel99.setText("Ngày Tạo");
        jLabel99.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabel100.setText("Mã Hóa đơn");
        jLabel100.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        lblManV.setText(".........................................");
        lblManV.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        lblNgayTao.setText("................");
        lblNgayTao.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        lblMaHD.setText("..........................");
        lblMaHD.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        btnLayThongTin.setText("Lấy Thông tin");
        btnLayThongTin.setBackground(new java.awt.Color(71, 120, 197));
        btnLayThongTin.setBorderPainted(false);
        btnLayThongTin.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnLayThongTin.setForeground(new java.awt.Color(255, 255, 255));
        btnLayThongTin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLayThongTinActionPerformed(evt);
            }
        });

        jLabel45.setText("Tên khách hàng");
        jLabel45.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        lblTenKhachHang.setText("-");
        lblTenKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(39, 39, 39)
                        .addComponent(lblManV, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel100)
                            .addComponent(jLabel99))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNgayTao))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                        .addComponent(btnLayThongTin)
                        .addGap(23, 23, 23))))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblManV)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTenKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel100)
                    .addComponent(lblMaHD)
                    .addComponent(btnLayThongTin))
                .addGap(29, 29, 29)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel99)
                    .addComponent(lblNgayTao))
                .addGap(35, 35, 35))
        );

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 16), new java.awt.Color(13, 83, 193))); // NOI18N

        jLabel137.setText("Tổng tiền");
        jLabel137.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabel140.setText("Điểm tích luỹ");
        jLabel140.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabel141.setText("Tiền khách đưa");
        jLabel141.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabel142.setText("Tiền trả khách");
        jLabel142.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabel143.setText("Ghi chú");
        jLabel143.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jTextArea5.setColumns(20);
        jTextArea5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTextArea5.setRows(5);
        jTextArea5.setBorder(new javax.swing.border.MatteBorder(null));
        jScrollPane20.setViewportView(jTextArea5);

        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.setBackground(new java.awt.Color(71, 120, 197));
        btnThanhToan.setBorderPainted(false);
        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        jLabel144.setText("Tiền Khuyến mãi");
        jLabel144.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        txtTongTien.setEditable(false);
        txtTongTien.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtTongTien.setText("0");

        jTextField97.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTextField97.setText("0");
        jTextField97.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        txtTienKhachDua.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtTienKhachDua.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtTienKhachDua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTienKhachDuaKeyPressed(evt);
            }
        });

        txtTienTraKhach.setEditable(false);
        txtTienTraKhach.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtTienTraKhach.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        txtDiem.setEditable(false);
        txtDiem.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtDiem.setBackground(new java.awt.Color(255, 255, 255));
        txtDiem.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        chkDiemTichLuy.setText("Dùng");
        chkDiemTichLuy.setBackground(new java.awt.Color(255, 255, 255));
        chkDiemTichLuy.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jLabel143, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane20)
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel137, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel144))
                                .addGap(9, 9, 9)
                                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTongTien)
                                    .addGroup(jPanel27Layout.createSequentialGroup()
                                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField97, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel141, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel142, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel140))
                                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel27Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(chkDiemTichLuy))
                                    .addGroup(jPanel27Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtTienTraKhach, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtTienKhachDua))))))
                        .addGap(30, 30, 30))))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel137)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel144, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField97, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel140)
                    .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkDiemTichLuy))
                .addGap(21, 21, 21)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel141))
                .addGap(26, 26, 26)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel142)
                    .addComponent(txtTienTraKhach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jLabel143)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane20, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlBanHangLayout = new javax.swing.GroupLayout(pnlBanHang);
        pnlBanHang.setLayout(pnlBanHangLayout);
        pnlBanHangLayout.setHorizontalGroup(
            pnlBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBanHangLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(pnlBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(603, 603, 603)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlBanHangLayout.setVerticalGroup(
            pnlBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBanHangLayout.createSequentialGroup()
                .addGroup(pnlBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnlBanHangLayout.createSequentialGroup()
                        .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnlBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlBanHangLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, 0)
                        .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlBanHangLayout.createSequentialGroup()
                        .addGroup(pnlBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBanHangLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlTong1.add(pnlBanHang, "cardBanHang");

        pnlNhaCungCap.setBackground(new java.awt.Color(255, 255, 255));

        jLabel128.setText("Ma");

        jLabel129.setText("Dia Chi");

        jLabel130.setText("Email");

        jLabel131.setText("Ten");

        jLabel132.setText("So dien thoai");

        tbNcc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbNcc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbNccMouseClicked(evt);
            }
        });
        jScrollPane19.setViewportView(tbNcc);

        cbbLocNcc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnThemNcc.setText("Them");
        btnThemNcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNccActionPerformed(evt);
            }
        });

        btnSuaNcc.setText("Sua");
        btnSuaNcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaNccActionPerformed(evt);
            }
        });

        btnXoaNcc.setText("Xoa");
        btnXoaNcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaNccActionPerformed(evt);
            }
        });

        btnKhoiPhucNcc.setText("Khoi Phuc");
        btnKhoiPhucNcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhoiPhucNccActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel128)
                            .addComponent(jLabel129))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaNcc, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                            .addComponent(txtDiaChiNcc)))
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addComponent(jLabel130)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTimKiemNcc, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmailNcc, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(cbbLocNcc, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel131)
                            .addComponent(jLabel132))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenNcc, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                            .addComponent(txtSdtNcc))
                        .addGap(68, 68, 68)
                        .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnXoaNcc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSuaNcc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThemNcc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnKhoiPhucNcc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(95, 95, 95))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel44Layout.createSequentialGroup()
                .addComponent(jScrollPane19)
                .addContainerGap())
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel128)
                            .addComponent(txtMaNcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThemNcc)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel44Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel131)
                            .addComponent(txtTenNcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel129)
                            .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel132)
                                .addComponent(txtSdtNcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDiaChiNcc, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel130)
                            .addComponent(txtEmailNcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoaNcc)))
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btnSuaNcc)))
                .addGap(18, 18, 18)
                .addComponent(btnKhoiPhucNcc)
                .addGap(41, 41, 41)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiemNcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbLocNcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane4.addTab("NCC", jPanel44);

        jPanel46.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Phu Kien", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        tbChonPK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane21.setViewportView(tbChonPK);

        txtTimPk.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimPkCaretUpdate(evt);
            }
        });
        txtTimPk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimPkKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane21, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                    .addGroup(jPanel46Layout.createSequentialGroup()
                        .addComponent(txtTimPk, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimPk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane21, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel47.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Nha Cung Cap", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        tbChonNCCPK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane22.setViewportView(tbChonNCCPK);

        txtTimNccPk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimNccPkKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane22)
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addComponent(txtTimNccPk, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimNccPk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane22, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel48.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnThemPKNCC.setText("Them");
        btnThemPKNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemPKNCCActionPerformed(evt);
            }
        });

        btnSuaPKNCC.setText("Sua");
        btnSuaPKNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaPKNCCActionPerformed(evt);
            }
        });

        btnXoaPKNCC.setText("Xoa");

        btnNhapPKNCC.setText("Nhap");
        btnNhapPKNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapPKNCCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel48Layout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNhapPKNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaPKNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaPKNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemPKNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btnThemPKNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btnSuaPKNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnXoaPKNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnNhapPKNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel49.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "PK - NCC"));

        tbPKNCC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane23.setViewportView(tbPKNCC);

        cbbPKNCC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane23)
                .addContainerGap())
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addComponent(txtTimKiemPKNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(cbbPKNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel49Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiemPKNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbPKNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane23, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(124, Short.MAX_VALUE))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("PKNCC", jPanel45);

        jPanel51.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Dien Thoai", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        tbChonDt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane24.setViewportView(tbChonDt);

        txtTimDt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimDtKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane24, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                    .addGroup(jPanel51Layout.createSequentialGroup()
                        .addComponent(txtTimDt, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel51Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimDt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel52.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "NhaCungCap", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        tbChonNccDt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane25.setViewportView(tbChonNccDt);

        txtTimNccDt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimNccDtKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane25, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                    .addGroup(jPanel52Layout.createSequentialGroup()
                        .addComponent(txtTimNccDt, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel52Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimNccDt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane25, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel53.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "DT - NCC"));

        tbDTNCC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane26.setViewportView(tbDTNCC);

        cbbDTNCC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane26)
                    .addGroup(jPanel53Layout.createSequentialGroup()
                        .addComponent(txtTimKiemDTNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94)
                        .addComponent(cbbDTNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel53Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiemDTNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbDTNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane26, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel54.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnthemDTNCC1.setText("Thêm");
        btnthemDTNCC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemDTNCC1ActionPerformed(evt);
            }
        });

        btnSuaDTNCC1.setText("Sua");
        btnSuaDTNCC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaDTNCC1ActionPerformed(evt);
            }
        });

        btnXoaDTNCC1.setText("Xoa");

        btnNhapDTNCC.setText("Nhap");
        btnNhapDTNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapDTNCCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(jPanel54);
        jPanel54.setLayout(jPanel54Layout);
        jPanel54Layout.setHorizontalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel54Layout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNhapDTNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaDTNCC1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaDTNCC1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnthemDTNCC1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );
        jPanel54Layout.setVerticalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btnthemDTNCC1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btnSuaDTNCC1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnXoaDTNCC1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnNhapDTNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel50Layout.createSequentialGroup()
                        .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel50Layout.createSequentialGroup()
                        .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane4.addTab("DTNCC", jPanel50);

        javax.swing.GroupLayout pnlNhaCungCapLayout = new javax.swing.GroupLayout(pnlNhaCungCap);
        pnlNhaCungCap.setLayout(pnlNhaCungCapLayout);
        pnlNhaCungCapLayout.setHorizontalGroup(
            pnlNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1380, Short.MAX_VALUE)
            .addGroup(pnlNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlNhaCungCapLayout.createSequentialGroup()
                    .addGap(3, 3, 3)
                    .addComponent(jTabbedPane4)
                    .addGap(3, 3, 3)))
        );
        pnlNhaCungCapLayout.setVerticalGroup(
            pnlNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 817, Short.MAX_VALUE)
            .addGroup(pnlNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlNhaCungCapLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pnlTong1.add(pnlNhaCungCap, "cardNCC");
        pnlNhaCungCap.getAccessibleContext().setAccessibleName("");

        getContentPane().add(pnlTong1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 1380, 750));

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1380, Short.MAX_VALUE)
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 1380, 50));

        side_pane.setBackground(new java.awt.Color(23, 35, 51));
        side_pane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_1.setBackground(new java.awt.Color(23, 35, 51));
        btn_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_1MouseExited(evt);
            }
        });

        ind_20.setPreferredSize(new java.awt.Dimension(3, 43));
        ind_20.setOpaque(false);

        javax.swing.GroupLayout ind_20Layout = new javax.swing.GroupLayout(ind_20);
        ind_20.setLayout(ind_20Layout);
        ind_20Layout.setHorizontalGroup(
            ind_20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_20Layout.setVerticalGroup(
            ind_20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        btn_1.add(ind_20);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png"))); // NOI18N
        jLabel14.setText("Trang chủ");
        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        btn_1.add(jLabel14);

        side_pane.add(btn_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 160, 60));

        btn_12.setBackground(new java.awt.Color(23, 35, 51));
        btn_12.setPreferredSize(new java.awt.Dimension(158, 60));
        btn_12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_2MouseExited(evt);
            }
        });

        ind_21.setPreferredSize(new java.awt.Dimension(3, 43));
        ind_21.setOpaque(false);

        ind_22.setPreferredSize(new java.awt.Dimension(3, 43));
        ind_22.setOpaque(false);

        javax.swing.GroupLayout ind_22Layout = new javax.swing.GroupLayout(ind_22);
        ind_22.setLayout(ind_22Layout);
        ind_22Layout.setHorizontalGroup(
            ind_22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_22Layout.setVerticalGroup(
            ind_22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        ind_21.add(ind_22);

        jLabel55.setText("Bán hàng");
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        ind_21.add(jLabel55);

        btn_12.add(ind_21);

        jLabel69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/selling.png"))); // NOI18N
        jLabel69.setText("Bán hàng");
        jLabel69.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        btn_12.add(jLabel69);

        side_pane.add(btn_12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 160, -1));

        btn_13.setBackground(new java.awt.Color(23, 35, 51));
        btn_13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_3MouseExited(evt);
            }
        });

        ind_23.setPreferredSize(new java.awt.Dimension(3, 43));
        ind_23.setOpaque(false);

        javax.swing.GroupLayout ind_23Layout = new javax.swing.GroupLayout(ind_23);
        ind_23.setLayout(ind_23Layout);
        ind_23Layout.setHorizontalGroup(
            ind_23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_23Layout.setVerticalGroup(
            ind_23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        btn_13.add(ind_23);

        jLabel90.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/smartphone-call.png"))); // NOI18N
        jLabel90.setText("Điện thoại");
        jLabel90.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(255, 255, 255));
        btn_13.add(jLabel90);

        side_pane.add(btn_13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 160, 60));

        btn_14.setBackground(new java.awt.Color(23, 35, 51));
        btn_14.setPreferredSize(new java.awt.Dimension(158, 60));
        btn_14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_4MouseExited(evt);
            }
        });

        ind_24.setPreferredSize(new java.awt.Dimension(3, 43));
        ind_24.setOpaque(false);

        javax.swing.GroupLayout ind_24Layout = new javax.swing.GroupLayout(ind_24);
        ind_24.setLayout(ind_24Layout);
        ind_24Layout.setHorizontalGroup(
            ind_24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_24Layout.setVerticalGroup(
            ind_24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        btn_14.add(ind_24);

        jLabel91.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/headphone.png"))); // NOI18N
        jLabel91.setText("Phụ kiện");
        jLabel91.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(255, 255, 255));
        btn_14.add(jLabel91);

        side_pane.add(btn_14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 160, 60));

        btn_15.setBackground(new java.awt.Color(23, 35, 51));
        btn_15.setPreferredSize(new java.awt.Dimension(158, 60));
        btn_15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_5MouseExited(evt);
            }
        });

        ind_25.setPreferredSize(new java.awt.Dimension(3, 43));
        ind_25.setOpaque(false);

        ind_26.setPreferredSize(new java.awt.Dimension(3, 43));
        ind_26.setOpaque(false);

        javax.swing.GroupLayout ind_26Layout = new javax.swing.GroupLayout(ind_26);
        ind_26.setLayout(ind_26Layout);
        ind_26Layout.setHorizontalGroup(
            ind_26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_26Layout.setVerticalGroup(
            ind_26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        ind_25.add(ind_26);

        jLabel92.setText("Bán hàng");
        jLabel92.setForeground(new java.awt.Color(255, 255, 255));
        ind_25.add(jLabel92);

        btn_15.add(ind_25);

        jLabel93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bill.png"))); // NOI18N
        jLabel93.setText("Hóa đơn");
        jLabel93.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(255, 255, 255));
        btn_15.add(jLabel93);

        side_pane.add(btn_15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 160, -1));

        btn_16.setBackground(new java.awt.Color(23, 35, 51));
        btn_16.setPreferredSize(new java.awt.Dimension(158, 60));
        btn_16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_6MouseExited(evt);
            }
        });

        ind_27.setPreferredSize(new java.awt.Dimension(3, 43));
        ind_27.setOpaque(false);

        ind_28.setPreferredSize(new java.awt.Dimension(3, 43));
        ind_28.setOpaque(false);

        javax.swing.GroupLayout ind_28Layout = new javax.swing.GroupLayout(ind_28);
        ind_28.setLayout(ind_28Layout);
        ind_28Layout.setHorizontalGroup(
            ind_28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_28Layout.setVerticalGroup(
            ind_28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        ind_27.add(ind_28);

        jLabel94.setText("Bán hàng");
        jLabel94.setForeground(new java.awt.Color(255, 255, 255));
        ind_27.add(jLabel94);

        btn_16.add(ind_27);

        jLabel95.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_user_20px_1.png"))); // NOI18N
        jLabel95.setText("Nhà cung cấp");
        jLabel95.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(255, 255, 255));
        btn_16.add(jLabel95);

        side_pane.add(btn_16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 160, -1));

        btn_17.setBackground(new java.awt.Color(23, 35, 51));
        btn_17.setPreferredSize(new java.awt.Dimension(158, 60));
        btn_17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_7MouseExited(evt);
            }
        });

        ind_29.setPreferredSize(new java.awt.Dimension(3, 43));
        ind_29.setOpaque(false);

        ind_30.setPreferredSize(new java.awt.Dimension(3, 43));
        ind_30.setOpaque(false);

        javax.swing.GroupLayout ind_30Layout = new javax.swing.GroupLayout(ind_30);
        ind_30.setLayout(ind_30Layout);
        ind_30Layout.setHorizontalGroup(
            ind_30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_30Layout.setVerticalGroup(
            ind_30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        ind_29.add(ind_30);

        jLabel96.setText("Bán hàng");
        jLabel96.setForeground(new java.awt.Color(255, 255, 255));
        ind_29.add(jLabel96);

        btn_17.add(ind_29);

        jLabel97.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/price-tag.png"))); // NOI18N
        jLabel97.setText("Khuyến mãi");
        jLabel97.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(255, 255, 255));
        btn_17.add(jLabel97);

        side_pane.add(btn_17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 160, -1));

        btn_18.setBackground(new java.awt.Color(23, 35, 51));
        btn_18.setPreferredSize(new java.awt.Dimension(158, 60));
        btn_18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_8MouseExited(evt);
            }
        });

        ind_31.setPreferredSize(new java.awt.Dimension(3, 43));
        ind_31.setOpaque(false);

        ind_32.setPreferredSize(new java.awt.Dimension(3, 43));
        ind_32.setOpaque(false);

        javax.swing.GroupLayout ind_32Layout = new javax.swing.GroupLayout(ind_32);
        ind_32.setLayout(ind_32Layout);
        ind_32Layout.setHorizontalGroup(
            ind_32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_32Layout.setVerticalGroup(
            ind_32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        ind_31.add(ind_32);

        jLabel106.setText("Bán hàng");
        jLabel106.setForeground(new java.awt.Color(255, 255, 255));
        ind_31.add(jLabel106);

        btn_18.add(ind_31);

        jLabel112.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/staff.png"))); // NOI18N
        jLabel112.setText("Nhân viên");
        jLabel112.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel112.setForeground(new java.awt.Color(255, 255, 255));
        btn_18.add(jLabel112);

        side_pane.add(btn_18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 160, -1));

        lblAnh1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imge_1.jpg"))); // NOI18N
        side_pane.add(lblAnh1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 60, 60));

        btn_19.setBackground(new java.awt.Color(23, 35, 51));
        btn_19.setPreferredSize(new java.awt.Dimension(158, 60));
        btn_19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_9MouseExited(evt);
            }
        });

        ind_33.setPreferredSize(new java.awt.Dimension(3, 43));
        ind_33.setOpaque(false);

        ind_34.setPreferredSize(new java.awt.Dimension(3, 43));
        ind_34.setOpaque(false);

        javax.swing.GroupLayout ind_34Layout = new javax.swing.GroupLayout(ind_34);
        ind_34.setLayout(ind_34Layout);
        ind_34Layout.setHorizontalGroup(
            ind_34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_34Layout.setVerticalGroup(
            ind_34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        ind_33.add(ind_34);

        jLabel133.setText("Bán hàng");
        jLabel133.setForeground(new java.awt.Color(255, 255, 255));
        ind_33.add(jLabel133);

        btn_19.add(ind_33);

        jLabel134.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bar-chart.png"))); // NOI18N
        jLabel134.setText("Thống kê");
        jLabel134.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel134.setForeground(new java.awt.Color(255, 255, 255));
        btn_19.add(jLabel134);

        side_pane.add(btn_19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 660, 160, -1));

        btn_20.setBackground(new java.awt.Color(23, 35, 51));
        btn_20.setPreferredSize(new java.awt.Dimension(158, 60));
        btn_20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_10MouseExited(evt);
            }
        });

        ind_35.setPreferredSize(new java.awt.Dimension(3, 43));
        ind_35.setOpaque(false);

        ind_36.setPreferredSize(new java.awt.Dimension(3, 43));
        ind_36.setOpaque(false);

        javax.swing.GroupLayout ind_36Layout = new javax.swing.GroupLayout(ind_36);
        ind_36.setLayout(ind_36Layout);
        ind_36Layout.setHorizontalGroup(
            ind_36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_36Layout.setVerticalGroup(
            ind_36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        ind_35.add(ind_36);

        jLabel135.setText("Bán hàng");
        jLabel135.setForeground(new java.awt.Color(255, 255, 255));
        ind_35.add(jLabel135);

        btn_20.add(ind_35);

        jLabel136.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/people.png"))); // NOI18N
        jLabel136.setText("Khách hàng");
        jLabel136.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel136.setForeground(new java.awt.Color(255, 255, 255));
        btn_20.add(jLabel136);

        side_pane.add(btn_20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, 160, -1));

        btn_exit1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_exitMousePressed(evt);
            }
        });
        side_pane.add(btn_exit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 640, -1, 46));

        btn_21.setBackground(new java.awt.Color(23, 35, 51));
        btn_21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_21.setPreferredSize(new java.awt.Dimension(158, 60));
        btn_21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_11MouseExited(evt);
            }
        });

        ind_37.setPreferredSize(new java.awt.Dimension(3, 43));
        ind_37.setOpaque(false);

        ind_38.setPreferredSize(new java.awt.Dimension(3, 43));
        ind_38.setOpaque(false);

        javax.swing.GroupLayout ind_38Layout = new javax.swing.GroupLayout(ind_38);
        ind_38.setLayout(ind_38Layout);
        ind_38Layout.setHorizontalGroup(
            ind_38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_38Layout.setVerticalGroup(
            ind_38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        ind_37.add(ind_38);

        jLabel138.setText("Bán hàng");
        jLabel138.setForeground(new java.awt.Color(255, 255, 255));
        ind_37.add(jLabel138);

        btn_21.add(ind_37);

        jLabel139.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Exit_25px.png"))); // NOI18N
        jLabel139.setText("Đăng xuất");
        jLabel139.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel139.setForeground(new java.awt.Color(255, 255, 255));
        btn_21.add(jLabel139);

        side_pane.add(btn_21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 720, 160, 50));

        jPanel43.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1380, Short.MAX_VALUE)
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        side_pane.add(jPanel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 1380, 50));

        getContentPane().add(side_pane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 840));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    int xx, xy;
    private void tblListDienThoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListDienThoaiMouseClicked
        // TODO add your handling code here:
        int row = tblListDienThoai.getSelectedRow();
        QLDienThoai qlDienThoai = listQLDienThoai.get(row);
        cbbTenHangDT.setSelectedItem(qlDienThoai.getHang().getTen());
        txtMaDienThoai.setText(qlDienThoai.getMaDienThoai());
        txtTenDienThoai.setText(qlDienThoai.getTenDienThoai());
        txtGiaBanDienThoai.setText(String.valueOf(qlDienThoai.getGiaBan()));
        txtMoTaDienThoai.setText(qlDienThoai.getMota());
        txtRamDT.setText(qlDienThoai.getRAM());
        txtRomDT.setText(qlDienThoai.getROM());
        txtCPUDT.setText(qlDienThoai.getCPU());
        txtHeDieuHanhDT.setText(qlDienThoai.getHeDieuHanh());
        txtMauSacDT.setText(qlDienThoai.getMauSac());
        txtManHinhDT.setText(qlDienThoai.getManHinh());
        txtCameraDT.setText(qlDienThoai.getCamera());
        txtPinDT.setText(qlDienThoai.getPin());
        txtBaoHanhDT.setText(String.valueOf(qlDienThoai.getThoiGianBaoHanh()));
        cbbTrangThaiDT.setSelectedItem(qlDienThoai.getTrangThai());
        if (qlDienThoai.getTrangThai() == 1) {
            cbbTrangThaiDT.setSelectedItem("Đang Bán");
        } else {
            cbbTrangThaiDT.setSelectedItem("Ngừng Bán");
        }
        if (qlDienThoai.getAnh() != null) {
            try {
                Image img = ImageHelper.createFromByteArray(qlDienThoai.getAnh(), "jpg");
                lbAnhDT.setIcon(new ImageIcon(ImageHelper.resige(img, lbAnhDT.getWidth(), lbAnhDT.getHeight())));
                personalImage = qlDienThoai.getAnh();
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        } else {
            lbAnhDT.setIcon(null);
        }
    }//GEN-LAST:event_tblListDienThoaiMouseClicked

    private void lbAnhDTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAnhDTMouseClicked
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                } else {
                    return f.getName().toLowerCase().endsWith(".jpg");
                }
            }

            @Override
            public String getDescription() {
                return "Image File (*.jpg)";
            }
        });
        if (chooser.showOpenDialog(pnlDienThoai) == JFileChooser.CANCEL_OPTION) {
            return;
        }
        try {
            File file = chooser.getSelectedFile();
            ImageIcon icon = new ImageIcon(file.getPath());
            Image image = ImageHelper.resige(icon.getImage(), 200, 200);
            ImageIcon resizedIcon = new ImageIcon(image);
            lbAnhDT.setIcon(resizedIcon);
            personalImage = ImageHelper.toByteArray(image, "jpg");
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }//GEN-LAST:event_lbAnhDTMouseClicked

    private void btnLamMoiDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiDTActionPerformed
        // TODO add your handling code here:
        txtTimKiemDienThoai.setText("");
        txtBaoHanhDT.setText("");
        txtCPUDT.setText("");
        txtCameraDT.setText("");
        txtGiaBanDienThoai.setText("");
        txtGiaNhapDienThoai.setText("");
        txtHeDieuHanhDT.setText("");
        txtMaDienThoai.setText("");
        txtManHinhDT.setText("");
        txtMauSacDT.setText("");
        txtMoTaDienThoai.setText("");
        txtPinDT.setText("");
        txtRamDT.setText("");
        txtRomDT.setText("");
        txtSoLuongDienThoai.setText("");
        txtTenDienThoai.setText("");
        txtTimKiemDienThoai.setText("");
        cbbTenHangDT.setSelectedIndex(0);
        cbbTrangThaiDT.setSelectedIndex(0);
        lbAnhDT.setIcon(null);
    }//GEN-LAST:event_btnLamMoiDTActionPerformed

    private void btnDoiTrangThaiDienThoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiTrangThaiDienThoaiActionPerformed
        // TODO add your handling code here:
        int row = tblListDienThoai.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần sửa.");
        } else {
            UUID idDienThoai = listQLDienThoai.get(row).getIdDienThoai();
            String ma = txtMaDienThoai.getText();
            String ten = txtTenDienThoai.getText();
            String ram = txtRamDT.getText();
            String rom = txtRomDT.getText();
            String cpu = txtCPUDT.getText();
            String hdh = txtHeDieuHanhDT.getText();
            String manHinh = txtManHinhDT.getText();
            String camera = txtCameraDT.getText();
            String pin = txtPinDT.getText();
            String mauSac = txtMauSacDT.getText();
            Integer baoHanh = Integer.valueOf(txtBaoHanhDT.getText());
            Integer trangThai;
            if (cbbTrangThaiDT.getSelectedItem().equals("Đang Bán")) {
                trangThai = 1;
            } else {
                trangThai = 0;
            }
            String giaBan1 = txtGiaBanDienThoai.getText();
            BigDecimal giaBan = new BigDecimal(giaBan1);
            String moTa = txtMoTaDienThoai.getText();
            Hang tenHang = iHangService.getOne(cbbTenHangDT.getSelectedItem().toString());
            if (ten.isBlank() || ram.isBlank() || rom.isBlank() || cpu.isBlank() || hdh.isBlank() || manHinh.isBlank() || camera.isBlank() || pin.isBlank() || mauSac.isBlank() || String.valueOf(giaBan).isBlank() || moTa.isBlank()) {
                JOptionPane.showMessageDialog(this, "Các trường đang trống, vui lòng nhập đầy đủ!");
            } //            else if (ram.matches("^[0-9.0-9]{1,3}[GBgb|MBmb]{2}$")) {
            //                JOptionPane.showMessageDialog(this, "Ram không đúng định dạng. (số + GB hoặc MB)");
            //            } else if (rom.matches("^[0-9.0-9]{1,3}[GBgb|MBmb]{2}$")) {
            //                JOptionPane.showMessageDialog(this, "Rom không đúng định dạng. (số + GB hoặc MB)");
            //            } else if (cpu.matches("^[a-z A-Z 0-9]{6,50}$")) {
            //                JOptionPane.showMessageDialog(this, "CPU không đúng định dạng.");
            //            } else if (hdh.equals("Android") || hdh.equals("IOS") || hdh.equals("Windows Phone") || hdh.equals("Symbian") || hdh.equals("BlackBerry OS") || hdh.equals("Bada")) {
            //                JOptionPane.showMessageDialog(this, "Hệ điều hành không đúng định dạng.");
            //            } else if (manHinh.matches("^[a-zA-Z]{2,10}$")) {
            //                JOptionPane.showMessageDialog(this, "Màn hình không đúng định dạng.");
            //            } else if (pin.matches("^[a-zA-Z]{2,10}$")) {
            //                JOptionPane.showMessageDialog(this, "Pin không đúng định dạng.");
            //            }
            else {
                QLDienThoai QLDienThoai = listQLDienThoai.get(row);
                QLDienThoai.setMaDienThoai(ma);
                QLDienThoai.setTenDienThoai(ten);
                QLDienThoai.setSoLuongTon(0);
                QLDienThoai.setRAM(ram);
                QLDienThoai.setROM(rom);
                QLDienThoai.setCPU(cpu);
                QLDienThoai.setHeDieuHanh(hdh);
                QLDienThoai.setManHinh(manHinh);
                QLDienThoai.setCamera(camera);
                QLDienThoai.setPin(pin);
                QLDienThoai.setMauSac(mauSac);
                QLDienThoai.setGiaBan(giaBan);
                QLDienThoai.setThoiGianBaoHanh(baoHanh);
                if (QLDienThoai.getTrangThai() == 1) {
                    QLDienThoai.setTrangThai(0);
                } else {
                    QLDienThoai.setTrangThai(1);
                }
                QLDienThoai.setAnh(personalImage);
                QLDienThoai.setMota(moTa);
                QLDienThoai.setHang(tenHang);
                dienThoaiService.sua(QLDienThoai, idDienThoai);
                JOptionPane.showMessageDialog(this, "Đổi trạng thái thành công");
                showData(listQLDienThoai = dienThoaiService.getAll());
            }
        }
    }//GEN-LAST:event_btnDoiTrangThaiDienThoaiActionPerformed

    private void btnSuaDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaDTActionPerformed
        // TODO add your handling code here:
        int row = tblListDienThoai.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần sửa.");
        } else {
            UUID idDienThoai = listQLDienThoai.get(row).getIdDienThoai();
            String ma = txtMaDienThoai.getText();
            String ten = txtTenDienThoai.getText();
            String ram = txtRamDT.getText();
            String rom = txtRomDT.getText();
            String cpu = txtCPUDT.getText();
            String hdh = txtHeDieuHanhDT.getText();
            String manHinh = txtManHinhDT.getText();
            String camera = txtCameraDT.getText();
            String pin = txtPinDT.getText();
            String mauSac = txtMauSacDT.getText();
            Integer baoHanh = Integer.valueOf(txtBaoHanhDT.getText());
            Integer trangThai;
            if (cbbTrangThaiDT.getSelectedItem().equals("Đang Bán")) {
                trangThai = 1;
            } else {
                trangThai = 0;
            }
            String giaBan1 = txtGiaBanDienThoai.getText();
            BigDecimal giaBan = new BigDecimal(giaBan1);
            String moTa = txtMoTaDienThoai.getText();
            Hang tenHang = iHangService.getOne(cbbTenHangDT.getSelectedItem().toString());
            if (ten.isBlank() || ram.isBlank() || rom.isBlank() || cpu.isBlank() || hdh.isBlank() || manHinh.isBlank() || camera.isBlank() || pin.isBlank() || mauSac.isBlank() || String.valueOf(giaBan).isBlank() || moTa.isBlank()) {
                JOptionPane.showMessageDialog(this, "Các trường đang trống, vui lòng nhập đầy đủ!");
            } //            else if (ram.matches("^[0-9.0-9]{1,3}[GBgb|MBmb]{2}$")) {
            //                JOptionPane.showMessageDialog(this, "Ram không đúng định dạng. (số + GB hoặc MB)");
            //            } else if (rom.matches("^[0-9.0-9]{1,3}[GBgb|MBmb]{2}$")) {
            //                JOptionPane.showMessageDialog(this, "Rom không đúng định dạng. (số + GB hoặc MB)");
            //            } else if (cpu.matches("^[a-z A-Z 0-9]{6,50}$")) {
            //                JOptionPane.showMessageDialog(this, "CPU không đúng định dạng.");
            //            } else if (hdh.equals("Android") || hdh.equals("IOS") || hdh.equals("Windows Phone") || hdh.equals("Symbian") || hdh.equals("BlackBerry OS") || hdh.equals("Bada")) {
            //                JOptionPane.showMessageDialog(this, "Hệ điều hành không đúng định dạng.");
            //            } else if (manHinh.matches("^[a-zA-Z]{2,10}$")) {
            //                JOptionPane.showMessageDialog(this, "Màn hình không đúng định dạng.");
            //            } else if (pin.matches("^[a-zA-Z]{2,10}$")) {
            //                JOptionPane.showMessageDialog(this, "Pin không đúng định dạng.");
            //            }
            else {
                QLDienThoai QLDienThoai = listQLDienThoai.get(row);
                QLDienThoai.setMaDienThoai(ma);
                QLDienThoai.setTenDienThoai(ten);
                QLDienThoai.setSoLuongTon(0);
                QLDienThoai.setRAM(ram);
                QLDienThoai.setROM(rom);
                QLDienThoai.setCPU(cpu);
                QLDienThoai.setHeDieuHanh(hdh);
                QLDienThoai.setManHinh(manHinh);
                QLDienThoai.setCamera(camera);
                QLDienThoai.setPin(pin);
                QLDienThoai.setMauSac(mauSac);
                QLDienThoai.setGiaBan(giaBan);
                QLDienThoai.setThoiGianBaoHanh(baoHanh);
                QLDienThoai.setTrangThai(trangThai);
                QLDienThoai.setAnh(personalImage);
                QLDienThoai.setMota(moTa);
                QLDienThoai.setHang(tenHang);
                String add = dienThoaiService.sua(QLDienThoai, idDienThoai);
                JOptionPane.showMessageDialog(this, add);
                showData(listQLDienThoai = dienThoaiService.getAll());
            }
        }
    }//GEN-LAST:event_btnSuaDTActionPerformed

    private void btnThemDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDTActionPerformed
        // TODO add your handling code here:
        Hang tenHang = iHangService.getOne(cbbTenHangDT.getSelectedItem().toString());
        String ma = maDTTuTang();
        String ten = txtTenDienThoai.getText();
        String ram = txtRamDT.getText();
        String rom = txtRomDT.getText();
        String cpu = txtCPUDT.getText();
        String hdh = txtHeDieuHanhDT.getText();
        String manHinh = txtManHinhDT.getText();
        String camera = txtCameraDT.getText();
        String pin = txtPinDT.getText();
        String mauSac = txtMauSacDT.getText();
        Integer baoHanh = Integer.valueOf(txtBaoHanhDT.getText());
        Integer trangThai;
        if (cbbTrangThaiDT.getSelectedItem().equals("Dang Ban")) {
            trangThai = 1;
        } else {
            trangThai = 0;
        }
        String giaBan1 = txtGiaBanDienThoai.getText();
        BigDecimal giaBan = new BigDecimal(giaBan1);
        String moTa = txtMoTaDienThoai.getText();
        if (ten.isBlank() || ram.isBlank() || rom.isBlank() || cpu.isBlank() || hdh.isBlank() || manHinh.isBlank() || camera.isBlank() || pin.isBlank() || mauSac.isBlank() || String.valueOf(giaBan).isBlank() || moTa.isBlank()) {
            JOptionPane.showMessageDialog(this, "Các trường đang trống, vui lòng nhập đầy đủ!");
        } //        else if (ram.matches("^[0-9.0-9]{1,3}[GBgb|MBmb]{2}$")) {
        //            JOptionPane.showMessageDialog(this, "Ram không đúng định dạng. (số + GB hoặc MB)");
        //        } else if (rom.matches("^[0-9.0-9]{1,3}[GBgb|MBmb]{2}$")) {
        //            JOptionPane.showMessageDialog(this, "Rom không đúng định dạng. (số + GB hoặc MB)");
        //        } else if (cpu.matches("^[a-z A-Z 0-9]{6,50}$")) {
        //            JOptionPane.showMessageDialog(this, "CPU không đúng định dạng.");
        //        } else if (hdh.equals("Android") || hdh.equals("IOS") || hdh.equals("Windows Phone") || hdh.equals("Symbian") || hdh.equals("BlackBerry OS") || hdh.equals("Bada")) {
        //            JOptionPane.showMessageDialog(this, "Hệ điều hành không đúng định dạng.");
        //        } else if (manHinh.matches("^[a-zA-Z]{2,10}$")) {
        //            JOptionPane.showMessageDialog(this, "Màn hình không đúng định dạng.");
        //        } else if (pin.matches("^[a-zA-Z]{2,10}$")) {
        //            JOptionPane.showMessageDialog(this, "Pin không đúng định dạng.");
        //        }
        else {
            QLDienThoai qlDienThoai = new QLDienThoai();
            qlDienThoai.setMaDienThoai(ma);
            qlDienThoai.setTenDienThoai(ten);
            qlDienThoai.setSoLuongTon(0);
            qlDienThoai.setRAM(ram);
            qlDienThoai.setROM(rom);
            qlDienThoai.setCPU(cpu);
            qlDienThoai.setHeDieuHanh(hdh);
            qlDienThoai.setManHinh(manHinh);
            qlDienThoai.setCamera(camera);
            qlDienThoai.setPin(pin);
            qlDienThoai.setMauSac(mauSac);
            qlDienThoai.setGiaBan(giaBan);
            qlDienThoai.setThoiGianBaoHanh(baoHanh);
            qlDienThoai.setTrangThai(trangThai);
            qlDienThoai.setAnh(personalImage);
            qlDienThoai.setHang(tenHang);
            String add = dienThoaiService.them(qlDienThoai);
            JOptionPane.showMessageDialog(this, add);
            showData(listQLDienThoai = dienThoaiService.getAll());
        }
    }//GEN-LAST:event_btnThemDTActionPerformed

    private void btnTimKiemDienThoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemDienThoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTimKiemDienThoaiActionPerformed

    private void btnTaoMaQRDienThoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoMaQRDienThoaiActionPerformed
        // TODO add your handling code here:
        int row = tblListDienThoai.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn Điện thoại cần tạo mã.");
            return;
        }
        QLDienThoai qldt = listQLDienThoai.get(row);
        new MainDienThoai(qldt);
        JOptionPane.showMessageDialog(this, "Tạo mã thành công tại ổ đĩa D:");
    }//GEN-LAST:event_btnTaoMaQRDienThoaiActionPerformed

    private void rdoTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoTatCaActionPerformed
        // TODO add your handling code here:
        showData(listQLDienThoai = dienThoaiService.getAll());
    }//GEN-LAST:event_rdoTatCaActionPerformed

    private void rdoDangBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoDangBanActionPerformed
        // TODO add your handling code here:
        showData(listQLDienThoai = dienThoaiService.dtDangBan());
    }//GEN-LAST:event_rdoDangBanActionPerformed

    private void rdoNgungBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNgungBanActionPerformed
        // TODO add your handling code here:
        showData(listQLDienThoai = dienThoaiService.dtNgungBan());
    }//GEN-LAST:event_rdoNgungBanActionPerformed

    private void tblPhuKienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhuKienMouseClicked
        // TODO add your handling code here:
        int row = tblPhuKien.getSelectedRow();
        fillDataPK(row);
    }//GEN-LAST:event_tblPhuKienMouseClicked

    private void txtTimKiemPKCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemPKCaretUpdate
        // TODO add your handling code here:
        String ten = txtTimKiemPK.getText();
        listQLPhuKien = iPhuKienService.search(ten);
        showDataTablePK(listQLPhuKien);
    }//GEN-LAST:event_txtTimKiemPKCaretUpdate

    private void lblAnhPKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnhPKMouseClicked
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                } else {
                    return f.getName().toLowerCase().endsWith(".jpg");
                }
            }

            @Override
            public String getDescription() {
                return "Image File (*.jpg)";
            }
        });
        if (chooser.showOpenDialog(pnlDienThoai) == JFileChooser.CANCEL_OPTION) {
            return;
        }
        try {
            File file = chooser.getSelectedFile();
            ImageIcon icon = new ImageIcon(file.getPath());
            Image image = ImageHelper.resige(icon.getImage(), 186, 239);
            ImageIcon resizedIcon = new ImageIcon(image);
            lblAnhPK.setIcon(resizedIcon);
            personalImage = ImageHelper.toByteArray(image, "jpg");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_lblAnhPKMouseClicked

    private void btnThemPKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemPKActionPerformed
        // TODO add your handling code here:
        if (txtTenPK.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Tên phụ kiện không được để trống");
        } else if (txtGiaBanPK.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Giá bán không được để trống");
        } else if (txtMoTaPK.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Mô tả không được để trống");
        } else if (txtThoiGianBaoHanhPK.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Thời gian bảo hành không được để trống");
        } else {
            String ma = txtMaPK.getText();
            String ten = txtTenPK.getText();
            String giaBan = txtGiaBanPK.getText();
            BigDecimal giaBan1 = new BigDecimal(giaBan);
            int thoiGianBH = Integer.parseInt(txtThoiGianBaoHanhPK.getText());
            String moTa = txtMoTaPK.getText();
            int trangThai;
            if (cbbTrangThaiPK.getSelectedItem().equals("Đang bán")) {
                trangThai = 1;
            } else {
                trangThai = 0;
            }
            Hang hang = iHangService.getOne((String) cbbTenHangPK.getSelectedItem());
            QLPhuKien qLPhuKien = new QLPhuKien();
            qLPhuKien.setMa(maPK());
            qLPhuKien.setTen(ten);
            qLPhuKien.setSoLuong(0);
            qLPhuKien.setGiaBan(giaBan1);
            qLPhuKien.setThoiGianBaoHanh(thoiGianBH);
            qLPhuKien.setMoTa(moTa);
            qLPhuKien.setTrangThai(1);
            qLPhuKien.setAnh(personalImage);
            qLPhuKien.setHang(hang);
            String add = iPhuKienService.add(qLPhuKien);
            JOptionPane.showMessageDialog(this, add);
            listQLPhuKien = iPhuKienService.getAll();
            showDataTablePK(listQLPhuKien);
        }
    }//GEN-LAST:event_btnThemPKActionPerformed

    private void btnSuaPKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaPKActionPerformed
        // TODO add your handling code here:
        int row = tblPhuKien.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Xin chọn phụ kiến muốn update");
            return;
        }
        if (txtTenPK.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Tên phụ kiện không được để trống");
        } else if (txtGiaBanPK.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Giá bán không được để trống");
        } else if (txtMoTaPK.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Mô tả không được để trống");
        } else if (txtThoiGianBaoHanhPK.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Thời gian bảo hành không được để trống");
        } else {
            UUID id = listQLPhuKien.get(row).getId();
            String ma = txtMaPK.getText();
            String ten = txtTenPK.getText();
            String giaBan = txtGiaBanPK.getText();
            BigDecimal giaBan1 = new BigDecimal(giaBan);
            int thoiGianBH = Integer.parseInt(txtThoiGianBaoHanhPK.getText());
            String moTa = txtMoTaPK.getText();
            int trangThai;
            if (cbbTrangThaiPK.getSelectedItem().equals("Đang bán")) {
                trangThai = 1;
            } else {
                trangThai = 0;
            }
            Hang hang = iHangService.getOne((String) cbbTenHangPK.getSelectedItem());
            QLPhuKien qLPhuKien = listQLPhuKien.get(row);
            qLPhuKien.setMa(ma);
            qLPhuKien.setTen(ten);
            qLPhuKien.setSoLuong(0);
            qLPhuKien.setGiaBan(giaBan1);
            qLPhuKien.setThoiGianBaoHanh(thoiGianBH);
            qLPhuKien.setMoTa(moTa);
            qLPhuKien.setTrangThai(trangThai);
            qLPhuKien.setAnh(personalImage);
            qLPhuKien.setHang(hang);
            String update = iPhuKienService.update(qLPhuKien, id);
            JOptionPane.showMessageDialog(this, update);
            listQLPhuKien = iPhuKienService.getAll();
            showDataTablePK(listQLPhuKien);
        }
    }//GEN-LAST:event_btnSuaPKActionPerformed

    private void btnDoiTrangThaiPKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiTrangThaiPKActionPerformed
        // TODO add your handling code here:
        int row = tblPhuKien.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Xin chọn phụ kiến muốn update");
            return;
        }
        if (txtTenPK.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Tên phụ kiện không được để trống");
        } else if (txtGiaBanPK.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Giá bán không được để trống");
        } else if (txtMoTaPK.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Mô tả không được để trống");
        } else if (txtThoiGianBaoHanhPK.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Thời gian bảo hành không được để trống");
        } else {
            UUID id = listQLPhuKien.get(row).getId();
            String ma = txtMaPK.getText();
            String ten = txtTenPK.getText();
            String giaBan = txtGiaBanPK.getText();
            BigDecimal giaBan1 = new BigDecimal(giaBan);
            int thoiGianBH = Integer.parseInt(txtThoiGianBaoHanhPK.getText());
            String moTa = txtMoTaPK.getText();
            int trangThai;
            Hang hang = iHangService.getOne((String) cbbTenHangPK.getSelectedItem());
            QLPhuKien qLPhuKien = listQLPhuKien.get(row);
            qLPhuKien.setMa(ma);
            qLPhuKien.setTen(ten);
            qLPhuKien.setSoLuong(0);
            qLPhuKien.setGiaBan(giaBan1);
            qLPhuKien.setThoiGianBaoHanh(thoiGianBH);
            qLPhuKien.setMoTa(moTa);
            if (qLPhuKien.getTrangThai() == 1) {
                qLPhuKien.setTrangThai(0);
            } else {
                qLPhuKien.setTrangThai(1);
            }
            qLPhuKien.setAnh(personalImage);
            qLPhuKien.setHang(hang);
            String update = iPhuKienService.update(qLPhuKien, id);
            JOptionPane.showMessageDialog(this, "Đổi trạng thái thành công");
            listQLPhuKien = iPhuKienService.getAll();
            showDataTablePK(listQLPhuKien);
        }
    }//GEN-LAST:event_btnDoiTrangThaiPKActionPerformed

    private void btnClearPKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearPKActionPerformed
        // TODO add your handling code here:
        txtTenPK.setText("");
        txtGiaBanPK.setText("");
        txtSoLuongTonPK.setText("");
        txtMaPK.setText("");
        txtMoTaPK.setText("");
        txtThoiGianBaoHanhPK.setText("");
        cbbTrangThaiPK.setSelectedIndex(0);
        txtGiaNhapPK.setText("");
        cbbTenHangPK.setSelectedIndex(0);
        lblAnhPK.setIcon(null);
        cbbTenHangPK.setSelectedIndex(0);
    }//GEN-LAST:event_btnClearPKActionPerformed

    private void btnThemNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNVActionPerformed
        // TODO add your handling code here:
        if (txtEmailNV.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Email không được để trống");
        } else if (!txtEmailNV.getText().matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
            JOptionPane.showMessageDialog(this, "Email sai định dạng");
        } else if (txtSoDienThoaiNV.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống");
        } else if (!txtSoDienThoaiNV.getText().matches("^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại sai định dạng");
        } else {
            try {
                String ma = txtMaNV.getText();
                String hoTen = txtHovaTenNV.getText();
                int gioiTinh;
                if (radioNamNV.isSelected()) {
                    gioiTinh = 1;
                } else {
                    gioiTinh = 0;
                }
                int namSinh = Integer.parseInt(txtNamSinhNV.getText());
                String diaChi = txtDiaChiNV.getText();
                String cccd = txtCccdNV.getText();
                String email = txtEmailNV.getText();
                String sdt = txtSoDienThoaiNV.getText();
                int trangThai;
                if (cbbTrangThaiNV.getSelectedItem().equals("Đang làm việc")) {
                    trangThai = 1;
                } else {
                    trangThai = 0;
                }
                TaiKhoan taiKhoan = iTaiKhoanService.getOne(cbbTenTKNV.getSelectedItem().toString(), cbbMKNV.getSelectedItem().toString());
                domainmodel.ChucVu chucVu = iChucVuService.getOne(cbbChucVuNV.getSelectedItem().toString());
                QLNhanVien qLNhanVien = new QLNhanVien();
                qLNhanVien.setMa(ma);
                qLNhanVien.setHoTen(hoTen);
                qLNhanVien.setGioiTinh(gioiTinh);
                qLNhanVien.setNamSinh(namSinh);
                qLNhanVien.setDiaChi(diaChi);
                qLNhanVien.setCccd(cccd);
                qLNhanVien.setEmail(email);
                qLNhanVien.setSdt(sdt);
                qLNhanVien.setTrangThai(1);
                qLNhanVien.setAnh(personalImage);
                qLNhanVien.setTaiKhoan(taiKhoan);
                qLNhanVien.setChucVu(chucVu);
                String add = iNhanVienService.add(qLNhanVien);
                JOptionPane.showMessageDialog(this, add);
                listQLNhanVien = iNhanVienService.getAll();
                showDataTableNV(listQLNhanVien);
                emailSender.guiMail(txtEmailNV.getText(), "Thông tin tài khoản và mật khẩu", "<h2 style=\"color: red;\">\n"
                        + "Đây là tên tài khoản và mật khẩu để bạn đăng nhập vào phần mềm quản lý của hàng điện thoại. \n"
                        + "</h2><br>\"\n"
                        + " <h3>Tên tài khoản: " + cbbTenTKNV.getSelectedItem() + "</h3>"
                        + " <h3>Mật khẩu: " + cbbMKNV.getSelectedItem() + "</h3>");
                JOptionPane.showMessageDialog(this, "Thông tin tài khoản đã được gửi đến Email của bạn!");
            } catch (MessagingException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnThemNVActionPerformed

    private void btnSuaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaNVActionPerformed
        // TODO add your handling code here:
        int row = tblNhanVien.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Xin chọn nhân viên muốn update");
            return;
        }
        if (txtEmailNV.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Email không được để trống");
        } else if (!txtEmailNV.getText().matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
            JOptionPane.showMessageDialog(this, "Email sai định dạng");
        } else if (txtSoDienThoaiNV.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống");
        } else if (!txtSoDienThoaiNV.getText().matches("^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại sai định dạng");
        } else {
            UUID id = listQLNhanVien.get(row).getId();
            String ma = txtMaNV.getText();
            String hoTen = txtHovaTenNV.getText();
            int gioiTinh;
            if (radioNamNV.isSelected()) {
                gioiTinh = 1;
            } else {
                gioiTinh = 0;
            }
            int namSinh = Integer.parseInt(txtNamSinhNV.getText());
            String diaChi = txtDiaChiNV.getText();
            String cccd = txtCccdNV.getText();
            String email = txtEmailNV.getText();
            String sdt = txtSoDienThoaiNV.getText();
            int trangThai;
            if (cbbTrangThaiNV.getSelectedItem().equals("Đang làm việc")) {
                trangThai = 1;
            } else {
                trangThai = 0;
            }
            QLNhanVien qLNhanVien = listQLNhanVien.get(row);
            TaiKhoan taiKhoan = iTaiKhoanService.getOne(cbbTenTKNV.getSelectedItem().toString(), cbbMKNV.getSelectedItem().toString());
            domainmodel.ChucVu chucVu = iChucVuService.getOne(cbbChucVuNV.getSelectedItem().toString());
            qLNhanVien.setMa(ma);
            qLNhanVien.setHoTen(hoTen);
            qLNhanVien.setGioiTinh(gioiTinh);
            qLNhanVien.setNamSinh(namSinh);
            qLNhanVien.setDiaChi(diaChi);
            qLNhanVien.setCccd(cccd);
            qLNhanVien.setEmail(email);
            qLNhanVien.setSdt(sdt);
            qLNhanVien.setTrangThai(trangThai);
            qLNhanVien.setAnh(personalImage);
            qLNhanVien.setTaiKhoan(taiKhoan);
            qLNhanVien.setChucVu(chucVu);
            String update = iNhanVienService.update(qLNhanVien, id);
            JOptionPane.showMessageDialog(this, update);
            listQLNhanVien = iNhanVienService.getAll();
            showDataTableNV(listQLNhanVien);
        }
    }//GEN-LAST:event_btnSuaNVActionPerformed

    private void btnDoiTrangThaiNvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiTrangThaiNvActionPerformed
        // TODO add your handling code here:
        int row = tblNhanVien.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Xin chọn nhân viên muốn update");
            return;
        }
        if (txtEmailNV.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Email không được để trống");
        } else if (!txtEmailNV.getText().matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
            JOptionPane.showMessageDialog(this, "Email sai định dạng");
        } else if (txtSoDienThoaiNV.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống");
        } else if (!txtSoDienThoaiNV.getText().matches("^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại sai định dạng");
        } else {
            UUID id = listQLNhanVien.get(row).getId();
            String ma = txtMaNV.getText();
            String hoTen = txtHovaTenNV.getText();
            int gioiTinh;
            if (radioNamNV.isSelected()) {
                gioiTinh = 1;
            } else {
                gioiTinh = 0;
            }
            int namSinh = Integer.parseInt(txtNamSinhNV.getText());
            String diaChi = txtDiaChiNV.getText();
            String cccd = txtCccdNV.getText();
            String email = txtEmailNV.getText();
            String sdt = txtSoDienThoaiNV.getText();
            int trangThai;
            QLNhanVien qLNhanVien = listQLNhanVien.get(row);
            TaiKhoan taiKhoan = iTaiKhoanService.getOne(cbbTenTKNV.getSelectedItem().toString(), cbbMKNV.getSelectedItem().toString());
            domainmodel.ChucVu chucVu = iChucVuService.getOne(cbbChucVuNV.getSelectedItem().toString());
            qLNhanVien.setMa(ma);
            qLNhanVien.setHoTen(hoTen);
            qLNhanVien.setGioiTinh(gioiTinh);
            qLNhanVien.setNamSinh(namSinh);
            qLNhanVien.setDiaChi(diaChi);
            qLNhanVien.setCccd(cccd);
            qLNhanVien.setEmail(email);
            qLNhanVien.setSdt(sdt);
            if (qLNhanVien.getTrangThai() == 1) {
                qLNhanVien.setTrangThai(0);
            } else {
                qLNhanVien.setTrangThai(1);
            }
            qLNhanVien.setAnh(personalImage);
            qLNhanVien.setTaiKhoan(taiKhoan);
            qLNhanVien.setChucVu(chucVu);
            String update = iNhanVienService.update(qLNhanVien, id);
            JOptionPane.showMessageDialog(this, "Đổi trạng thái thành công");
            listQLNhanVien = iNhanVienService.getAll();
            showDataTableNV(listQLNhanVien);
        }
    }//GEN-LAST:event_btnDoiTrangThaiNvActionPerformed

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        // TODO add your handling code here:
        int row = tblNhanVien.getSelectedRow();
        fillDataNV(row);
    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void btnClearNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearNVActionPerformed
        // TODO add your handling code here:
        txtMaNV.setText("");
        txtHovaTenNV.setText("");
        buttonGroup1.clearSelection();
        txtNamSinhNV.setText("");
        txtDiaChiNV.setText("");
        txtCccdNV.setText("");
        txtEmailNV.setText("");
        txtSoDienThoaiNV.setText("");
        cbbChucVuNV.setSelectedIndex(0);
        cbbTrangThaiNV.setSelectedIndex(0);
        lblAnhNV.setIcon(null);
    }//GEN-LAST:event_btnClearNVActionPerformed

    private void lblAnhNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnhNVMouseClicked
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                } else {
                    return f.getName().toLowerCase().endsWith(".jpg");
                }
            }

            @Override
            public String getDescription() {
                return "Image File (*.jpg)";
            }
        });
        if (chooser.showOpenDialog(pnlDienThoai) == JFileChooser.CANCEL_OPTION) {
            return;
        }
        try {
            File file = chooser.getSelectedFile();
            ImageIcon icon = new ImageIcon(file.getPath());
            Image image = ImageHelper.resige(icon.getImage(), 186, 239);
            ImageIcon resizedIcon = new ImageIcon(image);
            lblAnhNV.setIcon(resizedIcon);
            personalImage = ImageHelper.toByteArray(image, "jpg");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_lblAnhNVMouseClicked

    private void btnQuetMaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuetMaNVActionPerformed
        // TODO add your handling code here:
        Menu m = new Menu();
        m.setVisible(true);
    }//GEN-LAST:event_btnQuetMaNVActionPerformed

    private void txtTimKiemNVCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemNVCaretUpdate
        // TODO add your handling code here:
        String cccd = txtTimKiemNV.getText();
        listQLNhanVien = iNhanVienService.search(cccd);
        showDataTableNV(listQLNhanVien);
    }//GEN-LAST:event_txtTimKiemNVCaretUpdate

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton29ActionPerformed

    private void tblListDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListDataMouseClicked
        // TODO add your handling code here:
        int row = tblListData.getSelectedRow();
        fillDataKH(row);
    }//GEN-LAST:event_tblListDataMouseClicked

    private void btnThemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseEntered
        // TODO add your handling code here:
        btnThem.setBackground(new Color(111, 140, 186));
    }//GEN-LAST:event_btnThemMouseEntered

    private void btnThemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseExited
        // TODO add your handling code here:
        btnThem.setBackground(new Color(71, 120, 197));
    }//GEN-LAST:event_btnThemMouseExited

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, khService.add(getDataKH()));
        listKH.clear();
        listKH = khService.getAll();
        showTableKH(listKH);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        int row = tblListData.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng để sửa");
        } else {
            UUID id = listKH.get(row).getId();
            JOptionPane.showMessageDialog(this, khService.update(getDataKH(), id));
            listKH.clear();
            listKH = khService.getAll();
            showTableKH(listKH);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int row = tblListData.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng để sửa");
        } else {
            UUID id = listKH.get(row).getId();
            JOptionPane.showMessageDialog(this, khService.delete(id));
            listKH.remove(row);
            listKH.clear();
            listKH = khService.getAll();
            showTableKH(listKH);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        txtHoVaTen.setText("");
        txtCCCD.setText("");
        txtHoVaTen.setText("");
        txtDiaChi.setText("");
        txtDiemTichLuy.setText("");
        txtEmail.setText("");
        datePKNgaySinh.setDate(new Date(System.currentTimeMillis()).toLocalDate());
        txtSDT.setText("");
        txtGhiChu.setText("");
        txtHoVaTen.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void txtCCCDerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCCCDerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCCCDerformed

    private void txtSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSearchCaretUpdate
        // TODO add your handling code here:
        String search = txtSearch.getText();
        listKH.clear();
        listKH = khService.search(search);
        showTableKH(listKH);
    }//GEN-LAST:event_txtSearchCaretUpdate

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void btnTaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoActionPerformed
        // TODO add your handling code here:
        int row = tblListData.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn Khách hàng cần tạo mã");
            return;
        }
        KhachHangViewMD kh = listKH.get(row);
        new MainKH(kh);
        JOptionPane.showMessageDialog(this, "Tạo mã Phụ Kiện thành công");
    }//GEN-LAST:event_btnTaoActionPerformed

    private void pnlSearchMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSearchMouseDragged
        // TODO add your handling code here:
        //source to drag
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_pnlSearchMouseDragged

    private void pnlSearchMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSearchMousePressed
        // TODO add your handling code here:
        //drag this pane
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_pnlSearchMousePressed

    private void pnlKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlKhachHangMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_pnlKhachHangMouseClicked

    private void txtTimKiemHoaDonCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemHoaDonCaretUpdate
        // TODO add your handling code here:
        //        String text = txtTimKiemHoaDon.getText().trim();
        //
        //        if (text.isEmpty()) {
        //            lstQLHD = IHoadonservice.getAll();
        //        }
        //        //lstQLHD = IHoadonservice.search(txtTimKiemHoaDon.getText().trim());
        //        FillFormHoaDon(text);
        //        System.out.println(text);
    }//GEN-LAST:event_txtTimKiemHoaDonCaretUpdate

    private void txtTimKiemHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemHoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemHoaDonActionPerformed

    private void txtTimKiemHoaDonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemHoaDonKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemHoaDonKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //        xuatExcel();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void pnlHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHoaDonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_pnlHoaDonMouseClicked

    private void tblKMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKMMouseClicked
        // TODO add your handling code here:
        int row = tblKM.getSelectedRow();
        showDetailKM(row);
    }//GEN-LAST:event_tblKMMouseClicked

    private void tblDienThoaiKMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDienThoaiKMMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDienThoaiKMMouseClicked

    private void cbSelectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSelectAllActionPerformed
        // TODO add your handling code here:
        //        tblPKKM.selectAll();
        for (int i = 0; i < listQLDienThoai.size(); i++) {
            tblDienThoaiKM.setValueAt(true, i, 3);
        }
    }//GEN-LAST:event_cbSelectAllActionPerformed

    private void cbClearAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbClearAllActionPerformed
        // TODO add your handling code here:
        //        tblPKKM.clearSelection();
        for (int i = 0; i < listQLDienThoai.size(); i++) {
            tblDienThoaiKM.setValueAt(false, i, 3);
        }
    }//GEN-LAST:event_cbClearAllActionPerformed

    private void showActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showActionPerformed
        // TODO add your handling code here:
        listQLDienThoai = dienThoaiService.getAll();
        showTableDTKM(listQLDienThoai);
    }//GEN-LAST:event_showActionPerformed

    private void tblHoaDonChiTietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonChiTietMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblHoaDonChiTietMouseClicked

    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
        // TODO add your handling code here:
        int rowHDCT = tblHoaDonChiTiet.getSelectedRow();
        if (rowHDCT == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn sản phẩm cần bỏ khỏi giỏ hàng");
            return;
        }
        int rowHD = tblHoaDon.getSelectedRow();
        String maHD = tblHoaDon.getValueAt(rowHD, 0).toString();
        HoaDon hoaDon = hoaDonRepo.getOne(maHD);
        if (hoaDon.getTrangThai() != 0) {
            JOptionPane.showMessageDialog(this, "Chỉ có hoá đơn chưa thanh toán mới được xoá sản phẩm");
            return;
        }
        Object o = tblHoaDonChiTiet.getValueAt(rowHDCT, 0);
        //        if (o instanceof DienThoai) {
        //            DienThoai dt = (DienThoai) o;
        //            HoaDonChiTiet hdct = hoaDonChiTietRepo.getAllDT(hoaDon.getMaHD(), dt.getMaDienThoai());
        //            hoaDonChiTietRepo.delete(hdct);
        //        } else {
        //            PhuKien phuKien = (PhuKien) o;
        //            HoaDonChiTiet hdct = hoaDonChiTietRepo.getAllPK(hoaDon.getMaHD(), phuKien.getMa());
        //            hoaDonChiTietRepo.delete(hdct);
        //        }
        hoaDonChiTietRepo.delete((HoaDonChiTiet) o);
        fillToHDCT(maHD);
    }//GEN-LAST:event_jButton40ActionPerformed

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton41ActionPerformed

    private void jButton42MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton42MouseClicked
        // TODO add your handling code here:
        //         new QuetMa().show();
    }//GEN-LAST:event_jButton42MouseClicked

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
        // TODO add your handling code here:
        //        JOptionPane.showMessageDialog(this, valuesSL);
        HoaDon hd;
        int row = tblHoaDon.getSelectedRow();
        hd = HoaDonRepository.getOne(tblHoaDon.getValueAt(row, 0).toString());
        new MaQR(hd).setVisible(true);
    }//GEN-LAST:event_jButton42ActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        // TODO add your handling code here:
        int row = tblHoaDon.getSelectedRow();
        String maHD = tblHoaDon.getValueAt(row, 0).toString();
        HoaDon hd = hoaDonRepo.getOne(maHD);
        String maNV = tblHoaDon.getValueAt(row, 1).toString();
        String date = hd.getNgayTao().toString();
        lblMaHD.setText(maHD);
        lblManV.setText(maNV);
        String text = String.format("%.0f", hoaDonChiTietRepo.sumMoney(maHD));
        txtTongTien.setText(text);
        lblNgayTao.setText(date);
        fillToHDCT(hd.getMaHD());
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void cboHoaDonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboHoaDonItemStateChanged
        // TODO add your handling code here:
        int index = cboHoaDon.getSelectedIndex() + 1;
        fillToHoaDon(hoaDonRepo.getHoaDons(index));
    }//GEN-LAST:event_cboHoaDonItemStateChanged

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
        // TODO add your handling code here:
        String maHD = "HD" + (tblHoaDon.getRowCount() + 1);
        String maNV = "F8196D15-FAC4-4945-BA20-EDC29534D46A";
        LocalDateTime dateTime = LocalDateTime.now();
        HoaDon hoaDon = new HoaDon(null, maHD, dateTime, null, 0, 0, null, null, null);
        hoaDonRepo.SaveOrUpdate(hoaDon);
        fillToHoaDon(hoaDonRepo.getAll());
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void btnHuyHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyHoaDonActionPerformed
        // TODO add your handling code here:

        int row = tblHoaDon.getSelectedRow();
        //        HoaDon hd = hoaDonRepo.getOne(maHD);
        //        JOptionPane.showMessageDialog(this, hd+maHD);
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn hoá đơn cần huỷ");
        }
        String trangThai = tblHoaDon.getValueAt(row, 4).toString();
        if (trangThai.equals("Chờ thanh toán")) {
            String maHD = tblHoaDon.getValueAt(row, 0).toString();
            HoaDon hd = hoaDonRepo.getOne(maHD);
            hd.setTrangThai(2);
            hoaDonRepo.SaveOrUpdate(hd);
            fillToHoaDon(hoaDonRepo.getAll());
            JOptionPane.showMessageDialog(this, "Huỷ hoá đơn thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Hoá đơn chờ thanh toán mới được huỷ");
        }
    }//GEN-LAST:event_btnHuyHoaDonActionPerformed

    private void cboLocSanPhamItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboLocSanPhamItemStateChanged
        // TODO add your handling code here:
        pnlSanPham.removeAll();
        pnlSanPham.updateUI();
        int index = cboLocSanPham.getSelectedIndex();
        if (index == 0) {
            addPanelDienThoai();
            addPanelPhuKien();
        } else if (index == 1) {
            addPanelDienThoai();
        } else {
            addPanelPhuKien();
        }
    }//GEN-LAST:event_cboLocSanPhamItemStateChanged

    private void btnLayThongTinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLayThongTinActionPerformed
        // TODO add your handling code here:
        new ViewKhachHang().setVisible(true);
    }//GEN-LAST:event_btnLayThongTinActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
        int row = tblHoaDon.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn hoá đơn cần thanh toán");
            return;
        }
        int check = JOptionPane.showConfirmDialog(this, "Xác nhận thanh toán", "Thanh toán hoá đơn", JOptionPane.YES_NO_OPTION);
        if (check != JOptionPane.YES_OPTION) {
            return;
        }
        String maHd = tblHoaDon.getValueAt(row, 0).toString();
        HoaDon hd = hoaDonRepo.getOne(maHd);
        List<HoaDonChiTiet> hdct = HoaDonChiTietRepository.getAll(maHd);
        if (hdct.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa thêm sản phẩm cần thanh toán");
        } else {
            JOptionPane.showMessageDialog(this, "Thanh toán thành công");
            if (chkDiemTichLuy.isSelected()) {
                hd.setDiemTichLuy(Integer.parseInt(txtDiem.getText()));
                KhachHangRepository kh = new KhachHangRepository();
                khachHangMua.setDiemTichLuy(0);
                kh.update(khachHangMua, khachHangMua.getId());
            }
            hd.setList(hdct);
            hd.setTrangThai(1);
            hd.setKhachHang(khachHangMua);
            hoaDonRepo.SaveOrUpdate(hd);
            fillToHoaDon(hoaDonRepo.getAll());
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void txtTienKhachDuaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachDuaKeyPressed
        // TODO add your handling code here:
        String tienKhachDuaStr = null;
        if (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
            try {
                tienKhachDuaStr = txtTienKhachDua.getText().trim().substring(0, txtTienKhachDua.getText().length() - 1);
            } catch (Exception e) {
                System.out.println("hi");
            }
            if (tienKhachDuaStr.isEmpty()) {
                txtTienTraKhach.setText("");
                return;
            }
        } else {
            tienKhachDuaStr = txtTienKhachDua.getText() + evt.getKeyChar();
        }
        String tongTienStr = txtTongTien.getText();
        if (tongTienStr.isEmpty()) {
            tongTienStr = "0";
        }
        Integer tongTien = Integer.parseInt(tongTienStr);
        Integer tienKhachDua = Integer.parseInt(tienKhachDuaStr);
        Integer tienTra = tienKhachDua - tongTien;
        txtTienTraKhach.setText(String.valueOf(tienTra));
    }//GEN-LAST:event_txtTienKhachDuaKeyPressed

    private void btn_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_1MouseClicked
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) pnlTong.getLayout();
        layout.show(pnlTong, "cardMain");
        //        setButtonClick(btn_1);
    }//GEN-LAST:event_btn_1MouseClicked

    private void btn_1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_1MouseEntered
        // TODO add your handling code here:
        btn_1.setBackground(new Color(40, 57, 80));
        btn_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btn_1MouseEntered

    private void btn_1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_1MouseExited
        // TODO add your handling code here:
        btn_1.setBackground(new Color(23, 35, 51));
    }//GEN-LAST:event_btn_1MouseExited

    private void btn_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_2MouseClicked
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) pnlTong.getLayout();
        layout.show(pnlTong, "cardBanHang");;
    }//GEN-LAST:event_btn_2MouseClicked

    private void btn_2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_2MouseEntered
        // TODO add your handling code here:
        btn_2.setBackground(new Color(40, 57, 80));
        btn_2.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btn_2MouseEntered

    private void btn_2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_2MouseExited
        // TODO add your handling code here:
        btn_2.setBackground(new Color(23, 35, 51));
    }//GEN-LAST:event_btn_2MouseExited

    private void btn_3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_3MouseClicked
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) pnlTong.getLayout();
        layout.show(pnlTong, "cardDienThoai");;
    }//GEN-LAST:event_btn_3MouseClicked

    private void btn_3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_3MouseEntered
        // TODO add your handling code here:
        btn_3.setBackground(new Color(40, 57, 80));
        btn_3.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btn_3MouseEntered

    private void btn_3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_3MouseExited
        // TODO add your handling code here:
        btn_3.setBackground(new Color(23, 35, 51));
    }//GEN-LAST:event_btn_3MouseExited

    private void btn_4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_4MouseClicked
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) pnlTong.getLayout();
        layout.show(pnlTong, "cardPhuKien");;
    }//GEN-LAST:event_btn_4MouseClicked

    private void btn_4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_4MouseEntered
        // TODO add your handling code here:
        btn_4.setBackground(new Color(40, 57, 80));
        btn_4.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btn_4MouseEntered

    private void btn_4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_4MouseExited
        // TODO add your handling code here:
        btn_4.setBackground(new Color(23, 35, 51));
    }//GEN-LAST:event_btn_4MouseExited

    private void btn_5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_5MouseClicked
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) pnlTong.getLayout();
        layout.show(pnlTong, "cardHoaDon");
    }//GEN-LAST:event_btn_5MouseClicked

    private void btn_5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_5MouseEntered
        // TODO add your handling code here:
        btn_5.setBackground(new Color(40, 57, 80));
        btn_5.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btn_5MouseEntered

    private void btn_5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_5MouseExited
        // TODO add your handling code here:
        btn_5.setBackground(new Color(23, 35, 51));
    }//GEN-LAST:event_btn_5MouseExited

    private void btn_6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_6MouseClicked
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) pnlTong.getLayout();
        layout.show(pnlTong, "cardNCC");;
    }//GEN-LAST:event_btn_6MouseClicked

    private void btn_6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_6MouseEntered
        // TODO add your handling code here:
        btn_6.setBackground(new Color(40, 57, 80));
        btn_6.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btn_6MouseEntered

    private void btn_6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_6MouseExited
        // TODO add your handling code here:
        btn_6.setBackground(new Color(23, 35, 51));
    }//GEN-LAST:event_btn_6MouseExited

    private void btn_7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_7MouseClicked
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) pnlTong.getLayout();
        layout.show(pnlTong, "cardKhuyenMai");
    }//GEN-LAST:event_btn_7MouseClicked

    private void btn_7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_7MouseEntered
        // TODO add your handling code here:
        btn_7.setBackground(new Color(40, 57, 80));
        btn_7.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btn_7MouseEntered

    private void btn_7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_7MouseExited
        // TODO add your handling code here:
        btn_7.setBackground(new Color(23, 35, 51));
    }//GEN-LAST:event_btn_7MouseExited

    private void btn_8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_8MouseClicked
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) pnlTong.getLayout();
        layout.show(pnlTong, "cardNhanVien");
    }//GEN-LAST:event_btn_8MouseClicked

    private void btn_8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_8MouseEntered
        // TODO add your handling code here:
        btn_8.setBackground(new Color(40, 57, 80));
        btn_8.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btn_8MouseEntered

    private void btn_8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_8MouseExited
        // TODO add your handling code here:
        btn_8.setBackground(new Color(23, 35, 51));
    }//GEN-LAST:event_btn_8MouseExited

    private void btn_9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_9MouseClicked
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) pnlTong.getLayout();
        layout.show(pnlTong, "cardThongKe");;
    }//GEN-LAST:event_btn_9MouseClicked

    private void btn_9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_9MouseEntered
        // TODO add your handling code here:
        btn_9.setBackground(new Color(40, 57, 80));
        btn_9.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btn_9MouseEntered

    private void btn_9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_9MouseExited
        // TODO add your handling code here:
        btn_9.setBackground(new Color(23, 35, 51));
    }//GEN-LAST:event_btn_9MouseExited

    private void btn_10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_10MouseClicked
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) pnlTong.getLayout();
        layout.show(pnlTong, "cardKhachHang");
    }//GEN-LAST:event_btn_10MouseClicked

    private void btn_10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_10MouseEntered
        // TODO add your handling code here:
        btn_10.setBackground(new Color(40, 57, 80));
        btn_10.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btn_10MouseEntered

    private void btn_10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_10MouseExited
        // TODO add your handling code here:
        btn_10.setBackground(new Color(23, 35, 51));
    }//GEN-LAST:event_btn_10MouseExited

    private void btn_exitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_exitMousePressed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btn_exitMousePressed

    private void btn_11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_11MouseClicked
        // TODO add your handling code here:
        int cancel = JOptionPane.showConfirmDialog(this, "Bạn có muốn đăng xuất phần mềm không?", null, JOptionPane.YES_NO_OPTION);
        if (cancel == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btn_11MouseClicked

    private void btn_11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_11MouseEntered
        // TODO add your handling code here:
        btn_11.setBackground(new Color(40, 57, 80));
        btn_11.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btn_11MouseEntered

    private void btn_11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_11MouseExited
        // TODO add your handling code here:
        btn_11.setBackground(new Color(23, 35, 51));
    }//GEN-LAST:event_btn_11MouseExited

    private void tbNccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNccMouseClicked
        row = tbNcc.getSelectedRow();
        fillData(row);
    }//GEN-LAST:event_tbNccMouseClicked
    private void fillData(int row) {
        QLNhaCungCap selectNcc = listNcc.get(row);
        txtMaNcc.setText(selectNcc.getMa());
        txtTenNcc.setText(selectNcc.getTen());
        txtDiaChiNcc.setText(selectNcc.getDiaChi());
        txtEmailNcc.setText(selectNcc.getEmail());
        txtSdtNcc.setText(selectNcc.getSdt());
    }

    private void btnThemNccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNccActionPerformed
        QLNhaCungCap newNcc = new QLNhaCungCap();
        if (txtMaNcc.getText().isEmpty() || txtTenNcc.getText().isEmpty() || txtDiaChiNcc.getText().isEmpty() || txtEmailNcc.getText().isEmpty() || txtSdtNcc.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được bỏ trống dữ liệu");
            return;
        }

        if (!txtEmailNcc.getText().matches("^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@"
                + "[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$")) {
            JOptionPane.showMessageDialog(this, "Sai định dạng email");
            return;
        }

        if (!txtSdtNcc.getText().matches("^(0|84)(2(0[3-9]|1[0-6|8|9]|2[0-2|5-9]|3[2-9]|4[0-9]|5[1|2|4-9]|6[0-3|9]|7[0-7]|8[0-9]|9[0-4|6|7|9])|3[2-9]|5[5|6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])([0-9]{7})$")) {
            JOptionPane.showMessageDialog(this, "Sai định dạng điện thoại");
            return;
        }

        for (QLNhaCungCap qLNhaCungCap : iNhaCungCapService.getAll()) {
            if (qLNhaCungCap.getMa().equals(txtMaNcc.getText())) {
                JOptionPane.showMessageDialog(this, "Trùng Mã");
                return;
            }
        }

        for (QLNhaCungCap qLNhaCungCap : iNhaCungCapService.getAll()) {
            if (qLNhaCungCap.getTen().equals(txtTenNcc.getText())) {
                JOptionPane.showMessageDialog(this, "Trùng Tên");
                return;
            }
        }
        newNcc.setMa(txtMaNcc.getText());
        newNcc.setTen(txtTenNcc.getText());
        newNcc.setDiaChi(txtDiaChiNcc.getText());
        newNcc.setEmail(txtEmailNcc.getText());
        newNcc.setSdt(txtSdtNcc.getText());
        newNcc.setTrangThai(0);
        JOptionPane.showMessageDialog(this, nccService.save(newNcc));
        listNcc = nccService.getAll();
        showDataTable();
    }//GEN-LAST:event_btnThemNccActionPerformed

    private void btnSuaNccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaNccActionPerformed
        row = tbNcc.getSelectedRow();
        if (row <= -1) {
            JOptionPane.showMessageDialog(this, "Xin mời chọn để sửa");
            return;
        }
        QLNhaCungCap updateNcc = listNcc.get(row);
        if (txtMaNcc.getText().isEmpty() || txtTenNcc.getText().isEmpty() || txtDiaChiNcc.getText().isEmpty() || txtEmailNcc.getText().isEmpty() || txtSdtNcc.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được bỏ trống dữ liệu");
            return;
        }

        if (!txtEmailNcc.getText().matches("^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@"
                + "[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$")) {
            JOptionPane.showMessageDialog(this, "Sai định dạng email");
            return;
        }

        if (!txtSdtNcc.getText().matches("^(0|84)(2(0[3-9]|1[0-6|8|9]|2[0-2|5-9]|3[2-9]|4[0-9]|5[1|2|4-9]|6[0-3|9]|7[0-7]|8[0-9]|9[0-4|6|7|9])|3[2-9]|5[5|6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])([0-9]{7})$")) {
            JOptionPane.showMessageDialog(this, "Sai định dạng điện thoại");
            return;
        }
        for (QLNhaCungCap qLNhaCungCap : iNhaCungCapService.getAll()) {
            if (qLNhaCungCap.getMa().equals(txtMaNcc.getText())) {
                JOptionPane.showMessageDialog(this, "Trùng Mã");
                return;
            }
        }

        for (QLNhaCungCap qLNhaCungCap : iNhaCungCapService.getAll()) {
            if (qLNhaCungCap.getTen().equals(txtTenNcc.getText())) {
                JOptionPane.showMessageDialog(this, "Trùng Tên");
                return;
            }
        }
        updateNcc.setMa(txtMaNcc.getText());
        updateNcc.setTen(txtTenNcc.getText());
        updateNcc.setDiaChi(txtDiaChiNcc.getText());
        updateNcc.setEmail(txtEmailNcc.getText());
        updateNcc.setSdt(txtSdtNcc.getText());
        updateNcc.setTrangThai(0);
        JOptionPane.showMessageDialog(this, nccService.update(updateNcc));
        listNcc = nccService.getAll();
        showDataTable();
    }//GEN-LAST:event_btnSuaNccActionPerformed

    private void btnXoaNccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaNccActionPerformed
        row = tbNcc.getSelectedRow();
        QLNhaCungCap doiTrangThaiNcc = listNcc.get(row);
        doiTrangThaiNcc.setTrangThai(1);
        JOptionPane.showMessageDialog(this, nccService.update(doiTrangThaiNcc));
        listNcc = nccService.getAll();
        showDataTable();
    }//GEN-LAST:event_btnXoaNccActionPerformed

    private void btnKhoiPhucNccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhoiPhucNccActionPerformed
        row = tbNcc.getSelectedRow();
        QLNhaCungCap doiTrangThaiNcc = listNcc.get(row);
        doiTrangThaiNcc.setTrangThai(0);
        JOptionPane.showMessageDialog(this, nccService.update(doiTrangThaiNcc));
        listNcc = nccService.getAll();
        showDataTable();
    }//GEN-LAST:event_btnKhoiPhucNccActionPerformed

    private void txtTimPkCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimPkCaretUpdate
        String ten = txtTimPk.getText();
        listPhuKien = phuKienService.search(ten);
        showDataTable();
    }//GEN-LAST:event_txtTimPkCaretUpdate

    private void txtTimPkKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimPkKeyReleased
        String ten = txtTimPk.getText();
        listPhuKien = phuKienService.search(ten);
        showDataTable();
    }//GEN-LAST:event_txtTimPkKeyReleased

    private void txtTimNccPkKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimNccPkKeyReleased
        String ma = txtTimNccPk.getText();
        listNcc = nccService.timKiem(ma);
        showDataTable();
    }//GEN-LAST:event_txtTimNccPkKeyReleased

    private void btnThemPKNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemPKNCCActionPerformed
        int rowTbNcc = tbChonNCCPK.getSelectedRow();
        int rowTbPk = tbChonPK.getSelectedRow();

        if (rowTbNcc <= -1 || rowTbPk <= -1) {
            JOptionPane.showMessageDialog(this, "Xin mời chọn để thêm");
            return;
        }
        QLNhaCungCap newNcc = listNcc.get(rowTbNcc);
        QLPhuKien newPk = listPhuKien.get(rowTbPk);
        NhapPKNCC newView = new NhapPKNCC(this, true, newPk, newNcc, dtmPhuKienNcc, null, listPKNCC);
        newView.setVisible(true);
    }//GEN-LAST:event_btnThemPKNCCActionPerformed

    private void btnSuaPKNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaPKNCCActionPerformed
        int rowTbPkNcc = tbPKNCC.getSelectedRow();
        QLPhuKienNCC PkNcc = listPKNCC.get(rowTbPkNcc);
        if (rowTbPkNcc <= -1) {
            JOptionPane.showMessageDialog(this, "Xin mời chọn để thêm");
            return;
        }
        NhapPKNCC newView = new NhapPKNCC(this, true, null, null, dtmPhuKienNcc, PkNcc, listPKNCC);
        newView.setVisible(true);
    }//GEN-LAST:event_btnSuaPKNCCActionPerformed

    private void btnNhapPKNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapPKNCCActionPerformed
        for (QLPhuKienNCC pkNcc : listPKNCC) {
            if (pkNcc.getId() == null) {
                JOptionPane.showMessageDialog(this, phuKienNCCService.save(pkNcc));
            }
        }

    }//GEN-LAST:event_btnNhapPKNCCActionPerformed

    private void txtTimDtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimDtKeyReleased
        //       String ma = txtTimDt.getText();
        //
        //       listDt = dienThoaiService.timKiem(ma);
        //       showDataTable();
    }//GEN-LAST:event_txtTimDtKeyReleased

    private void txtTimNccDtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimNccDtKeyReleased
        String ma = txtTimNccDt.getText();
        listNcc = nccService.timKiem(ma);
        showDataTable();
    }//GEN-LAST:event_txtTimNccDtKeyReleased

    private void btnthemDTNCC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemDTNCC1ActionPerformed
        int rowTbNcc = tbChonNccDt.getSelectedRow();
        int rowtbdt = tbChonDt.getSelectedRow();
        QLNhaCungCap newNcc = listNcc.get(rowTbNcc);
        QLDienThoai newDt = listDt.get(rowtbdt);
        NhapDTNCC newView = new NhapDTNCC(this, true, newDt, newNcc, dtmDtNcc, null, listDTNCC);
        newView.setVisible(true);
    }//GEN-LAST:event_btnthemDTNCC1ActionPerformed

    private void btnSuaDTNCC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaDTNCC1ActionPerformed
        int rowTbDtNcc = tbDTNCC.getSelectedRow();
        QLDTNhaCungCap DtNcc = listDTNCC.get(rowTbDtNcc);
        NhapDTNCC newView = new NhapDTNCC(this, true, null, null, dtmDtNcc, DtNcc, listDTNCC);
        newView.setVisible(true);
    }//GEN-LAST:event_btnSuaDTNCC1ActionPerformed

    private void btnNhapDTNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapDTNCCActionPerformed
        for (QLDTNhaCungCap dtNcc : listDTNCC) {
            if (dtNcc.getId() == null) {
                JOptionPane.showMessageDialog(this, dtNccService.save(dtNcc));
            }
        }
    }//GEN-LAST:event_btnNhapDTNCCActionPerformed

    private void btnTaoMaPKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoMaPKActionPerformed
        // TODO add your handling code here:
        int row = tblPhuKien.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn phụ kiện cần tạo mã");
            return;
        }
        QLPhuKien pk = listQLPhuKien.get(row);
        new Main(pk);
        JOptionPane.showMessageDialog(this, "Tạo mã Phụ Kiện thành công");
    }//GEN-LAST:event_btnTaoMaPKActionPerformed

    private void radioDangBanPKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDangBanPKActionPerformed
        // TODO add your handling code here:
        listQLPhuKien = iPhuKienService.getPKDB();
        showDataTablePK(listQLPhuKien);
    }//GEN-LAST:event_radioDangBanPKActionPerformed

    private void radioNgungBanPKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNgungBanPKActionPerformed
        // TODO add your handling code here:
        listQLPhuKien = iPhuKienService.getPKNB();
        showDataTablePK(listQLPhuKien);
    }//GEN-LAST:event_radioNgungBanPKActionPerformed

    private void radioTatCaPKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioTatCaPKActionPerformed
        // TODO add your handling code here:
        listQLPhuKien = iPhuKienService.getAll();
        showDataTablePK(listQLPhuKien);
    }//GEN-LAST:event_radioTatCaPKActionPerformed

    private void radioDangLamViecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDangLamViecActionPerformed
        // TODO add your handling code here:
        listQLNhanVien = iNhanVienService.getNVDLV();
        showDataTableNV(listQLNhanVien);
    }//GEN-LAST:event_radioDangLamViecActionPerformed

    private void radioDaNghiViecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDaNghiViecActionPerformed
        // TODO add your handling code here:
        listQLNhanVien = iNhanVienService.getNVDNV();
        showDataTableNV(listQLNhanVien);
    }//GEN-LAST:event_radioDaNghiViecActionPerformed

    private void radioTatCaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioTatCaNVActionPerformed
        // TODO add your handling code here:
        listQLNhanVien = iNhanVienService.getAll();
        showDataTableNV(listQLNhanVien);
    }//GEN-LAST:event_radioTatCaNVActionPerformed

    private void txtTimKiemDienThoaiCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemDienThoaiCaretUpdate
        // TODO add your handling code here:
        String timKiemMaDienThoai = txtTimKiemDienThoai.getText();
        String timKiemTenDienThoai = txtTimKiemDienThoai.getText();
        List<QLDienThoai> listTimKiemDT = dienThoaiService.timKiem(timKiemMaDienThoai, timKiemTenDienThoai);
        showData(listTimKiemDT);
    }//GEN-LAST:event_txtTimKiemDienThoaiCaretUpdate

    private void btnThemKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKMActionPerformed
        // TODO add your handling code here:
        String maKM = "KM0" + (GenMa.getMaKM() + 1);
        String tenKm = GenMa.getValues(txtTenKM);
        int hinhThuc = cbbHTKM.getSelectedIndex();
        String mucGiamGia = txtMucGG.getText().trim();
        java.util.Date ngayBD = getDate(dPNgayBD.getDate());
        java.util.Date ngayKT = getDate(dPNgayKT.getDate());
        String moTa = txtMoTaKM.getText().trim();
        KhuyenMai km = new KhuyenMai(null, maKM, tenKm, BigDecimal.valueOf(Double.valueOf(mucGiamGia)), hinhThuc, ngayBD, ngayKT, 1, moTa);
        ChiTietKhuyenMaiRepository.SaveOrUpdate(km);
        showTableKM();
        JOptionPane.showMessageDialog(this, "Thêm thành công");
    }//GEN-LAST:event_btnThemKMActionPerformed

    private void btnSuaKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaKMActionPerformed
        int row = tblKM.getSelectedRow();
        KhuyenMai z = (KhuyenMai) tblKM.getValueAt(row, 0);
        String tenKm = GenMa.getValues(txtTenKM);
        int hinhThuc = cbbHTKM.getSelectedIndex();
        String mucGiamGia = txtMucGG.getText().trim();
        java.util.Date ngayBD = getDate(dPNgayBD.getDate());
        java.util.Date ngayKT = getDate(dPNgayKT.getDate());
        String moTa = txtMoTaKM.getText().trim();
        KhuyenMai km = new KhuyenMai(z.getId(), z.getMaKM(), tenKm, BigDecimal.valueOf(Double.valueOf(mucGiamGia)), hinhThuc, ngayBD, ngayKT, 1, moTa);
        ChiTietKhuyenMaiRepository.SaveOrUpdate(km);
        showTableKM();
        JOptionPane.showMessageDialog(this, "Sửa thành công");
    }//GEN-LAST:event_btnSuaKMActionPerformed

    private void txtSearchKMCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSearchKMCaretUpdate
        // TODO add your handling code here:
        String timKiem = txtSearchKM.getText().trim();
        showTableKM(ChiTietKhuyenMaiRepository.getAll(timKiem), "hi");
    }//GEN-LAST:event_txtSearchKMCaretUpdate

    private void cboLocItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboLocItemStateChanged
        // TODO add your handling code here:
        int index = cboLoc.getSelectedIndex();
        String dau;
        if (index == 1) {
            dau = ">";
        } else if (index == 2) {
            dau = "<";
        } else {
            showTableKM();
            return;
        }
        showTableKM(ChiTietKhuyenMaiRepository.Loc(dau), "");
    }//GEN-LAST:event_cboLocItemStateChanged

    java.util.Date getDate(LocalDate d) {
        java.util.Date date = Date.from(d.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return date;
    }

    void showDetailKM(int row) {
        KhuyenMai km = (KhuyenMai) tblKM.getValueAt(row, 0);
        txtMaKM.setText(km.getMaKM());
        txtTenKM.setText(km.getTenKM());
        txtMucGG.setText(String.valueOf(km.getMucKhuyenMai()));
        if (km.getHinhThucKhuyenMai() == 1) {
            cbbHTKM.setSelectedIndex(1);
        } else {
            cbbHTKM.setSelectedIndex(0);
        }
        txtMoTaKM.setText(km.getMoTa());
        dPNgayBD.setDate(convertToLocalDateViaMilisecond(km.getNgayBatDau()));
        dPNgayKT.setDate(convertToLocalDateViaMilisecond(km.getNgayKT()));
    }

    public LocalDate convertToLocalDateViaMilisecond(java.util.Date dateToConvert) {
        return Instant.ofEpochMilli(dateToConvert.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
//Hết code cua dung    
//Hết Code của Vanh
//    void get(){
//        if (!txtEmailNcc.getText().matches("^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@"
//                + "[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$")) {
//            JOptionPane.showMessageDialog(this, "Sai định dạng email");
//            return;
//        }
//
//        if (!txtSdtNcc.getText().matches("^(0|84)(2(0[3-9]|1[0-6|8|9]|2[0-2|5-9]|3[2-9]|4[0-9]|5[1|2|4-9]|6[0-3|9]|7[0-7]|8[0-9]|9[0-4|6|7|9])|3[2-9]|5[5|6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])([0-9]{7})$")) {
//            JOptionPane.showMessageDialog(this, "Sai định dạng điện thoại");
//            return;
//        }
//
//        for (QLNhaCungCap qLNhaCungCap : iNhaCungCapService.getAll()) {
//            if (qLNhaCungCap.getMa().equals(txtMaNcc.getText())) {
//                JOptionPane.showMessageDialog(this, "Trùng Mã");
//                return;
//            }
//        }
//
//        for (QLNhaCungCap qLNhaCungCap : iNhaCungCapService.getAll()) {
//            if (qLNhaCungCap.getTen().equals(txtTenNcc.getText())) {
//                JOptionPane.showMessageDialog(this, "Trùng Tên");
//                return;
//            }
//        }
//        newNcc.setMa(txtMaNcc.getText());
//        newNcc.setTen(txtTenNcc.getText());
//        newNcc.setDiaChi(txtDiaChiNcc.getText());
//        newNcc.setEmail(txtEmailNcc.getText());
//        newNcc.setSdt(txtSdtNcc.getText());
//        newNcc.setTrangThai(0);
//        JOptionPane.showMessageDialog(this, nccService.save(newNcc));
//        listNcc = nccService.getAll();
//        showDataTable();
//    }                                          
//    private void fillData(int row) {
//        QLNhaCungCap selectNcc = listNcc.get(row);
//        txtMaNcc.setText(selectNcc.getMa());
//        txtTenNcc.setText(selectNcc.getTen());
//        txtDiaChiNcc.setText(selectNcc.getDiaChi());
//        txtEmailNcc.setText(selectNcc.getEmail());
//        txtSdtNcc.setText(selectNcc.getSdt());
//    }

    private void showDataTable() {
        dtmNcc.setRowCount(0);
        dtmNccVc.setRowCount(0);
        dtmPhuKien.setRowCount(0);
        dtmPhuKienNcc.setRowCount(0);
        dtmChonDt.setRowCount(0);
        dtmChonNccDt.setRowCount(0);
        dtmDtNcc.setRowCount(0);
        for (QLNhaCungCap x : listNcc) {
            dtmNcc.addRow(new Object[]{x.getMa(), x.getTen(), x.getDiaChi(), x.getEmail(), x.getSdt(), x.convertTrangThai(x.getTrangThai())});
        }
        for (QLNhaCungCap x : listNcc) {
            dtmNccVc.addRow(new Object[]{x.getMa(), x.getTen(), x.convertTrangThai(x.getTrangThai())});
        }
        for (QLNhaCungCap x : listNcc) {
            dtmChonNccDt.addRow(new Object[]{x.getMa(), x.getTen(), x.convertTrangThai(x.getTrangThai())});
        }
        for (QLPhuKien x : listPhuKien) {
            dtmPhuKien.addRow(new Object[]{x.getMa(), x.getTen()});
        }
        for (QLPhuKienNCC x : listPKNCC) {
            dtmPhuKienNcc.addRow(new Object[]{x.getMaphuKien(), x.getManhaCungCap(), x.getSoLuongNhap(), x.getGiaNhap(), x.tongTien(x.getGiaNhap(), x.getSoLuongNhap())});
        }
        for (QLDienThoai x : listDt) {
            dtmChonDt.addRow(new Object[]{x.getMaDienThoai(), x.getTenDienThoai()});
        }
        for (QLDTNhaCungCap x : listDTNCC) {
            dtmDtNcc.addRow(new Object[]{x.getManhaCungCap(), x.getMadienThoai(), x.getSoLuongNhap(), x.getGiaNhap()});
        }
    }    //Hết Code của Vanh

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    private void setColor(JPanel pane) {
        pane.setBackground(new Color(41, 57, 80));
    }

    private void resetColor(JPanel[] pane, JPanel[] indicators) {
        for (int i = 0; i < pane.length; i++) {
            pane[i].setBackground(new Color(23, 35, 51));

        }
        for (int i = 0; i < indicators.length; i++) {
            indicators[i].setOpaque(false);
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClearNV;
    private javax.swing.JButton btnClearPK;
    private javax.swing.JButton btnDoiTrangThaiDienThoai;
    private javax.swing.JButton btnDoiTrangThaiNv;
    private javax.swing.JButton btnDoiTrangThaiPK;
    private javax.swing.JButton btnHuyHoaDon;
    private javax.swing.JButton btnKhoiPhucNcc;
    private javax.swing.JButton btnLamMoiDT;
    private javax.swing.JButton btnLayThongTin;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnNhapDTNCC;
    private javax.swing.JButton btnNhapPKNCC;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnQuetMaNV;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnSuaDT;
    private javax.swing.JButton btnSuaDTNCC1;
    private javax.swing.JButton btnSuaKM;
    private javax.swing.JButton btnSuaNV;
    private javax.swing.JButton btnSuaNcc;
    private javax.swing.JButton btnSuaPK;
    private javax.swing.JButton btnSuaPKNCC;
    private javax.swing.JButton btnTao;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnTaoMaPK;
    private javax.swing.JButton btnTaoMaQRDienThoai;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemDT;
    private javax.swing.JButton btnThemKM;
    private javax.swing.JButton btnThemNV;
    private javax.swing.JButton btnThemNcc;
    private javax.swing.JButton btnThemPK;
    private javax.swing.JButton btnThemPKNCC;
    private javax.swing.JButton btnTimKiemDienThoai;
    private javax.swing.JButton btnTrangSau;
    private javax.swing.JButton btnTrangTruoc;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaDTNCC1;
    private javax.swing.JButton btnXoaNcc;
    private javax.swing.JButton btnXoaPKNCC;
    private javax.swing.JPanel btn_1;
    private javax.swing.JPanel btn_10;
    private javax.swing.JPanel btn_11;
    private javax.swing.JPanel btn_12;
    private javax.swing.JPanel btn_13;
    private javax.swing.JPanel btn_14;
    private javax.swing.JPanel btn_15;
    private javax.swing.JPanel btn_16;
    private javax.swing.JPanel btn_17;
    private javax.swing.JPanel btn_18;
    private javax.swing.JPanel btn_19;
    private javax.swing.JPanel btn_2;
    private javax.swing.JPanel btn_20;
    private javax.swing.JPanel btn_21;
    private javax.swing.JPanel btn_3;
    private javax.swing.JPanel btn_4;
    private javax.swing.JPanel btn_5;
    private javax.swing.JPanel btn_6;
    private javax.swing.JPanel btn_7;
    private javax.swing.JPanel btn_8;
    private javax.swing.JPanel btn_9;
    private javax.swing.JLabel btn_exit;
    private javax.swing.JLabel btn_exit1;
    private javax.swing.JButton btnthemDTNCC1;
    private java.awt.Button button1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JCheckBox cbClearAll;
    private javax.swing.JCheckBox cbSelectAll;
    private javax.swing.JComboBox<String> cbbChucVuNV;
    private javax.swing.JComboBox<String> cbbDTNCC;
    private javax.swing.JComboBox<String> cbbHTKM;
    private javax.swing.JComboBox<String> cbbLocNcc;
    public static javax.swing.JComboBox<String> cbbMKNV;
    private javax.swing.JComboBox<String> cbbPKNCC;
    private javax.swing.JComboBox<String> cbbTenHangDT;
    private javax.swing.JComboBox<String> cbbTenHangPK;
    public static javax.swing.JComboBox<String> cbbTenTKNV;
    private javax.swing.JComboBox<String> cbbTrangThaiDT;
    private javax.swing.JComboBox<String> cbbTrangThaiNV;
    private javax.swing.JComboBox<String> cbbTrangThaiPK;
    private javax.swing.JComboBox<String> cboHoaDon;
    private javax.swing.JComboBox<String> cboLoc;
    private javax.swing.JComboBox<String> cboLocSanPham;
    private javax.swing.JCheckBox chkDiemTichLuy;
    private com.github.lgooddatepicker.components.DatePicker dPNgayBD;
    private com.github.lgooddatepicker.components.DatePicker dPNgayKT;
    private com.github.lgooddatepicker.components.DatePicker datePKNgaySinh;
    private javax.swing.JPanel ind_1;
    private javax.swing.JPanel ind_10;
    private javax.swing.JPanel ind_11;
    private javax.swing.JPanel ind_12;
    private javax.swing.JPanel ind_13;
    private javax.swing.JPanel ind_14;
    private javax.swing.JPanel ind_15;
    private javax.swing.JPanel ind_16;
    private javax.swing.JPanel ind_17;
    private javax.swing.JPanel ind_18;
    private javax.swing.JPanel ind_19;
    private javax.swing.JPanel ind_2;
    private javax.swing.JPanel ind_20;
    private javax.swing.JPanel ind_21;
    private javax.swing.JPanel ind_22;
    private javax.swing.JPanel ind_23;
    private javax.swing.JPanel ind_24;
    private javax.swing.JPanel ind_25;
    private javax.swing.JPanel ind_26;
    private javax.swing.JPanel ind_27;
    private javax.swing.JPanel ind_28;
    private javax.swing.JPanel ind_29;
    private javax.swing.JPanel ind_3;
    private javax.swing.JPanel ind_30;
    private javax.swing.JPanel ind_31;
    private javax.swing.JPanel ind_32;
    private javax.swing.JPanel ind_33;
    private javax.swing.JPanel ind_34;
    private javax.swing.JPanel ind_35;
    private javax.swing.JPanel ind_36;
    private javax.swing.JPanel ind_37;
    private javax.swing.JPanel ind_38;
    private javax.swing.JPanel ind_4;
    private javax.swing.JPanel ind_5;
    private javax.swing.JPanel ind_6;
    private javax.swing.JPanel ind_7;
    private javax.swing.JPanel ind_8;
    private javax.swing.JPanel ind_9;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox5;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextField jTextField100;
    private javax.swing.JTextField jTextField97;
    private javax.swing.JLabel lbAnhDT;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JLabel lblAnh1;
    private javax.swing.JLabel lblAnhNV;
    private javax.swing.JLabel lblAnhPK;
    private javax.swing.JLabel lblMaHD;
    private javax.swing.JLabel lblManV;
    private javax.swing.JLabel lblNgayTao;
    public static javax.swing.JLabel lblTenKhachHang;
    private javax.swing.JPanel pnlBanHang;
    private javax.swing.JPanel pnlDienThoai;
    private javax.swing.JPanel pnlHoaDon;
    private javax.swing.JPanel pnlKhachHang;
    private javax.swing.JPanel pnlKhuyenMai;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlMain1;
    private javax.swing.JPanel pnlNhaCungCap;
    private javax.swing.JPanel pnlNhanVien;
    private javax.swing.JPanel pnlPhuKien;
    private javax.swing.JPanel pnlSanPham;
    private javax.swing.JPanel pnlSearch;
    private javax.swing.JPanel pnlThongKe;
    private javax.swing.JPanel pnlTong;
    private javax.swing.JPanel pnlTong1;
    private javax.swing.JRadioButton radioDaNghiViec;
    private javax.swing.JRadioButton radioDangBanPK;
    private javax.swing.JRadioButton radioDangLamViec;
    public static javax.swing.JRadioButton radioNamNV;
    private javax.swing.JRadioButton radioNgungBanPK;
    public static javax.swing.JRadioButton radioNuNV;
    private javax.swing.JRadioButton radioTatCaNV;
    private javax.swing.JRadioButton radioTatCaPK;
    private javax.swing.JRadioButton rdoDangBan;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNgungBan;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JRadioButton rdoTatCa;
    private javax.swing.JScrollPane scpSanPhamBH;
    private javax.swing.JButton show;
    private javax.swing.JPanel side_pane;
    private javax.swing.JTable tbChonDt;
    private javax.swing.JTable tbChonNCCPK;
    private javax.swing.JTable tbChonNccDt;
    private javax.swing.JTable tbChonPK;
    private javax.swing.JTable tbDTNCC;
    private javax.swing.JTable tbNcc;
    private javax.swing.JTable tbPKNCC;
    private javax.swing.JTable tblDienThoaiKM;
    private static javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblHoaDonChiTiet;
    private javax.swing.JTable tblKM;
    private javax.swing.JTable tblListData;
    private javax.swing.JTable tblListDienThoai;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTable tblPKKM;
    private javax.swing.JTable tblPhuKien;
    private javax.swing.JTable tblThongKe;
    private javax.swing.JTable tblhdct;
    private javax.swing.JTable tblhoadon;
    private javax.swing.JTextField txtBaoHanhDT;
    private javax.swing.JTextField txtCCCD;
    private javax.swing.JTextField txtCPUDT;
    private javax.swing.JTextField txtCameraDT;
    public static javax.swing.JTextField txtCccdNV;
    private javax.swing.JTextField txtDiaChi;
    public static javax.swing.JTextArea txtDiaChiNV;
    private javax.swing.JTextField txtDiaChiNcc;
    public static javax.swing.JTextField txtDiem;
    private javax.swing.JTextField txtDiemTichLuy;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmailNV;
    private javax.swing.JTextField txtEmailNcc;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtGiaBanDienThoai;
    private javax.swing.JTextField txtGiaBanPK;
    private javax.swing.JTextField txtGiaNhapDienThoai;
    private javax.swing.JTextField txtGiaNhapPK;
    private javax.swing.JTextField txtHeDieuHanhDT;
    private javax.swing.JTextField txtHoVaTen;
    public static javax.swing.JTextField txtHovaTenNV;
    private javax.swing.JTextField txtMaDienThoai;
    private javax.swing.JTextField txtMaKM;
    public static javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMaNcc;
    private javax.swing.JTextField txtMaPK;
    private javax.swing.JTextField txtManHinhDT;
    private javax.swing.JTextField txtMauSacDT;
    private javax.swing.JTextArea txtMoTaDienThoai;
    private javax.swing.JTextArea txtMoTaKM;
    private javax.swing.JTextArea txtMoTaPK;
    private javax.swing.JTextField txtMucGG;
    public static javax.swing.JTextField txtNamSinhNV;
    private javax.swing.JTextField txtPinDT;
    private javax.swing.JTextField txtRamDT;
    private javax.swing.JTextField txtRomDT;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSdtNcc;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSearchKM;
    private javax.swing.JTextField txtSearchTenDT;
    private javax.swing.JTextField txtSearchTenPK;
    private javax.swing.JTextField txtSoDienThoaiNV;
    private javax.swing.JTextField txtSoLuongDienThoai;
    private javax.swing.JTextField txtSoLuongTonPK;
    private javax.swing.JTextField txtTenDienThoai;
    private javax.swing.JTextField txtTenKM;
    private javax.swing.JTextField txtTenNcc;
    private javax.swing.JTextField txtTenPK;
    private javax.swing.JTextField txtThoiGianBaoHanhPK;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTienTraKhach;
    private javax.swing.JTextField txtTimDt;
    private javax.swing.JTextField txtTimKiemDTNCC;
    private javax.swing.JTextField txtTimKiemDienThoai;
    private javax.swing.JTextField txtTimKiemHoaDon;
    private javax.swing.JTextField txtTimKiemNV;
    private javax.swing.JTextField txtTimKiemNcc;
    private javax.swing.JTextField txtTimKiemPK;
    private javax.swing.JTextField txtTimKiemPKNCC;
    private javax.swing.JTextField txtTimNccDt;
    private javax.swing.JTextField txtTimNccPk;
    private javax.swing.JTextField txtTimPk;
    public static javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
