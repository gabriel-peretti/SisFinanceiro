/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import apoio.ConexaoBD;
import apoio.Formatacao;
import apoio.Formatador;
import dao.ClientesDAO;
import dao.ProdutosDAO;
import dao.VendasDAO;
import dao.VendasProdutoDAO;
import entidade.Clientes;
import entidade.Produtos;
import entidade.Vendas;
import entidade.VendasProduto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author peret
 */
public class DlgVendas extends javax.swing.JDialog {

    int codigo = 0;
    double setvalortotal = 0;
    int codigovendaproduto = 0;
    int codigovenda;
    Clientes cliente = null;
    Produtos produto = null;
    double valortotall = 0;
    Produtos vendaproduto = null;
    Produtos estoque = null;
    Vendas testevalortotal = null;
    Vendas valortotal = null;
    Vendas venda = null;
    ClientesDAO clientesDAO;
    ProdutosDAO produtosDAO;
    VendasDAO vendasdao;
    Formatador formatador = new Formatador();

    /**
     * Creates new form IfrVendas
     */
    public DlgVendas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        vendasdao = new VendasDAO();

        try {
            MaskFormatter form = new MaskFormatter("##/##/####");
            tffData.setFormatterFactory(new DefaultFormatterFactory(form));
        } catch (ParseException ex) {
            System.out.println("Erro ao gerar data = " + ex);
        }

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date hoje = new Date();
        tffData.setText(df.format(hoje));

    }

    DlgVendas() {
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
        tfdNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfdProduto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfdQuantidade = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfdValor = new javax.swing.JTextField();
        btnPesquisarProduto = new javax.swing.JButton();
        btnPesquisarCliente = new javax.swing.JButton();
        tffData = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        tfdDesconto = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tfdEstoque = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVendasProduto = new javax.swing.JTable();
        btnSalvar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        tfdValorTotal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        tfdTotalVenda = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setTitle("Vendas");

        jLabel1.setText("Nome do Cliente:");

        jLabel3.setText("Data:");

        jLabel4.setText("Produto:");

        jLabel5.setText("Quantidade:");

        jLabel6.setText("Valor por item:");

        tfdValor.setEditable(false);

        btnPesquisarProduto.setText("Localizar");
        btnPesquisarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarProdutoActionPerformed(evt);
            }
        });

        btnPesquisarCliente.setText("Localizar");
        btnPesquisarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarClienteActionPerformed(evt);
            }
        });

        tffData.setEditable(false);

        jLabel8.setText("Desconto:");

        tfdDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdDescontoActionPerformed(evt);
            }
        });

        jLabel10.setText("Estoque:");

        tfdEstoque.setEditable(false);

        tblVendasProduto.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblVendasProduto);

        btnSalvar.setText("Adicionar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jLabel7.setText("Valor Total:");

        tfdValorTotal.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4)
                                    .addComponent(tfdNome, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                                    .addComponent(tfdProduto))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnPesquisarCliente)
                                    .addComponent(btnPesquisarProduto)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfdDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfdEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(tfdValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(tfdQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tffData, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(tfdValor, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfdNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPesquisarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tffData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPesquisarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfdValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfdQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfdValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );

        jTabbedPane1.addTab("Vendas", jPanel1);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Formulário de Vendas");

        btnExcluir.setText("Excluir produto");
        btnExcluir.setMaximumSize(new java.awt.Dimension(115, 57));
        btnExcluir.setMinimumSize(new java.awt.Dimension(115, 57));
        btnExcluir.setPreferredSize(new java.awt.Dimension(115, 57));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Application-32.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setMaximumSize(new java.awt.Dimension(115, 57));
        btnEditar.setMinimumSize(new java.awt.Dimension(115, 57));
        btnEditar.setPreferredSize(new java.awt.Dimension(115, 57));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Ball-standby-48.png"))); // NOI18N
        btnFechar.setText("Fechar");
        btnFechar.setMaximumSize(new java.awt.Dimension(115, 57));
        btnFechar.setMinimumSize(new java.awt.Dimension(115, 57));
        btnFechar.setPreferredSize(new java.awt.Dimension(115, 57));
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        jButton1.setText("Finalizar Venda");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tfdTotalVenda.setEditable(false);

        jLabel9.setText("Total da venda:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(jButton1)
                                .addGap(45, 45, 45)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfdTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfdTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        String idString = String.valueOf(tblVendasProduto.getValueAt(tblVendasProduto.getSelectedRow(), 0));
        int id = Integer.parseInt(idString);

        String retorno = new VendasDAO().excluir(id);

        if (retorno == null) {

            JOptionPane.showMessageDialog(null, "Venda excluída com sucesso.");
        } else {
            JOptionPane.showMessageDialog(null, "Problemas ao excluir venda.");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        String idString = String.valueOf(tblVendasProduto.getValueAt(tblVendasProduto.getSelectedRow(), 0));
        int id = Integer.parseInt(idString);

        Vendas v = new VendasDAO().consultarId(id);

        if (v == null) {
            JOptionPane.showMessageDialog(null, "Registro não localizado!");
        } else {
            codigo = v.getVendas_id();

            // mudar a aba ativa para Cadastro
            jTabbedPane1.setSelectedIndex(0);

            // coloca dados nos campos de interface
            //tfdNome.setText(String.valueOf(v.getCliente_id()));
            tffData.setText(String.valueOf(v.getDatavenda()));
            //tfdProduto.setText(String.valueOf(v.getProduto_id()));
            //tfdQuantidade.setText(String.valueOf(v.getQuantidade()));
            tfdQuantidade.setText(Double.toString(v.getQuantidade()));
            tfdValor.setText(String.valueOf(this.produto.getValorvenda()));
            tfdValorTotal.setText(Double.toString(v.getValortotal()));
            //tfdSituacao.setText(String.valueOf(v.getSituacao()));
            tfdDesconto.setText(Double.toString(v.getDesconto()));
            tfdValorTotal.setText(String.valueOf(valortotal));

            tfdNome.requestFocus();
        }
    }//GEN-LAST:event_btnEditarActionPerformed
    public void definirValores(Clientes cliente) {
        tfdNome.setText(cliente.getNome());
        this.cliente = cliente;
    }

    public void definirValorProduto(Produtos produto) {
        tfdProduto.setText(produto.getDescricao());
        this.produto = produto;
    }

    public void definirValorTotal(Vendas venda) {
        double valortot = 0;
        valortot = (((this.vendaproduto.getValorvenda())) * (Double.parseDouble(tfdQuantidade.getText())));
        tfdValorTotal.setText(String.valueOf(valortot));
        System.out.println("valortotal:" + valortot);
        this.valortotal = venda;
    }

    public void definirValorVenda(Produtos produto) {
        tfdValor.setText(String.valueOf(produto.getValorvenda()));
        this.vendaproduto = produto;
    }

    public void definirQuantidade(Produtos produto) {
        tfdEstoque.setText(String.valueOf(produto.getQuantidade()));
        this.estoque = produto;
    }

    public void definirIdVenda() {
        valortotall = 0;
        int qtd = 0;
        float valor = 0;
        Vendas v = new Vendas();
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "select valortotal from vendas "
                    + "where vendas_id = " + codigo + ""
                    + "";
            ResultSet resultado = st.executeQuery(sql);
            System.out.println("resultado = " + sql);

            if (resultado.next()) {
                //v.setTotalvendas(resultado4.getFloat("TotalVenda"));
                valor = resultado.getFloat("valortotal");
                System.out.println("Total da VendaHUEHUEHEU:" + valor);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar valortotal" + ex);
        }
    }

    public void somarValorTotal() {
        VendasDAO vendasdao = new VendasDAO();
        tfdTotalVenda.setText(String.valueOf(vendasdao.obterTotalVenda()));
        //System.out.println("sexo é" + vendasdao.obterTotalVenda());
    }


    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void tfdDescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdDescontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdDescontoActionPerformed

    private void btnPesquisarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarClienteActionPerformed
        DlgConsultaClientes ifrConsultaClientes = new DlgConsultaClientes(null, true, this);
        ifrConsultaClientes.setLocationRelativeTo(this);
        ifrConsultaClientes.setVisible(true);
    }//GEN-LAST:event_btnPesquisarClienteActionPerformed

    private void btnPesquisarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarProdutoActionPerformed
        DlgConsultaProdutos ifrConsultaProdutos = new DlgConsultaProdutos(null, true, this);
        ifrConsultaProdutos.setLocationRelativeTo(this);
        ifrConsultaProdutos.setVisible(true);
        //Vendas vendinha = new Vendas();
        //vendinha.setValor(this.produto.getValorvenda()); // pega valorvenda do produto
        tfdValor.setText(String.valueOf(this.produto.getValorvenda()));
        tfdEstoque.setText(String.valueOf(this.produto.getQuantidade()));
    }//GEN-LAST:event_btnPesquisarProdutoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        Vendas vendinha = new Vendas();

        VendasDAO vendasDAO = new VendasDAO();

        /////////////////////////////
        vendinha.setVendas_id(codigo);

        String retorno = null;

        System.out.println("codigo da venda: > " + codigo);
        //System.out.println("totalvenda: > " + setvalortotal);

        if (tfdNome.getText().equals("")) {
            tfdNome.requestFocus();
            JOptionPane.showMessageDialog(null, "O campo cliente é obrigatório, favor preencher.", "Aviso", JOptionPane.WARNING_MESSAGE);
            //tfdDescricao.setBackground(Color.yellow);
            return;
        } else {
            vendinha.setCliente_id(this.cliente.getCliente_id());
        }

        if (tfdProduto.getText().equals("")) {
            tfdProduto.requestFocus();
            JOptionPane.showMessageDialog(null, "O campo produto é obrigatório, favor preencher.", "Aviso", JOptionPane.WARNING_MESSAGE);
            //tfdDescricao.setBackground(Color.yellow);
            return;
        } else {
            vendinha.setProduto_id(this.produto.getProduto_id());
        }

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String date = df.format(new Date());
        vendinha.setDatavenda(date);

        if (tfdQuantidade.getText().equals("")) {
            tfdQuantidade.requestFocus();
            JOptionPane.showMessageDialog(null, "O campo quantidade é obrigatório, favor preencher.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        } else {

            vendinha.setValor(this.produto.getValorvenda());

            vendinha.setEstoque((this.produto.getQuantidade()) - (Double.valueOf(tfdQuantidade.getText().replace(',', '.'))));
            double consultarestoque = 0;
            consultarestoque = (this.produto.getQuantidade()) - (Double.valueOf(tfdQuantidade.getText().replace(',', '.')));
            tfdEstoque.setText(String.valueOf(consultarestoque));
            System.out.println("estoque" + consultarestoque);

            vendinha.setValortotal(Double.valueOf(tfdValor.getText()) * (Double.valueOf(tfdQuantidade.getText().replace(',', '.'))) - (Double.valueOf(tfdDesconto.getText().replace(',', '.'))));
            double valortotall = 0;
            valortotall = (Double.valueOf(tfdValor.getText()) * (Double.valueOf(tfdQuantidade.getText().replace(',', '.'))) - (Double.valueOf(tfdDesconto.getText().replace(',', '.'))));
            tfdValorTotal.setText(String.valueOf(valortotall));
            System.out.println("valortotal" + valortotall);

            String vQuantidade = tfdQuantidade.getText().replace(",", ".");
            double numeroConvertido = Double.parseDouble(vQuantidade);
            String valorFormatado = new DecimalFormat("###0.00").format(numeroConvertido);
            tfdQuantidade.setText(valorFormatado);
            vendinha.setQuantidade(formatador.ConverterVirgulaParaPonto(tfdQuantidade.getText()));

        }

        vendinha.setValor(this.produto.getValorvenda());

        //vendinha.setTotalvendas(this.testevalortotal.getTotalvendas());
        tfdTotalVenda.setText(String.valueOf(this.testevalortotal));

        if (tfdDesconto.getText().equals("")) {
            tfdDesconto.requestFocus();
            JOptionPane.showMessageDialog(null, "O campo desconto é obrigatório, favor preencher.", "Aviso", JOptionPane.WARNING_MESSAGE);
            //tfdQuantidade.setBackground(Color.yellow);
            return;
        } else {

            String vDesconto = tfdDesconto.getText().replace(",", ".");
            double numeroConvertido = Double.parseDouble(vDesconto);
            String valorFormatado = new DecimalFormat("###0.00").format(numeroConvertido);
            tfdDesconto.setText(valorFormatado);
            vendinha.setDesconto(formatador.ConverterVirgulaParaPonto(tfdDesconto.getText()));
        }

        // salvar = inserir
        retorno = vendasDAO.salvar(vendinha); //
        
        somarValorTotal();

        codigo = vendinha.getVendas_id();

        new VendasProdutoDAO().popularTabela(tblVendasProduto, codigo); //, codigo

        JOptionPane.showMessageDialog(null, "Registro salvo com sucesso!");

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Vendas v = new Vendas();
        codigo = v.getVendas_id();
        codigo = 0;
        v.setVendas_id(codigo);

        new VendasProdutoDAO().popularTabela(tblVendasProduto, codigo);

        tfdProduto.setText("");
        tfdNome.setText("");
        //tffData.setText("");
        tfdValor.setText("");
        tfdValorTotal.setText("");
        tfdQuantidade.setText("");
        //tfdSituacao.setText("");
        tfdDesconto.setText("");
        tfdEstoque.setText("");
        // posiciona cursor
        tfdNome.requestFocus();
        System.out.println("codigo finalizar venda:" + codigo);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnPesquisarCliente;
    private javax.swing.JButton btnPesquisarProduto;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblVendasProduto;
    private javax.swing.JTextField tfdDesconto;
    private javax.swing.JTextField tfdEstoque;
    private javax.swing.JTextField tfdNome;
    private javax.swing.JTextField tfdProduto;
    private javax.swing.JTextField tfdQuantidade;
    private javax.swing.JTextField tfdTotalVenda;
    private javax.swing.JTextField tfdValor;
    private javax.swing.JTextField tfdValorTotal;
    private javax.swing.JFormattedTextField tffData;
    // End of variables declaration//GEN-END:variables
}