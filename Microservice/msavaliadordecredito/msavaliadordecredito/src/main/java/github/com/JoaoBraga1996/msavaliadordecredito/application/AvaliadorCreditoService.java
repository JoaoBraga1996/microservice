package github.com.JoaoBraga1996.msavaliadordecredito.application;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import feign.FeignException.FeignClientException;
import github.com.JoaoBraga1996.msavaliadordecredito.application.domain.model.CartaoCliente;
import github.com.JoaoBraga1996.msavaliadordecredito.application.domain.model.DadosCliente;
import github.com.JoaoBraga1996.msavaliadordecredito.application.domain.model.SituacaoCliente;
import github.com.JoaoBraga1996.msavaliadordecredito.ex.DadosClienteNotFoundException;
import github.com.JoaoBraga1996.msavaliadordecredito.ex.ErroComunicacaoMicroServicesException;
import github.com.JoaoBraga1996.msavaliadordecredito.infra.clients.CartoesResourceClient;
import github.com.JoaoBraga1996.msavaliadordecredito.infra.clients.ClienteResourceClient;

@Service
public class AvaliadorCreditoService {

	@Autowired
	private ClienteResourceClient clienteClient;

	@Autowired
	private CartoesResourceClient cartoesClient;

	public SituacaoCliente obterSituacaoCliente(String cpf)
			throws DadosClienteNotFoundException, ErroComunicacaoMicroServicesException {
		try {
			ResponseEntity<DadosCliente> dadosClienteResponse = clienteClient.dadosCliente(cpf);
			ResponseEntity<List<CartaoCliente>> cartoesResponse = cartoesClient.getCartoesByClientes(cpf);

			SituacaoCliente situacaoCliente = new SituacaoCliente();
			situacaoCliente.setCliente(dadosClienteResponse.getBody());
			situacaoCliente.setCartoes(cartoesResponse.getBody());

			return situacaoCliente;

		} catch (FeignClientException e) {
			int status = e.status();
			if (HttpStatus.NOT_FOUND.value() == status) {
				throw new DadosClienteNotFoundException();

			}

			throw new ErroComunicacaoMicroServicesException(e.getMessage(), status);
		}

	}

}
