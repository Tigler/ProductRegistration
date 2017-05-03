/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productregistration;

import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author tigler
 */
public class Main extends javax.swing.JFrame implements UpdatesDataInForms {

    @Override
    public void addDataInTable() {
        ResultSet resSet = null;
        try {
            resSet = ProductRegistration.st.executeQuery("select tovarcheck.pk_tovarcheck,"
                    + " TO_CHAR(tovarcheck.curdate, 'DD.MM.YYYY'),TO_CHAR(tovarcheck.otpuscheno, 'DD.MM.YYYY')"
                    + " from tovarcheck "
            );
            jTable1.setModel(DbUtils.resultSetToTableModel(resSet));

        } catch (Exception ex) {
            System.out.println(ex);
        }
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.addColumn("Сумма");

        try {
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                resSet = ProductRegistration.st.executeQuery("select cost.zakupka,cost.nds,cost.nacenka,strcheck.count"
                        + " from strcheck "
                        + " inner join tovarcheck on tovarcheck.PK_tovarcheck=strcheck.PK_tovarcheck"
                        + " inner join tovar on tovar.PK_tovar=strcheck.PK_tovar"
                        + " inner join cost on cost.PK_cost=tovar.PK_cost"
                        + " where tovarcheck.pk_tovarcheck=" + jTable1.getValueAt(i, 0)
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
                jTable1.setValueAt(sum, i, 3);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);

        jTable1.getColumnModel().getColumn(1).setHeaderValue("Дата");
        jTable1.getColumnModel().getColumn(2).setHeaderValue("Отпущено");
    }

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        jButtonAdd.setToolTipText("Добавление товарного чека");
        jButtonEdit.setToolTipText("Изменение товарного чека");
        jButtonDelete.setToolTipText("Удаление товарного чека");
        jButtonPrint.setToolTipText("Печать товарного чека");
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTable2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        addDataInTable();
        
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

            ImageIcon icon = new ImageIcon(getClass().getResource("/img/printer.png"));
            Image img = icon.getImage();
            Image newimg = img.getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
            jButtonPrint.setIcon(new ImageIcon(newimg));
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

        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable( )         {  @Override  public boolean isCellEditable(int row, int column)  {        return false;     }        };
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable( )         {  @Override  public boolean isCellEditable(int row, int column)  {        return false;     }        };
        jButtonAdd = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonPrint = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItemTovars = new javax.swing.JMenuItem();
        jMenuItemPostav = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemSchetFact = new javax.swing.JMenuItem();
        jMenuItemAktVozvrat = new javax.swing.JMenuItem();
        jMenuUchet = new javax.swing.JMenu();
        jMenuItemProdTovar = new javax.swing.JMenuItem();
        jMenuItemCountTovar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Учет и реализация товаров");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Дата", "Сумма", "Отпущено"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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
                "Наименование", "Количество", "Ед.Измерения", "Цена", "Сумма", "НДС", "Итого"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

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

        jButtonPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrintActionPerformed(evt);
            }
        });

        jLabel1.setText("Товарные чеки");

        jLabel2.setText("Содержание чека");

        jMenu3.setText("Справочники");

        jMenuItemTovars.setText("Товары");
        jMenuItemTovars.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTovarsActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemTovars);

        jMenuItemPostav.setText("Поставщики");
        jMenuItemPostav.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPostavActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemPostav);

        jMenuBar1.add(jMenu3);

        jMenu1.setText("Документы");

        jMenuItemSchetFact.setText("Счет-фактуры");
        jMenuItemSchetFact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSchetFactActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemSchetFact);

        jMenuItemAktVozvrat.setText("Акты возврата");
        jMenuItemAktVozvrat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAktVozvratActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemAktVozvrat);

        jMenuBar1.add(jMenu1);

        jMenuUchet.setText("Отчеты");
        jMenuUchet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuUchetMousePressed(evt);
            }
        });

        jMenuItemProdTovar.setText("О продажах");
        jMenuItemProdTovar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemProdTovarActionPerformed(evt);
            }
        });
        jMenuUchet.add(jMenuItemProdTovar);

        jMenuItemCountTovar.setText("О количестве товарах");
        jMenuItemCountTovar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCountTovarActionPerformed(evt);
            }
        });
        jMenuUchet.add(jMenuItemCountTovar);

        jMenuBar1.add(jMenuUchet);

        jMenu2.setText("Справка");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu2MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonEdit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonPrint)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdd)
                    .addComponent(jButtonEdit)
                    .addComponent(jButtonDelete)
                    .addComponent(jButtonPrint))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemTovarsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTovarsActionPerformed
        Tovar tovar = new Tovar();
        tovar.setVisible(true);
    }//GEN-LAST:event_jMenuItemTovarsActionPerformed

    private void jMenuItemSchetFactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSchetFactActionPerformed
        SchetFakt schetFakt = new SchetFakt();
        schetFakt.setVisible(true);
    }//GEN-LAST:event_jMenuItemSchetFactActionPerformed

    private void jMenuItemAktVozvratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAktVozvratActionPerformed
        AktVozvrat aktVozvrat = new AktVozvrat();
        aktVozvrat.setVisible(true);
    }//GEN-LAST:event_jMenuItemAktVozvratActionPerformed

    private void jMenuItemPostavActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPostavActionPerformed
        Postav postav = new Postav();
        postav.setVisible(true);
    }//GEN-LAST:event_jMenuItemPostavActionPerformed

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        // TODO add your handling code here:
        try {
            ResultSet resSet = ProductRegistration.st.executeQuery("select tovar.pk_tovar,"
                    + " tovar.nametovar,strcheck.count,tovar.edizmer, cost.zakupka,cost.nds,cost.nacenka"
                    + " from strcheck "
                    + " inner join tovar on tovar.PK_tovar=strcheck.PK_tovar"
                    + " inner join cost on cost.PK_cost=tovar.PK_cost"
                    + " where pk_tovarcheck=" + jTable1.getValueAt(jTable1.getSelectedRow(), 0)
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

    private void jButtonPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrintActionPerformed
        // TODO add your handling code here:
        if (jTable1.getRowCount() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Выделите строку товарного чека для печати", "Печать чека", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        //DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        String reportDateStart = jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString();
        String reportDateEnd = jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString();
        try {
            boolean complete = jTable2.print(JTable.PrintMode.FIT_WIDTH,
                    new MessageFormat("Дата: " + reportDateStart + ". Отпущено:" + reportDateEnd),
                    new MessageFormat("Страница {0,number,integer}"));
        } catch (Exception p) {
            /* Printing failed, report to the user */
            JOptionPane.showMessageDialog(rootPane, "Невозможно напечатать", "Печать чека", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonPrintActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        // TODO add your handling code here:
        TovarCheck tovarCheck = new TovarCheck(-1, 0);
        tovarCheck.setListenerCloseForm(new ListenerCloseForm(this));
        tovarCheck.setVisible(true);
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        // TODO add your handling code here:
        if (jTable1.getSelectedRow() != -1) {
            int pk = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
            TovarCheck tovarCheck = new TovarCheck(pk, 1);
            tovarCheck.setListenerCloseForm(new ListenerCloseForm(this));
            tovarCheck.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Выделите строку для редактирования товарного чека", "Сообщение", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
        if (jTable1.getSelectedRow() != -1) {
            ResultSet resSet = null;
            try {

                int result = JOptionPane.showOptionDialog(
                        null,
                        "Вы уверены, что хотите удалить товарный чек?",
                        "Удаление записи",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        new Object[]{"Да", "Нет"},
                        "Да");

                if (result == JOptionPane.YES_OPTION) {
                    resSet = ProductRegistration.st.executeQuery("delete tovarcheck where pk_tovarcheck=" + jTable1.getValueAt(jTable1.getSelectedRow(), 0)
                    );
                    addDataInTable();
                }
            } catch (Exception ex) {
                System.out.println(ex);
                JOptionPane.showMessageDialog(rootPane, "Удаление товарного чека не возможно", "Удаление записи", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Выделите строку для удаления товарного чека", "Удаление записи", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jMenu2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MousePressed
        // TODO add your handling code here:
        About about = new About();
        about.setVisible(true);
    }//GEN-LAST:event_jMenu2MousePressed

    private void jMenuUchetMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuUchetMousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenuUchetMousePressed

    private void jMenuItemCountTovarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCountTovarActionPerformed
        // TODO add your handling code here:
        Uchet uchet = new Uchet();
        uchet.setVisible(true);
    }//GEN-LAST:event_jMenuItemCountTovarActionPerformed

    private void jMenuItemProdTovarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemProdTovarActionPerformed
        // TODO add your handling code here:
        ProdTovar prodTovar = new ProdTovar();
        prodTovar.setVisible(true);
    }//GEN-LAST:event_jMenuItemProdTovarActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonPrint;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItemAktVozvrat;
    private javax.swing.JMenuItem jMenuItemCountTovar;
    private javax.swing.JMenuItem jMenuItemPostav;
    private javax.swing.JMenuItem jMenuItemProdTovar;
    private javax.swing.JMenuItem jMenuItemSchetFact;
    private javax.swing.JMenuItem jMenuItemTovars;
    private javax.swing.JMenu jMenuUchet;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
