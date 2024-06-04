package model;

public class Cidade {
    
    public int id;;
    public String nome;
    
//metodo construtor que nao recebe parametro
    
    public Cidade(){
        this.id=0;
        this.nome="Sem Nome";
    }
    
    public Cidade(String nome){
        this.id=0;
        this.nome= nome;
    }
    
    public Cidade(int id, String nome){
        this.id=id;
        this.nome= nome;
    }
    @Override
    public String toString(){
        return "Cidade: \n  Nome: "+ this.nome + "\n  Id: " + this.id ;
    }
    
}
