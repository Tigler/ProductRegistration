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
public class AktVozvratEdit extends javax.swing.JFrame implements UpdatesDataInForms {

    private int PK;
    private int addOrUpdate;
    private ListenerCloseForm listenerCloseForm;
    private String pkCost;

    ArrayList<String> pkPostav;
    ArrayList<String> valuesPastav;
    String pkAkt;

    public void setListenerCloseForm(ListenerCloseForm listenerCloseForm) {
        this.listenerCloseForm = listenerCloseForm;
    }

    @Override
    public void addDataInTable() {
        int pkAk = 0;
        if (addOrUpdate == 0) {
            try {
                ResultSet resSet = ProductRegistration.st.executeQuery("select aktvozvrat_seq.currval from dual"
                );
                if (resSet.next()) {
                    pkAk = Integer.parseInt(resSet.getString(1));
                }
            } catch (Exception ex) {
                System.out.println(ex);
                Logger.getLogger(KartaTovara.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            pkAk = PK;
        }

        try {
            ResultSet resSet = ProductRegistration.st.executeQuery("select strvozvrat.pk_stract,tovar.pk_tovar,"
                    + " tovar.nametovar, strvozvrat.count,tovar.edizmer,cost.zakupka,cost.nds,cost.nacenka  "
                    + " from strvozvrat"
                    + " inner join tovar on tovar.PK_tovar=strvozvrat.pk_tovar"
                    + " inner join cost on cost.PK_cost=tovar.PK_cost"
                    + " where strvozvrat.pk_actvozvrat=" + pkAk
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
     * Creates new form SchetFactEdit
     */
    public AktVozvratEdit(int PK, int addOrUpdate) {
        initComponents();
        pkPostav = new ArrayList<>();
        valuesPastav = new ArrayList<>();
        this.PK = PK;
        this.addOrUpdate = addOrUpdate;
        jDateChooserCurDate.setDateFormatString("dd.MM.yyyy");
        jDateChooserCurDate.setDate(new Date());
        JTextFieldDateEditor editor2 = (JTextFieldDateEditor) jDateChooserCurDate.getDateEditor();
        editor2.setEditable(false);
        jDateChooserOfor.setDateFormatString("dd.MM.yyyy");
        JTextFieldDateEditor editor1 = (JTextFieldDateEditor) jDateChooserOfor.getDateEditor();
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
        try {
            resSet = ProductRegistration.st.executeQuery("select pk_postav,"
                    + " postav.shortname from postav"
            );
            while (resSet.next()) {
                pkPostav.add(resSet.getString(1));
                valuesPastav.add(resSet.getString(2));
            }
            jComboBoxPostav.setModel(new DefaultComboBoxModel(valuesPastav.toArray()));
            jComboBoxPostav.setSelectedIndex(-1);
        } catch (Exception ex) {
            System.out.println(ex);
            Logger.getLogger(KartaTovara.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (addOrUpdate == 1 || addOrUpdate == 2) {
            try {
                resSet = ProductRegistration.st.executeQuery("select strvozvrat.pk_stract,"
                        + " postav.pk_postav,TO_CHAR(aktvozvrat.curdate, 'DD.MM.YYYY'),TO_CHAR(aktvozvrat.oformlen, 'DD.MM.YYYY'),aktvozvrat.num"
                        + " from strvozvrat"
                        + " inner join aktvozvrat on aktvozvrat.PK_aktvozvrat=strvozvrat.PK_actvozvrat"
                        + " inner join postav on postav.PK_postav=aktvozvrat.PK_postav"
                        + " where strvozvrat.pk_actvozvrat=" + PK
                );
                if (resSet.next()) {
                    pkAkt = resSet.getString(1);
                    String[] curParse = resSet.getString(3).split(" ");
                    String[] provParse = resSet.getString(4).split(" ");
                    jTextField1.setText(resSet.getString(5));

                    String[] parseCurDate = curParse[0].split("-");
                    String[] parseProvDate = provParse[0].split("-");
                    Date thedate = new SimpleDateFormat("dd.MM.yyyy").parse(resSet.getString(3));
                    jDateChooserCurDate.setDate(thedate);
                    editor1 = (JTextFieldDateEditor) jDateChooserCurDate.getDateEditor();
                    editor1.setEditable(false);

                    Date thedate1 = new SimpleDateFormat("dd.MM.yyyy").parse(resSet.getString(4));
                    jDateChooserOfor.setDate(thedate1);
                    editor2 = (JTextFieldDateEditor) jDateChooserOfor.getDateEditor();
                    editor2.setEditable(false);

                    for (int i = 0; i < pkPostav.size(); i++) {
                        if (pkPostav.get(i).equals(resSet.getString(2))) {
                            jComboBoxPostav.setSelectedIndex(i);
                            break;
                        }
                    }
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
                resSet = ProductRegistration.st.executeQuery("insert into aktvozvrat (pk_postav) values('0')"
                );
            } catch (Exception ex) {
                System.out.println(ex);
                Logger.getLogger(KartaTovara.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (addOrUpdate == 0) {

                try {
                    resSet = ProductRegistration.st.executeQuery("select aktvozvrat_seq.currval from dual"
                    );
                    if (resSet.next()) {
                        this.pkAkt = resSet.getString(1);
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
        jButtonAdd = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonOk = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jDateChooserCurDate = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jComboBoxPostav = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jDateChooserOfor = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Акт возврата");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Содержание акта возврата"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Наименование", "Количество", "Ед.измерения", "Цена", "Сумма"
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

        jButtonOk.setText("Ok");
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
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonDelete)
                        .addGap(601, 817, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonOk, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(jButtonCancel)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonAdd)
                    .addComponent(jButtonEdit)
                    .addComponent(jButtonDelete))
                .addGap(15, 15, 15)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOk)
                    .addComponent(jButtonCancel))
                .addContainerGap())
        );

        jLabel1.setText("Акт возврата №");

        jLabel4.setText("от");

        jLabel2.setText("Оформлено");

        jLabel3.setText("Поставщик");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(351, 351, 351)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChooserCurDate, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxPostav, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChooserOfor, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel4)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooserCurDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxPostav, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jDateChooserOfor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed
        // TODO add your handling code here:
        try {
            int pkAk = 0;
            Date dateChooserAddDate = jDateChooserCurDate.getDate();
            java.sql.Date curDate = new java.sql.Date(dateChooserAddDate.getTime());

            Date dateChooserAddDate1 = jDateChooserOfor.getDate();
            java.sql.Date prov = new java.sql.Date(dateChooserAddDate1.getTime());
            if (addOrUpdate == 0) {

                try {
                    ResultSet resSet = ProductRegistration.st.executeQuery("select aktvozvrat_seq.currval from dual"
                    );
                    if (resSet.next()) {
                        pkAk = Integer.parseInt(resSet.getString(1));
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                    Logger.getLogger(KartaTovara.class.getName()).log(Level.SEVERE, null, ex);
                }

                ResultSet resSet = ProductRegistration.st.executeQuery("update aktvozvrat set curdate=TO_DATE('" + curDate + "', 'YYYY-MM-DD'),"
                        + "oformlen=TO_DATE('" + prov + "', 'YYYY-MM-DD'),pk_postav='" + pkPostav.get(jComboBoxPostav.getSelectedIndex()) + "',num='"+jTextField1.getText()+"'"
                        + " where pk_aktvozvrat=" + pkAk
                );
                JOptionPane.showMessageDialog(rootPane, "Акт возврата успешно добавлен", "Дабавление записи", JOptionPane.INFORMATION_MESSAGE);
            } else {
                ResultSet resSet = ProductRegistration.st.executeQuery("update aktvozvrat set curdate=TO_DATE('" + curDate + "', 'YYYY-MM-DD'),"
                        + "oformlen=TO_DATE('" + prov + "', 'YYYY-MM-DD'),pk_postav='" + pkPostav.get(jComboBoxPostav.getSelectedIndex()) + "',num='"+jTextField1.getText()+"'"
                        + " where pk_aktvozvrat=" + PK
                );
            }
            listenerCloseForm.event();
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Невозможно добавить акт возврата", "Дабавление записи", JOptionPane.ERROR_MESSAGE);
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
        StrAkt strAkt = new StrAkt(-1, 0, Integer.parseInt(pkAkt));
        strAkt.setListenerCloseForm(new ListenerCloseForm(this));
        strAkt.setVisible(true);
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        // TODO add your handling code here:
        if (jTable1.getSelectedRow() != -1) {
            int pk = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
            StrAkt strAkt = new StrAkt(pk, 1, Integer.parseInt(pkAkt));
            strAkt.setListenerCloseForm(new ListenerCloseForm(this));
            strAkt.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Выделите строку для редактирования акта возврата", "Сообщение", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
        if (jTable1.getSelectedRow() != -1) {
            ResultSet resSet = null;
            try {

                int result = JOptionPane.showOptionDialog(
                        null,
                        "Вы уверены, что хотите удалить товар из акта возврата?",
                        "Удаление записи",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        new Object[]{"Да", "Нет"},
                        "Да");

                if (result == JOptionPane.YES_OPTION) {
                    resSet = ProductRegistration.st.executeQuery("delete strvozvrat where pk_strvozvrat=" + jTable1.getValueAt(jTable1.getSelectedRow(), 0)
                    );
                    addDataInTable();
                }
            } catch (Exception ex) {
                System.out.println(ex);
                JOptionPane.showMessageDialog(rootPane, "Удаление товара из акта возврата не возможно", "Удаление записи", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Выделите строку для удаления товара из акта возврата", "Сообщение", JOptionPane.INFORMATION_MESSAGE);
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
            java.util.logging.Logger.getLogger(SchetFactEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SchetFactEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SchetFactEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SchetFactEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AktVozvratEdit(0, 0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JComboBox<String> jComboBoxPostav;
    private com.toedter.calendar.JDateChooser jDateChooserCurDate;
    private com.toedter.calendar.JDateChooser jDateChooserOfor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
