/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAO_T;
import entidade.Clientes;
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
public class ClientesDAO implements IDAO_T<Clientes> {

    ResultSet resultadoQ = null;

    private static int cliente_id = 0;

    public int obterLancamentoId() {
        return cliente_id;
    }

    public boolean salvar1(Clientes clientes) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "INSERT INTO clientes(cliente_id,nome,rg,cpf,telefone,email,situacao,endereco) VALUES ("
                    + "DEFAULT, "
                    + "'" + clientes.getNome() + "',"
                    + "'" + clientes.getRg() + "',"
                    + "'" + clientes.getCpf() + "',"
                    + "'" + clientes.getTelefone() + "',"
                    + "'" + clientes.getEmail() + "',"
                    + "'" + clientes.getSituacao() + "',"
                    + "'" + clientes.getEndereco() + "'"
                    + ")";

            System.out.println("sql: " + sql);

            int resultado = st.executeUpdate(sql);

            return true;
        } catch (Exception e) {
            System.out.println("Erro ao salvar cliente = " + e);
            return false;
        }

    }

    public String salvar(Clientes o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "INSERT INTO clientes(cliente_id,nome,rg,cpf,telefone,email,situacao,endereco) VALUES ("
                    + "DEFAULT, "
                    + "'" + o.getNome() + "',"
                    + "'" + o.getRg() + "',"
                    + "'" + o.getCpf() + "',"
                    + "'" + o.getTelefone() + "',"
                    + "'" + o.getEmail() + "',"
                    + "'" + o.getSituacao() + "',"
                    + "'" + o.getEndereco() + "'"
                    + ")";

            System.out.println("sql: " + sql);

            int resultado = st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

            ResultSet chave = st.getGeneratedKeys();

            if (chave.next()) {
                cliente_id = chave.getInt(1);
                System.out.println("Id gerado: " + cliente_id);
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
    public String atualizar(Clientes o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "UPDATE clientes "
                    + "SET "
                    + "nome = '" + o.getNome() + "',"
                    + "rg = '" + o.getRg() + "',"
                    + "cpf = '" + o.getCpf() + "',"
                    + "telefone = '" + o.getTelefone() + "',"
                    + "email =    '" + o.getEmail() + "',"
                    + "situacao = '" + o.getSituacao() + "',"
                    + "endereco = '" + o.getEndereco() + "'"
                    + "WHERE cliente_id = " + o.getCliente_id();

            System.out.println("sql: " + sql);

            int resultado = st.executeUpdate(sql);

            return null;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar o cliente = " + e);
            return e.toString();
        }
    }

    @Override
    public String excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "UPDATE clientes "
                    + "SET "
                    + "situacao = 'I' "
                    + "WHERE cliente_id = " + id;

            System.out.println("sql: " + sql);

            int resultado = st.executeUpdate(sql);

            return null;
        } catch (Exception e) {
            System.out.println("Erro excluir/inativar cliente = " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<Clientes> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Clientes> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Clientes consultarId(int id) {
        Clientes c = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "select * from clientes "
                    + "where  "
                    + "cliente_id = " + id;

            System.out.println("sql: " + sql);

            resultadoQ = st.executeQuery(sql);

            if (resultadoQ.next()) {
                c = new Clientes();
                ;
                c.setCliente_id(id);
                c.setNome(resultadoQ.getString("nome"));
                c.setRg(resultadoQ.getString("rg"));
                c.setCpf(resultadoQ.getString("cpf"));
                c.setTelefone(resultadoQ.getString("telefone"));
                c.setEmail(resultadoQ.getString("email"));
                c.setSituacao(resultadoQ.getString("situacao").charAt(0));
                c.setEndereco(resultadoQ.getString("endereco"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar o cliente = " + e);
        }
        return c;
    }

    public void popularTabela(JTable tabela, String criterio) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[8];
        cabecalho[0] = "Código";
        cabecalho[1] = "Nome";
        cabecalho[2] = "RG";
        cabecalho[3] = "CPF";
        cabecalho[4] = "Telefone";
        cabecalho[5] = "Email";
        cabecalho[6] = "Situacao";
        cabecalho[7] = "Endereço";

        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) FROM clientes WHERE NOME ILIKE '%" + criterio + "%'");

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][8];

        } catch (Exception e) {
            System.out.println("Erro ao consultar cliente: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * FROM clientes WHERE NOME ILIKE '%" + criterio + "%' "
                    + "ORDER BY nome");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("cliente_id");
                dadosTabela[lin][1] = resultadoQ.getString("nome");
                dadosTabela[lin][2] = resultadoQ.getString("rg");
                dadosTabela[lin][3] = resultadoQ.getString("cpf");
                dadosTabela[lin][4] = resultadoQ.getString("telefone");
                dadosTabela[lin][5] = resultadoQ.getString("email");
                dadosTabela[lin][6] = resultadoQ.getString("situacao");
                dadosTabela[lin][7] = resultadoQ.getString("endereco");
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
