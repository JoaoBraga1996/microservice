package github.com.JoaoBraga1996.msavaliadordecredito.ex;

public class DadosClienteNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;

	public DadosClienteNotFoundException() {
		super("Dados Clientes não encontrados para CPF informado");
	}

}
