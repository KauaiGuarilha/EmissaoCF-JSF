package br.com.vendaCupom.DAO;

import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import br.com.vendaProduto.DAO.ProdutoDAO;
import br.com.vendaProduto.domain.Produto;

/**
*
* @author Kauai Guarilha
*/
public class ProdutoDAOTest {

	@SuppressWarnings("unused")
	@Test
	@Ignore
    public void incluir() {
		
		Produto produto = new Produto();
		
		produto.setNome("Leite 500ml");
		produto.setValor(2.40);
		
		ProdutoDAO produtoDao = new ProdutoDAO();		
		
		if(produto == null) {
			System.out.println("Faça o cadastro!");
		}else {
		System.out.println("Produto Incluído com sucesso!");
		    produtoDao.inclusao(produto);
		}
	}
	
	@Test
	@Ignore
	public void editar() { 
		Long codigo = 2L;
		
		ProdutoDAO  produtoDao = new ProdutoDAO();
		Produto produto = produtoDao.buscar(codigo);
	    
		if(produto == null) {
			System.out.println("Nenhum produto encontrado.");
		}else {						
			produto.setValor(4.8);
			produtoDao.alteracao(produto);
		}
	}
	
	@Test	
	@Ignore
	public void excluir() {
		
        Long codigo = 3L;
		
		ProdutoDAO produtoDao = new ProdutoDAO();
		
		Produto produto = produtoDao.buscar(codigo);
		
		if(produto == null) {
			System.out.println("Nenhum produto encontrado!");
		}else {
			produtoDao.exclusao(produto);
		}		
	}
	
	@Test
	@Ignore
	public void listar() {
		
		ProdutoDAO produtoDao = new ProdutoDAO();
		
		List<Produto> resultado = produtoDao.listagem();
		
		for(Produto produto: resultado) {
			System.out.println("Código produto: " + produto.getId_produto() + " | Nome: " + produto.getNome() + " | Valor: " + produto.getValor());
		}	
	}
	
	@Test	
	@Ignore
    public void buscar() {
       
    	Long codigo = 2L;
    	
    	ProdutoDAO produtoDao = new ProdutoDAO();
		
    	Produto produto = produtoDao.buscar(codigo);
		
		System.out.println("Código produto: " + produto.getId_produto() + " | Nome: " + produto.getNome() + " | Valor: " + produto.getValor());
			
    }
	
}
