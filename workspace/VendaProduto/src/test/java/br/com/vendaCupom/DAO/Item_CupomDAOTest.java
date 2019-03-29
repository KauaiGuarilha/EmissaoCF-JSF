package br.com.vendaCupom.DAO;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.vendaProduto.DAO.CupomDAO;
import br.com.vendaProduto.DAO.Item_CupomDAO;
import br.com.vendaProduto.DAO.ProdutoDAO;
import br.com.vendaProduto.domain.Cupom;
import br.com.vendaProduto.domain.Item_Cupom;
import br.com.vendaProduto.domain.Produto;

/**
*
* @author Kauai Guarilha
*/
public class Item_CupomDAOTest {

	@SuppressWarnings("unused")
	@Test
	@Ignore
    public void incluir() {
		
		Long codProd = 3L;
		Long codCup = 2L;
		
		Item_Cupom itemCupom = new Item_Cupom();
		Produto produto = new Produto();
		Cupom cupom = new Cupom();
		
		Item_CupomDAO itemCupomDao = new Item_CupomDAO();
		ProdutoDAO produtoDao = new ProdutoDAO();
		CupomDAO cupomDao = new CupomDAO();
		
		produto = produtoDao.buscar(codProd);
		cupom = cupomDao.buscar(codCup);
		
		itemCupom.setProduto(produto);
		itemCupom.setCupom(cupom);
		itemCupom.setQuantidade(40);
		itemCupom.setValor_unitario(54.8);			
		
		if(itemCupom == null) {
			System.out.println("Faça o cadastro!");
		}else {
		System.out.println("itemCupom Incluído com sucesso!");
		    itemCupomDao.inclusao(itemCupom);	
		}
	}
	
	@Test
	@Ignore
	public void editar() { 
		Long codProd = 1L;
		Long codCup = 1L;
		
		Item_CupomDAO itemCupomDao = new Item_CupomDAO();
		ProdutoDAO produtoDao = new ProdutoDAO();
		CupomDAO cupomDao = new CupomDAO();
		
		Item_Cupom itemCupom = new Item_Cupom();
		Produto produto = produtoDao.buscar(codProd);
		Cupom cupom = cupomDao.buscar(codCup);
	    
		if(produto == null) {
			System.out.println("Nenhum itemCupom encontrado.");
		}else {						
			itemCupom.setProduto(produto);
			itemCupom.setCupom(cupom);
			itemCupom.setQuantidade(20);
			itemCupom.setValor_unitario(30.5);			
			
			itemCupomDao.alteracao(itemCupom);
		}
	}
	
	@Test	
	@Ignore
	public void excluir() {
		
        Long codigo = 3L;
		
        Item_CupomDAO itemCupomDao = new Item_CupomDAO();
        
        Item_Cupom itemCupom = itemCupomDao.buscar(codigo);		
		
		if(itemCupom == null) {
			System.out.println("Nenhum produto encontrado!");
		}else {
			itemCupomDao.exclusao(itemCupom);
		}		
	}
	
	@Test
	@Ignore
	public void listar() {
		
		Item_CupomDAO itemCupomDao = new Item_CupomDAO();
		
		List<Item_Cupom> resultado = itemCupomDao.listagem();
		
		for(Item_Cupom itemCupom : resultado) {
			System.out.println("Código ItemCupom: " + itemCupom.getId_item_cupom() + " | Nome Produto: " + itemCupom.getProduto().getNome() +
					" | Data de emissão: " + itemCupom.getCupom().getDh_emissao() + " | Quantidade: " + itemCupom.getQuantidade() + 
					" | Valor Unitário: " + itemCupom.getValor_unitario());	
		}	
	}
	
	@Test
	@Ignore
    public void buscar() {
       
    	Long codigo = 1L;
    	
    	Item_CupomDAO itemCupomDao = new Item_CupomDAO();
		
    	Item_Cupom itemCupom = itemCupomDao.buscar(codigo);
		
		System.out.println("Código ItemCupom: " + itemCupom.getId_item_cupom() + " | Nome Produto: " + itemCupom.getProduto().getNome() +
				" | Data de emissão: " + itemCupom.getCupom().getDh_emissao() + " | Quantidade: " + itemCupom.getQuantidade() + 
				" | Valor Unitário: " + itemCupom.getValor_unitario());			
    }
}
