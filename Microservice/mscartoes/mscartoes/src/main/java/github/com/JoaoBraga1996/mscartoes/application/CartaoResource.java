package github.com.JoaoBraga1996.mscartoes.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import github.com.JoaoBraga1996.mscartoes.application.representation.CartaoSaveRequest;
import github.com.JoaoBraga1996.mscartoes.application.representation.CartoesPorClienteResponse;
import github.com.JoaoBraga1996.mscartoes.domain.Cartao;
import github.com.JoaoBraga1996.mscartoes.domain.ClienteCartao;

@RestController
@RequestMapping("cartoes")
public class CartaoResource {

	@Autowired
	CartaoService service;

	@Autowired
	ClienteCartaoService clienteCartaoService;

	@GetMapping(params = "renda")
	public ResponseEntity<List<Cartao>> getCartoesRendaAteh(@RequestParam("renda") Long renda) {
		List<Cartao> list = service.getCartoesRendaMenorIgual(renda);
		return ResponseEntity.ok(list);
	}

	@GetMapping(params = "cpf")
	public ResponseEntity<List<CartoesPorClienteResponse>> getCartoesByClientes(@RequestParam("cpf") String cpf) {
		List<ClienteCartao> lista = clienteCartaoService.listCartoesByCpf(cpf);
		List<CartoesPorClienteResponse> resultList = lista.stream().map(CartoesPorClienteResponse::fromModel).toList();
		return ResponseEntity.ok(resultList);

	}

	@PostMapping
	public ResponseEntity<Cartao> cadastra(@RequestBody CartaoSaveRequest request) {
		Cartao cartao = request.toModel();
		service.save(cartao);
		return ResponseEntity.status(HttpStatus.CREATED).body(cartao);
	}

}