/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productregistration;

import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Image;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author tigler
 */
public class TovarCheck extends javax.swing.JFrame implements UpdatesDataInForms {

    private int PK;
    private int addOrUpdate;
    private ListenerCloseForm listenerCloseForm;
    private String pkCost;

    ArrayList<String> pkPostav;
    ArrayList<String> valuesPastav;
    String pkTov;

    public void setListenerCloseForm(ListenerCloseForm listenerCloseForm) {
        this.listenerCloseForm = listenerCloseForm;
    }

    @Override
    public void addDataInTable() {
        int pkSF = 0;
        if (addOrUpdate == 0) {
            try {
                ResultSet resSet = ProductRegistration.st.executeQuery("select tovarcheck_seq.currval from dual"
                );
                if (resSet.next()) {
                    pkSF = Integer.parseInt(resSet.getString(1));
                }
            } catch (Exception ex) {
                System.out.println(ex);
                Logger.getLogger(KartaTovara.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            pkSF = Integer.parseInt(pkTov);
        }

        try {
            ResultSet resSet = ProductRegistration.st.executeQuery("select strcheck.pk_strcheck,tovar.pk_tovar,"
                    + " tovar.nametovar, strcheck.count,tovar.edizmer,cost.zakupka,cost.nds,cost.nacenka  "
                    + " from strcheck"
                    + " inner join tovar on tovar.PK_tovar=strcheck.PK_tovar"
                    + " inner join cost on cost.PK_cost=tovar.PK_cost"
                    + " where strcheck.pk_tovarcheck=" + pkSF
            );
            jTable1.setModel(DbUtils.resultSetToTableModel(resSet));

        } catch (Exception ex) {
            System.out.println(ex);
            Logger.getLogger(KartaTovara.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.addColumn("Цена");
        dtm.addColumn("Сумма");
        for (int i = 0; i < jTable1.getRowCount(); i++) {

            double zakupka = Double.valueOf(jTable1.getValueAt(i, 5).toString());
            double nds = Double.valueOf(jTable1.getValueAt(i, 6).toString());
            double nacenka = Double.valueOf(jTable1.getValueAt(i, 7).toString());
            double snds = zakupka / 100 * nds;
            double snacenka = zakupka / 100 * nacenka;
            double itog = zakupka + snds + snacenka;
            String cost = String.format(Locale.US, "%.2f", itog);
            String sum = String.format(Locale.US, "%.2f", Double.valueOf(cost) * Double.valueOf(jTable1.getValueAt(i, 3).toString()));
            jTable1.setValueAt(cost, i, 8);
            jTable1.setValueAt(sum, i, 9);
        }
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(1).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(1).setMinWidth(0);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(0);

        jTable1.getColumnModel().getColumn(2).setHeaderValue("Наименование");
        jTable1.getColumnModel().getColumn(3).setHeaderValue("Количество");
        jTable1.getColumnModel().getColumn(4).setHeaderValue("Ед.измерения");

        jTable1.getColumnModel().getColumn(5).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(5).setMinWidth(0);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(6).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(6).setMinWidth(0);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(7).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(7).setMinWidth(0);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(0);

    }

    /**
     * Creates new form TovarCheck
     */
    public TovarCheck(int PK, int addOrUpdate) {
        initComponents();
        pkPostav = new ArrayList<>();
        valuesPastav = new ArrayList<>();
        this.PK = PK;
        this.addOrUpdate = addOrUpdate;
        jDateChooserCurDate.setDateFormatString("dd.MM.yyyy");
        jDateChooserCurDate.setDate(new Date());
        JTextFieldDateEditor editor2 = (JTextFieldDateEditor) jDateChooserCurDate.getDateEditor();
        editor2.setEditable(false);
        jDateChooserOtpus.setDateFormatString("dd.MM.yyyy");
        JTextFieldDateEditor editor1 = (JTextFieldDateEditor) jDateChooserOtpus.getDateEditor();
        editor1.setEditable(false);
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

        ResultSet resSet = null;

        if (addOrUpdate == 1 || addOrUpdate == 2) {
            try {
                resSet = ProductRegistration.st.executeQuery("select strcheck.pk_tovarcheck,"
                        + " TO_CHAR(tovarcheck.curdate, 'DD.MM.YYYY'),TO_CHAR(tovarcheck.otpuscheno, 'DD.MM.YYYY')"
                        + " from strcheck"
                        + " inner join tovarcheck on tovarcheck.PK_tovarcheck=strcheck.PK_tovarcheck"
                        + " where strcheck.pk_tovarcheck=" + PK
                );
                if (resSet.next()) {
                    pkTov = resSet.getString(1);
                    String[] curParse = resSet.getString(2).split(" ");
                    String[] provParse = resSet.getString(3).split(" ");

                    String[] parseCurDate = curParse[0].split("-");
                    String[] parseProvDate = provParse[0].split("-");
                    Date thedate = new SimpleDateFormat("dd.MM.yyyy").parse(resSet.getString(2));
                    jDateChooserCurDate.setDate(thedate);
                    editor1 = (JTextFieldDateEditor) jDateChooserCurDate.getDateEditor();
                    editor1.setEditable(false);

                    Date thedate1 = new SimpleDateFormat("dd.MM.yyyy").parse(resSet.getString(3));
                    jDateChooserOtpus.setDate(thedate1);
                    editor2 = (JTextFieldDateEditor) jDateChooserOtpus.getDateEditor();
                    editor2.setEditable(false);
                }
                if (addOrUpdate == 2) {

                }
            } catch (Exception ex) {
                System.out.println(ex);
                Logger.getLogger(KartaTovara.class.getName()).log(Level.SEVERE, null, ex);
            }

            addDataInTable();
        } else {
            try {
                resSet = ProductRegistration.st.executeQuery("insert into tovarcheck (curdate) values(TO_DATE('2017-01-01', 'YYYY-MM-DD'))"
                );
            } catch (Exception ex) {
                System.out.println(ex);
                Logger.getLogger(KartaTovara.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (addOrUpdate == 0) {

                try {
                    resSet = ProductRegistration.st.executeQuery("select tovarcheck_seq.currval from dual"
                    );
                    if (resSet.next()) {
                        pkTov = resSet.getString(1);
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                    Logger.getLogger(KartaTovara.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
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
        jLabel1 = new javax.swing.JLabel();
        jDateChooserCurDate = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jDateChooserOtpus = new com.toedter.calendar.JDateChooser();
        jButtonOk = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Товарный чек");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Содержание чека"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Наименование", "Количество", "Ед.измерения", "Цена", "Сумма", "НДС", "Итого"
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

        jLabel1.setText("Дата");

        jLabel2.setText("Отпущено");

        jButtonOk.setText("Ок");
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Отмена");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonOk, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonCancel)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChooserCurDate, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooserOtpus, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButtonAdd)
                                    .addComponent(jButtonEdit)
                                    .addComponent(jButtonDelete)))
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addComponent(jDateChooserCurDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooserOtpus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancel)
                    .addComponent(jButtonOk))
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed
        // TODO add your handling code here:
        try {
            int pkSF = 0;
            Date dateChooserAddDate = jDateChooserCurDate.getDate();
            java.sql.Date curDate = new java.sql.Date(dateChooserAddDate.getTime());

            Date dateChooserAddDate1 = jDateChooserOtpus.getDate();
            java.sql.Date prov = new java.sql.Date(dateChooserAddDate1.getTime());
            if (addOrUpdate == 0) {

                try {
                    ResultSet resSet = ProductRegistration.st.executeQuery("select tovarcheck_seq.currval from dual"
                    );
                    if (resSet.next()) {
                        pkSF = Integer.parseInt(resSet.getString(1));
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                    Logger.getLogger(KartaTovara.class.getName()).log(Level.SEVERE, null, ex);
                }

                ResultSet resSet = ProductRegistration.st.executeQuery("update tovarcheck set curdate=TO_DATE('" + curDate + "', 'YYYY-MM-DD'),"
                        + "otpuscheno=TO_DATE('" + prov + "', 'YYYY-MM-DD')"
                        + " where pk_tovarcheck=" + pkSF
                );
                JOptionPane.showMessageDialog(rootPane, "Товарный чек успешно добавлен", "Дабавление записи", JOptionPane.INFORMATION_MESSAGE);
            } else {
                ResultSet resSet = ProductRegistration.st.executeQuery("update tovarcheck set curdate=TO_DATE('" + curDate + "', 'YYYY-MM-DD'),"
                        + "otpuscheno=TO_DATE('" + prov + "', 'YYYY-MM-DD')"
                        + " where pk_tovarcheck=" + pkTov
                );
            }
            listenerCloseForm.event();
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Невозможно добавить товарный чек", "Дабавление записи", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);
            Logger.getLogger(KartaTovara.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonOkActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        // TODO add your handling code here:
        TovarStrCheck tovarStrCheck = new TovarStrCheck(-1, 0, Integer.parseInt(pkTov));
        tovarStrCheck.setListenerCloseForm(new ListenerCloseForm(this));
        tovarStrCheck.setVisible(true);
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        // TODO add your handling code here:
        if (jTable1.getSelectedRow() != -1) {
            int pk = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
            TovarStrCheck tovarStrCheck = new TovarStrCheck(pk, 1, Integer.parseInt(pkTov));
            tovarStrCheck.setListenerCloseForm(new ListenerCloseForm(this));
            tovarStrCheck.setVisible(true);
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
                        "Вы уверены, что хотите удалить товар из товарного чека?",
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
                JOptionPane.showMessageDialog(rootPane, "Удаление товара из товарного чека не возможно", "Удаление записи", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Выделите строку для удаления товара из товарного чека", "Сообщение", JOptionPane.INFORMATION_MESSAGE);
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
            java.util.logging.Logger.getLogger(TovarCheck.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TovarCheck.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TovarCheck.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TovarCheck.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TovarCheck(0, 0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonOk;
    private com.toedter.calendar.JDateChooser jDateChooserCurDate;
    private com.toedter.calendar.JDateChooser jDateChooserOtpus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
