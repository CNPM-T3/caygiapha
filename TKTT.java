/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caygiapha;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.GridPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ADT
 */
public class TKTT extends javax.swing.JInternalFrame {
    // tạo bảng table cho khung
        String a[]=new String[] {"STT","Loại thành tích","Số lượng"};
        DefaultTableModel tb=new DefaultTableModel(a,0);
    /**
     * Creates new form TKTT_1
     */
    public TKTT() {
        initComponents();
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

        tunam = new javax.swing.JTextField();
        dennam = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TK = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Thống kê thành tích");

        tunam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tunamActionPerformed(evt);
            }
        });
        tunam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tunamKeyPressed(evt);
            }
        });

        dennam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dennamKeyPressed(evt);
            }
        });

        TK.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "STT", "Loại Thành Tích", "Số Lượng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TK.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TK);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("THỐNG KÊ THÀNH TÍCH");

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Tìm");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Từ năm");

        jLabel3.setText("Đến năm");

        jButton1.setText("Đóng");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setText("     .................");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(jButton1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tunam, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dennam, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2))
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tunam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(dennam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/*
    private void tunamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tunamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tunamActionPerformed
*/
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        if(Integer.valueOf(tunam.getText()) > Integer.valueOf(dennam.getText())){
            jLabel5.setText("Thông tin không hợp lệ.\nVui lòng kiểm tra lại...");
            jLabel5.setVisible(true);
            return;
        }
        jLabel5.setVisible(false);
        PreparedStatement pre;
        ResultSet res;
        String select="select LTT,count (ID) from TT where year(NPS)>=? and year(NPS)<=? group by LTT  ";
        try {
            pre=SQL.getConnection().prepareStatement(select);
            //nhập năm của khung 1-2
            pre.setString(1, tunam.getText());
            pre.setString(2, dennam.getText());
            res=pre.executeQuery();
            select.compareTo(select);
            tb.setRowCount(0);
            if(res.isBeforeFirst()==false){
                TK.setModel(tb);
                return;
            }
            //nếu giá trị trước đó ko có trước đó
            if(res.isBeforeFirst()){
                // vector giá trị ko biết đc
                Vector a;
                int i=1;
                //chèn dòng đếm
                tb.setRowCount(0);
                while(res.next()){
                    a=new Vector();
                    a.add(i);
                    a.add(res.getString(1));
                    a.add(res.getString(2));
                    tb.addRow(a);
                    i++;
                }
                TK.setModel(tb);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TKTT.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }//GEN-LAST:event_jButton2MouseClicked

    private void tunamKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tunamKeyPressed
        // TODO add your handling code here:
        //kt những phím nếu nhỏ hơn 0 lơn hơn 9
        if(evt.getKeyChar()<'0' || evt.getKeyChar()>'9'){
            jLabel5.setText("Thông tin không hợp lệ.\nVui lòng kiểm tra lại...");
            jLabel5.setVisible(true);
        }
    }//GEN-LAST:event_tunamKeyPressed

    private void dennamKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dennamKeyPressed
        // TODO add your handling code here:
        //kt những phím nếu nhỏ hơn 0 lơn hơn 9
            if(evt.getKeyChar()<'0' || evt.getKeyChar()>'9'){
            jLabel5.setText("Thông tin không hợp lệ.\nVui lòng kiểm tra lại...");
            jLabel5.setVisible(true);
        }
    }//GEN-LAST:event_dennamKeyPressed

       
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TK;
    private javax.swing.JTextField dennam;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tunam;
    // End of variables declaration//GEN-END:variables
}
