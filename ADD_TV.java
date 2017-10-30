/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package caygiapha;
import java.awt.event.ActionEvent;
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
    /**
     * Creates new form ADD_TV_1
     */
    public ADD_TV() {
        initComponents();
        jLabel9.setVisible(false);
        C_NamPS.setText(df.format(date));
        
        if(Bridge.isOpen()){
            String[] data=Bridge.getData();
            Tx_MaTVC.setText(data[0]);
            Tx_MaTVC.setEditable(false);
            But_Tim.setEnabled(false);
            edit=false;
        }
        Search();
        setVisible(true);
        
    }
    private void Search(){
            try {
                String cmd ="select HVT,GT,NS from TV where ID = ?";
                PreparedStatement ps=SQL.getConnection().prepareStatement(cmd);
                ps.setString(1, Tx_MaTVC.getText());
                ResultSet re = ps.executeQuery();
                if(re.isBeforeFirst()){
                    re.next();
                    Tx_ThanhVienCu.setText(re.getString(1));
                    Txt_GT.setText(re.getString(2));
                    Txt_NS.setText(re.getString(3));
                } else {
                    Tx_ThanhVienCu.setText("");
                    Txt_GT.setText("");
                    Txt_NS.setText("");
                    JOptionPane.showMessageDialog(this, "Không tìm thấy thành viên này!","Lỗi",1);
                }
            } catch (SQLException ex) {
                Tx_ThanhVienCu.setText("");
                Txt_GT.setText("");
                Txt_NS.setText("");
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
                    System.out.println(new String(string));
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
        ID = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        Txt_GT = new javax.swing.JTextField();
        Txt_NS = new javax.swing.JTextField();
        But_Tim = new javax.swing.JButton();

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

        jLabel5.setText("Quan hệ");

        C_QuanHe.setMaximumRowCount(4);
        C_QuanHe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn...", "Chồng", "Vợ", "Con" }));
        C_QuanHe.setToolTipText("");
        C_QuanHe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C_QuanHeActionPerformed(evt);
            }
        });

        jLabel6.setText("Ngày phát sinh");

        jLabel8.setText("Thành viên mới");

        C_GioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Giới tính", "Nam", "Nữ" }));
        C_GioiTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C_GioiTinhActionPerformed(evt);
            }
        });

        jLabel10.setText("Ngày sinh");

        Tx_NamS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tx_NamSActionPerformed(evt);
            }
        });

        C_NgayS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn...", "Ngày 1", "Ngày 2", "Ngày 3", "Ngày 4", "Ngày 5", "Ngày 6", "Ngày 7", "Ngày 8", "Ngày 9", "Ngày 10", "Ngày 11", "Ngày 12", "Ngày 13", "Ngày 14", "Ngày 15", "Ngày 16", "Ngày 17", "Ngày 18", "Ngày 19", "Ngày 20", "Ngày 21", "Ngày 22", "Ngày 23", "Ngày 24", "Ngày 25", "Ngày 26", "Ngày 27", "Ngày 28", "Ngày 29", "Ngày 30", "Ngày 31" }));
        C_NgayS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C_NgaySActionPerformed(evt);
            }
        });

        C_ThangS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn...", "Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12" }));

        jLabel11.setText("Năm");

        jLabel12.setText("Quê quán");

        jLabel13.setText("Nghề nghiệp");

        jLabel14.setText("Địa chỉ");

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

        jLabel2.setText("Giới tính");

        But_Dong.setText("Đóng");
        But_Dong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                But_DongActionPerformed(evt);
            }
        });

        C_QueQuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn...", "Hà Nội", "Đà Nẵng", "TP.Hồ Chí Minh", "Đồng Bằng Sông Cửu Long" }));
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

        ID.setText("jLabel15");

        jLabel9.setText("Đã thêm thành công");

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
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(C_QuanHe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Tx_ThanhVM, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(C_NamPS, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel2))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(C_NgayS, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(C_ThangS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Tx_NamS, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(C_GioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Tx_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(C_NgheNghiep, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(But_Them)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ID)
                                    .addComponent(But_Dong))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12)
                                .addComponent(jLabel14))
                            .addGap(42, 42, 42)
                            .addComponent(C_QueQuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Tx_ThanhVienCu, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(Tx_MaTVC)
                            .addComponent(Txt_GT)
                            .addComponent(Txt_NS))
                        .addGap(18, 18, 18)
                        .addComponent(But_Tim)))
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
                    .addComponent(Tx_ThanhVM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(C_ThangS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(Tx_NamS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(C_NgayS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(C_GioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(C_QueQuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(But_Them)
                            .addComponent(But_Dong)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Tx_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(C_NgheNghiep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ID)
                    .addComponent(jLabel9))
                .addContainerGap())
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
        
        if(chr==65535 || chr==KeyEvent.VK_DELETE || chr==KeyEvent.VK_BACK_SPACE){
            return;
        }
        
        if(chr==KeyEvent.VK_ENTER){
          Search();
             return;   
        }
       
        
        String id= Tx_MaTVC.getText();
        int len=id.length();
        if(len==6 || len==7){
            
          Statement s;
          ResultSet r;
          String a="select HVT,GT,NS from TV where ID like '"+id+chr+"'" ;
          
            try {
                s=SQL.getConnection().createStatement();
                r=s.executeQuery(a);
                if(r.next()==true){
                    Tx_ThanhVienCu.setText(r.getString(1));
                    Txt_GT.setText(r.getString(2));
                    Txt_NS.setText(r.getString(3));
                }else{
                    Tx_ThanhVienCu.setText("");
                    Txt_GT.setText("");
                    Txt_NS.setText("");
                    JOptionPane.showMessageDialog(this, "Không tìm thấy thành viên này!","Lỗi",1);
                }
               
            } catch (SQLException ex) {
                Tx_ThanhVienCu.setText("");
                Txt_GT.setText("");
                Txt_NS.setText("");
                Logger.getLogger(ADD_TV.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        }
        else{
            Tx_ThanhVienCu.setText("");
        }
    }//GEN-LAST:event_Tx_MaTVCKeyPressed

    private void But_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_But_ThemActionPerformed
            
        
    }//GEN-LAST:event_But_ThemActionPerformed

    private void Tx_DiaChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tx_DiaChiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tx_DiaChiActionPerformed

    private void C_QueQuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C_QueQuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_C_QueQuanActionPerformed

    private void But_TimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_But_TimMouseClicked
        // TODO add your handling code here:
        Search();
    }//GEN-LAST:event_But_TimMouseClicked

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
    private javax.swing.JLabel ID;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
