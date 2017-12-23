/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Transporte.AlgoritmoTransporte;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


public class Main extends javax.swing.JFrame {

    AlgoritmoTransporte met = new AlgoritmoTransporte();
    DefaultTableModel custosModel;
    Integer origem = 0, destino = 0;

    /**
     * Creates new form PruebaP
     */
    public Main() {
        initComponents();
        tbCustos.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));
        JTableHeader th = tbCustos.getTableHeader();
        this.setLocationRelativeTo(null);
        SpinnerNumberModel nm = new SpinnerNumberModel();
        nm.setMinimum(0);
        SpinnerNumberModel Nm = new SpinnerNumberModel();
        nm.setMinimum(0);
        custosModel = (DefaultTableModel) tbCustos.getModel();
        spDestino.setModel(Nm);
        spOrigem.setModel(nm);
        soloNumeros(tbCustos);
    }

    public void soloNumeros(JTable a) {
        a.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != '.') {
                    getToolkit().beep();
                    e.consume();
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PInserirDados = new javax.swing.JPanel();
        PCostos = new javax.swing.JPanel();
        PTbCostos = new javax.swing.JScrollPane();
        tbCustos = new javax.swing.JTable();
        spDestino = new javax.swing.JSpinner();
        spOrigem = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnInserir = new javax.swing.JButton();
        btnResolver = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Programación Lineal - Método de Transporte");

        PInserirDados.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ingreso de Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        PCostos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Matriz de Costos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        tbCustos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tbCustos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        PTbCostos.setViewportView(tbCustos);

        javax.swing.GroupLayout PCostosLayout = new javax.swing.GroupLayout(PCostos);
        PCostos.setLayout(PCostosLayout);
        PCostosLayout.setHorizontalGroup(
            PCostosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PCostosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PTbCostos, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
                .addContainerGap())
        );
        PCostosLayout.setVerticalGroup(
            PCostosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PCostosLayout.createSequentialGroup()
                .addComponent(PTbCostos, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addContainerGap())
        );

        spDestino.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        spDestino.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spDestinoStateChanged(evt);
            }
        });

        spOrigem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        spOrigem.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spOrigemStateChanged(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Origens:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Destinos:");

        btnInserir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnInserir.setText("Criar Tabela");
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });

        btnResolver.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnResolver.setText("Resolver");
        btnResolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResolverActionPerformed(evt);
            }
        });

        btnLimpar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PInserirDadosLayout = new javax.swing.GroupLayout(PInserirDados);
        PInserirDados.setLayout(PInserirDadosLayout);
        PInserirDadosLayout.setHorizontalGroup(
            PInserirDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PInserirDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PInserirDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PCostos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PInserirDadosLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(spOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(spDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnInserir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PInserirDadosLayout.createSequentialGroup()
                        .addComponent(btnResolver, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        PInserirDadosLayout.setVerticalGroup(
            PInserirDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PInserirDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PInserirDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(btnInserir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addComponent(PCostos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PInserirDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLimpar)
                    .addComponent(btnResolver, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        PCostos.getAccessibleContext().setAccessibleName("Matriz de Custos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PInserirDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PInserirDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PInserirDados.getAccessibleContext().setAccessibleName("Inserir dados");
        PInserirDados.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void spDestinoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spDestinoStateChanged
        // TODO add your handling code here:
        destino = (Integer) spDestino.getValue();
        met.setDestino(destino);
    }//GEN-LAST:event_spDestinoStateChanged

    private void spOrigemStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spOrigemStateChanged
        // TODO add your handling code here:
        origem = (Integer) spOrigem.getValue();
        met.setOrigem(origem);
    }//GEN-LAST:event_spOrigemStateChanged

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        if (destino > 0 && origem > 0) {
            //Invocando el método crear tabla del Método del transporte
            met.criarTabela(tbCustos, custosModel);
        } else if (origem <= 0) {
            JOptionPane.showMessageDialog(null, "Deve possuir alguma origem de onde vem os produtos");
        } else if (destino <= 0) {
            JOptionPane.showMessageDialog(null, "Deve possuir algum destino para onde será enviado os produtos");
        }
    }//GEN-LAST:event_btnInserirActionPerformed

    private void btnResolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResolverActionPerformed
        Double[][] custos = new Double[origem][destino];
        
        Integer[][] oferta = new Integer[origem][1], demanda = new Integer[1][destino];
        for (int i = 0; i <= origem; i++) {
            for (int j = 0; j <= destino; j++) {
                if (j < destino && i < origem) {
                    custos[i][j] = (double) tbCustos.getValueAt(i, j+1);
                } else if (j >= destino && i < origem) {
                    oferta[i][0] = (int) tbCustos.getValueAt(i, j+1);
                } else if (j < destino && i == origem) {
                    demanda[0][j] = (int) tbCustos.getValueAt(i, j+1);
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Datos inseridos");
        met.setCustos(custos);
        met.setDemanda(demanda);
        met.setOferta(oferta);
        Solucao sol=new Solucao();
        sol.setVisible(true);
    }//GEN-LAST:event_btnResolverActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimparActionPerformed

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
            javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PCostos;
    private javax.swing.JPanel PInserirDados;
    private javax.swing.JScrollPane PTbCostos;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnResolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSpinner spDestino;
    private javax.swing.JSpinner spOrigem;
    private javax.swing.JTable tbCustos;
    // End of variables declaration//GEN-END:variables
}