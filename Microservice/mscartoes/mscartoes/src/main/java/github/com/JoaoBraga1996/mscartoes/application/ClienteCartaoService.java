package github.com.JoaoBraga1996.mscartoes.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import github.com.JoaoBraga1996.mscartoes.domain.ClienteCartao;
import github.com.JoaoBraga1996.mscartoes.infra.repository.ClienteCartaoRepository;

@Service
public class ClienteCartaoService {
	
	@Autowired
	ClienteCartaoRepository repository;
	
	
	public List<ClienteCartao>  listCartoesByCpf(String cpf){
		return repository.findByCpf(cpf);
	}
	
	

}
