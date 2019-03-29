package br.com.vendaCupom.DAO;

import java.util.Date;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import br.com.vendaProduto.DAO.CupomDAO;
import br.com.vendaProduto.domain.Cupom;

/**
*
* @author Kauai Guarilha
*/
public class CupomDAOTest {

	@SuppressWarnings("unused")
	@Test
	@Ignore
    public void incluir() {
		
		Cupom cupom = new Cupom();
		
		cupom.setDh_emissao(new Date());
		
		CupomDAO cupomDao = new CupomDAO();		
		
		if(cupom == null) {
			System.out.println("Faça o cadastro!");
		}else {
		System.out.println("Produto Incluído com sucesso!");
		    cupomDao.inclusao(cupom);
		}
	}
	
	@Test
	@Ignore
	public void editar() { 
		Long codigo = 2L;
		
		CupomDAO cupomDao = new CupomDAO();	
		Cupom cupom = cupomDao.buscar(codigo);
	    
		if(cupom == null) {
			System.out.println("Nenhum produto encontrado.");
		}else {						
			cupom.setDh_emissao(new Date());
			cupomDao.alteracao(cupom);
		}
	}
	
	@Test
	@Ignore
	public void excluir() {
		
        Long codigo = 3L;
		
        CupomDAO cupomDao = new CupomDAO();	
		Cupom cupom = cupomDao.buscar(codigo);
		
		if(cupom == null) {
			System.out.println("Nenhum produto encontrado.");
		}else {	
			cupomDao.exclusao(cupom);
		}		
	}
	
	@Test
	@Ignore
	public void listar() {
		
		 CupomDAO cupomDao = new CupomDAO();	
		
		List<Cupom> resultado = cupomDao.listagem();
		
		for(Cupom cupom: resultado) {
			System.out.println("Código do Cupom: " + cupom.getId_cupom() + " | Data de Cadastro: " + cupom.getDh_emissao());
		}	
	}
	
	@Test
	@Ignore
    public void buscar() {
       
    	Long codigo = 2L;
    	
    	CupomDAO cupomDao = new CupomDAO();	
		Cupom cupom = cupomDao.buscar(codigo);
		
		System.out.println("Código do Cupom: " + cupom.getId_cupom() + " | Data de Cadastro: " + cupom.getDh_emissao());
			
    }
	
	
}
