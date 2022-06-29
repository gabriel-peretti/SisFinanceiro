/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

/**
 *
 * @author peret
 */
public class VendasProduto {
    private int produto_id;
    private int vendas_id;
    private int vendasproduto_id;
    private double valor;
    private double quantidade;

    public int getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(int produto_id) {
        this.produto_id = produto_id;
    }

    public int getVendas_id() {
        return vendas_id;
    }

    public void setVendas_id(int vendas_id) {
        this.vendas_id = vendas_id;
    }

    public int getVendasproduto_id() {
        return vendasproduto_id;
    }

    public void setVendasproduto_id(int vendasproduto_id) {
        this.vendasproduto_id = vendasproduto_id;
    }

    public double getVendasproduto_valor() {
        return valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }
    
    
    
    
}
