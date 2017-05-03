package productregistration;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import net.proteanit.sql.DbUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tigler
 */
public class KartaPostav extends javax.swing.JFrame {

    private int PK;
    private int addOrUpdate;
    private ListenerCloseForm listenerCloseForm;

    public void setListenerCloseForm(ListenerCloseForm listenerCloseForm) {
        this.listenerCloseForm = listenerCloseForm;
    }

    /**
     * Creates new form KartaPostav
     */
    public KartaPostav(int PK, int addOrUpdate) {
        initComponents();
        this.PK = PK;
        this.addOrUpdate = addOrUpdate;

        jTextFieldFullName.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
                if (str == null) {
                    return;
                }
                if ((getLength() + str.length()) <= 40) {
                    super.insertString(offset, str, attr);
                }
            }
        });
        jTextFieldShortName.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
                if (str == null) {
                    return;
                }
                if ((getLength() + str.length()) <= 30) {
                    super.insertString(offset, str, attr);
                }
            }
        });
        jTextFieldYurAddress.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
                if (str == null) {
                    return;
                }
                if ((getLength() + str.length()) <= 60) {
                    super.insertString(offset, str, attr);
                }
            }
        });
        jTextFieldFactAddress.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
                if (str == null) {
                    return;
                }
                if ((getLength() + str.length()) <= 60) {
                    super.insertString(offset, str, attr);
                }
            }
        });
        jTextFieldTelephone.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
                if (str == null) {
                    return;
                }
                if ((getLength() + str.length()) <= 12) {
                    super.insertString(offset, str, attr);
                }
            }
        });
        jTextFieldEmail.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
                if (str == null) {
                    return;
                }
                if ((getLength() + str.length()) <= 30) {
                    super.insertString(offset, str, attr);
                }
            }
        });
        jTextFieldManager.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
                if (str == null) {
                    return;
                }
                if ((getLength() + str.length()) <= 30) {
                    super.insertString(offset, str, attr);
                }
            }
        });
        jTextFieldDirector.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
                if (str == null) {
                    return;
                }
                if ((getLength() + str.length()) <= 30) {
                    super.insertString(offset, str, attr);
                }
            }
        });
        jTextFieldINN.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
                if (str == null) {
                    return;
                }
                if ((getLength() + str.length()) <= 15) {
                    super.insertString(offset, str, attr);
                }
            }
        });
        jTextFieldNumSchet.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
                if (str == null) {
                    return;
                }
                if ((getLength() + str.length()) <= 15) {
                    super.insertString(offset, str, attr);
                }
            }
        });
        if (addOrUpdate == 1 || addOrUpdate == 2) {
            ResultSet resSet = null;
            try {
                resSet = ProductRegistration.st.executeQuery("select pk_postav,"
                        + " fullname,shortname,yuraddress,factaddress,telephone,email,inn,schet,manager,director"
                        + " from postav where pk_postav=" + PK
                );
                if (resSet.next()) {
                    jTextFieldFullName.setText(resSet.getString(2));
                    jTextFieldShortName.setText(resSet.getString(3));
                    jTextFieldYurAddress.setText(resSet.getString(4));
                    jTextFieldFactAddress.setText(resSet.getString(5));
                    jTextFieldTelephone.setText(resSet.getString(6));
                    jTextFieldEmail.setText(resSet.getString(7));
                    jTextFieldINN.setText(resSet.getString(8));
                    jTextFieldNumSchet.setText(resSet.getString(9));
                    jTextFieldManager.setText(resSet.getString(10));
                    jTextFieldDirector.setText(resSet.getString(11));

                }
                if (addOrUpdate == 2) {
                    jTextFieldFullName.setEditable(false);
                    jTextFieldShortName.setEditable(false);
                    jTextFieldYurAddress.setEditable(false);
                    jTextFieldFactAddress.setEditable(false);
                    jTextFieldTelephone.setEditable(false);
                    jTextFieldEmail.setEditable(false);
                    jTextFieldINN.setEditable(false);
                    jTextFieldNumSchet.setEditable(false);
                    jTextFieldManager.setEditable(false);
                    jTextFieldDirector.setEditable(false);
                }
            } catch (Exception ex) {
                System.out.println(ex);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldFullName = new javax.swing.JTextField();
        jTextFieldShortName = new javax.swing.JTextField();
        jTextFieldYurAddress = new javax.swing.JTextField();
        jTextFieldFactAddress = new javax.swing.JTextField();
        jTextFieldTelephone = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldINN = new javax.swing.JTextField();
        jTextFieldNumSchet = new javax.swing.JTextField();
        jTextFieldManager = new javax.swing.JTextField();
        jTextFieldDirector = new javax.swing.JTextField();
        jButtonOk = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Карта поставщика");

        jLabel1.setText("Полное название");

        jLabel2.setText("Краткое название");

        jLabel3.setText("Юридический адрес");

        jLabel4.setText("Фактический адрес");

        jLabel5.setText("Телефон");

        jLabel6.setText("E-mail");

        jLabel7.setText("ИНН");

        jLabel8.setText("Номер счета");

        jLabel9.setText("Менеджер");

        jTextFieldShortName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldShortNameActionPerformed(evt);
            }
        });

        jLabel10.setText("Руководитель");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldShortName)
                    .addComponent(jTextFieldYurAddress)
                    .addComponent(jTextFieldFactAddress)
                    .addComponent(jTextFieldTelephone)
                    .addComponent(jTextFieldEmail)
                    .addComponent(jTextFieldINN)
                    .addComponent(jTextFieldNumSchet)
                    .addComponent(jTextFieldManager)
                    .addComponent(jTextFieldDirector, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                    .addComponent(jTextFieldFullName))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jButtonOk, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCancel)
                .addGap(83, 83, 83))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel1)
                                            .addComponent(jTextFieldFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2)
                                            .addComponent(jTextFieldShortName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel3))
                                    .addComponent(jTextFieldYurAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jTextFieldFactAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jTextFieldTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7))
                            .addComponent(jTextFieldINN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8))
                    .addComponent(jTextFieldNumSchet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldManager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldDirector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOk)
                    .addComponent(jButtonCancel))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldShortNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldShortNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldShortNameActionPerformed

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed
        // TODO add your handling code here:
        ResultSet resSet = null;
        try {
            String fullname = jTextFieldFullName.getText();
            String shortname = jTextFieldShortName.getText();
            String yur = jTextFieldYurAddress.getText();
            String fact = jTextFieldFactAddress.getText();
            String telephone = jTextFieldTelephone.getText();
            String email = jTextFieldEmail.getText();
            String inn = jTextFieldINN.getText();
            String schet = jTextFieldNumSchet.getText();
            String manager = jTextFieldManager.getText();
            String director = jTextFieldDirector.getText();
            if (fullname.equals("") || shortname.equals("") || yur.equals("") || fact.equals("") || telephone.equals("")
                    || email.equals("") || inn.equals("") || schet.equals("") || manager.equals("") || director.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Сначала необходимо заполнить все поля", "Сообщение", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if (addOrUpdate == 0) {
                try {
                    resSet = ProductRegistration.st.executeQuery("insert into postav "
                            + " (fullname,shortname,yuraddress,factaddress,telephone,email,inn,schet,manager,director)"
                            + " values('" + fullname + "','" + shortname + "','" + yur + "','" + fact
                            + "','" + telephone + "','" + email + "','" + inn + "','" + schet + "','" + manager + "','" + director + "')"
                    );
                    listenerCloseForm.event();
                    JOptionPane.showMessageDialog(rootPane, "Запись о паставщике успешно добавлена", "Сообщение", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    System.out.println(ex);
                    JOptionPane.showMessageDialog(rootPane, "Не удалось добавить запись о поставщике", "Сообщение", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            } else {
                if (addOrUpdate == 2) {
                    this.dispose();
                    return;
                }
                try {
                    resSet = ProductRegistration.st.executeQuery("update postav set "
                            + " fullname='" + fullname + "', shortname='" + shortname + "', yuraddress='" + yur
                            + "', factaddress='" + fact + "', telephone='" + telephone
                            + "', email='" + email + "', inn='" + inn + "', schet='" + schet
                            + "', manager='" + manager + "', director='" + director
                            + "' where pk_postav=" + PK
                    );
                    listenerCloseForm.event();
                    JOptionPane.showMessageDialog(rootPane, "Запись о паставщике успешно изменена", "Сообщение", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    System.out.println(ex);
                    JOptionPane.showMessageDialog(rootPane, "Не удалось изменить запись о поставщике", "Сообщение", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }
            this.dispose();
        } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(rootPane, "Не удалось считать поля", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButtonOkActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

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
            java.util.logging.Logger.getLogger(KartaPostav.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KartaPostav.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KartaPostav.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KartaPostav.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KartaPostav(0, 0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextFieldDirector;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldFactAddress;
    private javax.swing.JTextField jTextFieldFullName;
    private javax.swing.JTextField jTextFieldINN;
    private javax.swing.JTextField jTextFieldManager;
    private javax.swing.JTextField jTextFieldNumSchet;
    private javax.swing.JTextField jTextFieldShortName;
    private javax.swing.JTextField jTextFieldTelephone;
    private javax.swing.JTextField jTextFieldYurAddress;
    // End of variables declaration//GEN-END:variables
}
