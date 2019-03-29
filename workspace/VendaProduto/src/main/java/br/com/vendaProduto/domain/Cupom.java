package br.com.vendaProduto.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
*
* @author Kauai Guarilha
*/
@Entity
public class Cupom {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Long id_cupom;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date dh_emissao;

	public Long getId_cupom() {
		return id_cupom;
	}

	public void setId_cupom(Long id_cupom) {
		this.id_cupom = id_cupom;
	}

	public Date getDh_emissao() {
		return dh_emissao;
	}

	public void setDh_emissao(Date dh_emissao) {
		this.dh_emissao = dh_emissao;
	}

	// Gerado o hashCode() and equals(Object obj), pra que entenda oque puxar no combobox
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_cupom == null) ? 0 : id_cupom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cupom other = (Cupom) obj;
		if (id_cupom == null) {
			if (other.id_cupom != null)
				return false;
		} else if (!id_cupom.equals(other.id_cupom))
			return false;
		return true;
	}	
	
	
}

