
package view;

import dao.CategoriaDAO;
import dao.CidadeDAO;
import dao.ClienteDAO;
import dao.ProdutoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Categoria;
import model.Cidade;
import model.Cliente;
import model.Pedido;
import model.Produto;

public class MainTela {
    
    public static void main(String[] args) {
//      List<Cidade> cidades= ArrayList<Cidade>();
        List<Cidade> cidades= CidadeDAO.getCidades();
        
//      List<Cliente> clientes= new ArrayList<Cliente>();
        List<Cliente> clientes= ClienteDAO.getClientes();
        
//      List<Categoria> categorias= new ArrayList<Categoria>();
        List<Categoria> categorias= CategoriaDAO.getCategorias();
        
//        List<Produto> produtos= new ArrayList<Produto>();
        List<Produto> produtos= ProdutoDAO.getProduto();
        
        List<Pedido> pedidos = new ArrayList<Pedido>();
        
        int opcao=-1;
        do{
            opcao = mostrarMenu();
        switch (opcao) {
            case 0:
                break;
            case 1: 
//                cidades.add(cadastrarCidade());
                cadastrarCidade();
                break;
            
            case 2: 
                cidades = CidadeDAO.getCidades();
                
                if (cidades.size() == 0 ){
                    JOptionPane.showMessageDialog(null, "Necessário cadastrar cidade!");
                    cadastrarCidade();
                    cidades = CidadeDAO.getCidades();
                    cadastrarCliente(cidades);
                }else{
//                  clientes.add(cadastrarCliente(cidades));
                    cadastrarCliente(cidades);
                }    
                break;
            
            case 3: 
                cadastrarCategoria();
                break;
            
            case 4: 
                if (categorias.size() == 0 ){
                    JOptionPane.showMessageDialog(null, "Necessário cadastrar categoria!");
                    break;
                }else{
                    CategoriaDAO.getCategorias();
                    cadastrarProduto(categorias);
                    break;
                }
            
            case 5: 
                cidades = CidadeDAO.getCidades();
                listarCidades(cidades);
                break;
            
            case 6: 
                clientes = ClienteDAO.getClientes();
                listarClientes(clientes);
                break;
            
            case 7: 
                categorias = CategoriaDAO.getCategorias();
                listarCategorias(categorias);
                break;
            
            case 8:
                produtos = ProdutoDAO.getProduto();
                listarProdutos(produtos);
                break;
            
            case 9:
                pedidos.add(cadastrarPedido(pedidos,clientes));
                break;
            
            case 10:
                listarPedidos(pedidos);
                if ( pedidos.size() > 0){
                    if (produtos.size()  == 0 ){
                        JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado!");
                        break;
                    }else{
                            String idPedDigitado = JOptionPane.showInputDialog("Digite o ID do pedido: ");
                            if (idPedDigitado.isEmpty() ){
                                break;
                            }else{
                                try {
                                    int idPed = Integer.valueOf(idPedDigitado);
                                Pedido pedSelected = null;
                                for (Pedido pedido : pedidos) {
                                    if( pedido.id == idPed){
                                        pedSelected = pedido;
                                    }
                                }
                                addProdutoAoPedido(produtos, pedSelected);
                                break;

                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, e.toString() );
                                    break;
                                    }
                                }
                        }
                    }else{
                        break;
                    }
            
            case 11:
                listarPedidos(pedidos);
                break;
            
            case 12:
                visualizarPedido(pedidos);
                break;
            
            default:
                JOptionPane.showMessageDialog(null, "Opção Inválida");
                break;
        }
    }while (opcao !=0);
    }
    
    public static void listarCidades( List<Cidade> cidades){
        String texto = "Cidades Cadastradas: ";
        if (cidades.size() ==0) {
            texto += "\nNenhuma cidade cadastrada!";
        }
        
        for (Cidade cid: cidades){
            texto += "\n" + cid.id + " - " + cid.nome + "\n------------------" ;
        }
        JOptionPane.showMessageDialog(null, texto);
    }
    
    public static void listarCategorias( List<Categoria> categorias){
        String texto = "Categorias Cadastradas: ";
        if (categorias.size() ==0) {
            texto += "\nNenhuma categoria cadastrada!";
        }
        for (Categoria cat: categorias){
            texto += "\n" + cat.id + " - " + cat.nome + "\n------------------" ;
        }
        JOptionPane.showMessageDialog(null, texto);        
    }
    
    public static void listarClientes( List<Cliente> clientes){
        String texto = "Clientes Cadastrados: ";
        if (clientes.size() ==0) {
            texto += "\nNenhum cliente cadastrado!";
        }
        for (Cliente cli: clientes){
            texto += "\n" + cli.id + " - " + cli.nome +
                    "\nEndereço - " + cli.endereco +
                    "\nCidade - " + cli.cidade.nome + "\n------------------" ;
        }
        JOptionPane.showMessageDialog(null, texto);        
    }
    
    public static void listarProdutos( List<Produto> produtos){
        String texto = "Produtos Cadastrados: ";
        if (produtos.size() ==0) {
            texto += "\nNenhum produto cadastrado!";
            JOptionPane.showMessageDialog(null, texto);
        }
        for (Produto prod: produtos){
            texto +="\n" + prod.id + " - " + prod.nome +
                    "\nPreço - R$ " + prod.preco +
                    "\nQuantidade - " + prod.quantidade +
                    "\nCategoria - " + prod.categoria.nome + 
                    "\n------------------" ;
        }
        JOptionPane.showMessageDialog(null, texto);        
    }
    
    public static void listarPedidos(List<Pedido> pedidos){
        String texto = "Pedidos Registrados: ";
        if (pedidos.size() == 0) {
            texto += "Nenhum pedido registrado!";
            JOptionPane.showMessageDialog(null, texto);
            
        }else{
            for (Pedido ped : pedidos) {
                texto += "\n----------------Pedido----------------";
                texto += "\nID do Pedido: " + ped.id;
                texto += "\nPedido no endereço: " + ped.endereco;
                texto += "\nNome da Cidade do Cliente: " + ped.cliente.cidade.nome;
                texto += "\nNome do Cliente: " + ped.cliente.nome ;
                texto += "\nTotal do Pedido: R$ +"
                + String.format("%.2f", ped.getvalorTotal());
            }
        JOptionPane.showMessageDialog(null, texto);
        }
    }
    
    public static int mostrarMenu(){
        String texto = "-----=Loja=-----\n\n "+
                       "1 - Cadastrar Cidade\n " +
                       "2 - Cadastrar Cliente\n " +
                       "3 - Cadastrar Categoria\n " +
                       "4 - Cadastrar Produto\n " + 
                       "5 - Listar Cidades\n " +
                       "6 - Listar Clientes\n " +
                       "7 - Listar Categorias\n " +
                       "8 - Listar Produtos\n " +
                       "9 - Cadastrar Pedido\n " +
                       "10 - Adicionar Produtos ao Pedido\n " +
                       "11 - Listar Pedidos\n " +
                       "12 - Visualizar Pedido\n " +
                       "0 - Sair\n "+
                       "\nDigite a opção desejada: ";
        int opcao = -1;
        String opcaoDigitada = JOptionPane.showInputDialog(texto);
        if (!opcaoDigitada.isEmpty()) {
            opcao= Integer.valueOf(opcaoDigitada);
        }
        return opcao;
    }
    
    public static void cadastrarCidade(){
        String nome = JOptionPane.showInputDialog("Digite o nome da cidade");
        if( !nome.isEmpty() ) CidadeDAO.cadastrar(nome);
    }
    
/*    public static Cidade cadastrarCidade(){
        String idDigitado= JOptionPane.showInputDialog("Digite o ID da cidade");
        int id=0;
        if (! idDigitado.isEmpty() ){ 
            id = Integer.valueOf(idDigitado);
        }
        String nome = JOptionPane.showInputDialog("Digite o nome da cidade");
        Cidade novaCidade= new Cidade(id, nome);
        return novaCidade;
    }
*/
    
    public static void cadastrarCategoria(){
        String nome = JOptionPane.showInputDialog("Digite o nome da categoria");
        if( !nome.isEmpty() ) CategoriaDAO.cadastrar(nome);
    }
//        String idDigitado= JOptionPane.showInputDialog("Digite o ID da Categoria");
//        int id=0;
//        if (! idDigitado.isEmpty() ){ 
//            id = Integer.valueOf(idDigitado);
//        }
//        String nome = JOptionPane.showInputDialog("Digite o nome da Categoria");
//        Categoria novaCategoria= new Categoria(id, nome);
//        return novaCategoria;
//    }
    
    public static void cadastrarCliente(List<Cidade> municipios){
//        String idDigitado= JOptionPane.showInputDialog("Digite o id do cliente");
//        int id=0;
//        if (! idDigitado.isEmpty() ){ 
//            id = Integer.valueOf(idDigitado);
//        }
        String nome = JOptionPane.showInputDialog("Digite o nome do Cliente: ");
        String end = JOptionPane.showInputDialog("Digite o endereço do Cliente: ");
        
        String texto = "Cidades Cadastradas: ";
        for (Cidade cidade: municipios){
            texto += "\n" + cidade.id + " - " + cidade.nome;
        }
        texto += "\n Digite o id da cidade deste cliente";
        int idCidade = Integer.valueOf(JOptionPane.showInputDialog(texto));
        Cidade cidSelecionada = null;
        for (Cidade cidade : municipios) {
            if(cidade.id==idCidade){
                cidSelecionada = cidade;
            }
        }
        Cliente novoCliente = new Cliente(0, nome, end, cidSelecionada);
        ClienteDAO.cadastrar(novoCliente);       
    }
    
//    INICIO + ID
    public static void cadastrarProduto(List<Categoria> categorias){
//        String idDigitado= JOptionPane.showInputDialog("Digite o id do produto");
//        int id=0;
//        if (! idDigitado.isEmpty() ){ 
//            id = Integer.valueOf(idDigitado);
//        }
        String nome = JOptionPane.showInputDialog("Digite o nome do Produto: ");
        
        
//      PREÇO  
        String precoDigitado = JOptionPane.showInputDialog("Digite o preço: ");
        precoDigitado= precoDigitado.replace("," , ".");
        double preco = 0;
        if (!precoDigitado.isEmpty()) {
            preco = Double.valueOf(precoDigitado);
        }
        
//      QUANTIDADE
        String qtdDigitada = JOptionPane.showInputDialog("Digite a quantidade: ");
        qtdDigitada = qtdDigitada.replace(",", ".");
        double qtd = 0;
        if (!precoDigitado.isEmpty()) {
            
            qtd = Double.valueOf(qtdDigitada);
        }
        
        
        String texto = "Categorias Cadastradas: ";
        for (Categoria cat: categorias){
            texto += "\n" + cat.id + " - " + cat.nome;
        }
        
        texto += "\n Digite o id da categoria deste produto";
        
        int idCategoria = Integer.valueOf(JOptionPane.showInputDialog(texto));
        Categoria catSelecionada = null;
        for (Categoria cat : categorias) {
            if(cat.id==idCategoria){
                catSelecionada = cat;
            }
        }
        
        Produto novoProduto = new Produto(0,nome, preco, qtd, catSelecionada);
        ProdutoDAO.cadastrar(novoProduto);
                
    }
    
    public static Pedido cadastrarPedido(List<Pedido> pedidos, List<Cliente> clientes){
        String idDigitado = JOptionPane.showInputDialog("Digite o ID da Pedido: ");
		int id = 0;
		if( ! idDigitado.isEmpty() ){
			id = Integer.valueOf( idDigitado );
		}
		String end = JOptionPane.showInputDialog("Digite o endereço de entrega: ");
		String texto = "Clientes cadastrados:";
		for (Cliente cli : clientes) {
			texto += "\n " + cli.id +  " - " + cli.nome;
		}
		texto += "\n  Digite o id do cliente deste Pedido: ";
		int idCliente = Integer.valueOf(  JOptionPane.showInputDialog(texto) );
		Cliente cliSelecionado = null;
		for (Cliente cli : clientes) {
			if( cli.id == idCliente ){
				cliSelecionado = cli;
			}
		}
		Pedido novoPedido = new Pedido();
		novoPedido.id = id;
		novoPedido.endereco = end;
		novoPedido.cliente = cliSelecionado;
		return novoPedido;
                
    }
    
    public static void addProdutoAoPedido(List<Produto> produtos, Pedido pedido){
		String texto = "Produtos cadastrados:";
		if( produtos.size() == 0 ){
			texto += "\n\nNenhum produto cadastrado";
		}
		for ( Produto prod: produtos ) {
			texto += "\n " + prod.id +  " - " + prod.nome + 
				 "\nPreço: R$ " + prod.preco +
				 "\nQuantidade: " + prod.quantidade +
				 "\nCategoria: " + prod.categoria.nome + 
				 "\n-------------------------" ;
		}
		texto += "\n\nDigite o id do Produto";
		String idDigitado = JOptionPane.showInputDialog(null, texto);
		int idProduto = 0;
		if( !idDigitado.isEmpty() ){
			idProduto = Integer.valueOf( idDigitado ) ;
		}

		Produto prodSelecionado = null;
		for (Produto produto : produtos) {
			if( produto.id == idProduto){
				prodSelecionado = produto;
			}
		}
		pedido.addProduto( prodSelecionado );

		
	} 
    
    public static void visualizarPedido(List<Pedido> pedidos){
		int idPedido = Integer.valueOf( JOptionPane.showInputDialog("Id do Pedido:") );
		Pedido pedSelecionado = null;
		for (Pedido pedido : pedidos) {
			if( pedido.id == idPedido){
				pedSelecionado = pedido;
			}
		}
		String texto = "";
		texto += "Pedido no end: " + pedSelecionado.endereco ;
		texto += "\nNome do Cliente: " + pedSelecionado.cliente.nome;
		texto += "\nNome da cidade do Cliente: " + pedSelecionado.cliente.cidade.nome;
		texto += "\nTotal do Pedido: R$ " + 
			 String.format("%.2f",  pedSelecionado.getvalorTotal());
		if( pedSelecionado.produtos.size() == 0 ){
			texto += "\nPedido Vazio";
		}else{
			texto += "\nProdutos do Pedido";
			for (Produto prod : pedSelecionado.produtos ) {
				texto += "\n" + prod.nome + " - " + prod.preco + " - " + prod.categoria.nome;
			}
		}
		JOptionPane.showMessageDialog(null, texto);
        }
    }
