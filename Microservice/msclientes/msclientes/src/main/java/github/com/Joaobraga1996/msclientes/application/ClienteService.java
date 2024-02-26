package github.com.Joaobraga1996.msclientes.application;

import github.com.Joaobraga1996.msclientes.domain.Cliente;
import github.com.Joaobraga1996.msclientes.infra.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository repository;

    public Cliente save(Cliente cliente){
        return repository.save(cliente);
    }

    public Optional<Cliente> getByCpf(String cpf){

        return repository.getByCpf(cpf);
    }

}
