package br.com.vendaProduto.bean;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.vendaProduto.DAO.CupomDAO;
import br.com.vendaProduto.domain.Cupom;

/**
*
* @author Kauai Guarilha
*/
@ViewScoped
@ManagedBean
public class CupomBean {

	private Cupom cupom;
	private List<Cupom> cupons;	
	
	public void setCupom(Cupom cupom) {
		this.cupom = cupom;
	}
	
	public Cupom getCupom() {
		return cupom;
	}
	
	public void setCupons(List<Cupom> cupons) {
		this.cupons = cupons;
	}
	
	public List<Cupom> getCupons() {
		return cupons;
	}
	
	public void novo() {
		cupom = new Cupom();
	}
	
	
	public void salvar() {
		
		try{
			CupomDAO cupomDao = new CupomDAO();
			
			cupomDao.merge(cupom);
			
			cupons = cupomDao.listagem();
			
			novo();
			
			Messages.addGlobalInfo("Salvo com sucesso !");
			
			
		}catch(RuntimeException ex) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o Produto!" + ex);
			ex.printStackTrace();
		}
    }

	@PostConstruct 
    public void listar() {
			
		try {
			CupomDAO cupomDao = new CupomDAO();
				
			cupons = cupomDao.listagem();
				
				
		}catch (RuntimeException ex) {
			Messages.addGlobalError("Ocorreu um erro ao tentar Listar" + ex);
			ex.printStackTrace();
		}
    }
	
	public void exclusao(ActionEvent evento) {
		
        try {
			
			cupom = (Cupom) evento.getComponent().getAttributes().get("cupomSelecionado");
			
			CupomDAO cupomDao = new CupomDAO();
			
			cupomDao.exclusao(cupom);
			
			cupons = cupomDao.listagem();
			
			Messages.addGlobalInfo("Excluído com sucesso!");
			
		}catch(RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao fazer a exclusão!");
			erro.printStackTrace();
		}	
	}
	
	public void alteracao(ActionEvent evento) {
		cupom = (Cupom) evento.getComponent().getAttributes().get("cupomSelecionado");
	}	
}
