/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAO_T;
import entidade.Produtos;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author gabriel.ferreira1
 */
public class ProdutosDAO implements IDAO_T<Produtos> {

    ResultSet resultadoQ = null;

    private static int produto_id = 0;

    public int obterLancamentoId() {
        return produto_id;
    }

    public boolean salvar1(Produtos produtos) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "INSERT INTO produtos VALUES ("
                    + "DEFAULT, "
                    + "'" + produtos.getDescricao() + "',"
                    + "" + produtos.getValorcompra() + ","
                    + "" + produtos.getValorvenda() + ","
                    + "" + produtos.getQuantidade() + ","
                    + "'" + produtos.getSituacao() + "'"
                    + ")";

            System.out.println("sql: " + sql);

            int resultado = st.executeUpdate(sql);

            return true;
        } catch (Exception e) {
            System.out.println("Erro ao salvar produto = " + e);
            return false;
        }

    }

    public String salvar(Produtos o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "INSERT INTO produtos VALUES ("
                    + "DEFAULT, "
                    + "'" + o.getDescricao() + "',"
                    + "" + o.getValorcompra() + ","
                    + "" + o.getValorvenda() + ","
                    + "" + o.getQuantidade() + ","
                    + "'" + o.getSituacao() + "'"
                    + ")";

            System.out.println("sql: " + sql);

            int resultado = st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

            ResultSet chave = st.getGeneratedKeys();

            if (chave.next()) {
                produto_id = chave.getInt(1);
                System.out.println("Id gerado: " + produto_id);
            }

            if (resultado == 0) {
                return "Erro ao inserir";
            } else {
                return null;
            }

        } catch (Exception e) {
            System.out.println("Erro ao salvar " + this.getClass().getName() + " = " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Produtos o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "UPDATE produtos "
                    + "SET "
                    + "descricao = '" + o.getDescricao() + "',"
                    + "valorcompra = " + o.getValorcompra() + ","
                    + "valorvenda = " + o.getValorvenda() + ","
                    + "quantidade = " + o.getQuantidade() + ","
                    + "situacao = '" + o.getSituacao() + "'"
                    + "WHERE produto_id = " + o.getProduto_id();

            System.out.println("sql: " + sql);

            int resultado = st.executeUpdate(sql);

            if (resultado == 0) {
                return "Erro ao atualizar";
            } else {
                return null;
            }
            
        } catch (Exception e) {
            System.out.println("Erro ao atualizar o produto = " + e);
            return e.toString();
        }
    }

    @Override
    public String excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "UPDATE produtos "
                    + "SET "
                    + "situacao = 'I' "
                    + "WHERE produto_id = " + id;

            System.out.println("sql: " + sql);

            int resultado = st.executeUpdate(sql);

            return null;
        } catch (Exception e) {
            System.out.println("Erro excluir/inativar produto = " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<Produtos> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Produtos> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @SuppressWarnings("empty-statement")
    public Produtos consultarId(int id) {
        Produtos p = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "select * from produtos "
                    + "where  "
                    + "produto_id = " + id;

            System.out.println("sql: " + sql);

            resultadoQ = st.executeQuery(sql);

            if (resultadoQ.next()) {
                p = new Produtos();
                
                p.setProduto_id(id);
                p.setDescricao(resultadoQ.getString("descricao"));
                p.setValorcompra(resultadoQ.getDouble("valorcompra"));
                p.setValorvenda(resultadoQ.getDouble("valorvenda"));
                p.setQuantidade(resultadoQ.getDouble("quantidade"));
                p.setSituacao(resultadoQ.getString("situacao").charAt(0));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar o produto = " + e);
        }
        return p;
    }

    public void popularTabela(JTable tabela, String criterio) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[6];
        cabecalho[0] = "Código";
        cabecalho[1] = "Descrição";
        cabecalho[2] = "ValorCompra";
        cabecalho[3] = "ValorVenda";
        cabecalho[4] = "Quantidade";
        cabecalho[5] = "Situacao";

        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) FROM produtos WHERE DESCRICAO ILIKE '%" + criterio + "%'");

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][6];

        } catch (Exception e) {
            System.out.println("Erro ao consultar produto: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * FROM produtos WHERE DESCRICAO ILIKE '%" + criterio + "%' "
                    + "ORDER BY descricao");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("produto_id");
                dadosTabela[lin][1] = resultadoQ.getString("descricao");
                dadosTabela[lin][2] = resultadoQ.getDouble("valorcompra");
                dadosTabela[lin][3] = resultadoQ.getDouble("valorvenda");
                dadosTabela[lin][4] = resultadoQ.getDouble("quantidade");
                dadosTabela[lin][5] = resultadoQ.getString("situacao");
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
