/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productregistration;

import java.awt.Image;
import java.sql.ResultSet;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author tigler
 */
public class Tovar extends javax.swing.JFrame implements UpdatesDataInForms {

    @Override
    public void addDataInTable() {
        ResultSet resSet = null;
        try {
            resSet = ProductRegistration.st.executeQuery("select pk_tovar,"
                    + " nametovar,edizmer,ostatok,cost.zakupka,cost.nds,cost.nacenka"
                    + " from tovar "
                    + " inner join cost on cost.PK_cost=tovar.PK_cost"
            );
            jTable1.setModel(DbUtils.resultSetToTableModel(resSet));

        } catch (Exception ex) {
            System.out.println(ex);
        }
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.addColumn("Цена");
        dtm.addColumn("Сумма");
        for (int i = 0; i < jTable1.getRowCount(); i++) {

            double zakupka = Double.valueOf(jTable1.getValueAt(i, 4).toString());
            double nds = Double.valueOf(jTable1.getValueAt(i, 5).toString());
            double nacenka = Double.valueOf(jTable1.getValueAt(i, 6).toString());
            double snds = zakupka / 100 * nds;
            double snacenka = zakupka / 100 * nacenka;
            double itog = zakupka + snds + snacenka;
            String cost = String.format(Locale.US, "%.2f", itog);
            String sum = String.format(Locale.US, "%.2f", Double.valueOf(cost) * Double.valueOf(jTable1.getValueAt(i, 3).toString()));
            jTable1.setValueAt(cost, i, 7);
            jTable1.setValueAt(sum, i, 8);
        }

        jTable1.getColumnModel()
                .getColumn(0).setMaxWidth(0);
        jTable1.getColumnModel()
                .getColumn(0).setMinWidth(0);
        jTable1.getColumnModel()
                .getColumn(0).setPreferredWidth(0);

        jTable1.getColumnModel()
                .getColumn(1).setHeaderValue("Наименование");
        jTable1.getColumnModel()
                .getColumn(2).setHeaderValue("Ед.измерения");
        jTable1.getColumnModel()
                .getColumn(3).setHeaderValue("Остаток");
        jTable1.getColumnModel()
                .getColumn(4).setHeaderValue("Закупочная цена");
        jTable1.getColumnModel()
                .getColumn(5).setHeaderValue("НДС");
        jTable1.getColumnModel()
                .getColumn(6).setHeaderValue("Наценка");

    }

    /**
     * Creates new form Tovar
     */
    public Tovar() {
        initComponents();
        addDataInTable();
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        try {

            ImageIcon icon = new ImageIcon(getClass().getResource("/img/view.png"));
            Image img = icon.getImage();
            Image newimg = img.getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
            jButtonView.setIcon(new ImageIcon(newimg));
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable( )         {  @Override  public boolean isCellEditable(int row, int column)  {        return false;     }        };
        jSeparator1 = new javax.swing.JSeparator();
        jButtonAdd = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonView = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Справочник товаров");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Список товаров"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Название", "Ед.измерения", "Цена"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

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

        jButtonView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonView)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonAdd)
                    .addComponent(jButtonEdit)
                    .addComponent(jButtonDelete)
                    .addComponent(jButtonView))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        // TODO add your handling code here:
        KartaTovara kartaTovara = new KartaTovara(-1, 0);
        kartaTovara.setListenerCloseForm(new ListenerCloseForm(this));
        kartaTovara.setVisible(true);
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        // TODO add your handling code here:
        if (jTable1.getSelectedRow() != -1) {
            int pk = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
            KartaTovara kartaTovara = new KartaTovara(pk, 1);
            kartaTovara.setListenerCloseForm(new ListenerCloseForm(this));
            kartaTovara.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Выделите строку для редактирования карты товара", "Сообщение", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
        if (jTable1.getSelectedRow() != -1) {
            ResultSet resSet = null;
            try {

                int result = JOptionPane.showOptionDialog(
                        null,
                        "Вы уверены, что хотите удалить карту товара?",
                        "Удаление записи",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        new Object[]{"Да", "Нет"},
                        "Да");

                if (result == JOptionPane.YES_OPTION) {
                    resSet = ProductRegistration.st.executeQuery("delete tovar where pk_tovar=" + jTable1.getValueAt(jTable1.getSelectedRow(), 0)
                    );
                    addDataInTable();
                }
            } catch (Exception ex) {
                System.out.println(ex);
                JOptionPane.showMessageDialog(rootPane, "Удаление карты товара не возможно", "Удаление записи", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Выделите строку для удаления карты товара", "Сообщение", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonViewActionPerformed
        // TODO add your handling code here:
        if (jTable1.getSelectedRow() != -1) {
            int pk = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
            KartaTovara kartaTovara = new KartaTovara(pk, 2);
            kartaTovara.setListenerCloseForm(new ListenerCloseForm(this));
            kartaTovara.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Выделите строку для просмотра карты товара", "Сообщение", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButtonViewActionPerformed

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
            java.util.logging.Logger.getLogger(Tovar.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tovar.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tovar.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tovar.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tovar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonView;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}