package github.com.JoaoBraga1996.msavaliadordecredito.infra.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import github.com.JoaoBraga1996.msavaliadordecredito.application.domain.model.CartaoCliente;

@FeignClient(value = "mscartoes",  path = "/cartoes")
public interface CartoesResourceClient {
	
	@GetMapping(params = "cpf")
	ResponseEntity<List<CartaoCliente>> getCartoesByClientes(@RequestParam("cpf") String cpf);

}
