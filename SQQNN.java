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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADT
 */
public class SQQNN extends javax.swing.JInternalFrame {
    /**
     * Creates new form SQQNN_1
     */
    private boolean edit=true;
    DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
    public SQQNN() {
        initComponents();
        ttv.setEditable(false);
        ns.setEditable(false);
        nnc.setEditable(false);
        qqc.setEditable(false);
        LoadData(matv.getText());
        setVisible(true);
    }
    
    public SQQNN(String ma){
        initComponents();
        ttv.setEditable(false);
        ns.setEditable(false);
        nnc.setEditable(false);
        qqc.setEditable(false);
        matv.setText(ma);
        matv.setEditable(false);
        edit=false;
        LoadData(matv.getText());
        setVisible(true);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        ltb = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        matv = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Csqq = new javax.swing.JComboBox<>();
        Csnn = new javax.swing.JComboBox<>();
        Bxacnhan = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ttv = new javax.swing.JTextField();
        ns = new javax.swing.JTextField();
        qqc = new javax.swing.JTextField();
        nnc = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Sửa quê quán và nghê nghiệp");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("SỬA QUÊ QUÁN & NGHỀ NGHIỆP");

        ltb.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Mã thành viên cần sửa:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Đổi nghề nghiệp");

        matv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matvActionPerformed(evt);
            }
        });
        matv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                matvKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Đổi quê quán");

        Csqq.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hà Nội", "Đà nẵng", "Hồ Chí Minh", "Đồng Bằng Sông Cửu Long" }));
        Csqq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CsqqActionPerformed(evt);
            }
        });

        Csnn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Không", "Giúp việc", "Giáo viên", "Giảng viên", "Thợ rèn", "Thợ tiện", "Thợ điện", "Nhân viên văn phòng", "Bác sĩ", "Y tá", "Dược sĩ", "Điều dưỡng", "Xây dựng", "Kỹ sư tin học", "Nghệ sĩ" }));
        Csnn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CsnnActionPerformed(evt);
            }
        });

        Bxacnhan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Bxacnhan.setText("XÁC NHẬN");
        Bxacnhan.setEnabled(false);
        Bxacnhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BxacnhanActionPerformed(evt);
            }
        });

        jLabel4.setText("Tên thành viên:");

        jLabel5.setText("Ngày sinh:");

        jLabel6.setText("Quê quán cũ:");

        jLabel7.setText("Nghề nghiệp cũ:");

        ns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nsActionPerformed(evt);
            }
        });

        qqc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qqcActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Csnn, 0, 172, Short.MAX_VALUE)
                            .addComponent(ltb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Bxacnhan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Csqq, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(matv)
                                    .addComponent(ttv)
                                    .addComponent(ns)
                                    .addComponent(qqc)
                                    .addComponent(nnc, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))))))
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(matv, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ttv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(ns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(qqc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(nnc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Csqq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Csnn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(11, 11, 11)
                .addComponent(Bxacnhan, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(ltb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoadData(String ma){
        //Kiểm tra mã thành viên
        if(ma.isEmpty()){
            //Xuất thông báo khi mã thành viên bị bỏ trống
            ltb.setText("Hãy nhập mã thành viên!");
            Csqq.setEnabled(false);
            Csnn.setEnabled(false);
            Bxacnhan.setEnabled(false);
            return;
        }
        
        ltb.setText("");
        //Khai báo câu lệnh tìm kiếm thông tin thành viên
        String cmd="select HVT,NS,QQ,NN from TV where ID like ?";
        try (PreparedStatement pre = SQL.getConnection().prepareStatement(cmd)) {
                pre.setString(1, ma);
                ResultSet re=pre.executeQuery();
                if(re.isBeforeFirst()){
                    re.next();
                    ttv.setText(re.getString(1));
                    ns.setText(df.format(re.getDate(2)));
                    qqc.setText(re.getString(3));
                    nnc.setText(re.getString(4));
                    //Enable cho các combobox và nút
                    Bxacnhan.setEnabled(true);
                    Csqq.setEnabled(true);
                    Csnn.setEnabled(true);
                    ltb.setText("");
                } else {
                    //Disenable các combobox và nút nếu không tìm thấy thành viên
                    Bxacnhan.setEnabled(false);
                    Csqq.setEnabled(false);
                    Csnn.setEnabled(false);
                    ttv.setText("");
                    ns.setText("");
                    qqc.setText("");
                    nnc.setText("");
                }
        } catch (SQLException ex) {
            Logger.getLogger(SQQNN.class.getName()).log(Level.SEVERE, null, ex);
            Bxacnhan.setEnabled(false);
            Csqq.setEnabled(false);
            Csnn.setEnabled(false);
        }
    }
    
    
    private void BxacnhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BxacnhanActionPerformed
        // TODO add your handling code here:
        //Khai báo câu lệnh update
        String sql = "update TV set QQ = ?,NN = ?";
        String sql2 = " where ID like ?";
        
            try{
                PreparedStatement sta=SQL.getConnection().prepareStatement(sql+sql2);
                //Thực hiện lệnh update
                sta.setString(1, Csqq.getSelectedItem().toString());
                sta.setString(2, Csnn.getSelectedItem().toString());
                sta.setString(3, matv.getText());
                sta.executeUpdate();
                qqc.setText(Csqq.getSelectedItem().toString());
                nnc.setText(Csnn.getSelectedItem().toString());
                //Xuất thông báo sau khi update
                ltb.setText("Sửa thành công!");
            } catch (SQLException ex) {
                Logger.getLogger(SMT.class.getName()).log(Level.SEVERE, null, ex);
                //Xuất thông báo khi quá trình update gặp lỗi
                ltb.setText("Sửa thát bại");
            }
    }//GEN-LAST:event_BxacnhanActionPerformed

    private void matvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_matvActionPerformed

    private void CsqqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CsqqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CsqqActionPerformed

    private void qqcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qqcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qqcActionPerformed

    private void CsnnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CsnnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CsnnActionPerformed

    private void nsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nsActionPerformed

    private void matvKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_matvKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyChar()==65535 || edit==false){
            return;
        }
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){
            LoadData(matv.getText());
            return;
        }
        
        if(matv.getText().length()==6||matv.getText().length()==7){
            LoadData(matv.getText()+evt.getKeyChar());
        } else {
            ttv.setText("");
            ns.setText("");
            nnc.setText("");
            qqc.setText("");
            Csnn.setEnabled(false);
            Csqq.setEnabled(false);
            Bxacnhan.setEnabled(false);
        }
    }//GEN-LAST:event_matvKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bxacnhan;
    private javax.swing.JComboBox<String> Csnn;
    private javax.swing.JComboBox<String> Csqq;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel ltb;
    private javax.swing.JTextField matv;
    private javax.swing.JTextField nnc;
    private javax.swing.JTextField ns;
    private javax.swing.JTextField qqc;
    private javax.swing.JTextField ttv;
    // End of variables declaration//GEN-END:variables
}
