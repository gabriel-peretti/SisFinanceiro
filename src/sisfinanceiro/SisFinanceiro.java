/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfinanceiro;

import apoio.ConexaoBD;
import apoio.Formatador;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import tela.FrmLogin;
import tela.FrmPrincipal;

/**
 *
 * @author gabriel.ferreira1
 */
public class SisFinanceiro {

    static Formatador formatador = new Formatador();

    public static void main(String[] args) {

        //     System.out.println(formatador.criptografia("bola123"));
        if (ConexaoBD.getInstance() != null) {
            //FrmLogin tela = new FrmLogin();
            //tela.setVisible(true);
//            System.out.println(formatador.criptografia("Teste123"));

            FrmPrincipal janela = new FrmPrincipal();
            janela.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Erro de conexão!");
        }

    }

}
