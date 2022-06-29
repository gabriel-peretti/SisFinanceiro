/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAO_T;
import entidade.VendasProduto;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author peret
 */
public class VendasProdutoDAO implements IDAO_T<VendasProduto> {
    
    ResultSet resultadoQ = null;
    private static int vendas_id = 0;
    
    public boolean salvar1(VendasProduto vendas) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "INSERT INTO vendas_produto (vendas_produto_id, vendas_id, produto_id, valor, quantidade) VALUES ("
                    + "DEFAULT, "
                    + "" + vendas.getVendas_id() + ","
                    + "" + vendas.getProduto_id() + ","
                    + "" + vendas.getValor() + ","
                    + "" + vendas.getQuantidade() + ""
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
    public String salvar(VendasProduto o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "INSERT INTO vendas_produto (vendas_produto_id, vendas_id, produto_id, valor, quantidade) VALUES ("
                    + "DEFAULT, "
                    + "" + o.getVendas_id() + ","
                    + "" + o.getProduto_id() + ","
                    + "" + o.getValor() + ","
                    + "" + o.getQuantidade() + ""
                    + ")";
            

            System.out.println("sql: " + sql);

            int resultado = st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

            ResultSet chave = st.getGeneratedKeys();

            if (chave.next()) {
                vendas_id = chave.getInt(1);
                System.out.println("Id gerado: " + vendas_id);
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
    public String atualizar(VendasProduto o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<VendasProduto> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<VendasProduto> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VendasProduto consultarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
public void popularTabela(JTable tabela, int criterio) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[6];
        cabecalho[0] = "Código";
        cabecalho[1] = "Vendas";
        cabecalho[2] = "Produto";
        //cabecalho[3] = "Descrição";
        cabecalho[3] = "Valor";
        cabecalho[4] = "Quantidade";
        cabecalho[5] = "Desconto";

        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                     + "SELECT count(*) FROM vendas_produto WHERE vendas_id = " + criterio);
                    
            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][6];

        } catch (Exception e) {
            System.out.println("Erro ao consultar venda: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * FROM vendas_produto vp "
                    + "LEFT JOIN produtos p On vp.produto_id = p.produto_id "
                    + "WHERE vp.vendas_id = " + criterio );
                    //+ "ORDER BY vendas_produto_id");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("vendas_produto_id");
                dadosTabela[lin][1] = resultadoQ.getInt("vendas_id");
                //dadosTabela[lin][2] = resultadoQ.getInt("produto_id");
                dadosTabela[lin][2] = resultadoQ.getString("descricao");
                //dadosTabela[lin][3] = resultadoQ.getDate("DataVenda");
                //dadosTabela[lin][4] = resultadoQ.getDouble("valor");
                dadosTabela[lin][3] = resultadoQ.getDouble("valor");
                dadosTabela[lin][4] = resultadoQ.getDouble("quantidade");
                dadosTabela[lin][5] = resultadoQ.getDouble("desconto");
                //dadosTabela[lin][8] = resultadoQ.getDouble("desconto");
                //dadosTabela[lin][9] = resultadoQ.getDouble("estoque");
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

public void popularTabelaTeste(JTable tabela) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[6];
        cabecalho[0] = "Código";
        cabecalho[1] = "Vendas";
        cabecalho[2] = "Produto";
        cabecalho[3] = "Valor";
        cabecalho[4] = "Quantidade";
        cabecalho[5] = "Desconto";

        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                     + "SELECT count(*) FROM vendas_produto ");
                    
            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][6];

        } catch (Exception e) {
            System.out.println("Erro ao consultar venda: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * FROM vendas_produto "
                    + "ORDER BY vendas_produto_id");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("vendas_produto_id");
                dadosTabela[lin][1] = resultadoQ.getInt("vendas_id");
                dadosTabela[lin][2] = resultadoQ.getInt("produto_id");
                //dadosTabela[lin][2] = resultadoQ.getInt("cliente_id");
                //dadosTabela[lin][3] = resultadoQ.getDate("DataVenda");
                //dadosTabela[lin][4] = resultadoQ.getDouble("valor");
                dadosTabela[lin][3] = resultadoQ.getDouble("valor");
                dadosTabela[lin][4] = resultadoQ.getDouble("quantidade");
                dadosTabela[lin][5] = resultadoQ.getDouble("desconto");
                //dadosTabela[lin][8] = resultadoQ.getDouble("desconto");
                //dadosTabela[lin][9] = resultadoQ.getDouble("estoque");
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
}
}

