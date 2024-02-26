package github.com.JoaoBraga1996.mscartoes.application.representation;

import github.com.JoaoBraga1996.mscartoes.domain.BandeiraCartao;
import github.com.JoaoBraga1996.mscartoes.domain.Cartao;

import java.math.BigDecimal;

public class CartaoSaveRequest {

	private String nome;
	private BandeiraCartao bandeira;
	private String BigDecimal;
	private BigDecimal renda;
	private BigDecimal limite;

	public CartaoSaveRequest() {
	}

	public CartaoSaveRequest(String nome, BandeiraCartao bandeira, String bigDecimal, BigDecimal renda,
			BigDecimal limite) {
		this.nome = nome;
		this.bandeira = bandeira;
		this.renda = renda;
		this.limite = limite;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BandeiraCartao getBandeira() {
		return bandeira;
	}

	public void setBandeira(BandeiraCartao bandeira) {
		this.bandeira = bandeira;
	}

	public String getBigDecimal() {
		return BigDecimal;
	}

	public void setBigDecimal(String bigDecimal) {
		BigDecimal = bigDecimal;
	}

	public java.math.BigDecimal getRenda() {
		return renda;
	}

	public void setRenda(java.math.BigDecimal renda) {
		this.renda = renda;
	}

	public java.math.BigDecimal getLimite() {
		return limite;
	}

	public void setLimite(java.math.BigDecimal limite) {
		this.limite = limite;
	}

	public Cartao toModel() {
		return new Cartao(nome, bandeira, renda, limite);
	}
}