/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productregistration;

import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author tigler
 */
public class SchetFakt extends javax.swing.JFrame implements UpdatesDataInForms {

    @Override
    public void addDataInTable() {
        ResultSet resSet = null;
        try {
            resSet = ProductRegistration.st.executeQuery("select pk_schetfact,schetfact.num,postav.shortname,"
                    + " TO_CHAR(curdate, 'DD.MM.YYYY'),TO_CHAR(provedeno, 'DD.MM.YYYY')"
                    + " from schetfact "
                    + " inner join postav on postav.PK_postav=schetfact.PK_postav"
            );
            jTable1.setModel(DbUtils.resultSetToTableModel(resSet));

        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.addColumn("Сумма");

        try {
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                resSet = ProductRegistration.st.executeQuery("select cost.zakupka,cost.nds,cost.nacenka,strfact.count"
                        + " from strfact "
                        + " inner join schetfact on schetfact.PK_schetfact=strfact.PK_schetfact"
                        + " inner join tovar on tovar.PK_tovar=strfact.PK_tovar"
                        + " inner join cost on cost.PK_cost=tovar.PK_cost"
                        + " where strfact.pk_schetfact=" + jTable1.getValueAt(i, 0)
                );
                double summa = 0;
                while (resSet.next()) {
                    double zakupka = Double.valueOf(resSet.getString(1));
                    double nds = Double.valueOf(resSet.getString(2));
                    double nacenka = Double.valueOf(resSet.getString(3));
                    double snds = zakupka / 100 * nds;
                    double snacenka = zakupka / 100 * nacenka;
                    double itog = zakupka + snds + snacenka;
                    String cost = String.format(Locale.US, "%.2f", itog);
                    summa += Double.valueOf(cost) * Double.valueOf(resSet.getString(4));
                }
                String sum = String.format(Locale.US, "%.2f", summa);
                jTable1.setValueAt(sum, i, 5);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SchetFakt.class.getName()).log(Level.SEVERE, null, ex);
        }

        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);

        jTable1.getColumnModel().getColumn(1).setHeaderValue("Номер");
        jTable1.getColumnModel().getColumn(2).setHeaderValue("Поставщик");
        jTable1.getColumnModel().getColumn(3).setHeaderValue("Дата");
        jTable1.getColumnModel().getColumn(4).setHeaderValue("Проведено");
    }

    /**
     * Creates new form SchetFakt
     */
    public SchetFakt() {
        initComponents();
        addDataInTable();
        jButtonAdd.setToolTipText("Добавление счет-фактуры");
        jButtonEdit.setToolTipText("Изменение счет-фактуры");
        jButtonDelete.setToolTipText("Удаление счет-фактуры");
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTable2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/img/add.png"));
            Image img = icon.getImage();
            Image newimg = img.getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
            jButtonAdd.setIcon(new ImageIcon(newimg));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        try {

            ImageIcon icon = new ImageIcon(getClass().getResource("/img/edit.png"));
            Image img = icon.getImage();
            Image newimg = img.getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
            jButtonEdit.setIcon(new ImageIcon(newimg));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        try {

            ImageIcon icon = new ImageIcon(getClass().getResource("/img/delete.png"));
            Image img = icon.getImage();
            Image newimg = img.getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
            jButtonDelete.setIcon(new ImageIcon(newimg));
        } catch (Exception ex) {
            System.out.println(ex);
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

        jSeparator1 = new javax.swing.JSeparator();
        jButtonAdd = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable( )         {  @Override  public boolean isCellEditable(int row, int column)  {        return false;     }        };
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable( )         {  @Override  public boolean isCellEditable(int row, int column)  {        return false;     }        };
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Счет-фактуры");

        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });

        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Поставщик", "Дата", "Сумма", "Проведено"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Наименование", "Количество", "Ед.измерения", "Цена", "Сумма", "НДС", "Итого"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel1.setText("Содержание счет-фактуры");

        jLabel2.setText("Счет-фактуры");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 909, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonEdit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonDelete))
                            .addComponent(jLabel1))
                        .addContainerGap(701, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonAdd)
                    .addComponent(jButtonEdit)
                    .addComponent(jButtonDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        SchetFactEdit schetFactEdit = new SchetFactEdit(-1, 0);
        schetFactEdit.setListenerCloseForm(new ListenerCloseForm(this));
        schetFactEdit.setVisible(true);
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        // TODO add your handling code here:
         try {
            ResultSet resSet = ProductRegistration.st.executeQuery("select tovar.pk_tovar,"
                    + " tovar.nametovar,strfact.count,tovar.edizmer, cost.zakupka,cost.nds,cost.nacenka"
                    + " from strfact "
                    + " inner join tovar on tovar.PK_tovar=strfact.PK_tovar"
                    + " inner join cost on cost.PK_cost=tovar.PK_cost"
                    + " where pk_schetfact=" + jTable1.getValueAt(jTable1.getSelectedRow(), 0)
            );
            jTable2.setModel(DbUtils.resultSetToTableModel(resSet));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
        dtm.addColumn("Цена");
        dtm.addColumn("Сумма");

        for (int i = 0; i < jTable2.getRowCount(); i++) {
            double zakupka = Double.valueOf(jTable2.getValueAt(i, 4).toString());
            double nds = Double.valueOf(jTable2.getValueAt(i, 5).toString());
            double nacenka = Double.valueOf(jTable2.getValueAt(i, 6).toString());
            double snds = zakupka / 100 * nds;
            double snacenka = zakupka / 100 * nacenka;
            double itog = zakupka + snds + snacenka;
            String cost = String.format(Locale.US, "%.2f", itog);
            String sum = String.format(Locale.US, "%.2f", Double.valueOf(cost) * Double.valueOf(jTable2.getValueAt(i, 2).toString()));
            jTable2.setValueAt(cost, i, 7);
            jTable2.setValueAt(sum, i, 8);
        }

        jTable2.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable2.getColumnModel().getColumn(0).setMinWidth(0);
        jTable2.getColumnModel().getColumn(0).setPreferredWidth(0);

        jTable2.getColumnModel().getColumn(1).setHeaderValue("Наименование");
        jTable2.getColumnModel().getColumn(2).setHeaderValue("Количество");
        jTable2.getColumnModel().getColumn(3).setHeaderValue("Ед.измерения");

        jTable2.getColumnModel().getColumn(4).setMaxWidth(0);
        jTable2.getColumnModel().getColumn(4).setMinWidth(0);
        jTable2.getColumnModel().getColumn(4).setPreferredWidth(0);
        jTable2.getColumnModel().getColumn(5).setMaxWidth(0);
        jTable2.getColumnModel().getColumn(5).setMinWidth(0);
        jTable2.getColumnModel().getColumn(5).setPreferredWidth(0);
        jTable2.getColumnModel().getColumn(6).setMaxWidth(0);
        jTable2.getColumnModel().getColumn(6).setMinWidth(0);
        jTable2.getColumnModel().getColumn(6).setPreferredWidth(0);
    }//GEN-LAST:event_jTable1MousePressed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        // TODO add your handling code here:
        if (jTable1.getSelectedRow() != -1) {
            int pk = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
            SchetFactEdit schetFactEdit = new SchetFactEdit(pk, 1);
            schetFactEdit.setListenerCloseForm(new ListenerCloseForm(this));
            schetFactEdit.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Выделите строку для редактирования счет-фактуры", "Сообщение", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
         if (jTable1.getSelectedRow() != -1) {
            ResultSet resSet = null;
            try {

                int result = JOptionPane.showOptionDialog(
                        null,
                        "Вы уверены, что хотите удалить счет-фактуру?",
                        "Удаление записи",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        new Object[]{"Да", "Нет"},
                        "Да");

                if (result == JOptionPane.YES_OPTION) {
                    resSet = ProductRegistration.st.executeQuery("delete schetfact where pk_schetfact=" + jTable1.getValueAt(jTable1.getSelectedRow(), 0)
                    );
                    addDataInTable();
                }
            } catch (Exception ex) {
                System.out.println(ex);
                JOptionPane.showMessageDialog(rootPane, "Удаление счет-фактуры не возможно", "Удаление записи", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Выделите строку для счет-фактуры товара", "Сообщение", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SchetFakt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SchetFakt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SchetFakt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SchetFakt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SchetFakt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables

}
