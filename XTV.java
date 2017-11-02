/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caygiapha;

import java.awt.event.KeyEvent;
import java.sql.*;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADT
 */
public class XTV extends javax.swing.JInternalFrame {
    private String[] data;
    /**
     * Creates new form XTV_1
     */

    
    DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
    public XTV() {
        initComponents();
        Select();
        setVisible(true);
    }
    void Select (){
        try {
            DefaultTableModel tb= (DefaultTableModel) jTable1.getModel();
            tb.setRowCount(0);
            Statement sta=SQL.getConnection().createStatement();
            ResultSet res;
            //Khai báo câu lệnh tìm kiếm thông tin các thành viên trong gia phả
            String cmd="select ID,HVT,NS,left(ID,2), (case when left (ID,2) like '01' then '' else dbo.TC (ID) end) from TV where HVT like N'"+HVT_ThanhVien.getText()+"%'";
            
            //Thêm điều kiện cho câu lệnh nếu có chọn thông tin ngày sinh
            if(ngaySinh.getSelectedIndex()!=0){
                cmd+=" and day(NS)="+ngaySinh.getSelectedItem();
            }
            if(thangSinh.getSelectedIndex()!=0){
                cmd+=" and month(NS)="+thangSinh.getSelectedItem();
            }
            if(!namSinh.getText().isEmpty()){
                cmd+=" and year(NS)="+Integer.valueOf(namSinh.getText());
            }
            //Thực thi lệnh
            res=sta.executeQuery(cmd);
            int i=0;
            
//            if(res.isBeforeFirst()==true){
            while(res.next()){  //Trong khi chưa hết danh sách thành viên
                    Object[] Odata=new Object[] {res.getString(1),res.getString(2),df.format(res.getDate(3)),res.getString(4),res.getString(5)};
                    //Thêm dòng
                    tb.addRow(Odata);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),Integer.toString(ex.getErrorCode()),1);
            Logger.getLogger(XTV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 //   private void exit(){
 //       this.dispose();
 //   }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        HVT_ThanhVien = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ngaySinh = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        thangSinh = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        namSinh = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        But_XTT = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        But_XGKT = new javax.swing.JButton();
        But_SQH = new javax.swing.JButton();
        But_ADD_TV = new javax.swing.JButton();
        But_SQQNN = new javax.swing.JButton();
        But_Dong = new javax.swing.JButton();

        setClosable(true);
        setResizable(true);
        setTitle("Xem Thông Tin Thành Viên");
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("XEM THÔNG TIN THÀNH VIÊN");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("THÔNG TIN THÀNH VIÊN");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Họ tên", "Ngày sinh", "Đời", "Cha/mẹ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel1.setText("Họ tên");

        HVT_ThanhVien.setBackground(new java.awt.Color(240, 240, 240));
        HVT_ThanhVien.setFocusCycleRoot(true);
        HVT_ThanhVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HVT_ThanhVienActionPerformed(evt);
            }
        });
        HVT_ThanhVien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                HVT_ThanhVienKeyPressed(evt);
            }
        });

        jLabel3.setText("Ngày");
        jLabel3.setMaximumSize(new java.awt.Dimension(30, 14));
        jLabel3.setMinimumSize(new java.awt.Dimension(30, 14));
        jLabel3.setPreferredSize(new java.awt.Dimension(30, 14));

        ngaySinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn...", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", " " }));
        ngaySinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ngaySinhActionPerformed(evt);
            }
        });
        ngaySinh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ngaySinhKeyPressed(evt);
            }
        });

        jLabel4.setText("Tháng");

        thangSinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn...", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", " " }));
        thangSinh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                thangSinhKeyPressed(evt);
            }
        });

        jLabel5.setText("Năm");

        namSinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namSinhActionPerformed(evt);
            }
        });
        namSinh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                namSinhKeyPressed(evt);
            }
        });

        jButton2.setText("Tìm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton2KeyPressed(evt);
            }
        });

        But_XTT.setText("Xem thành tích");
        But_XTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                But_XTTActionPerformed(evt);
            }
        });

        jLabel6.setText("Ngày sinh:");

        But_XGKT.setText("Xem giấy tử");
        But_XGKT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                But_XGKTMouseClicked(evt);
            }
        });

        But_SQH.setText("Sửa quan hệ");
        But_SQH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                But_SQHMouseClicked(evt);
            }
        });
        But_SQH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                But_SQHActionPerformed(evt);
            }
        });

        But_ADD_TV.setText("Thêm thành viên");
        But_ADD_TV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                But_ADD_TVMouseClicked(evt);
            }
        });

        But_SQQNN.setText("Sửa quê quán và nghề nghiệp");
        But_SQQNN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                But_SQQNNMouseClicked(evt);
            }
        });

        But_Dong.setText("Đóng");
        But_Dong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                But_DongMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ngaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(thangSinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(namSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(203, 203, 203))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(HVT_ThanhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(379, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(But_Dong)
                                .addGap(276, 276, 276))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(But_XTT)
                                .addGap(18, 18, 18)
                                .addComponent(But_XGKT)
                                .addGap(18, 18, 18)
                                .addComponent(But_ADD_TV)
                                .addGap(18, 18, 18)
                                .addComponent(But_SQQNN)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(But_SQH)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(HVT_ThanhVien, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(thangSinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(namSinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jLabel6)
                    .addComponent(ngaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(But_XTT)
                    .addComponent(But_XGKT)
                    .addComponent(But_ADD_TV)
                    .addComponent(But_SQQNN)
                    .addComponent(But_SQH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(But_Dong)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Error(){ //Hàm xuất thông báo
        JOptionPane.showMessageDialog(this, "Vui lòng chọn thành viên","Lỗi",1);
    }
    /*
    private void HVT_ThanhVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HVT_ThanhVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HVT_ThanhVienActionPerformed
*/
    private void ngaySinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ngaySinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ngaySinhActionPerformed

    private void namSinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namSinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namSinhActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Select();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void But_XTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_But_XTTActionPerformed
        // TODO add your handling code here:
        try {
//            //Lấy mã thành viên từ Table
//            String a=jTable1.getValueAt(jTable1.getSelectedRow(),0).toString();
////            System.out.println(a+"  "+b+" "+c);
//            data=new String[]{a};
//            //Đưa thông tin vào 
//            Bridge.setData(data);
            //Tạo cửa sổ
            String a=new String(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
            MAIN.a.getJDesktop().add(new XTT(a));
        } catch (Exception e) {
            //Thông báo lỗi
            Error();
        }
    }//GEN-LAST:event_But_XTTActionPerformed

    private void HVT_ThanhVienKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_HVT_ThanhVienKeyPressed
        // TODO add your handling code here:
        int n=evt.getKeyChar();
        if(n==KeyEvent.VK_ENTER){ //Nếu bấm phím Enter
            Select();
        }
//        n=HVT_ThanhVien.getText().charAt(HVT_ThanhVien.getText().length()-1);
    }//GEN-LAST:event_HVT_ThanhVienKeyPressed

    private void ngaySinhKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ngaySinhKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){ // nếu bấm nút Enter
            Select();
        }
    }//GEN-LAST:event_ngaySinhKeyPressed

    private void thangSinhKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_thangSinhKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){ //Nếu bấm nút Enter
            Select();
        }
    }//GEN-LAST:event_thangSinhKeyPressed

    private void namSinhKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_namSinhKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyChar()==KeyEvent.VK_ENTER) { //Nếu bấm nút Enter
            Select();
        }
    }//GEN-LAST:event_namSinhKeyPressed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyChar()==KeyEvent.VK_ENTER) { //Nếu bấm nút Enter
            Select();
        }
    }//GEN-LAST:event_jButton2KeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:

        if(evt.getKeyChar()==KeyEvent.VK_ESCAPE) {//Nếu bấm nút Escape
            //Đóng của sổ
            this.dispose();
        }
    }//GEN-LAST:event_formKeyPressed

    private void But_XGKTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_But_XGKTMouseClicked
        // TODO add your handling code here:
        
        try {
            //Lấy mã thành viên từ Table
            String a=jTable1.getValueAt(jTable1.getSelectedRow(),0).toString();
            MAIN.a.getJDesktop().add(new XGKT(a));
        } catch (Exception e) {
            //Thông báo lỗi
            Error();
        }
        
    }//GEN-LAST:event_But_XGKTMouseClicked

    private void But_SQHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_But_SQHMouseClicked
        // TODO add your handling code here:
        try {
            String a = (String) jTable1.getValueAt(jTable1.getSelectedRow(), 0);
            MAIN.a.getJDesktop().add(new SQH(a));
        } catch (Exception e) {
            Error();
        }
    }//GEN-LAST:event_But_SQHMouseClicked

    private void But_ADD_TVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_But_ADD_TVMouseClicked
        // TODO add your handling code here:
        try {
            String a = (String) jTable1.getValueAt(jTable1.getSelectedRow(), 0);
            MAIN.a.getJDesktop().add(new ADD_TV(a));
        } catch (Exception e) {
            Error();
        }
    }//GEN-LAST:event_But_ADD_TVMouseClicked

    private void But_SQHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_But_SQHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_But_SQHActionPerformed

    private void But_SQQNNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_But_SQQNNMouseClicked
        // TODO add your handling code here:
        try {
            String a = (String) jTable1.getValueAt(jTable1.getSelectedRow(), 0);
            MAIN.a.getJDesktop().add(new SQQNN(a));
        } catch (Exception e) {
            Error();
        }
    }//GEN-LAST:event_But_SQQNNMouseClicked

    private void But_DongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_But_DongMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_But_DongMouseClicked


    public void HVT_ThanhVienActionPerformed(java.awt.event.ActionEvent evt) {
                
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton But_ADD_TV;
    private javax.swing.JButton But_Dong;
    private javax.swing.JButton But_SQH;
    private javax.swing.JButton But_SQQNN;
    private javax.swing.JButton But_XGKT;
    private javax.swing.JButton But_XTT;
    private javax.swing.JTextField HVT_ThanhVien;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField namSinh;
    private javax.swing.JComboBox<String> ngaySinh;
    private javax.swing.JComboBox<String> thangSinh;
    // End of variables declaration//GEN-END:variables
}
