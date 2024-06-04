package view;

import javax.swing.JOptionPane;
import model.Categoria;
import model.Cidade;
import model.Cliente;
import model.ClienteFisico;
import model.ClienteJuridico;
import model.Pedido;
import model.Produto;

public class Main {
    public static void main(String[] args) {
        System.out.println("Projeto Lolja");
        
        Cidade c1 = new Cidade(1, "Ponte Nova");
        Cidade c2 = new Cidade(2, "Porto Alegre");
        Cidade c3 = new Cidade(3, "Rio de Janeiro");        
        
        System.out.println("Cidade " + c1.id + ": " + c1.nome);
        System.out.println("Cidade " + c2.id + ": " + c2.nome);
        System.out.println("Cidade " + c3.id + ": " + c3.nome);
        
        Cliente cli1 = new Cliente();
        cli1.nome="João";
        cli1.cidade=c2;
        
        Cliente cli2 = new Cliente();
        cli2.nome = "Bruto";
        cli2.cidade=c1;
        
        Cliente cli3 = new Cliente(3, "Jeová", "Rua Benevolente, 53", c3);
        
        Cliente cli4 = new Cliente(4, "Santo Mais", "Rua Salmonela, 023", new Cidade ("Tangamandapio") );
        
        cli3.cidade = cli4.cidade;
        
        //System.out.println("Cliente: " + cli4.nome + "\nCidade: " + cli4.cidade.nome);
        System.out.println(cli4);
        //String texto=("Cliente: " + cli4.nome + "\nCidade: " + cli4.cidade.nome);
        //JOptionPane.showMessageDialog(null, cli2);

        //System.out.println("=============AIDS GENIAL===============");
        //System.out.println(c3);
        
        Cidade[] cidades={c1,c2,c3};
        for (Cidade cid: cidades){
            System.out.println("=============TESOURA===============");
            System.out.println(cid);
        }
        
        System.out.println("\n\n---23/04/24 ---");
        
        ClienteFisico pf1 = new ClienteFisico();
        pf1.nome= "Berimlau";
        pf1.cidade=c1;
        pf1.endereco="Rua Mão de leite";
        System.out.println("Nome do Cliente PF1: " + pf1.nome);
        
        System.out.println("-----barra-----");
        
        ClienteFisico pf2 = new ClienteFisico("Adalto","943.234.432-94");
        pf2.cidade=c2;
        
        ClienteFisico pf3 = new ClienteFisico(3, "Ruam", "Rua Quati", c3, "000.123.322-99", 1.84, true);    
        
        ClienteJuridico pj1 = new ClienteJuridico();
        pj1.nome= "Sebas Burguer";
        pj1.cnpj="392.493.932-90";
        pj1.endereco="Rua Joao dos Bentos";
        pj1.cidade=c3;
        System.out.println(pj1);
//        JOptionPane.showMessageDialog(null, pj1);

        ClienteJuridico pj2 = new ClienteJuridico(2, "Sano Colchões", "943.384.023-99", "Rua Ao Luar", c2);
        System.out.println(pj2);
//        JOptionPane.showMessageDialog(null, pj2);
        


//         30/04/24 --------
        

        System.out.println("\n----30/04/24----\n");
        
        Categoria cat01 = new Categoria(1, "Bebidas");
        Categoria cat02 = new Categoria(2, "Alimentos");
        
        Produto prod01 = new Produto("Coca Cola");
        prod01.preco= 8.99;
        prod01.quantidade= 100;
        prod01.categoria= cat01;
        
        Produto prod02 = new Produto(2, "Pepsi", 7.65, 90, cat01);
        Produto prod03 = new Produto(3, "Arroz", 4.99, 80, cat02);
        
        Pedido ped01 = new Pedido("Rua A, 150", pf2);
        
        ped01.imprimirPedido();
        
        ped01.addProduto(prod02);
        ped01.imprimirPedido();
        
        //ped01.addProduto(new Produto[] {prod01, prod03, prod03});
        ped01.addProduto(prod01, prod03, prod03);
        
        
        ped01.imprimirPedido();
        
        System.out.println("-----------Modificadores e acessores----------");
        ped01.setvalorTotal(10);
        System.out.println("Total do pedido: " + ped01.getvalorTotal());
        System.out.println("Taxa de entrega: " + Pedido.TAXA_DE_ENTREGA);
    }
    
    
}
