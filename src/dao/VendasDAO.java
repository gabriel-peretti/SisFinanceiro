/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAO_T;
import entidade.Produtos;
import entidade.Vendas;
import entidade.VendasProduto;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author peret
 */
public class VendasDAO implements IDAO_T<Vendas> {

    ResultSet resultadoQ = null;
    private int codigovenda;
    private static int vendas_id = 0;
    private static int vendas_produto = 0;
    public static double totalvendas = 0;

    public int obterLancamentoId() {
        return vendas_id;
    }

    public double obterTotalVenda() {
        return totalvendas;
    }

    public boolean salvar1(Vendas vendas) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "INSERT INTO vendas (vendas_id,produto_id, cliente_id, datavenda, valor,valortotal,quantidade,desconto,estoque) VALUES ("
                    + "DEFAULT, "
                    + "" + vendas.getProduto_id() + ","
                    + "" + vendas.getCliente_id() + ","
                    + "'" + vendas.getDatavenda() + "',"
                    + "" + vendas.getValor() + ","
                    + "" + vendas.getValortotal() + ","
                    + "" + vendas.getQuantidade() + ","
                    // "'" + vendas.getSituacao() + "',"
                    + "" + vendas.getDesconto() + ","
                    + "" + vendas.getEstoque() + ""
                    + ")";

            System.out.println("sql: " + sql);

            int resultado = st.executeUpdate(sql);

            return true;
        } catch (Exception e) {
            System.out.println("Erro ao salvar venda = " + e);
            return false;
        }

    }

    @Override
    public String salvar(Vendas v) {
        VendasProduto vp = new VendasProduto();
        int resultado = 0;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            if (v.getVendas_id() == 0) {

                String sql = ""
                        + "INSERT INTO vendas (vendas_id, produto_id, cliente_id,datavenda,valor,valortotal,quantidade,desconto,estoque) VALUES ("
                        + "DEFAULT, "
                        + "" + v.getProduto_id() + ","
                        + "" + v.getCliente_id() + ","
                        + "'" + v.getDatavenda() + "',"
                        + "" + v.getValor() + ","
                        + "" + v.getValortotal() + ","
                        + "" + v.getQuantidade() + ","
                        // "'" + v.getSituacao() + "',"
                        + "" + v.getDesconto() + ","
                        + "" + v.getEstoque() + ""
                        + ")";

                System.out.println("sql: " + sql);

                resultado = st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

                ResultSet chave = st.getGeneratedKeys();

                if (chave.next()) {
                    v.setVendas_id(chave.getInt("vendas_id"));
                    vendas_id = chave.getInt("vendas_id");
                    System.out.println("codigo venda : " + vendas_id);
                }
            }

            String sql2 = ""
                    + "UPDATE produtos "
                    + "SET "
                    + "quantidade  = " + v.getEstoque() + ""
                    + "WHERE produto_id = " + v.getProduto_id();

            int resultado2 = st.executeUpdate(sql2);

            System.out.println("sql: " + sql2);

            //if (vp.getVendasproduto_id() == 0) {
            String sql3 = ""
                    + "INSERT INTO vendas_produto (vendas_produto_id, vendas_id, produto_id, valor, quantidade, desconto) VALUES ("
                    + "DEFAULT,                "
                    + "" + vendas_id + ","
                    + "" + v.getProduto_id() + ","
                    + "" + v.getValortotal() + ","
                    + "" + v.getQuantidade() + ","
                    + "" + v.getDesconto() + ""
                    + ")";

            System.out.println("sql: " + sql3);

            int resultado3 = st.executeUpdate(sql3);

            String sql4 = ""
                    + "select SUM(valor) As TotalVenda from vendas_produto "
                    + "where vendas_id = " + vendas_id + ""
                    + "";
            ResultSet resultado4 = st.executeQuery(sql4);
            System.out.println("resultado = " + sql4);

            if (resultado4.next()) {
                v.setTotalvendas(resultado4.getFloat("TotalVenda"));
                float valor = resultado4.getFloat("TotalVenda");
                System.out.println("Total da Venda:" + valor);

                String sql5 = ""
                        + "UPDATE vendas set valortotal = " + valor
                        + "where vendas_id = " + vendas_id + ""
                        + "";
                int resultado5 = st.executeUpdate(sql5, Statement.RETURN_GENERATED_KEYS);

                ResultSet chave = st.getGeneratedKeys();

                if (chave.next()) {
                    totalvendas = chave.getFloat("valortotal");
                    v.setTotalvendas(chave.getFloat("valortotal"));
                    System.out.println("valor da venda ZOADO KKK : " + totalvendas);
                }
            }

            if (resultado == 0) {
                return "Erro ao inserir";
            } else {
                return null;
            }

        } catch (Exception e) {
            System.out.println("Erro salvar " + this.getClass().getName() + " = " + e);
            return e.toString();
        }

    }

    @Override
    public String atualizar(Vendas v) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "UPDATE vendas "
                    + "SET "
                    + "produto_id  = " + v.getProduto_id() + ","
                    + "cliente_id = " + v.getCliente_id() + ","
                    + "datavenda  = '" + v.getDatavenda() + "',"
                    + "valor      = " + v.getValor() + ","
                    + "valortotal = " + v.getValortotal() + ","
                    + "quantidade = " + v.getQuantidade() + ","
                    // "situacao = '" + v.getSituacao() + "',"
                    + "desconto = " + v.getDesconto() + ","
                    + "desconto = " + v.getEstoque() + ""
                    + "WHERE vendas_id = " + v.getVendas_id();

            System.out.println("sql: " + sql);

            int resultado = st.executeUpdate(sql);

            return null;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar a venda = " + e);
            return e.toString();
        }
    }

    @Override
    public String excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "DELETE FROM vendas_produto "
                    + "WHERE vendas_produto_id = " + id;

            System.out.println("sql: " + sql);

            int resultado = st.executeUpdate(sql);

            return null;
        } catch (Exception e) {
            System.out.println("Erro ao excluir venda. = " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<Vendas> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Vendas> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vendas consultarId(int id) {
        Vendas v = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "select * from vendas "
                    + "where  "
                    + "vendas_id = " + id;

            System.out.println("sql: " + sql);

            resultadoQ = st.executeQuery(sql);

            if (resultadoQ.next()) {
                v = new Vendas();

                v.setVendas_id(id);
                v.setProduto_id(resultadoQ.getInt("produto_id"));
                v.setCliente_id(resultadoQ.getInt("cliente_id"));
                v.setDatavenda(resultadoQ.getString("DataVenda"));
                v.setValor(resultadoQ.getDouble("valor"));
                v.setValortotal(resultadoQ.getDouble("valortotal"));
                v.setQuantidade(resultadoQ.getDouble("quantidade"));
                v.setSituacao(resultadoQ.getString("situacao").charAt(0));
                v.setDesconto(resultadoQ.getDouble("desconto"));
                v.setEstoque(resultadoQ.getDouble("estoque"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar venda = " + e);
        }
        return v;
    }

    public Vendas consultarIdVendasProduto(int id) {
        Vendas v = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "select * from vendas_produto "
                    + "where  "
                    + "vendas_produto_id = " + id;

            System.out.println("sql: " + sql);

            resultadoQ = st.executeQuery(sql);

            if (resultadoQ.next()) {
                v = new Vendas();

                v.setVendas_id(id);
                v.setProduto_id(resultadoQ.getInt("produto_id"));
                v.setCliente_id(resultadoQ.getInt("cliente_id"));
                v.setDatavenda(resultadoQ.getString("DataVenda"));
                v.setValor(resultadoQ.getDouble("valor"));
                v.setValortotal(resultadoQ.getDouble("valortotal"));
                v.setQuantidade(resultadoQ.getDouble("quantidade"));
                v.setSituacao(resultadoQ.getString("situacao").charAt(0));
                v.setDesconto(resultadoQ.getDouble("desconto"));
                v.setEstoque(resultadoQ.getDouble("estoque"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar venda = " + e);
        }
        return v;
    }

    public void popularTabela(JTable tabela, String criterio) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[8];
        cabecalho[0] = "Cliente";
        cabecalho[1] = "CPF";
        cabecalho[2] = "RG";
        cabecalho[3] = "Endereço";
        cabecalho[4] = "Produto";
        cabecalho[5] = "Quantidade";
        cabecalho[6] = "Valor de venda";
        cabecalho[7] = "Valor total";

        //cabecalho[5] = "Situacao";
        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * FROM vendas_produto vp "
                    + "LEFT JOIN vendas v on vp.vendas_id = v.vendas_id "
                    + "LEFT JOIN produtos p on vp.produto_id = p.produto_id "
                    + "LEFT JOIN clientes c On v.cliente_id = c.cliente_id "
                    + "WHERE c.NOME ILIKE '%" + criterio + "%' "
                    + "ORDER BY c.nome");

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][8];

        } catch (Exception e) {
            System.out.println("Erro ao consultar produto: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * FROM vendas_produto vp "
                    + "LEFT JOIN vendas v on vp.vendas_id = v.vendas_id "
                    + "LEFT JOIN produtos p on vp.produto_id = p.produto_id "
                    + "LEFT JOIN clientes c On v.cliente_id = c.cliente_id "
                    + "WHERE c.NOME ILIKE '%" + criterio + "%' "
                    + "ORDER BY c.nome");

            while (resultadoQ.next()) {
                dadosTabela[lin][0] = resultadoQ.getString("nome");
                dadosTabela[lin][1] = resultadoQ.getString("cpf");
                dadosTabela[lin][2] = resultadoQ.getString("rg");
                dadosTabela[lin][3] = resultadoQ.getString("endereco");
                dadosTabela[lin][4] = resultadoQ.getString("descricao");
                dadosTabela[lin][5] = resultadoQ.getDouble("quantidade");
                dadosTabela[lin][6] = resultadoQ.getDouble("valorvenda");
                dadosTabela[lin][7] = resultadoQ.getDouble("valor");
                //dadosTabela[lin][5] = resultadoQ.getString("situacao");
                // caso a coluna precise exibir uma imagem
//                if (resultadoQ.getBoolean("Situacao")) {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_ativo.png"));
//                } else {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_inativo.png"));
//                }
                lin++;
            }
        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }

        // configuracoes adicionais no componente tabela
        tabela.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
            @Override
            // quando retorno for FALSE, a tabela nao é editavel
            public boolean isCellEditable(int row, int column) {
                return false;
                /*  
                 if (column == 3) {  // apenas a coluna 3 sera editavel
                 return true;
                 } else {
                 return false;
                 }
                 */
            }

            // alteracao no metodo que determina a coluna em que o objeto ImageIcon devera aparecer
            @Override
            public Class getColumnClass(int column) {

                if (column == 2) {
//                    return ImageIcon.class;
                }
                return Object.class;
            }
        });

        // permite seleção de apenas uma linha da tabela
        tabela.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < tabela.getColumnCount(); i++) {
            column = tabela.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(17);
                    break;
                case 1:
                    column.setPreferredWidth(140);
                    break;
//                case 2:
//                    column.setPreferredWidth(14);
//                    break;
            }
        }
        // renderizacao das linhas da tabela = mudar a cor
//        jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
//
//            @Override
//            public Component getTableCellRendererComponent(JTable table, Object value,
//                    boolean isSelected, boolean hasFocus, int row, int column) {
//                super.getTableCellRendererComponent(table, value, isSelected,
//                        hasFocus, row, column);
//                if (row % 2 == 0) {
//                    setBackground(Color.GREEN);
//                } else {
//                    setBackground(Color.LIGHT_GRAY);
//                }
//                return this;
//            }
//        });
    }

    public void popularTabela2(JTable tabela, String criterio, String criterio2) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[6];
        cabecalho[0] = "Produto";
        cabecalho[1] = "Data";
        cabecalho[2] = "Quantidade";
        cabecalho[3] = "Desconto";
        cabecalho[4] = "Valor de venda";
        cabecalho[5] = "Valor total";

        //cabecalho[3] = "ValorVenda";
        //cabecalho[4] = "Quantidade";
        //cabecalho[5] = "Situacao";
        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    //+ "SELECT COUNT (*) FROM vendas WHERE datavenda between '" + criterio + "' and '" + criterio2 + "' ");
                    //+ "GROUP BY datavenda "
                    //+ "ORDER BY datavenda ");
                    + "SELECT * FROM vendas_produto vp "
                    + "left join vendas v on vp.vendas_id = v.vendas_id "
                    + "LEFT JOIN  produtos p On vp.produto_id = p.produto_id "
                    + "WHERE v.datavenda between '" + criterio + "' and '" + criterio + "' "
                    + "ORDER BY p.descricao ");

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][6];

        } catch (Exception e) {
            System.out.println("Erro ao consultar produto: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * FROM vendas_produto vp "
                    + "left join vendas v on vp.vendas_id = v.vendas_id "
                    + "LEFT JOIN  produtos p On vp.produto_id = p.produto_id "
                    + "WHERE v.datavenda between '" + criterio + "' and '" + criterio + "' "
                    + "ORDER BY p.descricao ");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getString("descricao");
                dadosTabela[lin][1] = resultadoQ.getString("datavenda");
                dadosTabela[lin][2] = resultadoQ.getDouble("quantidade");
                dadosTabela[lin][3] = resultadoQ.getDouble("desconto");
                dadosTabela[lin][4] = resultadoQ.getDouble("valorvenda");
                dadosTabela[lin][5] = resultadoQ.getDouble("valor");
                //dadosTabela[lin][5] = resultadoQ.getString("situacao");
                // caso a coluna precise exibir uma imagem
//                if (resultadoQ.getBoolean("Situacao")) {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_ativo.png"));
//                } else {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_inativo.png"));
//                }
                lin++;
            }
        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }

        // configuracoes adicionais no componente tabela
        tabela.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
            @Override
            // quando retorno for FALSE, a tabela nao é editavel
            public boolean isCellEditable(int row, int column) {
                return false;
                /*  
                 if (column == 3) {  // apenas a coluna 3 sera editavel
                 return true;
                 } else {
                 return false;
                 }
                 */
            }

            // alteracao no metodo que determina a coluna em que o objeto ImageIcon devera aparecer
            @Override
            public Class getColumnClass(int column) {

                if (column == 2) {
//                    return ImageIcon.class;
                }
                return Object.class;
            }
        });

        // permite seleção de apenas uma linha da tabela
        tabela.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < tabela.getColumnCount(); i++) {
            column = tabela.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(17);
                    break;
                case 1:
                    column.setPreferredWidth(140);
                    break;
//                case 2:
//                    column.setPreferredWidth(14);
//                    break;
            }
        }
        // renderizacao das linhas da tabela = mudar a cor
//        jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
//
//            @Override
//            public Component getTableCellRendererComponent(JTable table, Object value,
//                    boolean isSelected, boolean hasFocus, int row, int column) {
//                super.getTableCellRendererComponent(table, value, isSelected,
//                        hasFocus, row, column);
//                if (row % 2 == 0) {
//                    setBackground(Color.GREEN);
//                } else {
//                    setBackground(Color.LIGHT_GRAY);
//                }
//                return this;
//            }
//        });
    }

}
