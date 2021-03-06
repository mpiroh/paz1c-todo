package sk.upjs.ics.todo;

import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class MainForm extends javax.swing.JFrame {
    
    private UlohaDao ulohaDao = UlohaDaoFactory.INSTANCE.getUlohaDao();

    public MainForm() {
        initComponents();
        refresh();        
    }

    private void refresh() {
        List<Uloha> ulohy = ulohaDao.dajVsetky();
        ulohyList.setListData(ulohy.toArray());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ulohyList = new javax.swing.JList();
        ulohaTextField = new javax.swing.JTextField();
        pridatButton = new javax.swing.JButton();
        terminDatePicker = new org.jdesktop.swingx.JXDatePicker();
        odstranitButton = new javax.swing.JButton();
        hotovoButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ulohyList.setCellRenderer(new UlohaListCellRenderer());
        ulohyList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ulohyListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ulohyList);

        ulohaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ulohaTextFieldActionPerformed(evt);
            }
        });

        pridatButton.setText("Pridať");
        pridatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pridatButtonActionPerformed(evt);
            }
        });

        odstranitButton.setText("Odstraniť");
        odstranitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odstranitButtonActionPerformed(evt);
            }
        });

        hotovoButton.setText("Hotovo!");
        hotovoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hotovoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ulohaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(terminDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pridatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(odstranitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hotovoButton))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ulohaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(terminDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pridatButton)
                    .addComponent(odstranitButton)
                    .addComponent(hotovoButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pridatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pridatButtonActionPerformed
        Uloha uloha = new Uloha();
        
        String nazov = ulohaTextField.getText();
        if(nazov.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Názov je povinný.");
            return;
        }        
        uloha.setNazov(nazov);
        
        Date date = terminDatePicker.getDate();
        if(date == null) {
            date = new Date();
        }
        if(date.before(new Date())) {
            JOptionPane.showMessageDialog(this, "Dátum nesmie byť z minulosti.");
        }
        uloha.setDate(date);
        uloha.setSplnena(false);
        
        ulohaDao.pridat(uloha);
        
        refresh();
    }//GEN-LAST:event_pridatButtonActionPerformed

    private void odstranitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_odstranitButtonActionPerformed
        Uloha uloha = (Uloha) ulohyList.getSelectedValue();
        ulohaDao.odstranit(uloha);
        
        refresh();
    }//GEN-LAST:event_odstranitButtonActionPerformed

    private void hotovoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hotovoButtonActionPerformed
        Uloha uloha = (Uloha) ulohyList.getSelectedValue();
        uloha.setSplnena(true);
        ulohaDao.upravit(uloha);
        
        refresh();
    }//GEN-LAST:event_hotovoButtonActionPerformed

    private void ulohaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ulohaTextFieldActionPerformed
        //-----------------------------------------------------------------
    }//GEN-LAST:event_ulohaTextFieldActionPerformed

    private void ulohyListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ulohyListMouseClicked
        if(evt.getClickCount() == 2) {
            Uloha uloha = (Uloha) ulohyList.getSelectedValue();
            
            UlohaForm ulohaForm = new UlohaForm(this, true, uloha);
            ulohaForm.setVisible(true);
            
            refresh();
        }
    }//GEN-LAST:event_ulohyListMouseClicked


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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton hotovoButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton odstranitButton;
    private javax.swing.JButton pridatButton;
    private org.jdesktop.swingx.JXDatePicker terminDatePicker;
    private javax.swing.JTextField ulohaTextField;
    private javax.swing.JList ulohyList;
    // End of variables declaration//GEN-END:variables
}
