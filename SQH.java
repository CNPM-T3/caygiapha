/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caygiapha;

import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ADT
 */
public class SQH extends javax.swing.JInternalFrame {

    /**
     * Creates new form SQH_1
     */
    private String nstvc;
    private String gt;
    DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
    public SQH() {
        initComponents();
        Bxacnhan.setEnabled(false);
//        ttv.setEditable(false);
//        ns.setEditable(false);
//        ttvc.setEditable(false);
//        qhc.setEditable(false);
        setVisible(true);
    }
    
    public SQH(String ma){
        initComponents();
        matv.setText(ma);
        matv.setEditable(false);
        Bxacnhan.setEnabled(true);
        boolean x=Search(matv.getText());
        if(x){
            setVisible(true);
        } else {
            dispose();
        }
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
        Cqh = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        Bxacnhan = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        matv = new javax.swing.JTextField();
        ltb = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ttv = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ns = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        ttvc = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        qhc = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Sửa quan hệ");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("SỬA QUAN HỆ THÀNH VIÊN");

        Cqh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chồng", "Vợ", "Con" }));
        Cqh.setFocusable(false);
        Cqh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CqhActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Đổi quan hệ:");

        Bxacnhan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Bxacnhan.setText("XÁC NHẬN");
        Bxacnhan.setFocusable(false);
        Bxacnhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BxacnhanActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Mã thành viên cần sửa:");

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

        ltb.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel3.setText("Tên thành viên:");

        ttv.setEditable(false);
        ttv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ttvActionPerformed(evt);
            }
        });

        jLabel4.setText("Ngày sinh:");

        ns.setEditable(false);
        ns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nsActionPerformed(evt);
            }
        });

        jLabel5.setText("Tên thành viên cũ:");

        ttvc.setEditable(false);
        ttvc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ttvcActionPerformed(evt);
            }
        });

        jLabel6.setText("Quan hệ cũ");

        qhc.setEditable(false);
        qhc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qhcActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ttv, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(matv, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 1, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ns, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ttvc, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Cqh, 0, 163, Short.MAX_VALUE)
                            .addComponent(qhc)
                            .addComponent(Bxacnhan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ltb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(matv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ttv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(ttvc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(qhc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cqh, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(Bxacnhan, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ltb, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean Search(String ma){
        String cmd="select T.HVT,T.NS,T1.HVT,QH,T1.NS,T.GT from TV T left outer join QH Q on T.ID=Q.ID left outer join TV T1 on ID_O=T1.ID where T.ID like ?";
        try {
            PreparedStatement pre=SQL.getConnection().prepareStatement(cmd);
            pre.setString(1, ma);
            ResultSet r=pre.executeQuery();
            if(r.next()==true){
                    if(r.getDate(5)==null){
                        JOptionPane.showMessageDialog(this, "Không tìm thấy thông tin thành viên cũ.","Lỗi",1);
                        return false;
                    } else {
                        ttv.setText(r.getString(1));
                        ns.setText(df.format(r.getDate(2)));
                        ttvc.setText(r.getString(3));
                        qhc.setText(r.getString(4));
                        nstvc=df.format(r.getDate(5));
                        gt=r.getString(6);
                        ltb.setText("");
                    }
                }else{
                    ttv.setText("");
                    ns.setText("");
                    ttvc.setText("");
                    qhc.setText("");
                    Cqh.setEnabled(false);
                    ltb.setText("Không tìm thấy người này!");
                    ltb.setVisible(true);
                }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SQH.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    private boolean CheckYear(){
        try {
            String cmd = "select (case when dateadd(year,15,?)>? then 1 else 0 end)";
            PreparedStatement pre=SQL.getConnection().prepareStatement(cmd);
            pre.setString(1, nstvc);
            pre.setString(2, ns.getText());
            ResultSet re=pre.executeQuery();
            re.next();
            return re.getBoolean(1);
        } catch (SQLException ex) {
            Logger.getLogger(SQH.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    private void BxacnhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BxacnhanActionPerformed
        // TODO add your handling code here:
        if(!Bxacnhan.isEnabled()) {
            return;
        }
        
        if(CheckYear() && Cqh.getSelectedIndex()==2){
            JOptionPane.showMessageDialog(this, "Cha/mẹ phải hơn con tối thiểu 15 tuổi.","Lỗi",1);
            return;
        }
        if((gt.compareTo("Nam")==0&&Cqh.getSelectedIndex()==0)||(gt.compareTo("Nữ")==0&&Cqh.getSelectedIndex()==1)){
            JOptionPane.showMessageDialog(this, "Quan hệ không hợp lệ.","Lỗi",1);
            return;
        }
        String sql = "update QH set QH = N'" + Cqh.getItemAt(Cqh.getSelectedIndex()) +"'";
        String sql1= " where ID like '"+matv.getText()+"'";
        String timma=" select ID from TV where ID like '" + matv.getText() + "'";
        ResultSet res=null;
        try {
            Statement ma = SQL.getConnection().createStatement();
            res=ma.executeQuery(timma);
        } catch (SQLException ex) {
            Logger.getLogger(SQH.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(matv.getText().isEmpty())
        {    
            ltb.setText("Hãy nhập mã thành viên!");
            Cqh.setEnabled(false);
        }
        else
        {
            try {
                if(res.isBeforeFirst());
                else{
                Cqh.setEnabled(false);
                ltb.setText("Không tìm thấy người này!");
                ltb.setVisible(true);
                return;
                }
            } catch (SQLException ex) {
                Logger.getLogger(SQH.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            try {
            Statement sta=SQL.getConnection().createStatement();
            sta.executeUpdate(sql+sql1);
            ltb.setText("Sửa thành công!");
            ttv.setText("");
                    ns.setText("");
                    ttvc.setText("");
                    qhc.setText("");
            } catch (SQLException ex) {
              Logger.getLogger(SQH.class.getName()).log(Level.SEVERE, null, ex);
                ltb.setText("Sửa thất bại!");
            }
        }
    }//GEN-LAST:event_BxacnhanActionPerformed

    private void matvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_matvActionPerformed

    private void ttvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ttvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ttvActionPerformed

    private void qhcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qhcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qhcActionPerformed

    private void CqhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CqhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CqhActionPerformed

    private void nsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nsActionPerformed

    private void ttvcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ttvcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ttvcActionPerformed

    private void matvKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_matvKeyPressed
        // TODO add your handling code here:        
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){
          Search(matv.getText());
        }
        
    }//GEN-LAST:event_matvKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bxacnhan;
    private javax.swing.JComboBox<String> Cqh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel ltb;
    private javax.swing.JTextField matv;
    private javax.swing.JTextField ns;
    private javax.swing.JTextField qhc;
    private javax.swing.JTextField ttv;
    private javax.swing.JTextField ttvc;
    // End of variables declaration//GEN-END:variables
}
