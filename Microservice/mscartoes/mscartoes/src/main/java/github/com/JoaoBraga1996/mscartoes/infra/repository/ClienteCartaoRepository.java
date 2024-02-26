package github.com.JoaoBraga1996.mscartoes.infra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import github.com.JoaoBraga1996.mscartoes.domain.ClienteCartao;

public interface ClienteCartaoRepository extends JpaRepository<ClienteCartao, Long> {

	List<ClienteCartao> findByCpf(String cpf);

}
