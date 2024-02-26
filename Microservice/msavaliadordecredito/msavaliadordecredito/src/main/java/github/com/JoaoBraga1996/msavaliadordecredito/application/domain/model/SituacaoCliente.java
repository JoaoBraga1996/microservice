package github.com.JoaoBraga1996.msavaliadordecredito.application.domain.model;

import java.util.List;

public class SituacaoCliente {

	private DadosCliente cliente;
	private List<CartaoCliente> cartoes;

	public SituacaoCliente(DadosCliente cliente, List<CartaoCliente> cartoes) {

		this.cliente = cliente;
		this.cartoes = cartoes;
	}

	public SituacaoCliente() {
	}

	public DadosCliente getCliente() {
		return cliente;
	}

	public void setCliente(DadosCliente cliente) {
		this.cliente = cliente;
	}

	public List<CartaoCliente> getCartoes() {
		return cartoes;
	}

	public void setCartoes(List<CartaoCliente> cartoes) {
		this.cartoes = cartoes;
	}

}
