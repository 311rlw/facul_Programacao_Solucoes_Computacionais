package model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    
    public static double TAXA_DE_ENTREGA=8.99;
    
    public int id;
    public String endereco;
    public List <Produto> produtos;
    public Cliente cliente;
    private double valorTotal;
    
    
//    metodo construtor
    public Pedido(){
        this.produtos = new ArrayList<Produto>();
    }
    
    public Pedido(String endereco, Cliente cli){
        this.endereco = endereco;
        this.cliente = cli;
        this.produtos = new ArrayList<Produto>();
    }
    
//    metodo acessor (GET)
    public double getvalorTotal(){
        return this.valorTotal;
    }
    
//    metodo modificador (SET)
    public void setvalorTotal(double valor){
        if (valor >=TAXA_DE_ENTREGA)
        this.valorTotal=valor;
        else 
            System.out.println("Valor não permitido");
    }
    
    
//    alguma coisa  seila
    public void addProduto(Produto prod){
        if (this.produtos.size() == 0){
        this.valorTotal += TAXA_DE_ENTREGA;
    }
        this.produtos.add(prod);
        this.valorTotal+=prod.preco;
    }
    
/*    public void addProduto(Produto[] listaDeProdutos){
        for (Produto pr : listaDeProdutos){
            this.produtos.add(pr);
        }
*/    
    
    public void addProduto(Produto...p){
        if (this.produtos.size() == 0){
        this.valorTotal += TAXA_DE_ENTREGA;
    }
        for (Produto produto : p){
            this.produtos.add(produto);
            this.valorTotal+=produto.preco;
        }
        
        
            
    }
    
    public void imprimirPedido(){
        System.out.println("\n-------------Pedido------------ ");
        System.out.println("Pedido no endereço: " + this.endereco );
        System.out.println("Nome da Cidade do Cliente: " + this.cliente.cidade.nome);
        System.out.println("Nome do Cliente: " + this.cliente.nome );
        if(this.produtos.size()==0 ){
            System.out.println("Pedido Vazio");
        }else{
            System.out.println("Produtos do Pedido");
            for(Produto prod : this.produtos){
                System.out.println(prod.nome + " - " + prod.preco);
            }
            System.out.println("Valor total do pedido: R$ " + String.format("%.2f", valorTotal));
        }
    }
}
