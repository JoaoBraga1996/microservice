package github.com.JoaoBraga1996.mscartoes.application;

import github.com.JoaoBraga1996.mscartoes.domain.Cartao;
import github.com.JoaoBraga1996.mscartoes.infra.repository.CartaoRepository;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CartaoService {

	@Autowired
	private CartaoRepository repository;

	@Transactional
	public Cartao save(Cartao cartao) {
		return repository.save(cartao);
	}

	@Transactional
	public List<Cartao> getCartoesRendaMenorIgual(Long renda) {
		var rendaBigDecimal = BigDecimal.valueOf(renda);
		return repository.findByRendaLessThanEqual(rendaBigDecimal);

	}

}
