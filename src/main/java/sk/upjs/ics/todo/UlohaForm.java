package sk.upjs.ics.todo;

import java.awt.Frame;
import java.util.Date;
import javax.swing.JOptionPane;


public class UlohaForm extends javax.swing.JDialog {
    private Uloha uloha;
    private UlohaDao ulohaDao = UlohaDaoFactory.INSTANCE.getUlohaDao();
    
    public UlohaForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    UlohaForm(Frame parent, boolean modal, Uloha uloha) {
        super(parent, modal);
        initComponents();
        
        setLocationRelativeTo(null);
        
        this.uloha = uloha;
        
        nazovTextField.setText(uloha.getNazov());
        terminDatePicker.setDate(uloha.getDate());
        splnenaCheckBox.setSelected(uloha.isSplnena());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nazovTextField = new javax.swing.JTextField();
        nazovLabel = new javax.swing.JLabel();
        terminDatePicker = new org.jdesktop.swingx.JXDatePicker();
        terminLabel = new javax.swing.JLabel();
        splnenaCheckBox = new javax.swing.JCheckBox();
        okButton = new javax.swing.JButton();
        stornoButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        nazovLabel.setText("Úloha:");

        terminLabel.setText("Termín:");

        splnenaCheckBox.setText("Splnená");

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        stornoButton.setText("Storno");
        stornoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stornoButtonActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nazovLabel)
                            .addComponent(terminLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nazovTextField)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(terminDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(splnenaCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(okButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stornoButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nazovTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nazovLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(terminDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(terminLabel)
                    .addComponent(splnenaCheckBox))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(stornoButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        String nazov = nazovTextField.getText();
        if (nazov.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Názov je povinný.");
            return;
        }
        
        Date datum = terminDatePicker.getDate();
        if (datum == null) {
            datum = new Date();
        } else if (datum.before(new Date())) {
            JOptionPane.showMessageDialog(this, "Dátum nesmie byť z minulosti.");
            return;
        }
        
        uloha.setNazov(nazov);
        uloha.setDate(datum);
        uloha.setSplnena(splnenaCheckBox.isSelected());
        
        ulohaDao.upravit(uloha);
        
        setVisible(false);
    }//GEN-LAST:event_okButtonActionPerformed

    private void stornoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stornoButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_stornoButtonActionPerformed


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
            java.util.logging.Logger.getLogger(UlohaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UlohaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UlohaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UlohaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UlohaForm dialog = new UlohaForm(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel nazovLabel;
    private javax.swing.JTextField nazovTextField;
    private javax.swing.JButton okButton;
    private javax.swing.JCheckBox splnenaCheckBox;
    private javax.swing.JButton stornoButton;
    private org.jdesktop.swingx.JXDatePicker terminDatePicker;
    private javax.swing.JLabel terminLabel;
    // End of variables declaration//GEN-END:variables
}
