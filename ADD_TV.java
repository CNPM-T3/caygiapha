/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package caygiapha;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ADT
 */
public class ADD_TV extends javax.swing.JInternalFrame {
        java.util.Date date = new java.util.Date();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal= Calendar.getInstance();
        DefaultTableModel model;
        boolean edit=true;
        boolean firt=false;
        int selectday=0;
        int groupmonth=1;
    /**
     * Creates new form ADD_TV_1
     */
    public ADD_TV() {
        initComponents();
        C_NamPS.setText(df.format(date));
        LoadDate();
        C_QuanHe.setEnabled(false);
        But_Them.setEnabled(false);
        Search_01();
        setVisible(true);
        
    }
    public ADD_TV(String ma){
        initComponents();
        C_NamPS.setText(df.format(date));
        LoadDate();
        Tx_MaTVC.setText(ma);
        Tx_MaTVC.setEditable(false);
        But_Tim.setEnabled(false);
        But_Tim.setEnabled(false);
        edit=false;
        Search(Tx_MaTVC.getText());
        setVisible(true);
    }
    
    private void Search_01(){
            try {
                String cmd="select * from TV where ID like '01%' and len(ID)=7";
                ResultSet re=SQL.getConnection().createStatement().executeQuery(cmd);
                if(re.isBeforeFirst());
                else {
                    Tx_MaTVC.setEditable(false);
                    But_Them.setEnabled(true);
                    C_QuanHe.setEnabled(false);
                    But_Tim.setEnabled(false);
                    edit=false;
                    firt=true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ADD_TV.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
    private void Search(String ma){
            try {
                String cmd ="select HVT,GT,NS from TV where ID = ?";
                PreparedStatement ps=SQL.getConnection().prepareStatement(cmd);
                ps.setString(1, ma);
                ResultSet re = ps.executeQuery();
                if(re.isBeforeFirst()){
                    re.next();
                    Tx_ThanhVienCu.setText(re.getString(1));
                    Txt_GT.setText(re.getString(2));
                    Txt_NS.setText(df.format(re.getDate(3)));
                    C_QuanHe.setEnabled(true);
                    But_Them.setEnabled(true);
                } else {
                    Tx_ThanhVienCu.setText("");
                    Txt_GT.setText("");
                    Txt_NS.setText("");
                    C_QuanHe.setEnabled(false);
                    But_Them.setEnabled(false);
                }
            } catch (SQLException ex) {
                Tx_ThanhVienCu.setText("");
                Txt_GT.setText("");
                Txt_NS.setText("");
                C_QuanHe.setEnabled(false);
                But_Them.setEnabled(false);
                Logger.getLogger(ADD_TV.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Không đụng vào">                   
    private String UP_ID(String ID){                   
        int i=ID.length()-1; //lấy vị trí của ký tự cuối cùng trong String
        char[] a=ID.toCharArray();  // chuyển đổi Sting thì mẳng char[] 1 chiều
        if(i==6){
                a[i]++; //đổi thành ký tự tiếp theo
            while(i>2){ //vòng lặp nâng ký tự
                if(a[i]==('9'+1))   //xet ksy tự lớn hơn '9'
                    a[i]='A';   //đổi ký tự đó thành 'A'
                else if(a[i]>'Z'){  // xét ký tự lớn hơn 'Z'
                    a[i]='0';       //đưa ký tự về '0'
                    a[i-1]++;       //năng tự ký tự phía trước thàng ký tự tiếp theo
                }
                i--;                //tiếp tục xét các ký tự trước đó
            }
        if(a[2]>'Z')    //xét ký tự thứ 2 trong mảng. Nếu lớn hơn 'Z'
            return null;    // Đúng: trả về null
        return new String(a);  //Sai: trả về chuỗi ký tự đã được nâng
        }
        a[7]++;         // Xét ký tự thứ 7. Phần này được thực hiện khi quan hệ là vợ hoặc chồng
        if(a[7]>'Z')
            return null;
        return new String(a);
    }

    private String Get_ID(){
        if(firt){
            Tx_MaTVC.setEditable(true);
            But_Them.setEnabled(false);
            But_Tim.setEnabled(true);
            edit=true;
            firt=false;
            return "01ABC01";
        }
        ResultSet res;
        PreparedStatement pre;
        if(C_QuanHe.getSelectedItem().toString().equals("Vợ")||C_QuanHe.getSelectedItem().toString().equals("Chồng")){  //Xét quan hệ
            try {
                //Tạo prepareStatement với câu lệnh tìm kiếm
                pre=SQL.getConnection().prepareStatement("select ID from TV where ID like ? order by ID desc");
                // cung cấp thông tin tìm kiếm. 
                pre.setString(1, Tx_MaTVC.getText()+"[A-Z]"); // [A-Z]: ký tự từ A đến Z
                //thực thi lệnh tìm kiếm
                res=pre.executeQuery();
                if(res.next()==false)
                    return Tx_MaTVC.getText()+'A';  //trả về đoạn mã phát sinh có ký tự thứ 8 đc thêm vào khi câu lệnh trên không tìm ra kết quả
                return UP_ID(res.getString("ID"));  //trả về đoạn mã phát sinh khi có kết quả từ câu lệnh
            } catch (SQLException ex) {
                Logger.getLogger(ADD_TV.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        else {
                //Phần này được thực hiên khi quan hệ được chọn là con
                try {
                    char[] string= new char[2]; //lấy đời của thành viên cũ
                    //lấy số đời của thành viên cũ
                    string[0]=Tx_MaTVC.getText().toCharArray()[0];
                    string[1]=(char) (Tx_MaTVC.getText().toCharArray()[1]+1);
                    if(string[1]>'9'){  //Nếu ký tự đời ở hàng đơn vị lớn hơn 9
                        string[0]++;
                        string[1]='0';
                        if(string[0]>'9')
                            return null;
                    }
//                    System.out.println(new String(string));
                    String ID = new String(string);
                    pre=SQL.getConnection().prepareStatement("select ID from TV where ID like ? and len(ID)=7 order by ID desc");
                    pre.setString(1,ID+"%");
                    res=pre.executeQuery();
                    if(res.isBeforeFirst()==false)
                        return new String(string)+"A0001";
                    res.next();
                    return UP_ID(res.getString("ID"));
                } catch (SQLException ex) {
                    Logger.getLogger(ADD_TV.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
                }
        }
    }                
// </editor-fold> GEN-END:UP_ID


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Tx_ThanhVienCu = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        C_QuanHe = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        C_NamPS = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Tx_ThanhVM = new javax.swing.JTextField();
        C_GioiTinh = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        Tx_NamS = new javax.swing.JTextField();
        C_NgayS = new javax.swing.JComboBox<>();
        C_ThangS = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        Tx_DiaChi = new javax.swing.JTextField();
        But_Them = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        But_Dong = new javax.swing.JButton();
        C_QueQuan = new javax.swing.JComboBox<>();
        C_NgheNghiep = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        Tx_MaTVC = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        Txt_GT = new javax.swing.JTextField();
        Txt_NS = new javax.swing.JTextField();
        But_Tim = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        TBTen = new javax.swing.JLabel();

        setClosable(true);
        setResizable(true);
        setTitle("Tiếp Nhận Thành Viên");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tiếp nhận thành viên");
        jLabel1.setToolTipText("");

        jLabel3.setText("Thành viên cũ");

        Tx_ThanhVienCu.setEditable(false);
        Tx_ThanhVienCu.setSelectionColor(new java.awt.Color(0, 0, 125));
        Tx_ThanhVienCu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tx_ThanhVienCuActionPerformed(evt);
            }
        });

        jLabel5.setText("Quan hệ:");

        C_QuanHe.setMaximumRowCount(4);
        C_QuanHe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chồng", "Vợ", "Con" }));
        C_QuanHe.setToolTipText("");
        C_QuanHe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C_QuanHeActionPerformed(evt);
            }
        });

        jLabel6.setText("Ngày phát sinh:");

        jLabel8.setText("Thành viên mới:");

        C_GioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        C_GioiTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C_GioiTinhActionPerformed(evt);
            }
        });

        jLabel10.setText("Ngày sinh:");

        Tx_NamS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tx_NamSActionPerformed(evt);
            }
        });

        C_NgayS.setMaximumRowCount(31);
        C_NgayS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        C_NgayS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C_NgaySActionPerformed(evt);
            }
        });

        C_ThangS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        C_ThangS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C_ThangSActionPerformed(evt);
            }
        });

        jLabel11.setText("Năm");

        jLabel12.setText("Quê quán:");

        jLabel13.setText("Nghề nghiệp:");

        jLabel14.setText("Địa chỉ:");

        Tx_DiaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tx_DiaChiActionPerformed(evt);
            }
        });

        But_Them.setText("Thêm");
        But_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                But_ThemActionPerformed(evt);
            }
        });
        But_Them.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                But_ThemKeyPressed(evt);
            }
        });

        jLabel2.setText("Giới tính:");

        But_Dong.setText("Đóng");
        But_Dong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                But_DongActionPerformed(evt);
            }
        });

        C_QueQuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hà Nội", "Đà Nẵng", "TP.Hồ Chí Minh", "Đồng Bằng Sông Cửu Long" }));
        C_QueQuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C_QueQuanActionPerformed(evt);
            }
        });

        C_NgheNghiep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Không", "Giúp việc", "Giáo viên", "Giảng viên", "Thợ rèn", "Thợ tiện", "Thợ điện", "Nhân viên văn phòng", "Bác sĩ", "Y tá", "Dược sĩ", "Điều dưỡng", "Xây dựng", "Kỹ sư tin học", "Nghệ sĩ" }));

        jLabel4.setText("Mã thành viên cũ");

        Tx_MaTVC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Tx_MaTVCKeyPressed(evt);
            }
        });

        jLabel7.setText("Giới tính:");

        jLabel15.setText("Ngày sinh:");

        Txt_GT.setEditable(false);

        Txt_NS.setEditable(false);

        But_Tim.setText("Tìm");
        But_Tim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                But_TimMouseClicked(evt);
            }
        });

        jLabel16.setText("Tháng");

        jLabel17.setText("Ngày");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Txt_GT, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                            .addComponent(Tx_ThanhVienCu, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Tx_MaTVC)
                            .addComponent(Txt_NS))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(But_Tim)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(C_NamPS)
                                    .addComponent(Tx_ThanhVM)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(C_QuanHe, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 181, Short.MAX_VALUE))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel12)
                                        .addComponent(jLabel14))
                                    .addGap(42, 42, 42)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(C_QueQuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Tx_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel13)
                                    .addGap(29, 29, 29)
                                    .addComponent(C_NgheNghiep, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel2))
                                    .addGap(42, 42, 42)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel11)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(Tx_NamS, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(C_GioiTinh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel16)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(C_ThangS, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel17)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(C_NgayS, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(57, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(But_Them)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(But_Dong)
                .addGap(99, 99, 99))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TBTen, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Tx_MaTVC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(But_Tim))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tx_ThanhVienCu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(Txt_GT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(Txt_NS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(C_QuanHe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(C_NamPS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(Tx_ThanhVM))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(Tx_NamS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C_ThangS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(C_NgayS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(C_GioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(C_QueQuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(Tx_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(C_NgheNghiep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(But_Them)
                    .addComponent(But_Dong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TBTen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void But_DongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_But_DongActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_But_DongActionPerformed

    private void Tx_MaTVCKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Tx_MaTVCKeyPressed
        // TODO add your handling code here:.
        if(!edit)
            return;
        char chr=evt.getKeyChar();
        
        if(chr==65535){
            return;
        }
        
        if(chr==KeyEvent.VK_ENTER){
          Search(Tx_MaTVC.getText());
             return;   
        }
       
        
        String id= Tx_MaTVC.getText();
        int len=id.length();
        if(len==6 || len==7){
            Search(Tx_MaTVC.getText()+evt.getKeyChar());
        }
        else{
            Tx_ThanhVienCu.setText("");
            Txt_GT.setText("");
            Txt_NS.setText("");
            C_QuanHe.setEnabled(false);
            But_Them.setEnabled(false);
        }
    }//GEN-LAST:event_Tx_MaTVCKeyPressed

    private void LoadDate() {
        int day;
        int groupmonth;
        switch(C_ThangS.getSelectedIndex()+1){
            case 1: case 3: case 5: case 7: case 8: case 10: case 12: {
                day=31;
                groupmonth=1;
                break;
            }
            case 2:
                if(Integer.valueOf(Tx_NamS.getText())%4==0){
                    day=29;
                    groupmonth=2;
                }
                else {
                    day=28;
                    groupmonth=3;
                }
                break;
            default:
                day=30;
                groupmonth=4;
                break;
        }
        if(groupmonth!=this.groupmonth){
            C_NgayS.removeAllItems();
            for(int i=1;i<=day;i++)
                C_NgayS.addItem(Integer.toString(i));
            this.groupmonth=groupmonth;
            
        }

    }
    
    private boolean Check_Year(String ns){
            try {
                String cmd="select (case when dateadd(year,15,?)>? then 1 else 0 end)";
                PreparedStatement pre=SQL.getConnection().prepareStatement(cmd);
                pre.setString(1, Txt_NS.getText());
                pre.setString(2, ns);
                ResultSet re=pre.executeQuery();
                re.next();
                return re.getBoolean(1);
            } catch (SQLException ex) {
                Logger.getLogger(ADD_TV.class.getName()).log(Level.SEVERE, null, ex);
                return true;
            }
    }
    
    private boolean Check_GT(){
        return Txt_GT.getText().compareTo(C_GioiTinh.getSelectedItem().toString())==0 && C_QuanHe.getSelectedItem().toString().compareTo("Con")!=0;
    }
    
    private  boolean Check_QH(){
        return (Txt_GT.getText().compareTo("Nữ")==0 && C_QuanHe.getSelectedItem().toString().compareTo("Vợ")==0) || (Txt_GT.getText().compareTo("Nam")==0 && C_QuanHe.getSelectedItem().toString().compareTo("Chồng")==0);
    }
    
    private void But_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_But_ThemActionPerformed
        if(!But_Them.isEnabled()){
            return;
        }
                
        try {
                String cmd ="insert into TV values (?,?,?,?,?,?,?) insert into QH values (?,?,?,?)";
                String ns=C_NgayS.getSelectedItem().toString()+"/"+C_ThangS.getSelectedItem().toString()+"/"+Tx_NamS.getText();
                if(C_QuanHe.getSelectedIndex()==3 && Check_Year(ns)) {
                    JOptionPane.showMessageDialog(this, "Cha/mẹ phải hơn con 15 trở lên.","Lỗi",1);
                    return;
                }
                if(Check_GT()){
                    JOptionPane.showMessageDialog(this, "Giới tính không hợp lệ.","Lỗi",1);
                    return;
                }
                if(Check_QH()){
                    JOptionPane.showMessageDialog(this, "Quan hê không hợp lệ.","Lỗi",1);
                    return;
                }
                String ID= Get_ID();
                PreparedStatement pre=SQL.getConnection().prepareStatement(cmd);
                pre.setString(1, ID);
                pre.setString(2, Tx_ThanhVM.getText());
                pre.setString(3, (String) C_GioiTinh.getSelectedItem());
                pre.setString(4, ns);
                pre.setString(5, C_QueQuan.getSelectedItem().toString());
                pre.setString(6, C_NgheNghiep.getSelectedItem().toString());
                pre.setString(7, Tx_DiaChi.getText());

                pre.setString(8, ID);
                pre.setString(9, C_NamPS.getText());
                pre.setString(10, C_QuanHe.getSelectedItem().toString());
                pre.setString(11, Tx_MaTVC.getText());
                pre.execute();
                TBTen.setText("Tên: "+Tx_ThanhVM.getText()+"     Mã: "+ID);
                JOptionPane.showMessageDialog(this,"Thêm thành công" ,"Thông báo",1);
                C_QuanHe.setSelectedIndex(0);
                Tx_ThanhVM.setText("");
                C_NgayS.setSelectedIndex(0);
                C_ThangS.setSelectedIndex(0);
                Tx_NamS.setText("");
                C_GioiTinh.setSelectedIndex(0);
                C_QueQuan.setSelectedIndex(0);
                Tx_DiaChi.setText("");
                C_NgheNghiep.setSelectedIndex(0);
//                if(edit) {
//                    Tx_MaTVC.setText("");
//                    Tx_ThanhVienCu.setText("");
//                    Txt_GT.setText("");
//                    Txt_NS.setText("");
//                }
                
            } catch (SQLException ex) {
//                int begin=ex.getMessage().indexOf("\"")+1;
//                int end=ex.getMessage().indexOf("\". ");
                JOptionPane.showMessageDialog(this,ex.getMessage(),"Lỗi",1);
//                Logger.getLogger(ADD_TV.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
    }//GEN-LAST:event_But_ThemActionPerformed

    private void Tx_DiaChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tx_DiaChiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tx_DiaChiActionPerformed

    private void C_QueQuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C_QueQuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_C_QueQuanActionPerformed

    private void But_TimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_But_TimMouseClicked
        // TODO add your handling code here:
        Search(Tx_MaTVC.getText());
    }//GEN-LAST:event_But_TimMouseClicked

    private void C_ThangSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C_ThangSActionPerformed
        // TODO add your handling code here:
        try {
            LoadDate();
        } catch (Exception e) {
            Logger.getLogger(e.getLocalizedMessage()).log(Level.SEVERE,"Lỗi",e);
        }
    }//GEN-LAST:event_C_ThangSActionPerformed

    public void But_ThemKeyPressed(java.awt.event.KeyEvent evt){
        
    }

    public void Tx_ThanhVienCuActionPerformed(java.awt.event.ActionEvent evt){
        
    }
    
    public void C_QuanHeActionPerformed(java.awt.event.ActionEvent evt) {
                
    }
    
    
    public void C_NgayPSActionPerformed(java.awt.event.ActionEvent evt) {
                
    }
    
    public void C_GioiTinhActionPerformed(java.awt.event.ActionEvent evt) {
                
    }
    
    public void C_NamSActionPerformed(java.awt.event.ActionEvent evt) {
                
    }
    
    public void C_NgaySActionPerformed(java.awt.event.ActionEvent evt) {
                
    }
    
    public void Tx_NamSActionPerformed(java.awt.event.ActionEvent evt) {
                
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton But_Dong;
    private javax.swing.JButton But_Them;
    private javax.swing.JButton But_Tim;
    private javax.swing.JComboBox<String> C_GioiTinh;
    private javax.swing.JTextField C_NamPS;
    private javax.swing.JComboBox<String> C_NgayS;
    private javax.swing.JComboBox<String> C_NgheNghiep;
    private javax.swing.JComboBox<String> C_QuanHe;
    private javax.swing.JComboBox<String> C_QueQuan;
    private javax.swing.JComboBox<String> C_ThangS;
    private javax.swing.JLabel TBTen;
    private javax.swing.JTextField Tx_DiaChi;
    private javax.swing.JTextField Tx_MaTVC;
    private javax.swing.JTextField Tx_NamS;
    private javax.swing.JTextField Tx_ThanhVM;
    private javax.swing.JTextField Tx_ThanhVienCu;
    private javax.swing.JTextField Txt_GT;
    private javax.swing.JTextField Txt_NS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
