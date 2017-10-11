/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caygiapha;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
//import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADT
 */
public class ADD_TT extends javax.swing.JInternalFrame {

    /**
     * Creates new form ADD_TT_1
     */
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal= Calendar.getInstance();
        DefaultTableModel model;
        
    public ADD_TT() {
        initComponents();
        ngay.setText(df.format(date));
        model = (DefaultTableModel) bang.getModel();
        if(Bridge.isOpen()){
            String[] data=Bridge.getData();
            matv.setText(data[0]);
            hoVaTen.setText(data[1]);
            ngaySinh.setText(data[2]);
            matv.setEnabled(false);
            hoVaTen.setEnabled(false);
            ngaySinh.setEnabled(false);
        }
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

        jLabel7 = new javax.swing.JLabel();
        matv = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        bang = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        ngay = new javax.swing.JTextField();
        Bdong = new javax.swing.JButton();
        Lthongbao = new javax.swing.JLabel();
        BThem = new javax.swing.JButton();
        Cltt = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        hoVaTen = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ngaySinh = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Ghi Nhận Thành Tích");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Mã thành viên:");

        matv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matvActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Ngày phát sinh:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Loại thành tích:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("BẢNG GHI NHẬN THÀNH TÍCH");

        bang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Họ tên", "Loại thành tích", "Ngày phát sinh"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(bang);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("THÀNH TÍCH THÀNH VIÊN VỪA THÊM");

        ngay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ngayActionPerformed(evt);
            }
        });

        Bdong.setText("Đóng");
        Bdong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BdongActionPerformed(evt);
            }
        });

        BThem.setText("Thêm");
        BThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BThemMouseClicked(evt);
            }
        });
        BThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BThemActionPerformed(evt);
            }
        });

        Cltt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Cltt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Công dân tri thức", "Công dân văn hóa", "Công dân chăm chỉ", "Công dân khỏe", "Công dân tốt bụng", "Đảng viên tri thức", "Đảng viên văn hóa", "Đảng viên chăm chỉ", "Đảng viên khỏe", "Đảng viên tốt bụng" }));
        Cltt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClttActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Họ và tên:");

        hoVaTen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Ngày sinh:");

        ngaySinh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ngay)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Cltt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ngaySinh)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Lthongbao))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(matv, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(hoVaTen)))))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(209, 209, 209)
                                .addComponent(BThem)))
                        .addContainerGap(49, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addComponent(Bdong)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(matv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(hoVaTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Lthongbao)
                        .addGap(33, 33, 33))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ngaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Cltt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ngay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BThem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Bdong)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void matvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_matvActionPerformed

    private void ngayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ngayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ngayActionPerformed

    private void BdongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BdongActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_BdongActionPerformed

    private void BThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BThemMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BThemMouseClicked

    private void BThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BThemActionPerformed
                // TODO add your handling code here
                
                PreparedStatement pre;
                ResultSet res=null;
            try {
                String select="select ID, NPS, LTT from TT where ID like ? and NPS = ? LTT like ?";
                pre=SQL.getConnection().prepareStatement(select);
                pre.setString(1, matv.getText());
                pre.setString(2,ngay.getText());
                pre.setString(3, Cltt.getSelectedItem().toString());
                res=pre.executeQuery();
                if(res.isBeforeFirst()==false){
                    String sql="insert into TT values(?,?,?)"; 
                    pre=SQL.getConnection().prepareStatement(sql);
                    pre.setString(1, matv.getText());
                    pre.setString(2,ngay.getText());
                    pre.setString(3, Cltt.getSelectedItem().toString());
                    if(pre.execute())
                        model.insertRow(model.getRowCount(), new Object[]{matv.getText(),Cltt.getSelectedItem(),ngay.getText()});
                }
            } catch (SQLException ex) {
                Logger.getLogger(ADD_TT.class.getName()).log(Level.SEVERE, null, ex);
                Lthongbao.setText("Thêm thất bại!");
            }
    }//GEN-LAST:event_BThemActionPerformed

    private void ClttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClttActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClttActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BThem;
    private javax.swing.JButton Bdong;
    private javax.swing.JComboBox<String> Cltt;
    private javax.swing.JLabel Lthongbao;
    private javax.swing.JTable bang;
    private javax.swing.JTextField hoVaTen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField matv;
    private javax.swing.JTextField ngay;
    private javax.swing.JTextField ngaySinh;
    // End of variables declaration//GEN-END:variables

    private void add(String dateString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}