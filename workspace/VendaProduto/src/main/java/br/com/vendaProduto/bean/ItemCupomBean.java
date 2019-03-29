package br.com.vendaProduto.bean;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.omnifaces.util.Messages;

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
@ViewScoped
@ManagedBean
public class ItemCupomBean {
		
	private Item_Cupom itemCupom;
	private List<Item_Cupom> itemCupons;
	private List<Produto> produtos;
	private List<Cupom> cupons;
	
	
	public void setItemCupom(Item_Cupom itemCupom) {
		this.itemCupom = itemCupom;
	}
	
	public Item_Cupom getItemCupom() {
		return itemCupom;
	}
	
	public void setItemCupons(List<Item_Cupom> itemCupons) {
		this.itemCupons = itemCupons;
	}
	
	public List<Item_Cupom> getItemCupons() {
		return itemCupons;
	}
	
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	
	public void setCupons(List<Cupom> cupons) {
		this.cupons = cupons;
	}
	
	public List<Cupom> getCupons() {
		return cupons;
	}
	
	public void novo() {
		
		try {
			itemCupom = new Item_Cupom();
			CupomDAO cupomDao = new CupomDAO();  
	        ProdutoDAO produtoDao = new ProdutoDAO();        
	        
	        produtos = produtoDao.listagem("nome");            
	        cupons = cupomDao.listagem("id_cupom");
        
	     }catch(RuntimeException ex) {
		
			Messages.addGlobalError("Ocorreu um erro ao tentar Listar" + ex);
			ex.printStackTrace();
	    }
	}
	
	public void salvar() {
		try {
			
            Item_CupomDAO itemCupomDao = new Item_CupomDAO();
			
			itemCupomDao.merge(itemCupom);
			
			itemCupom = new Item_Cupom();
									
			ProdutoDAO produtoDao = new ProdutoDAO();			
			produtos = produtoDao.listagem("nome");
			
			CupomDAO cupomDao = new CupomDAO();
			cupons = cupomDao.listagem("id_cupom");			

			itemCupons = itemCupomDao.listagem();
			
			novo();				
			
			Messages.addGlobalInfo("Salvo com sucesso !");
			
		}catch(RuntimeException ex) {
			Messages.addGlobalError("Ocorreu um erro ao tentar Listar" + ex);
			ex.printStackTrace();
		}
	}	
	
	@PostConstruct 
    public void listar() {
		
		try {
			Item_CupomDAO itemCupomDao = new Item_CupomDAO();
			
			itemCupons = itemCupomDao.listagem();
			
			
			
		}catch(RuntimeException ex) {
			
			Messages.addGlobalError("Ocorreu um erro ao tentar Listar" + ex);
			ex.printStackTrace();
		}
	}
	
    public void exclusao(ActionEvent evento) {
		
        try {
			
			itemCupom = (Item_Cupom) evento.getComponent().getAttributes().get("itemCupomSelecionado");
			
			Item_CupomDAO itemCupomDao = new Item_CupomDAO();
			
			itemCupomDao.exclusao(itemCupom);
			
			itemCupons = itemCupomDao.listagem();
			
			Messages.addGlobalInfo("Excluído com sucesso!");
			
		}catch(RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao fazer a exclusão!");
			erro.printStackTrace();
		}	
	}
	
	public void alteracao(ActionEvent evento) {
		
		try {
			itemCupom = (Item_Cupom) evento.getComponent().getAttributes().get("itemCupomSelecionado");
			
			CupomDAO cupomDao = new CupomDAO();  
	        ProdutoDAO produtoDao = new ProdutoDAO();        
	        
	        produtos = produtoDao.listagem("nome");            
	        cupons = cupomDao.listagem("id_cupom");
        
	     }catch(RuntimeException ex) {
		
			Messages.addGlobalError("Ocorreu um erro ao tentar Listar" + ex);
			ex.printStackTrace();
	    }
			
	}
}

	

