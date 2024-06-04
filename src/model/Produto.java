package model;

public class Produto {
    public int id;
    public String nome;
    public double preco, quantidade;
    public Categoria categoria;
    
    public Produto(){
        
    }
    
    public Produto(String nome ){
        this.nome = nome;
    }
    public Produto(int id, String nome, double preco, double quantidade, Categoria categoria ){
        this.nome = nome;
        this.preco= preco;
        this.id=id;
        this.quantidade=quantidade;
        this.categoria=categoria;
    }
}
