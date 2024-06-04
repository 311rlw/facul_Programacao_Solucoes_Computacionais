package model;

public class Cliente {
    
    public int id;;
    public String nome, endereco;
    public Cidade cidade;
    
    public Cliente(){
        this.nome="Sem Nome";
    }
    
    public Cliente(String nome){
        this.nome=nome;
    }
    public Cliente(int id, String nome, String endereco, Cidade cidade){
        this.id=id;
        this.nome=nome;
        this.endereco=endereco;
    //  this.altura=altura;
    //  this.casado=casado;
        this.cidade=cidade;
    }
    
    @Override
    public String toString(){
        String texto = "Cliente: " + this.nome +
                       "\nEndereço: " + this.endereco +
                       "\nCidade: " + this.cidade.nome;
        return texto;
    }
}
