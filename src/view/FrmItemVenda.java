/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.DaoItemVenda;
import dao.DaoProduto;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author ManutencaoEtec
 */
public class FrmItemVenda extends javax.swing.JDialog {

    ArrayList<DaoProduto> pro;
    NumberFormatter nfPreco;
    NumberFormatter nfNumero;
    private static DaoItemVenda itemRetorno;

    /**
     * Creates new form FrmItemVenda
     *
     * @param item
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public FrmItemVenda(DaoItemVenda item) throws SQLException, ClassNotFoundException {
        initComponents();
        //Centrsalizando o form
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width - this.getWidth()) / 2;
        int y = (screen.height - this.getHeight()) / 2;
        setBounds(x, y, this.getWidth(), this.getHeight());
        txtNumVenda.setText(String.valueOf(item.getNumVenda()));
        setModal(true);
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        try {
            DecimalFormat df = new DecimalFormat("R$ #,###,##0.00; -#,###,##0.00");
            nfPreco = new NumberFormatter(df);
            nfPreco.setValueClass(Double.class);
            DecimalFormat dfn = new DecimalFormat("###0");
            nfNumero = new NumberFormatter(dfn);
            nfNumero.setValueClass(Integer.class);
            DefaultFormatterFactory dffQtd = new DefaultFormatterFactory(nfNumero);
            txtQuantidade.setFormatterFactory(dffQtd);
            DaoProduto produto = new DaoProduto();
            pro = new ArrayList<DaoProduto>();
            pro.addAll(produto.Pesquisar());
            cmbProduto.removeAllItems();
            for (DaoProduto prod : pro) {
                cmbProduto.addItem(String.valueOf(prod.getCodProd()));
            }
            if (item.getCodPro() != 0) {
                cmbProduto.setSelectedItem(item.getCodPro());
                txtQuantidade.setValue(item.getQuantidade());
            } else {
                cmbProduto.setSelectedIndex(0);
            }
            setVisible(true);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new SQLException("Ocorreu um erro no form de vendas" + ex.getMessage(), "Erro");
        }
    }

    public static DaoItemVenda showItemVenda(DaoItemVenda item) throws SQLException, ClassNotFoundException {
        FrmItemVenda frmItemVenda = new FrmItemVenda(item);
        return itemRetorno;
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
        txtNumVenda = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtProduto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSubtotal = new javax.swing.JTextField();
        cmbProduto = new javax.swing.JComboBox<>();
        txtQuantidade = new javax.swing.JFormattedTextField();
        btnOk = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Venda");

        txtNumVenda.setEnabled(false);
        txtNumVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumVendaActionPerformed(evt);
            }
        });

        jLabel2.setText("Produto");

        txtProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProdutoActionPerformed(evt);
            }
        });

        jLabel3.setText("Quantidade");

        jLabel4.setText("Preço");

        txtPreco.setEnabled(false);
        txtPreco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrecoFocusLost(evt);
            }
        });
        txtPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecoActionPerformed(evt);
            }
        });

        jLabel5.setText("SubTotal");

        txtSubtotal.setEnabled(false);
        txtSubtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSubtotalActionPerformed(evt);
            }
        });

        cmbProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProdutoActionPerformed(evt);
            }
        });

        txtQuantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtQuantidadeFocusLost(evt);
            }
        });
        txtQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantidadeActionPerformed(evt);
            }
        });

        btnOk.setText("Ok");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
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
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNumVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(txtQuantidade))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5))
                            .addGap(32, 32, 32)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNumVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk)
                    .addComponent(btnCancelar))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNumVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumVendaActionPerformed

    private void txtProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProdutoActionPerformed

    private void txtPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecoActionPerformed

    private void txtSubtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSubtotalActionPerformed

    private void cmbProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProdutoActionPerformed
        try {
            pro.get(cmbProduto.getSelectedIndex()).getDescricao();
                try {
                    txtProduto.setText(pro.get(cmbProduto.getSelectedIndex()).getDescricao());
                    txtQuantidade.setValue(1);
                    txtPreco.setText(nfPreco.valueToString(pro.get(cmbProduto.getSelectedIndex()).getPrecoUnit()));
                    txtSubtotal.setText(nfPreco.valueToString(Integer.parseInt(txtQuantidade.getText()) * pro.get(cmbProduto.getSelectedIndex()).getPrecoUnit()));
                } catch (ArrayIndexOutOfBoundsException ex) {
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro:\nO código digitado não corresponde a um produto cadastrado123\nValor: " + ex.getMessage() + ex.getCause(), "Erro:", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                } catch (Exception ex) {

                }
            
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_cmbProdutoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        itemRetorno = null;
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        itemRetorno = new DaoItemVenda();
        try {
            itemRetorno.setNumVenda(Integer.valueOf(txtNumVenda.getText()));
            itemRetorno.setCodPro(pro.get(cmbProduto.getSelectedIndex()).getCodProd());
            itemRetorno.setDescricao(pro.get(cmbProduto.getSelectedIndex()).getDescricao());
            itemRetorno.setQuantidade(Integer.valueOf(txtQuantidade.getText()));
            itemRetorno.setPrecoUnit(pro.get(cmbProduto.getSelectedIndex()).getPrecoUnit());
            itemRetorno.setSubtotal(Integer.valueOf(txtQuantidade.getText()) * pro.get(cmbProduto.getSelectedIndex()).getPrecoUnit());
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao retornar o novo item para venda\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_btnOkActionPerformed

    private void txtQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantidadeActionPerformed
        try {
            //JOptionPane.showMessageDialog(null, nfPreco.valueToString(Integer.valueOf(txtQuantidade.getText()) * pro.get(cmbProduto.getSelectedIndex()).getPrecoUnit()));
            txtSubtotal.setText(nfPreco.valueToString(Integer.valueOf(txtQuantidade.getText()) * pro.get(cmbProduto.getSelectedIndex()).getPrecoUnit()));
        } catch (ParseException | ArithmeticException ex) {
            txtQuantidade.setValue((Integer) 1);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao calcular o subtotal" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtQuantidadeActionPerformed

    private void txtQuantidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuantidadeFocusLost
        try {
            //JOptionPane.showMessageDialog(null, nfPreco.valueToString(Integer.valueOf(txtQuantidade.getText()) * pro.get(cmbProduto.getSelectedIndex()).getPrecoUnit()));
            txtSubtotal.setText(nfPreco.valueToString(Integer.valueOf(txtQuantidade.getText()) * pro.get(cmbProduto.getSelectedIndex()).getPrecoUnit()));
        } catch (ParseException | ArithmeticException ex) {
            txtQuantidade.setValue((Integer) 1);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao calcular o subtotal" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtQuantidadeFocusLost

    private void txtPrecoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecoFocusLost
        try {
            //JOptionPane.showMessageDialog(null, nfPreco.valueToString(Integer.valueOf(txtQuantidade.getText()) * pro.get(cmbProduto.getSelectedIndex()).getPrecoUnit()));
            txtSubtotal.setText(nfPreco.valueToString(Integer.valueOf(txtQuantidade.getText()) * pro.get(cmbProduto.getSelectedIndex()).getPrecoUnit()));
        } catch (ParseException | ArithmeticException ex) {
            txtQuantidade.setValue((Integer) 1);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao calcular o subtotal" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtPrecoFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnOk;
    private javax.swing.JComboBox<String> cmbProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtNumVenda;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtProduto;
    private javax.swing.JFormattedTextField txtQuantidade;
    private javax.swing.JTextField txtSubtotal;
    // End of variables declaration//GEN-END:variables
}
