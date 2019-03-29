package br.com.vendaProduto.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
*
* @author Kauai Guarilha
*/
@Entity
public class Item_Cupom {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Long id_item_cupom;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Cupom cupom;
	
	@Column(nullable = false)
	private int quantidade;
	
	@Column(nullable = false, precision = 6, scale = 2)
	private double valor_unitario;

	public Long getId_item_cupom() {
		return id_item_cupom;
	}

	public void setId_item_cupom(Long id_item_cupom) {
		this.id_item_cupom = id_item_cupom;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Cupom getCupom() {
		return cupom;
	}

	public void setCupom(Cupom cupom) {
		this.cupom = cupom;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValor_unitario() {
		return valor_unitario;
	}

	public void setValor_unitario(double valor_unitario) {
		this.valor_unitario = valor_unitario;
	}

	// Gerado o hashCode() and equals(Object obj), pra que entenda oque puxar no combobox
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_item_cupom == null) ? 0 : id_item_cupom.hashCode());
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
		Item_Cupom other = (Item_Cupom) obj;
		if (id_item_cupom == null) {
			if (other.id_item_cupom != null)
				return false;
		} else if (!id_item_cupom.equals(other.id_item_cupom))
			return false;
		return true;
	}	
	
	

}
