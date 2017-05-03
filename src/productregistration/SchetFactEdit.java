/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productregistration;

import com.toedter.calendar.JDateChooser;
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
public class SchetFactEdit extends javax.swing.JFrame implements UpdatesDataInForms {

    /**
     * Creates new form SchetFactEdit
     */
    private int PK;
    private int addOrUpdate;
    private ListenerCloseForm listenerCloseForm;
    private String pkCost;

    ArrayList<String> pkPostav;
    ArrayList<String> valuesPastav;
    String pkSchetFact;

    public void setListenerCloseForm(ListenerCloseForm listenerCloseForm) {
        this.listenerCloseForm = listenerCloseForm;
    }

    @Override
    public void addDataInTable() {
        int pkSF = 0;
        if (addOrUpdate == 0) {
            try {
                ResultSet resSet = ProductRegistration.st.executeQuery("select schetfact_seq.currval from dual"
                );
                if (resSet.next()) {
                    pkSF = Integer.parseInt(resSet.getString(1));
                }
            } catch (Exception ex) {
                System.out.println(ex);
                Logger.getLogger(KartaTovara.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            pkSF = Integer.parseInt(pkSchetFact);
        }

        try {
            ResultSet resSet = ProductRegistration.st.executeQuery("select strfact.pk_strfact,tovar.pk_tovar,"
                    + " tovar.nametovar, strfact.count,tovar.edizmer,cost.zakupka,cost.nds,cost.nacenka  "
                    + " from strfact"
                    + " inner join tovar on tovar.PK_tovar=strfact.PK_tovar"
                    + " inner join cost on cost.PK_cost=tovar.PK_cost"
                    + " where strfact.pk_schetfact=" + pkSF
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

    public SchetFactEdit(int PK, int addOrUpdate) {
        initComponents();
        pkPostav = new ArrayList<>();
        valuesPastav = new ArrayList<>();
        this.PK = PK;
        this.addOrUpdate = addOrUpdate;
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jDateChooserCurDate.setDateFormatString("dd.MM.yyyy");
        jDateChooserCurDate.setDate(new Date());
        JTextFieldDateEditor editor2 = (JTextFieldDateEditor) jDateChooserCurDate.getDateEditor();
        editor2.setEditable(false);
        jDateChooserProv.setDateFormatString("dd.MM.yyyy");
        JTextFieldDateEditor editor1 = (JTextFieldDateEditor) jDateChooserProv.getDateEditor();
        editor1.setEditable(false);
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
                resSet = ProductRegistration.st.executeQuery("select strfact.pk_schetfact,"
                        + " postav.pk_postav,TO_CHAR(schetfact.curdate, 'DD.MM.YYYY'),TO_CHAR(schetfact.provedeno, 'DD.MM.YYYY'),schetfact.num"
                        + " from strfact"
                        + " inner join schetfact on schetfact.PK_schetfact=strfact.PK_schetfact"
                        + " inner join postav on postav.PK_postav=schetfact.PK_postav"
                        + " where strfact.pk_schetfact=" + PK
                );
                if (resSet.next()) {
                    pkSchetFact = resSet.getString(1);
                    String[] curParse = resSet.getString(3).split(" ");
                    String[] provParse = resSet.getString(4).split(" ");
                    jTextFieldNumFact.setText(resSet.getString(5));
                    String[] parseCurDate = curParse[0].split("-");
                    String[] parseProvDate = provParse[0].split("-");
                    Date thedate = new SimpleDateFormat("dd.MM.yyyy").parse(resSet.getString(3));
                    jDateChooserCurDate.setDate(thedate);
                    editor1 = (JTextFieldDateEditor) jDateChooserCurDate.getDateEditor();
                    editor1.setEditable(false);

                    Date thedate1 = new SimpleDateFormat("dd.MM.yyyy").parse(resSet.getString(4));
                    jDateChooserProv.setDate(thedate1);
                    editor2 = (JTextFieldDateEditor) jDateChooserProv.getDateEditor();
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
                resSet = ProductRegistration.st.executeQuery("insert into schetfact (pk_postav) values('0')"
                );
            } catch (Exception ex) {
                System.out.println(ex);
                Logger.getLogger(KartaTovara.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (addOrUpdate == 0) {

                try {
                    resSet = ProductRegistration.st.executeQuery("select schetfact_seq.currval from dual"
                    );
                    if (resSet.next()) {
                        pkSchetFact = resSet.getString(1);
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

        jSeparator2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable( )         {  @Override  public boolean isCellEditable(int row, int column)  {        return false;     }        };
        jButtonAdd = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonOk = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNumFact = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jDateChooserCurDate = new com.toedter.calendar.JDateChooser();
        jSeparator4 = new javax.swing.JSeparator();
        jComboBoxPostav = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jDateChooserProv = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Счет-фактура");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Содержание счет-фактуры"));

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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 949, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonEdit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonDelete)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonOk, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jButtonCancel)
                        .addGap(32, 32, 32))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonAdd)
                    .addComponent(jButtonEdit)
                    .addComponent(jButtonDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOk)
                    .addComponent(jButtonCancel))
                .addContainerGap())
        );

        jLabel1.setText("Счет-фактура №");

        jLabel4.setText("от");

        jLabel2.setText("Проведено");

        jLabel3.setText("Поставщик");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(322, 322, 322)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldNumFact, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooserCurDate, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator4)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxPostav, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChooserProv, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jTextFieldNumFact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(jDateChooserCurDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxPostav, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooserProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed
        try {
            int pkSF = 0;
            Date dateChooserAddDate = jDateChooserCurDate.getDate();
            java.sql.Date curDate = new java.sql.Date(dateChooserAddDate.getTime());

            Date dateChooserAddDate1 = jDateChooserProv.getDate();
            java.sql.Date prov = new java.sql.Date(dateChooserAddDate1.getTime());
            if (addOrUpdate == 0) {

                try {
                    ResultSet resSet = ProductRegistration.st.executeQuery("select schetfact_seq.currval from dual"
                    );
                    if (resSet.next()) {
                        pkSF = Integer.parseInt(resSet.getString(1));
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                    Logger.getLogger(KartaTovara.class.getName()).log(Level.SEVERE, null, ex);
                }

                ResultSet resSet = ProductRegistration.st.executeQuery("update schetfact set curdate=TO_DATE('" + curDate + "', 'YYYY-MM-DD'),"
                        + "provedeno=TO_DATE('" + prov + "', 'YYYY-MM-DD'),pk_postav='" + pkPostav.get(jComboBoxPostav.getSelectedIndex()) + "',num='"+jTextFieldNumFact.getText()+"'"
                        + " where pk_schetfact=" + pkSF
                );
                JOptionPane.showMessageDialog(rootPane, "Счет-фактура успешно добавлена", "Дабавление записи", JOptionPane.INFORMATION_MESSAGE);
            } else {
                ResultSet resSet = ProductRegistration.st.executeQuery("update schetfact set curdate=TO_DATE('" + curDate + "', 'YYYY-MM-DD'),"
                        + "provedeno=TO_DATE('" + prov + "', 'YYYY-MM-DD'),pk_postav='" + pkPostav.get(jComboBoxPostav.getSelectedIndex()) + "',num='"+jTextFieldNumFact.getText()+"'"
                        + " where pk_schetfact=" + pkSchetFact
                );
            }
            listenerCloseForm.event();
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Невозможно добавить счет-фактуру", "Дабавление записи", JOptionPane.ERROR_MESSAGE);
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
        StrSchetFact strSchetFact = new StrSchetFact(-1, 0, Integer.parseInt(pkSchetFact));
        strSchetFact.setListenerCloseForm(new ListenerCloseForm(this));
        strSchetFact.setVisible(true);
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        // TODO add your handling code here:
        if (jTable1.getSelectedRow() != -1) {
            int pk = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
            StrSchetFact strSchetFact = new StrSchetFact(pk, 1, Integer.parseInt(pkSchetFact));
            strSchetFact.setListenerCloseForm(new ListenerCloseForm(this));
            strSchetFact.setVisible(true);
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
                        "Вы уверены, что хотите удалить товар из счет-фактуры?",
                        "Удаление записи",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        new Object[]{"Да", "Нет"},
                        "Да");

                if (result == JOptionPane.YES_OPTION) {
                    resSet = ProductRegistration.st.executeQuery("delete strfact where pk_strfact=" + jTable1.getValueAt(jTable1.getSelectedRow(), 0)
                    );
                    addDataInTable();
                }
            } catch (Exception ex) {
                System.out.println(ex);
                JOptionPane.showMessageDialog(rootPane, "Удаление товара из счет-фактуры не возможно", "Удаление записи", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Выделите строку для удаления товара из счет-фактуры", "Сообщение", JOptionPane.INFORMATION_MESSAGE);
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
                new SchetFactEdit(0, 0).setVisible(true);
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
    private com.toedter.calendar.JDateChooser jDateChooserProv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldNumFact;
    // End of variables declaration//GEN-END:variables

}
