/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import dao.ProdutosDAO;
import entidade.Produtos;
import apoio.Formatador;
import java.awt.Color;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author gabriel.ferreira1
 */
public class IfrProdutos extends javax.swing.JInternalFrame {

    int codigo = 0;
    Formatador formatador = new Formatador();

    /**
     * Creates new form IfrProdutos
     */
    public IfrProdutos() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfdDescricao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfdValorCompra = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfdSituacao = new javax.swing.JTextField();
        tfdQuantidade = new javax.swing.JFormattedTextField();
        tfdValorVenda = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        tfdCriterioPesquisa = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();

        setMaximizable(true);
        setTitle("Cadastro de Produtos");

        jLabel1.setText("Descrição:");

        jLabel3.setText("Valor de Compra:");

        tfdValorCompra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfdValorCompraFocusLost(evt);
            }
        });
        tfdValorCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfdValorCompraKeyReleased(evt);
            }
        });

        jLabel2.setText("Valor de Venda:");

        jLabel5.setText("Quantidade:");

        jLabel6.setText("Situação:");

        tfdQuantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfdQuantidadeFocusLost(evt);
            }
        });

        tfdValorVenda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfdValorVendaFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfdDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(tfdQuantidade, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tfdValorCompra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfdDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfdValorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfdValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfdQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfdSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(119, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cadastro", jPanel1);

        jLabel4.setText("Critério");

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblProdutos);

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Search-32.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfdCriterioPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdCriterioPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Consulta", jPanel2);

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Delete-32.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setMaximumSize(new java.awt.Dimension(115, 57));
        btnExcluir.setMinimumSize(new java.awt.Dimension(115, 57));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Application-32.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setMaximumSize(new java.awt.Dimension(115, 57));
        btnEditar.setMinimumSize(new java.awt.Dimension(115, 57));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Select-48.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Ball-standby-48.png"))); // NOI18N
        btnFechar.setText("Fechar");
        btnFechar.setMaximumSize(new java.awt.Dimension(115, 57));
        btnFechar.setMinimumSize(new java.awt.Dimension(115, 57));
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        Produtos produtinho = new Produtos();

        produtinho.setProduto_id(codigo);
        
        if (tfdDescricao.getText().equals("")) {

                JOptionPane.showMessageDialog(null, "O campo descrição é obrigatório, favor preencher.", "Aviso", JOptionPane.WARNING_MESSAGE);
                //tfdDescricao.setBackground(Color.GRAY);
                //tfdDescricao.setForeground(Color.white);
                //tfdDescricao.requestFocus();
                return;
            } else {
                produtinho.setDescricao(tfdDescricao.getText());
                //.setBackground(Color.GRAY);
                //tfdDescricao.setForeground(Color.white);
            }

            if (tfdValorCompra.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "O campo valor de compra é obrigatório, favor preencher.", "Aviso", JOptionPane.WARNING_MESSAGE);
                //tfdValorCompra.setBackground(Color.GRAY);
                //tfdValorCompra.setForeground(Color.white);
                tfdValorCompra.requestFocus();
                return;
            } else {

                String vCompra = tfdValorCompra.getText().replace(",", ".");
                double numeroConvertido = Double.parseDouble(vCompra);
                String valorFormatado = new DecimalFormat("###0.00").format(numeroConvertido);
                tfdValorCompra.setText(valorFormatado);
                produtinho.setValorcompra(formatador.ConverterVirgulaParaPonto(tfdValorCompra.getText()));
            }

            if (tfdValorVenda.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "O campo valor de venda é obrigatório, favor preencher.", "Aviso", JOptionPane.WARNING_MESSAGE);
                //tfdValorVenda.setBackground(Color.GRAY);
                //tfdValorVenda.setForeground(Color.white);
                tfdValorVenda.requestFocus();
                return;
            } else {

                String vVenda = tfdValorVenda.getText().replace(",", ".");
                double numeroConvertido = Double.parseDouble(vVenda);
                String valorFormatado = new DecimalFormat("###0.00").format(numeroConvertido);
                tfdValorVenda.setText(valorFormatado);
                produtinho.setValorvenda(formatador.ConverterVirgulaParaPonto(tfdValorVenda.getText()));

            }

            if (tfdQuantidade.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "O campo quantidade é obrigatório, favor preencher.", "Aviso", JOptionPane.WARNING_MESSAGE);
                //tfdQuantidade.setBackground(Color.GRAY);
                //tfdQuantidade.setForeground(Color.white);
                tfdQuantidade.requestFocus();
                return;
            } else {

                String vQuantidade = tfdQuantidade.getText().replace(",", ".");
                double numeroConvertido = Double.parseDouble(vQuantidade);
                String valorFormatado = new DecimalFormat("###0.00").format(numeroConvertido);
                tfdQuantidade.setText(valorFormatado);
                produtinho.setQuantidade(formatador.ConverterVirgulaParaPonto(tfdQuantidade.getText()));
            }

            if (tfdSituacao.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "O campo situação é obrigatório, favor preencher.", "Aviso", JOptionPane.WARNING_MESSAGE);
                //tfdSituacao.setBackground(Color.GRAY);
                //tfdSituacao.setBackground(Color.white);
                tfdSituacao.requestFocus();
                return;
            } else {
                String temp = tfdSituacao.getText();
                tfdSituacao.setText(temp.toUpperCase());
                produtinho.setSituacao(tfdSituacao.getText().charAt(0));
            }
       
        produtinho.setSituacao(tfdSituacao.getText().charAt(0));
        ProdutosDAO produtosDAO = new ProdutosDAO();

        String retorno = null;

        if (codigo == 0) {

            if (tfdDescricao.getText().equals("")) {

                JOptionPane.showMessageDialog(null, "O campo descrição é obrigatório, favor preencher.", "Aviso", JOptionPane.WARNING_MESSAGE);
                tfdDescricao.setBackground(Color.GRAY);
                //tfdDescricao.setForeground(Color.white);
                //tfdDescricao.requestFocus();
                return;
            } else {
                produtinho.setDescricao(tfdDescricao.getText());
                //.setBackground(Color.GRAY);
                //tfdDescricao.setForeground(Color.white);
            }

            if (tfdValorCompra.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "O campo valor de compra é obrigatório, favor preencher.", "Aviso", JOptionPane.WARNING_MESSAGE);
                //tfdValorCompra.setBackground(Color.GRAY);
                //tfdValorCompra.setForeground(Color.white);
                tfdValorCompra.requestFocus();
                return;
            } else {

                String vCompra = tfdValorCompra.getText().replace(",", ".");
                double numeroConvertido = Double.parseDouble(vCompra);
                String valorFormatado = new DecimalFormat("###0.00").format(numeroConvertido);
                tfdValorCompra.setText(valorFormatado);
                produtinho.setValorcompra(formatador.ConverterVirgulaParaPonto(tfdValorCompra.getText()));
            }

            if (tfdValorVenda.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "O campo valor de venda é obrigatório, favor preencher.", "Aviso", JOptionPane.WARNING_MESSAGE);
                //tfdValorVenda.setBackground(Color.GRAY);
                //tfdValorVenda.setForeground(Color.white);
                tfdValorVenda.requestFocus();
                return;
            } else {

                String vVenda = tfdValorVenda.getText().replace(",", ".");
                double numeroConvertido = Double.parseDouble(vVenda);
                String valorFormatado = new DecimalFormat("###0.00").format(numeroConvertido);
                tfdValorVenda.setText(valorFormatado);
                produtinho.setValorvenda(formatador.ConverterVirgulaParaPonto(tfdValorVenda.getText()));

            }

            if (tfdQuantidade.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "O campo quantidade é obrigatório, favor preencher.", "Aviso", JOptionPane.WARNING_MESSAGE);
                //tfdQuantidade.setBackground(Color.GRAY);
                //tfdQuantidade.setForeground(Color.white);
                tfdQuantidade.requestFocus();
                return;
            } else {

                String vQuantidade = tfdQuantidade.getText().replace(",", ".");
                double numeroConvertido = Double.parseDouble(vQuantidade);
                String valorFormatado = new DecimalFormat("###0.00").format(numeroConvertido);
                tfdQuantidade.setText(valorFormatado);
                produtinho.setQuantidade(formatador.ConverterVirgulaParaPonto(tfdQuantidade.getText()));
            }

            if (tfdSituacao.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "O campo situação é obrigatório, favor preencher.", "Aviso", JOptionPane.WARNING_MESSAGE);
                //tfdSituacao.setBackground(Color.GRAY);
                //tfdSituacao.setBackground(Color.white);
                tfdSituacao.requestFocus();
                return;
            } else {
                String temp = tfdSituacao.getText();
                tfdSituacao.setText(temp.toUpperCase());
                produtinho.setSituacao(tfdSituacao.getText().charAt(0));
            }

            // salvar = inserir
            retorno = produtosDAO.salvar(produtinho);
            JOptionPane.showMessageDialog(null, "Registro salvo com sucesso.");

        } else {
            // atualizar = update
            retorno = produtosDAO.atualizar(produtinho);
            JOptionPane.showMessageDialog(null, "Registro salvo com sucesso.");
        }

        if (retorno == null) {

            // limpar campos
            tfdDescricao.setText("");
            tfdValorCompra.setText("");
            tfdValorVenda.setText("");
            tfdQuantidade.setText("");
            tfdSituacao.setText("");

            // posiciona cursor
            tfdDescricao.requestFocus();

        } else {
            JOptionPane.showMessageDialog(null, "Ops! Problemas ao salvar registro.");
        }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        new ProdutosDAO().popularTabela(tblProdutos, tfdCriterioPesquisa.getText());
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        String idString = String.valueOf(tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 0));
        int id = Integer.parseInt(idString);

        Produtos p = new ProdutosDAO().consultarId(id);

        if (p != null) {
            jTabbedPane1.setSelectedIndex(0);

            tfdDescricao.setText(p.getDescricao());
            tfdValorCompra.setText(String.valueOf(p.getValorcompra()));
            tfdValorVenda.setText(String.valueOf(p.getValorvenda()));
            tfdQuantidade.setText(String.valueOf(p.getQuantidade()));
            tfdSituacao.setText(String.valueOf(p.getSituacao()));

            tfdDescricao.requestFocus();

            codigo = p.getProduto_id();
            //JOptionPane.showMessageDialog(null, "Registro não localizado!");
        } else {
            JOptionPane.showMessageDialog(null, "Registro não localizado!");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        String idString = String.valueOf(tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 0));
        int id = Integer.parseInt(idString);

        String retorno = new ProdutosDAO().excluir(id);

        if (retorno == null) {
            JOptionPane.showMessageDialog(null, "Registro inativado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Problemas ao inativar registro.");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tfdValorVendaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfdValorVendaFocusLost
        //String numero = tfdValorVenda.getText();

        //int numeroConvertido = Integer.parseInt(numero);
        //String valorFormatado = new DecimalFormat("###0.00").format(numeroConvertido);
        //tfdValorVenda.setText(valorFormatado);
    }//GEN-LAST:event_tfdValorVendaFocusLost

    private void tfdQuantidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfdQuantidadeFocusLost
        //String numero = tfdQuantidade.getText();

        //int numeroConvertido = Integer.parseInt(numero);
        //String valorFormatado = new DecimalFormat("###0.00").format(numeroConvertido);
        //tfdQuantidade.setText(valorFormatado);
    }//GEN-LAST:event_tfdQuantidadeFocusLost

    private void tfdValorCompraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfdValorCompraKeyReleased

    }//GEN-LAST:event_tfdValorCompraKeyReleased

    private void tfdValorCompraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfdValorCompraFocusLost
        //String numero = tfdValorCompra.getText();

        //int numeroConvertido = Integer.parseInt(numero);
        //String valorformatado = new DecimalFormat("###0.00").format(numeroConvertido);
        //tfdValorCompra.setText(valorFormatado);
    }//GEN-LAST:event_tfdValorCompraFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTextField tfdCriterioPesquisa;
    private javax.swing.JTextField tfdDescricao;
    private javax.swing.JFormattedTextField tfdQuantidade;
    private javax.swing.JTextField tfdSituacao;
    private javax.swing.JTextField tfdValorCompra;
    private javax.swing.JFormattedTextField tfdValorVenda;
    // End of variables declaration//GEN-END:variables

}
