package github.com.JoaoBraga1996.msavaliadordecredito.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import github.com.JoaoBraga1996.msavaliadordecredito.application.domain.model.SituacaoCliente;
import github.com.JoaoBraga1996.msavaliadordecredito.ex.DadosClienteNotFoundException;
import github.com.JoaoBraga1996.msavaliadordecredito.ex.ErroComunicacaoMicroServicesException;

@RestController
@RequestMapping("avaliacoes-credito")
public class AvaliadorCreditoResource {

	@Autowired
	AvaliadorCreditoService service;

	@GetMapping(value = "situacao-cliente", params = "cpf")
	public ResponseEntity consultaSituacaoCliente(@RequestParam("cpf") String cpf) {

		try {
			SituacaoCliente situacaoCliente = service.obterSituacaoCliente(cpf);
			return ResponseEntity.ok(situacaoCliente);

		} catch (DadosClienteNotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (ErroComunicacaoMicroServicesException e) {
			return ResponseEntity.status(HttpStatus.resolve(e.getStatus())).body(e.getMessage());

		}
	}

}
