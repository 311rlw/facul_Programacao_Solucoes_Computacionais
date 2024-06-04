
package model;

public class ClienteJuridico extends Cliente {
    
    public String cnpj;
    
    public ClienteJuridico(){
        super();
    }
    
    public ClienteJuridico(String nome){
        super(nome);
    }
    
    public ClienteJuridico(int id, String nome, String cnpj, String endereco, Cidade cidade){
        super(id, nome, endereco, cidade);
        this.cnpj=cnpj;
    }
    
      @Override
    public String toString() {
       String txt = "----------------Cliente Jur�dico----------------\n" +
                    "Nome da empresa: " + this.nome +
                    "\nCNPJ: " + this.cnpj +
                    "\nEndere�o: " + this.endereco +
                    "\nCidade: " + this.cidade.nome;
        return txt;
       
    }
}
