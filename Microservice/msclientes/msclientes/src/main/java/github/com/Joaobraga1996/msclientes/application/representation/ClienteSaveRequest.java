package github.com.Joaobraga1996.msclientes.application.representation;

import github.com.Joaobraga1996.msclientes.domain.Cliente;

public class ClienteSaveRequest {

    public ClienteSaveRequest(){}

    public ClienteSaveRequest(String cpf, String nome, Integer idade) {
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
    }

    private String cpf;
    private String nome;
    private Integer idade;

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public Cliente toModel(){
        return new Cliente(cpf, nome, idade);
    }
}
