package github.com.Joaobraga1996.msclientes.application;

import github.com.Joaobraga1996.msclientes.application.representation.ClienteSaveRequest;
import github.com.Joaobraga1996.msclientes.domain.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;


import java.net.URI;

@RestController
@RequestMapping("clientes")
public class ClienteResource {

    @Autowired
    ClienteService service;

    @PostMapping
    public ResponseEntity save(@RequestBody ClienteSaveRequest request) {
        var cliente = request.toModel();
        service.save(cliente);
        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(cliente.getCpf())
                .toUri();
        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(params = "cpf")
    public ResponseEntity dadosCliente(@RequestParam("cpf") String cpf) {
        var cliente = service.getByCpf(cpf);
        if (cliente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }
}
//ServletUriComponentsBuilder objeto pra construrir urls dinamicas
// fromCurrentRequest() atraves da url corrente  exemplo localhost:Port:/clientes?cpf=12155
//query é quando vai passar parametros via url]
//builderandexpand ele vai buildar a url com o parametro recebido na query
